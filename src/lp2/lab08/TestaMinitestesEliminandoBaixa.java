package lp2.lab08;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Conjunto de testes para a class MinitesteEliminandoMaisBaixa.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaMinitestesEliminandoBaixa {
	MinitestesEliminandoBaixa minitElimBai_1, minitElimBai_2;

	/**
	 * Instancia 2 disciplinas MinitestesEliminandoBaixa.
	 */
	@Before
	public void iniciaDisciplinaConvencional() {
		List<String> pos = new ArrayList<String>();
		List<String> pos1 = new ArrayList<String>();
		pos1.add("Disciplina 3");
		pos1.add("Disciplina 4");
		pos1.add("Disciplina 5");

		minitElimBai_1 = new MinitestesEliminandoBaixa("Disciplina 1", 5, pos,
				1);
		minitElimBai_2 = new MinitestesEliminandoBaixa("Disciplina 2", 10,
				pos1, 2);
	}

	/**
	 * Conjunto de testes para o Construtor.
	 */
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Erro no Contrutor.", "Disciplina 1",
				minitElimBai_1.getNome());
		Assert.assertEquals("Erro no Contrutor.", 5,
				minitElimBai_1.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 0, minitElimBai_1
				.getPosRequisitos().size());
		Assert.assertEquals("Erro no Contrutor.", 1,
				minitElimBai_1.getQtdMinitestesAEliminar());

		Assert.assertEquals("Erro no Contrutor.", "Disciplina 2",
				minitElimBai_2.getNome());
		Assert.assertEquals("Erro no Contrutor.", 10,
				minitElimBai_2.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 3, minitElimBai_2
				.getPosRequisitos().size());
		Assert.assertEquals("Erro no Contrutor.", 2,
				minitElimBai_2.getQtdMinitestesAEliminar());

		Assert.assertTrue(minitElimBai_2.getPosRequisitos().contains(
				"Disciplina 3"));
		Assert.assertTrue(minitElimBai_2.getPosRequisitos().contains(
				"Disciplina 4"));
		Assert.assertTrue(minitElimBai_2.getPosRequisitos().contains(
				"Disciplina 5"));
	}

	/**
	 * Conjunto de testes para o metodo adicionaNota().
	 * 
	 * @throws Exception
	 *             Excecao retornada pelo adicionaNota().
	 */
	@Test
	public void testaAdicionaNota() throws Exception {
		minitElimBai_1.adicionaNota(0.0);
		try {
			minitElimBai_1.adicionaNota(-1.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}
		try {
			minitElimBai_1.adicionaNota(11.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}

		minitElimBai_2.adicionaNota(1.0);
		minitElimBai_2.adicionaNota(2.0);
		minitElimBai_2.adicionaNota(3.0);
		minitElimBai_2.adicionaNota(4.0);
		minitElimBai_2.adicionaNota(5.0);
		minitElimBai_2.adicionaNota(6.0);
		minitElimBai_2.adicionaNota(7.0);
		minitElimBai_2.adicionaNota(8.0);
		minitElimBai_2.adicionaNota(9.0);
		minitElimBai_2.adicionaNota(10.0);
		try {
			minitElimBai_2.adicionaNota(10.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro em adicionaNota()",
					"Quantidade de provas atingida.", e.getMessage());
		}

	}

	/**
	 * Conjunto de testes para o getMediaAtual().
	 * 
	 * @throws Exception
	 *             Excecao retornada pelo getMediaAtual().
	 */
	@Test
	public void testaGetMediaAtual() throws Exception {
		Assert.assertEquals("Erro no getMediaAtual()", 0.0,
				minitElimBai_1.getMediaAtual(), 0.05);
		minitElimBai_1.setQtdProvasJaRealizadas(5);
		minitElimBai_1.adicionaNota(1.0);
		minitElimBai_1.adicionaNota(2.0);
		minitElimBai_1.adicionaNota(3.0);
		// Adicao de duas faltas, pois houve 5 minitestes e so foram feitos 3.
		minitElimBai_1.adicionaFalta();
		try {
			minitElimBai_1.adicionaFalta();
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}
		Assert.assertEquals("Erro no getMediaAtual()", 2,
				minitElimBai_1.getMediaAtual(), 0.05);

		Assert.assertEquals("Erro no getMediaAtual()", 0.0,
				minitElimBai_2.getMediaAtual(), 0.05);
		minitElimBai_2.setQtdProvasJaRealizadas(7);
		minitElimBai_2.adicionaNota(10.0);
		minitElimBai_2.adicionaNota(5.0);

		// Adicao de 5 faltas, pois houve 7 minitestes e so foram feitos 5
		minitElimBai_2.adicionaFalta();
		minitElimBai_2.adicionaFalta();
		try {
			minitElimBai_2.adicionaFalta();
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}
		try {
			minitElimBai_2.adicionaFalta();
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}
		try {
			minitElimBai_2.adicionaFalta();
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}
		Assert.assertEquals("Erro no getMediaAtual()", 5,
				minitElimBai_2.getMediaAtual(), 0.05);
	}

	/**
	 * Conjunto de testes para o adicionaFalta().
	 * 
	 * @throws Exception
	 *             Excecao retornada pelo adicionaFalta().
	 */
	@Test
	public void testaAdicionaFalta() throws Exception {

		minitElimBai_1.adicionaFalta();
		try {
			minitElimBai_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			minitElimBai_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, minitElimBai_1
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 1,
				minitElimBai_1.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, minitElimBai_1
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, minitElimBai_1
				.getNotas().get(1), 0.05);

		minitElimBai_2.adicionaFalta();
		minitElimBai_2.adicionaFalta();
		try {
			minitElimBai_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			minitElimBai_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, minitElimBai_2
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 2,
				minitElimBai_2.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, minitElimBai_2
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, minitElimBai_2
				.getNotas().get(1), 0.05);
	}

	/**
	 * Conjunto de testes para o metodo getMensagem().
	 */
	@Test
	public void testaGetMensagem() {
		Assert.assertEquals(
				"Erro no getMensagem()",
				"Disciplina 1 eh avaliada com 5 minitestes, eliminando 1 dos mais baixos.",
				minitElimBai_1.getMensagem());
		Assert.assertEquals(
				"Erro no getMensagem()",
				"Disciplina 2 eh avaliada com 10 minitestes, eliminando 2 dos mais baixos.",
				minitElimBai_2.getMensagem());
	}

	/**
	 * Conjunto de testes extras para gets e sets.
	 */
	@Test
	public void testesExtras() {
		minitElimBai_1.setNome("Disc 1");
		Assert.assertEquals("Erro em setNome()", "Disc 1",
				minitElimBai_1.getNome());
		minitElimBai_1.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				minitElimBai_1.getQtdProvas());
		minitElimBai_1.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				minitElimBai_1.getQtdMinitestesJaRealizados());
		minitElimBai_1.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				minitElimBai_1.getQtdFaltas());
		minitElimBai_1.setQtdMinitestesAEliminar(4);
		Assert.assertEquals("Erro em setQtdProvasAEliminar()", 4,
				minitElimBai_1.getQtdMinitestesAEliminar());

		minitElimBai_2.setNome("Disc 2");
		Assert.assertEquals("Erro em setNome()", "Disc 2",
				minitElimBai_2.getNome());
		minitElimBai_2.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				minitElimBai_2.getQtdProvas());
		minitElimBai_2.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				minitElimBai_2.getQtdMinitestesJaRealizados());
		minitElimBai_2.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				minitElimBai_2.getQtdFaltas());
		minitElimBai_2.setQtdMinitestesAEliminar(2);
		Assert.assertEquals("Erro em setQtdProvasAEliminar()", 2,
				minitElimBai_2.getQtdMinitestesAEliminar());

	}

}
