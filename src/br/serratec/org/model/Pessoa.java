package br.serratec.org.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	
	
	@Override
	public String toString() {
		return "\nNome: " + nome + "\nCPF: " + cpf + "\nNascimento: " + dataNascimento;
	}



	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	

}
