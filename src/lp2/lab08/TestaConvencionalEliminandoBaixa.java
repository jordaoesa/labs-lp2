package lp2.lab08;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Conjunto de testes para a class ConvencionalEliminandoMaisBaixa.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaConvencionalEliminandoBaixa {
	ConvencionalEliminandoBaixa convenElimBai_1, convenElimBai_2;

	/**
	 * Instancia 2 disciplinas ConvencionalEliminandoBaixa.
	 */
	@Before
	public void iniciaDisciplinaConvencional() {
		List<String> pos = new ArrayList<String>();
		List<String> pos1 = new ArrayList<String>();
		pos1.add("Disciplina 3");
		pos1.add("Disciplina 4");
		pos1.add("Disciplina 5");

		convenElimBai_1 = new ConvencionalEliminandoBaixa("Disciplina 1", 5,
				pos, 1);
		convenElimBai_2 = new ConvencionalEliminandoBaixa("Disciplina 2", 10,
				pos1, 2);
	}

	/**
	 * Conjunto de testes para o Construtor.
	 */
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Erro no Contrutor.", "Disciplina 1",
				convenElimBai_1.getNome());
		Assert.assertEquals("Erro no Contrutor.", 5,
				convenElimBai_1.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 0, convenElimBai_1
				.getPosRequisitos().size());
		Assert.assertEquals("Erro no Contrutor.", 1,
				convenElimBai_1.getQtdProvasAEliminar());

		Assert.assertEquals("Erro no Contrutor.", "Disciplina 2",
				convenElimBai_2.getNome());
		Assert.assertEquals("Erro no Contrutor.", 10,
				convenElimBai_2.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 3, convenElimBai_2
				.getPosRequisitos().size());
		Assert.assertEquals("Erro no Contrutor.", 2,
				convenElimBai_2.getQtdProvasAEliminar());

		Assert.assertTrue(convenElimBai_2.getPosRequisitos().contains(
				"Disciplina 3"));
		Assert.assertTrue(convenElimBai_2.getPosRequisitos().contains(
				"Disciplina 4"));
		Assert.assertTrue(convenElimBai_2.getPosRequisitos().contains(
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
		convenElimBai_1.adicionaNota(0.0);
		try {
			convenElimBai_1.adicionaNota(-1.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}
		try {
			convenElimBai_1.adicionaNota(11.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}

		convenElimBai_2.adicionaNota(1.0);
		convenElimBai_2.adicionaNota(2.0);
		convenElimBai_2.adicionaNota(3.0);
		convenElimBai_2.adicionaNota(4.0);
		convenElimBai_2.adicionaNota(5.0);
		convenElimBai_2.adicionaNota(6.0);
		convenElimBai_2.adicionaNota(7.0);
		convenElimBai_2.adicionaNota(8.0);
		convenElimBai_2.adicionaNota(9.0);
		convenElimBai_2.adicionaNota(10.0);
		try {
			convenElimBai_2.adicionaNota(10.0);
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
				convenElimBai_1.getMediaAtual(), 0.05);
		convenElimBai_1.setQtdProvasJaRealizadas(5);
		convenElimBai_1.adicionaNota(1.0);
		convenElimBai_1.adicionaNota(2.0);
		convenElimBai_1.adicionaNota(3.0);
		Assert.assertEquals("Erro no getMediaAtual()", 1.5,
				convenElimBai_1.getMediaAtual(), 0.05);

		Assert.assertEquals("Erro no getMediaAtual()", 0.0,
				convenElimBai_2.getMediaAtual(), 0.05);
		convenElimBai_2.setQtdProvasJaRealizadas(7);
		convenElimBai_2.adicionaNota(10.0);
		convenElimBai_2.adicionaNota(5.0);
		Assert.assertEquals("Erro no getMediaAtual()", 3,
				convenElimBai_2.getMediaAtual(), 0.05);
		convenElimBai_2.adicionaNota(10.0);
		convenElimBai_2.adicionaNota(10.0);
		convenElimBai_2.adicionaNota(10.0);
		Assert.assertEquals("Erro no getMediaAtual()", 9.0,
				convenElimBai_2.getMediaAtual(), 0.05);
		convenElimBai_2.adicionaNota(4.0);
		Assert.assertEquals("Erro no getMediaAtual()", 9.0,
				convenElimBai_2.getMediaAtual(), 0.05);
	}

	/**
	 * Conjunto de testes para o adicionaFalta().
	 * 
	 * @throws Exception
	 *             Excecao retornada pelo adicionaFalta().
	 */
	@Test
	public void testaAdicionaFalta() throws Exception {

		try {
			convenElimBai_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			convenElimBai_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, convenElimBai_1
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 0,
				convenElimBai_1.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convenElimBai_1
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convenElimBai_1
				.getNotas().get(1), 0.05);

		try {
			convenElimBai_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			convenElimBai_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, convenElimBai_2
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 0,
				convenElimBai_2.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convenElimBai_2
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convenElimBai_2
				.getNotas().get(1), 0.05);
	}

	/**
	 * Conjunto de testes para o metodo getMensagem().
	 */
	@Test
	public void testaGetMensagem() {
		Assert.assertEquals(
				"Erro no getMensagem()",
				"Disciplina 1 eh avaliada com 5 provas, eliminando 1 das mais baixas.",
				convenElimBai_1.getMensagem());
		Assert.assertEquals(
				"Erro no getMensagem()",
				"Disciplina 2 eh avaliada com 10 provas, eliminando 2 das mais baixas.",
				convenElimBai_2.getMensagem());
	}

	/**
	 * Conjunto de testes extras para gets e sets.
	 */
	@Test
	public void testesExtras() {
		convenElimBai_1.setNome("Disc 1");
		Assert.assertEquals("Erro em setNome()", "Disc 1",
				convenElimBai_1.getNome());
		convenElimBai_1.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				convenElimBai_1.getQtdProvas());
		convenElimBai_1.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				convenElimBai_1.getQtdProvasJaRealizadas());
		convenElimBai_1.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				convenElimBai_1.getQtdFaltas());
		convenElimBai_1.setQtdProvasAEliminar(4);
		Assert.assertEquals("Erro em setQtdProvasAEliminar()", 4,
				convenElimBai_1.getQtdProvasAEliminar());

		convenElimBai_2.setNome("Disc 2");
		Assert.assertEquals("Erro em setNome()", "Disc 2",
				convenElimBai_2.getNome());
		convenElimBai_2.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				convenElimBai_2.getQtdProvas());
		convenElimBai_2.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				convenElimBai_2.getQtdProvasJaRealizadas());
		convenElimBai_2.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				convenElimBai_2.getQtdFaltas());
		convenElimBai_2.setQtdProvasAEliminar(2);
		Assert.assertEquals("Erro em setQtdProvasAEliminar()", 2,
				convenElimBai_2.getQtdProvasAEliminar());

	}

}
