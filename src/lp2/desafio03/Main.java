package lp2.desafio03;

import java.util.Scanner;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Banco banco;
		banco = new Banco(qtdAlunos());
		impressao(banco);

		while (true) {
			realizarOperacao(banco);
		}
	}

	/**
	 * 
	 * @return
	 */
	private static int qtdAlunos() {
		System.out.print("Quantos alunos serao envolvidos no calculo: ");
		return (new Scanner(System.in)).nextInt();
	}

	/**
	 * 
	 * @param banco
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
	 * 
	 */
	private static String operacaoARealizar() {
		System.out.println("Operacoes");
		System.out.println("E - Emprestimo");
		System.out.println("P - Pagamento");
		System.out.println("T - Sair");
		System.out.print("Digite a operacao: ");

		return (new Scanner(System.in)).next();
	}

	/**
	 * 
	 * @param banco
	 */
	public static void realizarOperacao(Banco banco) {
		int valorPagamento;
		int valorEmprestimo;
		String nomeCredor;
		String nomeDevedor;
		String nomePagador;
		String nomeBeneficiario;

		String operacao = operacaoARealizar();
		if (operacao.equalsIgnoreCase("E")) {

			System.out.print("Qual a quantia emprestada? ");
			valorEmprestimo = (new Scanner(System.in)).nextInt();
			impressao(banco);
			System.out.print("Quem esta emprestando? ");
			nomeCredor = (new Scanner(System.in)).next();
			impressao(banco);
			System.out.print("Quem esta recebendo? ");
			nomeDevedor = (new Scanner(System.in)).next();

			banco.novoEmprestimo(nomeCredor, nomeDevedor, valorEmprestimo);
			banco.imprimeRelacoes();

		} else if (operacao.equalsIgnoreCase("P")) {

			System.out.print("Qual a quantia a ser paga? ");
			valorPagamento = (new Scanner(System.in)).nextInt();
			impressao(banco);
			System.out.print("Quem esta pagando? ");
			nomePagador = (new Scanner(System.in)).next();
			impressao(banco);
			System.out.print("Quem esta sendo pago? ");
			nomeBeneficiario = (new Scanner(System.in)).next();

			banco.novoPagamento(nomePagador, nomeBeneficiario, valorPagamento);
			banco.imprimeRelacoes();

		} else if (operacao.equalsIgnoreCase("T")) {
			System.out.println("Simplificacao: ");
			banco.simplificacao();
			System.out.println("Simplificacao realizada com sucesso.");
			System.out.println("Fim das Tarefas.");
			System.out.println();
			System.out.println("Deseja Sair? [T para sair]-[outra tecla para continuar]");
			String saida = (new Scanner(System.in)).nextLine();
			if(saida.equalsIgnoreCase("T")) System.exit(0);
		}
	}

}
