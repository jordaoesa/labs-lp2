package lp2.lab06;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/* 
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * Uma playlist de musicas dinamica.
 * 
 * @author jordaoesa
 * 
 */
public class PlaylistDinamica {

	private String autor;
	private String preferida = "Nao tem preferida";
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
	 * Metodo responsavel por pesquisar musicas na playlistDinamica a partir de
	 * uma posicao passada como parametro e retorna-la.
	 * 
	 * @param posicao
	 *            A posicao da musica procurada.
	 * @return Retorna a musica caso ela seja encontrada e null caso contrario.
	 */
	public String pesquisaMusica(int posicao) {
		if (posicao < 0 || posicao > musicas.size() || musicas.size() == 0)
			return null;
		return musicas.get(posicao);
	}

	/**
	 * Metodo responsavel por pesquisar musicas na playlistDinamica a partir do
	 * nome da musica pasado como parametro e retorna-la.
	 * 
	 * @param chave
	 *            O nome da musica a ser pesquisada.
	 * @return Retorna a musica caso ela seja encontrada e null caso contrario.
	 */
	public String pesquisaMusica(String chave) {
		if (!musicas.contains(chave))
			return null;
		return chave;
	}

	/**
	 * Metodo responsavel por procurar uma musica na playlistDinamica.
	 * 
	 * @param chave
	 *            A musica a ser procurada na playlistDinamica.
	 * @return Retorna true caso a musica seja encontrada e false caso
	 *         contrario.
	 */
	public boolean contemMusica(String chave) {
		return musicas.contains(chave);
	}

	/**
	 * Metodo responsavel por remover uma musica da playlistDinamica que eh
	 * passada como parametro.
	 * 
	 * @param musica
	 *            A musica a ser removida da playlistDinamica.
	 * @return Retorna a musica caso ela seja encontrada e removida da
	 *         playlistDinamica ou null caso contrario.
	 */
	public String removeMusica(String musica) {
		if (!musicas.contains(musica))
			return null;
		musicas.remove(musica);
		return musica;
	}

	/**
	 * Metodo responsavel por expor o numero de musicas na playlistDinamica.
	 * 
	 * @return O numero de musicas da playlistDinamica.
	 */
	public int numeroDeMusicas() {
		return musicas.size();
	}

	/**
	 * Metodo toString() da playlistDinamica.
	 * 
	 * @return Uma String com nome do Autor, Nome da playlist, musica Preferida
	 *         e todas as Musicas.
	 */
	public String toString() {
		String strMusicas = "[";
		for (int i = 0; i < musicas.size(); i++) {
			strMusicas += musicas.get(i) + ", ";
		}
		if (strMusicas.length() > 1)
			strMusicas = strMusicas.substring(0, strMusicas.length() - 2);
		strMusicas += "]";
		return "Autor: " + autor + ", Nome: " + nome + ", Preferida: "
				+ preferida + ", Musicas: " + strMusicas;
	}

	/**
	 * Metodo responsavel por comparar duas playlistsDinamicas. A comparacao eh
	 * feita com base nas musicas das playlistsDinamicas. Se elas contiverem as
	 * mesmas musicas e em mesma quantidade elas sao iguais.
	 * 
	 * @return Retorna true caso as playlistsDinamicas sejam iguais e false caso
	 *         contrario.
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

		// Iniciando os elementos das playlistsDinamicas Temporarias como
		// null.
		for (int i = 0; i < musicas.size(); i++) {
			musicasTemp1.add(null);
			musicasTemp2.add(null);
		}

		Collections.copy(musicasTemp1, musicas);
		Collections.copy(musicasTemp2, playlistOutra.getMusicas());

		Collections.sort(musicasTemp1);
		Collections.sort(musicasTemp2);

		int j = 0;
		for (String musica : musicasTemp1) {
			if (!musica.equals(musicasTemp2.get(j))) {
				return false;
			}
			j++;
		}

		return true;
	}
}
