package lp2.labGuiado01;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class IdadeParaVotacao{
	public static void main(String args[]){
	
		int idade = 2011 - 1991;
	
		if (idade >= 16 && idade < 18)
			System.out.println("Eleitor apto - voto nao obrigatorio");
		else if (idade >= 18 && idade < 70)
			System.out.println("Eleitor apto - voto obrigatorio");
		else if (idade >= 70)
			System.out.println("Eleitor apto - voto nao obrigatorio");
	}
}
