package lp2.lab06;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 */

/**
 * Uma playlist de musicas com tamanho predefinido.
 * 
 * @author jordaoesa
 */
public class Playlist {

	private String autor;
	private String nome;
	private String preferida;
	private String musicas[];

	/**
	 * Contrutor da Playlist.
	 * 
	 * @param nome
	 *            Nome da playlist.
	 * @param autor
	 *            Nome do autor da playlist.
	 * @param tamanho
	 *            Ttamanho da playlist.
	 */
	public Playlist(String nome, String autor, int tamanho) {
		this.nome = nome;
		this.autor = autor;
		this.musicas = new String[tamanho];
	}

	/**
	 * Construtor da Playlist.
	 * 
	 * @param nome
	 *            Nome da playlist.
	 * @param autor
	 *            Nome do autor da playlist.
	 * @param tamanho
	 *            Tamanho da playlist.
	 * @param preferida
	 *            Musica preferida pelo autor da playlist.
	 */
	public Playlist(String nome, String autor, int tamanho, String preferida) {
		this(nome, autor, tamanho);
		this.preferida = preferida;
		musicas[0] = this.preferida;
	}

	/**
	 * Metodo acessor para o atributo autor da playlist.
	 * 
	 * @return O nome do autor da playlist.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Metodo acessor para o atributo nome da playlist.
	 * 
	 * @return O nome da playlist.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo acessor para o atributo preferida da playlist.
	 * 
	 * @return A musica preferida pelo autor da playlist.
	 */
	public String getPreferida() {
		return preferida;
	}

	/**
	 * Metodo por definir ou redefinir a musica preferida pelo autor n playlist.
	 * Caso a musica ja esteja inserida na playlist este metodo apenas modifica
	 * o valor da musica preferida, caso contrario, ele insere a musica
	 * preferida na playlist e modifica o valor da musica preferida.
	 * 
	 * @param preferida
	 *            A nova musica preferida.
	 * @throws Exception
	 *             Excecao retornada caso se tente inserir uma preferida que nao
	 *             esteja na playlist e a playlist ja esteja cheia.
	 */
	public void setPreferida(String preferida) throws Exception {

		boolean verificador = false;

		for (int i = 0; i < musicas.length; i++) {
			if (musicas[i] != null && musicas[i].equals(preferida)) {
				verificador = true;
				break;
			}
		}

		if (!verificador && !adicionaMusica(preferida)) {
			throw new Exception("Musica nao adicionada. Playlist Cheia.");
		}

		this.preferida = preferida;

	}

	/**
	 * Metodo acessor para o atributo musicas.
	 * 
	 * @return Um array contendo todas as musicas da playlist.
	 */
	public String[] getMusicas() {
		return musicas;
	}

	/**
	 * Metodo responsavel por adicionar musicas na playlist.
	 * 
	 * @param musica
	 *            Musica a ser adicionada na playlist.
	 * @return Retorna true caso a musica seja inserida com sucesso ou false
	 *         caso contrario.
	 */
	public boolean adicionaMusica(String musica) {

		for (int i = 0; i < musicas.length; i++) {
			if (musicas[i] == null) {
				musicas[i] = musica;
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo toString() responsavel por imprimir todos os dados da playlist.
	 */
	public String toString() {
		String strMusica = "";
		for (int i = 0; i < musicas.length; i++) {
			strMusica += musicas[i] + " ";
		}

		return "Autor: " + autor + ", Nome: " + nome + ", Preferida: "
				+ preferida + ", Musicas: " + strMusica;
	}

}
