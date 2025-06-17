package Planes;

import Objetos.Usuario;

public class PlanKeto implements PlanNutricional{


	@Override
	public String generarDieta() {
	    // SIMULAMOS UNA DIETA KETO ESTANDAR
	    return """
	    	       Dieta Keto:
	    	       Desayuno: Huevos revueltos con aguacate
	    	       Almuerzo: Pollo a la plancha con ensalada de espinaca y nueces
	    	       Cena: Salmon con espárragos y queso parmesano
	    	       """;
	}

	@Override
	public void calcularMacronutrientes() {
		Usuario u =new Usuario();
	    // SIMULAMOS UN CÁLCULO BASADO EN PORCENTAJES ESTANDAR DE UNA DIETA KETO
	    double totalCalorias = u.getCaloriasRecomendadas(); // calculamos con las calorias recomendadas del usuario
	    double grasas = totalCalorias * 0.70 / 9;  // 70% de grasas
	    double proteina = totalCalorias * 0.25 / 4; // 25% de proteína
	    double carbohidratos = totalCalorias * 0.05 / 4; // 5% de carbohidratos

	    System.out.println("Distribucion de Macronutrientes:");
	    System.out.println("Calorias totales: " + totalCalorias + " kcal");
	    System.out.println("Grasas: " + grasas + " g");
	    System.out.println("Proteinas: " + proteina + " g");
	    System.out.println("Carbohidratos: " + carbohidratos + " g");
	}

	@Override
	public void sugerirRecetas() {
	    // RECETAS PARA UNA DIETA KETO
	    System.out.println("Recetas sugeridas para tu dieta Keto:");
	    System.out.println("1. Omelette de espinaca con queso y aguacate");
	    System.out.println("2. Pechuga de pollo en salsa de crema y champiñones");
	    System.out.println("3. Ensalada de atún con mayonesa y almendras");
	}

}
