package Objetos;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Planes.PlanEjercicio;
import Planes.PlanGanarMusculo;
import Planes.PlanHipertrofia;
import Planes.PlanKeto;
import Planes.PlanNutricional;
import Planes.PlanPerdidaDeGrasa;
import Planes.PlanResistencia;
import Planes.PlanVegano;



public class Gestor {
	DecimalFormat df= new DecimalFormat ("#.0");
	Scanner sc= new Scanner(System.in);
	ArrayList <Usuario>usuarios= new ArrayList<>();
	ArrayList <Alimento>alimentos= new ArrayList<>();
	
	GestorActividad gs= new GestorActividad();
	GestorAlimento ga= new GestorAlimento();
	Usuario usuarioActivo = null;  // Atributo para almacenar el usuario activo
	
	private final double IMC_MAX=24.9;
	private final double IMC_MIN=18.5;

	// CREAMOS UNA EXPRESION REGULAR PARA EL CORREO
	private final String CORREO_REGEX="^[\\w.-]{1,20}@[a-zA-Z0-9.-]+\\.[a-zA-z]{2,}$"; // 1.20 INDICA EL NUMERO DE LETRAS ANTES DEL @ Y( A-Z 0-9 .- ) LOS VALORES QUE ACEPTA
	
	//expresion para verificar el  nombre y apellido
	private final String CADENA_REGEX="^[a-zA-Z]+$"; // SOLO LETRAS SIN ESPACIO NI NUMERO
	
	
	protected boolean iniciarSesion() {
	    String correo = pedirCorreo( true);
	    if (repiteCorreo(correo)) {
	        String contraseña = pedirContraseña();
	        if (repiteContraseña(contraseña)) {
	            System.out.println("Inicio de sesión exitoso");
	            // Encontrar al usuario con el correo proporcionado
	            for (Usuario u : usuarios) {
	                if (u.getCorreo().equals(correo)) {
	                    usuarioActivo = u;  // Asignar al usuario activo
	                    break;
	                }
	            }
	            return true;
	        } else {
	            System.out.println("Contraseña incorrecta");
	            return false;
	        }
	    } else {
	        System.out.println("Correo no registrado");
	        return false;
	    }
	}
	
	protected void registrarse() {
	    String correo = pedirCorreo(false);
	    System.out.println("______________________________________________________________________");
	    String contraseña = pedirContraseña();
	    System.out.println("______________________________________________________________________");
	    String nombre = pedirNombre();
	    System.out.println("______________________________________________________________________");
	    String apellido = pedirApellido();
	    System.out.println("______________________________________________________________________");
	    int edad = pedirEdad();
	    System.out.println("______________________________________________________________________");
	    double peso = pedirPeso();
	    System.out.println("______________________________________________________________________");
	    double altura = pedirAltura();
	    System.out.println("______________________________________________________________________");
	    String sexo = pedirSexo();
	    System.out.println("______________________________________________________________________");
	    double fActividad = pedirFactor();
	    System.out.println("______________________________________________________________________");

	    double imc = calcularIMC(peso, altura);
	    String categoriaIMC = calcularCategoriaImc(imc);
	    double pesoObjetivo = pedirPesoObjetivo(altura);
	    System.out.println("______________________________________________________________________");
	    double caloriasRecomendadas = calcularCalorias(sexo, altura, pesoObjetivo, edad, fActividad);

	    Usuario nuevoUsuario = new Usuario(
	        nombre, apellido, correo, contraseña, sexo, categoriaIMC,
	        peso, altura, pesoObjetivo, fActividad, imc, caloriasRecomendadas, edad
	    );

	    usuarios.add(nuevoUsuario);
	    System.out.println("______________________________________________________________________");
	}

	protected void mostrarInicio() {
		System.out.println("BIENVENIDO A FIT TRACK IT");
		System.out.println("Escoje una opción");
		System.out.println("1. Iniciar Sesión");
		System.out.println("2. Registrarse");
		System.out.println("3. Salir");
	}
	
	protected void mostrarPanelPrincipal() {
		System.out.println("            ");
	    System.out.println("FIT TRACK IT-----PANEL PRINCIPAL");
	    System.out.println("Escoje una opción:"); 
	    System.out.println("1. Registrar alimentos consumidos");
	    System.out.println("2. Ver historial de consumo, macronutrientes y progreso");
	    System.out.println("3. Agregar alimento nuevo");
	    System.out.println("4. Ver mis datos");
	    System.out.println("5. Ajustar mis datos");
	    System.out.println("6. Mostrar actividades fisicas que puedes realizar");
	    System.out.println("7. Ver planes");
	    System.out.println("8. Cerrar Sesión");

	}
	
	protected void casosPanelPrincipal( ) {
		int option=0;
		
		while(option!=8){ // REPITE EL BUBLE HASTA QUE INGRESE UN 8 POR TECLADO
			mostrarPanelPrincipal();
			option=pedirOpcion();
			switch(option){
			case 1:
				System.out.println("REGISTRAR ALIMENTOS CONSUMIDOS");
		         if(usuarioActivo != null) {
	                    ga.mostrarAlimentos(); // Muestra el listado de alimentos disponibles
	                    
	                    System.out.println("Seleccione el número del alimento:");
	                    int indexAlim = pedirOpcion(); // suponiendo que este método lee la opción del usuario
	                    if (indexAlim < 1 || indexAlim > ga.alimentos.size()) {
	                        System.out.println("Opción inválida.");
	                        break;
	                    }
	                    
	                    // Obtén el alimento seleccionado
	                    Alimento alimentoSeleccionado = ga.alimentos.get(indexAlim - 1);
	                    System.out.println("Ingrese la cantidad consumida en " + alimentoSeleccionado.getUnidadDeMedida() + ":");
	                    double cantidadIngresada = ga.pedirCantidadMacros(); // lee la cantidad ingresada
	                    
	                    usuarioActivo.registrarAlimentoConsumido(alimentoSeleccionado, cantidadIngresada);
	                } else {
	                    System.out.println("No has iniciado sesión.");
	                }
				break;
				
			case 2:
				if(usuarioActivo!=null) {
					System.out.println("HISTORIAL DE CONSUMO, MACRONUTRIENTES Y PROGRESO");
					System.out.println("ALIMENTOS CONSUMIDOS");
					usuarioActivo.mostrarAlimentosConsumidos(); // AQUI CON EL ARRAY DE ALIMENTOSCONSUMIDOS MOSTRAMOS LA SUMA DE TODOS LOS MACRO Y MICRONUTRIENTES 
					// Y LOS ALIMENTOS CONSUMIDOS
				}else {
					System.out.println("No has iniciado sesion");
				}
				break;
				
			case 3:
				System.out.println("AGREGA UN NUEVO ALIMENTO");
				if(usuarioActivo!=null) {
					ga.AgregarAlimentosNuevos(); // AQUI EL USUARIO PUEDE INGRESAR UN NUEVO ALIMENTO POR SI ES QUE NO HAY EN LA LISTA EL QUE DESEA
				}else {
					System.out.println("No has iniciado sesion");
				}
				break;
				
			case 4:
				System.out.println("MIS DATOS");
				if(usuarioActivo !=null) {
					System.out.println(usuarioActivo.toString()); // IMPRIMIMOS TODOS LOS DATOS DEL USUARIO
				}else {
					System.out.println("No has iniciado sesion");
				}
				break;
			
			case 5:
				System.out.println("CONFIGURACION: MIS DATOS");
				ajustarDatos(); // AQUI PODEMOS CONFIGURAR NUESTROS DATOS
				break;
			
			case 6:
				gs.mostrarActividades();
				break;
			case 7:
				System.out.println("VER TODOS LOS PLANES ");
				if(usuarioActivo!=null) {
					elegirPlan();
				}else {
					System.out.println("No has iniciado sesion");
				}
				
			case 8:
				System.out.println("Cerrando sesion........");
				//usuarioActivo = null;
				
				break;
			
			default: System.out.println("Opcion invalida, asegurese de introducir del 1 al 6");
			break;
			
			}
		}
	}
	
	protected void elegirPlan() {
		boolean correcto=false;
		int option1 =0;
		System.out.println("¿Que tipo de plan deseas ver?");
		System.out.println("1. Plan Nutricional");
		System.out.println("2. Plan de ejercicios");
		do {
			option1=pedirOpcion();
			switch (option1) {
			case 1:
			
				System.out.println("Elige que tipo de plan nutricional quieres: ");
				System.out.println("1. Plan Keto");
				System.out.println("2. Plan Vegano");
				System.out.println("3. Plan ganar masa muscular");
				elegirPlanNutricional();
				correcto=true;
				break;
				
			case 2:
				
				System.out.println("Elige que tipo de plan de ejercicios quieres: ");
				System.out.println("1. Plan Hipertrofia");
				System.out.println("2. Plan Resistencia");
				System.out.println("3. Plan perdida de grasa");
				elegirPlanEjercicios();
				correcto=true;
				break;
		
				
			default: System.out.println("Ingrese una opcion valida");
				break;
			}
		}while(!correcto);
	}
	
	protected void elegirPlanNutricional() {
		int option2=0;
		PlanNutricional plan = null;
		boolean correcto=false;
		do {
			option2=pedirOpcion();
			switch(option2) {
			case 1:
				System.out.println("PLAN KETO");
				plan = new PlanKeto();
				correcto=true;
				break;
				
			case 2:
				System.out.println("PLAN VEGANO");
				plan = new PlanVegano();
				correcto=true;
				break;
				
			case 3:
				System.out.println("PLAN PARA GANAR MASA MUSCULAR");
				plan = new PlanGanarMusculo();
				correcto=true;
				break;
		
				
			default: System.out.println("Ingrese una opcion valida");
				break;
			}
			
			
		}while(!correcto);
		
		if(plan !=null) {
			plan.generarDieta();
			plan.calcularMacronutrientes();
			plan.sugerirRecetas();
		}
		
	}
	
	protected void elegirPlanEjercicios() {
		boolean correcto= true;
		int option3=0;
		PlanEjercicio plan = null;
		do {
			option3=pedirOpcion();
			switch(option3) {
			case 1:
				System.out.println("PLAN HIPERTROFIA");
				plan = new PlanHipertrofia();
				correcto=true;
				break;
				
			case 2:
				System.out.println("PLAN RESISTENCIA");
				plan = new PlanResistencia();
				correcto=true;
				break;
				
			case 3:
				System.out.println("PLAN PARA PERDER GRASA");
				plan = new PlanPerdidaDeGrasa();
				correcto=true;
				break;
		
				
			default: System.out.println("Ingrese una opcion valida");
				break;
			}
			
			
		}while(!correcto);
		
		if(plan !=null) {
			plan.sugerirEjerciciosAlternativos();
			plan.calcularDuracionTotal();
			plan.generarRutina();
			plan.ajustarRutina(3, 5);
		}
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
		
	protected String pedirNombre() {
		final int LONGITUD_MAXIMA =15;
		final int LONGITUD_MINIMA=3;
		
		String nombre;
		System.out.println("Introduzca su nombre (Un solo nombre)");
		while(true) {// bucle para continuar hasta que reciba una opcion valida
			nombre=sc.nextLine().trim();
			if(nombre.length()>=LONGITUD_MINIMA && nombre.length()<=LONGITUD_MAXIMA && nombre.matches(CADENA_REGEX)) { // validamos la longitud de caracteres 
				return nombre;
			}else { // si no cumple la condicion vuelve a pedir que ingrese 
				System.out.println("Su nombre debe tener al menos entre "+LONGITUD_MINIMA+" y "+LONGITUD_MAXIMA+" letras, no se permite números ");
				System.out.println("Introduzca nuevamente (Un solo nombre)");
			}
		}	
	}

	protected String pedirApellido() {
		final int LONGITUD_MAXIMA =25;
		final int LONGITUD_MINIMA=3;
		
		String apellido="";
		System.out.println("Introduzca su apellido (Un solo apellido)");
		while(true) {// bucle para continuar hasta que reciba una opcion valida
			apellido=sc.nextLine().trim();
			if(apellido.length()>= LONGITUD_MINIMA && apellido.length()<=LONGITUD_MAXIMA  &&apellido.matches(CADENA_REGEX)) { // validamos la longitud de caracteres 
				return apellido;
			}else {// si no cumple la condicion vuelve a pedir que ingrese 
				System.out.println("Su apellido debe tener al menos entre "+ LONGITUD_MINIMA+" y "+ LONGITUD_MAXIMA+" letras");
				System.out.println("Introduzca nuevamente (Un solo apellido)");
			}
		}
	}

	protected int pedirEdad() {
		//los declaramos en constantes para que asi si cambia el rango de edad, solo cambiemos aqui
		final int EDAD_MINIMA=10;
		final int EDAD_MAXIMA=70;
		
		int edad =0;
		String edadStr;
		System.out.println("Introduzca su edad");
		while(true) { // bucle para continuar hasta que reciba una opcion valida
			edadStr=sc.nextLine().trim();
			try {
				edad=Integer.parseInt(edadStr);
				
				if(edad>=EDAD_MINIMA && edad <=EDAD_MAXIMA) { // condicional para verificar que este en un rango de edad valido para usar el programa
					return edad;
				}else {
					System.out.println("Edad fuera del rango. El rango de edad permitido es de "+EDAD_MINIMA+" hasta "+EDAD_MAXIMA+ " años.");
					System.out.println("Ingrese nuevamente");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Ingrese un numero entero");
				System.out.println("Ingrese nuevamente");
			}
		}
	}
		
	protected double pedirPeso() {
		//los declaramos en constantes para que asi si cambia el rango de edad, solo cambiemos aqui
		final double PESO_MINIMO=30;
		final double PESO_MAXIMO=250;
		
		double peso =0;
		String pesoStr;
		
		while(true) { // bucle para continuar hasta que reciba una opcion valida
			System.out.println("Introduzca su peso en kg (ejemplo: 70.5)");
			pesoStr=sc.nextLine().trim().replace(",", ".");
			try {
				peso=Double.parseDouble(pesoStr);
				
				if(peso>=PESO_MINIMO && peso <=PESO_MAXIMO) {
					return peso; // si esta en el rango me devuelve el peso
				}else {
					System.out.println("Peso fuera del rango. El rango de peso considerado es de "+PESO_MINIMO+" hasta "+PESO_MAXIMO);
					System.out.println("Ingrese nuevamente");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Ingrese un dato numérico");
				System.out.println("Ingrese nuevamente");
			}
		}
	}

	protected double pedirAltura() {
		//los declaramos en constantes para que asi si cambia el rango de edad, solo cambiemos aqui
		final double ALTURA_MINIMA=1.2;
		final double ALTURA_MAXIMA=2.5;
		
		double altura =0;
		String alturaStr;
		System.out.println("Introduzca su altura en metros (ejemplo: 1.70)");
		while(true) { // bucle para continuar hasta que reciba una opcion valida
			alturaStr=sc.nextLine().trim().replace(",", ".");
			try {
				altura=Double.parseDouble(alturaStr);
				
				if(altura>=ALTURA_MINIMA && altura <=ALTURA_MAXIMA) {
					return altura;
				}else {
					System.out.println("Altura fuera del rango. El rango de altura considerado es de "+ALTURA_MINIMA+" hasta "+ALTURA_MAXIMA);
					System.out.println("Ingrese nuevamente");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Ingrese un dato numérico");
				System.out.println("Ingrese nuevamente");
			}
		}
	}

	protected String pedirSexo() {

		System.out.println("Escoja su sexo");
		System.out.println("1. Masculino");
		System.out.println("2. Femenino");
		
		while(true) {
			int option= pedirOpcion();
			switch(option){
			case 1: return "Masculino"; 
			case 2: return "Femenino";
			default: System.out.println("Opción invalida, ingrese 1 o 2");
			}
		}
	}
		
	protected double pedirFactor() {
		System.out.println("Escoje tu factor de actividad:"); // MOSTRAMOS LOS TIPOS DE FACTOR DE ACTIVIDAD Y DESCRIBIMOS UN POCO PARA QUE EL USUARIO SE PUEDA GUIAR Y SELECCIONE LA OPCION CORRECTA 
		System.out.println("1. Sedentario (No realizas practicamente nada de ejercicio)");
		System.out.println("2. Actividad ligera (Realizas ejercicio suave de 1 a 3 veces por semana");
		System.out.println("3. Actividad moderada (Realizas ejericio de 3 a 5 veces por semana)");
		System.out.println("4. Actividad intensa (Realizas ejercicio de 6 o 7 dias por semana)");
		System.out.println("5. Actividad muy intensa (Realizas ejercicios muy intensos al menos dos horas diarias");
		System.out.println("   o tienes una actividad laboral muy intensa");
		
		while(true) {
			int option= pedirOpcion();
			switch(option){
			case 1: return 1.2; 
			case 2: return 1.375;
			case 3: return 1.55;
			case 4: return 1.725;
			case 5: return 1.9;
			default: System.out.println("Opción invalida, ingrese 1 hasta el 5");
			}
		}
	}	
		
	protected String pedirCorreo( boolean repetido) {
	    String correo;
	    Pattern pattern = Pattern.compile(CORREO_REGEX); // COMPILA LA EXPRESION REGULAR

	    System.out.println("Ingrese su correo:");
	    while (true) {
	        correo = sc.nextLine().trim(); 

	        // VALIDAR CON LA EXPRESION REGULAR
	        if (!pattern.matcher(correo).matches()) {
	            System.out.println("Correo no valido. Asegurese de incluir '@' y que tenga un maximo de 20 caracteres antes del '@'");
	            continue;
	        }

	        // EXTRAEMOS EL DOMINIO CON SUBSTRING , DESPUES DEL @ 
	        String dominio = correo.substring(correo.indexOf("@") + 1);

	        // VALIDAMOS LOS DOMINIOS, SOLO SE ACEPTAN ESOS DOMINIOS POR AHORA 
	        if (!(dominio.equals("gmail.com") || dominio.equals("outlook.com") ||
	              dominio.equals("hotmail.com") || dominio.equals("yahoo.com"))) {
	            System.out.println("Dominio no permitido. Solo se aceptan: @gmail.com, @outlook.com, @hotmail.com, @yahoo.com");
	            continue;
	        }

	        //EL BOOLEAN REPETIDO COMO ES TRUE SE VUELVE FALSE (ENTONCES VALIDA 
	        if (!repetido && repiteCorreo(correo)) {
	            System.out.println("Este correo ya está registrado. Por favor, ingrese otro.");
	        } else {
	            return correo;
	        }
	    }
	}

	protected String pedirContraseña() {
		
		final int LONGITUD_MAXIMA =20;
		final int LONGITUD_MINIMA=8;
		
		String contraseña="";
		System.out.println("Ingrese su contraseña (debe tener minimo 8 caracteres");
		while(true) {
			contraseña= sc.nextLine().trim();
			if(contraseña.length()>=LONGITUD_MINIMA && contraseña.length()<=LONGITUD_MAXIMA) {
				return contraseña;
			}else {
				System.out.println("Tu contraseña debe tener entre"+LONGITUD_MINIMA+" y "+LONGITUD_MAXIMA+" caracteres");
			}
		}
	}

	protected boolean repiteCorreo( String correo) {
		
		for(Usuario u:usuarios) {
			if(u.getCorreo().equals(correo)) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean repiteContraseña( String contraseña) {
		
		for(Usuario u:usuarios) {
			if(u.getContraseña().equals(contraseña)) {
				return true;
			}
		}
		return false;
	}
	
	protected void mostrarRango(Double altura) {
		
		double pesoMax= (altura * altura) * IMC_MAX;
		double pesoMin= (altura * altura) * IMC_MIN;
		System.out.println("Tu peso normal esta en este rango: ");
		System.out.println( df.format(pesoMin)+"---"+df.format(pesoMax));
	}
	
	protected double calcularIMC(double peso, double altura) {
	    double imc = peso / (altura * altura);  // Fórmula estándar del IMC
	    imc = Math.round(imc * 10.0) / 10.0;  // Redondear el IMC a un decimal

	    return imc; // Retornar el IMC calculado
	}
	
	protected String calcularCategoriaImc(double imc) {
		 	
		if (imc < 18.5) { // 
		        return"Bajo peso";
		    } else if (imc >= 18.5 && imc < 24.9) {
		        return"Peso normal";
		    } else if (imc >= 25.0 && imc < 29.9) {
		        return"Sobrepeso";
		    } else if (imc >= 30.0 && imc < 34.9) {
		        return"Obesidad grado 1";
		    } else if (imc >= 35.0 && imc < 39.9) {
		        return"Obesidad grado 2";
		    } else {
		        return"Obesidad grado 3";
		    }
	}
	
    protected double pedirPesoObjetivo( double altura) {
        double pesoMax = (altura * altura) * IMC_MAX;
        double pesoMin = (altura * altura) * IMC_MIN;

        mostrarRango( altura);  // Mostrar el rango
        double pesoObjetivo;

        System.out.println("Escoge cual es tu peso objetivo (dentro de este rango):");
        while (true) {
            String pesoObStr = sc.nextLine().trim().replace(",", ".");
            try {
                pesoObjetivo = Double.parseDouble(pesoObStr);
                if (pesoObjetivo <= pesoMax && pesoObjetivo >= pesoMin) {
                    return pesoObjetivo;
                } else {
                    System.out.println("Ingrese un peso que esté en su rango de peso normal");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numérico");
            }
            System.out.println("Ingrese nuevamente");
        }
    }
	
	protected double calcularCalorias( String sexo,double altura,double pesoObjetivo,int edad,double fActividad) {
		double caloriasDiarias=0;
		
		if(sexo.equals("Femenino")) {
			caloriasDiarias= caloriasMujer(altura, pesoObjetivo, edad, fActividad);
			
		}else if(sexo.equals("Masculino")){
			caloriasDiarias=caloriasHombre(altura, pesoObjetivo, edad, fActividad);
			
		}
		return caloriasDiarias;
	}
	
	protected double caloriasMujer( double altura,double pesoObjetivo,int edad,double fActividad) {
		
		int alturacm=(int) (altura*100); // convertimos la altura a centimetros para esta formula 
		
		Double TMBMujer= 447.593+(9.247*pesoObjetivo)+(3.098*alturacm)-(4.330*edad); // formula para calcular la taza metabolica basal de la mujer 
		
		Double caloriasDiarias= TMBMujer* fActividad; // multiplicamos la taza metabolica basal x factor de actividad  y el resultado son las calorias diarias 
		System.out.println("Tus calorias diarias a consumir son de: "+df.format(caloriasDiarias)); // mostramos  las calorias diarias recomendadas
		return caloriasDiarias;
	}
	
	protected double caloriasHombre(double altura,double pesoObjetivo,int edad,double fActividad) {
		
		int alturacm=(int) (altura*100); // convertimos la altura a centimetros para esta formula 
		
		Double TMBHombre= 88.362+(13.397*pesoObjetivo)+(4.799*alturacm)-(5.677*edad); // formula para calcular la taza metabolica basal del hombre
		Double caloriasDiarias= TMBHombre* fActividad; // multiplicamos la taza metabolica basal x factor de actividad  y el resultado son las calorias diarias 
		System.out.println("Tus calorias diarias a consumir son de: "+df.format(caloriasDiarias)); // mostramos  las calorias diarias recomendadas
		return caloriasDiarias;
	}
	
	
	protected void ajustarDatos() {
	    int opcion;
	    
	    if(usuarioActivo!=null) {
	    	do {
		        System.out.println("Seleccione qué dato desea modificar:");
		        System.out.println("1. Nombre");
		        System.out.println("2. Apellido");
		        System.out.println("3. Edad");
		        System.out.println("4. Peso");
		        System.out.println("5. Altura");
		        System.out.println("6. Sexo");
		        System.out.println("7. Factor de actividad");
		        System.out.println("8. Correo");
		        System.out.println("9. Contraseña");
		        System.out.println("0. Volver al menu principal");

		        opcion = pedirOpcion();

		        switch (opcion) {
		            case 1:
		            	usuarioActivo.setNombre(pedirNombre());
	                    System.out.println("Nombre actualizado con exito");
		                break;
		            case 2:
		                usuarioActivo.setApellido(pedirApellido());
		                System.out.println("Apellido actualizado con exito");
		                break;
		            case 3:
		                usuarioActivo.setEdad(pedirEdad());
		                System.out.println("Edad actualizada con exito");
		                break;
		            case 4:
		                usuarioActivo.setPeso(pedirPeso());
		                System.out.println("Peso actualizado con exito");
		                break;
		            case 5:
		                usuarioActivo.setAltura(pedirAltura());
		                System.out.println("Altura actualizada con exito");
		                break;
		            case 6:
		                usuarioActivo.setSexo(pedirSexo());
		                System.out.println("Sexo actualizado con exito");
		                break;
		            case 7:
		                usuarioActivo.setfActividad(pedirFactor());
		                System.out.println("Factor de actividad actualizado con exito");
		                break;
		            case 8:
		                usuarioActivo.setCorreo(pedirCorreo(true)); // 
		                System.out.println("Correo actualizado con éxito.");
		                break;
		            case 9:
		                usuarioActivo.setContraseña(pedirContraseña());
		                System.out.println("Contraseña actualizada con éxito.");
		                break;
		            case 0:
		                System.out.println("Volviendo al menú principal...");
		                break;
		            default:
		                System.out.println("Opcion invalida, por favor vuelve a ingresar");
		        }
		    } while (opcion != 0);
	    }
	}




}

