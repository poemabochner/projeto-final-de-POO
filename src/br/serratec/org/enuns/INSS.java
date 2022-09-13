package br.serratec.org.enuns;

public enum INSS {
	FAIXA1(0.0, 1212., 0.075, 0.), FAIXA2(1212.01, 2427.35, 0.09, 18.18), FAIXA3(2427.36, 3641.03, 0.12, 91.),
	FAIXA4(3641.04, 7087.22, 0.14, 163.82);

	Double valorInicialINSS;
	Double valorFinalINSS;
	Double aliquotaINSS;
	Double deducao;

	private INSS(Double valorInicial, Double valorFinal, Double aliquota, Double deducao) {
		this.valorInicialINSS = valorInicial;
		this.valorFinalINSS = valorFinal;
		this.aliquotaINSS = aliquota;
		this.deducao = deducao;
	}

	public Double getDeducao() {
		return deducao;
	}

	public Double getValorInicialINSS() {
		return valorInicialINSS;
	}

	public Double getValorFinalINSS() {
		return valorFinalINSS;
	}

	public Double getAliquotaINSS() {
		return aliquotaINSS;
	}
	
	

	
}
