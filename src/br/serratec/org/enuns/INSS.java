package br.serratec.org.enuns;

public enum INSS {
	FAIXA1(0.0, 1212., 0.075), FAIXA2(1212.01, 2427.35, 0.09), FAIXA3(2427.36, 3641.03, 0.12),
	FAIXA4(3641.04, 7087.22, 0.14);

	Double valorInicialINSS;
	Double valorFinalINSS;
	Double aliquotaINSS;

	private INSS(Double valorInicial, Double valorFinal, Double aliquota) {
		this.valorInicialINSS = valorInicial;
		this.valorFinalINSS = valorFinal;
		this.aliquotaINSS = aliquota;
	}

	
}
