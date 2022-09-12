package br.serratec.org.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private Double salarioBruto;
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
