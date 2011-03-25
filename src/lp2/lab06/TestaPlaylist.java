package lp2.lab06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Conjunto de testes para a class Playlist.
 * 
 * @author jordaoesa
 * 
 */
public class TestaPlaylist {
	Playlist p1, p2;

	/**
	 * Instanciando duas playlists, uma com cada um dos construtores.
	 */
	@Before
	public void iniciaPlaylist() {
		p1 = new Playlist("Playlist 1", "Jordao", 10);
		p2 = new Playlist("Playlist 2", "Jordao", 17, "Faint");
	}

	/**
	 * Conjunto de testes para o construtor. Aqui eh verificado se os dados
	 * inseridos no contrutor realmente sao utilizados nas playlists.
	 */
	@Test
	public void testaConstrutor() {
		String arrayTeste[] = new String[10];
		Assert.assertEquals("Erro Construtor Playlist1", "Playlist 1",
				p1.getNome());
		Assert.assertEquals("Erro Construtor Playlist1", "Jordao",
				p1.getAutor());
		Assert.assertArrayEquals("Erro Construtor Playlist1", arrayTeste,
				p1.getMusicas());
		Assert.assertEquals("Erro Construtor Playlist1", null,
				p1.getPreferida());

		String arrayTeste2[] = new String[17];
		arrayTeste2[0] = "Faint";
		Assert.assertEquals("Erro Construtor Playlist2", "Playlist 2",
				p2.getNome());
		Assert.assertEquals("Erro Construtor Playlist2", "Jordao",
				p2.getAutor());
		Assert.assertArrayEquals("Erro Construtor Playlist2", arrayTeste2,
				p2.getMusicas());
		Assert.assertEquals("Erro Construtor Playlist2", "Faint",
				p2.getPreferida());

	}

	/**
	 * Conjunto de testes para o metodo adicionaMusica(). Aqui sao testados
	 * varias insercoes de musicas nas playlists.
	 */
	@Test
	public void testaAdicionaMusica() {
		Assert.assertTrue("Erro AdicionaMusica() Playlist1",
				p1.adicionaMusica("Musica1"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist1",
				p1.adicionaMusica("Musica2"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist1",
				p1.adicionaMusica("Musica3"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist1",
				p1.adicionaMusica("Musica4"));

		Assert.assertTrue("Erro AdicionaMusica() Playlist2",
				p2.adicionaMusica("Musica2"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist2",
				p2.adicionaMusica("Musica3"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist2",
				p2.adicionaMusica("Musica4"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist2",
				p2.adicionaMusica("Musica5"));
		Assert.assertTrue("Erro AdicionaMusica() Playlist2",
				p2.adicionaMusica("Musica6"));
	}

	/**
	 * Conjunto de testes para o metodo setPreferida(). Aqui eh testado se o
	 * metodo realmente adiciona uma nova musica a playlist quando ela ja nao
	 * esta la.
	 * 
	 * @throws Exception
	 *             Excecao retornada caso a playlist esteja cheia e se queira
	 *             setar como preferida uma musica que ja nao esteja na
	 *             playlist.
	 */
	@Test
	public void testaSetPreferida() throws Exception {
		p1.adicionaMusica("Musica1");
		p1.adicionaMusica("Musica2");
		p1.adicionaMusica("Musica3");
		p1.adicionaMusica("Musica4");

		p2.adicionaMusica("Musica2");
		p2.adicionaMusica("Musica3");
		p2.adicionaMusica("Musica4");
		p2.adicionaMusica("Musica5");
		p2.adicionaMusica("Musica6");

		int cont = 0;

		p1.setPreferida("Musica1");
		Assert.assertEquals("Erro SetPreferida() Playlist1", "Musica1",
				p1.getPreferida());
		for (int i = 0; i < p1.getMusicas().length; i++) {
			if (p1.getMusicas()[i] != null)
				cont++;
		}
		Assert.assertEquals("Erro SetPreferida() Playlist1", 4, cont);

		p1.setPreferida("Musica5");
		Assert.assertEquals("Erro SetPreferida() Playlist1", "Musica5",
				p1.getPreferida());
		cont = 0;
		for (int i = 0; i < p1.getMusicas().length; i++) {
			if (p1.getMusicas()[i] != null)
				cont++;
		}
		Assert.assertEquals("Erro SetPreferida() Playlist1", 5, cont);

		// testando p2
		Assert.assertEquals("Erro SetPreferida() Playlist2", "Faint",
				p2.getPreferida());

		p2.setPreferida("Musica6");
		Assert.assertEquals("Erro SetPreferida() Playlist2", "Musica6",
				p2.getPreferida());
		cont = 0;
		for (int i = 0; i < p2.getMusicas().length; i++) {
			if (p2.getMusicas()[i] != null)
				cont++;
		}
		Assert.assertEquals("Erro SetPreferida() Playlist2", 6, cont);

		p2.setPreferida("Musica7");
		Assert.assertEquals("Erro SetPreferida() Playlist2", "Musica7",
				p2.getPreferida());
		cont = 0;
		for (int i = 0; i < p2.getMusicas().length; i++) {
			if (p2.getMusicas()[i] != null)
				cont++;
		}
		Assert.assertEquals("Erro SetPreferida() Playlist2", 7, cont);
	}

	/**
	 * Conjunto de testes para os metodos adicionaMusica() e setPreferida().
	 * Aqui sao testados casos extremos; como o caso de uma lista ja estar cheia
	 * e tentarmos adicionar mais musicas nela ou tentarmos modificar a musica
	 * preferida por uma que a playlist nao contenha.
	 * 
	 * @throws Exception
	 *             Excecao retornada caso a playlist esteja cheia e se queira
	 *             setar como preferida uma musica que ja nao esteja na
	 *             playlist.
	 */
	@Test
	public void testaExtremosArray() throws Exception {
		for (int i = 0; i < p1.getMusicas().length; i++) {
			p1.adicionaMusica("Musica" + (i + 1));
		}
		for (int i = 1; i < p2.getMusicas().length; i++) {
			p2.adicionaMusica("Musica" + (i + 1));
		}

		// as duas Playlists ja estao lotadas

		Assert.assertFalse("Erro em adicionaMusica() Playlist1",
				p1.adicionaMusica("Musica11"));
		Assert.assertFalse("Erro em adicionaMusica() Playlist1",
				p1.adicionaMusica("Musica12"));

		Assert.assertFalse("Erro em adicionaMusica() Playlist1",
				p2.adicionaMusica("Musica18"));
		Assert.assertFalse("Erro em adicionaMusica() Playlist1",
				p2.adicionaMusica("Musica19"));

		p1.setPreferida("Musica10");
		Assert.assertEquals("Erro em setPreferida() Playlist1", "Musica10",
				p1.getPreferida());

		p2.setPreferida("Musica17");
		Assert.assertEquals("Erro em setPreferida() Playlist2", "Musica17",
				p2.getPreferida());

		try {
			p1.setPreferida("Musica11");
			Assert.fail("Deveria ter falhado setPreferida() Playlist1");
		} catch (Exception e) {
			Assert.assertEquals("Erro em setPreferida() Playlist1",
					"Musica nao adicionada. Playlist Cheia.", e.getMessage());
		}

		try {
			p2.setPreferida("Musica18");
			Assert.fail("Deveria ter falhado setPreferida() Playlist2");
		} catch (Exception e) {
			Assert.assertEquals("Erro em setPreferida() Playlist2",
					"Musica nao adicionada. Playlist Cheia.", e.getMessage());
		}
	}

}
