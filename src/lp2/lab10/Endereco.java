package lp2.lab10;

public class Endereco implements ItemDeContato {

	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private int numero;

	public Endereco(String rua, String complemento, String bairro,
			String cidade, String estado, String cep, int numero) {
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
	}

	@Override
	public String exibirContato() {
		String exibeContato = "Rua: " + rua + "\nComplemento: " + complemento
				+ "\nBairro: " + bairro + "\nCidade: " + cidade + "\nEstado: "
				+ estado + "\nCEP: " + cep + "\nNumero: " + numero;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.ENDERECO;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
