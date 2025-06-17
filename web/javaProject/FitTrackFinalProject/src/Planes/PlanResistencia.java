package Planes;

public class PlanResistencia implements PlanEjercicio{

    @Override
    public String generarRutina() {
        // SIMULAMOS UNA RUTINA DE EJERCICIOS PARA RESISTENCIA
        return """
               Rutina para Resistencia:
               Dia 1: Cardio (40 minutos) + Circuito de pesas (cuerpo entero)
               Dia 2: HIIT (30 minutos)
               Dia 3: Cardio largo (60 minutos)
               Dia 4: Circuito de pesas (cuerpo entero)
               Dia 5: Cardio ligero o HIIT (30 minutos)
               Dia 6: Día de descanso o yoga
               Dia 7: Cardio largo o descanso
               """;
    }

    @Override
    public int calcularDuracionTotal() {
     
        int diasPorSemana = 6; // SUPONEMOS QUE EL USUARIO REALIZA LA RUTINA 6 DIAS A LA SEMANA
        int duracionPromedioPorSesion = 45; // CADA SESION DE CARDIO O CIRCUITO DURA 45 MINUTOS
        return diasPorSemana * duracionPromedioPorSesion; // TOTAL DE MINUTOS POR SEMANA
    }

    @Override
    public void sugerirEjerciciosAlternativos() {
        // SUGERIMOS EJERCICIOS ALTERNATIVOS PARA RESISTENCIA
        System.out.println("Ejercicios alternativos para tu rutina de Resistencia:");
        System.out.println("1. Bicicleta en lugar de correr en cinta");
        System.out.println("2. Flexiones en lugar de press de banca");
        System.out.println("3. Sentadillas con peso en lugar de sentadillas sin peso");
        System.out.println("4. Escaladores en lugar de saltos");
    }

    @Override
    public void ajustarRutina(int nivel, int diasPorSemana) {
        // AJUSTAMOS LA RUTINA DE EJERCICIOS SEGUN EL NIVEL DEL USUARIO Y LOS DIAS POR SEMANA
        // UN USUARIO PRINCIPIANTE PODRIA HACER MENOS SESIONES O RUTINAS MAS LIGERAS
        if (nivel == 1) { // Principiante
            System.out.println("Rutina ajustada para nivel principiante: 3-4 dias por semana.");
            diasPorSemana = 4;
        } else if (nivel == 2) { // Intermedio
            System.out.println("Rutina ajustada para nivel intermedio: 4-5 dias por semana.");
            diasPorSemana = 5;
        } else { // Avanzado
            System.out.println("Rutina ajustada para nivel avanzado: 6 dias por semana.");
            diasPorSemana = 6;
        }
        System.out.println("Duracion total ajustada de la rutina: " + calcularDuracionTotal() + " minutos a la semana.");
    }
}
