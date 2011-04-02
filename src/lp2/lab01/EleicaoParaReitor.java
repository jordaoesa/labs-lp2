//PROGRAMA INCOMPLETO

package lp2.lab01;
import java.util.Scanner;

/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/

public class EleicaoParaReitor{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int candidatos[] = new int[ args.length - 1 ], votos[] = new int[ args.length - 1 ];
		int qtdEleitores = Integer.parseInt(args[0]);

		for (int i=0; i<(args.length - 1); i++){
			votos[i] = 0;
		}

		for (int i=1; i<args.length; i++){
			candidatos[i-1] = Integer.parseInt(args[i]);
		}
		
		for (int i=0; i<qtdEleitores; i++){
			int voto;
			System.out.print("Voto " +(i+1)+ ": ");
			voto = input.nextInt();
			for(int j=0; j<candidatos.length; j++){
				if (voto == candidatos[j]){
					votos[j] += 1;
				}
			}
			
		}

		for (int i=0; i<votos.length; i++){
			System.out.println(votos[i]);
		}
		



	}
}
