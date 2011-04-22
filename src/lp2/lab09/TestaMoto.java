package lp2.lab09;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TestaMoto {
	Moto moto;

	@Before
	public void criaMoto() {
		moto = new Moto();
	}

	@Test
	public void testaConstrutor() {
		Assert.assertTrue("Erro no Contrutor de Moto", moto.consertosPassados()
				.isEmpty());
	}

	@Test
	public void testaAdicionaVerificacao() {
		moto.verificacoes().clear();
		moto.adicionaVerificacao(Verificacao.OLEO);
		moto.adicionaVerificacao(Verificacao.PNEUS);
		Assert.assertEquals("Erro em adicionaVerificacao()", 2, moto
				.verificacoes().size());
		Assert.assertEquals("Erro em adicionaVerificacao()", Verificacao.OLEO,
				moto.verificacoes().get(0));
		Assert.assertEquals("Erro em adicionaVerificacao()", Verificacao.PNEUS,
				moto.verificacoes().get(1));
	}

	@Test
	public void testaConsertar() {
		moto.verificacoes().clear();
		moto.adicionaVerificacao(Verificacao.OLEO);
		moto.adicionaVerificacao(Verificacao.PNEUS);

		Assert.assertEquals("Erro em consertar()", Verificacao.OLEO, moto
				.verificacoes().get(0));
		moto.consertar(Verificacao.OLEO);
		Assert.assertEquals("Erro em consertar()", Verificacao.PNEUS, moto
				.verificacoes().get(0));
		moto.consertar(Verificacao.PNEUS);
		Assert.assertEquals("Erro em consertar()", 0, moto.verificacoes()
				.size());
	}

	@Test
	public void testaTrocarPneus_ChecaPneuAvariado() {
		int cont = 0;
		for(int i=0; i<2; i++){
			if(moto.checaPneuAvariado(i)){
				cont++;
			}
		}
		Assert.assertEquals("Erro em trocarPneus()", cont, moto.trocarPneus());
	}

}
