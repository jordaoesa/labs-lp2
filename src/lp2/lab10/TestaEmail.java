package lp2.lab10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Conjunto de testes responsavel por verificar os metodos da classe Email.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaEmail {

	private Email email;

	@Before
	public void criaEmail() {
		email = new Email();
		email.setEmail("jordaoesa@gmail.com");
	}

	@Test
	public void testaTipoDeItemContato() {
		Assert.assertEquals("Erro em tipoDeContato()",
				TipoDeItemDeContato.EMAIL, email.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.TELEFONE == email
				.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.ENDERECO == email
				.tipoDoContato());
	}

	@Test
	public void testaExibirContato() {
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("jose@antonio_.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("jose@dominio@dominio.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("jose!@dominio.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("jose#!&*()@dominio.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaoesa@gmail.com", email.exibirContato());
		email.setEmail("jose123@dominio34.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jose123@dominio34.com", email.exibirContato());
		email.setEmail("JoAoUm@dominio34.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> JoAoUm@dominio34.com", email.exibirContato());
		email.setEmail("JoAoUm@DOMinio34.CoM");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> JoAoUm@DOMinio34.CoM", email.exibirContato());
		email.setEmail("jordaotalk@gmail.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordaotalk@gmail.com", email.exibirContato());
		email.setEmail("jordao_ezequiel@gmail.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordao_ezequiel@gmail.com", email.exibirContato());
		email.setEmail("jordao_ezequiel.serafim@gmail.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordao_ezequiel.serafim@gmail.com",
				email.exibirContato());
		email.setEmail("jordao_ezequiel.serafim_ara.ujo@gmail.com");
		Assert.assertEquals("Erro em exibirContato()",
				"Email >> jordao_ezequiel.serafim_ara.ujo@gmail.com",
				email.exibirContato());
	}

	@Test
	public void testaEquals() {
		Assert.assertFalse("Erro no equals()",
				email.equals("jordaoesa@gmail.com"));

		Email em = new Email();
		em.setEmail("jordaoesa@gmail.com");
		Assert.assertTrue("Erro no equals()", email.equals(em));
		em.setEmail("joao@gmail.com");
		Assert.assertFalse("Erro no equals()", email.equals(em));
	}

	@Test
	public void testaGetsSets() {
		Assert.assertEquals("Erro em getEmail()", "jordaoesa@gmail.com",
				email.getEmail());
		email.setEmail("novoEmail@exemplo.com.br");
		Assert.assertEquals("Erro em getEmail()", "novoEmail@exemplo.com.br",
				email.getEmail());
	}

}
