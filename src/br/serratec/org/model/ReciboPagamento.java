package br.serratec.org.model;

import br.serratec.org.enuns.INSS;

public class ReciboPagamento implements Calculos {
	
	@Override
	public Double calculoINSS(Double salarioBruto) {
		 
		 if (Funcionario.getSalarioBruto() >= INSS.FAIXA1.getValorFinalINSS()) {
			  return Funcionario.getSalarioBruto() * INSS.FAIXA1.getAliquotaINSS();
		 }
		return 0.;
		 
		 // Seguir desse ponto
	}



	@Override
	public void calculoIR(Double salarioBruto) {
		// TODO Auto-generated method stub
		
	}




}
