package fr.airpure.main.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.airpure.main.dto.response.UtilisateurConnexionDtoResponse;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.repositories.UtilisateurRepository;
import io.jsonwebtoken.Jwts;

/**
 * Gestion de la réponse HTTP en cas d'authentification à succès.
 */
@Configuration
public class JWTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationSuccessHandler.class);

	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	@Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			
		LOG.debug("Génération du token JWT");

		User user = (User) authentication.getPrincipal();

		String rolesList = user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.joining(","));
		System.out.println("USER " + user.getUsername());
		Utilisateur utilisateur = this.utilisateurRepo.findByEmail(user.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("L'email ne correspond à aucun collegue"));

		response.setContentType("application/json");
		response.getWriter().write(mapper.writeValueAsString(new UtilisateurConnexionDtoResponse(utilisateur)));

		Map<String, Object> infosSupplementaireToken = new HashMap<>();
		infosSupplementaireToken.put("roles", rolesList);
		LOG.info("roles {} ", infosSupplementaireToken);

		String jws = Jwts.builder().setSubject(user.getUsername()).addClaims(infosSupplementaireToken)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();

        Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));
        authCookie.setHttpOnly(true);
        authCookie.setMaxAge(EXPIRES_IN * 1000);
        authCookie.setPath("/");
        response.addCookie(authCookie);
        LOG.info("Token JWT généré posé dans un cookie et en entête HTTP");

//		ResponseCookie responseCookie = ResponseCookie.from(TOKEN_COOKIE, jws).httpOnly(true).maxAge(EXPIRES_IN * 1000)
//				.path("/").secure(true).sameSite("None").build();
//		response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
//		LOG.info("Token JWT généré posé dans un cookie et en entête HTTP");

	}
}
