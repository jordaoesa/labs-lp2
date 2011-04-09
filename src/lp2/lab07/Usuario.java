package lp2.lab07;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * Um usuario que vai ser cadastrado no sistema.
 * 
 * @author jordaoesa
 * 
 */
public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private Pais nacionalidade;
	private boolean logado = false;

	/**
	 * Instancia um novo usuario.
	 * 
	 * @param nome
	 *            O nome do usuario.
	 * @param login
	 *            O login do usuario;
	 * @param senha
	 *            A senha do usuario.
	 * @param nacionalidade
	 *            A nacionalidade do usuario.
	 */
	public Usuario(String nome, String login, String senha, Pais nacionalidade) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.nacionalidade = nacionalidade;
	}

	/**
	 * Metodo acessor para o atributo nome.
	 * 
	 * @return O nome do usuario.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo modificador para o atributo nome.
	 * 
	 * @param nome
	 *            O novo nome do usuario.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo acessor para o atributo login.
	 * 
	 * @return O login.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Metodo modificador para o atributo login.
	 * 
	 * @param login
	 *            O novo login para o usuario.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Metodo acessor para o atributo senha.
	 * 
	 * @return A senha do usuario.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Metodo modificador para o atributo senha.
	 * 
	 * @param senha
	 *            A nova senha para o usuario.
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Metodo acessor para o atributo nacionalidade.
	 * 
	 * @return O pais onde o usuario eh natural.
	 */
	public Pais getNacionalidade() {
		return nacionalidade;
	}

	/**
	 * Metodo modificador para o atributo nacionalidade.
	 * 
	 * @param nacionalidade
	 *            A nova nacionalidade do usuario.
	 */
	public void setNacionalidade(Pais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	/**
	 * Metodo que retorna a saudacao correspondente com o idioma do usuario.
	 */
	public void getSaudacao() {
		System.out.println(nacionalidade.getIdioma().getSaudacao() + " " + nome
				+ ".\n");
	}

	/**
	 * Metodo que verifica se o usuario esta logado ou nao.
	 * 
	 * @return Retorna true caso o usuario esteja logado e false caso contrario.
	 */
	public boolean isLogado() {
		return logado;
	}

	/**
	 * Metodo modificador para o atributo logado.
	 * 
	 * @param logado
	 *            O novo valor para logado.
	 */
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
