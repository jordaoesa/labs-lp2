package lp2.lab11;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		final int NUMERO_FIGURAS = 5;
		final int COMPENSADOR = 1;
		final int LADO_MAXIMO = 100;
		int opcao;
		Random random = new Random();
		Random rd = new Random();
		RepositorioDeFigurasGeometricas repositorio = new RepositorioDeFigurasGeometricas();

		for (int i = 0; i < NUMERO_FIGURAS; i++) {
			opcao = random.nextInt(2);
			opcao += COMPENSADOR;
			if (opcao == 1){
				try{
					int lado = rd.nextInt(LADO_MAXIMO) + COMPENSADOR;
					//System.out.println(i+": lado "+ lado);
					repositorio.adicionarFiguraGeometrica((new Quadrado(lado)));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}else if (opcao == 2){
				try{
					double raio = random.nextDouble() + COMPENSADOR;
					//System.out.println(i+": raio " + raio);
					repositorio.adicionarFiguraGeometrica((new Circulo(raio)));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		
		System.out.println("Antes de remover:");
		repositorio.desenharTodasAsFigurasGeometricas();
		
		repositorio.removerFiguraGeometrica(1);

		System.out.println("\nDepois de remover:");
		repositorio.desenharTodasAsFigurasGeometricas();
	}

}
