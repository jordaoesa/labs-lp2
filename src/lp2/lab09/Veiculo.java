package lp2.lab09;

import java.util.List;

public abstract class Veiculo {
	
	public abstract List<String> consertosPassados();
	public abstract List<Verificacao> verificacoes();
	public abstract void adicionaVerificacao(Verificacao v);
	public abstract void consertar(Verificacao v);
	public abstract void limpar();
	public abstract int trocarPneus();
	public abstract boolean checaPneuAvariado(int i);

}
