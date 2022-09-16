package br.serratec.org.arquivos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import br.serratec.org.enuns.Parentesco;
import br.serratec.org.exception.DependenteException;
import br.serratec.org.model.Dependente;
import br.serratec.org.model.Funcionario;

public class Importador implements Arquivo {

	Set<Funcionario> funcionarios = new HashSet<>();

	public void importarArquivo(String arquivoEntrada) throws DependenteException {
		File arquivo = new File(arquivoEntrada);

		try {
			Scanner sc = new Scanner(arquivo);

			// Ler funcionarios
			while (sc.hasNextLine()) {
				String func = sc.nextLine();
				if (!func.isEmpty()) {
					String vetorFuncionario[] = func.split(";");
					String dataFuncionario = vetorFuncionario[2];
					LocalDate dataNascimentoFunc = LocalDate.parse(dataFuncionario);
					String salario = vetorFuncionario[3];
					Double salarioBruto = Double.parseDouble(salario);

					Funcionario funcionario = new Funcionario(vetorFuncionario[0], vetorFuncionario[1],
							dataNascimentoFunc, salarioBruto);
					// Ler dependentes
					while (sc.hasNextLine()) {
						String dependente = sc.nextLine();
						if (!dependente.isBlank()) {
							String vetorDependente[] = dependente.split(";");
							String dataDependente = vetorDependente[2];
							LocalDate dataNascimentoDependente = LocalDate.parse(dataDependente);
							String parentesco = vetorDependente[3];
							Integer idade = Period.between(dataNascimentoDependente, LocalDate.now()).getYears();

							try {
								if (idade < 18) {
									funcionario.getDependente()
											.add(new Dependente(vetorDependente[0], vetorDependente[1],
													dataNascimentoDependente, Parentesco.valueOf(parentesco),
													funcionarios));
								} else {
									throw new DependenteException();
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O dependente " + vetorDependente[0] + " não foi importado pois possui mais de 18 anos!");
							}

						} else {
							break;
						}

					}
					
					funcionarios.add(funcionario);
				}
			}
			sc.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao ler o arquivo :(");
		}
		JOptionPane.showMessageDialog(null, funcionarios);
	}

	public void gravarArquivo(String arquivoSaida) {
		try {
			// Gravar arquivo de saída
			PrintWriter gravacaoArquivo = new PrintWriter(arquivoSaida);
			String saida = null;
			
			for (Funcionario funcionario : funcionarios) {
				funcionario.calculoINSS();
				funcionario.calculoIR();
				String linha = String.format("%s;%s;%.2f;%.2f;%.2f;\n", funcionario.getNome(), funcionario.getCpf(),
						funcionario.getDescontoINSS(), funcionario.getDescontoIR(), funcionario.getSalarioLiquido());
				gravacaoArquivo.print(linha);
				
				saida = String.format("\nNome: %s \nCPF: %s \nDesconto INSS: %.2f \nDesconto IRRF: %.2f \nSalário líquido: %.2f\n\n", funcionario.getNome(), funcionario.getCpf(),
						funcionario.getDescontoINSS(), funcionario.getDescontoIR(), funcionario.getSalarioLiquido());

				JOptionPane.showMessageDialog(null, saida, "Recibo de pagamento", JOptionPane.PLAIN_MESSAGE);
			}
			gravacaoArquivo.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso :)");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gravar o arquivo :(");
		}
	}
}
