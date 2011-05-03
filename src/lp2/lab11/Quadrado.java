package lp2.lab11;

public class Quadrado implements FiguraGeometricaPLana {

	private double area;
	private int lado;
	private double perimetro;
	
	public Quadrado(int lado) throws Exception{
		if(lado <= 0)
			throw new Exception("Lado invalido.");
		this.lado = lado;
	}
	
	@Override
	public double calcularArea() {
		area = lado * lado;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		perimetro = lado * 4;
		return perimetro;
	}

	@Override
	public void desenhar() {
		System.out.println("Desenhando Quadrado");
	}

	@Override
	public int compareTo(FiguraGeometricaPLana o) {
		return (int) (this.calcularArea() - o.calcularArea());
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	
	

}
