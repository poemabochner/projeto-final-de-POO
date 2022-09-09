package br.serratec.org.enuns;

public enum IR {
	FAIXA1(0., 1903.98, 0., 0.), FAIXA2(1903.99, 2826.65, 0.075, 142.80), FAIXA3(2826.66, 3751.05, 0.15, 354.80),
	FAIXA4(3751.06, 4664.68, 0.225, 636.13), FAIXA5(4664.69, 999999.99, 0.275, 869.36);

	Double valorInicialIR;
	Double valorFinalIR;
	Double aliquotaIR;
	Double deducaoIR;
	final Double dependenteIR = 189.59;

	private IR(Double valorInicialIR, Double valorFinalIR, Double aliquotaIR, Double deducaoIR) {
		this.valorInicialIR = valorInicialIR;
		this.valorFinalIR = valorFinalIR;
		this.aliquotaIR = aliquotaIR;
		this.deducaoIR = deducaoIR;
	}

}
