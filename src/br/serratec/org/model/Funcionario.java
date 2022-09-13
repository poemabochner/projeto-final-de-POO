package br.serratec.org.model;

import java.time.LocalDate;

import br.serratec.org.enuns.INSS;
import br.serratec.org.enuns.IR;

public class Funcionario extends Pessoa {
	private Double salarioBruto = 0.;
	private Double salarioLiquido = 0.;
	private Double descontoINSS;
	private Double descontoIR;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalario bruto: " + salarioBruto + " INSS: " + descontoINSS + " IRRF: "
				+ descontoIR;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido = salarioBruto - descontoINSS - descontoIR;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public Double getDescontoINSS() {
		return descontoINSS;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void calculoINSS() {
		if (salarioBruto <= INSS.FAIXA1.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA1.getAliquotaINSS()) - INSS.FAIXA1.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA2.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA2.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA2.getAliquotaINSS()) - INSS.FAIXA2.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA3.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA3.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA3.getAliquotaINSS()) - INSS.FAIXA3.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA4.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA4.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA4.getAliquotaINSS()) - INSS.FAIXA4.getDeducao();
		} else {
			this.descontoINSS = (INSS.FAIXA4.getValorFinalINSS() * INSS.FAIXA4.getAliquotaINSS())
					- INSS.FAIXA4.getDeducao();
		}

	}

	public void calculoIR() {
		if (salarioBruto <= IR.FAIXA1.getValorFinalIR()) {
			this.descontoIR = 0.;
		} else if (salarioBruto >= IR.FAIXA2.getValorInicialIR() && salarioBruto <= IR.FAIXA2.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - IR.FAIXA2.getDependenteIR() - descontoINSS) * IR.FAIXA2.getAliquotaIR())
					- IR.FAIXA2.getDeducaoIR());
		} else if (salarioBruto >= IR.FAIXA3.getValorInicialIR() && salarioBruto <= IR.FAIXA3.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - IR.FAIXA3.getDependenteIR() - descontoINSS) * IR.FAIXA3.getAliquotaIR())
					- IR.FAIXA3.getDeducaoIR());
		} else if (salarioBruto >= IR.FAIXA4.getValorInicialIR() && salarioBruto <= IR.FAIXA4.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - IR.FAIXA4.getDependenteIR() - descontoINSS) * IR.FAIXA4.getAliquotaIR())
					- IR.FAIXA4.getDeducaoIR());
		} else {
			this.descontoIR = (((salarioBruto - IR.FAIXA5.getDependenteIR() - descontoINSS) * IR.FAIXA5.getAliquotaIR())
					- IR.FAIXA5.getDeducaoIR());
		}

	}

}
