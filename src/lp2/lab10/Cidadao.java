package lp2.lab10;

/**
 * Uma interface responsavel por caracterizar um Cidadao.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public interface Cidadao {

	/**
	 * Metodo responsavel por verificar se um dado Cidadao esta apto a votar.
	 * 
	 * @return Retorna true se o cidadao poder votar e false caso contrario.
	 */
	public boolean vota();

	/**
	 * Metodo que retorna o RG de um cidadao.
	 * 
	 * @return O RG do cidadao.
	 */
	public String getRG();

}
