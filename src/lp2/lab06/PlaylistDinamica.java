package lp2.lab06;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Uma playlist de musicas dinamica.
 * 
 * @author jordaoesa
 * 
 */
public class PlaylistDinamica {

	private String autor;
	private String preferida;
	private String nome;
	private List<String> musicas = new ArrayList<String>();

	/**
	 * Construtor da PlaylistDinamica.
	 * 
	 * @param nome
	 *            Nome da playlistDinamica.
	 * @param autor
	 *            Autor da playlistDinamica.
	 */
	public PlaylistDinamica(String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}

	/**
	 * Construtor da PlaylistDinamica.
	 * 
	 * @param nome
	 *            Nome da playlistDinamica.
	 * @param autor
	 *            Autor da playlistDinamica.
	 * @param preferida
	 *            Musica preferida pelo autor da playlistDinamica.
	 */
	public PlaylistDinamica(String nome, String autor, String preferida) {
		this(nome, autor);
		this.preferida = preferida;
		musicas.add(this.preferida);
	}

	/**
	 * Metodo acessor para o atributo nome da playlistDinamica.
	 * 
	 * @return O nome do autor da playlistDinamica.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Metodo acessor para a musica preferida da playlistDinamica.
	 * 
	 * @return A musica preferida pelo autor da plylistDinamica.
	 */
	public String getPreferida() {
		return preferida;
	}

	/**
	 * Metodo acessor para o atributo nome da playlistDinamica.
	 * 
	 * @return O nome da playlistDinamica.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo acessor para o atributo musicas da playlistDinamica.
	 * 
	 * @return Uma lista com todas as musicas da playlistDinamica.
	 */
	public List<String> getMusicas() {
		return musicas;
	}

	/**
	 * Metodo responsavel por definir ou redefinir a musica preferida pelo autor
	 * da playlistDinamica. Caso a musica ja esteja inserida na playlistDinamica
	 * este metodo apenas modifica o valor da musica preferida, caso contrario,
	 * ele insere a musica preferida na playlist e modifica o valor da musica
	 * preferida.
	 * 
	 * @param preferida
	 *            A musica preferida.
	 */
	public void setPreferida(String preferida) {
		if (!musicas.contains(preferida)) {
			musicas.add(preferida);
		}
		this.preferida = preferida;
	}

	/**
	 * Metodo responsavel por adicionar musicas na playlistDinamica.
	 * 
	 * @param musica
	 *            A musica a ser adicionada na playlistDinamica.
	 * @return Retorna true caso a musica seja inserida com sucesso ou false
	 *         caso contrario.
	 */
	public boolean adicionaMusica(String musica) {
		return musicas.add(musica);
	}

	/**
	 * Metodo responsavel por adicionar musicas em uma determinada posicao da
	 * playlistDinamica.
	 * 
	 * @param musica
	 *            A musica a ser adicionada na playlistDinamica.
	 * @param posicao
	 *            A posicao na qual a musica vai ser adicionada.
	 * @throws Exception
	 *             Uma excecao eh lancada caso a posicao passada seja menor que
	 *             zero.
	 */
	public void adicionaMusica(String musica, int posicao) throws Exception {
		if (posicao < 0 || posicao > musicas.size())
			throw new Exception(
					"Posicao invalida. Insira valores dentro da quantidade de musicas na playlist.");
		musicas.add(posicao, musica);
	}

	/**
	 * 
	 * @param posicao
	 * @return
	 */
	public String pesquisaMusica(int posicao) {
		if (posicao < 0 || posicao > musicas.size())
			return null;
		return musicas.get(posicao);
	}

	/**
	 * 
	 * @param chave
	 * @return
	 */
	public String pesquisaMusica(String chave) {
		if (!musicas.contains(chave))
			return null;
		return chave;
	}

	/**
	 * 
	 * @param chave
	 * @return
	 */
	public boolean contemMusica(String chave) {
		return musicas.contains(chave);
	}

	/**
	 * 
	 * @param musica
	 * @return
	 */
	public String removeMusica(String musica) {
		if (!musicas.contains(musica))
			return null;
		musicas.remove(musica);
		return musica;
	}

	/**
	 * 
	 * @return
	 */
	public int numeroDeMusicas() {
		return musicas.size();
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		String strMusicas = "[";
		for (int i = 0; i < musicas.size(); i++) {
			strMusicas += musicas.get(i) + ", ";
		}
		if(strMusicas.length() > 1)
			strMusicas = strMusicas.substring(0, strMusicas.length()-2);
		strMusicas+="]";
		return "Autor: " + autor + ", Nome: " + nome + ", Preferida: "
				+ preferida + ", Musicas: " + strMusicas;
	}

	/**
	 * 
	 * @return
	 */
	public boolean equals(Object outraPlaylist) {
		if (!(outraPlaylist instanceof PlaylistDinamica)) {
			return false;
		}
		PlaylistDinamica playlistOutra = (PlaylistDinamica) outraPlaylist;
		if (this.musicas.size() != playlistOutra.getMusicas().size())
			return false;

		List<String> musicasTemp1 = new ArrayList<String>();
		List<String> musicasTemp2 = new ArrayList<String>();

		Collections.copy(musicasTemp1, musicas);
		Collections.copy(musicasTemp2, playlistOutra.getMusicas());

		Collections.sort(musicasTemp1);
		Collections.sort(musicasTemp2);

		int j = 0;
		for (String musica : musicas) {
			if (!musica.equals(playlistOutra.getMusicas().get(j))) {
				return false;
			}
			j++;
		}
		return true;
	}
}