package lp2.lab05;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/* 
 * Aluno: Jordao Ezequiel Serafim de Araujo 
 * Matricula: 21021526
 * 
 */

/**
 * Varios testes para os metodos presentes na classe ProgressaoGeometrica.
 * 
 * @author jordaoesa
 * 
 */
public class TestaProgressaoGeometrica {
	ProgressaoGeometrica pg1, pg2, pg3;

	/**
	 * Responsavel pela instanciacao de algumas PGs.
	 */
	@Before
	public void criaPGs() {
		pg1 = new ProgressaoGeometrica(1, 2);
		pg2 = new ProgressaoGeometrica(25, -4);
		pg3 = new ProgressaoGeometrica(10, 5);
	}

	/**
	 * Responsavel por fazer os testes do metodo imprime da classe
	 * ProgressaoGeometrica.
	 * 
	 * @throws Exception
	 *             Excecao retornada caso o numero passado para o metodo imprime
	 *             seja menor ou igual a zero.
	 */
	@Test
	public void testaImprime() throws Exception {
		Assert.assertEquals("Erro em imprime da pg1", "[1]", pg1.imprime(1));
		Assert.assertEquals("Erro em imprime da pg1", "[1, 2, 4]",
				pg1.imprime(3));
		Assert.assertEquals("Erro em imprime da pg1", "[1, 2, 4, 8]",
				pg1.imprime(4));
		Assert.assertEquals("Erro em imprime da pg1", "[1, 2, 4, 8, 16]",
				pg1.imprime(5));

		Assert.assertEquals("Erro em imprime da pg2", "[25]", pg2.imprime(1));
		Assert.assertEquals("Erro em imprime da pg2", "[25, -100, 400]",
				pg2.imprime(3));
		Assert.assertEquals("Erro em imprime da pg2", "[25, -100, 400, -1600]",
				pg2.imprime(4));
		Assert.assertEquals("Erro em imprime da pg2",
				"[25, -100, 400, -1600, 6400]", pg2.imprime(5));

		Assert.assertEquals("Erro em imprime da pg3", "[10]", pg3.imprime(1));
		Assert.assertEquals("Erro em imprime da pg3", "[10, 50, 250]",
				pg3.imprime(3));
		Assert.assertEquals("Erro em imprime da pg3", "[10, 50, 250, 1250]",
				pg3.imprime(4));
		Assert.assertEquals("Erro em imprime da pg3",
				"[10, 50, 250, 1250, 6250]", pg3.imprime(5));

		// Testando excecoes pg1
		try {
			Assert.assertEquals("Erro em imprime da pg1", "[1]", pg1.imprime(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg1",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em imprime da pg1", "[1]",
					pg1.imprime(-1));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg1",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		// Testando excecoes pg2
		try {
			Assert.assertEquals("Erro em imprime da pg2", "[25]",
					pg2.imprime(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg2",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em imprime da pg2", "[25]",
					pg2.imprime(-1));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg2",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		// Testando excecoes pg3
		try {
			Assert.assertEquals("Erro em imprime da pg3", "[10]",
					pg3.imprime(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg3",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em imprime da pg3", "[10]",
					pg3.imprime(-1));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em imprime da pg3",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}
	}

	/**
	 * Testa se o construtor esta, realmente, definindo o primeiro termo da PG e
	 * a razao corretos.
	 */
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Primeiro da pg1 termo errado.", 1, pg1.primeiro());
		Assert.assertEquals("Razao da pg1 errada.", 2,
				pg1.proximo() / pg1.primeiro());

		Assert.assertEquals("Primeiro termo da pg2 errado.", 25, pg2.primeiro());
		Assert.assertEquals("Razao da pg2 errada.", -4,
				pg2.proximo() / pg2.primeiro());

		Assert.assertEquals("Primeiro termo da pg3 errado.", 10, pg3.primeiro());
		Assert.assertEquals("Razao da pg3 errada.", 5,
				pg3.proximo() / pg3.primeiro());
	}

	/**
	 * Testa se o metodo "primeiro" da classe ProgressaoGeometrica esta
	 * funcionando corretamente.
	 */
	@Test
	public void testaPrimeiro() {
		Assert.assertEquals("Erro em primeiro da pg1", 1, pg1.primeiro());
		Assert.assertEquals("Erro em primeiro da pg2", 25, pg2.primeiro());
		Assert.assertEquals("Erro em primeiro da pg3", 10, pg3.primeiro());
		for (int i = 0; i < 10; i++) {
			pg1.proximo();
			pg2.proximo();
			pg3.proximo();
		}
		Assert.assertEquals("Erro em primeiro da pg1", 1, pg1.primeiro());
		Assert.assertEquals("Erro em primeiro da pg2", 25, pg2.primeiro());
		Assert.assertEquals("Erro em primeiro da pg3", 10, pg3.primeiro());
	}

	/**
	 * Testa varios casos para o metodo "proximo" da classe
	 * ProgressaoGeometrica.
	 */
	@Test
	public void testaProximo() {

		int proximo1 = pg1.primeiro();
		int proximo2 = pg2.primeiro();
		int proximo3 = pg3.primeiro();

		for (int i = 0; i < 11; i++) { // Coloquei o intervalo de 0 a 11 porque
										// da estouro. (declarei as variaveis
										// como sendo do tipo int)
			proximo1 *= 2;
			proximo2 *= -4;
			proximo3 *= 5;

			Assert.assertEquals(
					"Erro no metodo proximo, Progressao(25,-4), " + (i + 1)
							+ "chamada(s)", proximo1, pg1.proximo());
			Assert.assertEquals("Erro no metodo proximo, Progressao(0,0), "
					+ (i + 1) + " chamada(s)", proximo2, pg2.proximo());
			Assert.assertEquals(
					"Erro no metodo proximo, Progressao(-25,4), " + (i + 1)
							+ " chamada(s)", proximo3, pg3.proximo());
		}
	}

	/**
	 * Testes para o metodo "termo" da classe ProgressaoGeometrica.
	 * 
	 * @throws Exception
	 *             Excecao retornada caso o numero passado para o metodo termo
	 *             seja menor ou igual a zero.
	 */
	@Test
	public void testaTermo() throws Exception {
		Assert.assertEquals("Erro em termo da pg1", 1, pg1.termo(1));
		Assert.assertEquals("Erro em termo da pg1", 2, pg1.termo(2));
		Assert.assertEquals("Erro em termo da pg1", 4, pg1.termo(3));

		Assert.assertEquals("Erro em termo da pg2", 25, pg2.termo(1));
		Assert.assertEquals("Erro em termo da pg2", -100, pg2.termo(2));
		Assert.assertEquals("Erro em termo da pg2", 400, pg2.termo(3));

		Assert.assertEquals("Erro em termo da pg3", 10, pg3.termo(1));
		Assert.assertEquals("Erro em termo da pg3", 50, pg3.termo(2));
		Assert.assertEquals("Erro em termo da pg3", 250, pg3.termo(3));

		// Testando excecoes pg1
		try {
			Assert.assertEquals("Erro em termo da pg1", 1, pg1.termo(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg1",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em termo da pg1", 1, pg1.termo(-1));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg1",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		// Testando excecoes pg2
		try {
			Assert.assertEquals("Erro em termo da pg2", 1, pg2.termo(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg2",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em termo da pg2", 1, pg2.termo(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg2",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		// Testando excecoes pg3
		try {
			Assert.assertEquals("Erro em termo da pg3", 1, pg3.termo(0));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg3",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}

		try {
			Assert.assertEquals("Erro em termo da pg3", 1, pg3.termo(-1));
			Assert.fail("Deveria ter retornado a excecao de Numero invalido.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em termo da pg3",
					"Numero invalido. Digite valores maiores que zero.",
					e.getMessage());
		}
	}

}
