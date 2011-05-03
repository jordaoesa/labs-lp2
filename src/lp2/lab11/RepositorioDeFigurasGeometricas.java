package lp2.lab11;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeFigurasGeometricas {

	private List<FiguraGeometricaPLana> figuras = new ArrayList<FiguraGeometricaPLana>();
	
	public void adicionarFiguraGeometrica(FiguraGeometricaPLana figura){
		figuras.add(figura);
	}
	
	public void removerFiguraGeometrica(int index){
		if(index < 0 || index > figuras.size())
			return;
		figuras.remove(index);
	}
	
	public void desenharTodasAsFigurasGeometricas(){
		for(FiguraGeometricaPLana figura : figuras){
			figura.desenhar();
		}
	}

	public List<FiguraGeometricaPLana> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<FiguraGeometricaPLana> figuras) {
		this.figuras = figuras;
	}
	
}
