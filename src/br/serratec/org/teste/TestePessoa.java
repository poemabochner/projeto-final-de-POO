/**
 * @author Barbara Souza, Erick Viana, José Ailton Lopes, Leandro Ferraz, Paulo Petersen, Poema Bochner
 * @since 16/09/2022
 * @version 1.0
 */
package br.serratec.org.teste;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.serratec.org.arquivos.Importador;
import br.serratec.org.exception.DependenteException;
import br.serratec.org.model.Funcionario;
import br.serratec.org.model.Mensagem;

public class TestePessoa {
	// java -jar programa.jar
	public static void main(String[] args) throws DependenteException {
		ImageIcon icon = new ImageIcon("Imagem/dp.png");
		String arquivo;
		Importador importador = new Importador();
		Mensagem mensagem = new Mensagem();
		
		try {
			arquivo = JOptionPane.showInputDialog(
					"        TI GÓDX - Departamento Pessoal\n\n Informe o caminho onde está o arquivo:      ",
					"Arquivo/Funcionarios.txt");

			importador.importarArquivo(arquivo);
			

			mensagem.exibirMensagem("   Processando folha de pagamento, aguarde...  ");

			arquivo = JOptionPane.showInputDialog(
					"        TI GÓDX - Departamento Pessoal\n\n Informe o caminho para salvar o arquivo:      ",
					"Arquivo/FuncionariosSaida.txt");

			importador.gravarArquivo(arquivo);

			if (JOptionPane.showConfirmDialog(null, "Deseja abrir o arquivo?", "TI GÓDX - Departamento Pessoal",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				java.awt.Desktop.getDesktop().open(new File(arquivo));
			}
			mensagem.exibirMensagem("                              Encerrando ...");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu erro ao importar e processar o arquivo!",
					"TI GÓDX - Departamento Pessoal", JOptionPane.PLAIN_MESSAGE, icon);
		}
	}

}
