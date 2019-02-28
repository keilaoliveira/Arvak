package br.com.arvak.domain.enums;

public enum SituacaoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int idPagamento;
	private String descricaoPagamento;
	
	private SituacaoPagamento(int idPagamento, String descricaoPagamento) {
		this.idPagamento = idPagamento;
		this.descricaoPagamento = descricaoPagamento;
	}
	
	public int getidPagamento() {
		return idPagamento;
	}
	
	public String getdescricaoPagamento() {
		return descricaoPagamento;
	}
	
	public static SituacaoPagamento toEnum(Integer idPagamento) {
		if (idPagamento == null) {
			return null;
		}
		
		for (SituacaoPagamento x : SituacaoPagamento.values()) {
			if (idPagamento.equals(x.getidPagamento())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de Pagamento Inválido: " + idPagamento);
	}
	
}
