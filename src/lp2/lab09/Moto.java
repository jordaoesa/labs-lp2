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
public class Moto extends Veiculo {

	private List<String> consertosPassados;
	private List<Verificacao> verificacoes;
	private final int QTD_PNEUS;
	private final int QTD_VERIFICACOES;
	private boolean pneus[];
	private Random rd;

	/**
	 * Instancia um objeto Moto com avarias de maneira randomica.
	 */
	public Moto() {
		consertosPassados = new ArrayList<String>();
		verificacoes = new ArrayList<Verificacao>();
		QTD_PNEUS = 2;
		QTD_VERIFICACOES = Verificacao.values().length;
		pneus = new boolean[QTD_PNEUS];
		rd = new Random();

		iniciaPneus();
		iniciaVerificacoes();
	}

	/**
	 * Metodo responsavel por retornar a lista de consertos por onde a Moto ja
	 * passou.
	 */
	@Override
	public List<String> consertosPassados() {
		return consertosPassados;
	}

	/**
	 * Metodo responsavel por retornar a lista de verificacoes pelas quais a
	 * Moto deve passar.
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
	 * Metodo responsavel por consertar uma avaria que a moto apresenta. Esta
	 * avaria eh passada como parametro e se a lista de verificacoes da moto
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
	 * Metodo responsavel por limpar a Moto.
	 */
	@Override
	public void limpar() {
		System.out.println("Lavando a Moto ...");
	}

	/**
	 * Metodo responsavel por trocar os pneus avariados da Moto.
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
	 * Metodo responsavel por iniciar os pneus avariados da Moto.
	 */
	private void iniciaPneus() {
		Random rd = new Random();
		for (int i = 0; i < QTD_PNEUS; i++) {
			pneus[i] = rd.nextBoolean();
		}
	}

	/**
	 * Metodo responsavel por iniciar as avarias que a Moto apresenta e
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
	 * Metodo responsavel por comprar luvas para a "Moto" (motoqueiro).
	 */
	public void comprarLuvas() {
		System.out.println("Comprando luvas ...");
	}

	/**
	 * Metodo responsavl por comprar capacete para a "Moto" (motoqueiro);
	 */
	public void comprarCapacete() {
		System.out.println("Comprando capacete ...");
	}

	/**
	 * Metodo responsavel por colocar retrovisores na Moto.
	 */
	public void colocarRetrovisores() {
		System.out.println("Colocando retrovisores ...");
	}

	/**
	 * Metodo responsavel por pintar a Moto. Eh necessario que o usuario escolha
	 * a cor que deseja pintar.
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
		System.out.println("Pintando a moto de " + cores[opcao - CORRETOR]
				+ " ...");
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
