package Conexion;
import java.sql.*;

public class Conexion {
    
    Connection conexion;
    public Connection realziarConexion() {
        String url = "jdbc:postgresql://localhost:5432/Metro";
        String usuario = "postgres";
        String pass = "postgres2018";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            java.sql.Statement st = conexion.createStatement();
        } catch (Exception e) {
            System.out.println("Error de Conexion " + e.getMessage());
        }return conexion;
    }
}
