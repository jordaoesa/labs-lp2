package lp2.lab08;

import java.util.Collections;
import java.util.List;

/**
 * Uma disciplina avaliada a partir de Minitestes onde 25 porcento destes podem
 * ser faltados pelo aluno e existem tambem a eliminacao das notas mais baixas.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class MinitestesEliminandoBaixa extends Convencional {

	private int qtdMinitestesAEliminar;
	private int qtdMinitestesJaRealizados;

	/**
	 * Construtor da class MinitesteEliminandoBaixa.
	 * 
	 * @param nome
	 *            O nome da Disciplina.
	 * @param qtdProvas
	 *            A quantidade de provas a serem realizadas na disciplina.
	 * @param posRequisitos
	 *            As disciplinas que tem como pre requisito a atual.
	 * @param qtdMinitestesAEliminar
	 *            A quantidade de minitestes com nota baixa que vao ser
	 *            removidos para o calculo da media.
	 */
	public MinitestesEliminandoBaixa(String nome, int qtdProvas,
			List<String> posRequisitos, int qtdMinitestesAEliminar) {
		super(nome, qtdProvas, posRequisitos);
		this.qtdMinitestesAEliminar = qtdMinitestesAEliminar;
	}

	/**
	 * Retorna a quantidade de minitestes ja realizados.
	 * 
	 * @return A quantidade de minitstes ja realizados.
	 */
	public int getQtdMinitestesJaRealizados() {
		return qtdMinitestesJaRealizados;
	}

	/**
	 * Define uma nova quantidade de minitestes que vao ser realizadas.
	 * 
	 * @param qtdMinitestesJaRealizados
	 *            A nova quantidade de minitestes a serem realizados.
	 */
	@Override
	public void setQtdProvasJaRealizadas(int qtdMinitestesJaRealizados) {
		this.qtdMinitestesJaRealizados = qtdMinitestesJaRealizados;
	}

	/**
	 * Retorna a quantidade de minitstes a eliminar com notas baixas.
	 * 
	 * @return A quantidade de minitestes a eliminar.
	 */
	public int getQtdMinitestesAEliminar() {
		return qtdMinitestesAEliminar;
	}

	/**
	 * Define uma nova quantidade de minitestes a eliminar.
	 * 
	 * @param qtdMinitestesAEliminar
	 *            A nova quantidade de ninitestes.
	 */
	public void setQtdMinitestesAEliminar(int qtdMinitestesAEliminar) {
		this.qtdMinitestesAEliminar = qtdMinitestesAEliminar;
	}

	/**
	 * Retorna a media aritmetica parcial da Disciplina.
	 * 
	 * @return A media parcial da Disciplina.
	 */
	@Override
	public double getMediaAtual() {
		int naoConta = (int) (getQtdProvas() * (0.25));
		double soma = 0.0;
		Collections.sort(getNotas(), Collections.reverseOrder());

		if (getNotas().size() > qtdMinitestesAEliminar) {
			for (int i = 0; i < getNotas().size() - qtdMinitestesAEliminar; i++) {
				soma += getNotas().get(i);
			}
			return (soma / (getNotas().size() - qtdMinitestesAEliminar));
		}
		return 0.0;
	}

	/**
	 * Adiciona uma nova falta a Disciplina alem de zeros caso o limite de
	 * faltas seja excedido.
	 * 
	 * @throws Exception
	 *             Retorna excecao caso a quantidade de faltas passe do limite.
	 */
	@Override
	public void adicionaFalta() throws Exception {
		if (getQtdFaltas() == (int) (getQtdProvas() * (0.25))) {
			adicionaNota(0.0);
			throw new Exception("Numero de faltas excedido.");
		}
		setQtdFaltas(getQtdFaltas() + 1);
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
				+ " minitestes, eliminando " + getQtdMinitestesAEliminar()
				+ " dos mais baixos.";
		return mensagem;
	}
}
