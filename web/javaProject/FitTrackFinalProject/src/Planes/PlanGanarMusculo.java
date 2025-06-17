package Planes;

import Objetos.Usuario;

public class PlanGanarMusculo implements PlanNutricional{

	@Override
    public String generarDieta() {
        // SIMULAMOS UNA DIETA PARA GANAR MÚSCULO
        return """
               Dieta para Ganar Musculo:
               Desayuno: Avena con proteina en polvo, leche de almendra y platano
               Almuerzo: Pechuga de pollo a la parrilla con arroz integral y brocoli
               Cena: Filete de salmon con quinoa y esparragos
               """;
    }
	@Override
    public void calcularMacronutrientes() {
        Usuario u = new Usuario();
        //  CALCULO  DE UNA DIETA PARA GANAR MUSCULO
        double totalCalorias = u.getCaloriasRecomendadas(); // SUPONEMOS UN TOTAL DIARIO
        double grasas = totalCalorias * 0.30 / 9;  // 30% de grasas saludables 
        double proteina = totalCalorias * 0.40 / 4; // 40% de proteina 
        double carbohidratos = totalCalorias * 0.30 / 4; // 30% de carbohidratos 

        System.out.println("Distribucion de Macronutrientes:");
        System.out.println("Calorias totales: " + totalCalorias + " kcal");
        System.out.println("Grasas: " + grasas + " g");
        System.out.println("Proteinas: " + proteina + " g");
        System.out.println("Carbohidratos: " + carbohidratos + " g");
    }

    @Override
    public void sugerirRecetas() {
        // RECETAS PARA UNA DIETA PARA GANAR MÚSCULO
        System.out.println("Recetas sugeridas:");
        System.out.println("1. Pechuga de pollo con batata y esparragos");
        System.out.println("2. Tazon de quinoa con atun, aguacate y verduras al vapor");
        System.out.println("3. Batido de proteínas con avena, platano, leche de almendras y mantequilla de mani");
    }

}
