package fr.airpure.main.dto.request;

public class RegisterDtoRequest {
	private String nom;
	private String prenom;
	private String username;
	private String email;
	private String password;
	
	public RegisterDtoRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterDtoRequest(String nom, String prenom, String username, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
