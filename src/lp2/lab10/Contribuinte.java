package lp2.lab10;

/**
 * Uma interface responsavel por caracterizar um Contribuinte.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public interface Contribuinte {

	/**
	 * Metodo responsavel por verificar quanto um Contribuinte dve pagar de
	 * Imposto de Renda.
	 * 
	 * @return O valor a ser pago.
	 */
	public double pagaIR();

	/**
	 * Metodo que retorna o CPF do Cidadao.
	 * 
	 * @return O CPF do Cidadao.
	 */
	public String getCPF();

}
