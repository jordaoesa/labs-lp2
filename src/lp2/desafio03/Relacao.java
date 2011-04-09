package lp2.desafio03;

/**
 * Uma relacao entre dois alunos. A relacao contem um aluno devedor e um valor
 * de divida.
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
public class Relacao {
	private Aluno aluno = null;
	private float valor = 0;

	/**
	 * Instancia um objeto Relacao
	 * 
	 * @param aluno
	 *            O aluno devedor.
	 * @param valor
	 *            O valor da divida.
	 */
	public Relacao(Aluno aluno, float valor) {
		this.aluno = aluno;
		this.valor = valor;
	}

	/**
	 * Metodo acessor para aluno devedor.
	 * 
	 * @return O aluno devedor
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Metodo modificador para o aluno devedor.
	 * 
	 * @param aluno
	 *            O novo aluno devedor.
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * Metodo acessor para o valor da divida.
	 * 
	 * @return O valor da divida.
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Metodo modificador para o valor da divida.
	 * 
	 * @param valor
	 *            O novo valor da divida.
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

}
