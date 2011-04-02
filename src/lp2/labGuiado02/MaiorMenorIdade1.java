package lp2.labGuiado02;
import java.util.Scanner;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class MaiorMenorIdade1{
	public static void main(String args[]){
	
		int ano1, ano2, ano3, maior, menor;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ano1: ");
		ano1 = input.nextInt();
		System.out.print("Ano2: ");
		ano2 = input.nextInt();
		System.out.print("Ano3: ");
		ano3 = input.nextInt();
		
		maior = ano1;
		menor = ano1;
		
		if (ano2 > maior) maior = ano2;
		if (ano3 > maior) maior = ano3;
		if (ano2 < menor) menor = ano2;
		if (ano3 < menor) menor = ano3;

		System.out.println("O maior ano eh: " + maior);
		System.out.println("O menor ano eh: " + menor);
	}

}
