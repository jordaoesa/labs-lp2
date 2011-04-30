package lp2.lab10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Conjunto de testes responsavel por verificar os metodos Da classe Telefone.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaTelefone {

	Telefone telefone;

	@Before
	public void iniciaTlefone() {
		telefone = new Telefone();
		telefone.setTelefone("55-83-99999999");
	}

	@Test
	public void testaTipoDeItemContato() {
		Assert.assertEquals("Erro em tipoDeContato()",
				TipoDeItemDeContato.TELEFONE, telefone.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.EMAIL == telefone
				.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.ENDERECO == telefone
				.tipoDoContato());
	}

	@Test
	public void testaExibirContato() {
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 55-83-99999999", telefone.exibirContato());
		telefone.setTelefone("122344444444");
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 55-83-99999999", telefone.exibirContato());
		telefone.setTelefone("22-22/33333333");
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 55-83-99999999", telefone.exibirContato());
		telefone.setTelefone("99-99-9999999");
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 55-83-99999999", telefone.exibirContato());
		telefone.setTelefone("99-99-9999a99&");
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 55-83-99999999", telefone.exibirContato());
		telefone.setTelefone("99-99-99999999");
		Assert.assertEquals("Erro em exibirContato()",
				"Telefone >> 99-99-99999999", telefone.exibirContato());
	}

	@Test
	public void testaEquals() {
		Telefone t = new Telefone();
		t.setTelefone("55-83-99999999");
		Assert.assertTrue("Erro em equals()", telefone.equals(t));
		t.setTelefone("55-83-9999999k");
		Assert.assertTrue("Erro em equals()", telefone.equals(t));
		t.setTelefone("55-99-00000000");
		Assert.assertFalse("Erro em equals()", telefone.equals(t));
	}

	@Test
	public void testaGetsSets() {
		Assert.assertEquals("Erro em getTelefone()", "55-83-99999999",
				telefone.getTelefone());
		telefone.setTelefone("12-34-12345678");
		Assert.assertEquals("Erro em getTelefone()", "12-34-12345678",
				telefone.getTelefone());
	}

}
