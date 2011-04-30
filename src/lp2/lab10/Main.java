package lp2.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsavel pela execucao do programa de cadastro de funcionarios.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Main {

	private static ListaContatos listaContatos = new ListaContatos();

	/**
	 * Metodo de execucao do programa de cadastro de funcionarios.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		startProgram();
	}

	private static void menuPrincipal() {
		System.out
				.println("======================================================");
		System.out
				.println("| 1 - Cadastrar Funcionario                          |");
		System.out
				.println("| 2 - Remover Funcionario                            |");
		System.out
				.println("| 3 - Remover Contato de Funcionario                 |");
		System.out
				.println("| 4 - Verificar Existencia de Contato de Funcionario |");
		System.out
				.println("| 5 - Substituir Contato de Funcionario              |");
		System.out
				.println("| 6 - Obter Contatos de Funcionario                  |");
		System.out
				.println("| 7 - Funcionarios Cadastrados                       |");
		System.out
				.println("| 8 - Verificar se Funcionario esta apto a Votar     |");
		System.out
				.println("| 9 - Valor do Imposto de Renda do Funcionario       |");
		System.out
				.println("|10 - Adicionar Contato a Funcionario                |");
		System.out
				.println("|11 - Sair                                           |");
		System.out
				.println("======================================================");
	}

	private static void startProgram() {
		int opcao = 11;

		do {
			menuPrincipal();
			opcao = getInteiro();
			switch (opcao) {
			case 1:
				cadastrarFuncionario();
				break;
			case 2:
				removerFuncionario();
				break;
			case 3:
				removerContatoDeFuncionario();
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
			case 8:
				verificarSeFuncionarioVota();
				break;
			case 9:
				valorDoImpostoDeRendaDeFuncionario();
				break;
			case 10:
				adicionarContatoAFuncionario();
				break;
			default:
				// pass
				break;
			}
		} while (opcao != 11);
	}

	private static void adicionarContatoAFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			ItemDeContato item = null;
			System.out.println("Digite o contato a ser adicionado:");
			System.out.println("1 - Email");
			System.out.println("2 - Telefone");
			System.out.println("3 - Endereco");
			int opcao;
			do {
				opcao = getInteiro();
			} while (opcao < 1 || opcao > 3);

			switch (opcao) {
			case 1:
				item = recebeEmail();
				break;
			case 2:
				item = recebeTelefone();
				break;
			case 3:
				item = recebeEndereco();
				break;
			default:
				break;
			}

			for (ItemDeContato it : pessoa.getListaDeContatos()) {
				if (it.equals(item)) {
					System.out.println("O Funcionario " + pessoa.getNome()
							+ " ja possui este contato.");
					return;
				}
			}
			pessoa.adicionarContato(item);
			System.out.println("Contato adicionado com sucesso.");
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void valorDoImpostoDeRendaDeFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			System.out.println("O Funcionario " + pessoa.getNome() + " Paga R$ "
					+ pessoa.pagaIR() + " De Imposto De Renda.");
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void verificarSeFuncionarioVota() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			if (pessoa.vota()) {
				System.out.println("O Funcionario " + pessoa.getNome()
						+ " Esta Apto a Votar.");
			} else {
				System.out.println("O Funcionario " + pessoa.getNome()
						+ " Nao Esta Apto a Votar.");
			}
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void pessoasCadastradas() {
		if (listaContatos.nomePessoasCadastradas().isEmpty()) {
			System.out.println("Nao ha funcionarios cadastrados no registro.");
		} else {
			System.out.println("Os funcionarios cadastrados sao:");
			for (int i = 0; i < listaContatos.nomePessoasCadastradas().size(); i++) {
				System.out.println((i + 1) + " - "
						+ listaContatos.nomePessoasCadastradas().get(i));
			}
		}
	}

	private static void obterContatosDeFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			for (ItemDeContato item : pessoa.getListaDeContatos()) {
				System.out.println(item.exibirContato());
			}
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void substituirContatoDeFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {

			ItemDeContato item = null;
			System.out.println("Digite o contato a ser substituido:");
			System.out.println("1 - Email");
			System.out.println("2 - Telefone");
			System.out.println("3 - Endereco");
			int opcao;
			do {
				opcao = getInteiro();
			} while (opcao < 1 || opcao > 3);

			switch (opcao) {
			case 1:
				System.out.println("Email Antigo");
				item = recebeEmail();
				break;
			case 2:
				System.out.println("Telefone Antigo");
				item = recebeTelefone();
				break;
			case 3:
				System.out.println("Endereco Antigo");
				item = recebeEndereco();
				break;
			default:
				break;
			}

			for (ItemDeContato it : pessoa.getListaDeContatos()) {
				if (it.equals(item)) {
					if (item instanceof Email) {
						System.out.println("Novo Email");
						Email em = recebeEmail();
						pessoa.getListaDeContatos().remove(item);
						pessoa.adicionarContato(em);
						System.out.println("O contato:\n"
								+ item.exibirContato()
								+ "\nfoi substituido por:\n"
								+ em.exibirContato());
					} else if (item instanceof Telefone) {
						System.out.println("Novo Telefone");
						Telefone tf = recebeTelefone();
						pessoa.getListaDeContatos().remove(item);
						pessoa.adicionarContato(tf);
						System.out.println("O contato:\n"
								+ item.exibirContato()
								+ "\nfoi substituido por:\n"
								+ tf.exibirContato());
					} else if (item instanceof Endereco) {
						System.out.println("Novo Endereco");
						Endereco ed = recebeEndereco();
						pessoa.getListaDeContatos().remove(item);
						pessoa.adicionarContato(ed);
						System.out.println("O contato:\n"
								+ item.exibirContato()
								+ "\nfoi substituido por:\n"
								+ ed.exibirContato());
					}
					return;
				}
			}
			adicionaContatoQueFuncionarioNaoTem(pessoa, item);
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}

	}

	private static void verificarExistenciaDeContatoDeFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {

			ItemDeContato item = null;
			System.out.println("Digite o contato a ser procurado:");
			System.out.println("1 - Email");
			System.out.println("2 - Telefone");
			System.out.println("3 - Endereco");
			int opcao;
			do {
				opcao = getInteiro();
			} while (opcao < 1 || opcao > 3);

			switch (opcao) {
			case 1:
				item = recebeEmail();
				break;
			case 2:
				item = recebeTelefone();
				break;
			case 3:
				item = recebeEndereco();
				break;
			default:
				break;
			}

			for (ItemDeContato it : pessoa.getListaDeContatos()) {
				if (it.equals(item)) {
					System.out.println("O contato:\n" + it.exibirContato()
							+ "\nja existe para o funcionario: "
							+ pessoa.getNome());
					return;
				}
			}
			adicionaContatoQueFuncionarioNaoTem(pessoa, item);
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}

	}

	private static void removerContatoDeFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			for (int i = 0; i < pessoa.getListaDeContatos().size(); i++) {
				System.out.println((i + 1) + " - "
						+ pessoa.getListaDeContatos().get(i).exibirContato());
			}
			System.out.println("Deseja remover qual contato:");
			int opcao;

			do {
				opcao = getInteiro();
			} while (opcao < 1 || opcao > pessoa.getListaDeContatos().size());

			pessoa.getListaDeContatos().remove(opcao - 1);
			System.out.println("Contato de " + pessoa.getNome()
					+ " removido com sucesso.");
			if (pessoa.getListaDeContatos().isEmpty()) {
				listaContatos.getListaDePessoas().remove(pessoa);
				System.out.println("Lista de Contatos de " + pessoa.getNome()
						+ " vazia.\nFuncionario removido do sistema.");
			}
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void removerFuncionario() {
		Pessoa pessoa = encontraFuncionario();
		if (pessoa != null) {
			listaContatos.getListaDePessoas().remove(pessoa);
			System.out.println("Funcionario removido com sucesso.");
		} else {
			System.out.println("Funcionario nao encontrado no registro.");
		}
	}

	private static void cadastrarFuncionario() {
		System.out.println("Digite o Nome:");
		String nome;
		do {
			nome = getString();
		} while (temNumero(nome));
		System.out.println("Digite o RG:");
		String rg;
		do {
			rg = getString();
		} while (!rg.matches("[0-9]*"));
		System.out.println("Digite o CPF:");
		String cpf;
		do {
			cpf = getString();
		} while (!Pessoa.verificaCPF(cpf));
		System.out.println("Digite a Idade:");
		int idade;
		do {
			idade = getInteiro();
		} while (idade < 0 || idade > 150);
		System.out.println("Digite o Salario:");
		double salario;
		do {
			salario = getDouble();
		} while (salario < 0);
		System.out.println("Quais Contatos esse Funcionario tem:");
		List<ItemDeContato> listaDeContatos = getContatosFunc();

		Pessoa pessoa = new Pessoa(nome, rg, cpf, idade, salario,
				listaDeContatos);
		if (listaContatos.adicionarPessoa(pessoa)) {
			System.out.println("Funcionario cadastrado com sucesso.");
		} else {
			System.out
					.println("Cadastro mal sucedido. Funcionario com mesmo nome/cpf/rg ja cadastrado.");
		}
	}

	private static List<ItemDeContato> getContatosFunc() {
		List<ItemDeContato> contatos = new ArrayList<ItemDeContato>();

		int opcao = 4;
		do {
			System.out.println("1 - Email");
			System.out.println("2 - Telefone");
			System.out.println("3 - Endereco");
			System.out.println("4 - Sair e Cadastrar Funcionario");
			opcao = getInteiro();
			switch (opcao) {
			case 1:
				Email email = recebeEmail();
				if (!contatos.contains(email)) {
					contatos.add(email);
					System.out.println("Email cadastrado com sucesso.");
				} else
					System.out.println(email.exibirContato()
							+ " ja cadastrado.");
				break;
			case 2:
				Telefone telefone = recebeTelefone();
				if (!contatos.contains(telefone)) {
					contatos.add(telefone);
					System.out.println("Telefone cadastrado com sucesso.");
				} else
					System.out.println(telefone.exibirContato()
							+ " ja cadastrado.");
				break;
			case 3:
				Endereco endereco = recebeEndereco();
				if (!contatos.contains(endereco)) {
					contatos.add(endereco);
					System.out.println("Endereco cadastrado com sucesso.");
				} else
					System.out.println(endereco.exibirContato()
							+ "\n--ja cadastrado.");
				break;
			case 4:
				if (contatos.isEmpty()) {
					System.out
							.println("Deve haver pelo menos uma forma de contactar este funcionario.");
					opcao = 0;
				} else {
					break;
				}
				break;
			default:
				break;
			}
		} while (opcao != 4);
		return contatos;
	}

	private static Email recebeEmail() {
		Email email = new Email();
		System.out.println("Digite o email:");
		String em;
		do {
			em = getString();
		} while (!email.checaEmail(em));
		email.setEmail(em);
		return email;
	}

	private static Telefone recebeTelefone() {
		Telefone telefone = new Telefone();
		System.out.println("Digite o telefone: [ex: 55-83-99999999]");
		String tel;
		do {
			tel = getString();
		} while (!telefone.checaTelefone(tel));
		telefone.setTelefone(tel);
		return telefone;
	}

	private static Endereco recebeEndereco() {
		System.out.println("Digite a rua:");
		String rua = getString();
		System.out.println("Digite o complemento:");
		String complemento = getString();
		System.out.println("Digite o bairro:");
		String bairro = getString();
		System.out.println("Digite a cidade:");
		String cidade = getString();
		System.out.println("Digite o estado:");
		String estado = getString();
		System.out.println("Digite o cep: [ex: 12345-000]");
		String cep;
		do {
			cep = getString();
		} while (!cep.matches("\\d\\d\\d\\d\\d-\\d\\d\\d"));
		System.out.println("Digite o numero:");
		int numero = getInteiro();

		Endereco endereco = new Endereco(rua, complemento, bairro, cidade,
				estado, cep, numero);
		return endereco;
	}

	private static String getString() {
		String entrada = "";
		do {
			System.out.print("> ");
			entrada = (new Scanner(System.in)).nextLine();
		} while (entrada.replace(" ", "").equals(""));
		return entrada;
	}

	private static Integer getInteiro() {
		Integer num = null;
		do {
			try {
				System.out.print("> ");
				num = Integer.parseInt((new Scanner(System.in)).next());
			} catch (Exception e) {
				// pass
			}
		} while (num == null);
		return num;
	}

	private static Double getDouble() {
		Double valor = null;
		do {
			try {
				System.out.println("> ");
				valor = Double.parseDouble((new Scanner(System.in).next()));
			} catch (Exception e) {
				// pass
			}
		} while (valor == null);
		return valor;
	}

	private static boolean temNumero(String string) {
		for (int i = 0; i < 10; i++) {
			if (string.contains(String.valueOf(i))) {
				return true;
			}
		}
		return false;
	}

	private static Pessoa encontraFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do {
			nome = getString();
		} while (temNumero(nome));

		for (Pessoa pessoa : listaContatos.getListaDePessoas()) {
			if (pessoa.getNome().equalsIgnoreCase(nome)) {
				return pessoa;
			}
		}
		return null;
	}

	private static void adicionaContatoQueFuncionarioNaoTem(Pessoa pessoa,
			ItemDeContato item) {
		int opcao;
		System.out.println("O funcionario " + pessoa.getNome()
				+ " nao tem esse contato.");
		System.out.println("Deseja adiciona-lo:");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		do {
			opcao = getInteiro();
		} while (opcao < 1 || opcao > 2);
		switch (opcao) {
		case 1:
			pessoa.adicionarContato(item);
			System.out.println("Contato adicionado com sucesso.");
			return;
		case 2:
			System.out.println("Contato nao adicionado.");
			return;
		default:
			break;
		}
	}

}
