package Planes;

public interface PlanEjercicio {
	  // METODO PARA GENERAR UNA RUTINA SEGUN EL OBJETIVOO DEL USUARIO
  String generarRutina();
  
  // METODO PARA CALCULAR LA DURACION TOTAL DEL PLAN DE EJERCICIO
  int calcularDuracionTotal();
  
  // METODO PARA SUGERIR EJERCICIOS ALTERNATIVOS EN CASO DE NECESIDAD
  void sugerirEjerciciosAlternativos();
  
  // METODO PARA AJUSTAR LA RUTINA SEGUN EL NIVEL DEL USUARIO Y FRECUENCIA SEMANAL
  void ajustarRutina(int nivel, int diasPorSemana);
}
