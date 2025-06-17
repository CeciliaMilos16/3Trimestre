package Objetos;

public class Grasas extends Alimento {

	//ATRIBUTOS
		private double grasaSaturada, grasaInsaturada, grasasTrans;

		protected Grasas(double cantidad, double calorias, double carbohidratos, double proteinas, double grasas,
				 String unidadDeMedida,String nombre, double grasaSaturada, double grasaInsaturada, double grasasTrans) {
			super(cantidad, calorias, carbohidratos, proteinas, grasas, unidadDeMedida, nombre);
		
			this.grasaSaturada=grasaSaturada;
			this.grasaInsaturada=grasaInsaturada;
			this.grasasTrans=grasasTrans;
		}

		protected double getGrasaSaturada() {
			return grasaSaturada;
		}

		protected double getGrasaInsaturada() {
			return grasaInsaturada;
		}

		protected double getGrasasTrans() {
			return grasasTrans;
		}

		protected void setGrasaSaturada(double grasaSaturada) {
			this.grasaSaturada = grasaSaturada;
		}

		protected void setGrasaInsaturada(double grasaInsaturada) {
			this.grasaInsaturada = grasaInsaturada;
		}

		protected void setGrasasTrans(double grasasTrans) {
			this.grasasTrans = grasasTrans;
		}
		
	
		
		
}
