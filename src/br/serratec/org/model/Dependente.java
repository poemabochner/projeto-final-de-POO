package br.serratec.org.model;

import java.time.LocalDate;
import java.util.Set;

import br.serratec.org.enuns.Parentesco;

public class Dependente extends Pessoa {
	private Parentesco parentesco;
	private Funcionario funcionario;

	

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco,
			Set<Funcionario> funcionarios) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {
		return "\nDependente: " + nome + "\nParentesco: " + parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	
	

}
