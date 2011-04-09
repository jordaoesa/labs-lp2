package lp2.lab07;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * 
 * @author jordaoesa
 *
 */
public enum Pais {
	
	
	DE("Alemanha", "Berlim", Idioma.ALEMAO),
	AT("Austria", "Viena", Idioma.ALEMAO),
	BE("Belgica", "Bruxelas", Idioma.ALEMAO),
	DK("Dinamarca", "Copenhague", Idioma.DINAMARQUES),
	SK("Eslovaquia", "Bratislava", Idioma.ESLOVACO),
	ES("Espanha", "Madrid", Idioma.ESPANHOL),
	EE("Estonia", "Tallin", Idioma.ESTONIANO),
	FR("Franca", "Paris ", Idioma.FRANCES),
	IE("Irlanda", "Dublim", Idioma.INGLES),
	IT("Italia", "Roma", Idioma.ITALIANO),
	LU("Luxemburgo", "Luxemburgo", Idioma.FRANCES),
	MT("Malta", "La Valeta", Idioma.INGLES),
	PT("Portugal", "Lisboa", Idioma.PORTUGUES),
	UK("Reino Unido", "Londres", Idioma.INGLES),
	RO("Romenia", "Bucareste", Idioma.ROMENO);
	
	private String nome;
	private String capital;
	private Idioma idioma;
	
	/**
	 * Instancia um novo objeto do enum Pais.
	 * @param nome O nome do pais.
	 * @param capital A capital do pais.
	 * @param idioma O idioma do pais.
	 */
	Pais(String nome, String capital, Idioma idioma){
		this.nome = nome;
		this.capital = capital;
		this.idioma = idioma;
	}
	
	/**
	 * Metodo acessor para o atributo "nome".
	 * @return O nome do pais.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo modificador para o atributo "nome".
	 * @param nome O novo nome do pais.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo acessor para o atributo "capital".
	 * @return A capital do pais.
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * Metodo modificador para o atributo capital.
	 * @param capital A nova capital do pais.
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * Metodo acessor para o atributo idioma.
	 * @return O idioma do pais.
	 */
	public Idioma getIdioma() {
		return idioma;
	}

	/**
	 * Metodo modificador para o atributo idioma.
	 * @param idioma O novo idioma do pais.
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

}
