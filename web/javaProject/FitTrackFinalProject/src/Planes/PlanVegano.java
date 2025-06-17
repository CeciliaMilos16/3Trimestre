package Planes;

import Objetos.Usuario;

public class PlanVegano implements PlanNutricional{

	@Override
    public String generarDieta() {
        // SIMULAMOS UNA DIETA VEGANA ESTÁNDAR
        return """
               Dieta Vegana:
               Desayuno: Avena con leche de almendra, semillas de chia y frutas rojas
               Almuerzo: Ensalada de quinoa con garbanzos, aguacate y espinacas
               Cena: Tofu a la plancha con vegetales al vapor y arroz integral
               """;
    }

    @Override
    public void calcularMacronutrientes() {
        Usuario u = new Usuario();
        //  CALCULO BASADO EN PORCENTAJES  DE UNA DIETA VEGANA
        double totalCalorias = u.getCaloriasRecomendadas(); // calculamos con las calorias recomendadas del usuario
        double grasas = totalCalorias * 0.30 / 9;  // 30% de grasas saludables
        double proteina = totalCalorias * 0.20 / 4; // 20% de proteina TOFU, LEGUMBRES ETC..
        double carbohidratos = totalCalorias * 0.50 / 4; // 50% de carbohidratos 

        System.out.println("Distribución de Macronutrientes:");
        System.out.println("Calorías totales: " + totalCalorias + " kcal");
        System.out.println("Grasas: " + grasas + " g");
        System.out.println("Proteínas: " + proteina + " g");
        System.out.println("Carbohidratos: " + carbohidratos + " g");
    }

    @Override
    public void sugerirRecetas() {
        // RECETAS PARA UNA DIETA VEGANA
        System.out.println("Recetas sugeridas para tu dieta Vegana:");
        System.out.println("1. Ensalada de lentejas con tomate, pepino y aliño de limon, sal y aceite de oliva");
        System.out.println("2. Tofu revuelto con espinacas y champiñones");
        System.out.println("3. Batido de platano con leche de coco, espirulina y almendras");
    }

}