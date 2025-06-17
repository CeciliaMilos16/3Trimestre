package Planes;

public class PlanPerdidaDeGrasa implements PlanEjercicio{

    @Override
    public String generarRutina() {
        // SIMULAMOS UNA RUTINA DE EJERCICIOS PARA PERDER GRASA
        return """
               Rutina para Perdida de Grasa:
               Dia 1: Cardio (30 minutos) + Circuito de pesas (cuerpo entero)
               Dia 2: HIIT (30 minutos)
               Dia 3: Cardio (40 minutos)
               Dia 4: HIIT (30 minutos)
               Dia 5: Circuito de pesas (cuerpo entero) + Cardio (20 minutos)
               Dia 6: Dia de descanso o yoga
               Dia 7: Cardio ligero o descanso
               """;
    }

    @Override
    public int calcularDuracionTotal() {
      
        int diasPorSemana = 6; // SUPONEMOS QUE EL USUARIO REALIZA LA RUTINA 6 DIAS A LA SEMANA
        int duracionPromedioPorSesion = 40; // CADA SESION DE CARDIO O HIIT DURA 40 MINUTOS
        return diasPorSemana * duracionPromedioPorSesion; // TOTAL DE MINUTOS POR SEMANA
    }

    @Override
    public void sugerirEjerciciosAlternativos() {
        // SUGERIMOS EJERCICIOS ALTERNATIVOS PARA PERDER GRASA
        System.out.println("Ejercicios alternativos para tu rutina de Perdida de Grasa:");
        System.out.println("1. Bicicleta estatico en lugar de correr en cinta");
        System.out.println("2. Sentadillas con salto en lugar de step-ups");
        System.out.println("3. Burpees en lugar de saltos de tijera");
        System.out.println("4. Caminatas rapidas en lugar de correr");
    }

    @Override
    public void ajustarRutina(int nivel, int diasPorSemana) {
        // AJUSTAMOS LA RUTINA DE EJERCICIOS SEGUN EL NIVEL DEL USUARIO Y LOS DIAS POR SEMANA
        // UN USUARIO PRINCIPIANTE PODRIA HACER MENOS SESIONES DE CARDIO O HIIT
        if (nivel == 1) { // Principiante
            System.out.println("Rutina ajustada para nivel principiante: 3-4 dias por semana.");
            diasPorSemana = 4;
        } else if (nivel == 2) { // Intermedio
            System.out.println("Rutina ajustada para nivel intermedio: 5 dias por semana.");
            diasPorSemana = 5;
        } else { // Avanzado
            System.out.println("Rutina ajustada para nivel avanzado: 6 dias por semana.");
            diasPorSemana = 6;
        }
        System.out.println("Duracion total ajustada de la rutina: " + calcularDuracionTotal() + " minutos a la semana.");
    }
}
