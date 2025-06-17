package Objetos;

class Deporte extends ActividadFisica {
	   
	//ATRIBUTO
	private String tipoDeporte; // INDIVIDUAL O EN EQUIPO

	
	//METODO CONSTRUCTOR
    public Deporte(String nombre, int duracion, int caloriasQuemadas, String tipoDeporte) {
        super(nombre, duracion, caloriasQuemadas);
        this.tipoDeporte = tipoDeporte;
    }

    @Override
    public String descripcion() {
        return "Deporte de tipo " + tipoDeporte + ". Bueno para la coordinación y el trabajo en equipo.";
    }
}
