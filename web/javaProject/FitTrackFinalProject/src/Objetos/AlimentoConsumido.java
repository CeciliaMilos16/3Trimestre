package Objetos;

public class AlimentoConsumido {
	
	private Alimento alimento;
	private double cantidad;
	
	
	protected AlimentoConsumido(Alimento alimento, double cantidad) {
		super();
		this.alimento = alimento;
		this.cantidad = cantidad;
	}
	
	


	protected Alimento getAlimento() {
		return alimento;
	}




	protected double getCantidad() {
		return cantidad;
	}




	@Override
	public String toString() {
		return "Alimento= " + alimento.getNombre()  + " \n" +
	    " cantidad= " + cantidad   +"\n" +
        "_______________________________________________\n";
	}
}
