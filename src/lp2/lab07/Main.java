package lp2.lab07;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * Classe principal do programa responsavel pela execucao e interacao com o
 * usuario.
 * 
 * @author jordaoesa
 * 
 */
public class Main {

	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static List<Anuncio> anuncios = new ArrayList<Anuncio>();

	/**
	 * Onde se encontra o laco principal do programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcao;
		do {
			opcao = menuInicial();
			switch (opcao) {
			case 1:
				logar(getLoginSenha());
				break;
			case 2:
				Usuario user = recebeDadosUsuario();
				if (user == null) {
					break;
				}
				adicionaUsuario(user);
				break;
			case 3:
				criarAnuncio();
				break;
			case 4:
				System.exit(0);
			default:
				// pass
			}
		} while (opcao != 4);

	}

	/**
	 * Menu inicial do programa.
	 * 
	 * @return Um inteiro correspondente com a opcao que o usuario escolheu.
	 */
	private static int menuInicial() {
		final int VALOR_MINIMO = 1;
		final int VALOR_MAXIMO = 4;

		System.out.println("* MENU ******************");
		System.out.println("* 1 - Logar             *");
		System.out.println("* 2 - Cadastrar Usuario *");
		System.out.println("* 3 - Adicionar Anuncio *");
		System.out.println("* 4 - Sair              *");
		System.out.println("*************************");

		return recebeInteiro(VALOR_MINIMO, VALOR_MAXIMO);
	}

	/**
	 * Este metodo contem um laco com as opcoes que sao disponibilizadas ao
	 * usuario logado no sistema.
	 */
	private static void logado() {
		int opcao;

		do {
			opcao = menuLogado();
			switch (opcao) {
			case 1:
				getUsuario().setLogado(false);
				System.out.println("Deslogado com sucesso.");
				break;
			case 2:
				alterarLogin();
				break;
			case 3:
				alterarSenha();
				break;
			case 4:
				alterarNome();
				break;
			case 5:
				alterarNacionalidade();
				break;
			case 6:
				verDadosPessoais();
				break;
			case 7:
				exibirAnuncios();
				break;
			default:
				// pass
			}
		} while (opcao != 1);
	}

	/**
	 * Menu que eh mostrado ao usuario logado no sistema.
	 * 
	 * @return Um inteiro correspondente com a opcao que o usuario escolheu.
	 */
	private static int menuLogado() {
		final int VALOR_MINIMO = 1;
		final int VALOR_MAXIMO = 7;

		System.out.println("\n* Menu *********************");
		System.out.println("*1 - Deslogar              *");
		System.out.println("*2 - Alterar Login         *");
		System.out.println("*3 - Alterar Senha         *");
		System.out.println("*4 - Alterar Nome          *");
		System.out.println("*5 - Alterar Nacionalidade *");
		System.out.println("*6 - Ver Dados Pessoais    *");
		System.out.println("*7 - Rever Anuncios        *");
		System.out.println("****************************");

		return recebeInteiro(VALOR_MINIMO, VALOR_MAXIMO);
	}

	/**
	 * Metodo responsavel por receber o "nome", o "login"(login aceito apenas se
	 * nao contiver espacos), a "senha" e a "nacionalidade" do usuario.
	 * 
	 * @return Um objeto de Usuario com nome, login, senha e nacionalidade
	 *         definidas pelos usuario do programa.
	 */
	private static Usuario recebeDadosUsuario() {
		String nomeLoginSenhaNacionalidade[] = new String[4];
		Pais nacionalidade = null;

		System.out.println("Digite o nome: ");
		do {
			nomeLoginSenhaNacionalidade[0] = getString();
		} while (temNumero(nomeLoginSenhaNacionalidade[0]));
		System.out.println("Digite o login: ");
		do {
			nomeLoginSenhaNacionalidade[1] = getString();
		} while (nomeLoginSenhaNacionalidade[1].trim().contains(" "));
		System.out.println("Digite a senha: ");
		nomeLoginSenhaNacionalidade[2] = getString();
		System.out.println("Digite a nacionalidade: ");
		nacionalidades();
		nomeLoginSenhaNacionalidade[3] = getString();

		nacionalidade = verificaNacionalidade(nomeLoginSenhaNacionalidade[3]);
		if (nacionalidade == null) {
			System.out.println("Pais invalido.");
			return null;
		}
		Usuario user = new Usuario(nomeLoginSenhaNacionalidade[0],
				nomeLoginSenhaNacionalidade[1], nomeLoginSenhaNacionalidade[2],
				nacionalidade);
		return user;
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

	/**
	 * Metodo responsavel por encontrar um objeto Pais e retorna-lo dado apenas
	 * o seu nome.
	 * 
	 * @param nacionalidade
	 *            Uma string com o nome do pais.
	 * @return O objeto Pais quem tem o nome passado como parametro.
	 */
	private static Pais verificaNacionalidade(String nacionalidade) {
		for (Pais pais : Pais.values()) {
			if (pais.getNome().toLowerCase().trim()
					.equals(nacionalidade.toLowerCase().trim())) {
				return pais;
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por mostrar as opcoes de nacionalidade disponiveis.
	 */
	private static void nacionalidades() {
		System.out.println("|- Nacionalidades: -|");
		System.out.println("|-- Alemanha      --|");
		System.out.println("|-- Austria       --|");
		System.out.println("|-- Belgica       --|");
		System.out.println("|-- Dinamarca     --|");
		System.out.println("|-- Eslovaquia    --|");
		System.out.println("|-- Espanha       --|");
		System.out.println("|-- Estonia       --|");
		System.out.println("|-- Franca        --|");
		System.out.println("|-- Irlanda       --|");
		System.out.println("|-- Italia        --|");
		System.out.println("|-- Luxemburgo    --|");
		System.out.println("|-- Malta         --|");
		System.out.println("|-- Portugal      --|");
		System.out.println("|-- Reino Unido   --|");
		System.out.println("|-- Romenia       --|");
	}

	/**
	 * Metodo que adiciona um novo usuario ao sistema.
	 * 
	 * @param usuario
	 *            O usuario a ser adicionado.
	 */
	private static void adicionaUsuario(Usuario usuario) {
		boolean verifica = true;
		if (usuarios.size() > 0) {
			for (Usuario user : usuarios) {
				if (user.getLogin().equals(usuario.getLogin())) {
					verifica = false;
				}
			}
			if (verifica) {
				usuarios.add(usuario);
				System.out.println("Usuario cadastrado com sucesso.");
			} else {
				System.out
						.println("Cadastro nao realizado. Login indisponivel.");
			}
		} else {
			usuarios.add(usuario);
			System.out.println("Usuario cadastrado com sucesso.");
		}
	}

	/**
	 * Metodo responsavel por alterar a nacionalidade de um usuario.
	 * 
	 * @return Retorna true caso seja posivel alterar e false caso contrario.
	 */
	private static boolean alterarNacionalidade() {
		System.out.println("Digite a nova nacionalidade:");
		nacionalidades();
		Pais pais = verificaNacionalidade(getString());
		if (pais != null) {
			getUsuario().setNacionalidade(pais);
			System.out.println("Nacionalidade alterado com sucesso.");
			return true;
		}
		System.out.println("Nacionalidade nao encontrada.");
		return false;
	}

	/**
	 * Metodo responsavel por alterar o nome de um usuario. So sao aceitos nomes
	 * que nao contenham caracteres numericos.
	 */
	private static void alterarNome() {
		String nome;
		System.out.println("Digite o novo nome:");
		do {
			nome = getString();
		} while (temNumero(nome));
		getUsuario().setNome(nome);
		System.out.println("Nome alterado com sucesso.");
	}

	/**
	 * Metodo responsavel por alterar a senha de um usuario.
	 */
	private static void alterarSenha() {
		System.out.println("Digite a nova senha:");
		String novaSenha = getString();
		getUsuario().setSenha(novaSenha);
		System.out.println("Senha alterado com sucesso.");
	}

	/**
	 * Metodo responsavel por alterar o login de um usuario. Um novoLogin so eh
	 * aceito se nao contiver nenhum caracter espaco em seu interior.
	 */
	private static void alterarLogin() {
		boolean verifica = true;
		String novoLogin = null;
		System.out.println("Digite o novo login:");
		do {
			novoLogin = getString();
		} while (novoLogin.trim().contains(" "));

		for (Usuario user : usuarios) {
			if (user.getLogin().equals(novoLogin)) {
				System.out.println("Login ja existente.");
				verifica = false;
				break;
			}
		}

		if (verifica) {
			getUsuario().setLogin(novoLogin);
			System.out.println("Login alterado com sucesso.");
		}
	}

	/**
	 * Metodo responsavel por verificar o usuario que esta logado no momento e
	 * retorna-lo.
	 * 
	 * @return O usuario logado.
	 */
	private static Usuario getUsuario() {
		for (Usuario user : usuarios) {
			if (user.isLogado()) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por logar um usuario no sistema dados seu login e
	 * senha.
	 * 
	 * @param loginSenha
	 *            O login e a senha do usuario a ser logado.
	 */
	private static void logar(String[] loginSenha) {
		Usuario usuario = null;
		boolean verifica = false;
		for (Usuario user : usuarios) {
			if (user.getLogin().equals(loginSenha[0])
					&& user.getSenha().equals(loginSenha[1])) {
				usuario = user;
				verifica = true;
				break;
			}
		}
		if (verifica) {
			usuario.getSaudacao();
			usuario.setLogado(true);
			exibirAnuncios();
			logado();
		} else {
			System.out.println("Login/Senha invalido(s).");
		}
	}

	/**
	 * Metodo responsavel por receber o login e a senha do usuario.
	 * 
	 * @return Um array com login e senha.
	 */
	private static String[] getLoginSenha() {
		String loginSenha[] = new String[2];

		System.out.println("Digite o Login: ");
		loginSenha[0] = getString();
		System.out.println("Digite a Senha: ");
		loginSenha[1] = getString();

		return loginSenha;
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
			System.out.print(">>> ");
			entrada = (new Scanner(System.in)).nextLine();
		} while (entrada.replace(" ", "").equals(""));
		return entrada;
	}

	/**
	 * Metodo responsavel por criar anuncios.
	 */
	private static void criarAnuncio() {
		System.out.println("Digite o pais de origem:");
		nacionalidades();
		Pais pais = verificaNacionalidade(getString());
		if (pais == null) {
			System.out.println("Pais invalido.");
			return;
		}

		System.out.println("Digite o nome da Empresa:");
		String nomeEmpresa = getString();

		System.out.println("Digite o link para pagina web:");
		String linkPagWeb = getString();

		System.out.println("Digite o anuncio:");
		String strAnuncio = getString();

		anuncios.add(new Anuncio(pais, nomeEmpresa, linkPagWeb, strAnuncio));
		System.out.println("Anuncio criado com sucesso.");
	}

	/**
	 * Metodo responsavel por exibir anuncios.
	 */
	private static void exibirAnuncios() {
		System.out.println("|---- Anuncios:");
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getPais().getNome()
					.equals(getUsuario().getNacionalidade().getNome())) {
				anuncio.exibeAnuncio();
			}
		}
	}

	/**
	 * Metodo responsavel por mostrar todos os dados pessoais de um usuario.
	 */
	private static void verDadosPessoais() {
		System.out.println("|---- Dados Pessoais:");
		System.out.println("|-- Nome: " + getUsuario().getNome());
		System.out.println("|-- Login: " + getUsuario().getLogin());
		System.out.println("|-- Senha: " + getUsuario().getSenha());
		System.out.println("|-- Pais: "
				+ getUsuario().getNacionalidade().getNome());
		System.out.println("|-- Capital: "
				+ getUsuario().getNacionalidade().getCapital());
		System.out.println("|-- Idioma: "
				+ getUsuario().getNacionalidade().getIdioma().toString());
	}

	/**
	 * Este metodo eh responsavel pelo tratamento de erros na entrada dos
	 * valores. Sao passados dois valores inteiros que representam o valor
	 * minimo que pode ser recebido e o valor maximo que pode ser recebido.
	 * 
	 * @param menorValor
	 *            O menor valor que pode ser recebido.
	 * @param maiorValor
	 *            O maior valor que pode ser recebido.
	 */
	private static int recebeInteiro(int menorValor, int maiorValor) {
		while (true) {
			try {
				String valor;
				int numero;
				do {
					System.out.print(">>> ");
					valor = (new Scanner(System.in)).nextLine();
					numero = Integer.parseInt(valor);
				} while (numero < menorValor || numero > maiorValor);
				return numero;
			} catch (NumberFormatException num) {
				// naum faca nada
			}
		}
	}
}
