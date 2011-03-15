package lp2.lab04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaProgressaoAritmetica{
	ProgressaoAritmetica pa1, pa2, pa3;

	@Before
	public void criaPAs() {
		pa1 = new ProgressaoAritmetica(25, -4);
		pa2 = new ProgressaoAritmetica(0, 0);
		pa3 = new ProgressaoAritmetica(-25, 4);
	}

	@Test
	public void testaImprime() {

		Assert.assertEquals("Erro em imprime da pa1", "[25]", pa1.imprime(-1));
		Assert.assertEquals("Erro em imprime da pa1", "[25]", pa1.imprime(0));

 		Assert.assertEquals("Erro em imprime da pa1", 21, pa1.proximo());
			
		Assert.assertEquals("Erro em imprime da pa2", "[0]", pa2.imprime(1));
		Assert.assertEquals("Erro em imprime da pa2", 0, pa2.proximo());
			
		Assert.assertEquals("Erro em imprime da pa3", "[-25]", pa3.imprime(1));
		Assert.assertEquals("Erro em imprime da pa3", -21, pa3.proximo());
			
		Assert.assertEquals("Erro em imprime da pa1", "[25, 21, 17]", pa1.imprime(3));
		Assert.assertEquals("Erro em imprime da pa1", 13, pa1.proximo());
			
		Assert.assertEquals("Erro em imprime da pa1", "[0, 0, 0]", pa2.imprime(3));
		Assert.assertEquals("Erro em imprime da pa2", 0, pa2.proximo());
			
		Assert.assertEquals("Erro em imprime da pa1", "[-25, -21, -17]", pa3.imprime(3));
		Assert.assertEquals("Erro em imprime da pa3", -13, pa3.proximo());

	}

	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Primeiro da pa1 termo errado.", 25, pa1.primeiro());
		Assert.assertEquals("Razao da pa1 errada.", -4, pa1.proximo() - pa1.primeiro());
		
		Assert.assertEquals("Primeiro termo da pa2 errado.", 0, pa2.primeiro());
		Assert.assertEquals("Razao da pa2 errada.", 0, pa2.proximo() - pa2.primeiro());

		Assert.assertEquals("Primeiro termo da pa3 errado.", -25, pa3.primeiro());
		Assert.assertEquals("Razao da pa3 errada.", 4, pa3.proximo() - pa3.primeiro());
	}

	@Test
	public void testaPrimeiro() {
		Assert.assertEquals("Primeiro elemento de pa1 errado", 25, pa1.primeiro());
		Assert.assertEquals("Primeiro elemento de pa2 errado", 0, pa2.primeiro());
		Assert.assertEquals("Primeiro elemento de pa3 errado", -25, pa3.primeiro());
		for (int i = 0; i < 10; i++) {
			pa1.proximo();
			pa2.proximo();
			pa3.proximo();			
		}
		Assert.assertEquals("Primeiro elemento de pa1 errado", 25, pa1.primeiro());
		Assert.assertEquals("Primeiro elemento de pa2 errado", 0, pa2.primeiro());
		Assert.assertEquals("Primeiro elemento de pa3 errado", -25, pa3.primeiro());
	}

	@Test
	public void testaProximo() {
		int proximo1 = pa1.primeiro();
		int proximo2 = pa2.primeiro();
		int proximo3 = pa3.primeiro();
		
		for (int i = 0; i < 100; i++) {
			proximo1 -= 4;
			proximo2 += 0;
			proximo3 += 4;
			
			Assert.assertEquals("Erro no metodo testProximo, Progressao(25,-4), " + (i + 1)	+ "chamada(s)", proximo1, pa1.proximo());
			Assert.assertEquals("Erro no metodo testProximo, Progressao(0,0), "+ (i + 1) + " chamada(s)", proximo2, pa2.proximo());
			Assert.assertEquals("Erro no metodo testProximo, Progressao(-25,4), " + (i + 1)	+ " chamada(s)", proximo3, pa3.proximo());
		}

	}
}
