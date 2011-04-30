package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Conjunto de testes responsavel por verificar os metodos da classe Pessoa.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class TestaPessoa {

	Pessoa pessoa;

	@Before
	public void iniciaPessoa() {
		List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();
		String nome = "Jose Anonimo";
		String rg = "123456";
		String cpf = "12345678909";
		int idade = 25;
		double salario = 2000;
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		telefone.setTelefone("55-83-99999999");
		listaDeContatos.add(email);
		listaDeContatos.add(telefone);

		pessoa = new Pessoa(nome, rg, cpf, idade, salario, listaDeContatos);
	}

	@Test
	public void testaPagaIR() {
		Assert.assertEquals("Erro em pagaIR()", 300, pessoa.pagaIR(), 0.0005);
		pessoa.setSalario(1000);
		Assert.assertEquals("Erro em pagaIR()", 0, pessoa.pagaIR(), 0.0005);
		pessoa.setSalario(3500);
		Assert.assertEquals("Erro em pagaIR()", 875, pessoa.pagaIR(), 0.0005);
	}

	@Test
	public void testaVota() {
		Assert.assertTrue("Erro em vota()", pessoa.vota());
		pessoa.setIdade(15);
		Assert.assertFalse("Erro em vota()", pessoa.vota());
		pessoa.setIdade(50);
		Assert.assertTrue("Erro em vota()", pessoa.vota());
	}

	@Test
	public void testaGetCPF() {
		Assert.assertEquals("Erro em getCPF()", "12345678909", pessoa.getCPF());
		pessoa.setCPF("00350484848"); // CPF VALIDO
		Assert.assertEquals("Erro em getCPF()", "00350484848", pessoa.getCPF());
		pessoa.setCPF("00650484569"); // CPF INVALIDO
		Assert.assertEquals("Erro em getCPF()", "00350484848", pessoa.getCPF());
		pessoa.setCPF("24216113931"); // CPF VALIDO
		Assert.assertEquals("Erro em getCPF()", "24216113931", pessoa.getCPF());
	}

	@Test
	public void testaGetRG() {
		Assert.assertEquals("Erro em getRG()", "123456", pessoa.getRG());
		pessoa.setRG("456789");
		Assert.assertEquals("Erro em getRG()", "456789", pessoa.getRG());
	}

	@Test
	public void testaEquals() {
		List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();
		String nome = "Jose Anonimo";
		String rg = "123456";
		String cpf = "12345678909";
		int idade = 20;
		double salario = 0;
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("jose@dominio.com");
		telefone.setTelefone("55-83-55555555");
		listaDeContatos.add(email);
		listaDeContatos.add(telefone);

		Pessoa p = new Pessoa(nome, rg, cpf, idade, salario, listaDeContatos);

		Assert.assertTrue("Erro em equals()", pessoa.equals(p));
		p.setNome("Joao"); // AINDA SAO IGUAIS CPF E RG
		Assert.assertTrue("Erro em equals()", pessoa.equals(p));
		p.setRG("6789"); // AINDA EH IGUAL O CPF
		Assert.assertTrue("Erro em equals()", pessoa.equals(p));
		p.setCPF("24216113931"); // AGORA SAO PESSOAS DIFERENTES
		Assert.assertFalse("Erro em equals()", pessoa.equals(p));
	}

	@Test
	public void testaVerificaCPF() {
		Assert.assertFalse("Erro em verificaCPF()",
				Pessoa.verificaCPF("123456sdf"));
		Assert.assertFalse("Erro em verificaCPF()", Pessoa.verificaCPF("126"));
		Assert.assertFalse("Erro em verificaCPF()", Pessoa.verificaCPF(""));
		Assert.assertFalse("Erro em verificaCPF()",
				Pessoa.verificaCPF("asdfghjklqq"));
		Assert.assertFalse("Erro em verificaCPF()",
				Pessoa.verificaCPF("12345678900"));
		Assert.assertFalse("Erro em verificaCPF()",
				Pessoa.verificaCPF("12345609877"));

		Assert.assertTrue("Erro em verificaCPF()",
				Pessoa.verificaCPF("12345678909"));
		Assert.assertTrue("Erro em verificaCPF()",
				Pessoa.verificaCPF("24216113931"));
		Assert.assertTrue("Erro em verificaCPF()",
				Pessoa.verificaCPF("00350484848"));

	}

	@Test
	public void testaAdicionarContato() {
		Assert.assertEquals("Erro em adcionaContato()", 2, pessoa
				.getListaDeContatos().size());
		Email m = new Email();
		m.setEmail("email@email.com");
		pessoa.adicionarContato(m);
		Assert.assertEquals("Erro em adcionaContato()", 3, pessoa
				.getListaDeContatos().size());

		Assert.assertTrue(
				"Erro em adcionaContato()",
				pessoa.getListaDeContatos().get(0).tipoDoContato() == TipoDeItemDeContato.EMAIL);
		Assert.assertTrue(
				"Erro em adcionaContato()",
				pessoa.getListaDeContatos().get(1).tipoDoContato() == TipoDeItemDeContato.TELEFONE);
		Assert.assertTrue(
				"Erro em adcionaContato()",
				pessoa.getListaDeContatos().get(2).tipoDoContato() == TipoDeItemDeContato.EMAIL);
	}

	@Test
	public void testaGetsSets() {
		List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		telefone.setTelefone("55-83-99999999");
		listaDeContatos.add(email);
		listaDeContatos.add(telefone);

		Assert.assertEquals("Erro em getSalario()", 2000, pessoa.getSalario(),
				0.0005);
		Assert.assertEquals("Erro em getCPF()", "12345678909", pessoa.getCPF());
		Assert.assertEquals("Erro em getIdade()", 25, pessoa.getIdade());
		Assert.assertEquals("Erro em getListaDeContatos()", listaDeContatos,
				pessoa.getListaDeContatos());
		Assert.assertEquals("Erro em getNome()", "Jose Anonimo",
				pessoa.getNome());
		Assert.assertEquals("Erro em getRG()", "123456", pessoa.getRG());

		Email em = new Email();
		em.setEmail("email@email.com");
		listaDeContatos.add(em);

		pessoa.setCPF("00350484848");
		pessoa.setIdade(18);
		pessoa.setListaDeContatos(listaDeContatos);
		pessoa.setNome("joao");
		pessoa.setRG("45667");
		pessoa.setSalario(6000);

		Assert.assertEquals("Erro em getSalario()", 6000, pessoa.getSalario(),
				0.0005);
		Assert.assertEquals("Erro em getCPF()", "00350484848", pessoa.getCPF());
		Assert.assertEquals("Erro em getIdade()", 18, pessoa.getIdade());
		Assert.assertEquals("Erro em getListaDeContatos()", listaDeContatos,
				pessoa.getListaDeContatos());
		Assert.assertEquals("Erro em getNome()", "joao", pessoa.getNome());
		Assert.assertEquals("Erro em getRG()", "45667", pessoa.getRG());

	}

}