package lp2.lab11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestaRepositorioDeFigurasGeometricas {

	RepositorioDeFigurasGeometricas repositorio;
	
	@Before
	public void iniciaReposiorio(){
		repositorio = new RepositorioDeFigurasGeometricas();
	}
	
	@Test
	public void testaAdicionaFigura(){
		FiguraGeometricaPLana figura1 = null;
		FiguraGeometricaPLana figura2 = null;
		try {
			figura1 = new Quadrado(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			figura2 = new Circulo(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		repositorio.adicionarFiguraGeometrica(figura1);
		repositorio.adicionarFiguraGeometrica(figura2);
		
		Assert.assertEquals("Erro em adicionaFigura()", 2, repositorio.getFiguras().size());
	}
	
	@Test
	public void testaRemoverFigura(){
		FiguraGeometricaPLana figura1 = null;
		FiguraGeometricaPLana figura2 = null;
		try {
			figura1 = new Quadrado(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			figura2 = new Circulo(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		repositorio.adicionarFiguraGeometrica(figura1);
		repositorio.adicionarFiguraGeometrica(figura2);
		
		repositorio.removerFiguraGeometrica(1);
		Assert.assertEquals("Erro em adicionaFigura()", 1, repositorio.getFiguras().size());
	}
	
}
