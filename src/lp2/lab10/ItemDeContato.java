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

	public String exibirContato();

	public TipoDeItemDeContato tipoDoContato();

	@Override
	public boolean equals(Object obj);

}
