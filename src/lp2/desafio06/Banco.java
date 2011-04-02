package lp2.desafio06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Um Banco.
 * 
 * @author felipebb
 * @author jordaoesa
 * @author marceloax
 * 
 */
public class Banco {

	private Aluno alunos[];
	private String nomeCredor;
	private String nomeDevedor;
	private String nomePagador;
	private String nomeBeneficiario;
	private float valorPagamento;
	private float valorEmprestimo;
	List<String[]> relacoes = new ArrayList<String[]>();

	/**
	 * 
	 * @param qtdAlunos
	 */
	public Banco(int qtdAlunos) {
		alunos = new Aluno[qtdAlunos];
		for (int i = 0; i < qtdAlunos; i++) {
			alunos[i] = new Aluno("a" + (i + 1));
		}
	}

	/**
	 * 
	 * @return
	 */
	public Aluno[] getAlunos() {
		return alunos;
	}

	/**
	 * 
	 * @param alunos
	 */
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	/**
	 * 
	 * @param nomeCredor
	 * @param nomeDevedor
	 * @param valorEmprestimo
	 */
	public void novoEmprestimo(String nomeCredor, String nomeDevedor,
			float valorEmprestimo) {
		// for(int i=0; i<alunos.length; i++){
		// if(alunos[i].getNome().equals(nomeDevedor)){
		// this.nomeDevedor = nomeDevedor;
		// }
		// if(alunos[i].getNome().equals(nomeCredor)){
		// this.nomeCredor = nomeCredor;
		// }
		// }

		// this.nomeDevedor = nomeDevedor;
		// this.nomeCredor = nomeCredor;
		// this.valorEmprestimo = valorEmprestimo;
		String relacao[] = { nomeCredor, nomeDevedor,
				String.valueOf(valorEmprestimo) };
		relacoes.add(relacao);
	}

	/**
	 * 
	 * @param nomePagador
	 * @param nomeBeneficiario
	 * @param valorPagamento
	 */
	public void novoPagamento(String nomePagador, String nomeBeneficiario,
			float valorPagamento) {
		this.nomePagador = nomePagador;
		this.nomeBeneficiario = nomeBeneficiario;
		this.valorPagamento = valorPagamento;
	}

	public String imprimeRelacoes() {
		String impressao = "";
		Iterator<String[]> i = relacoes.iterator();
		while (i.hasNext()) {
			String teste[] = i.next();
			for (int j = 0; j < teste.length; j++) {
				impressao += teste[j] + ", ";
			}
		}
		return impressao;
	}

}
