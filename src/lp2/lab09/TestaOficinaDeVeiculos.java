package lp2.lab09;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestaOficinaDeVeiculos {
	OficinaDeVeiculos oficina;
	Moto moto;
	Carro carro;
	
	@Before
	public void criaOficina(){
		oficina = new OficinaDeVeiculos();
		moto = new Moto();
		carro = new Carro();
	}
	
	@Test
	public void testaRecebeVeiculo_Proximo(){
		
		
		oficina.recebeVeiculo(moto);
		oficina.recebeVeiculo(carro);
		
		Assert.assertEquals("Erro em recebeVeiculo() e em proximo()", moto, oficina.proximo());
		Assert.assertEquals("Erro em recebeVeiculo() e em proximo()", carro, oficina.proximo());
		Assert.assertNull("Erro em proximo()", oficina.proximo());
	}
	
	@Test
	public void testaManutencao_ManutencaoPersonalizada(){
		int diferenca;
		
		oficina.recebeVeiculo(moto);
		oficina.recebeVeiculo(carro);
		
		diferenca = moto.verificacoes().size();
		oficina.manutencao();
		Assert.assertTrue("Erro em manutencao", (diferenca != moto.verificacoes().size()));
		
		diferenca = carro.verificacoes().size();
		oficina.manutencaoPersonalizada();
		Assert.assertTrue("Erro em manutencao()", (diferenca != carro.verificacoes().size()));
	}
	
	@Test
	public void testaEntregaVeiculo(){
		
		oficina.recebeVeiculo(moto);
		oficina.recebeVeiculo(carro);
		
		Assert.assertNull("Erro em entregaVeiculo()", oficina.entrega(moto));
		oficina.manutencao();
		Assert.assertEquals("Erro em entregaVeiculo()", moto, oficina.entrega(moto));
		
		Assert.assertNull("Erro em entregaVeiculo()", oficina.entrega(carro));
		oficina.manutencaoPersonalizada();
		Assert.assertEquals("Erro em entregaVeiculo()", carro, oficina.entrega(carro));
	}

}
