package lp2.lab02;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * 
 * @author jordaoesa
 * */

public class Calendario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		lacoMain();
	}
	
	/**
	 * Este metodo define o laco principal do programa.
	 */
	
	private static void lacoMain(){
		int opcao=4;
		do{
			opcao = menuOpcoes();
			switch (opcao) {
				case 1:
					indicaDiaSemana();
					break;
				case 2:
					verificaAnoBissexto();
					break;
				case 3:
					diasUteisMes();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("\nOpcao invalida. Digite valores no intervalo [1 <= valor <= 4].\n");
			}
		}while(opcao!=4);
	}
	
	/**
	 * Este metodo mostra o menu de opcoes que o usuario pode escolher.
	 */
	private static int menuOpcoes(){
		int opcao;
		Scanner input = new Scanner(System.in);
		
		System.out.println("#### MENU #########################");
		System.out.println("#1 - Dia da semana.               #");
		System.out.println("#2 - Ano bissexto.                #");
		System.out.println("#3 - Quantos dias uteis tem o mes.#");
		System.out.println("#4 - Sair                         #");
		System.out.println("###################################");
		System.out.print("Opcao: ");
		opcao = input.nextInt();
		
		return opcao;
	}

	/**
	 * Metodo responsavel por encontrar o dia da semana atraves da data passada pelo usuario.
	 */
	private static void indicaDiaSemana() {
		Calendar calendario = new GregorianCalendar();
		final String SEMANA[] = {"Domingo", "Segunda Feira","Terca Feira","Quarta Feira","Quinta Feira","Sexta Feira","Sabado"};
		final int CONSTANTE = 1;
		int dia, mes, ano;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nInsira o dia [1 a 31]: ");
		dia = input.nextInt();
		System.out.print("Insira o mes [1=Janeiro, ..., 12=Dezembro]: ");
		mes = input.nextInt();
		System.out.print("Insira o ano [Ano desejado]: ");
		ano = input.nextInt();
		
		dia -= CONSTANTE;
		mes -= CONSTANTE;
		
		calendario.clear();
		calendario.set(ano, mes, dia);
		
		System.out.printf("\nDia %d/%d/%d eh um(a): %s\n\n", dia+CONSTANTE, mes+CONSTANTE, ano, SEMANA[calendario.get(Calendar.DAY_OF_WEEK)]);	
	}
	
	/**
	 * Metodo responsavel por verificar se um dado ano passado pelo usuario eh ou nao bissext.
	 */
	private static void verificaAnoBissexto(){
		GregorianCalendar calendario = new GregorianCalendar();
		Scanner input = new Scanner(System.in);
		int ano;
		System.out.print("\nInsira o ano: ");
		ano = input.nextInt();
		
		if(calendario.isLeapYear(ano)){
			System.out.printf("\nO ano %d eh bissexto.\n\n", ano);
		}else{
			System.out.printf("\nO ano %d naum eh bissexto.\n\n", ano);
		}
	}
	
	/**
	 * Metodo responsavel por mostar ao usuario a quantidade de dias uteis que um dado mes tem.
	 */
	private static void diasUteisMes(){
		
		Calendar calendario = new GregorianCalendar();
		GregorianCalendar calendar = new GregorianCalendar();
		final int CONSTANTE = 1;
		int mes, ano, diasUteis=0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nInsira o mes [1=Janeiro, ..., 12=Dezembro]: ");
		mes = input.nextInt();
		System.out.print("Insira o ano [Ano desejado]: ");
		ano = input.nextInt();
		
		mes -= CONSTANTE;
		
		calendario.set(ano, mes, 0);
		
		if(calendar.isLeapYear(ano)){
			if(mes+CONSTANTE == 2){
				for(int i=1; i<=28; i++){
					if(calendar.get(Calendar.DAY_OF_WEEK) != 0 && calendar.get(Calendar.DAY_OF_WEEK) != 6){
						diasUteis++;
					}
				}
			}
		}
		System.out.println(diasUteis);
		
	}

}
