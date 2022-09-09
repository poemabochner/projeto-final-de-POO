package br.serratec.org.model;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Importador {
	private String arquivo;
	
	
	public Importador(String arquivo) {
		super();
		this.arquivo = arquivo;
	}


	public static void importarArquivo(String arquivo) throws FileNotFoundException {
		FileReader file = new FileReader(arquivo);
	}
}
