package lp2.lab04;

/**
 * Aluno: Jordao Ezequiel Serafim de Araujo 
 * Matricula: 21021526
 * 
 * @author jordaoesa
 */
public class ProgressaoAritmetica {

	int primeiro, razao, termoAtual = 0;

	/**
	 * Contrutor principal da class ProgressaoAritmetica.
	 * 
	 * @param primeiro
	 *            O primeiro termo da progressao aritmetica.
	 * @param razao
	 *            A razao da progressao aritmetica.
	 */
	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
	}

	/**
	 * Metodo responsavel pela impressao dos n primeiros termos de uma PA.
	 * 
	 * @param n
	 *            Eh o n-esimo termo da sequencia.
	 * @return O retorno eh uma grande string contendo todos os n termos da PA.
	 */
	public String imprime(int n) {
		this.termoAtual = n;
		String progressao = "[";

		if (n <= 0) {
			this.termoAtual = 1;
			progressao += this.primeiro;
			progressao += "]";
			return progressao;
		}

		for (int i = 1; i <= n; i++) {
			progressao += this.primeiro + (i - 1) * this.razao;
			progressao += ", ";
		}
		progressao = progressao.substring(0, progressao.length() - 2);
		progressao += "]";
		return progressao;
	}

	/**
	 * Metodo responsavel por "limpar a sequencia da PA atual" e retornar o
	 * primeiro termo da PA.
	 * 
	 * @return O primeiro termo da PA.
	 */
	public int primeiro() {
		this.termoAtual = 1;
		return this.primeiro;
	}

	/**
	 * Metodo responsavel por retornar o proximo termo da PA.
	 * 
	 * @return O proximo termo da PA.
	 */
	public int proximo() {
		int proximoValor;
		proximoValor = this.primeiro + ((this.termoAtual + 1) - 1) * this.razao;
		termoAtual++;
		return proximoValor;
	}

	/**
	 * Metodo responsavel por modificar o valor da progressao i-esimo termo da
	 * PA.
	 * 
	 * @param i
	 *            A posicao (comecando em 1) para o qual se deseja setar a
	 *            progressao.
	 * @return O i-esimo termo da progressao.
	 */
	public int termo(int i) {
		return (this.primeiro + (i - 1) * this.razao);
	}

}
