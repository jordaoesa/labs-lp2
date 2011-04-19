package lp2.lab08;

import java.util.ArrayList;
import java.util.List;

/**
 * Uma disciplina Convencional avaliada a partir de provas em que existe
 * reposicao de uma prova.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Convencional {

	private String nome;
	private int qtdProvas;
	private int qtdFaltas = 0;
	private int qtdProvasJaRealizadas;
	private List<String> posRequisitos = new ArrayList<String>();
	private List<Double> notas = new ArrayList<Double>();

	/**
	 * Contrutor da class Convencional.
	 * 
	 * @param nome
	 *            O nome da Disciplina.
	 * @param qtdProvas
	 *            A quantidade de provas a serem realizadas na disciplina.
	 * @param posRequisitos
	 *            As disciplinas que tem como pre requisito a atual.
	 */
	public Convencional(String nome, int qtdProvas, List<String> posRequisitos) {
		this.nome = nome;
		this.qtdProvas = qtdProvas;
		this.posRequisitos = posRequisitos;
	}

	/**
	 * Retorna a quantidade de provas ja realizadas ate o momento.
	 * 
	 * @return A quantidade de provas ja realizadas.
	 */
	public int getQtdProvasJaRealizadas() {
		return qtdProvasJaRealizadas;
	}

	/**
	 * Define uma nova quantidade de provas para as provas ja realizadas ate
	 * entao.
	 * 
	 * @param qtdProvasJaRealizadas
	 *            A nova quantidade de provas ja realizada.
	 */
	public void setQtdProvasJaRealizadas(int qtdProvasJaRealizadas) {
		this.qtdProvasJaRealizadas = qtdProvasJaRealizadas;
	}

	/**
	 * Retorna a quantidade de provas a serem feitas nesta disciplina.
	 * 
	 * @return A quantidade de provas a serem feitas.
	 */
	public int getQtdProvas() {
		return qtdProvas;
	}

	/**
	 * Define uma nova quantidade de provas a serem feitas.
	 * 
	 * @param qtdProvas
	 *            A nova quantidade de provas a ser feitas.
	 */
	public void setQtdProvas(int qtdProvas) {
		this.qtdProvas = qtdProvas;
	}

	/**
	 * Retorna o nome da Disciplina.
	 * 
	 * @return O nome da disciplina.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define um novo nome para a Disciplina.
	 * 
	 * @param nome
	 *            O novo nome a ser dado a Disciplina.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a lista com todas as notas da Disciplina.
	 * 
	 * @return A lista de notas da Disciplina.
	 */
	public List<Double> getNotas() {
		return notas;
	}

	/**
	 * Retorna a lista de pos-requisitos da Disciplina.
	 * 
	 * @return A lista de pos-requisitos.
	 */
	public List<String> getPosRequisitos() {
		return posRequisitos;
	}

	/**
	 * Retorna a quantidade de faltas da Disciplina.
	 * 
	 * @return A quantidade de faltas.
	 */
	public int getQtdFaltas() {
		return qtdFaltas;
	}

	/**
	 * Define uma nova quantidade de faltas para a disciplina.
	 * 
	 * @param qtdFaltas
	 *            A nova quantidade de faltas.
	 */
	public void setQtdFaltas(int qtdFaltas) {
		this.qtdFaltas = qtdFaltas;
	}

	/**
	 * Calcula a media aritmetica parcial da Disciplina.
	 * 
	 * @return A media parcial da Disciplina.
	 */
	public double getMediaAtual() {
		double soma = 0.0;
		if (getNotas().size() == 0) {
			return 0.0;
		} else if (getNotas().size() == getQtdProvas()
				|| getNotas().size() == qtdProvasJaRealizadas) {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
			return (soma / (getNotas().size()));
		} else {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
			return (soma / (qtdProvasJaRealizadas - 1));
		}
	}

	/**
	 * Adiciona notas na lista de notas da Disciplina.
	 * 
	 * @param nota
	 *            A nova nota a ser adicionada.
	 * @throws Exception
	 *             Retorna excecao caso seja adicionada uma nota invalida ou se
	 *             a lista de notas ja estiver lotada.
	 */
	public void adicionaNota(double nota) throws Exception {
		if (nota < 0.0 || nota > 10.0) {
			throw new Exception("Nota invalida.");
		}
		if (notas.size() == qtdProvas) {
			throw new Exception("Quantidade de provas atingida.");
		}
		notas.add(nota);
	}

	/**
	 * Adiciona uma nova falta e uma nota zero na lista de notas da Disciplina.
	 * 
	 * @throws Exception
	 *             Retorna excecao caso nao seja possivel adicionar esta nova
	 *             falta (ja tenha sido atingido o numeto limite de faltas).
	 */
	public void adicionaFalta() throws Exception {
		final int LIMITE_DE_FALTAS = 1;
		if (qtdFaltas == LIMITE_DE_FALTAS) {
			adicionaNota(0.0);
			throw new Exception("Numero de faltas excedido.");
		}
		++qtdFaltas;
	}

	/**
	 * Uma mensagem sobre a disciplina para facilitar o uso no metodo main da
	 * class Main.
	 * 
	 * @return A mensagem.
	 */
	public String getMensagem() {
		String mensagem = getNome() + " eh avaliada com " + getQtdProvas()
				+ " provas, sem eliminar notas.";
		return mensagem;
	}

}
