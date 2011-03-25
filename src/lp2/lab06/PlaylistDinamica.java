package lp2.lab06;

import java.util.List;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

//import java.util.Collections;

public class PlaylistDinamica {

	private String autor;
	private String preferida;
	private String nome;
	private List<String> musicas = new ArrayList<String>();

	public PlaylistDinamica(String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}

	public PlaylistDinamica(String nome, String autor, String preferida) {
		this(nome, autor);
		this.preferida = preferida;
		musicas.add(this.preferida);
	}

	public String getAutor() {
		return autor;
	}

	public String getPreferida() {
		return preferida;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getMusicas() {
		return musicas;
	}

	// implementar
	public void setPreferida(String preferida) {
		if (!musicas.contains(preferida)) {
			musicas.add(preferida);
		}
		this.preferida = preferida;
	}

	public boolean adicionaMusica(String musica) {
		return musicas.add(musica);
	}

	public void adicionaMusica(String musica, int posicao) throws Exception {
		if (posicao < 0)
			throw new Exception(
					"Posicao invalida. Insira valores maiores que ou iguais a zero.");
		musicas.add(posicao, musica);
	}

	public String pesquisaMusica(int posicao) {
		if (posicao < 0)
			return null;
		return musicas.get(posicao);
	}

	public String pesquisaMusica(String chave) {
		if (!musicas.contains(chave))
			return null;
		return chave;
	}

	public boolean contemMusica(String chave) {
		return musicas.contains(chave);
	}

	public String removeMusica(String musica) {
		if (!musicas.contains(musica))
			return null;
		musicas.remove(musica);
		return musica;
	}

	public int numeroDeMusicas() {
		return musicas.size();
	}

	public String toString() {
		String strMusicas = "";
		for (int i = 0; i < musicas.size(); i++) {
			strMusicas += musicas.get(i) + " ";
		}
		return "Autor: " + autor + ", Nome: " + nome + ", Preferida: "
				+ preferida + "Musicas: " + strMusicas;
	}

	public boolean equals(Object outraPlaylist) {
		if (!(outraPlaylist instanceof PlaylistDinamica)) {
			return false;
		}
		PlaylistDinamica playlistOutra = (PlaylistDinamica) outraPlaylist;
		if (this.musicas.size() != playlistOutra.getMusicas().size())
			return false;
		int cont = 0;
		Iterator<String> i = musicas.iterator();
		
		return true;
	}
}
