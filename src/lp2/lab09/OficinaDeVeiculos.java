package lp2.lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Uma Oficina responsavel por receber veiculos e fazer operacoes de conserto
 * sobre os mesmos.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 *         Respostas as questoes presentes no lab: <br>
 *         1) Estao comentados todos os lugares onde ha chamadas polimorficas.<br>
 *         2) Uma maneira de diminuir a repeticao de codigo seria a
 *         implementacao, ja na classe abstrata Veiculo, dos metodos
 *         consertosPassados(), verificacoes(), adicionaVerificacao() e
 *         consertar(), ja que todos tem a mesma implmentacao independente do
 *         veiculo. O metodo limpar() poderia receber como parametro um String
 *         indicando o nome do veiculo que seria impresso (moto ou carro). Os
 *         metodos trocarPneus() e checaPneuAvariado() poderiam receber como
 *         parametro a quantidade de pneus que o veiculo possui e isso tambem os
 *         tornaria metodos mais "flexiveis". Dessa maneira o reuso de codigo
 *         seria bem maior.<br>
 * <br>
 */
public class OficinaDeVeiculos {

	private static List<Veiculo> veiculosASeremVerificados;
	private int index;

	/**
	 * Instancia uma OficinaDeVeiculos responsavel por fazer operacoes sobre
	 * veiculos como Carro e Moto.
	 */
	public OficinaDeVeiculos() {
		veiculosASeremVerificados = new ArrayList<Veiculo>();
		index = 0;
	}

	/**
	 * Metodo responsavel por receber um objeto Veiculo para a Oficina.
	 * 
	 * @param obj
	 *            O Veiculo a ser recebido.
	 */
	public void recebeVeiculo(Object obj) {
		if (obj instanceof Veiculo) {
			Veiculo veiculo = (Veiculo) obj;
			veiculosASeremVerificados.add(veiculo);
			if (veiculo instanceof Carro)
				System.out.println("Carro entrando na Oficina ...");
			else if (veiculo instanceof Moto)
				System.out.println("Moto entrando na Oficina ...");
		}
	}

	/**
	 * Metodo responsavel por determinar qual o proximo Veiculo a ser consertado
	 * na oficina.
	 * 
	 * @return O proximo Veiculo a ser consertado.
	 */
	public Veiculo proximo() {
		if (index < veiculosASeremVerificados.size()) {
			Veiculo prox = veiculosASeremVerificados.get(index);
			index++;
			return prox;
		}
		return null;
	}

	/**
	 * Metodo responsavel por entregar um Veiculo caso este ja esteja
	 * consertado.
	 * 
	 * @param obj
	 *            O Veiculo a ser entregue
	 * @return O Veiculo a ser entregue.
	 */
	public Veiculo entrega(Object obj) {
		if (obj instanceof Veiculo) {
			Veiculo veiculo = (Veiculo) obj;
			// veiculo.verificacoes().size() >>> Polimorfismo
			if (veiculo.verificacoes().size() == 0) {
				veiculosASeremVerificados.remove(0);
				index--;
				if (veiculo instanceof Carro)
					System.out.println("Carro saindo da oficina ...");
				else if (veiculo instanceof Moto)
					System.out.println("Moto saindo da oficina ...");
				return veiculo;
			}
		}
		System.out.println("Nao ha veiculos prontos para entrega.");
		return null;
	}

	/**
	 * Metodo responsavel por fazer a manutencao geral do Veiculo. Este metodo
	 * verifica quais avarias o Veiculo apresenta e as conserta.
	 */
	public void manutencao() {
		Veiculo veiculo = proximo();
		if (veiculo != null) {
			List<Verificacao> copia = new ArrayList<Verificacao>();
			// veiculo.verificacoes() >>> Polimorfismo
			for (Verificacao v : veiculo.verificacoes()) {
				copia.add(v);
			}
			// veiculo.verificacoes() >>> Polimorfismo
			System.out.println("Lista de defeitos antes da troca: "
					+ veiculo.verificacoes());
			// veiculo.trocarPneus() >>> Polimorfismo
			if (copia.contains(Verificacao.PNEUS)) {
				System.out.println("Quantidade de Pneus trocados: "
						+ veiculo.trocarPneus());
			}
			// veiculo.consertar(verificacao) >>> Polimorfismo
			for (Verificacao verificacao : copia) {
				veiculo.consertar(verificacao);
			}
			// veiculo.verificacoes() >>> Polimorfismo
			System.out.println("Lista de defeitos apos a troca: "
					+ veiculo.verificacoes());
			// veiculo.consertosPassados() >>> Polimorfismo
			System.out
					.println("Lista de consertos pelos quais o veiculo ja passou: "
							+ veiculo.consertosPassados());
			// veiculo.limpar() >>> Polimorfismo
			veiculo.limpar();
		} else {
			System.out.println("Nao ha veiculos a serem consertados.");
		}
	}

	/**
	 * Metodo responsavel por fazer uma manutencao personalizada no Veiculo.
	 * Este metodo verifica as avarias que o usuario quer que sejam verificadas
	 * e as conserta.
	 */
	public void manutencaoPersonalizada() {
		Veiculo veiculo = proximo();

		if (veiculo != null) {
			// veiculo.verificacoes().clear() >>> Polimorfismo
			veiculo.verificacoes().clear();
			recebeVerificacoesUsuario(veiculo);

			List<Verificacao> copia = new ArrayList<Verificacao>();
			// veiculo.verificacoes() >>> Polimorfismo
			for (Verificacao v : veiculo.verificacoes()) {
				copia.add(v);
			}
			// veiculo.verificacoes() >>> Polimorfismo
			System.out.println("Lista de defeitos antes da troca: "
					+ veiculo.verificacoes());
			// veiculo.trocarPneus() >>> Polimorfismo
			if (copia.contains(Verificacao.PNEUS)) {
				System.out.println("Quantidade de Pneus trocados: "
						+ veiculo.trocarPneus());
			}
			// veiculo.consertar() >>> Polimorfismo
			for (Verificacao verificacao : copia) {
				veiculo.consertar(verificacao);
			}
			// veiculo.verificacoes() >>> Polimorfismo
			System.out.println("Lista de defeitos apos a troca: "
					+ veiculo.verificacoes());
			// veiculo.consertosPassados() >>> Polimorfismo
			System.out
					.println("Lista de consertos pelos quais o veiculo ja passou: "
							+ veiculo.consertosPassados());
			// veiculo.limpar() >>> Polimorfismo
			veiculo.limpar();
		} else {
			System.out.println("Nao ha veiculos a serem consertados.");
		}
	}

	/**
	 * Metodo de execucao da OficinaDeVeiculos.
	 */
	public static void main(String[] args) {
		OficinaDeVeiculos oficina = new OficinaDeVeiculos();
		recebeDadosIniciais(oficina);
	}

	/**
	 * Menu de possiveis verificacoes que o usuaeio deseja fazr com seu Viculo.
	 */
	private static void menuVerificacoes() {
		System.out
				.println("===========================================================================================");
		System.out
				.println("|O que deseja verificar?                                                                  |");
		System.out
				.println("|1-Pneus, 2-Oleo, 3-Motor, 4-Carroceria, 5-Eletronica, 6-Suspensao, 7-Freios, 8-Verificar |");
		System.out
				.println("===========================================================================================");
	}

	/**
	 * Menu principal do programa OficinaDeVeiculos.
	 */
	private static void menuInicial() {
		System.out.println("===============================");
		System.out.println("|O que deseja fazer?          |");
		System.out.println("|1 - Adicionar Carro          |");
		System.out.println("|2 - Adicionar Moto           |");
		System.out.println("|3 - Manutencao Personalizada |");
		System.out.println("|4 - Manutencao Geral         |");
		System.out.println("|5 - Entregar Veiculo         |");
		System.out.println("|6 - Veiculos na Oficina      |");
		System.out.println("|7 - Extras                   |");
		System.out.println("|8 - Sair                     |");
		System.out.println("===============================");
	}

	/**
	 * Metodo responsavel por receber as verificacoes que um usuario deseja
	 * fazer sobre seu Veiculo.
	 * 
	 * @param Veiculo
	 *            O veiculo a ser verificado.
	 */
	private static void recebeVerificacoesUsuario(Veiculo veiculo) {
		int opcao;
		final int CORRETOR = 1;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 8;
		do {
			menuVerificacoes();
			opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);
			for (Verificacao verificacao : Verificacao.values()) {
				// veiculo.verificacoes().contains(verificacao) >>> Polimorfismo
				if ((opcao - CORRETOR) == verificacao.ordinal()
						&& !veiculo.verificacoes().contains(verificacao)) {
					// veiculo.adicionaVerificacao >>> Polimorfismo
					veiculo.adicionaVerificacao(verificacao);
				}
			}
		} while (opcao != MAX_VALUE);
	}

	/**
	 * Metodo responsavel por mostrar quais sao os veiculos presentes na
	 * Oficina.
	 */
	private static void veiculosNaOficina() {
		int indice = 0;
		if (!veiculosASeremVerificados.isEmpty()) {
			for (Veiculo veiculo : veiculosASeremVerificados) {
				indice++;
				if (veiculo instanceof Moto) {
					// veiculo.verificacoes().isEmpty() >>> Polimorfismo
					if (veiculo.verificacoes().isEmpty()) {
						System.out.println(indice + " Moto - CONSERTADA.");
					} else {
						System.out.println(indice + " Moto - NAO CONSERTADA.");
					}
				} else {
					// veiculo.verificacoes().isEmpty() >>> Polimorfismo
					if (veiculo.verificacoes().isEmpty()) {
						System.out.println(indice + " Carro - CONSERTADO.");
					} else {
						System.out.println(indice + " Carro - NAO CONSERTADO.");
					}
				}
			}
		} else {
			System.out.println("Nao ha veiculos na oficina.");
		}
	}

	/**
	 * Metodo responsavel por receber os dados iniciais na Oficina. Como
	 * adicionar carros, motos, fazer manutencao ...
	 * 
	 * @param oficina
	 *            A oficina a qual os dados pertencem.
	 */
	private static void recebeDadosIniciais(OficinaDeVeiculos oficina) {
		int opcao;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 8;
		String saida = "nao sair";
		do {
			menuInicial();
			opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);
			switch (opcao) {
			case 1:
				Veiculo carro = new Carro();
				oficina.recebeVeiculo(carro);
				break;
			case 2:
				Veiculo moto = new Moto();
				oficina.recebeVeiculo(moto);
				break;
			case 3:
				oficina.manutencaoPersonalizada();
				break;
			case 4:
				oficina.manutencao();
				break;
			case 5:
				if (veiculosASeremVerificados.size() > 0) {
					oficina.entrega(veiculosASeremVerificados.get(0));
				} else {
					System.out.println("Nao ha veiculos prontos para entrega.");
				}
				break;
			case 6:
				veiculosNaOficina();
				break;
			case 7:
				extras();
				break;
			case 8:
				if (veiculosASeremVerificados.isEmpty()) {
					saida = "sair";
				} else {
					System.out.println("Ainda ha veiculos na oficina.");
					System.out.println("Deseja mesmo sair?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					int op = recebeInteiro(1, 2);
					if (op == 1) {
						saida = "sair";
					}
				}
				break;
			default:
				// pass
				break;
			}
		} while (saida.equals("nao sair"));
	}

	/**
	 * Menu de extras disponiveis para uma Moto.
	 */
	private static void menuExtraMoto() {
		System.out.println("===========================");
		System.out.println("|O que deseja fazer?      |");
		System.out.println("|1 - Comprar capacete     |");
		System.out.println("|2 - Comprar luvas        |");
		System.out.println("|3 - Colocar retrovisores |");
		System.out.println("|4 - Pintar moto          |");
		System.out.println("|5 - Lavar moto           |");
		System.out.println("|6 - Sair do extras       |");
		System.out.println("===========================");
	}

	/**
	 * Menu de extras disponiveis para um carro.
	 */
	private static void menuExtraCarro() {
		System.out.println("=======================");
		System.out.println("|O que deseja fazer?  |");
		System.out.println("|1 - Passar aspirador |");
		System.out.println("|2 - Colocar rodao    |");
		System.out.println("|3 - Colocar neon     |");
		System.out.println("|4 - Pintar carro     |");
		System.out.println("|5 - Lavar carro      |");
		System.out.println("|6 - Sair Extras      |");
		System.out.println("=======================");
	}

	/**
	 * Metodo responsavel por chamar os metodos presentes em Moto que sao
	 * responsaveis pelas modificacoes escolhidas pelo usuario.
	 * 
	 * @param moto
	 *            A moto que vai sofrer modificacoes.
	 */
	private static void extrasMoto(Moto moto) {
		int opcao;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 6;

		do {
			menuExtraMoto();
			opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);

			switch (opcao) {
			case 1:
				moto.comprarCapacete();
				break;
			case 2:
				moto.comprarLuvas();
				break;
			case 3:
				moto.colocarRetrovisores();
				break;
			case 4:
				moto.pintar();
				break;
			case 5:
				moto.limpar();
				break;
			}
		} while (opcao != MAX_VALUE);
	}

	/**
	 * Metodo responsavel por chamar os metodos presentes em Carro que sao
	 * responsaveis pelas modificacoes escolhidas pelo usuario.
	 * 
	 * @param carro
	 *            O carro que vai sofrer as modificacoes.
	 */
	private static void extrasCarro(Carro carro) {
		int opcao;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 6;

		do {
			menuExtraCarro();
			opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);

			switch (opcao) {
			case 1:
				carro.passarAspirador();
				break;
			case 2:
				carro.colocarRodao();
				break;
			case 3:
				carro.colocarNeon();
				break;
			case 4:
				carro.pintar();
				break;
			case 5:
				carro.limpar();
				break;
			}
		} while (opcao != MAX_VALUE);
	}

	/**
	 * Metodo responsavel por selecionar um veiculo, identificar se o mesmo eh
	 * um Carro ou uma Moto e chamar o menu extras para o Veiculo
	 * correspondente.
	 */
	private static void extras() {
		if (veiculosASeremVerificados.isEmpty()) {
			System.out.println("Nao ha viculos na oficina.");
			return;
		}

		int opcao;
		final int CORRETOR = 1;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = veiculosASeremVerificados.size();

		veiculosNaOficina();
		System.out.println("Selecione o veiculo:");
		opcao = recebeInteiro(MIN_VALUE, MAX_VALUE);
		Veiculo veiculo = veiculosASeremVerificados.get(opcao - CORRETOR);
		// veiculo.verificacoes().isEmpty() >>> Polimorfismo
		if (!veiculo.verificacoes().isEmpty()) {
			System.out.println("Veiculo nao concertado.");
			return;
		}

		if (veiculo instanceof Moto) {
			Moto moto = (Moto) veiculo;
			extrasMoto(moto);
		} else {
			Carro carro = (Carro) veiculo;
			extrasCarro(carro);
		}
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
