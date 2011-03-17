package lp2.lab05;

/* 
 * Aluno: Jordao Ezequiel Serafim de Araujo 
 * Matricula: 21021526
 * 
 */

/**
 * Uma Progressao Geometrica
 * 
 * @author jordaoesa
 * 
 */
public class ProgressaoGeometrica {

	int primeiro, razao, termoAtual = 0;

	/**
	 * @param primeiro
	 *            O primeiro termo da PG.
	 * @param razao
	 *            A razao da PG.
	 */
	public ProgressaoGeometrica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
	}

	/**
	 * Metodo responsavel pela impressao dos n primeiros termos de uma PG.
	 * 
	 * @param n
	 *            Eh o n-esimo termo da sequencia.
	 * @throws Exception
	 *             Excecao retornada caso sejam passados valores menores ou
	 *             iguais a zero.
	 * @return O retorno eh uma grande string contendo todos os n termos da PG.
	 */
	public String imprime(int n) throws Exception {
		String progressao = "[";

		if (n <= 0) {
			throw new Exception(
					"Numero invalido. Digite valores maiores que zero.");
		}

		for (int i = 1; i <= n; i++) {
			progressao += String.valueOf((int) (this.primeiro * (Math.pow(
					this.razao, (i - 1)))));
			progressao += ", ";
		}
		progressao = progressao.substring(0, progressao.length() - 2);
		progressao += "]";
		return progressao;
	}

	/**
	 * Metodo responsavel por "limpar a sequencia da PG atual" e retornar o
	 * primeiro termo da PG.
	 * 
	 * @return O primeiro termo da PG.
	 */
	public int primeiro() {
		this.termoAtual = 1;
		return this.primeiro;
	}

	/**
	 * Metodo responsavel por retornar o proximo termo da PG.
	 * 
	 * @return O proximo termo da PG.
	 */
	public int proximo() {
		int proximoValor;
		proximoValor = (int) (this.primeiro * (Math.pow(this.razao,
				((this.termoAtual + 1) - 1))));
		termoAtual++;
		return proximoValor;
	}

	/**
	 * Metodo responsavel por modificar o valor da PG para o i-esimo termo.
	 * 
	 * @param i
	 *            A posicao (comecando em 1) para o qual se deseja setar a
	 *            progressao.
	 * @throws Exception
	 *             Excecao retornada caso sejam passados valores menores ou
	 *             iguais a zero.
	 * @return O i-esimo termo da progressao.
	 */
	public int termo(int i) throws Exception {

		if (i <= 0) {
			throw new Exception(
					"Numero invalido. Digite valores maiores que zero.");
		}

		termoAtual = (int) (this.primeiro * (Math.pow(this.razao, (i - 1))));
		return termoAtual;
	}

}
