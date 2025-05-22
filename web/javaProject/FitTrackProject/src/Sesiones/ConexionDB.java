package Sesiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	  Connection conn = null;
      static String url = "jdbc:mysql://localhost:3306/proyectofinal";  // URL de conexión
      static String user = "root";      // Cambia por tu usuario de MySQL
      static String password = "";      // Cambia por tu contraseña
    public static Connection getConnection() {
      
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
        }

        return conn;
    
    }

    public static void main(String[] args) {
    	System.out.println("Conectando a: " + url + " con usuario: " + user);

        getConnection();
    }
}
