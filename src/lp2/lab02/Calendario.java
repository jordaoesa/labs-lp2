package lp2.lab02;

import java.io.ObjectInputStream.GetField;
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
		GregorianCalendar calendario = new GregorianCalendar();
		final String SEMANA[] = {"", "Domingo", "Segunda Feira","Terca Feira","Quarta Feira","Quinta Feira","Sexta Feira","Sabado"};
		final int CONSTANTE_CORRECAO = 1;
		int dia, mes, ano;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nInsira o dia [1 a 31]: ");
		dia = input.nextInt();
		System.out.print("Insira o mes [1 a 12]: ");
		mes = input.nextInt();
		System.out.print("Insira o ano [ano desejado]: ");
		ano = input.nextInt();
		
		calendario.clear();
		calendario.set(ano, (mes - CONSTANTE_CORRECAO), dia);
		
		System.out.printf("\nDia %d/%d/%d eh um(a): %s\n\n", dia, mes, ano, SEMANA[calendario.get(Calendar.DAY_OF_WEEK)]);	
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
		
		GregorianCalendar calendario = new GregorianCalendar();
		final int CONSTANTE_CORRECAO = 1, DIA = 1;
		int mes, ano, diasUteis = 0, qtdDias = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nInsira o mes [1 a 12]: ");
		mes = input.nextInt();
		System.out.print("Insira o ano [ano desejado]: ");
		ano = input.nextInt();
		
		mes -= CONSTANTE_CORRECAO;
		
		calendario.set(ano, mes, DIA);
		
		if(mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11){
			qtdDias = 31;
		} else if(mes == 3 || mes == 5 || mes == 8 || mes == 10){
			qtdDias = 31;
		} else if(mes == 1){
			if(calendario.isLeapYear(ano)){
				qtdDias = 29;
			} else{
				qtdDias = 28;
			}
		}
		
		for(int i = DIA; i <= qtdDias; i++){
			calendario.set(ano, mes, i);
			if(calendario.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY && calendario.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY){
				diasUteis++;
			}
		}
		
		System.out.println("dias uteis: "+diasUteis);
		
	}

}
