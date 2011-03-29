package lp2.lab06;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaPlaylistDinamica {

	PlaylistDinamica p1, p2;

	@Before
	public void criaPlaylistsDinamicas() {
		p1 = new PlaylistDinamica("PlaylistDinamica 1", "Jordao");
		p2 = new PlaylistDinamica("PlaylistDinamica 2", "Jordao", "Faint");
	}

	@Test
	public void testaConstrutor() {
		List<String> listaDeMusicasTeste = new ArrayList<String>();

		// playlistDinamica 1
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 1",
				"PlaylistDinamica 1", p1.getNome());
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 1", "Jordao",
				p1.getAutor());
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 1",
				"Nao tem preferida", p1.getPreferida());
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 1",
				listaDeMusicasTeste, p1.getMusicas());

		// playlistDinamica 2
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 2",
				"PlaylistDinamica 2", p2.getNome());
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 2", "Jordao",
				p2.getAutor());
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 2", "Faint",
				p2.getPreferida());

		listaDeMusicasTeste.add("Faint");
		Assert.assertEquals("Erro no Contrutor PlaylistDinamica 2",
				listaDeMusicasTeste, p2.getMusicas());

	}

	@Test
	public void testaSetPreferida() {

		// playlistDinamica 1
		Assert.assertEquals("Erro em setPreferida playlistDinamica 1",
				"Nao tem preferida", p1.getPreferida());
		p1.setPreferida("Musica0");
		Assert.assertEquals("Erro em setPreferida playlistDinamica 1",
				"Musica0", p1.getPreferida());
		Assert.assertEquals("Erro em setPreferida playlistDinamica 1",
				"Musica0", p1.getMusicas().get(0));
		p1.setPreferida("Musica1");
		Assert.assertEquals("Erro em setPreferida playlistDinamica 1",
				"Musica1", p1.getPreferida());
		Assert.assertEquals("Erro em setPreferida playlistDinamica 1",
				"Musica1", p1.getMusicas().get(1));

		// playlistDinamica 2
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2", "Faint",
				p2.getPreferida());
		p2.setPreferida("Faint");
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2", "Faint",
				p2.getPreferida());
		p2.setPreferida("Musica1");
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2",
				"Musica1", p2.getPreferida());
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2",
				"Musica1", p2.getMusicas().get(1));
		p2.setPreferida("Musica2");
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2",
				"Musica2", p2.getPreferida());
		Assert.assertEquals("Erro em setPreferida playlistDinamica 2",
				"Musica2", p2.getMusicas().get(2));
	}

	@Test
	public void testaAdicionaMusica() throws Exception {

		// adicionaMusica(String musica) playlistDinamica 1
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 1",
				p1.adicionaMusica("Musica0"));
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 1",
				p1.adicionaMusica("Musica0"));
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 1",
				p1.adicionaMusica("Musica2"));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica0", p1.getMusicas().get(0));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica0", p1.getMusicas().get(1));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica2", p1.getMusicas().get(2));

		// adicionaMusica(String musica, int posicao) playlistDinamica 1
		p1.adicionaMusica("Musica3", 2);
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica3", p1.getMusicas().get(2));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica2", p1.getMusicas().get(3));
		p1.adicionaMusica("Musica5", 0);
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica5", p1.getMusicas().get(0));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica0", p1.getMusicas().get(1));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 1",
				"Musica2", p1.getMusicas().get(4));

		// adicionaMusica(String musica) playlistDinamica 2
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 2",
				p2.adicionaMusica("Musica1"));
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 2",
				p2.adicionaMusica("Musica1"));
		Assert.assertTrue("Erro em adicionaMusica playlistDinamica 2",
				p2.adicionaMusica("Musica2"));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Faint", p2.getMusicas().get(0));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica1", p2.getMusicas().get(1));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica1", p2.getMusicas().get(2));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica2", p2.getMusicas().get(3));

		// adicionaMusica(String musica, int posicao) playlistDinamica 2
		p2.adicionaMusica("Musica0", 0);
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica0", p2.getMusicas().get(0));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Faint", p2.getMusicas().get(1));
		p2.adicionaMusica("Musica4", 4);
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica4", p2.getMusicas().get(4));
		Assert.assertEquals("Erro em adicionaMusica playlistDinamica 2",
				"Musica2", p2.getMusicas().get(5));

		try {
			p1.adicionaMusica("Musica", -1);
			Assert.fail("Deveria ter falhado em adicionar musica playlistDinamica 1.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro em adicionaMusica playlistDinamica 1",
					"Posicao invalida. Insira valores dentro da quantidade de musicas na playlist.",
					e.getMessage());
		}

		try {
			p1.adicionaMusica("Musica", 10);
			Assert.fail("Deveria ter falhado em adicionar musica playlistDinamica 1.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro em adicionaMusica playlistDinamica 1",
					"Posicao invalida. Insira valores dentro da quantidade de musicas na playlist.",
					e.getMessage());
		}

		try {
			p2.adicionaMusica("Musica", -1);
			Assert.fail("Deveria ter falhado em adicionar musica playlistDinamica 2.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro em adicionaMusica playlistDinamica 2",
					"Posicao invalida. Insira valores dentro da quantidade de musicas na playlist.",
					e.getMessage());
		}

		try {
			p2.adicionaMusica("Musica", 10);
			Assert.fail("Deveria ter falhado em adicionar musica playlistDinamica 2.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Erro em adicionaMusica playlistDinamica 2",
					"Posicao invalida. Insira valores dentro da quantidade de musicas na playlist.",
					e.getMessage());
		}
	}

	@Test
	public void testaPesquisaMusica() throws Exception {
		// testando pesquisaMusica em playlistDinamica 1

		// passando posicao como parametro
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1",
				p1.pesquisaMusica(0));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1",
				p1.pesquisaMusica(-1));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1",
				p1.pesquisaMusica(10));

		p1.adicionaMusica("Musica0");
		p1.adicionaMusica("Musica1", 0);
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 1",
				"Musica1", p1.pesquisaMusica(0));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 1",
				"Musica0", p1.pesquisaMusica(1));

		// passando musica como parametro
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1",
				p1.pesquisaMusica("Musica2"));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1",
				p1.pesquisaMusica(""));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 1",
				"Musica0", p1.pesquisaMusica("Musica0"));

		// testando pesquisaMusica em playlistDinamica 2

		// passando posicao como parametro
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2",
				p2.pesquisaMusica(-1));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2",
				p2.pesquisaMusica(10));

		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2",
				"Faint", p2.pesquisaMusica(0));
		p2.adicionaMusica("Musica0");
		p2.adicionaMusica("Musica1", 0);
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2",
				"Musica1", p2.pesquisaMusica(0));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2",
				"Faint", p2.pesquisaMusica(1));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2",
				"Musica0", p2.pesquisaMusica(2));

		// passando musica como parametro
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2",
				p2.pesquisaMusica("Musica2"));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2",
				p2.pesquisaMusica(""));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2",
				"Faint", p2.pesquisaMusica("Faint"));
	}

	@Test
	public void testaContemMusica() {
		Assert.assertFalse("Erro em contemMusica playlistDinamica 1",
				p1.contemMusica("Musica0"));
		p1.adicionaMusica("Musica1");
		Assert.assertTrue("Erro em contemMusica playlistDinamica 1",
				p1.contemMusica("Musica1"));

		Assert.assertFalse("Erro em contemMusica playlistDinamica 2",
				p2.contemMusica("Musica0"));
		Assert.assertTrue("Erro em contemMusica playlistDinamica 2",
				p2.contemMusica("Faint"));
		p2.adicionaMusica("Musica1");
		Assert.assertTrue("Erro em contemMusica playlistDinamica 2",
				p2.contemMusica("Musica1"));
	}

	@Test
	public void testaRemoveMusica() throws Exception {
		Assert.assertNull("Erro em removeMusica playlistDinamica 1",
				p1.removeMusica("Musica"));
		p1.adicionaMusica("Musica0");
		Assert.assertEquals("Erro em removeMusica playlistDinamica 1",
				"Musica0", p1.pesquisaMusica(0));
		p1.removeMusica("Musica0");
		Assert.assertNull("Erro em removeMusica playlistDinamica 1",
				p1.pesquisaMusica(0));

		Assert.assertNull("Erro em removeMusica playlistDinamica 2",
				p2.removeMusica("Musica0"));
		Assert.assertEquals("Erro em removeMusica playlistDinamica 2", "Faint",
				p2.removeMusica("Faint"));
		p2.adicionaMusica("Musica0", 0);
		Assert.assertEquals("Erro em removeMusica playlistDinamica 2",
				"Musica0", p2.removeMusica("Musica0"));
	}

	@Test
	public void numeroDeMusicas() {
		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 1", 0,
				p1.numeroDeMusicas());
		p1.adicionaMusica("Musica0");
		p1.adicionaMusica("Musica1");
		p1.adicionaMusica("Musica3");
		p1.removeMusica("Musica0");
		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 1", 2,
				p1.numeroDeMusicas());

		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 2", 1,
				p2.numeroDeMusicas());
		p2.removeMusica("Musica0");
		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 2", 1,
				p2.numeroDeMusicas());
		p2.adicionaMusica("Musica0");
		p2.adicionaMusica("Musica1");
		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 2", 3,
				p2.numeroDeMusicas());
		p2.removeMusica("Faint");
		Assert.assertEquals("Erro em numeroDeMusicas playlistDinamica 2", 2,
				p2.numeroDeMusicas());
	}

	@Test
	public void testaToString() {
		Assert.assertEquals(
				"Erro em toString playlistDinamica 1",
				"Autor: Jordao, Nome: PlaylistDinamica 1, Preferida: Nao tem preferida, Musicas: []",
				p1.toString());
		Assert.assertEquals(
				"Erro em toString playlistDinamica 2",
				"Autor: Jordao, Nome: PlaylistDinamica 2, Preferida: Faint, Musicas: [Faint]",
				p2.toString());

		p1.setPreferida("Musica0");
		p1.adicionaMusica("Musica1");
		p2.adicionaMusica("Musica1");
		p2.adicionaMusica("Musica2");

		Assert.assertEquals(
				"Erro em toString playlistDinamica 1",
				"Autor: Jordao, Nome: PlaylistDinamica 1, Preferida: Musica0, Musicas: [Musica0, Musica1]",
				p1.toString());
		Assert.assertEquals(
				"Erro em toString playlistDinamica 2",
				"Autor: Jordao, Nome: PlaylistDinamica 2, Preferida: Faint, Musicas: [Faint, Musica1, Musica2]",
				p2.toString());
	}

	@Test
	public void testaEquals() {
		Assert.assertFalse("Erro em equals playlistDinamica 1", p1.equals(10));
		Assert.assertFalse("Erro em equals playlistDinamica 2",
				p2.equals("playlist"));
		Assert.assertFalse("Erro em equals playlistDinamica 1", p1.equals(p2));
		Assert.assertFalse("Erro em equals playlistDinamica 2", p2.equals(p1));

		p1.setPreferida("Faint");
		Assert.assertTrue("Erro em equals playlistDinamica 1", p1.equals(p2));
		Assert.assertTrue("Erro em equals playlistDinamica 2", p2.equals(p1));
		p1.adicionaMusica("Musica1");
		p2.adicionaMusica("Musica2");
		Assert.assertFalse("Erro em equals playlistDinamica 1", p1.equals(p2));
		Assert.assertFalse("Erro em equals playlistDinamica 2", p2.equals(p1));

		p1.adicionaMusica("Musica2");
		p2.adicionaMusica("Musica1");
		Assert.assertTrue("Erro em equals playlistDinamica 1", p1.equals(p2));
		Assert.assertTrue("Erro em equals playlistDinamica 2", p2.equals(p1));

		Assert.assertTrue("Erro em equals playlistDinamica 1", p1.equals(p1));
		Assert.assertTrue("Erro em equals playlistDinamica 2", p2.equals(p2));
	}
}
