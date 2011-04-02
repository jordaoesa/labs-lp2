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

		realizarOperacao(banco);
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

	public static void realizarOperacao(Banco banco) {
		int valorPagamento;
		int valorEmprestimo;
		String nomeCredor;
		String nomeDevedor;
		
		String operacao = operacaoARealizar();
		if (operacao.equals("E")) {
			impressao(banco);

			System.out.print("Qual a quantia emprestada? ");
			valorEmprestimo = (new Scanner(System.in)).nextInt();
			System.out.print("Quem esta emprestando? ");
			nomeCredor = (new Scanner(System.in)).next();
			System.out.print("Quem esta recebendo? ");
			nomeDevedor = (new Scanner(System.in)).next();

			banco.novoEmprestimo(nomeCredor, nomeDevedor, valorEmprestimo);
			
			System.out.println(banco.imprimeRelacoes());
			
		} else if (operacao.equals("P")) {

		} else if (operacao.equals("T")) {
			System.exit(0);
		}
	}

}
