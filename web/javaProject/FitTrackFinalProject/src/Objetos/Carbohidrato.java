package Objetos;

public class Carbohidrato extends Alimento{
	private double azucar, fibra;

	protected Carbohidrato(double cantidad, double calorias, double carbohidratos, double proteinas, double grasas,
			String unidadDeMedida,String nombre,  double azucar, double fibra) {
		super(cantidad, calorias, carbohidratos, proteinas, grasas, unidadDeMedida, nombre);
		this.azucar=azucar;
		this.fibra=fibra;
	}

	protected double getAzucar() {
		return azucar;
	}

	protected double getFibra() {
		return fibra;
	}

	protected void setAzucar(double azucar) {
		this.azucar = azucar;
	}

	protected void setFibra(double fibra) {
		this.fibra = fibra;
	}
}
