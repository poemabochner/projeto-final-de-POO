package br.serratec.org.teste;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import br.serratec.org.arquivos.Importador;
import br.serratec.org.exception.DependenteException;

public class TestePessoa {

	public static void main(String[] args) throws DependenteException {
		String arquivo;
		Scanner sc = new Scanner(System.in);
		Importador importador = new Importador();
		
		System.out.println("::::::::::::::::::: DEPARTAMENTO PESSOAL :::::::::::::::::::");
		System.out.print("\nInforme o caminho completo do arquivo a ser importado: ");
		arquivo = sc.next();

		
		importador.importarArquivo(arquivo);
		
		
		System.out.print("\nInforme o diretório completo do arquivo a ser exportado: ");
		arquivo = sc.next();
		System.out.println("");
		importador.gravarArquivo(arquivo);

		sc.close();
	}

}
