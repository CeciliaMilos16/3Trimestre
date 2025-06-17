package Objetos;

public  class Alimento {
	// atributos:
		private double cantidad, calorias, carbohidratos,proteinas,grasas;
		String nombre;
		private String unidadDeMedida;
		
		protected Alimento(double cantidad, double calorias, double carbohidratos, double proteinas, double grasas,
					String unidadDeMedida ,String nombre) {
			super();
			this.cantidad = cantidad;
			this.calorias = calorias;
			this.carbohidratos = carbohidratos;
			this.proteinas = proteinas;
			this.grasas = grasas;
			this.nombre = nombre;
			this.unidadDeMedida = unidadDeMedida;
		}

		protected double getCantidad() {
			return cantidad;
		}

		protected double getCalorias() {
			return calorias;
		}

		protected double getCarbohidratos() {
			return carbohidratos;
		}

		protected double getProteinas() {
			return proteinas;
		}

		protected double getGrasas() {
			return grasas;
		}

		protected String getNombre() {
			return nombre;
		}

		protected String getUnidadDeMedida() {
			return unidadDeMedida;
		}

		protected void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}

		protected void setCalorias(double calorias) {
			this.calorias = calorias;
		}

		protected void setCarbohidratos(double carbohidratos) {
			this.carbohidratos = carbohidratos;
		}

		protected void setProteinas(double proteinas) {
			this.proteinas = proteinas;
		}

		protected void setGrasas(double grasas) {
			this.grasas = grasas;
		}

		protected void setNombre(String nombre) {
			this.nombre = nombre;
		}

		protected void setUnidadDeMedida(String unidadDeMedida) {
			this.unidadDeMedida = unidadDeMedida;
		}

		@Override
		public String toString() {
			return " Nombre = " + nombre + "------- unidadDeMedida = " + unidadDeMedida ;
		}
		
}
