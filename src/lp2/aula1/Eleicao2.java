package lp2.aula1;
import java.util.*;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class Eleicao2{
	public static void main(String args[]){
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a sua idade: ");
		int idade = sc.nextInt();
	
		if (idade < 16){
			System.out.println("Voce nao esta habilitado a votar!");
			System.out.println("Voce deve ter pelo menos 16 anos!");
		} else if (idade < 18)
			System.out.println("Jovem! Voce tem o direito de votar");
		 else if (idade < 70)
			System.out.println("Eleitor! Exerca o seu direito");
		 else if (idade >= 70)
			System.out.println("Cidadao! Seu voto nao eh obrigatorio!");
		
	}
}