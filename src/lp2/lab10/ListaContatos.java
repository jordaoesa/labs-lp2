package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

public class ListaContatos {
	
	private List<Pessoa> listaDePessoas;

	public ListaContatos(){
		listaDePessoas = new ArrayList<Pessoa>();
	}
	
	public boolean adicionarPessoa(Pessoa novaPessoa){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				return false;
			}
		}
		return listaDePessoas.add(novaPessoa);
	}
	
	public boolean removerItemDeContato(Pessoa novaPessoa, ItemDeContato item){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				return pessoa.getListaDeContatos().remove(item);
			}
		}
		return false;
	}
	
	public boolean verificaExistenciaItemDeContato(Pessoa novaPessoa, ItemDeContato item){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				return pessoa.getListaDeContatos().contains(item);
			}
		}
		return false;
	}
	
	public void substituirItemDeContato(Pessoa novaPessoa, ItemDeContato velhoItem, ItemDeContato novoItem){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				if(pessoa.getListaDeContatos().contains(velhoItem)){
					pessoa.getListaDeContatos().remove(velhoItem);
					pessoa.adicionarContato(novoItem);
				}
			}
		}
	}
	
	public List<ItemDeContato> obterContatos(Pessoa novaPessoa){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				return pessoa.getListaDeContatos();
			}
		}
		return null;
	}
	
	public List<String> nomePessoasCadastradas(){
		List<String> pessoasCadastradas = new ArrayList<String>();
		for(Pessoa pessoa : listaDePessoas){
			pessoasCadastradas.add(pessoa.getNome());
		}
		return pessoasCadastradas;
	}
	
	public List<Pessoa> getListaDePessoas() {
		return listaDePessoas;
	}

	public void setListaDePessoas(List<Pessoa> listaDePessoas) {
		this.listaDePessoas = listaDePessoas;
	}

}
