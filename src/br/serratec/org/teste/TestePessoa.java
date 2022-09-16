package br.serratec.org.teste;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
// javafx
import br.serratec.org.arquivos.Importador;
import br.serratec.org.exception.DependenteException;

public class TestePessoa {

	public static void main(String[] args) throws DependenteException {
		try {
			String arquivo;
			Importador importador = new Importador();

			arquivo = JOptionPane.showInputDialog(
					"        DEPARTAMENTO PESSOAL\n\n Informe o caminho onde está o arquivo:      ",
					"Arquivo/Funcionarios.txt");

			importador.importarArquivo(arquivo);

			
			arquivo = JOptionPane.showInputDialog(
					"        DEPARTAMENTO PESSOAL\n\n Informe o caminho para salvar o arquivo:      ",
					"Arquivo/FuncionariosSaida.txt");
			
			
			importador.gravarArquivo(arquivo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu erro ao importar e processar o arquivo!");
		}
	}

}
