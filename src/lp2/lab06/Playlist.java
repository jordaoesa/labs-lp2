package lp2.lab06;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 */
public class Playlist {

	private String autor;
	private String nome;
	private String preferida;
	private String musicas[];

	public Playlist(String nome, String autor, int tamanho) {
		this.nome = nome;
		this.autor = autor;
		this.musicas = new String[tamanho];
	}

	public Playlist(String nome, String autor, int tamanho, String preferida) {
		this(nome, autor, tamanho);
		this.preferida = preferida;
		musicas[0] = this.preferida;
	}

	public String getAutor() {
		return autor;
	}

	public String getNome() {
		return nome;
	}

	public String getPreferida() {
		return preferida;
	}

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

	public String[] getMusicas() {
		return musicas;
	}

	public boolean adicionaMusica(String musica) {

		for (int i = 0; i < musicas.length; i++) {
			if (musicas[i] == null) {
				musicas[i] = musica;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String strMusica = "";
		for (int i = 0; i < musicas.length; i++) {
			strMusica += musicas[i] + " ";
		}

		return "Autor: " + autor + ", Nome: " + nome + ", Preferida: "
				+ preferida + ", Musicas: " + strMusica;
	}

}
