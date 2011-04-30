package lp2.lab10;

/**
 * Um tipo de Item de Contato - Telefone.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Telefone implements ItemDeContato {

	private String telefone;

	/**
	 * Instancia um novo telefone.
	 */
	public Telefone() {
	}

	/**
	 * Metodo responsavel por exibir o telefone do funcionario.
	 */
	@Override
	public String exibirContato() {
		String exibeContato = "Telefone >> " + telefone;
		return exibeContato;
	}

	/**
	 * Metodo responsavel por especificar o tipo do item de contato atual a
	 * partir de uma enumeracao.
	 */
	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.TELEFONE;
	}

	/**
	 * Metodo que verifica se dois telefones sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone))
			return false;
		Telefone tel = (Telefone) obj;
		if (!tel.getTelefone().equals(getTelefone()))
			return false;
		return true;
	}

	/**
	 * Retorna o telefone do funcionario.
	 * 
	 * @return O telefone.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define um novo telefone para o funcionario.
	 * 
	 * @param telefone
	 *            O novo telefone.
	 */
	public void setTelefone(String telefone) {
		if (checaTelefone(telefone)) {
			this.telefone = telefone;
		}
	}

	/**
	 * Metodo que checa se uma String com o telefone eh valida.
	 * 
	 * @param telefone
	 *            A String com o telefone a ser verificado.
	 * @return Retorna true se o telefone for valido e false caso contrario.
	 */
	public boolean checaTelefone(String telefone) {
		return telefone.matches("\\d\\d\\-\\d\\d\\-\\d\\d\\d\\d\\d\\d\\d\\d");
	}

}
