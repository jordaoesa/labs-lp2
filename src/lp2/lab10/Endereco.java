package lp2.lab10;

/**
 * Um tipo de Item de Contato - Endereco.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Endereco implements ItemDeContato {

	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private int numero;

	/**
	 * Instancia um novo Endereco.
	 * 
	 * @param rua
	 *            A rua do endereco.
	 * @param complemento
	 *            O complemento do endereco.
	 * @param bairro
	 *            O bairro do endereco.
	 * @param cidade
	 *            A cidade do endereco.
	 * @param estado
	 *            O estado do endereco.
	 * @param cep
	 *            O cep do endereco.
	 * @param numero
	 *            O numero da casa do endereco.
	 */
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

	/**
	 * Metodo responsavel por exibir detalhadamento o Endereco do funcionario.
	 */
	@Override
	public String exibirContato() {
		String exibeContato = "Endereco >> Rua: " + rua + ", Complemento: "
				+ complemento + ", Bairro: " + bairro + ", Cidade: " + cidade
				+ ", Estado: " + estado + ", CEP: " + cep + ", Numero: "
				+ numero;
		return exibeContato;
	}

	/**
	 * Metodo responsavel por especificar o tipo do item de contato atual a
	 * partir de uma enumeracao.
	 */
	@Override
	public TipoDeItemDeContato tipoDoContato() {
		return TipoDeItemDeContato.ENDERECO;
	}

	/**
	 * Compara todos os atributos de um Endreco com outro para verificar se
	 * ambos sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco))
			return false;
		Endereco end = (Endereco) obj;
		if (!end.getBairro().equals(getBairro())
				|| !end.getCep().equals(getCep())
				|| !end.getCidade().equals(getCidade())
				|| !end.getComplemento().equals(getComplemento())
				|| !end.getEstado().equals(getEstado())
				|| !(end.getNumero() == getNumero())
				|| !end.getRua().equals(getRua()))
			return false;

		return true;
	}

	/**
	 * Retorna a rua do endereco.
	 * 
	 * @return A rua.
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Define uma nova rua para o endereco.
	 * 
	 * @param rua
	 *            A nova rua.
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * O complementos do endereco.
	 * 
	 * @return O complemento.
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Define um novo complemento para o endereco.
	 * 
	 * @param complemento
	 *            O novo complemento.
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Retorna o bairro do endereco.
	 * 
	 * @return O bairro.
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Define um novo bairro para o endereco.
	 * 
	 * @param bairro
	 *            O novo bairro.
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna a cidade do endereco.
	 * 
	 * @return A cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Define uma cidade para o endereco.
	 * 
	 * @param cidade
	 *            A nova cidade.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o estado do endereco.
	 * 
	 * @return O estado.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Define um novo estado para o endereco.
	 * 
	 * @param estado
	 *            O novo estado.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna o cep do endereco.
	 * 
	 * @return O cep.
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Define um novo cep para o endereco.
	 * 
	 * @param cep
	 *            O novo cep.
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Retorna o numero do endereco.
	 * 
	 * @return O numero.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Define um novo numero para o endereco.
	 * 
	 * @param numero
	 *            O novo numero.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
