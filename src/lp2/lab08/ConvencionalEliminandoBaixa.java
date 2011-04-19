package lp2.lab08;

import java.util.Collections;
import java.util.List;

/**
 * Uma disciplina Convencional avaliada a partir de provas em que nao existe
 * reposicao de provas mas existe a eliminacao das notas mais baixas.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class ConvencionalEliminandoBaixa extends Convencional {

	private int qtdProvasAEliminar;
	private int qtdProvasJaRealizadas;

	/**
	 * Construtor da class ConvencionalEliminandoBaixa.
	 * 
	 * @param nome
	 *            O nome da Disciplina.
	 * @param qtdProvas
	 *            A quantidade de provas a serem realizadas na disciplina.
	 * @param posRequisitos
	 *            As disciplinas que tem como pre requisito a atual.
	 * @param qtdProvasAEliminar
	 *            A quantidade de provas com nota baixa que vao ser removidas
	 *            para o calculo da media.
	 */
	public ConvencionalEliminandoBaixa(String nome, int qtdProvas,
			List<String> posRequisitos, int qtdProvasAEliminar) {
		super(nome, qtdProvas, posRequisitos);
		this.qtdProvasAEliminar = qtdProvasAEliminar;
	}

	/**
	 * Retorna a quantidade de provas ja realizadas.
	 * 
	 * @return A quantidade de provas ja realizadas.
	 */
	public int getQtdProvasJaRealizadas() {
		return qtdProvasJaRealizadas;
	}

	/**
	 * Define uma nova quantidade de provas ja realizadas.
	 * 
	 * @param qtdProvasJaRealizadas
	 *            A nova quantidade de provas ja realizadas.
	 */
	@Override
	public void setQtdProvasJaRealizadas(int qtdProvasJaRealizadas) {
		this.qtdProvasJaRealizadas = qtdProvasJaRealizadas;
	}

	/**
	 * Retorna a quantidade de provas com notas baixas a eliminar.
	 * 
	 * @return A quantidade de provas a eliminar.
	 */
	public int getQtdProvasAEliminar() {
		return qtdProvasAEliminar;
	}

	/**
	 * Define uma nova quantidade de provas com notas baixas a eliminar.
	 * 
	 * @param qtdProvasAEliminar
	 *            A nova quantidade de provas a eliminar.
	 */
	public void setQtdProvasAEliminar(int qtdProvasAEliminar) {
		this.qtdProvasAEliminar = qtdProvasAEliminar;
	}

	/**
	 * Retorna a media aritmetica parcial da Disciplina
	 * 
	 * @return a media parcial da disciplina.
	 */
	@Override
	public double getMediaAtual() {
		double soma = 0.0;
		Collections.sort(getNotas(), Collections.reverseOrder());

		if (getNotas().size() == 0) {
			return 0.0;
		} else if (getNotas().size() == getQtdProvas()
				|| getNotas().size() == qtdProvasJaRealizadas) {
			for (int i = 0; i < getNotas().size() - qtdProvasAEliminar; i++) {
				soma += getNotas().get(i);
			}
		} else if (getNotas().size() <= qtdProvasJaRealizadas
				- qtdProvasAEliminar) {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
		} else if (getNotas().size() > qtdProvasJaRealizadas
				- qtdProvasAEliminar
				&& getNotas().size() < qtdProvasJaRealizadas) {
			for (int i = 0; i < qtdProvasJaRealizadas - qtdProvasAEliminar; i++) {
				soma += getNotas().get(i);
			}
		}
		return (soma / (qtdProvasJaRealizadas - qtdProvasAEliminar));
	}

	/**
	 * Adiciona uma nova falta a Disciplina alem de zeros caso o limite de
	 * faltas seja excedido.
	 * 
	 * @throws Exception
	 *             Retorna excecao caso a quantidade de faltas passe do limite
	 */
	@Override
	public void adicionaFalta() throws Exception {
		final int LIMITE_DE_FALTAS = 0;
		if (getQtdFaltas() == LIMITE_DE_FALTAS) {
			adicionaNota(0.0);
			throw new Exception("Numero de faltas excedido.");
		}
		setQtdFaltas(getQtdFaltas() + 1); // Nunca eh usado, pois o limite de
											// faltas nesta disciplina eh zero.
	}

	/**
	 * Uma mensagem sobre a disciplina para facilitar o uso no metodo main da
	 * class Main.
	 * 
	 * @return A mensagem.
	 */
	@Override
	public String getMensagem() {
		String mensagem = getNome() + " eh avaliada com " + getQtdProvas()
				+ " provas, eliminando " + getQtdProvasAEliminar()
				+ " das mais baixas.";
		return mensagem;
	}

}
