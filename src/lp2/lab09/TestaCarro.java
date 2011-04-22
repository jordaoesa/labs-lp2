package lp2.lab09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestaCarro {
	Carro carro;
	
	@Before
	public void criaCarro(){
		carro = new Carro();
	}
	
	@Test
	public void testaConstrutor() {
		Assert.assertTrue("Erro no Contrutor de Moto", carro.consertosPassados()
				.isEmpty());
	}

	@Test
	public void testaAdicionaVerificacao() {
		carro.verificacoes().clear();
		carro.adicionaVerificacao(Verificacao.OLEO);
		carro.adicionaVerificacao(Verificacao.PNEUS);
		
		Assert.assertEquals("Erro em adicionaVerificacao()", 2, carro
				.verificacoes().size());
		Assert.assertEquals("Erro em adicionaVerificacao()", Verificacao.OLEO,
				carro.verificacoes().get(0));
		Assert.assertEquals("Erro em adicionaVerificacao()", Verificacao.PNEUS,
				carro.verificacoes().get(1));
	}

	@Test
	public void testaConsertar() {
		carro.verificacoes().clear();
		carro.adicionaVerificacao(Verificacao.OLEO);
		carro.adicionaVerificacao(Verificacao.PNEUS);

		Assert.assertEquals("Erro em consertar()", Verificacao.OLEO, carro
				.verificacoes().get(0));
		carro.consertar(Verificacao.OLEO);
		Assert.assertEquals("Erro em consertar()", Verificacao.PNEUS, carro
				.verificacoes().get(0));
		carro.consertar(Verificacao.PNEUS);
		Assert.assertEquals("Erro em consertar()", 0, carro.verificacoes()
				.size());
	}

	@Test
	public void testaTrocarPneus_ChecaPneuAvariado() {
		int cont = 0;
		for(int i=0; i<4; i++){
			if(carro.checaPneuAvariado(i)){
				cont++;
			}
		}
		Assert.assertEquals("Erro em trocarPneus()", cont, carro.trocarPneus());
	}
}
