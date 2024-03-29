 package fr.airpure.main.security;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration Spring Security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	private JWTAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

	private JWTAuthorizationFilter jwtAuthorizationFilter;

	public WebSecurityConfig(JWTAuthenticationSuccessHandler jwtAuthenticationSuccessHandler,
			JWTAuthorizationFilter jwtAuthorizationFilter) {
		this.jwtAuthenticationSuccessHandler = jwtAuthenticationSuccessHandler;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	// Algorithme de hashage du mot de passe
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}


	/**
	 * Configuration de l'identité.
	 *
	 * @param ds
	 * @return
	 */
	// jpql trouver une autre solution avec jpa
	@Bean
	public UserDetailsService userDetailsService(DataSource ds) {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
		manager.setDataSource(ds);
		manager.setUsersByUsernameQuery("select email, mot_de_passe, 'true' from utilisateur where email=?");
		manager.setAuthoritiesByUsernameQuery(
				"select u.email, ru.role from utilisateur u, role_utilisateur ru where u.id=ru.utilisateur_id and u.email=?");
		return manager;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// désactivation CSRF
				.csrf()
					.disable()
					// support de requêtes Cross-Domain pour Spring Security
					// cette configuration permet d'utiliser les règles CORS de Spring MVC
					.cors()
				.and()
				// Suppression du cookie JSESSIONID
				// nous ne souhaitons pas de stockage d'état côté serveur

					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
					// en cas d'erreur, un code 403 est envoyé
					.exceptionHandling()
					.authenticationEntryPoint(
							(request, response, authException) -> response.setStatus(HttpServletResponse.SC_FORBIDDEN))
				.and()
					// toutes les requêtes doivent être authentifiées
					.authorizeRequests() // toutes les requêtes doivent être authentifiées
					.antMatchers("/accueil/**")
					.permitAll()
					.antMatchers("/station/**")
					.permitAll()
					.antMatchers("/notification/**")
					.permitAll()
					.antMatchers("/departement/**")
					.permitAll()
					.antMatchers("/favoris/**")
					.permitAll()
					// Pour tester mes requétes
					.antMatchers("/api/messages")
					.permitAll()
					
					//Test controller Commune
					.antMatchers("/commune/**")
					.permitAll()
					
					.antMatchers("/meteo/**")
					.permitAll()
								

					// Debut testes Echanges
					.antMatchers(HttpMethod.GET, "/accueil/**").permitAll()
					//.antMatchers(HttpMethod.GET, "/accueil/**").hasRole("ADMIN")
					//.antMatchers(HttpMethod.GET, "/accueil/rubriques").hasAuthority("2")
					//.antMatchers(HttpMethod.GET, "/accueil/rubriques").permitAll()


					//Fin teste Echanges
					
					// sample anonymous customization
					

					.anyRequest()
					.authenticated()

					
			
				.and()

				// génération d'un formulaire de login
				// il faut produire une requête avec les caractéristiques suivantes :
				// POST /login
				// 'Content-Type': 'application/x-www-form-urlencoded'
				// Deux paramètres : username et password
					.formLogin()
				// en cas de validation avec succès du formulaire
				// jwtAuthenticationSuccessHandler personnalise la réponse à envoyer
				// => la génération d'un jeton JWT
				// => la pause d'un cookie d'authentification
					.successHandler(jwtAuthenticationSuccessHandler)
				// en cas d'echec, code 400 envoyé
					.failureHandler(
						(request, response, exception) -> response.setStatus(HttpServletResponse.SC_BAD_REQUEST))

				// la requête POST /login n'est pas soumise à authentification
					.permitAll()
				.and()
					// Filtre permettant de récupérer le jeton JWT et transformer son contenu en
					// utilisateur connecté au sens Spring Security
					.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
					// Gestion de la déconnexion
					// /POST /logout
					.logout()
					// en cas de succès un OK est envoyé (à la place d'une redirection vers /login)
					.logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpServletResponse.SC_OK))
					// suppression du cookie d'authentification
					.deleteCookies(TOKEN_COOKIE);
		
		http.headers()
			.frameOptions()
			.sameOrigin();
		// Pour désactiver l'anonymous user
			//.and()
           //.anonymous().disable()
	}
}
