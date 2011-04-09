package lp2.lab07;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * Enum responsavel por definir os idiomas dos paises.
 * 
 * @author jordaoesa
 * 
 */
public enum Idioma {

	ALEMAO("Willkommen"), INGLES("Welcome"), DINAMARQUES("Velkommen"), ESLOVACO(
			"Vitajte"), ESPANHOL("Bienvenido"), ESTONIANO("Tere"), FRANCES(
			"Bienvenue"), ITALIANO("Benvenuti"), PORTUGUES("Seja Bem Vindo"), ROMENO(
			"Bine ai venit");

	private String saudacao;

	/**
	 * Instancia um novo objeto do enum Idioma.
	 * 
	 * @param saudacao A saudacao no idioma correspondente.
	 */
	Idioma(String saudacao) {
		this.saudacao = saudacao;
	}

	/**
	 * Retorna a saudacao no idioma escolhido.
	 * 
	 * @return A saudacao.
	 */
	public String getSaudacao() {
		return saudacao;
	}

	/**
	 * Define uma nova saudacao para o idioma escolhido.
	 * 
	 * @param saudacao
	 *            A nova saudacao.
	 */
	public void setSaudacao(String saudacao) {
		this.saudacao = saudacao;
	}

}
