package br.com.arvak.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int idTipoCliente;
	private String descricaoTipoCliente;
	
	private TipoCliente(int idTipoCliente, String descricaoTipoCliente) {
		this.idTipoCliente = idTipoCliente;
		this.descricaoTipoCliente = descricaoTipoCliente;
	}
	
	public int getidTipoCliente() {
		return idTipoCliente;
	}
	
	public String getdescricaoTipoCliente() {
		return descricaoTipoCliente;
	}
	
	public static TipoCliente toEnum(Integer idTipoCliente) {
		if (idTipoCliente == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (idTipoCliente.equals(x.getidTipoCliente())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de Cliente Inválido: " + idTipoCliente);
	}
	
}
