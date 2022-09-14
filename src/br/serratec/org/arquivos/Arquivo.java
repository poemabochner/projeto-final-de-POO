package br.serratec.org.arquivos;

import br.serratec.org.exception.DependenteException;

public interface Arquivo {
	void importarArquivo(String arquivoEntrada) throws DependenteException;
	void gravarArquivo(String arquivoSaida);
}
