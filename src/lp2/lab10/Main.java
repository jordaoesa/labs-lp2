package lp2.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static ListaContatos listaContatos = new ListaContatos();

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
		int opcao = 8;
		
		do{
			menuPrincipal();
			opcao = getInteiro();
			switch(opcao){
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
				default:
					//pass
					break;
			}
		}while(opcao != 8);
	}
	
	private static void pessoasCadastradas() {
		if(listaContatos.nomePessoasCadastradas().isEmpty()){
			System.out.println("Nao ha funcionarios cadastrados no registro.");
		}else{
			System.out.println("Os funcionarios cadastrados sao:");
			for(int i=0; i<listaContatos.nomePessoasCadastradas().size(); i++){
				System.out.println((i+1) + " - " + listaContatos.nomePessoasCadastradas().get(i));
			}
		}
	}

	private static void obterContatosDeFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		
		for(Pessoa pessoa : listaContatos.getListaDePessoas()){
			if(pessoa.getNome().equalsIgnoreCase(nome)){
				for(ItemDeContato item : pessoa.getListaDeContatos()){
					System.out.println(item.exibirContato());
				}
				return;
			}
		}
		System.out.println("Funcionario nao encontrado no registro.");
	}

	private static void substituirContatoDeFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		
		for(Pessoa pessoa : listaContatos.getListaDePessoas()){
			if(pessoa.getNome().equalsIgnoreCase(nome)){
				ItemDeContato item = null;
				System.out.println("Digite o contato a ser substituido:");
				System.out.println("1 - Email");
				System.out.println("2 - Telefone");
				System.out.println("3 - Endereco");
				int opcao;
				do{
					opcao = getInteiro();
				}while(opcao < 1 || opcao > 3);
				
				switch(opcao){
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
				
				for(ItemDeContato it : pessoa.getListaDeContatos()){
					if(it.equals(item)){
						if(item instanceof Email){
							System.out.println("Novo Email");
							Email em = recebeEmail();
							pessoa.getListaDeContatos().remove(item);
							pessoa.adicionarContato(em);
							System.out.println("O contato:\n" + item.exibirContato() + "\nfoi substituido por:\n" + em.exibirContato());
						}else if(item instanceof Telefone){
							System.out.println("Novo Telefone");
							Telefone tf = recebeTelefone();
							pessoa.getListaDeContatos().remove(item);
							pessoa.adicionarContato(tf);
							System.out.println("O contato:\n" + item.exibirContato() + "\nfoi substituido por:\n" + tf.exibirContato());
						}else if(item instanceof Endereco){
							System.out.println("Novo Endereco");
							Endereco ed = recebeEndereco();
							pessoa.getListaDeContatos().remove(item);
							pessoa.adicionarContato(ed);
							System.out.println("O contato:\n" + item.exibirContato() + "\nfoi substituido por:\n" + ed.exibirContato());
						}
						return;
					}
				}
				
				System.out.println("O funcionario " + pessoa.getNome() + " nao tem esse contato.");
				System.out.println("Deseja adiciona-lo:");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				do{
					opcao = getInteiro();
				}while(opcao < 1 || opcao > 2);
				switch(opcao){
					case 1:
						pessoa.adicionarContato(item);
						System.out.println("Contato adicionado com sucesso.");
						return;
					default:
						break;
				}
			}
		}
		System.out.println("Funcionario nao encontrado no registro.");
	}

	private static void verificarExistenciaDeContatoDeFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		
		for(Pessoa pessoa : listaContatos.getListaDePessoas()){
			if(pessoa.getNome().equalsIgnoreCase(nome)){
				ItemDeContato item = null;
				System.out.println("Digite o contato a ser procurado:");
				System.out.println("1 - Email");
				System.out.println("2 - Telefone");
				System.out.println("3 - Endereco");
				int opcao;
				do{
					opcao = getInteiro();
				}while(opcao < 1 || opcao > 3);
				
				switch(opcao){
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
				
				for(ItemDeContato it : pessoa.getListaDeContatos()){
					if(it.equals(item)){
						System.out.println("O contato:\n" + it.exibirContato() + "\nja existe para o funcionario: " + pessoa.getNome());
						return;
					}
				}
				
				System.out.println("O funcionario " + pessoa.getNome() + " nao tem esse contato.");
				System.out.println("Deseja adiciona-lo:");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				do{
					opcao = getInteiro();
				}while(opcao < 1 || opcao > 2);
				switch(opcao){
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
		System.out.println("Funcionario nao encontrado no registro.");
	}
	
	private static void removerContatoDeFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		
		for(Pessoa pessoa : listaContatos.getListaDePessoas()){
			if(pessoa.getNome().equalsIgnoreCase(nome)){
				for(int i=0; i<pessoa.getListaDeContatos().size(); i++){
					System.out.println((i+1) + " - " + pessoa.getListaDeContatos().get(i).exibirContato());
				}
				System.out.println("Deseja remover qual contato:");
				int opcao;
				
				do{
					opcao = getInteiro();
				}while(opcao < 1 || opcao > pessoa.getListaDeContatos().size());

				pessoa.getListaDeContatos().remove(opcao-1);
				System.out.println("Contato de " + pessoa.getNome() + " removido com sucesso.");
				if(pessoa.getListaDeContatos().isEmpty()){
					listaContatos.getListaDePessoas().remove(pessoa);
					System.out.println("Lista de Contatos de " + pessoa.getNome() + " vazia.\nFuncionario removido do sistema.");
				}
				return;
			}
		}
		System.out.println("Funcionario nao encontrado no registro.");
	}
	
	private static void removerFuncionario() {
		System.out.println("Digite o nome do Funcionario:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		
		for(Pessoa pessoa : listaContatos.getListaDePessoas()){
			if(pessoa.getNome().equalsIgnoreCase(nome)){
				listaContatos.getListaDePessoas().remove(pessoa);
				System.out.println("Funcionario removido com sucesso.");
				return;
			}
		}
		System.out.println("Funcionario nao encontrado no registro.");
	}

	private static void cadastrarFuncionario() {
		System.out.println("Digite o Nome:");
		String nome;
		do{
			nome = getString();
		}while(temNumero(nome));
		System.out.println("Digite o RG:");
		String rg;
		do{
			rg = getString();
		}while(!rg.matches("[0-9]*"));
		System.out.println("Digite o CPF:");
		String cpf;
		do{
			cpf = getString();
		}while(!cpf.matches("[0-9]*"));
		System.out.println("Digite a Idade:");
		int idade;
		do{
			idade = getInteiro();
		}while(idade < 0 || idade > 150);
		System.out.println("Digite o Salario:");
		double salario;
		do{
			salario = getDouble();
		}while(salario < 0);
		System.out.println("Quais Contatos esse Funcionario tem:");
		List<ItemDeContato> listaDeContatos = getContatosFunc();
		
		Pessoa pessoa = new Pessoa(nome, rg, cpf, idade, salario, listaDeContatos);
		if(listaContatos.adicionarPessoa(pessoa)){
			System.out.println("Funcionario cadastrado com sucesso.");
		}else{
			System.out.println("Cadastro mal sucedido. Funcionario com mesmo nome/cpf/rg ja cadastrado.");
		}
	}
	
	private static List<ItemDeContato> getContatosFunc() {
		List<ItemDeContato> contatos = new ArrayList<ItemDeContato>();
		
		int opcao = 4;
		do{
			System.out.println("1 - Email");
			System.out.println("2 - Telefone");
			System.out.println("3 - Endereco");
			System.out.println("4 - Sair e Cadastrar Funcionario");
			opcao = getInteiro();
			switch(opcao){
				case 1:
					contatos.add(recebeEmail());
					break;
				case 2:
					contatos.add(recebeTelefone());
					break;
				case 3:
					contatos.add(recebeEndereco());
					break;
				case 4:
					if(contatos.isEmpty()){
						System.out.println("Deve haver pelo menos uma forma de contactar este funcionario.");
						opcao = 0;
					}else{
						break;
					}
					break;
				default:
					break;
			}
		}while(opcao != 4);
		return contatos;
	}
	
	private static Email recebeEmail() {
		Email email = new Email();
		System.out.println("Digite o email:");
		String em;
		do{
			em = getString();
		}while(!email.checaEmail(em));
		email.setEmail(em);
		return email;
	}
	
	private static Telefone recebeTelefone(){
		Telefone telefone = new Telefone();
		System.out.println("Digite o telefone: [ex: 55-83-99999999]");
		String tel;
		do{
			tel = getString();
		}while(!telefone.checaTelefone(tel));
		telefone.setTelefone(tel);
		return telefone;
	}
	
	private static Endereco recebeEndereco(){
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
		do{
			cep = getString();
		}while(!cep.matches("\\d\\d\\d\\d\\d-\\d\\d\\d"));
		System.out.println("Digite o numero:");
		int numero = getInteiro();
		
		Endereco endereco = new Endereco(rua, complemento, bairro, cidade, estado, cep, numero);
		return endereco;
	}

	/**
	 * Metodo responsavel por receber strings. Ele verifica se as strings
	 * passadas estao vazias ou nao.
	 * 
	 * @return A string recebida.
	 */
	private static String getString() {
		String entrada = "";
		do {
			System.out.print("> ");
			entrada = (new Scanner(System.in)).nextLine();
		} while (entrada.replace(" ", "").equals(""));
		return entrada;
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
	
	/**
	 * 
	 * @return
	 */
	private static Double getDouble() {
		Double valor = null;
		do{
			try{
				System.out.println("> ");
				valor = Double.parseDouble((new Scanner(System.in).next()));
			}catch(Exception e){
				// pass
			}
		}while(valor == null);
		return valor;
	}
	
	/**
	 * Verifica se uma String passada como parametro possui numeros ou nao.
	 * 
	 * @param string
	 *            A string passada para verificacao.
	 * @return Retorna true caso tenha numeros e false caso contrario.
	 */
	private static boolean temNumero(String string) {
		for (int i = 0; i < 10; i++) {
			if (string.contains(String.valueOf(i))) {
				return true;
			}
		}
		return false;
	}

}
