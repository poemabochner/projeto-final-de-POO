package br.serratec.org.teste;

import java.io.FileNotFoundException;
import java.util.Scanner;

import br.serratec.org.model.Importador;

public class TestePessoa {

	public static void main(String[] args) throws FileNotFoundException {
		String arquivo;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o diretório do arquivo: ");
		arquivo = sc.next();
		
		Importador.importarArquivo(arquivo);
		
		System.out.println(arquivo);
		

	}

}
