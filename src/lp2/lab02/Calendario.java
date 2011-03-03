package lp2.lab02;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Calendario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	private static void diasUteisMes(){
		
		Calendar calendario = new GregorianCalendar();
		final int CONSTANTE = 1;
		int mes, ano, diasUteis=0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nInsira o mes [1=Janeiro, ..., 12=Dezembro]: ");
		mes = input.nextInt();
		System.out.print("Insira o ano [Ano desejado]: ");
		ano = input.nextInt();
		
		mes -= CONSTANTE;
		
		calendario.set(ano, mes, 0);
		
	}

}
