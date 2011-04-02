package lp2.lab01;
import java.util.Scanner;

/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/

public class AvaliaAluno {
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		int p, pX;
		double somaTotal = 0.0, media;

		System.out.print("Quantidade de provas realizadas na disciplina: ");
		p = input.nextInt();

		double notas[] = new double[p];
		for(int i=0; i<p; i++){
			notas[i] = 0.0;
		}

		System.out.print("Quantidade de provas realizadas por X: ");
		pX = input.nextInt();
		
		for (int i=0; i<pX; i++){
			System.out.print("Nota " + (i+1) + ": ");
			notas[i] = input.nextDouble();
		}
		
		for (int i=0; i<p; i++){
			somaTotal += notas[i];
		}
		media = somaTotal/p;

		System.out.println("A media parcial do aluno X eh: " + media);
		
		if (media >= 4.0 && media < 7.0){

			double notaPrecisa, notaMedia, notaFinal;				
			
			notaMedia = media*(60/100.0);
			notaPrecisa = ( 5 - media*(60/100.0) ) / (40/100.0);
			System.out.println("O aluno X precisa tirar " + notaPrecisa + " na prova final.");
			System.out.print("Informe a nota tirada na final: ");
			notaFinal = input.nextDouble();

			if (notaFinal >= notaPrecisa){
				System.out.println("O aluno X foi aprovado na Disciplina.");
			} else{
				System.out.println("O aluno X foi reprovado na Disciplina.");
			}
		} else if (media >= 7){
			System.out.println("A media final do aluno X eh: " + media);
			System.out.println("O aluno X foi aprovado na Disciplina.");
		} else{
			System.out.println("A media final do aluno X eh: " + media);
			System.out.println("O aluno X foi reprovado na Disciplina.");
		}
	}
}
