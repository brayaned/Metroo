package Metro;

import Conexion.Conexion;
import java.sql.*;

public class Usuario {

    private String idUsuario;
    private String contraseña;
    private int idTarjeta;
    private String nombre;

    Conexion conexion = new Conexion();
    Connection con = conexion.realziarConexion();
    PreparedStatement ps = null;

    public int verificarUsuario(int j, Usuario usuario, String id, String pass) {
        String sql = "SELECT * FROM usuario";
        Statement st;
        ResultSet result;
        try {
            st = con.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                if (id.equals(result.getString(1))) {
                    if (pass.equals(result.getString(2))) {
                        usuario.setIdUsuario(result.getString(1));
                        usuario.setContraseña(result.getString(2));
                        usuario.setIdTarjeta(result.getInt(3));
                        usuario.setNombre(result.getString(4));
                        j = 2;
                    } else {
                        j = 1;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }
        return j;
    }
    
    public int registrarUsuario(Usuario u,Tarjeta t, String pn,String ap,String id,String pass){
        
        
        String sql1="Select * from usuario";
        String sql="insert into Usuario (idUsuario,contraseña,idTarjeta,nombre) values (?,?,?,?)";
        String sqlt="insert into Tarjeta (idTarjeta,saldo,ulTran) values (?,?,?);";
        Statement st;
        ResultSet result;
        try {
            st=con.createStatement();
            result=st.executeQuery(sql1);
            while (result.next()) {
                if (id.equals(result.getString(1))) {
                    return -1;
                }
            }

            
            ps=con.prepareStatement(sqlt);
            ps.setInt(1,(t.getId()));
            ps.setInt(2,(t.getSaldo()));
            ps.setString(3,(t.getuTr()));
            ps.executeUpdate();
            
           
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getIdUsuario());
            System.out.println(u.getIdUsuario());
            ps.setString(2, u.getContraseña());
            ps.setInt(3, (t.getId()));
            ps.setString(4, u.getNombre());
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }
        return 0;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
