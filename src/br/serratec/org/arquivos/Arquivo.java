package br.serratec.org.arquivos;

import java.util.List;

import br.serratec.org.exception.DependenteException;
import br.serratec.org.model.Funcionario;

public interface Arquivo {
	String importarArquivo(String arquivoEntrada) throws DependenteException;
	void gravarArquivo(String arquivoSaida);
}
