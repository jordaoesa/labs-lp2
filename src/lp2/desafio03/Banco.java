package lp2.desafio03;

/**
 * Um Banco que organiza os saldos entre alunos.
 * 
 * @author jordaoesa
 * @author marceloax
 * @author felipebb <br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 *         Aluno: Marcelo Avelino Xavier<br>
 *         Matricula: 21115291<br>
 * <br>
 * 
 *         Aluno: Felipe Brasileiro Barbosa<br>
 *         Matricula: 21021067<br>
 * <br>
 * 
 */
public class Banco {

	private Aluno alunos[];

	/**
	 * Instancia um objeto Banco.
	 * 
	 * @param qtdAlunos
	 *            A quantidade de alunos que o banco suporta.
	 */
	public Banco(int qtdAlunos) {
		alunos = new Aluno[qtdAlunos];
		for (int i = 0; i < qtdAlunos; i++) {
			alunos[i] = new Aluno("a" + (i + 1));
		}
	}

	/**
	 * Metodo acessor para o array de alunos.
	 * 
	 * @return O array de alunos
	 */
	public Aluno[] getAlunos() {
		return alunos;
	}

	/**
	 * Metodo modificador para o array de alunos.
	 * 
	 * @param alunos
	 *            O novo array de alunos.
	 */
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	/**
	 * Metodo responsavel por criar um novo emprestimo entre alunos.
	 * 
	 * @param nomeCredor
	 *            O nome do credor.
	 * @param nomeDevedor
	 *            O nome do devedor.
	 * @param valorEmprestimo
	 *            O valor do emprestimo.
	 */
	public void novoEmprestimo(String nomeCredor, String nomeDevedor,
			float valorEmprestimo) {

		Aluno devedor = null;
		Aluno credor = null;
		boolean verifica = true;

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i].getNome().equals(nomeCredor)) {
				credor = alunos[i];
			}
			if (alunos[i].getNome().equals(nomeDevedor)) {
				devedor = alunos[i];
			}
		}

		if (devedor == null || credor == null) {
			System.out.println("-> Nome(s) inexistente(s) na lista de alunos.");
			return;
		}

		if (devedor.getNome().equals(credor.getNome())) {
			System.out.println("Operacao indisponivel. Nomes iguais.");
			return;
		}

		// verifica dividas
		for (int i = 0; i < devedor.getRelacoes().size(); i++) {
			if (devedor.getRelacoes().get(i).getAluno().getNome()
					.equals(nomeCredor)) {
				System.out.println("-> O aluno " + nomeCredor
						+ " deve ao aluno " + nomeDevedor
						+ ". Ele deve PAGAR sua divida.");
				verifica = false;
				break;
			}
		}
		if (verifica) {
			credor.adicionaRelacao(new Relacao(devedor, valorEmprestimo));
		}
	}

	/**
	 * Metodo responsavel pelos pagamentos de dividas entre os alunos.
	 * 
	 * @param nomePagador
	 *            O nome do pagador.
	 * @param nomeBeneficiario
	 *            O nome do beneficiario.
	 * @param valorPagamento
	 *            O valor do pagamento.
	 */
	public void novoPagamento(String nomePagador, String nomeBeneficiario,
			float valorPagamento) {

		Aluno pagador = null;
		Aluno beneficiario = null;
		boolean verifica = false;

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i].getNome().equals(nomePagador)) {
				pagador = alunos[i];
			}
			if (alunos[i].getNome().equals(nomeBeneficiario)) {
				beneficiario = alunos[i];
			}
		}

		if (pagador == null || beneficiario == null) {
			System.out.println("-> Nome(s) inexistente(s) na lista de alunos.");
			return;
		}

		if (pagador.getNome().equals(beneficiario.getNome())) {
			System.out.println("Operacao invalida. Nomes iguais.");
			return;
		}

		// verifica dividas
		for (int i = 0; i < beneficiario.getRelacoes().size(); i++) {
			if (beneficiario.getRelacoes().get(i).getAluno().getNome()
					.equals(nomePagador)
					&& valorPagamento <= beneficiario.getRelacoes().get(i)
							.getValor()) {
				verifica = true;
				break;
			}
		}

		if (verifica) {
			beneficiario
					.adicionaRelacao(new Relacao(pagador, (-valorPagamento)));
		} else {
			System.out
					.println("-> O aluno "
							+ nomePagador
							+ " nao deve ou o valor que esta sendo pago eh maior que a divida ao aluno "
							+ nomeBeneficiario);
		}

	}

	/**
	 * Metodo responsavel por imprimir as relacoes que tem saldo direfente de
	 * zero entre os alunos.
	 */
	public void imprimeRelacoes() {
		String impressao = "";
		for (int i = 0; i < alunos.length; i++) {
			for (int j = 0; j < alunos[i].getRelacoes().size(); j++) {
				impressao += alunos[i].getRelacoes().get(j).getAluno()
						.getNome()
						+ " deve "
						+ alunos[i].getRelacoes().get(j).getValor()
						+ " reais ao aluno " + alunos[i].getNome() + "\n";
			}
		}
		if (impressao.equals("")) {
			System.out
					.println("##########################################################");
			System.out
					.println("# Saldos simplificados/zerados. Nao ha saldos pendentes. #");
			System.out
					.println("##########################################################");
		} else {
			impressao = impressao.substring(0, impressao.length() - 1);
			System.out
					.println("# Relacoes: ############################################");
			System.out.println(impressao);
			System.out
					.println("# Fim das Relacoes. ####################################");
		}
	}

	/**
	 * Metodo responsavel pelas simplificacoes dos saldos entre os alunos. O
	 * objetivo eh diminuir a quantidade de pagamentos entre os alunos. Metodo
	 * complexo, mas necessario, pois deve-se fazer muitas comparacoes ate se
	 * chegar ao local certo para simplificar.
	 */
	public void simplificacao() {

		for (int i = 0; i < alunos.length; i++)
			for (int j = 0; j < alunos.length; j++)
				for (int k = 0; k < alunos[i].getRelacoes().size(); k++)
					if (alunos[i].getRelacoes().get(k).getAluno().getNome().equals(alunos[j].getNome()))
						for (int l = 0; l < alunos.length; l++)
							for (int m = 0; m < alunos[j].getRelacoes().size(); m++)
								if (alunos[j].getRelacoes().get(m).getAluno().getNome().equals(alunos[l].getNome()))
									for (int n = 0; n < alunos[l].getRelacoes().size(); n++)
										if (alunos[l].getRelacoes().get(n).getAluno().getNome().equals(alunos[i].getNome())) {
											float menor = alunos[i].getRelacoes().get(k).getValor();
											if (alunos[j].getRelacoes().get(m).getValor() < menor) {
												menor = alunos[j].getRelacoes().get(m).getValor();
											}
											if (alunos[l].getRelacoes().get(n).getValor() < menor) {
												menor = alunos[l].getRelacoes().get(n).getValor();
											}
											alunos[i].adicionaRelacao(new Relacao(alunos[j], (-menor)));
											alunos[j].adicionaRelacao(new Relacao(alunos[l], (-menor)));
											alunos[l].adicionaRelacao(new Relacao(alunos[i], (-menor)));
										}
		this.imprimeRelacoes();
	}

}
