package lp2.desafio03;

/**
 * O aluno passado no construtor de Relacao() deve a quantia tambem passada como
 * parametro para o outro aluno.
 * 
 * @author jordaoesa
 * 
 */
public class Relacao {
	private Aluno aluno = null;
	private float valor = 0;

	/**
	 * 
	 * @param aluno
	 * @param valor
	 */
	public Relacao(Aluno aluno, float valor) {
		this.aluno = aluno;
		this.valor = valor;
	}

	/**
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * 
	 * @param aluno
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * 
	 * @return
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * 
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

}
