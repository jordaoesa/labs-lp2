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
		int votosNulos=0, votosBrancos=0, votosValidos=0;
		
		for (int i=0; i<qtdEleitores; i++){
			boolean verifica = false;
			int voto;
			System.out.print("Voto " +(i+1)+ ": ");
			voto = input.nextInt();
			if (voto == 99){
				break;
			} else if (voto == 0){
				votosBrancos += 1;
			} else{
				for(int j=0; j<candidatos.length; j++){
					if (voto == candidatos[j]){
						votos[j] += 1;
						votosValidos += 1;
						verifica = true;
						break;
					}
				}
				if (!verifica){
					votosNulos += 1;
				}
			}
			
		}
		
		System.out.println("Resultado da votacao para reitor da UFCG: \n");
		System.out.println("Votos Nulos: " + votosNulos);
		System.out.println("Votos em branco: " + votosBrancos);
		System.out.println("Votos validos: " + votosValidos + "\n");
		
		for (int i=0; i<votos.length; i++){
			System.out.println("Candidato " +candidatos[i]+ ": " +votos[i]+ " votos");
		}
		
		int maisVotado = 0;
		for(int i=0; i<votos.length; i++){
			if(votos[i] > votos[maisVotado]){
				maisVotado = i;
			}
		}
		
		System.out.printf("\nO novo reitor da UFCG eh o candidato %d.", candidatos[maisVotado]);
		
	}
}
