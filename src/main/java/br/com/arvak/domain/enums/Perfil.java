package br.com.arvak.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int idPerfil;
	private String descricaoPerfil;
	
	private Perfil(int idPerfil, String descricaoPerfil) {
		this.idPerfil = idPerfil;
		this.descricaoPerfil = descricaoPerfil;
	}
	
	public int getidPerfil() {
		return idPerfil;
	}
	
	public String getdescricaoPerfil() {
		return descricaoPerfil;
	}
	
	public static Perfil toEnum(Integer idPerfil) {
		if (idPerfil == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (idPerfil.equals(x.getidPerfil())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido: " + idPerfil);
	}
	
}
