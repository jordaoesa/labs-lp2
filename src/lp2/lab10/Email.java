package lp2.lab10;

/**
 * Um tipo de Item de Contato Email.
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
	
	public Email(){
	}

	@Override
	public String exibirContato() {
		String exibeContato = "Email >> " + email;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.EMAIL;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Email))
			return false;
		Email em = (Email) obj;
		if(!em.getEmail().equals(getEmail()))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(checaEmail(email)){
			this.email = email;
		}
	}

	public boolean checaEmail(String email) {
		return email.matches("[a-zA-Z0-9_\\.]*@[a-zA-Z0-9\\.]*");
	}

}
