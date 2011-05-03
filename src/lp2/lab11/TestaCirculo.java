package lp2.lab11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaCirculo {
	Circulo circulo1;
	Circulo circulo2;
	Circulo circulo3;

	@Before
	public void iniciaCirculo() throws Exception {
		try {
			circulo1 = new Circulo(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			circulo2 = new Circulo(12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Erro em Construtor Circulo.", 10,
				circulo1.getRaio(), 0.005);
		Assert.assertEquals("Erro em Construtor Circulo.", 12,
				circulo2.getRaio(), 0.005);
		try {
			circulo3 = new Circulo(0);
		} catch (Exception e) {
			Assert.assertEquals("Erro no Construtor", "Raio invalido.", e.getMessage());
		}
	}

	@Test
	public void testaCalcularArea() {
		Assert.assertEquals("Erro em calcularArea() Circulo.",
				(Math.PI * 10 * 10), circulo1.calcularArea(), 0.005);
		Assert.assertEquals("Erro em calcularArea() Circulo.",
				(Math.PI * 12 * 12), circulo2.calcularArea(), 0.005);
	}

	@Test
	public void testaCalcularPerimetro() {
		Assert.assertEquals("Erro em calcularPerimetro().", (Math.PI*2*10), circulo1.calcularPerimetro(), 0.005);
		Assert.assertEquals("Erro em calcularPerimetro().", (Math.PI*2*12), circulo2.calcularPerimetro(), 0.005);
	}

	@Test
	public void testaCompareTo() {
		int retorno = circulo2.compareTo(circulo1);
		int retorno2 = circulo1.compareTo(circulo2);

		// Circulo 1 Maior que Circulo 2
		Assert.assertTrue("Erro no compareTo() Circulo.", (retorno > 0));
		// Circulo 2 Maior que Circulo 1
		Assert.assertTrue("Erro no compareTo() Circulo.", (retorno2 < 0));
	}
}
