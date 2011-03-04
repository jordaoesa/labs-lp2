package lp2.lab03;

import p1.aplic.cartas.*;
import java.util.Scanner;

/**
 * Aluno: Jordao Ezequiel Serafim de Araujo 
 * Matricula: 21021526
 * 
 * @author jordaoesa
 */
public class VinteUmJogo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			menu();
		}

	}
	static boolean verificaJogador = true;
	static boolean verificaMesa = true;

	private static void menu(){
		verificaJogador = true;
		verificaMesa = true;
		String opcao;
		System.out.println("\n# MENU ###############");
		System.out.println("# 1 - Jogar          #");
		System.out.println("# outra opcao - Sair #");
		System.out.println("######################");
		System.out.print(">>> ");
		opcao = (new Scanner(System.in)).nextLine();
		
		if(opcao.equals("1")){
			startGame();
		} else{
			System.exit(0);
		}
		
	}
	
	private static void startGame() {
		
		Baralho baralho = new Baralho();
		baralho.baralhar();

		Mao maoJogador = new Mao();
		Mao maoMesa = new Mao();
		
		maoJogador.adicionar(baralho.pegaCarta());
		maoMesa.adicionar(baralho.pegaCarta());
		
		while (true) {	
			
			System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
			System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());

			System.out.printf("Quantidade de cartas da Mesa: %s\n\n", maoMesa.númeroDeCartas());
			
			if(verificaJogador){
				adicionarCartasJogador(maoJogador, baralho);
			}
			if(verificaMesa){
				adicionarCartasMesa(maoMesa, baralho);
			}
			
			if(maoJogador.valor() > 21 || maoMesa.valor() == 21){
				System.out.println("Mesa Ganhou!!!!!!\n");
				System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
				System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
				System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
				System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
				break;
			}else if(maoMesa.valor() > 21 || maoJogador.valor() == 21){
				System.out.println("Jogador Ganhou!!!!!!\n");
				System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
				System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
				System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
				System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
				break;
			}
			
			if(!verificaJogador && !verificaMesa){
				if(maoJogador.valor() > maoMesa.valor()){
					System.out.println("Jogador Ganhou!!!!!!!\n");
					System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
					System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
					System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
					System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
					break;
				}else if(maoMesa.valor() > maoJogador.valor() || maoJogador.valor() == maoMesa.valor()){
					System.out.println("Mesa Ganhou!!!!!\n");
					System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
					System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
					System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
					System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
					break;
				}
			}	
		}
	}
	
	private static void adicionarCartasJogador(Mao mao, Baralho baralho){
		String opcao;
		System.out.println("# Deseja pegar uma carta? ####");
		System.out.println("# 1 - Sim                    #");
		System.out.println("# 2 - Parei por aqui         #");
		System.out.println("# outra opcao - Passar a vez #");
		System.out.println("##############################");
		System.out.print(">>> ");
		opcao = (new Scanner(System.in)).nextLine();
		if(opcao.equals("1")){
			if(baralho.númeroDeCartas() > 0){
				mao.adicionar(baralho.pegaCarta());
			}
		} else if(opcao.equals("2")){
			verificaJogador = false;
		}
	}
	
	private static void adicionarCartasMesa(Mao mao, Baralho baralho){
		if (baralho.númeroDeCartas() > 0){
			if (mao.valor() < 17){
				mao.adicionar(baralho.pegaCarta());
			}else{
				verificaMesa = false;
			}
		}
	}

}
