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
		String exibeContato = "Endereco >> Rua: " + rua + ", Complemento: " + complemento
				+ ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: "
				+ estado + ", CEP: " + cep + ", Numero: " + numero;
		return exibeContato;
	}

	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.ENDERECO;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco))
			return false;
		Endereco end = (Endereco) obj;
		if (!(end.getBairro().equals(getBairro())
				|| end.getCep().equals(getCep())
				|| end.getCidade().equals(getCidade())
				|| end.getComplemento().equals(getComplemento())
				|| end.getEstado().equals(getEstado())
				|| end.getNumero() == getNumero() || end.getRua().equals(
				getRua())))
			return false;

		return true;
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
