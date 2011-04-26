package lp2.lab10;

import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Cidadao, Contribuinte {

	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	private double salario;
	private List<ItemDeContato> listaDeContatos = new ArrayList<ItemDeContato>();

	public Pessoa(String nome, String rg, String cpf, int idade,
			double salario) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.idade = idade;
		this.salario = salario;
	}

	@Override
	public double pagaIR() {
		if (salario <= 1500)
			return 0;
		else if (salario >= 1500.01 && salario <= 3000.00)
			return 0.15 * salario;
		else if (salario > 3000)
			return 0.25 * salario;
		return -1;
	}

	@Override
	public String getCPF() {
		return cpf;
	}

	@Override
	public boolean vota() {
		if (idade < 16) {
			return false;
		}
		return true;
	}

	@Override
	public String getRG() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String cpf) {
		if (validaCPF(cpf)) {
			this.cpf = cpf;
		}
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		if (idade > 0) {
			this.idade = idade;
		}
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<ItemDeContato> getListaDeContatos() {
		return this.listaDeContatos;
	}

	public void setListaDeContatos(List<ItemDeContato> listaDeContatos) {
		this.listaDeContatos = listaDeContatos;
	}

	public boolean validaCPF(String cpf) {
		if (cpf.length() < 11 || cpf.length() > 11)
			return false;
		return true;
	}

}
