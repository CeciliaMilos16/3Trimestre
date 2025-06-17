package Planes;

public interface PlanNutricional {
	// METODO PARA GENERAR UNA DIETA SEGUN EL OBJETIVO DEL USUARIO
    String generarDieta();
    
    //  PARA CALCULAR LOS MACRONUTRIENTES TOTALES DEL PLAN
    void calcularMacronutrientes();
    
    //  PARA SUGERIR RECETAS RELACIONADAS CON LA DIETA
    void sugerirRecetas();
    
 
}
