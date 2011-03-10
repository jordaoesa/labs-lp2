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
	
	/**
	 * Metodo que mostra o menu principal do jogo.
	 */
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
	
	/**
	 * Metodo que inicia um novo jogo. Aqui eh criado um novo baralho.
	 */
	private static void startGame() {
		
		Baralho baralho = new Baralho();
		baralho.baralhar();
		jogar(baralho);
	}
	
	/**
	 * Metodo que pergunta ao usuario se ele deseja continuar jogando.
	 * @param baralho Este baralho foi criado no metodo startGame().
	 */
	private static void continuarJogando(Baralho baralho) {
		String opcao;
		System.out.println("\n# Deseja continuar Jogando? #");
		System.out.println("# 1 - Sim                   #");
		System.out.println("# outra opcao - Nao         #");
		System.out.println("#############################");
		System.out.print(">>> ");
		opcao = (new Scanner(System.in)).nextLine();
		if(opcao.equals("1")){
			verificaJogador = true;
			verificaMesa = true;
			jogar(baralho);
		}else{
			System.out.println("\n");
		}
	}

	/**
	 * Metodo que adiciona cartas a mao do jogador.
	 * @param mao Esta eh a mao do jogador que eh passada como parametro para este metodo adicionar cartas nela.
	 * @param baralho Este eh o baralho que eh utilizado para dar cartas tanto a mesa quanto ao jogador.
	 */
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
			}else{
				System.out.println("Nao ha mais cartas no baralho.");
				verificaJogador = false;
				verificaMesa = false;
			}
		} else if(opcao.equals("2")){
			System.out.println("Jogador nao quer mais cartas.");
			verificaJogador = false;
		} else{
			System.out.println("Jogador PASSOU A VEZ.");
		}
	}
	
	/**
	 * Metodo que adiciona cartas a mao da mesa.
	 * @param mao Esta eh a mao de cartas da mesa.
	 * @param baralho Este eh o baralho que eh utilizado para dar cartas tanto a mesa quanto ao jogador.
	 */
	private static void adicionarCartasMesa(Mao mao, Baralho baralho){
		if (baralho.númeroDeCartas() > 0){
			if (mao.valor() < 17){
				mao.adicionar(baralho.pegaCarta());
			}else{
				System.out.println("Mesa nao quer mais cartas.");
				verificaMesa = false;
			}
		}else{
			System.out.println("Nao ha mais cartas no baralho.");
			verificaMesa = false;
			verificaJogador = false;
		}
	}

	/**
	 * Metodo que contem todos os comandos necessarios para executar o jogo.
	 * @param baralho Este eh o baralho do jogo.
	 */
	private static void jogar(Baralho baralho){
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
				System.out.println("\n### Mesa Ganhou!!!!!! ###\n");
				System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
				System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
				System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
				System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
				if(maoJogador.valor() > 21){
					System.out.println("\n##Situacao do Jogo: Mao do Jogador Estourou.##\n");
				}else if(maoMesa.valor() == 21){
					System.out.println("\n##Situacao do Jogo: Mesa atingiu 21 pontos.##\n");
				}else if(maoMesa.valor() == maoJogador.valor()){
					System.out.println("\n##Situacao do Jogo: EMPATE.##\n");
				}
				break;
			}else if(maoMesa.valor() > 21 || maoJogador.valor() == 21){
				System.out.println("\n### Jogador Ganhou!!!!!! ###\n");
				System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
				System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
				System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
				System.out.printf("Pontos da Mesa: %d\n", maoMesa.valor());
				if(maoMesa.valor() > 21){
					System.out.println("\n##Situacao do Jogo: Mao da Mesa Estourou.##\n");
				}else if(maoJogador.valor() == 21){
					System.out.println("\n##Situacao do Jogo: Jogador atingiu 21 pontos.##\n");
				}else if(maoMesa.valor() == maoJogador.valor()){
					System.out.println("\n##Situacao do Jogo: EMPATE.##\n");
				}
				break;
			}
			
			if(!verificaJogador && !verificaMesa){
				
				if(maoJogador.valor() > maoMesa.valor()){
					System.out.println("\n### Jogador Ganhou!!!!!!! ###\n");
					System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
					System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
					System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
					System.out.printf("Pontos da Mesa: %d\n\n", maoMesa.valor());
					System.out.println("##Situacao do Jogo: Jogador tem mais pontos que a Mesa.##\n");
					break;
				}else if(maoMesa.valor() > maoJogador.valor() || maoJogador.valor() == maoMesa.valor()){
					System.out.println("\n### Mesa Ganhou!!!!! ###\n");
					System.out.printf("Mao do Jogador: %s\n", maoJogador.toString());
					System.out.printf("Pontos do Jogador: %d\n", maoJogador.valor());
					System.out.printf("Mao da Mesa: %s\n", maoMesa.toString());
					System.out.printf("Pontos da Mesa: %d\n\n", maoMesa.valor());
					System.out.println("##Situacao do Jogo: Mesa tem mais pontos ou mesma quantidade de pontos do Jogador.##\n");
					break;
				}
			}
		}
		System.out.printf("QUANTIDADE DE CARTAS NO BARALHO: %d\n", baralho.númeroDeCartas());
		if(baralho.númeroDeCartas() >= 2){
			continuarJogando(baralho);
		}else{
			System.out.println("\n### QUANTIDADE DE CARTAS INSUFICIENTE PARA JOGAR. ###\n");
			main(null);
		}
	}
}
