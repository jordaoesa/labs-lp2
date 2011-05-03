package lp2.lab11;

public class Circulo implements FiguraGeometricaPLana {
	
	private double area;
	private double raio;
	private double perimetro;
	
	public Circulo(double raio) throws Exception{
		if(raio <= 0)
			throw new Exception("Raio invalido.");
		this.raio = raio;
	}
	

	@Override
	public double calcularArea() {
		area = Math.PI * raio * raio;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		perimetro = 2 * Math.PI * raio;
		return perimetro;
	}

	@Override
	public void desenhar() {
		System.out.println("Desenhando um Criculo");
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


	public double getRaio() {
		return raio;
	}


	public void setRaio(double raio) {
		this.raio = raio;
	}


	public double getPerimetro() {
		return perimetro;
	}


	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	
	

}
