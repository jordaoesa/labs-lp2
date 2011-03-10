package lp2.lab03;
import java.util.Scanner;

import p1.aplic.cartas.*;

/**
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 * @author jordaoesa
 */
public class VinteUmPreparacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		Mao maoJogador = new Mao();
		baralho.baralhar();
		
		String opcao = "";
		final int NUMERO_MININO = 1;
		do{
			System.out.print("\nSua mao tem esta(s) carta(s): " + maoJogador);
			System.out.printf("\nSua mao tem %d cartas.\nDigite algo para pegar uma carta: ", maoJogador.númeroDeCartas());
			opcao = (new Scanner(System.in)).nextLine();
			if(baralho.númeroDeCartas() >= NUMERO_MININO){
				maoJogador.adicionar(baralho.pegaCarta());
			}else if(baralho.númeroDeCartas() == 0){
				System.out.println("O BARALHO ACABOU.");
			}
		}while (!opcao.equals("t"));
	}
}
