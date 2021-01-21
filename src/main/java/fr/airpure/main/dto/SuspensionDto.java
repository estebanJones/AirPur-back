package fr.airpure.main.dto;
/*
 * Dto à l'image d'une suspension coté Front
 */
public class SuspensionDto {
	private Boolean definitif;
	private Boolean temporaire;
	private Integer userAdminId;
	private Integer userSuspenduId;

	public SuspensionDto(Boolean definitif, Boolean temporaire, Integer userAdminId, Integer userSuspenduId) {
		super();
		this.definitif = definitif;
		this.temporaire = temporaire;
		this.userAdminId = userAdminId;
		this.userSuspenduId = userSuspenduId;
	}

	public Boolean getDefinitif() {
		return definitif;
	}

	public void setDefinitif(Boolean definitif) {
		this.definitif = definitif;
	}

	public Boolean getTemporaire() {
		return temporaire;
	}

	public void setTemporaire(Boolean temporaire) {
		this.temporaire = temporaire;
	}

	public Integer getUserAdminId() {
		return userAdminId;
	}

	public void setUserAdminId(Integer userAdminId) {
		this.userAdminId = userAdminId;
	}

	public Integer getUserSuspenduId() {
		return userSuspenduId;
	}

	public void setUserSuspenduId(Integer userSuspenduId) {
		this.userSuspenduId = userSuspenduId;
	}

}
