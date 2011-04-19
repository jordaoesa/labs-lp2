package lp2.lab08;

import java.util.Collections;
import java.util.List;

/**
 * Uma disciplina avaliada a partir de Minitestes onde 25 porcento destes podem
 * ser faltados pelo aluno.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Minitestes extends Convencional {

	private int qtdMinitestesJaRealizados;

	/**
	 * Construtor da class Minitestes.
	 * 
	 * @param nome
	 *            O nome da Disciplina.
	 * @param qtdProvas
	 *            A quantidade de provas a serem realizadas na disciplina.
	 * @param posRequisitos
	 *            As disciplinas que tem como pre requisito a atual.
	 */
	public Minitestes(String nome, int qtdProvas, List<String> posRequisitos) {
		super(nome, qtdProvas, posRequisitos);
	}

	/**
	 * Retorna a quantidade de minitestes ja realizados ate entao.
	 * 
	 * @return A quantidade de minitestes ja realizados.
	 */
	public int getQtdMinitestesJaRealizados() {
		return qtdMinitestesJaRealizados;
	}

	/**
	 * Define uma nova quantidade de provas ja realizadas.
	 * 
	 * @param qtdMinitestesJaRealizados
	 *            A nova quantidade de provas a serem realizadas.
	 */
	@Override
	public void setQtdProvasJaRealizadas(int qtdMinitestesJaRealizados) {
		this.qtdMinitestesJaRealizados = qtdMinitestesJaRealizados;
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

		if (getNotas().size() == 0) {
			return 0.0;
		} else if (getNotas().size() == getQtdProvas()
				|| getNotas().size() >= (getQtdProvas() - naoConta)
				|| getNotas().size() == qtdMinitestesJaRealizados
				|| getNotas().size() >= qtdMinitestesJaRealizados - naoConta) {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
			return (soma / getNotas().size());
		} else {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
			return (soma / (qtdMinitestesJaRealizados - naoConta));
		}
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
				+ " minitestes, sem eliminar notas.";
		return mensagem;
	}

}
