package Objetos;

import java.util.ArrayList;

public class GestorActividad {
	
	//ARRAY LIST  DE ACTIVIDADES
    private ArrayList<ActividadFisica> actividades;

    public GestorActividad() {
        actividades = new ArrayList<>();
        actividades.add(new Cardio("Correr", 30, 300, 8));
        actividades.add(new Fuerza("Levantamiento de pesas", 45, 400, "Piernas"));
        actividades.add(new Deporte("Fútbol", 60, 500, "Equipo"));
        actividades.add(new Cardio("Saltar la cuerda", 20, 250, 7));
        actividades.add(new Deporte("Tenis", 50, 450, "Individual"));
        actividades.add(new Cardio("Natación", 40, 350, 9));
        actividades.add(new Deporte("Baloncesto", 60, 550, "Equipo"));
        actividades.add(new Cardio("Ciclismo", 45, 400, 7));
        actividades.add(new Fuerza("Sentadillas", 35, 420, "Piernas"));
        actividades.add(new Deporte("Voleibol", 50, 480, "Equipo"));
        actividades.add(new Cardio("Elíptica", 30, 280, 6));
        actividades.add(new Fuerza("Peso muerto", 40, 450, "Espalda"));
        actividades.add(new Deporte("Boxeo", 45, 550, "Individual"));  
        actividades.add(new Deporte("Karate", 40, 520, "Individual"));
        actividades.add(new Cardio("Patinaje", 60, 600, 9));
        actividades.add(new Fuerza("Hip thrust", 35, 400, "Glúteos"));
        actividades.add(new Deporte("Rugby", 70, 650, "Equipo"));
        actividades.add(new Cardio("Zumba", 45, 420, 7));
        actividades.add(new Fuerza("Prensa de piernas", 30, 390, "Piernas"));
        actividades.add(new Cardio("Baile aeróbico", 50, 450, 8));
        actividades.add(new Fuerza("Abdominales", 20, 150, "Core"));
       
    }

    public void mostrarActividades() {
        for (ActividadFisica actividad : actividades) {
            actividad.mostrarInfo();
            System.out.println(actividad.descripcion());
            System.out.println("--------------------------------");
        }
    }
}
