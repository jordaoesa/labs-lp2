package lp2.lab07;

/*
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 */
/**
 * O anuncio q vai ser exibido ao usuario logado no sistema.
 * 
 * @author jordaoesa
 * 
 */
public class Anuncio {

	private Pais pais;
	private String nomeEmpresa;
	private String linkPagWeb;
	private String anuncio;

	/**
	 * Instancia um novo anuncio.
	 * 
	 * @param pais
	 *            O pais onde deve ser exibido o anuncio.
	 * @param nomeEmpresa
	 *            A Empresa que esta anunciando.
	 * @param linkPagWeb
	 *            Link para a pagina na web da empresa.
	 * @param anuncio
	 *            O anuncio a ser exibido.
	 */
	public Anuncio(Pais pais, String nomeEmpresa, String linkPagWeb,
			String anuncio) {
		this.pais = pais;
		this.nomeEmpresa = nomeEmpresa;
		this.linkPagWeb = linkPagWeb;
		this.anuncio = anuncio;
	}

	/**
	 * Metodo acessor para o atributo "pais".
	 * 
	 * @return O pais.
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * Metodo para modificar o pais do anuncio.
	 * 
	 * @param pais
	 *            O novo pais.
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * Metodo para acessar o nome da Empresa.
	 * 
	 * @return O nome da Empresa.
	 */
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	/**
	 * Metodo para modificar o nome da Empresa.
	 * 
	 * @param nomeEmpresa
	 *            O novo nome da Empresa.
	 */
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	/**
	 * Metodo para acessar o site da Empresa.
	 * 
	 * @return O site da empresa.
	 */
	public String getLinkPagWeb() {
		return linkPagWeb;
	}

	/**
	 * Metodo para modificar o site da Empresa.
	 * 
	 * @param linkPagWeb
	 *            O novo site da Empresa.
	 */
	public void setLinkPagWeb(String linkPagWeb) {
		this.linkPagWeb = linkPagWeb;
	}

	/**
	 * Metodo que acessa o anuncio.
	 * 
	 * @return O anuncio.
	 */
	public String getAnuncio() {
		return anuncio;
	}

	/**
	 * Metodo que modifica o anuncio.
	 * 
	 * @param anuncio
	 *            O novo anuncio.
	 */
	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}

	/**
	 * Metodo responsavel por exibir na tela os anuncios relacionados a cada
	 * Pais.
	 */
	public void exibeAnuncio() {
		System.out.println("**************************");
		System.out.println("* Empresa: " + nomeEmpresa);
		System.out.println("* Link Pagina Web: " + linkPagWeb);
		System.out.println("* Anuncio: " + anuncio);
		System.out.println("**************************");
	}

}
