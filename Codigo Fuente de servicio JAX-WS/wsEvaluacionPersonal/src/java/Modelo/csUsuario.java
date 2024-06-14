package Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class csUsuario {
   
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csUsuario() {
        this.con = null;
        this.stm = null;
    }
            
    public Usuario autenticar(String Usuario, String Contraseña) {
        Usuario u = null;
    
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;
        try {
            stm = con.createStatement();
            rs=stm.executeQuery("select u.IdUsuario, e.IdEmpleado, u.Usuario, e.Nombre "
            + "from Usuario u inner join Empleados e "
            + "on u.IdEmpleado=e.IdEmpleado "
            + "where Usuario= '" + Usuario + "' and Contraseña= '" + Contraseña + "' ");
            while(rs.next())
            {
            u=new Usuario(rs.getInt(1),rs.getInt(1),rs.getString("Usuario"),rs.getString("Nombre"));
            }
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {

        }   
        return u;
    }
}

