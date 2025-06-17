package Objetos;


abstract class ActividadFisica {
   
	//ATRIBUTOS
	private String nombre;
    private int duracion; // EN MINUTOS
    private int caloriasQuemadas;

    //METODO CONSTRUCTOR
    public ActividadFisica(String nombre, int duracion, int caloriasQuemadas) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public abstract String descripcion(); // METODO ABSTRACTO

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Duracion: " + duracion + " minutos");
        System.out.println("Calorias quemadas: " + caloriasQuemadas);
    }
}
