package lp2.lab10;

public class Telefone implements ItemDeContato {

	private String telefone;

	@Override
	public String exibirContato() {
		String exibeContato = "Telefone >> " + telefone;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.TELEFONE;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone))
			return false;
		Telefone tel = (Telefone) obj;
		if (!tel.getTelefone().equals(getTelefone()))
			return false;
		return true;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(checaTelefone(telefone)){
			this.telefone = telefone;
		}
	}

	public boolean checaTelefone(String telefone) {
		return telefone.matches("\\d\\d\\-\\d\\d\\-\\d\\d\\d\\d\\d\\d\\d\\d");
	}
	
}
