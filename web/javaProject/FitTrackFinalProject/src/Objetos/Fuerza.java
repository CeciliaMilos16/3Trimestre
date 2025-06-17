package Objetos;

class Fuerza extends ActividadFisica {
    
	//ATTRIBUTOS
	private String grupoMuscular; // GRUPO MUSCULAR TRABAJADO ( PIRENAS, GLUTEO, ETC...)

	
	//METODO CONSTRUCTOR
    public Fuerza(String nombre, int duracion, int caloriasQuemadas, String grupoMuscular) {
        super(nombre, duracion, caloriasQuemadas);
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public String descripcion() {
        return "Ejercicio de fuerza enfocado en " + grupoMuscular + ". Ayuda a ganar músculo.";
    }
}
