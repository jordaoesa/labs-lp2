package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

/**
 * Uma pessoa com implementacao de Cidadao e Contribuinte.
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Pessoa implements Cidadao, Contribuinte {

	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	private double salario;
	private List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();

	/**
	 * Instancia uma nova Pessoa.
	 * 
	 * @param nome
	 *            O nome da pessoa.
	 * @param rg
	 *            O RG da pessoa.
	 * @param cpf
	 *            O CPF da pessoa.
	 * @param idade
	 *            A idade da pessoa.
	 * @param salario
	 *            O salario da pessoa.
	 * @param listaDeContatos
	 *            A lista de contatos pelos quais a pessoa pode ser contactada.
	 */
	public Pessoa(String nome, String rg, String cpf, int idade,
			double salario, List<ItemDeContato> listaDeContatos) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.idade = idade;
		this.salario = salario;
		this.listaDeContatos = listaDeContatos;
	}

	/**
	 * Metodo que retorna o valor que a pessoa precisa pagar de Imposto de
	 * Renda.
	 */
	@Override
	public double pagaIR() {
		if (salario >= 0 && salario <= 1500)
			return 0;
		else if (salario >= 1500.01 && salario <= 3000.00)
			return 0.15 * salario;
		else if (salario > 3000)
			return 0.25 * salario;
		return -1;
	}

	/**
	 * Metodo que retorna o CPF da pessoa.
	 */
	@Override
	public String getCPF() {
		return cpf;
	}

	/**
	 * Metodo que verifica se uma pessoa esta apta a votar ou nao.
	 */
	@Override
	public boolean vota() {
		if (idade < 16) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que retorna o RG de uma pessoa.
	 */
	@Override
	public String getRG() {
		return rg;
	}

	/**
	 * Metodo que compara se duas pessoas sao iguais. Se os nomes dessas pessoas
	 * forem iguais, automaticamente elas ja serao iguais. Se o nome nao eh
	 * igual mas ou o CPF ou o RG ou ambos sao iguais, entao estas duas pessoas
	 * ainda sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa pessoa = (Pessoa) obj;
		if (pessoa.getNome().equalsIgnoreCase(getNome())) {
			return true;
		} else {
			if (pessoa.getCPF().equals(getCPF())
					|| pessoa.getRG().equals(getRG())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna o nome da pessoa.
	 * 
	 * @return O nome da pessoa.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define um novo nome para a pessoa.
	 * 
	 * @param nome
	 *            O novo nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Define um novo CPF para a pessoa caso este seja valido.
	 * 
	 * @param cpf
	 *            O novo CPF.
	 */
	public void setCPF(String cpf) {
		if (verificaCPF(cpf)) {
			this.cpf = cpf;
		}
	}

	/**
	 * Define um novo RG para a pessoa.
	 * 
	 * @param rg
	 *            O novo RG.
	 */
	public void setRG(String rg) {
		this.rg = rg;
	}

	/**
	 * Retorna a idade da pessoa.
	 * 
	 * @return A idade.
	 */
	public int getIdade() {
		return this.idade;
	}

	/**
	 * Define uma nova idade para a pessoa.
	 * 
	 * @param idade
	 *            A nova idade.
	 */
	public void setIdade(int idade) {
		if (idade > 0) {
			this.idade = idade;
		}
	}

	/**
	 * Retorna o salario da pessoa.
	 * 
	 * @return O salario.
	 */
	public double getSalario() {
		return this.salario;
	}

	/**
	 * Define um novo salario para a pessoa.
	 * 
	 * @param salario
	 *            O novo salario.
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Retorna a lista de contatos da pessoa.
	 * 
	 * @return A lista de contatos.
	 */
	public List<ItemDeContato> getListaDeContatos() {
		return this.listaDeContatos;
	}

	/**
	 * Define uma nova lista de contatos para a pessoa.
	 * 
	 * @param listaDeContatos
	 *            A nova lista de contatos.
	 */
	public void setListaDeContatos(List<ItemDeContato> listaDeContatos) {
		this.listaDeContatos = listaDeContatos;
	}

	/**
	 * Adiciona um novo contato a lista de contatos da pessoa caso este ja nao
	 * esteja la e tambem ele seja valido.
	 * 
	 * @param novoContato
	 *            O novo contato.
	 * @return Retorna true caso o contato seja adicionado e false caso
	 *         contrario.
	 */
	public boolean adicionarContato(ItemDeContato novoContato) {
		for (ItemDeContato contato : listaDeContatos) {
			if (contato.equals(novoContato)) {
				return false;
			}
		}
		listaDeContatos.add(novoContato);
		return true;
	}

	/**
	 * Metodo responsavel por verificar se um CPF eh valido ou nao. Este metodo
	 * valida um CPF a partir da verificacao dos dois ultimos digitos que
	 * compoem o CPF. <br>
	 * Tutorial para verificacao de CPF:
	 * http://www.profcardy.com/artigos/cpf.php<br>
	 * 
	 * @param cpf
	 *            A String contendo o CPF a ser verificado.
	 * @return Retorna true caso o CPF seja valido e false caso contrario.
	 */
	public static boolean verificaCPF(String cpf) {

		int decimo, decimoPrimeiro, soma = 0, mult = 10, resto;
		int cpfInt[] = new int[11];

		if (cpf.length() < 11 || cpf.length() > 11 || contaDigitos(cpf) < 11) {
			return false;
		}

		for (int i = 0; i < 11; i++) {
			cpfInt[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
		}

		// Verifica decimo digito
		for (int i = 0; i < 9; i++) {
			soma += (mult * cpfInt[i]);
			mult--;
		}

		resto = soma % 11;
		decimo = (resto == 0 || resto == 1) ? 0 : 11 - resto;

		if (decimo == cpfInt[9]) {

			mult = 11;
			soma = 0;

			// Verifica o decimo-primeiro digito
			for (int i = 0; i < 10; i++) {
				soma += (mult * cpfInt[i]);
				mult--;
			}

			resto = soma % 11;
			decimoPrimeiro = (resto == 0 || resto == 1) ? 0 : 11 - resto;

			if (decimoPrimeiro == cpfInt[10]) {
				return true;
			}

		}

		return false;
	}

	/**
	 * Metodo que conta quantos digitos existem em uma variavel String.
	 * 
	 * @param numero
	 *            A String a ser verificada.
	 * @return A quantidade de digitos que a String contem.
	 */
	private static int contaDigitos(String numero) {
		int contador = 0;
		for (int i = 0; i < numero.length(); i++) {
			if (numero.charAt(i) >= '0' && numero.charAt(i) <= '9') {
				contador++;
			}
		}
		return contador;
	}

}
