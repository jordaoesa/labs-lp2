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

	// @Test
	// public void testaToString() throws Exception{
	// p1.adicionaMusica("Musica1");
	// p1.adicionaMusica("Musica2");
	//
	// try{
	// p1.adicionaMusica("Musica0", -1);
	// }catch(Exception e){
	// System.out.println(e.getMessage());
	// }
	// System.out.println(p1.toString());
	// System.out.println(p2.toString());
	// }

	// @Test
	// public void testaEquals(){
	// PlaylistDinamica pl1 = new
	// PlaylistDinamica("Playlist1","Jordao","Musica0");
	// PlaylistDinamica pl2 = new
	// PlaylistDinamica("Playlist1","Jordao","Musica0");
	//
	// System.out.println("ok");
	//
	// Assert.assertTrue("Erro aquew no 1 teste", pl1.equals(pl2));
	//
	// System.out.println("ok");
	//
	// pl1.adicionaMusica("Musica1");
	// pl2.adicionaMusica("Musica1");
	//
	//
	// Assert.assertTrue("Erro aquew no 1 teste", pl1.equals(pl2));
	// }

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

	// @Test
	// public void testaMetodosAcessores() {
	// Assert.assertEquals("", "", );
	// }

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
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1", p1.pesquisaMusica(0));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1", p1.pesquisaMusica(-1));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 1", p1.pesquisaMusica(10));
		
		p1.adicionaMusica("Musica0");
		p1.adicionaMusica("Musica1", 0);
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 1", "Musica1", p1.pesquisaMusica(0));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 1", "Musica0", p1.pesquisaMusica(1));
		
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2", p2.pesquisaMusica(-1));
		Assert.assertNull("Erro em pesquisaMusica playlistDinamica 2", p2.pesquisaMusica(10));
		
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2", "Faint", p2.pesquisaMusica(0));
		p2.adicionaMusica("Musica0");
		p2.adicionaMusica("Musica1", 0);
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2", "Musica1", p2.pesquisaMusica(0));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2", "Faint", p2.pesquisaMusica(1));
		Assert.assertEquals("Erro em pesquisaMusica playlistDinamica 2", "Musica0", p2.pesquisaMusica(2));
	}

	@Test
	public void testaContemMusica() {

	}

	@Test
	public void testaRemoveMusica() {

	}

	@Test
	public void numeroDeMusicas() {

	}

	@Test
	public void testaToString() {

	}

	@Test
	public void testaEquals() {

	}
}
