package br.serratec.org.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.serratec.org.arquivos.Importador;
import br.serratec.org.model.Funcionario;
import br.serratec.org.model.ReciboPagamento;

public class TestePessoa {

	public static void main(String[] args) {
		String arquivo;
		Scanner sc = new Scanner(System.in);
		Importador importador = new Importador();
		
		
		System.out.println("::::::::::::::::::: DEPARTAMENTO PESSOAL :::::::::::::::::::");
		System.out.print("\nInforme o caminho completo do arquivo a ser importado: ");
		arquivo = sc.next();
		importador.importarArquivo(arquivo);

		
		System.out.print("\nInforme o diretório completo do arquivo a ser exportado: ");
		arquivo = sc.next();
		importador.gravarArquivo(arquivo);
		sc.close();
	}

}
