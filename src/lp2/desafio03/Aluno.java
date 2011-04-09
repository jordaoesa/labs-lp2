package lp2.desafio03;

import java.util.ArrayList;
import java.util.List;


/**
 * Um aluno que pode emprestar e pedir emprestado dinheiro.
 * 
 * 
 * @author jordaoesa
 * @author marceloax
 * @author felipebb <br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 *         Aluno: Marcelo Avelino Xavier<br>
 *         Matricula: 21115291<br>
 * <br>
 * 
 *         Aluno: Felipe Brasileiro Barbosa<br>
 *         Matricula: 21021067<br>
 * <br>
 * 
 */
public class Aluno {

	private String nome;
	private List<Relacao> relacoes = new ArrayList<Relacao>();

	/**
	 * Instancia um objeto Aluno.
	 * 
	 * @param nome
	 *            O nome do aluno.
	 */
	public Aluno(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo acessor para o nome do aluno.
	 * 
	 * @return O nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo modificador para o nome do aluno.
	 * 
	 * @param nome
	 *            O novo nome do aluno.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo acessor para a lista de relacoes.
	 * 
	 * @return A lista de relacoes.
	 */
	public List<Relacao> getRelacoes() {
		return relacoes;
	}

	/**
	 * Metodo responsavel por adicionar uma nova relacao e atualizar relacoes ja
	 * existentes na lista de relacoes.
	 * 
	 * @param relacao
	 */
	public void adicionaRelacao(Relacao relacao) {
		boolean verifica = true;
		for (int i = 0; i < relacoes.size(); i++) {
			if (relacoes.get(i).getAluno().getNome()
					.equals(relacao.getAluno().getNome())) {
				verifica = false;
				break;
			}
		}

		if (verifica) {
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
		verificaRemoveOrganiza();
	}

	/**
	 * Metodo responsavel por verificar relacoes em que o saldo entre os alunos
	 * ja foi zerado e remove-las assim como organizar a lista de relacoes por
	 * ordem de prioridade.
	 */
	private void verificaRemoveOrganiza() {

		// verifica relacoes encerradas e as remove
		for (int i = 0; i < relacoes.size(); i++) {
			if (relacoes.get(i).getValor() == 0.0) {
				relacoes.remove(relacoes.get(i));
			}
		}

		// Organiza a lista de relacoes para que as relacoes prioritarias sejam
		// computadas primeiro. Relacoes prioritarias sao relacoes entre alunos
		// mais proximos. Ex: a1, a2, a3 sao mais proximos que a1, a2, a4.
		for (int i = 0; i < relacoes.size(); i++) {
			for (int j = i + 1; j < relacoes.size(); j++) {
				if (relacoes.get(j).getAluno().getNome().charAt(1) < relacoes
						.get(i).getAluno().getNome().charAt(1)) {
					Relacao temp = relacoes.get(i);
					relacoes.set(i, relacoes.get(j));
					relacoes.set(j, temp);
				}
			}
		}
	}
}
