package lp2.lab08;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Conjunto de testes para a class Convencional.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaConvencional {
	Convencional convencional_1, convencional_2;

	/**
	 * Instancia 2 disciplinas Convencional.
	 */
	@Before
	public void iniciaDisciplinaConvencional() {
		List<String> pos = new ArrayList<String>();
		List<String> pos1 = new ArrayList<String>();
		pos1.add("Disciplina 3");
		pos1.add("Disciplina 4");
		pos1.add("Disciplina 5");

		convencional_1 = new Convencional("Disciplina 1", 5, pos);
		convencional_2 = new Convencional("Disciplina 2", 6, pos1);
	}

	/**
	 * Conjunto de testes para o Construtor.
	 */
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Erro no Contrutor.", "Disciplina 1",
				convencional_1.getNome());
		Assert.assertEquals("Erro no Contrutor.", 5,
				convencional_1.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 0, convencional_1
				.getPosRequisitos().size());

		Assert.assertEquals("Erro no Contrutor.", "Disciplina 2",
				convencional_2.getNome());
		Assert.assertEquals("Erro no Contrutor.", 6,
				convencional_2.getQtdProvas());
		Assert.assertEquals("Erro no Contrutor.", 3, convencional_2
				.getPosRequisitos().size());

		Assert.assertTrue(convencional_2.getPosRequisitos().contains(
				"Disciplina 3"));
		Assert.assertTrue(convencional_2.getPosRequisitos().contains(
				"Disciplina 4"));
		Assert.assertTrue(convencional_2.getPosRequisitos().contains(
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
		convencional_1.adicionaNota(0.0);
		try {
			convencional_1.adicionaNota(-1.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}
		try {
			convencional_1.adicionaNota(11.0);
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaNota()", "Nota invalida.",
					e.getMessage());
		}

		convencional_2.adicionaNota(1.0);
		convencional_2.adicionaNota(2.0);
		convencional_2.adicionaNota(3.0);
		convencional_2.adicionaNota(4.0);
		convencional_2.adicionaNota(5.0);
		convencional_2.adicionaNota(6.0);
		try {
			convencional_2.adicionaNota(7.0);
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
				convencional_1.getMediaAtual(), 0.05);
		convencional_1.setQtdProvasJaRealizadas(5);
		convencional_1.adicionaNota(1.0);
		convencional_1.adicionaNota(2.0);
		convencional_1.adicionaNota(3.0);
		Assert.assertEquals("Erro no getMediaAtual()", 1.5,
				convencional_1.getMediaAtual(), 0.05);

		Assert.assertEquals("Erro no getMediaAtual()", 0.0,
				convencional_2.getMediaAtual(), 0.05);
		convencional_2.setQtdProvasJaRealizadas(5);
		convencional_2.adicionaNota(10.0);
		convencional_2.adicionaNota(5.0);
		Assert.assertEquals("Erro no getMediaAtual()", 3.75,
				convencional_2.getMediaAtual(), 0.05);
		convencional_2.adicionaNota(10.0);
		convencional_2.adicionaNota(10.0);
		convencional_2.adicionaNota(10.0);
		Assert.assertEquals("Erro no getMediaAtual()", 9.0,
				convencional_2.getMediaAtual(), 0.05);
	}

	/**
	 * Conjunto de testes para o adicionaFalta().
	 * 
	 * @throws Exception
	 *             Excecao retornada pelo adicionaFalta().
	 */
	@Test
	public void testaAdicionaFalta() throws Exception {
		convencional_1.adicionaFalta();

		try {
			convencional_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			convencional_1.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, convencional_1
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 1,
				convencional_1.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convencional_1
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convencional_1
				.getNotas().get(1), 0.05);

		convencional_2.adicionaFalta();
		try {
			convencional_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		try {
			convencional_2.adicionaFalta();
			Assert.fail("Deveria ter retornado excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Erro no adicionaFalta()",
					"Numero de faltas excedido.", e.getMessage());
		}

		Assert.assertEquals("Erro no adicionaFalta()", 2, convencional_2
				.getNotas().size());
		Assert.assertEquals("Erro no adicionaFalta()", 1,
				convencional_2.getQtdFaltas());
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convencional_2
				.getNotas().get(0), 0.05);
		Assert.assertEquals("Erro no adicionaFalta()", 0.0, convencional_2
				.getNotas().get(1), 0.05);
	}

	/**
	 * Conjunto de testes para o metodo getMensagem().
	 */
	@Test
	public void testaGetMensagem() {
		Assert.assertEquals("Erro no getMensagem()",
				"Disciplina 1 eh avaliada com 5 provas, sem eliminar notas.",
				convencional_1.getMensagem());
		Assert.assertEquals("Erro no getMensagem()",
				"Disciplina 2 eh avaliada com 6 provas, sem eliminar notas.",
				convencional_2.getMensagem());
	}

	/**
	 * Conjunto de testes extras para gets e sets.
	 */
	@Test
	public void testesExtras() {
		convencional_1.setNome("Disc 1");
		Assert.assertEquals("Erro em setNome()", "Disc 1",
				convencional_1.getNome());
		convencional_1.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				convencional_1.getQtdProvas());
		convencional_1.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				convencional_1.getQtdProvasJaRealizadas());
		convencional_1.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				convencional_1.getQtdFaltas());

		convencional_2.setNome("Disc 2");
		Assert.assertEquals("Erro em setNome()", "Disc 2",
				convencional_2.getNome());
		convencional_2.setQtdProvas(10);
		Assert.assertEquals("Erro em setQtdProvas()", 10,
				convencional_2.getQtdProvas());
		convencional_2.setQtdProvasJaRealizadas(1);
		Assert.assertEquals("Erro em setQtdProvasJaRealizadas()", 1,
				convencional_2.getQtdProvasJaRealizadas());
		convencional_2.setQtdFaltas(3);
		Assert.assertEquals("Erro em setQtdFaltas()", 3,
				convencional_2.getQtdFaltas());
	}

}
