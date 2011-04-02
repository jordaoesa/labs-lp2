package lp2.labGuiado02;
import java.util.Scanner;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class MaiorMenorIdade{
	public static void main(String args[]){
	
		int idade1, idade2;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite a primeira idade: ");
		idade1 = input.nextInt();
		System.out.print("Digite a segunda idade: ");
		idade2 = input.nextInt();

		if (idade1 < idade2)
			System.out.println("Pessoa 1 mais nova");
		else if (idade1 == idade2)
			System.out.println("Idades iguais");
		else if (idade2 < idade1)
			System.out.println("Pessoa 2 mais nova");
		
	}

}
