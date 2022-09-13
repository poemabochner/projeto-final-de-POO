package br.serratec.org.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private static Double salarioBruto = 0.;
	private Double descontoINSS;
	private Double descontoIR;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalario bruto: " + salarioBruto;
	}

	public static Double getSalarioBruto() {
		return salarioBruto;
	}

	public Double getDescontoINSS() {
		return descontoINSS;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoINSS(Double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}

	public void setDescontoIR(Double descontoIR) {
		this.descontoIR = descontoIR;
	}

}
