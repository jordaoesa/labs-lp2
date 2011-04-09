package lp2.desafio03;

import java.util.Scanner;

/**
 * A classe de execucao do programa.
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
public class Main {

	/**
	 * Metodo de execucao do programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Banco banco = new Banco(qtdAlunos());
		impressao(banco);

		while (true) {
			realizarOperacao(banco);
		}
	}

	/**
	 * Metodo responsavel por receber a quantidade de alunos usuarios.
	 * 
	 * @return A quantidade de alunos usuarios.
	 */
	private static int qtdAlunos() {
		System.out.println("Quantos alunos serao envolvidos no calculo: ");
		return recebeInteiro();
	}

	/**
	 * Metodo responsavel por receber um inteiro.
	 * 
	 * @return Um inteiro.
	 */
	private static int recebeInteiro() {
		String str;
		do {
			System.out.print("-> ");
			str = (new Scanner(System.in)).nextLine();
		} while (temLetra(str));
		return Integer.parseInt(str);
	}

	/**
	 * Metodo responsavel por verificar a existencia de caracteres em numeros.
	 * 
	 * @param str
	 *            O numero recebido como uma string.
	 * @return Retorna true caso contenha letras e false caso contrario.
	 */
	private static boolean temLetra(String str) {
		if (str.isEmpty()) {
			return true;
		}
		for (Character c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo responsavel por receber string nao vazias.
	 * 
	 * @return A string recebida.
	 */
	private static String getString() {
		String entrada = "";
		do {
			System.out.print("-> ");
			entrada = (new Scanner(System.in)).nextLine();
		} while (entrada.replace(" ", "").equals(""));
		return entrada;
	}

	/**
	 * Metodo responsavel por imprimir a lista de alunos.
	 * 
	 * @param banco
	 *            O banco que contem a lista.
	 */
	private static void impressao(Banco banco) {
		String impressao = "";
		for (Aluno aluno : banco.getAlunos()) {
			impressao += aluno.getNome() + ", ";
		}
		System.out
				.println(impressao.substring(0, impressao.length() - 2) + ".");
	}

	/**
	 * Metodo responsavel por imprimir o menu de opcoes e receber uma string com
	 * a opcao.
	 * 
	 * @return A string opcao.
	 */
	private static String operacaoARealizar() {
		System.out.println("\n# Operacoes #######");
		System.out.println("# E - Emprestimo  #");
		System.out.println("# P - Pagamento   #");
		System.out.println("# S - Simplificar #");
		System.out.println("# T - Sair        #");
		System.out.println("###################");
		System.out.print("-> Digite a operacao: ");

		return getString();
	}

	/**
	 * Metodo responsavel por receber os dados que serao utilizados nas
	 * operacoes.
	 * 
	 * @param banco
	 *            O banco responsavel pelas operacoes.
	 */
	private static void realizarOperacao(Banco banco) {
		int valorPagamento;
		int valorEmprestimo;
		String nomeCredor;
		String nomeDevedor;
		String nomePagador;
		String nomeBeneficiario;

		String operacao = operacaoARealizar();
		if (operacao.equalsIgnoreCase("E")) {

			System.out.println("-> Qual a quantia emprestada? ");
			valorEmprestimo = recebeInteiro();
			impressao(banco);
			System.out.println("-> Quem esta emprestando? ");
			nomeCredor = getString();
			impressao(banco);
			System.out.println("-> Quem esta recebendo? ");
			nomeDevedor = getString();

			banco.novoEmprestimo(nomeCredor, nomeDevedor, valorEmprestimo);
			banco.imprimeRelacoes();

		} else if (operacao.equalsIgnoreCase("P")) {

			System.out.println("-> Qual a quantia a ser paga? ");
			valorPagamento = recebeInteiro();
			impressao(banco);
			System.out.println("-> Quem esta pagando? ");
			nomePagador = getString();
			impressao(banco);
			System.out.println("-> Quem esta sendo pago? ");
			nomeBeneficiario = getString();

			banco.novoPagamento(nomePagador, nomeBeneficiario, valorPagamento);
			banco.imprimeRelacoes();

		} else if (operacao.equalsIgnoreCase("S")) {
			System.out
					.println("\n#### Simplificacao #######################################");
			banco.simplificacao();
			System.out
					.println("#### Simplificacao realizada com sucesso. ################\n");
		} else if (operacao.equalsIgnoreCase("T")) {
			System.exit(0);
		}
	}

}
