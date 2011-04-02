package lp2.aula1;
import java.util.*;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class Eleicao{
	public static void main(String args[]){
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a sua idade: ");
		int idade = sc.nextInt();
		
		if (idade < 16){
			System.out.println("Voce nao esta habilitado a votar!");
			System.out.println("Voce deve ter pelo menos 16 anos!");
		}
		else{
			System.out.println("Eleitor! Exerca o seu direito");
		}
	}
}