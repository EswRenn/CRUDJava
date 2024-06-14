package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csPuesto {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csPuesto() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarPuesto(String Nombre, String Caracteristicas, String Sueldo) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.puesto(Nombre,Caracteristicas,Sueldo)" 
                   + " values ('" + Nombre + "','" + Caracteristicas + "','" + Sueldo + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarPuesto(String Nombre, String Caracteristicas, String Sueldo, int IdPuesto) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.puesto SET Nombre=?, Caracteristicas=?, Sueldo=? WHERE IdPuesto=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Nombre);
        pstmt.setString(2, Caracteristicas);
        pstmt.setString(3, Sueldo);
        pstmt.setInt(4, IdPuesto);

        respuesta = pstmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return respuesta;
}
   
     public int EliminarPuesto (int IdPuesto) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.puesto where IdPuesto = "+ IdPuesto +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<Puesto> ListarPuesto ()
     {
     Puesto p = null;
     ArrayList<Puesto> lista = new ArrayList<Puesto>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Puesto");
     while (rs.next())
     {
     p= new Puesto (rs.getString("Nombre"),rs.getString("Caracteristicas"),
     rs.getString("Sueldo"),rs.getInt(1));
     lista.add(p);
     }
     c1.desconectar();
     con.close();
     stm.close();
     }
     catch (Exception ex)
     {
     
     }
     return lista;
     }
     
     public Puesto ListarPuestoPorId (int IdPuesto)
     {
     Puesto p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Puesto where IdPuesto = "+IdPuesto +"");
     while (rs.next())
     {
     p= new Puesto (rs.getString("Nombre"),rs.getString("Caracteristicas"),
     rs.getString("Sueldo"),rs.getInt(1));
     }
     c1.desconectar();
     con.close();
     stm.close();
     }
     catch (Exception ex)
     {
     
     }
     return p;
     }
}
