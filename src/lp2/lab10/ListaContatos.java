package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

public class ListaContatos {
	
	private List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
	
	public ListaContatos(){
		
	}
	
	public void adicionarPessoa(Pessoa novaPessoa){
		for(Pessoa pessoa : listaDePessoas){
			if(pessoa.equals(novaPessoa)){
				return;
			}
		}
		listaDePessoas.add(novaPessoa);
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
	
	public void obterContatos(Pessoa pessoa){
		
	}
	
//	este método deve retornar uma lista de itens
//	de contato associada a uma determinada pessoa;
	
	public void nomePessoasCadastradas(){
		
	}
//	 retorna uma lista com o nome das
//	pessoas já cadastradas.

}
