package Planes;

public class PlanHipertrofia implements PlanEjercicio{

    @Override
    public String generarRutina() {
        // RUTINA DE EJERCICIOS PARA HIPERTROFIA
        return """
               Rutina de Hipertrofia:
               Día 1: Pecho y tríceps
               Día 2: Espalda y bíceps
               Día 3: Piernas
               Día 4: Hombros y abdomen
               Día 5: Día de descanso o cardio ligero
               """;
    }

    @Override
    public int calcularDuracionTotal() {
        
        int diasPorSemana = 5; // SUPONEMOS QUE EL USUARIO REALIZA LA RUTINA 5 DIAS A LA SEMANA
        int duracionPorSesion = 75; // CADA SESION DURA 75 MINUTOS EN PROMEDIO
        return diasPorSemana * duracionPorSesion; // TOTAL DE MINUTOS POR SEMANA
    }

    @Override
    public void sugerirEjerciciosAlternativos() {
        // SUGERIMOS EJERCICIOS ALTERNATIVOS PARA HIPERTROFIA
        System.out.println("Ejercicios alternativos para tu rutina de Hipertrofia:");
        System.out.println("1. Flexiones de pecho en lugar de press de banca");
        System.out.println("2. Remo con barra en lugar de pull-ups");
        System.out.println("3. Sentadillas con mancuernas en lugar de sentadillas con barra");
        System.out.println("4. Elevaciones laterales con mancuernas en lugar de press de hombros");
    }

    @Override
    public void ajustarRutina(int nivel, int diasPorSemana) {
        // AJUSTAMOS LA RUTINA DE EJERCICIOS SEGUN EL NIVEL DEL USUARIO Y LOS DIAS POR SEMANA
        // POR EJEMPLO, UN USUARIO PRINCIPIANTE HARIA UNA RUTINA CON MENOS DIAS Y MENOS EJERCICIOS POR DIA
        
    	if (nivel == 1) { // PRINCIPIANTE
            System.out.println("Rutina ajustada para nivel principiante: 3 días por semana.");
            diasPorSemana = 3;
        } else if (nivel == 2) { // INTERMEDIO
            System.out.println("Rutina ajustada para nivel intermedio: 4 días por semana.");
            diasPorSemana = 4;
        } else { // AVANZADO
            System.out.println("Rutina ajustada para nivel avanzado: 5 días por semana.");
            diasPorSemana = 5;
        }
        System.out.println("Duración total ajustada de la rutina: " + calcularDuracionTotal() + " minutos a la semana.");
    }
}

