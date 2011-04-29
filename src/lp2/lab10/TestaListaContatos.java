package lp2.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestaListaContatos {
	
	private ListaContatos listaContatos;
	private Pessoa pessoa;
	
	@Before
	public void iniciaListaContatos(){
		listaContatos = new ListaContatos();
		
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
	public void testaAdicionaPessoa(){
		
		Assert.assertEquals("Erro em adicionaPessoa()", 0, listaContatos.getListaDePessoas().size());
		listaContatos.adicionarPessoa(pessoa);
		Assert.assertEquals("Erro em adicionaPessoa()", 1, listaContatos.getListaDePessoas().size());
		listaContatos.adicionarPessoa(pessoa);
		Assert.assertEquals("Erro em adicionaPessoa()", 1, listaContatos.getListaDePessoas().size());
		
		List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();
		String nome2 = "Jose";
		String rg2 = "12345";
		String cpf2 = "00350484848";
		int idade = 25;
		double salario = 2000;
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		telefone.setTelefone("55-83-99999999");
		listaDeContatos.add(email);
		listaDeContatos.add(telefone);
		Pessoa pessoa2 = new Pessoa(nome2, rg2, cpf2, idade, salario, listaDeContatos);
		
		listaContatos.adicionarPessoa(pessoa2);
		Assert.assertEquals("Erro em adicionaPessoa()", 2, listaContatos.getListaDePessoas().size());
		
	}
	
	@Test
	public void testaRemoverItemDeContato(){
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		telefone.setTelefone("55-83-99999999");
		
		listaContatos.adicionarPessoa(pessoa);
		Assert.assertEquals("Erro em removerItemDeContato()", 2, listaContatos.getListaDePessoas().get(0).getListaDeContatos().size());
		listaContatos.removerItemDeContato(pessoa, email);
		Assert.assertEquals("Erro em removerItemDeContato()", 1, listaContatos.getListaDePessoas().get(0).getListaDeContatos().size());
		listaContatos.removerItemDeContato(pessoa, email);
		Assert.assertEquals("Erro em removerItemDeContato()", 1, listaContatos.getListaDePessoas().get(0).getListaDeContatos().size());
		listaContatos.removerItemDeContato(pessoa, telefone);
		Assert.assertEquals("Erro em removerItemDeContato()", 0, listaContatos.getListaDePessoas().get(0).getListaDeContatos().size());
	}

	@Test
	public void testaVerificaExistenciaItemDeContato(){
		listaContatos.adicionarPessoa(pessoa);
		
		Email email = new Email();
		Email em = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		em.setEmail("jose@dominio.com");
		telefone.setTelefone("55-83-99999999");
		
		Assert.assertTrue("Erro em verificaExistenciaItemDeContato()", listaContatos.verificaExistenciaItemDeContato(pessoa, email));
		Assert.assertTrue("Erro em verificaExistenciaItemDeContato()", listaContatos.verificaExistenciaItemDeContato(pessoa, telefone));
		Assert.assertFalse("Erro em verificaExistenciaItemDeContato()", listaContatos.verificaExistenciaItemDeContato(pessoa, em));
	}
	
	@Test
	public void testaSubstituirItemDeContato(){
		listaContatos.adicionarPessoa(pessoa);
		
		Email emailAntigo = new Email();
		Telefone telefoneAntigo = new Telefone();
		emailAntigo.setEmail("joseAnonimo@dominio.com");
		telefoneAntigo.setTelefone("55-83-99999999");
		
		Email email = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("jose@dominio.com");
		telefone.setTelefone("55-83-11111111");
		
		Assert.assertEquals("Erro em substituirItemDeContato()", emailAntigo, pessoa.getListaDeContatos().get(0));
		Assert.assertEquals("Erro em substituirItemDeContato()", telefoneAntigo, pessoa.getListaDeContatos().get(1));
		
		listaContatos.substituirItemDeContato(pessoa, emailAntigo, email);
		listaContatos.substituirItemDeContato(pessoa, telefoneAntigo, telefone);
		
		Assert.assertEquals("Erro em substituirItemDeContato()", email, pessoa.getListaDeContatos().get(0));
		Assert.assertEquals("Erro em substituirItemDeContato()", telefone, pessoa.getListaDeContatos().get(1));
	}
	
	@Test
	public void testaObterContatos(){
		listaContatos.adicionarPessoa(pessoa);
		
		List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();
		Email email = new Email();
		Email em = new Email();
		Telefone telefone = new Telefone();
		email.setEmail("joseAnonimo@dominio.com");
		em.setEmail("joao@hot.com");
		telefone.setTelefone("55-83-99999999");
		listaDeContatos.add(email);
		listaDeContatos.add(telefone);
		
		Assert.assertTrue("Erro em obterContatos()", verificaListasDeContatosIguais(listaDeContatos, listaContatos.obterContatos(pessoa)));
		listaDeContatos.add(em);
		Assert.assertFalse("Erro em obterContatos()", verificaListasDeContatosIguais(listaDeContatos, listaContatos.obterContatos(pessoa)));
	}
	
	@Test
	public void testaNomePessoasCadastradas(){
		listaContatos.adicionarPessoa(pessoa);
		List<String> nomes = new ArrayList<String>();
		nomes.add("Jose Anonimo");
		Assert.assertEquals("Erro em nomePessoasCadastradas()", nomes, listaContatos.nomePessoasCadastradas());
	}
	
	@Test
	public void testaGetsSets(){
		listaContatos.adicionarPessoa(pessoa);
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.add(pessoa);
		
		Assert.assertEquals("Erro em getsSets()", 1, listaContatos.getListaDePessoas().size());
		Assert.assertEquals("Erro em getsSets()", lista, listaContatos.getListaDePessoas());
	}
	
	private static boolean verificaListasDeContatosIguais(List<ItemDeContato> lista1, List<ItemDeContato> lista2){
		int i = 0, cont = 0;
		if(lista1.size() == lista2.size())
			for(ItemDeContato item1 : lista1){
				if(item1.equals(lista2.get(i))){
					cont++;
				}
				i++;
			}
		if(cont == lista1.size())
			return true;
		return false;
	}
}
