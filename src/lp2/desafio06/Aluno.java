package lp2.desafio06;

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
	public double getSaldoDevedor() {
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
	public double getSaldoCredor() {
		return saldoCredor;
	}

	/**
	 * 
	 * @param saldoCredor
	 */
	public void setSaldoCredor(float saldoCredor) {
		this.saldoCredor = saldoCredor;
	}

}
