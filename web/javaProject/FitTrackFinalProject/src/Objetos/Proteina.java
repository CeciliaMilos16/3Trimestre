package Objetos;

public class Proteina extends Alimento{

	//ATRIBUTOS
	private double aninoacidos;

	protected Proteina(double cantidad, double calorias, double carbohidratos, double proteinas, double grasas,
			String unidadDeMedida, String nombre, double aminoacidos) {
		super(cantidad, calorias, carbohidratos, proteinas, grasas, unidadDeMedida, nombre);
		this.aninoacidos=aminoacidos;
	}

	protected double getAninoacidos() {
		return aninoacidos;
	}

	protected void setAninoacidos(double aninoacidos) {
		this.aninoacidos = aninoacidos;
	}
	
	
	
	
}

