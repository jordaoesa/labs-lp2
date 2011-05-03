package lp2.lab11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaQuadrado {
	Quadrado quadrado1;
	Quadrado quadrado2;
	Quadrado quadrado3;

	@Before
	public void iniciaQuadrado() throws Exception {
		try {
			quadrado1 = new Quadrado(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			quadrado2 = new Quadrado(12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Erro em Construtor Quadrado.", 10,
				quadrado1.getLado());
		Assert.assertEquals("Erro em Construtor Quadrado.", 12,
				quadrado2.getLado());
		try {
			quadrado3 = new Quadrado(0);
		} catch (Exception e) {
			Assert.assertEquals("Erro no Construtor", "Lado invalido.", e.getMessage());
		}
	}

	@Test
	public void testaCalcularArea() {
		Assert.assertEquals("Erro em calcularArea() Quadrado.",
				(10 * 10), quadrado1.calcularArea(), 0.005);
		Assert.assertEquals("Erro em calcularArea() Quadrado.",
				(12 * 12), quadrado2.calcularArea(), 0.005);
	}

	@Test
	public void testaCalcularPerimetro() {
		Assert.assertEquals("Erro em calcularPerimetro() Quadrado.", (4*10), quadrado1.calcularPerimetro(), 0.005);
		Assert.assertEquals("Erro em calcularPerimetro() Quadrado.", (4*12), quadrado2.calcularPerimetro(), 0.005);
	}

	@Test
	public void testaCompareTo() {
		int retorno = quadrado2.compareTo(quadrado1);
		int retorno2 = quadrado1.compareTo(quadrado2);

		// Circulo 1 Maior que Circulo 2
		Assert.assertTrue("Erro no compareTo() Quadrado.", (retorno > 0));
		// Circulo 2 Maior que Circulo 1
		Assert.assertTrue("Erro no compareTo() Quadrado.", (retorno2 < 0));
	}
}
