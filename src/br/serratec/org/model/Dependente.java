package br.serratec.org.model;

import java.time.LocalDate;
import java.util.Set;

import br.serratec.org.enuns.Parentesco;

public class Dependente extends Pessoa {
	private Parentesco parentesco;
	

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	

	@Override
	public String toString() {
		return "\n Nome: " + nome + "\n CPF: " + cpf + "\n Nascimento: " + dataNascimento + "\n Parentesco: " + parentesco + "\n";
	}



	public Parentesco getParentesco() {
		return parentesco;
	}
	

}
