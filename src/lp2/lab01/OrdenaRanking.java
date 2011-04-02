package lp2.lab01;
import java.util.Scanner;

public class OrdenaRanking {

	/**
	 * Aluno: Jordao Ezequiel Serafim de Araujo
	 * Matricula: 21021526
	 * Aluno: Marcelo Avelino Xavier
	 * Matricula: 21115291
	 * Aluno: Felipe Brasileiro Barbosa
	 * Matricula: 21021067
	 */
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		int qtdGrupos, i, j;
		System.out.print("Informe a quantidade de grupos: ");
		qtdGrupos = input.nextInt();
		int pontuacoes[] = new int[qtdGrupos];
		for(i=0; i<qtdGrupos; i++){
			System.out.printf("Pontuacao Grupo %d: ", (i+1));
			pontuacoes[i] = input.nextInt();
		}
		int temp;
		for(i=0; i<qtdGrupos; i++){
			for(j=(i+1); j<qtdGrupos; j++){
				if(pontuacoes[i] > pontuacoes[j]){
					temp = pontuacoes[i];
					pontuacoes[i] = pontuacoes[j];
					pontuacoes[j] = temp;
				}
			}
		}
		for(i=0; i<qtdGrupos; i++){
			for(j=(i+1); j<qtdGrupos; j++){
				if(pontuacoes[i] == pontuacoes[j]){
					pontuacoes[i] = Integer.MAX_VALUE;
				}
			}
		}
		System.out.println("\n>>>>RANKING<<<<");
		for(i=0; i<qtdGrupos;i++){
			if(pontuacoes[i] < Integer.MAX_VALUE){
				System.out.println(pontuacoes[i]);
			}
		}
	}
}
