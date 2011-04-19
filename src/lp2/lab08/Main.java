package lp2.lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsavel pelas iteracoes e execucoes de metodos entre as
 * Disciplinas
 * 
 * @author jordaoesa<br>
 * <br>
 *         Aluno: Jordao Ezequiel Serafim de Araujo<br>
 *         Matricula: 21021526<br>
 * <br>
 * 
 */
public class Main {

	private static List<Convencional> listaDisciplinas = new ArrayList<Convencional>();
	private static String disciplinasSendoCursadas[] = null;
	private static String disciplinasMaiorQueSeteJaImpresas = "";
	private static String disciplinasMenorQueSeteJaImpresas = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String caminho =
		// "C:\\Users\\lsi\\workspace\\labs-lp2\\src\\lp2\\lab08\\disciplinas.txt";
		// String caminho =
		// "C:\\Users\\Seven\\workspace\\labs-lp2\\src\\lp2\\lab08\\disciplinas.txt";
		// String caminho =
		// "/home/jordaoesa/workspace/labs-lp2/src/lp2/lab08/disciplinas.txt";
		String caminho = "/home/jordao/workspace/labs-lp2/src/lp2/lab08/disciplinas.txt";

		start(caminho);
		System.out.println();
		getNotasDisciplinasSendoCursadas();
		System.out.println();
		disciplinasComMediaMenorQueSete();
		System.out.println();
		disciplinasPosRequisitos();
		System.out.println();
		disciplinasMediaMaiorQueSete();

	}

	private static void start(String caminho) {
		String nomeArquivo = caminho.substring(caminho.lastIndexOf("/") + 1,
				caminho.length());
		System.out.println("Lendo informacao das disciplinas de " + nomeArquivo
				+ "...");
		instanciaDisciplinas(lerArquivo(caminho));
		String nomesDisciplinas = "";
		for (Convencional disciplina : listaDisciplinas) {
			nomesDisciplinas += disciplina.getNome() + ", ";
		}
		nomesDisciplinas = nomesDisciplinas.substring(0,
				nomesDisciplinas.length() - 2)
				+ ".";
		System.out.println(listaDisciplinas.size()
				+ " disciplinas encontradas: " + nomesDisciplinas);
	}

	private static List<String[]> lerArquivo(String caminho) {
		List<String[]> listaDisciplinasArquivo = new ArrayList<String[]>();
		try {
			File file = new File(caminho);
			Scanner input;
			input = new Scanner(file);
			while (input.hasNextLine()) {
				String temp[] = input.nextLine().split(", ");
				listaDisciplinasArquivo.add(temp);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.err
					.println("Arquivo nao encontrado. Corriga nome/diretorio do arquivo e reinicie o programa.");
			System.exit(-1);
		}
		return listaDisciplinasArquivo;
	}

	private static void instanciaDisciplinas(
			List<String[]> listaDisciplinasArquivo) {
		for (String disciplina[] : listaDisciplinasArquivo) {
			List<String> posRequisitos = new ArrayList<String>();
			for (int i = 4; i < disciplina.length; i++) {
				posRequisitos.add(disciplina[i]);
			}
			if (disciplina[2].equals("convencional")) {
				if (Integer.parseInt(disciplina[3]) == 0) {
					listaDisciplinas.add(new Convencional(disciplina[0],
							Integer.parseInt(disciplina[1]), posRequisitos));
				} else {
					listaDisciplinas.add(new ConvencionalEliminandoBaixa(
							disciplina[0], Integer.parseInt(disciplina[1]),
							posRequisitos, Integer.parseInt(disciplina[3])));
				}
			} else if (disciplina[2].equals("minitestes")) {
				if (Integer.parseInt(disciplina[3]) == 0) {
					listaDisciplinas.add(new Minitestes(disciplina[0], Integer
							.parseInt(disciplina[1]), posRequisitos));
				} else {
					listaDisciplinas.add(new MinitestesEliminandoBaixa(
							disciplina[0], Integer.parseInt(disciplina[1]),
							posRequisitos, Integer.parseInt(disciplina[3])));
				}
			}
		}
	}

	private static String[] disciplinasSendoCursadas() {
		System.out
				.println("Liste as disciplinas sendo cursadas neste periodo (disciplina1, disciplina2, ...):");
		disciplinasSendoCursadas = (new Scanner(System.in)).nextLine()
				.replace(" ", "").split(",");
		for (int i = 0; i < disciplinasSendoCursadas.length; i++) {
			for (int j = i + 1; j < disciplinasSendoCursadas.length; j++) {
				if (disciplinasSendoCursadas[i]
						.equalsIgnoreCase(disciplinasSendoCursadas[j])) {
					for (Convencional disc : listaDisciplinas) {
						if (disc.getNome().equalsIgnoreCase(
								disciplinasSendoCursadas[i])) {
							System.err
									.println("Uma mesma disciplina aparece mais de uma vez.");
							System.exit(-1);
						}
					}

				}
			}
		}
		return disciplinasSendoCursadas;
	}

	private static void getNotasDisciplinasSendoCursadas() {
		boolean encontrou = false;
		for (String disciplina : disciplinasSendoCursadas()) {
			for (Convencional disc : listaDisciplinas) {
				if (disciplina.equalsIgnoreCase(disc.getNome())) {
					int cont = 0;
					encontrou = true;
					System.out.println("\n" + disc.getMensagem());
					List temp = qtdProvasRealizadas(disc);
					disc.setQtdProvasJaRealizadas((Integer) temp.get(0));

					for (Double nota : ((Double[]) temp.get(1))) {
						try {
							disc.adicionaNota(nota);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					for (int i = ((Double[]) temp.get(1)).length; i < ((Integer) temp
							.get(0)); i++) {
						try {
							disc.adicionaFalta();
						} catch (Exception e) {
							System.out.print(e.getMessage());
							System.out.print(" Ganhou " + ++cont
									+ " zero(s) em " + disc.getNome() + ".\n");
						}
					}
					break;
				}
			}
			if (!encontrou) {
				System.out.println(disciplina + " nao encontrada.");
			}
		}
	}

	private static List qtdProvasRealizadas(Convencional disc) {
		List returnList = new ArrayList();
		String tempNotas[];
		System.out.println("Quantas provas ja ouve este semestre?");
		int temp = recebeInteiro(0, disc.getQtdProvas());
		returnList.add(temp);

		System.out.println("Digite as notas que voce ja tirou para "
				+ disc.getNome() + " (Nota1; Nota2; ...):");
		tempNotas = (new Scanner(System.in)).nextLine().replace(" ", "")
				.split(";");
		while (temp < tempNotas.length) {
			System.out.println("Quantidade de nota(s) invalida. Redigite:\n> ");
			tempNotas = (new Scanner(System.in)).nextLine().replace(" ", "")
					.split(";");
		}
		Double notasDisciplinasRealizadas[] = new Double[tempNotas.length];
		for (int i = 0; i < tempNotas.length; i++) {
			try {
				notasDisciplinasRealizadas[i] = Double
						.parseDouble(tempNotas[i]);
			} catch (Exception e) {
				System.err
						.println("Uma ou mais notas invalida(s). Reinicie o programa.");
				System.exit(-1);
			}
		}
		returnList.add(notasDisciplinasRealizadas);
		return returnList;
	}

	private static void disciplinasComMediaMenorQueSete() {
		boolean verifica = true;
		System.out
				.println("As seguintes disciplinas estao com media parcial menor que 7:");
		// for (String disc : disciplinasSendoCursadas) {
		for (Convencional disciplina : listaDisciplinas) {
			if (!disciplinasMenorQueSeteJaImpresas.contains(disciplina
					.getNome())
					&& disciplina.getMediaAtual() < 7.0
					&& disciplina.getMediaAtual() > 0.0) {
				disciplinasMenorQueSeteJaImpresas += disciplina.getNome() + " ";
				verifica = false;
				System.out.printf("- " + disciplina.getNome() + ": %.2f",
						disciplina.getMediaAtual());
			}
		}
		// }
		if (verifica) {
			System.out
					.println("- Nao ha disciplinas com media parcial menor que 7.");
		}
	}

	private static void disciplinasPosRequisitos() {
		String returnStr = "";
		System.out
				.println("As disciplinas a seguir que tem como pre-requisito uma disciplina com media inferior a 7 sao:");
		for (String disc : disciplinasSendoCursadas) {
			for (Convencional disciplina : listaDisciplinas) {
				if (disc.equalsIgnoreCase(disciplina.getNome())
						&& disciplina.getMediaAtual() < 7.0) {
					for (String pos : disciplina.getPosRequisitos()) {
						if (!returnStr.contains(pos)) {
							returnStr += pos + " ";
							System.out.println("- " + pos);
						}
					}
				}
			}
		}
		if (returnStr.equals("")) {
			System.out
					.println("- Nao a disciplinas com pre-requisitos com media inferior a 7.");
		}
	}

	private static void disciplinasMediaMaiorQueSete() {
		boolean verifica = true;
		System.out
				.println("As seguintes disciplinas estao com media igual ou maior que 7 ou nula (representada por 0.0):");
		for (Convencional disciplina : listaDisciplinas) {
			if ((disciplina.getMediaAtual() == 0.0 || disciplina
					.getMediaAtual() >= 7.0)
					&& !disciplinasMaiorQueSeteJaImpresas.contains(disciplina
							.getNome())) {
				disciplinasMaiorQueSeteJaImpresas += disciplina.getNome() + " ";
				verifica = false;
				System.out.printf("- " + disciplina.getNome() + ": %.2f\n",
						disciplina.getMediaAtual());
			}
		}
		if (verifica) {
			System.out
					.println("- Nao ha disciplinas com media igual ou maior que 7.");
		}
	}

	private static int recebeInteiro(int menorValor, int maiorValor) {
		while (true) {
			try {
				String valor;
				int numero;
				do {
					System.out.print("> ");
					valor = (new Scanner(System.in)).nextLine();
					numero = Integer.parseInt(valor);
				} while (numero < menorValor || numero > maiorValor);
				return numero;
			} catch (NumberFormatException num) {
				// naum faca nada
			}
		}
	}

}
