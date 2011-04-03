package lp2.desafio03;

import java.util.ArrayList;
import java.util.List;

/**
 * Um aluno.
 * 
 * @author felipebb
 * @author jordaoesa
 * @author marceloax
 * 
 */
public class Aluno {

	private String nome;
	private float saldoDevedor = 0;
	private float saldoCredor = 0;
	private List<Relacao> relacoes = new ArrayList<Relacao>();

	/**
	 * 
	 * @param nome
	 */
	public Aluno(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public float getSaldoDevedor() {
		return saldoDevedor;
	}

	/**
	 * 
	 * @param saldoDevedor
	 */
	public void setSaldoDevedor(float saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	/**
	 * 
	 * @return
	 */
	public float getSaldoCredor() {
		return saldoCredor;
	}

	/**
	 * 
	 * @param saldoCredor
	 */
	public void setSaldoCredor(float saldoCredor) {
		this.saldoCredor = saldoCredor;
	}

	/**
	 * 
	 */
	public List<Relacao> getRelacoes() {
		return relacoes;
	}

	/**
	 * 
	 * @param relacao
	 */
	public void adicionaRelacao(Relacao relacao) {
		boolean verifica = true;
		for(int i=0; i<relacoes.size(); i++){
			if(relacoes.get(i).getAluno().getNome().equals(relacao.getAluno().getNome())){
				verifica = false;
				break;
			}
		}
		
		if(verifica){
			this.relacoes.add(relacao);
		} else {
			for (int i = 0; i < relacoes.size(); i++) {
				if (relacoes.get(i).getAluno().equals(relacao.getAluno())) {
					relacoes.get(i).setValor(
							relacoes.get(i).getValor() + relacao.getValor());
					break;
				}
			}
		}
		
		// verifica relacoes encerradas e as remove
		for(int i=0; i<relacoes.size(); i++){
			if(relacoes.get(i).getValor() == 0.0){
				relacoes.remove(relacoes.get(i));
			}
		}
		
	}

//	/**
//	 * 
//	 * @param nomeAluno
//	 */
//	public void verificaSaldo(String nomeAluno) {
//		String nomeTemp = "";
//		float saldoTemp = 0;
//		for (int i = 0; i < relacoes.size(); i++) {
//			if (relacoes.get(i).getAluno().getNome().equals(nomeAluno)) {
//				nomeTemp = relacoes.get(i).getAluno().getNome();
//				saldoTemp = relacoes.get(i).getValor();
//			}
//		}
//		System.out.println("Aluno " + nomeTemp + " deve ao aluno "
//				+ this.getNome() + ": " + saldoTemp);
//	}

}
