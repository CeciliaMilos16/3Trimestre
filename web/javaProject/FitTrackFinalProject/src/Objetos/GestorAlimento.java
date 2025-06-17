package Objetos;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorAlimento {

	Scanner sc= new Scanner (System.in);
	
	//EXPRESION PARA VERIFICA EL NOMBRE Y APELLIDO( UN SOLO NOMBRE O APELLIDO , SOLO ACEPTA LETRAS Y SIN ESPACIOS)
	private final String CADENA_REGEX="^[a-zA-Z]+$"; 
		
	// ARRAYLIST PARA ALMACENAR LOS ALIMENTOS
    ArrayList<Alimento> alimentos = new ArrayList<>();
    
    ArrayList <Double> cantidadesConsumidas=new ArrayList<>(); // AQUI ALMACENO LAS CANTIDADES POR ALIMENTO

   
    //CONSTRUCTOR
    public GestorAlimento() {
        agregarAlimentos(); 
    }
   

    //METODO PARA AGRE
    public void agregarAlimentos() {
        // PROTEINAS
        alimentos.add(new Proteina(1, 167, 0, 27, 3, "unidad", "Huevo", 12));
        alimentos.add(new Proteina(100, 200, 0, 33, 10, "gr", "Pavo", 15));
        alimentos.add(new Proteina(100, 200, 0, 40, 10, "gr", "Carne de res", 20));
        alimentos.add(new Proteina(1, 150, 0, 20, 5, "unidad", "Atún en agua", 5));
        alimentos.add(new Proteina(100, 160, 0, 24, 6, "gr", "Salmón", 25));
        
        // CARBOHIDRATOS
        alimentos.add(new Carbohidrato(100, 120, 20, 2, 0, "gr", "Arroz blanco", 10, 5));
        alimentos.add(new Carbohidrato(100, 120, 23, 3, 0, "gr", "Pasta", 8, 5));
        alimentos.add(new Carbohidrato(1, 125, 25, 4, 1, "unidad", "Pan integral", 10, 5));
        alimentos.add(new Carbohidrato(100, 100, 20, 4, 0, "gr", "Papas cocidas", 5, 3));
        alimentos.add(new Carbohidrato(100, 125, 29, 5, 1, "gr", "Quinoa", 15, 5));

        // GRASAS
        alimentos.add(new Grasas(100, 900, 0, 0, 100, "ml", "Aceite de oliva", 20, 50, 10));
        alimentos.add(new Grasas(100, 900, 0, 0, 100, "gr", "Mantequilla", 20, 60, 10));
        alimentos.add(new Grasas(100, 350, 0, 0, 100, "gr", "Aguacate", 17, 50, 10));
        alimentos.add(new Grasas(100, 880, 0, 0, 100, "gr", "Aceite de coco", 30, 60, 10));
        alimentos.add(new Grasas(100, 900, 0, 0, 100, "gr", "Almendras", 10, 50, 10));

        // ALIMENTOS CONSUMIDOS MUY A MENUDO 
        alimentos.add(new Proteina(1, 167, 0, 27, 3, "unidad", "Huevo", 12));
        alimentos.add(new Proteina(100, 67, 5, 3, 3, "ml", "Leche de vaca", 10));
        alimentos.add(new Carbohidrato(100, 125, 27, 5, 1, "gr", "Maíz", 8, 3));
        alimentos.add(new Carbohidrato(1, 110, 22, 3, 0, "unidad", "Plátano", 5, 4));
        
        alimentos.add(new Proteina(100, 167, 0, 33, 3, "gr", "Tofu", 15));
        alimentos.add(new Proteina(100, 167, 0, 25, 4, "gr", "Yogur griego", 10));
        
        // CARBOHIDRATOS
        alimentos.add(new Carbohidrato(100, 120, 30, 5, 0, "gr", "Lentejas", 10, 6));
        alimentos.add(new Carbohidrato(100, 120, 27, 5, 0, "gr", "Garbanzos", 14, 8));
        alimentos.add(new Carbohidrato(100, 110, 22, 3, 0, "gr", "Guisantes", 16, 4));

        // BEBIDAS
        alimentos.add(new Carbohidrato(100, 60, 10, 1, 0, "ml", "Jugo de naranja", 7, 5));
        alimentos.add(new Carbohidrato(100, 50, 10, 1, 0, "ml", "Yogurt bebible", 5, 2));
        alimentos.add(new Carbohidrato(100, 60, 12, 2, 0, "ml", "Leche de almendras", 6, 3));
    }
    
    //METODO PARA AGREGAR ALIMENTOS NUEVOS AL ARRAY DE ALIMENTOS
    protected void AgregarAlimentosNuevos() {
       
    	String nombre = pedirNombreAlimento();

        String unidad = pedirUnidadAlimento();

        System.out.println("Ingrese la cantidad del alimento:");
        double cantidad = pedirCantidadMacros();

        System.out.println("Ingrese las calorias del alimento:");
        double calorias = pedirCantidadMacros();

        System.out.println("Ingrese la cantidad de carbohidratos del alimento:");
        double carbohidrato = pedirCantidadMacros();

        System.out.println("Ingrese la cantidad de proteinas del alimento:");
        double proteina = pedirCantidadMacros();

        System.out.println("Ingrese la cantidad de grasas del alimento:");
        double grasas = pedirCantidadMacros();

        int option;
        do {
            System.out.println("Que tipo de alimento vas a agregar?");
            System.out.println("1. Carbohidrato");
            System.out.println("2. Proteina");
            System.out.println("3. Grasas");
            System.out.println("4. Salir");

            option = pedirOpcion();

            switch (option) {
                case 1:
                    System.out.println("Ingrese la cantidad de azucar que contiene:");
                    double azucar = pedirCantidadMacros();
                    System.out.println("Ingrese la cantidad de fibra que contiene:");
                    double fibra = pedirCantidadMacros();

                    alimentos.add(new Carbohidrato(cantidad, calorias, carbohidrato, proteina, grasas, unidad, nombre, azucar, fibra));
                    option = 4; // Salir después de agregar
                    break;

                case 2:
                    System.out.println("Ingrese la cantidad de aminoácidos que contiene:");
                    double aminoacidos = pedirCantidadMacros();

                    alimentos.add(new Proteina(cantidad, calorias, carbohidrato, proteina, grasas, unidad, nombre, aminoacidos));
                    option = 4; // Salir después de agregar
                    break;

                case 3:
                    System.out.println("Ingrese la cantidad de grasas saturadas:");
                    double grasaSaturada = pedirCantidadMacros();
                    System.out.println("Ingrese la cantidad de grasas insaturadas:");
                    double grasaInsaturada = pedirCantidadMacros();
                    System.out.println("Ingrese la cantidad de grasas trans:");
                    double grasasTrans = pedirCantidadMacros();

                    alimentos.add(new Grasas(cantidad, calorias, carbohidrato, proteina, grasas, unidad, nombre, grasaSaturada, grasaInsaturada, grasasTrans));
                    option = 4; // Salir después de agregar
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Ingrese una opción válida (1 - 4)");
            }
        } while (option != 4);
    }
   
    protected int pedirOpcion() {
    	
    	int option;
    	while(true) {
    		String optionStr= sc.nextLine().trim();
    		try {
    			option=Integer.parseInt(optionStr);
    			return option;
    		}catch(NumberFormatException e) {
    			System.out.println("Por favor ingrese un valor valido");
    		}
    	}
    }
    
    protected String pedirUnidadAlimento() {
    	System.out.println("Ingrese la unidad de medida: ");
    	System.out.println("1. Gramos");
    	System.out.println("2. Mililitros");
    	System.out.println("3. Unidad");
    	while(true) {
    		int option= pedirOpcion();
    		switch(option) {
    		case 1: return "gr";
    		case 2: return "ml";
    		case 3: return "unidad";
    		default: System.out.println("Ingrese una opcion valida (1-3)");
    		}
    	}
    }
    
    protected String pedirNombreAlimento() { // PEDIMOS EL NOMBRE Y CORROBORAMOS QUE SEA UNA CADENA CON EL REGEX
    	System.out.print("Ingrese el nombre del alimento: ");
    	final int LONGITUD_MAXIMA =15; // CONSTANTES PARA QUE SEA MAS FACIL MODIFICAR POR SI HAY ALGUN CAMBIO
    	final int LONGITUD_MINIMA=3;
    	
    	String nombreAlimento;
    	while(true) {// bucle para continuar hasta que reciba una opcion valida
    		nombreAlimento=sc.nextLine().trim();
    		if(nombreAlimento.length()>=LONGITUD_MINIMA && nombreAlimento.length()<=LONGITUD_MAXIMA && nombreAlimento.matches(CADENA_REGEX)) { // validamos la longitud de caracteres 
    			return nombreAlimento;
    		}else { // si no cumple la condicion vuelve a pedir que ingrese 
    			System.out.println("El nombre del alimento debe tener al menos entre "+LONGITUD_MINIMA+" y "+LONGITUD_MAXIMA+" letras, no se permite números ");
    			System.out.println("Introduzca nuevamente (Un solo nombre)");
    		}
    	}
    }
    
    protected double pedirCantidadMacros() {
    	// METODO PARA PEDIR CANTIDAD ( NO SOLO DE LOS MACROS)
    	double cantidad;
    	while(true) {
    		String cantidadStr= sc.nextLine().trim();
    		try {
    			cantidad=Integer.parseInt(cantidadStr);
    			if(cantidad >=0) { // 0 PORQUE ALGUNOS ALIMENTOS NO CONTIENEN CALORIAS , CARBOS,ETC...
    				return cantidad;	
    			}else {
    				System.out.println("No puedes introducir una cantidad negativa. Vuelve a introducir");
    			}
    			
    		}catch(NumberFormatException e) {
    			System.out.println("Por favor ingrese un valor numerico");
    		}
    	}
    }
    
    protected void mostrarAlimentos( ) { // AQUI USAMOS UN BUCLE FOR PARA RECORRER EL ARRAY DE ALIMENTOS Y ASI IMPRIME TODOS 
    	int orden=1; 
    	System.out.println("Mostrando alimentos:");
    	System.out.println("ALIMENTO (UNIDAD DE MEDIDA)");
    	for(Alimento a: alimentos) {
    		System.out.println("______________________________________________________");
    		System.out.println(orden+")"+ a.toString());
    		orden++;
    	}
    }

	
}
