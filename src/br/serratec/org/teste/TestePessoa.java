package br.serratec.org.teste;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import br.serratec.org.arquivos.Importador;
import br.serratec.org.exception.DependenteException;

public class TestePessoa {
	
	public static void main(String[] args) throws DependenteException {
		ImageIcon icon = new ImageIcon("img/dp.png");
		try {
			String arquivo;
			Importador importador = new Importador();

			arquivo = JOptionPane.showInputDialog(
					"        TI GÓDX - Departamento Pessoal\n\n Informe o caminho onde está o arquivo:      ",
					"Arquivo/Funcionarios.txt");

			importador.importarArquivo(arquivo);


			arquivo = JOptionPane.showInputDialog(
					"        TI GÓDX - Departamento Pessoal\n\n Informe o caminho para salvar o arquivo:      ",
					"Arquivo/FuncionariosSaida.txt");

			importador.gravarArquivo(arquivo);
			
			
			if (JOptionPane.showConfirmDialog(null, "   TI GÓDX - Departamento Pessoal\n\n Deseja abrir o arquivo?", "Arquivo",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					java.awt.Desktop.getDesktop().open(new File(arquivo)); 
			}
			JOptionPane.showMessageDialog(null, "Volte sempre!", "TI GÓDX - Departamento Pessoal", JOptionPane.PLAIN_MESSAGE, icon);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu erro ao importar e processar o arquivo!", "TI GÓDX - Departamento Pessoal", JOptionPane.PLAIN_MESSAGE, icon);
		}
	}

}
