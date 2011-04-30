package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por fazer operacoes sobre pessoas e seus respectivos itens
 * de contato.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class ListaContatos {

	private List<Pessoa> listaDePessoas;

	/**
	 * Intancia uma nova listaContatos que faz operacoes sobre as pessoas e seus
	 * itens de contato.
	 */
	public ListaContatos() {
		listaDePessoas = new ArrayList<Pessoa>();
	}

	/**
	 * Metodo responsavel por adicionar um funcionario a listaContatos da
	 * empresa.
	 * 
	 * @param novaPessoa
	 *            A pessoa que representa o funcionario.
	 * @return Retorna true case a pessoa seja adicionada com sucesso e false
	 *         caso contrario.
	 */
	public boolean adicionarPessoa(Pessoa novaPessoa) {
		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.equals(novaPessoa)) {
				return false;
			}
		}
		return listaDePessoas.add(novaPessoa);
	}

	/**
	 * Metodo responsavel por receber uma pessoa e remover um item de contato
	 * caso ela o tenha.
	 * 
	 * @param novaPessoa
	 *            A pessoa a qual o item vai ser removido.
	 * @param item
	 *            O item a ser removido.
	 * @return Retorna true caso o item seja removido com sucesso e false caso
	 *         contrario.
	 */
	public boolean removerItemDeContato(Pessoa novaPessoa, ItemDeContato item) {
		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.equals(novaPessoa)) {
				return pessoa.getListaDeContatos().remove(item);
			}
		}
		return false;
	}

	/**
	 * Metodo responsavel por verificar a existencia de um item de contato em
	 * uma pessoa.
	 * 
	 * @param novaPessoa
	 *            A pessoa que pode conter esse item de contato.
	 * @param item
	 *            O item a ser procurado.
	 * @return Retorna true caso o item seja encontrado com e false caso
	 *         contrario.
	 */
	public boolean verificaExistenciaItemDeContato(Pessoa novaPessoa,
			ItemDeContato item) {
		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.equals(novaPessoa)) {
				return pessoa.getListaDeContatos().contains(item);
			}
		}
		return false;
	}

	/**
	 * Metodo responsavel por substituir um item de contato em uma dada pessoa
	 * caso esta pessoa possua este item.
	 * 
	 * @param novaPessoa
	 *            A pessoa a substituir o item.
	 * @param velhoItem
	 *            O item a ser substituido.
	 * @param novoItem
	 *            O novo item.
	 */
	public void substituirItemDeContato(Pessoa novaPessoa,
			ItemDeContato velhoItem, ItemDeContato novoItem) {
		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.equals(novaPessoa)) {
				if (pessoa.getListaDeContatos().contains(velhoItem)) {
					pessoa.getListaDeContatos().remove(velhoItem);
					pessoa.adicionarContato(novoItem);
				}
			}
		}
	}

	/**
	 * Metodo responsavel por obter todos os contatos de uma dada pessoa.
	 * 
	 * @param novaPessoa
	 *            A pessoa a qual se quer os contatos.
	 * @return Retorna a lista contendo os itens de contato da pessoa e null
	 *         caso essa pessoa nao seja encontrada.
	 */
	public List<ItemDeContato> obterContatos(Pessoa novaPessoa) {
		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.equals(novaPessoa)) {
				return pessoa.getListaDeContatos();
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por obter todas as pessoas cadastradas no sistema da
	 * empresa.
	 * 
	 * @return A lista de pessoas cadastradas na empresa.
	 */
	public List<String> nomePessoasCadastradas() {
		List<String> pessoasCadastradas = new ArrayList<String>();
		for (Pessoa pessoa : listaDePessoas) {
			pessoasCadastradas.add(pessoa.getNome());
		}
		return pessoasCadastradas;
	}

	/**
	 * Retorna a lista de pessoas cadastradas.
	 * 
	 * @return A lista de pessoas.
	 */
	public List<Pessoa> getListaDePessoas() {
		return listaDePessoas;
	}

	/**
	 * Define uma nova lista de pessoas cadastradas.
	 * 
	 * @param listaDePessoas
	 *            A nova lista de pessoas.
	 */
	public void setListaDePessoas(List<Pessoa> listaDePessoas) {
		this.listaDePessoas = listaDePessoas;
	}

}
