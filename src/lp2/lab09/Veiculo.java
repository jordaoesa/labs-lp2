package lp2.lab09;

import java.util.List;

/**
 * Classe abstrata que defini os metodos necessarios a todos os objetos veiculo
 * que herdam dela.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public abstract class Veiculo {

	/**
	 * Metodo que retorna a lista de consertos pelos quais o veiculo ja passou.
	 * 
	 * @return A lista de consertos passados.
	 */
	public abstract List<String> consertosPassados();

	/**
	 * Metodo que retorna a lista de verificacoes pelas quais o veiculo vai
	 * passar.
	 * 
	 * @return A lista de verificacoes.
	 */
	public abstract List<Verificacao> verificacoes();

	/**
	 * Metodo responsavel por adicionar uma nova verificacao a lista de
	 * verificacoes pelas quais o veiculo vai passar.
	 * 
	 * @param verificacao
	 *            A nova verificacao a ser adicionada.
	 */
	public abstract void adicionaVerificacao(Verificacao verificacao);

	/**
	 * Metodo responsavel por consertae um certa avaria que o carro apresenta.
	 * 
	 * @param verificacao
	 *            A avaria a ser consertada.
	 */
	public abstract void consertar(Verificacao verificacao);

	/**
	 * Metodo responsavel por limpar o veiculo.
	 */
	public abstract void limpar();

	/**
	 * Metodo responsavel por verificar a quantidade de pneus que o veiculo
	 * precisa trocar.
	 * 
	 * @return A quantidade de pneus trocados.
	 */
	public abstract int trocarPneus();

	/**
	 * Metodo responsavel por checar se um pneu esta defeituoso ou nao.
	 * 
	 * @param i
	 *            O pneu a ser checado.
	 * @return Retorna true caso o pneu esteja avariado e false caso contrario.
	 */
	public abstract boolean checaPneuAvariado(int i);

}
