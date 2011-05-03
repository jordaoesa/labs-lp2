package lp2.lab10;

/**
 * Um tipo de Item de Contato - Email.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Email implements ItemDeContato {

	private String email;

	/**
	 * Instancia um novo email.
	 */
	public Email() {
	}

	/**
	 * Metodo responsavel por exibir o email do funcionario.
	 */
	@Override
	public String exibirContato() {
		String exibeContato = "Email >> " + email;
		return exibeContato;
	}

	/**
	 * Metodo responsavel por especificar o tipo do item de contato atual a
	 * partir de uma enumeracao.
	 */
	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.EMAIL;
	}

	/**
	 * Metodo que verifica se dois emails sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Email))
			return false;
		Email em = (Email) obj;
		if (!em.getEmail().equals(getEmail()))
			return false;
		return true;
	}

	/**
	 * Retorna o email do funcionario.
	 * 
	 * @return O email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define um novo email para o funcionario.
	 * 
	 * @param email
	 *            O novo email.
	 */
	public void setEmail(String email) {
		if (checaEmail(email)) {
			this.email = email;
		}
	}

	/**
	 * Verifica se uma String com o email eh valida a partir de expressao
	 * regular.
	 * 
	 * @param email
	 *            A String a ser verificada.
	 * @return Retorna true caso seja valido o email e false caso contrario.
	 */
	public boolean checaEmail(String email) {
		return email.matches("[a-zA-Z0-9]+[a-zA-Z0-9-_\\.]*@[a-zA-Z0-9]+[\\.]+[a-zA-Z0-9\\.]+");
	}
	
}
