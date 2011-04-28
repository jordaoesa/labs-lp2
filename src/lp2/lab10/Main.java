package lp2.lab10;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		recebeDadosIniciais();

	}
	
	public static void menuPrincipal(){
		System.out.println("=====================================================");
		System.out.println("|1 - Cadastrar Funcionario                          |");
		System.out.println("|2 - Remover Funcionario                            |");
		System.out.println("|3 - Remover Contato de Funcionario                 |");
		System.out.println("|4 - Verificar Existencia de Contato de Funcionario |");
		System.out.println("|5 - Substituir Contato de Funcionario              |");
		System.out.println("|6 - Obter Contatos de Funcionario                  |");
		System.out.println("|7 - Pessoas Cadastradas                            |");
		System.out.println("|8 - Sair                                           |");
		System.out.println("=====================================================");
	}
	
	public static void recebeDadosIniciais(){
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 8;
		int opcao = 8;
		
		do{
			menuPrincipal();
			recebeInteiro(MIN_VALUE, MAX_VALUE);
			switch(opcao){
				case 1:
					cadastrarFuncionario();
					break;
				case 2:
					removerFuncionario();
					break;
				case 3:
					removerFuncionario();
					break;
				case 4:
					verificarExistenciaDeContatoDeFuncionario();
					break;
				case 5:
					substituirContatoDeFuncionario();
					break;
				case 6:
					obterContatosDeFuncionario();
					break;
				case 7:
					pessoasCadastradas();
					break;
				default:
					//pass
					break;
			}
		}while(opcao != 8);
	}
	
	
	private static void pessoasCadastradas() {
		System.out.print("Nome: ");
		String nome = getString();
		
	}

	private static void obterContatosDeFuncionario() {
		
	}

	private static void substituirContatoDeFuncionario() {
		
	}

	private static void verificarExistenciaDeContatoDeFuncionario() {
		
	}

	private static void removerFuncionario() {
		
	}

	private static void cadastrarFuncionario() {
		
	}
	
	private static String getString(){
		return (new Scanner(System.in)).next();
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
