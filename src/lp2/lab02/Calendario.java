package lp2.lab02;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Aluno: Jordao Ezequiel Serafim de Araujo
 * Matricula: 21021526
 * Aluno: Marcelo Avelino Xavier
 * Matricula: 21115291
 * Aluno: Felipe Brasileiro Barbosa
 * Matricula: 21021067
 * 
 * @author jordaoesa
 * @author marceloax
 * @author felipebb
 */
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
				default:
					// naum faca nada
			}
		}while(opcao!=4);
	}
	
	/**
	 * Este metodo mostra o menu de opcoes que o usuario pode escolher.
	 */
	private static int menuOpcoes(){
		final int VALOR_MINIMO = 1;
		final int VALOR_MAXIMO = 4;
		
		System.out.println("#### MENU #########################");
		System.out.println("#1 - Dia da semana.               #");
		System.out.println("#2 - Ano bissexto.                #");
		System.out.println("#3 - Quantos dias uteis tem o mes.#");
		System.out.println("#4 - Sair                         #");
		System.out.println("###################################");
		
		return recebeInteiro(VALOR_MINIMO, VALOR_MAXIMO);
	}

	/**
	 * Metodo responsavel por encontrar o dia da semana atraves da data passada pelo usuario.
	 */
	private static void indicaDiaSemana() {
		
		final String STR_FORMATADA = "\n#####\nDia %d/%d/%d eh um(a): %s\n#####\n\n";
		final String SEMANA[] = {"", "Domingo", "Segunda Feira","Terca Feira","Quarta Feira","Quinta Feira","Sexta Feira","Sabado"};
		final int CONSTANTE_CORRECAO = 1;
		GregorianCalendar calendario = new GregorianCalendar();
		int dia, mes, ano;
		
		System.out.print("\nInsira o dia [1 a 31] ");
		dia = recebeInteiro(calendario.getMinimum(calendario.DAY_OF_MONTH), calendario.getMaximum(calendario.DAY_OF_MONTH));
		System.out.print("Insira o mes [1 a 12] ");
		mes = recebeInteiro( (calendario.getMinimum(calendario.MONTH) + CONSTANTE_CORRECAO) , (calendario.getMaximum(calendario.MONTH) + CONSTANTE_CORRECAO) );
		System.out.print("Insira o ano [ano desejado] ");
		ano = recebeInteiro(calendario.getMinimum(calendario.YEAR), calendario.getMaximum(calendario.YEAR));
		
		calendario.clear();
		calendario.set(ano, (mes - CONSTANTE_CORRECAO), dia);
		
		System.out.printf(STR_FORMATADA, dia, mes, ano, SEMANA[calendario.get(GregorianCalendar.DAY_OF_WEEK)]);	
	}
	
	/**
	 * Metodo responsavel por verificar se um dado ano passado pelo usuario eh ou nao bissext.
	 */
	private static void verificaAnoBissexto(){
		
		final String STR_FORMATADA1 = "\n#####\nO ano %d eh bissexto.\n#####\n\n", STR_FORMATADA2 = "\n#####\nO ano %d naum eh bissexto.\n#####\n\n";
		GregorianCalendar calendario = new GregorianCalendar();
		Scanner input = new Scanner(System.in);
		int ano;
		
		System.out.print("\nInsira o ano ");
		ano = recebeInteiro(calendario.getMinimum(calendario.YEAR), calendario.getMaximum(calendario.YEAR));
		
		if(calendario.isLeapYear(ano)){
			System.out.printf(STR_FORMATADA1, ano);
		}else{
			System.out.printf(STR_FORMATADA2, ano);
		}
	}
	
	/**
	 * Metodo responsavel por mostar ao usuario a quantidade de dias uteis que um dado mes tem.
	 */
	private static void diasUteisMes(){
		
		final int CONSTANTE_CORRECAO = 1, DIA = 1;
		final String MESES[] = {"Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		final String STR_FORMATADA = "\n#####\nO mes de %s de %d tem %d dias uteis.\n#####\n\n";
		GregorianCalendar calendario = new GregorianCalendar();
		int mes, ano, diasUteis = 0, qtdDias = 0;
		
		System.out.print("\nInsira o mes [1 a 12] ");
		mes = recebeInteiro( (calendario.getMinimum(calendario.MONTH) + CONSTANTE_CORRECAO) , (calendario.getMaximum(calendario.MONTH) + CONSTANTE_CORRECAO) );
		System.out.print("Insira o ano [ano desejado] ");
		ano = recebeInteiro(calendario.getMinimum(calendario.YEAR), calendario.getMaximum(calendario.YEAR));
		
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
			if(calendario.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY 
					&& calendario.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY){
				diasUteis++;
			}
		}
		
		System.out.printf(STR_FORMATADA, MESES[mes], ano, diasUteis);
		
	}
	
	/**
	 * Este metodo eh responsavel pelo tratamento de erros na entrada dos valores.
	 * Sao passados dois valores inteiros que representam o valor minimo que pode
	 * ser recebido e o valor maximo que pode ser recebido.
	 * 
	 * @param menorValor
	 * @param maiorValor
	 */
	private static int recebeInteiro(int menorValor, int maiorValor){
		while (true){
			try{
				String valor;
				int numero;
				do{
					System.out.print(">>> ");
					valor = (new Scanner(System.in)).nextLine();
					numero = Integer.parseInt(valor);
				}while(numero < menorValor || numero > maiorValor);
				return numero;
			}catch(NumberFormatException num){
				// naum faca nada
			}
		}
	}

}
