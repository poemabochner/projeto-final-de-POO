package br.serratec.org.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import br.serratec.org.enuns.INSS;
import br.serratec.org.enuns.IR;
import br.serratec.org.exception.DependenteException;

public class Funcionario extends Pessoa {
	private Double salarioBruto = 0.;
	private Double salarioLiquido = 0.;
	private Double descontoINSS;
	private Double descontoIR;
	private List<Dependente> dependente = new ArrayList<>();

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
	}

	@Override
	public String toString() {
		return "\nFuncionario: \nNome: " + nome + "\nCPF: " + cpf + "\nNascimento: " + dataNascimento
				+ "\nSalário bruto: " + salarioBruto + "\nDependentes: " + dependente + "\n";
	}

	public Double getSalarioLiquido() {
		return salarioLiquido = salarioBruto - descontoINSS - descontoIR;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public List<Dependente> getDependente() {
		return dependente;
	}

	public Double getDescontoINSS() {
		return descontoINSS;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void calculoINSS() {
		if (salarioBruto <= INSS.FAIXA1.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA1.getAliquotaINSS()) - INSS.FAIXA1.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA2.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA2.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA2.getAliquotaINSS()) - INSS.FAIXA2.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA3.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA3.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA3.getAliquotaINSS()) - INSS.FAIXA3.getDeducao();
		} else if (salarioBruto >= INSS.FAIXA4.getValorInicialINSS()
				&& salarioBruto <= INSS.FAIXA4.getValorFinalINSS()) {
			this.descontoINSS = (salarioBruto * INSS.FAIXA4.getAliquotaINSS()) - INSS.FAIXA4.getDeducao();
		} else {
			this.descontoINSS = (INSS.FAIXA4.getValorFinalINSS() * INSS.FAIXA4.getAliquotaINSS())
					- INSS.FAIXA4.getDeducao();
		}

	}

	public void calculoIR() {
		if (salarioBruto <= IR.FAIXA1.getValorFinalIR()) {
			this.descontoIR = 0.;
		} else if (salarioBruto >= IR.FAIXA2.getValorInicialIR() && salarioBruto <= IR.FAIXA2.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - (dependente.size() * IR.FAIXA2.getDependenteIR()) - descontoINSS)
					* IR.FAIXA2.getAliquotaIR()) - IR.FAIXA2.getDeducaoIR());
		} else if (salarioBruto >= IR.FAIXA3.getValorInicialIR() && salarioBruto <= IR.FAIXA3.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - (dependente.size() * IR.FAIXA3.getDependenteIR()) - descontoINSS)
					* IR.FAIXA3.getAliquotaIR()) - IR.FAIXA3.getDeducaoIR());
		} else if (salarioBruto >= IR.FAIXA4.getValorInicialIR() && salarioBruto <= IR.FAIXA4.getValorFinalIR()) {
			this.descontoIR = (((salarioBruto - (dependente.size() * IR.FAIXA4.getDependenteIR()) - descontoINSS)
					* IR.FAIXA4.getAliquotaIR()) - IR.FAIXA4.getDeducaoIR());
		} else {
			this.descontoIR = (((salarioBruto - (dependente.size() * IR.FAIXA5.getDependenteIR()) - descontoINSS)
					* IR.FAIXA5.getAliquotaIR()) - IR.FAIXA5.getDeducaoIR());
		}

	}

	public void adicionarDependente(Dependente dependente) throws DependenteException {
		Integer idade = Period.between(dependente.getDataNascimento(), LocalDate.now()).getYears();
		if (idade < 18) {
			this.dependente.add(dependente);
		} else {
			throw new DependenteException();
		}
	}

}
