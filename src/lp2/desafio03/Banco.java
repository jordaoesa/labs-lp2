package lp2.desafio03;


/**
 * Um Banco.
 * 
 * @author felipebb
 * @author jordaoesa
 * @author marceloax
 * 
 */
public class Banco {

	private Aluno alunos[];

	/**
	 * 
	 * @param qtdAlunos
	 */
	public Banco(int qtdAlunos) {
		alunos = new Aluno[qtdAlunos];
		for (int i = 0; i < qtdAlunos; i++) {
			alunos[i] = new Aluno("a" + (i + 1));
		}
	}

	/**
	 * 
	 * @return
	 */
	public Aluno[] getAlunos() {
		return alunos;
	}

	/**
	 * 
	 * @param alunos
	 */
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	/**
	 * 
	 * @param nomeCredor
	 * @param nomeDevedor
	 * @param valorEmprestimo
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
			System.out
					.println("->>>> Nome(s) inexistente(s) na lista de alunos.");
			return;
		}

		// verifica dividas
		for (int i = 0; i < devedor.getRelacoes().size(); i++) {
			if (devedor.getRelacoes().get(i).getAluno().getNome()
					.equals(nomeCredor)) {
				System.out.println("->>>> O aluno " + nomeCredor
						+ " deve ao aluno " + nomeDevedor
						+ ". Ele deve PAGAR sua divida.");
				verifica = false;
				break;
			}
		}
		if (verifica) {
			credor.adicionaRelacao(new Relacao(devedor, valorEmprestimo));
		}

		// atualizando os atributos dos alunos
		credor.setSaldoCredor(credor.getSaldoCredor() + valorEmprestimo);
		devedor.setSaldoDevedor(devedor.getSaldoDevedor() + valorEmprestimo);
	}

	/**
	 * 
	 * @param nomePagador
	 * @param nomeBeneficiario
	 * @param valorPagamento
	 */
	public void novoPagamento(String nomePagador, String nomeBeneficiario,
			float valorPagamento) {

		Aluno pagador = null;
		Aluno beneficiario = null;
		boolean verifica = true;

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i].getNome().equals(nomePagador)) {
				pagador = alunos[i];
			}
			if (alunos[i].getNome().equals(nomeBeneficiario)) {
				beneficiario = alunos[i];
			}
		}

		if (pagador == null || beneficiario == null) {
			System.out
					.println("->>>> Nome(s) inexistente(s) na lista de alunos.");
			return;
		}

		// verifica dividas
		for (int i = 0; i < beneficiario.getRelacoes().size(); i++) {
			if (beneficiario.getRelacoes().get(i).getAluno().getNome()
					.equals(nomePagador)
					&& valorPagamento <= beneficiario.getRelacoes().get(i)
							.getValor()) {
				verifica = false;
				break;
			}
		}
		if (!verifica) {
			beneficiario
					.adicionaRelacao(new Relacao(pagador, (-valorPagamento)));
		} else {
			System.out
					.println("->>>> O aluno "
							+ nomePagador
							+ " nao deve ou o valor que esta sendo pago eh maior que a divida ao aluno "
							+ nomeBeneficiario);
		}

	}

	/**
	 * 
	 */
	public void imprimeRelacoes() {
		System.out.println("->>>> Relacoes: ");
		for (int i = 0; i < alunos.length; i++) {
			for (int j = 0; j < alunos[i].getRelacoes().size(); j++) {
				System.out.println(alunos[i].getNome()
						+ " tem saldo positivo de "
						+ alunos[i].getRelacoes().get(j).getValor() + " com "
						+ alunos[i].getRelacoes().get(j).getAluno().getNome());
			}
		}
		System.out.println("->>>> Fim de Relacoes.");
	}
	
	/**
	 * Metodo responsavel pelas simplificacoes dos saldos entre os alunos. 
	 * O objetivo eh diminuir a quantidade de pagamentos entre os alunos.
	 * Este metodo eh da ordem (n*n)*(m*m). Onde 'n' eh o numero de alunos 
	 * e 'm' eh a quantidade de relacoes entre eles.
	 */
	public void simplificacao(){
		
		for(int i=0; i<alunos.length; i++)//{
			for(int j=0; j<alunos.length; j++)//{
				for(int k=0; k<alunos[i].getRelacoes().size(); k++)//{
					if(alunos[i].getRelacoes().get(k).getAluno().getNome().equals(alunos[j].getNome()))//{
						for(int l=0; l<alunos.length; l++)//{
							for(int m=0; m<alunos[j].getRelacoes().size(); m++)//{
								if(alunos[j].getRelacoes().get(m).getAluno().getNome().equals(alunos[l].getNome()))//{
									for(int n=0; n<alunos[l].getRelacoes().size(); n++)//{
										if(alunos[l].getRelacoes().get(n).getAluno().getNome().equals(alunos[i].getNome())){
											float menor = alunos[i].getRelacoes().get(k).getValor();
											if(alunos[j].getRelacoes().get(m).getValor() < menor) menor = alunos[j].getRelacoes().get(m).getValor();
											if(alunos[l].getRelacoes().get(n).getValor() < menor) menor = alunos[l].getRelacoes().get(n).getValor();
											alunos[i].adicionaRelacao(new Relacao(alunos[j], (-menor)));
											alunos[j].adicionaRelacao(new Relacao(alunos[l], (-menor)));
											alunos[l].adicionaRelacao(new Relacao(alunos[i], (-menor)));
										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		this.imprimeRelacoes();
	}

}
