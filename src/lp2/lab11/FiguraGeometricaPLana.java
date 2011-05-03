package lp2.lab11;

public interface FiguraGeometricaPLana extends
		Comparable<FiguraGeometricaPLana> {

	public double calcularArea();

	public double calcularPerimetro();

	public void desenhar();

	@Override
	public int compareTo(FiguraGeometricaPLana o);

}
