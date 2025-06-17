package Objetos;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Usuario {
	DecimalFormat df = new DecimalFormat("0.00");
	//ATRIBUTOS
	private String nombre, apellido,  correo, contraseña, sexo, categoriaIMC;
	private double peso, altura, pesoObjetivo , fActividad,imc,caloriasRecomendadas;
	private int edad;
	
	//ARRAYLIST PARA GUARDAR LOS ALIMENTOS CONSUMIDOS POR CADA USUARIO 
	private ArrayList <AlimentoConsumido> alimentosConsumidos= new ArrayList<>();
	
    // VARIALES PARA CALCULAR EL TOTAL DE LOS MACRONUTRIENTES QUE HA CONSUMIDO
    private double totalCalorias = 0;
    private double totalCarbohidratos = 0;
    private double totalProteinas = 0;
    private double totalGrasas = 0;
    private double grasaSaturadaTotales =0;
    private double grasaInsaturadaTotales=0 ;
    private double grasasTransTotales=0;
    private double azucarTotales=0 ;
    private double fibraTotales=0;
    private double aminoacidosTotales=0 ;
		
	//CONSTRUCTORES
    
    public Usuario() {
	}
    
	public Usuario( String nombre, String apellido,  String correo,
			String contraseña, String sexo, String categoriaIMC, double peso, double altura, double pesoObjetivo,
			double fActividad, double imc, double caloriasRecomendadas, int edad) {
		
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.sexo = sexo;
		this.categoriaIMC = categoriaIMC;
		this.peso = peso;
		this.altura = altura;
		this.pesoObjetivo = pesoObjetivo;
		this.fActividad = fActividad;
		this.imc = imc;
		this.caloriasRecomendadas = caloriasRecomendadas;
		this.edad = edad;
		this.alimentosConsumidos= new ArrayList<>(); // POR CADA USUARIO CREADO SE CREA UNA ARRAYLIST PARA LOS ALIMENTOS CONSUMIDOS
	}



	// METODO PARA REGISTRAR UN ALIMENTO CONSUMIDO
    protected void registrarAlimentoConsumido(Alimento alimento, double cantidad) {
        alimentosConsumidos.add(new AlimentoConsumido(alimento, cantidad));
        
        // CALCULA EL FACTOR CON LA CCANTIDAD CONSUMIDA Y LA CANTIDAD BASE DEL ALIMENTO
        double factor = cantidad / alimento.getCantidad();  
        totalCalorias += alimento.getCalorias() * factor;
        totalCarbohidratos += alimento.getCarbohidratos() * factor;
        totalProteinas += alimento.getProteinas() * factor;
        totalGrasas += alimento.getGrasas() * factor;
       
        // SI EL ALIMENTO ES DE UN TIPO ESPECIFICO SE HACE LOS CALCULOS DE CADA UNO DE SUS ATRIBUTOS
        
        if(alimento instanceof Grasas) { // AQUI VERIFICAMOS SI ES GRASA Y SUMANOS LOS TOTALES DE SUS ATRIBUTOS
			Grasas grasas= (Grasas)alimento;
			grasaSaturadaTotales += grasas.getGrasaSaturada()* factor;
			grasaInsaturadaTotales += grasas.getGrasaInsaturada()* factor;
			grasasTransTotales += grasas.getGrasasTrans()* factor;
			
		}
		if (alimento instanceof Carbohidrato) { // LO MISMO AQUI EN CASO DE CARBOS
			Carbohidrato carbo = (Carbohidrato)alimento;
			azucarTotales += carbo.getAzucar()* factor;
			fibraTotales += carbo.getFibra()* factor;
			
		}
		if (alimento instanceof Proteina) { // SEPARAMOS SI SON PROTE 
			Proteina prote= (Proteina)alimento;
			aminoacidosTotales += prote.getAninoacidos()* factor;
			
		}
    }

    // AQUI MOSTRAMOS TODOS SUS ALIMENTOS CONSUMIDOS CON LOS CALCULOS TOTALES DE LOS MACRO Y MICRONUTRIENTES
    protected void mostrarAlimentosConsumidos() {
        
    	if (alimentosConsumidos.isEmpty()) { // SI EL ARRAY DE ALIMENTOS CONSUMIDOS ESTA VACIO 
            System.out.println("No has registrado alimentos consumidos aun.");
        } else {
            System.out.println("--- HISTORIAL DE ALIMENTOS CONSUMIDOS ---");
            for (AlimentoConsumido ac : alimentosConsumidos) { // RECORREMOS EL ARRAY  Y CON EL METODO TOSTRING IMPRIMIMOS 
                System.out.println(ac.toString());
            }
            //AQUI MOSTRAMOS LOS CALCULOS QUE HICIMOS  EN EL METODO REGISTRAR ALIMENTO CONSUMIDO
            System.out.println("Total Calorías: " + totalCalorias);
            System.out.println("Total Carbohidratos: " + totalCarbohidratos + "g");
            System.out.println("Total Proteínas: " + totalProteinas + "g");
            System.out.println("Total Grasas: " + totalGrasas + "g");
            System.out.println("Grasas Saturadas totales: " + grasaSaturadaTotales + "g");
    	    System.out.println("Grasas Insaturadas totales: " + grasaInsaturadaTotales + "g");
    	    System.out.println("Grasas Trans totales: " + grasasTransTotales + "g");
    	    System.out.println("Azúcares Totales: " + azucarTotales);
    	    System.out.println("Fibra total: " + fibraTotales);
    	    System.out.println("Aminoacidos totales: " + aminoacidosTotales);
        }
    }




	protected String getNombre() {
		return nombre;
	}

	protected String getApellido() {
		return apellido;
	}

	protected String getCorreo() {
		return correo;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected String getSexo() {
		return sexo;
	}

	protected String getCategoriaIMC() {
		return categoriaIMC;
	}

	protected double getPeso() {
		return peso;
	}

	protected double getAltura() {
		return altura;
	}

	protected double getPesoObjetivo() {
		return pesoObjetivo;
	}

	protected double getfActividad() {
		return fActividad;
	}

	protected double getImc() {
		return imc;
	}

	public double getCaloriasRecomendadas() {
		return caloriasRecomendadas;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}

	protected void setCorreo(String correo) {
		this.correo = correo;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}

	protected void setCategoriaIMC(String categoriaIMC) {
		this.categoriaIMC = categoriaIMC;
	}

	protected void setPeso(double peso) {
		this.peso = peso;
	}

	protected void setAltura(double altura) {
		this.altura = altura;
	}

	protected void setPesoObjetivo(double pesoObjetivo) {
		this.pesoObjetivo = pesoObjetivo;
	}

	protected void setfActividad(double fActividad) {
		this.fActividad = fActividad;
	}

	protected void setImc(double imc) {
		this.imc = imc;
	}

	protected void setCaloriasRecomendadas(double caloriasRecomendadas) {
		this.caloriasRecomendadas = caloriasRecomendadas;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
	    return "Nombre: " + nombre + "\n" +
	           "Apellido: " + apellido + "\n" +
	           "Correo: " + correo + "\n" +
	           "Edad: " + edad + "\n" +
	           "Sexo: " + sexo + "\n" +
	           "Factor de Actividad: " + fActividad + "\n" +
	           "Peso: " + peso + " kg\n" +
	           "Altura: " + altura + " m\n" +
	           "IMC: " + imc + " (" + categoriaIMC + ")\n" +
	           "Peso Objetivo: " + pesoObjetivo + " kg\n" +
	           "Calorías Recomendadas: " + df.format(caloriasRecomendadas) + " kcal\n" +
	           "______________________________________________________________________\n";
	}
}
