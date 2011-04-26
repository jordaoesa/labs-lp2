package lp2.lab10;

public class Email implements ItemDeContato {

	private String email;

	@Override
	public String exibirContato() {
		String exibeContato = "Email: " + email;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.EMAIL;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean checaEmail(String email) {
		return email.matches("[a-z_\\.]*@[a-z]*\\.[a-z]*");
	}

//	public static void main(String[] args) {
//		Email e = new Email();
//		System.out.println(e.checaEmail("jo.r_d._o@jordao.com"));
//	}

}
