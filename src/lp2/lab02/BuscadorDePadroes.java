package lp2.lab02;
import java.util.Scanner;

public class BuscadorDePadroes {

	/**
	 * Aluno: Jordao Ezequiel Serafim de Araujo
	 * Matricula: 21021526
	 */
	public static void main(String[] args) {
		String sequenciaRecebida = args[0], padrao;
		Scanner input = new Scanner(System.in);
		int numOcorrencias=0;
		
		sequenciaRecebida = sequenciaRecebida.toLowerCase();
		sequenciaRecebida = sequenciaRecebida.replace(" ", "");
		
		System.out.print("Informe o padrao desejado: ");
		padrao = input.next();
		
		padrao = padrao.toLowerCase();
		padrao = padrao.replace(" ", "");
		
		for(int i=0; i<sequenciaRecebida.length(); i++)
			if(sequenciaRecebida.contains(padrao)){
				sequenciaRecebida = sequenciaRecebida.replaceFirst(padrao, padrao.toUpperCase());
				numOcorrencias++;
			}
		if(numOcorrencias == 0) System.out.printf("ocorrencias: %d\n", numOcorrencias);
		else System.out.printf("ocorrencias: %d - %s\n", numOcorrencias, sequenciaRecebida);
	}
}