package Objetos;

class Cardio extends ActividadFisica {
	   
	//ATRIBUTOS
	private int intensidad; // NIVEL DE INSTENSIDAD DEL 1 AL 10

	
	//METODO CONSTRUCTOR
    public Cardio(String nombre, int duracion, int caloriasQuemadas, int intensidad) {
        super(nombre, duracion, caloriasQuemadas);
        this.intensidad = intensidad;
    }

    @Override
    public String descripcion() {
        return "Ejercicio de cardio de intensidad " + intensidad + ". Bueno para la resistencia";
    }
}
