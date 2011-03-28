package lp2.lab06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestaPlaylistDinamica {

	PlaylistDinamica p1, p2;
	
	@Before
	public void criaPlaylistsDinamicas(){
		p1 = new PlaylistDinamica("PlaylistDinamica 1", "Jordao");
		p2 = new PlaylistDinamica("PlaylistDinamica 2", "Jordao", "Faint");
	}
	
	@Test
	public void testaToString() throws Exception{
		p1.adicionaMusica("Musica1");
		p1.adicionaMusica("Musica2");
		
		try{
			p1.adicionaMusica("Musica0", -1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
	
	@Test
	public void testaEquals(){
		PlaylistDinamica pl1 = new PlaylistDinamica("Playlist1","Jordao","Musica0");
		PlaylistDinamica pl2 = new PlaylistDinamica("Playlist1","Jordao","Musica0");
		
		System.out.println("ok");
		
		Assert.assertTrue("Erro aquew no 1 teste", pl1.equals(pl2));
		
		System.out.println("ok");
		
		pl1.adicionaMusica("Musica1");
		pl2.adicionaMusica("Musica1");
		
		
		Assert.assertTrue("Erro aquew no 1 teste", pl1.equals(pl2));
	}
}
