package lp2.lab10;

/**
 * Uma interface responsavel por caracterizar um Item de Contato.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public interface ItemDeContato {

	/**
	 * Metodo responsavel por exibir detalhadamento o item de contato.
	 * 
	 * @return Uma String com os detalhes do item d contato.
	 */
	public String exibirContato();

	/**
	 * Metodo responsavel por especificar o tipo do item de contato atual a
	 * partir de uma enumeracao.
	 * 
	 * @return A enumeracao que representa o tipo de item de contato atual.
	 */
	public TipoDeItemDeContato tipoDoContato();

	/**
	 * Metodo que vai verificar se dois itens de contato sao iguais a partir de
	 * comparacos entre seus atributos.
	 * 
	 * @param obj
	 *            Um objeto represetando o item de contato.
	 * @return Retorna true caso os itens de contato sejam iguais e false caso
	 *         contrario.
	 */
	@Override
	public boolean equals(Object obj);

}
