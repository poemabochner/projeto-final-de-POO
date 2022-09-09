package br.serratec.org.enuns;

public enum Parentesco {
	FILHO("Filho"), SOBRINHO("Sobrinho"), OUTROS("Outros");
	
	String parentesco;

	private Parentesco(String parentesco) {
		this.parentesco = parentesco;
	}
}
