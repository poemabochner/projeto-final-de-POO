package br.serratec.org.exception;

public class DependenteException extends Exception {
//Todo dependente tem que ser menor que 18 anos
//Não pode existir dependentes com o mesmo CPF

	public DependenteException() {
		System.out.println("Dependente maior de 18 anos!");
	}
}
