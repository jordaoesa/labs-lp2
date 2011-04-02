package lp2.labGuiado02;
import java.util.Scanner;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class MaiorMenorIdade3{
	public static void main(String args[]){
	
		int maior, menor, idades[] = new int[3];
		Scanner input = new Scanner(System.in);
		
		for (int i=0; i<3; i++){
			System.out.print("Ano " + (i+1) + ": ");
			idades[i] = 2011 - input.nextInt();
		}
		
		maior = idades[0];
		menor = idades[0];
		
		for (int i=0; i<3; i++){
			if (idades[i] > maior) maior = idades[i];
			if (idades[i] < menor) menor = idades[i];
		}

		System.out.println("O mais velho tem: " + maior + " ano(s).");
		System.out.println("O mais novo tem: " + menor + " ano(s).");
	}

}
