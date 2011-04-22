package lp2.lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Um veiculo.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Carro extends Veiculo {

	private List<String> consertosPassados;
	private List<Verificacao> verificacoes;
	private final int QTD_PNEUS;
	private final int QTD_VERIFICACOES;
	private boolean pneus[];
	private Random rd;

	/**
	 * Instancia um objeto Carro com avarias de maneira randomica.
	 */
	public Carro() {
		consertosPassados = new ArrayList<String>();
		verificacoes = new ArrayList<Verificacao>();
		QTD_PNEUS = 4;
		QTD_VERIFICACOES = Verificacao.values().length;
		pneus = new boolean[QTD_PNEUS];
		rd = new Random();

		iniciaPneus();
		iniciaVerificacoes();
	}

	/**
	 * Metodo responsavel por retornar a lista de consertos por onde o Carro ja
	 * passou.
	 */
	@Override
	public List<String> consertosPassados() {
		return consertosPassados;
	}

	/**
	 * Metodo responsavel por retornar a lista de verificacoes pelas quais o
	 * Carro deve passar.
	 */
	@Override
	public List<Verificacao> verificacoes() {
		return verificacoes;
	}

	/**
	 * Metodo responsavel por adicionar uma nova verificacao a lista de
	 * verificacoes.
	 */
	@Override
	public void adicionaVerificacao(Verificacao verificacao) {
		verificacoes.add(verificacao);
	}

	/**
	 * Metodo responsavel por consertar uma avaria que o Carro apresenta. Esta
	 * avaria eh passada como parametro e se a lista de verificacoes do Carro
	 * contiver essa avaria, ela eh removida e adicionada na lista de consertos
	 * pasados.
	 */
	@Override
	public void consertar(Verificacao verificacao) {
		if (verificacoes.contains(verificacao)) {
			verificacoes.remove(verificacao);
		}
		consertosPassados.add(verificacao.toString());
	}

	/**
	 * Metodo responsavel por limpar o Carro.
	 */
	@Override
	public void limpar() {
		System.out.println("Limpando o carro ...");
	}

	/**
	 * Metodo responsavel por trocar os pneus avariados do Carro.
	 */
	@Override
	public int trocarPneus() {
		int qtdPneusAvariados = 0;
		for (int i = 0; i < QTD_PNEUS; i++) {
			if (pneus[i]) {
				pneus[i] = false;
				++qtdPneusAvariados;
			}
		}
		return qtdPneusAvariados;
	}

	/**
	 * Metodo responsavel por checar se um pneu esta avariado ou nao.
	 */
	@Override
	public boolean checaPneuAvariado(int i) {
		if (i >= QTD_PNEUS || i < 0 || !pneus[i]) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo responsavel por iniciar os pneus avariados do Carro.
	 */
	private void iniciaPneus() {
		Random rd = new Random();
		for (int i = 0; i < QTD_PNEUS; i++) {
			pneus[i] = rd.nextBoolean();
		}
	}

	/**
	 * Metodo responsavel por iniciar as avarias que o Carro apresenta e
	 * adicionalas na lista d verificacoes.
	 */
	private void iniciaVerificacoes() {
		for (int i = 0; i < QTD_VERIFICACOES; i++) {
			if (rd.nextBoolean()) {
				verificacoes.add(Verificacao.values()[i]);
			}
		}
	}

	/**
	 * Metodo responsavel por passar o aspirador no Carro.
	 */
	public void passarAspirador() {
		System.out.println("Passando o aspirador de po ...");
	}

	/**
	 * Metodo responsavel por colocar rodoes no carro. Eh necessario que o usuario escolha o tamanho do rodao.
	 */
	public void colocarRodao() {
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 4;
		final int CORRETOR = 1;
		int opcao;
		String tamanhos[] = { "14", "16", "18", "20" };

		System.out.println("Escolha o tamanho:");
		System.out.println("1 - Aro 14");
		System.out.println("2 - Aro 16");
		System.out.println("3 - Aro 18");
		System.out.println("4 - Aro 20");

		opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);
		System.out.println("Colocando rodao aro " + tamanhos[opcao - CORRETOR]
				+ " ...");
	}

	/**
	 * Metodo responsavel por pintar o Carro. Eh necessario que o usuario escolha a cor.
	 */
	public void pintar() {
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 5;
		final int CORRETOR = 1;
		int opcao;
		String cores[] = { "Preto", "Branco", "Cinza", "Vermelho", "Amarelo" };

		System.out.println("Escolha a cor:");
		System.out.println("1 - Preto");
		System.out.println("2 - Branco");
		System.out.println("3 - Cinza");
		System.out.println("4 - Vermelho");
		System.out.println("5 - Amarelo");

		opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);
		System.out.println("Pintando o carro de " + cores[opcao - CORRETOR]
				+ " ...");
	}

	/**
	 * Metodo responsavel por colocar neon no Carro.
	 */
	public void colocarNeon() {
		System.out.println("Colocando neon ...");
	}

	/**
	 * Metodo responsavel por receber inteiros entre os valores minValue e
	 * maxValue.
	 * 
	 * @param minValue
	 *            O valor minimo a ser recebido.
	 * @param maxValue
	 *            O valor maximo a ser recebido.
	 * @return O inteiro recebido.
	 */
	private static int recebeInteiro(int minValue, int maxValue) {
		int num = 0;
		do {
			try {
				System.out.print("> ");
				num = Integer.parseInt((new Scanner(System.in)).next());
			} catch (Exception e) {
				// pass
			}
		} while (num < minValue || num > maxValue);

		return num;
	}

}
