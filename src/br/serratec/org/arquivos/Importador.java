package br.serratec.org.arquivos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.serratec.org.enuns.Parentesco;
import br.serratec.org.model.Dependente;
import br.serratec.org.model.Funcionario;

public class Importador {
	Set<Funcionario> funcionarios = new HashSet<>();
	Set<Dependente> dependentes = new HashSet<>();

	public void importarArquivo(String arquivoEntrada) {
		File arquivo = new File(arquivoEntrada);

		try {
			Scanner sc = new Scanner(arquivo);

			// Ler funcionarios
			while (sc.hasNextLine()) {
				String funcionario = sc.nextLine();
				if (!funcionario.isEmpty()) {
					String vetor[] = funcionario.split(";");
					String data = vetor[2];
					LocalDate dataAjustada = LocalDate.parse(data);
					Double salarioBruto = Double.parseDouble(vetor[3]);
					funcionarios.add(new Funcionario(vetor[0], vetor[1], dataAjustada, salarioBruto));
					System.out.println(funcionario.toString());

					// Ler dependentes
					while (sc.hasNextLine()) {
						String dependente = sc.nextLine();
						if (!dependente.isBlank()) {
							Parentesco parentesco = Parentesco.OUTROS;
							dependentes.add(new Dependente(vetor[0], vetor[1], dataAjustada, parentesco, funcionarios));
							System.out.println(dependente.toString());
						} else {
							break;
						}
					}
				}
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("Ocorreu ao ler o arquivo.");
		}
	}

	public void gravarArquivo(String arquivoSaida) {
		try {
			// Gravar arquivo de saída
			PrintWriter gravacaoArquivo = new PrintWriter(arquivoSaida);
			for (Funcionario funcionario : funcionarios) {
				String linha = funcionario.getNome() + ";" + funcionario.getCpf() + ";" + funcionario.getDescontoINSS() + ";" + funcionario.getDescontoIR() + "\n";
				gravacaoArquivo.print(linha);
			}
				System.out.println("Arquivo gravado com sucesso");
				gravacaoArquivo.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao gravar o arquivo.");
		}
	}
}
