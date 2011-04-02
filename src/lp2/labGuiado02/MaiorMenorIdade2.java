package lp2.labGuiado02;
import java.util.Scanner;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class MaiorMenorIdade2{
	public static void main(String args[]){
	
		int anos[] = new int[3], maior, menor;
		Scanner input = new Scanner(System.in);
		
		for (int i=0; i<3; i++){
			System.out.print("Ano " + (i+1) + ": ");
			anos[i] = input.nextInt();
		}
		
		maior = 2011-anos[0];
		menor = 2011-anos[0];
		
		if ((2011-anos[1]) > maior) maior = (2011-anos[1]);
		if ((2011-anos[2]) > maior) maior = (2011-anos[2]);
		if ((2011-anos[1]) < menor) menor = (2011-anos[1]);
		if ((2011-anos[2]) < menor) menor = (2011-anos[2]);

		System.out.println("O mais velho tem: " + maior + " ano(s).");
		System.out.println("O mais novo tem: " + menor + " ano(s).");
	}

}
