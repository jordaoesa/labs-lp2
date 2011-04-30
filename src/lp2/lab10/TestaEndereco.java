package lp2.lab10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Conjunto de testes responsavel por verificar os metodos da classe Endereco.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaEndereco {

	Endereco endereco;

	@Before
	public void iniciaEndereco() {
		String rua = "Rua Prof Severino";
		String complemento = "Apartamento";
		String bairro = "Conjunto dos Professores";
		String cidade = "Campina Grande";
		String estado = "Paraiba";
		String cep = "12345-000";
		int numero = 1;
		endereco = new Endereco(rua, complemento, bairro, cidade, estado, cep,
				numero);
	}

	@Test
	public void testaTipoDeItemContato() {
		Assert.assertEquals("Erro em tipoDeContato()",
				TipoDeItemDeContato.ENDERECO, endereco.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.TELEFONE == endereco
				.tipoDoContato());
		Assert.assertFalse(TipoDeItemDeContato.EMAIL == endereco
				.tipoDoContato());
	}

	@Test
	public void testaExibirContato() {
		Assert.assertEquals(
				"Erro em exibirContato()",
				"Endereco >> Rua: Rua Prof Severino, Complemento: "
						+ "Apartamento, Bairro: Conjunto dos Professores, Cidade: "
						+ "Campina Grande, Estado: Paraiba, CEP: 12345-000, Numero: 1",
				endereco.exibirContato());

		endereco.setBairro("outro bairro");
		Assert.assertEquals(
				"Erro em exibirContato()",
				"Endereco >> Rua: Rua Prof Severino, Complemento: "
						+ "Apartamento, Bairro: outro bairro, Cidade: "
						+ "Campina Grande, Estado: Paraiba, CEP: 12345-000, Numero: 1",
				endereco.exibirContato());
		endereco.setNumero(10);
		endereco.setCep("22222-000");
		endereco.setComplemento("outro complemento");
		endereco.setEstado("outro estado");
		endereco.setRua("outra rua");
		endereco.setCidade("outra cidade");
		Assert.assertEquals(
				"Erro em exibirContato()",
				"Endereco >> Rua: outra rua, Complemento: "
						+ "outro complemento, Bairro: outro bairro, Cidade: "
						+ "outra cidade, Estado: outro estado, CEP: 22222-000, Numero: 10",
				endereco.exibirContato());
	}

	@Test
	public void testaEquals() {
		String rua = "Rua Prof Severino";
		String complemento = "Apartamento";
		String bairro = "Conjunto dos Professores";
		String cidade = "Campina Grande";
		String estado = "Paraiba";
		String cep = "12345-000";
		int numero = 1;

		Endereco end = new Endereco(rua, complemento, bairro, cidade, estado,
				cep, numero);

		Assert.assertTrue("Erro no equals()", endereco.equals(end));
		end.setCep("12345-001");
		Assert.assertFalse("Erro no equals()", endereco.equals(end));
		end.setCep("12345-000");
		Assert.assertTrue("Erro no equals()", endereco.equals(end));
		end.setCidade("outra cidade");
		Assert.assertFalse("Erro no equals()", endereco.equals(end));
	}

	@Test
	public void testaGetsSets() {
		Assert.assertEquals("Erro em getBairro()", "Conjunto dos Professores",
				endereco.getBairro());
		Assert.assertEquals("Erro em getCep()", "12345-000", endereco.getCep());
		Assert.assertEquals("Erro em getCidade()", "Campina Grande",
				endereco.getCidade());
		Assert.assertEquals("Erro em getComplemento()", "Apartamento",
				endereco.getComplemento());
		Assert.assertEquals("Erro em getEstado()", "Paraiba",
				endereco.getEstado());
		Assert.assertEquals("Erro em getNumero()", 1, endereco.getNumero());
		Assert.assertEquals("Erro em getRua()", "Rua Prof Severino",
				endereco.getRua());

		endereco.setBairro("outro bairro");
		endereco.setNumero(10);
		endereco.setCep("22222-000");
		endereco.setComplemento("outro complemento");
		endereco.setEstado("outro estado");
		endereco.setRua("outra rua");
		endereco.setCidade("outra cidade");

		Assert.assertEquals("Erro em getBairro()", "outro bairro",
				endereco.getBairro());
		Assert.assertEquals("Erro em getCep()", "22222-000", endereco.getCep());
		Assert.assertEquals("Erro em getCidade()", "outra cidade",
				endereco.getCidade());
		Assert.assertEquals("Erro em getComplemento()", "outro complemento",
				endereco.getComplemento());
		Assert.assertEquals("Erro em getEstado()", "outro estado",
				endereco.getEstado());
		Assert.assertEquals("Erro em getNumero()", 10, endereco.getNumero());
		Assert.assertEquals("Erro em getRua()", "outra rua", endereco.getRua());
	}

}
