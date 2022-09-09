package br.serratec.org.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private Double salarioBruto;
	private Double descontoINSS;
	private Double descontoIR;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, Double descontoINSS,
			Double descontoIR) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoINSS = descontoINSS;
		this.descontoIR = descontoIR;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "\nSalario bruto: " + salarioBruto + "\nDesconto INSS: " + descontoINSS + "\nDesconto IRRF:" + descontoIR;
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

	
}
