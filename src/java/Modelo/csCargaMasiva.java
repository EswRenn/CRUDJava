package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csCargaMasiva {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csCargaMasiva() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarCargaMasiva(int IdRegistro, int IdEmpleado, int IdPuesto) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.CargaMasiva(IdRegistro,IdEmpleado,IdPuesto)" 
                   + " values ('" + IdRegistro + "','" + IdEmpleado+ "','" + IdPuesto+ "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarCargaMasiva( int IdRegistro, int IdEmpleado, int IdPuesto,int IdCarga) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.CargaMasiva SET IdRegistro=?, IdEmpleado=?, IdPuesto=? WHERE IdCarga=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, IdRegistro);
        pstmt.setInt(2, IdEmpleado);
        pstmt.setInt(3, IdPuesto);
        pstmt.setInt(4, IdCarga);

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
   
     public int EliminarCargaMasiva (int IdCarga) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.CargaMasiva where IdCarga = "+ IdCarga +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<CargaMasiva> ListarCargaMasiva ()
     {
     CargaMasiva p = null;
     ArrayList<CargaMasiva> lista = new ArrayList<CargaMasiva>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.CargaMasiva");
     while (rs.next())
     {
     p= new CargaMasiva (rs.getInt("IdRegistro"),rs.getInt("IdEmpleado"),rs.getInt("IdPuesto"),
     rs.getInt(1));
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
     
     public CargaMasiva ListarCargaMasivaPorId (int IdCarga)
     {
     CargaMasiva  p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.CargaMasiva  where IdCarga "+IdCarga+"");
     while (rs.next())
     {
     p= new CargaMasiva (rs.getInt("IdRegistro"),rs.getInt("IdEmpleado"),
     rs.getInt("IdPuesto"),
     rs.getInt(1));
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
