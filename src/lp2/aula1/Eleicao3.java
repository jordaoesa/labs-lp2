package lp2.aula1;
import java.util.*;
/**
*Aluno: Jordao Ezequiel Serafim de Araujo
*Matricula: 21021526
*/
public class Eleicao3{
	public static void main(String args[]){
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a sua idade: ");
		int idade = sc.nextInt();
	
		if (idade < 16){
			System.out.println("Voce nao esta habilitado a votar!");
			System.out.println("Voce deve ter pelo menos 16 anos!");
		} else if (idade >= 18 && idade < 70)
			System.out.println("Para voce, votar eh um direito e uma obrigacao!");
		else if ((idade >= 16 && idade < 18) || idade >= 70)
			System.out.println("Para voce, votar eh um direito, mas nao eh uma obrigacao!");
			
	}
}