package lp2.lab10;

public class Telefone implements ItemDeContato{

	private String telefone;
	
	@Override
	public String exibirContato() {
		String exibeContato = "Telefone: " + telefone;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.TELEFONE;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public boolean checaTelefone(String telefone){
		return telefone.matches("\\d\\d\\-\\d\\d\\-\\d\\d\\d\\d\\d\\d\\d\\d");
	}

//	public static void main(String[] args) {
//		Telefone t = new Telefone();
//		System.out.println(t.checaTelefone("55-83-99081560"));
//	}
}
