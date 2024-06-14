
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csRegistroEvaluacionPersonal {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csRegistroEvaluacionPersonal() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarRegistroEvaluacionPersonal(int IdEmpleado, int IdEvaluacion,String Respuesta1, String Respuesta2, String Respuesta3, String Respuesta4) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.RegistroEvaluacionPersonal(IdEmpleado,IdEvaluacion,Respuesta1,Respuesta2,Respuesta3,Respuesta4)" 
                   + " values ('" + IdEmpleado + "','" + IdEvaluacion + "','" +Respuesta1 + "','" + Respuesta2 + "','" + Respuesta3 + "','" + Respuesta4 + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarRegistroEvaluacionPersonal( int IdEmpleado, int IdEvaluacion,String Respuesta1, String Respuesta2, String Respuesta3, String Respuesta4,int IdRegistro) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.RegistroEvaluacionPersonal SET IdEmpleado=?, IdEvaluacion=?, Respuesta1=?, Respuesta2=?, Respuesta3=?, Respuesta4=? WHERE IdRegistro=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, IdEmpleado);
        pstmt.setInt(2, IdEvaluacion);
        pstmt.setString(3, Respuesta1);
        pstmt.setString(4, Respuesta2);
        pstmt.setString(5, Respuesta3);
        pstmt.setString(6, Respuesta4);
        pstmt.setInt(7, IdRegistro);

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
   
     public int EliminarRegistroEvaluacionPersonal (int IdRegistro) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.RegistroEvaluacionPersonal where IdRegistro = "+ IdRegistro+"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<RegistroEvaluacionPersonal> ListarRegistroEvaluacionPersonal()
     {
     RegistroEvaluacionPersonal p = null;
     ArrayList<RegistroEvaluacionPersonal> lista = new ArrayList<RegistroEvaluacionPersonal>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.RegistroEvaluacionPersonal");
     while (rs.next())
     {
     p= new RegistroEvaluacionPersonal (rs.getInt("IdEmpleado"),rs.getInt("IdEvaluacion"),rs.getString("Respuesta1"),
     rs.getString("Respuesta2"),rs.getString("Respuesta3"),rs.getString("Respuesta4"),rs.getInt(1));
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
     
     public RegistroEvaluacionPersonal ListarRegistroEvaluacionPersonalPorId (int IdRegistro)
     {
    RegistroEvaluacionPersonal p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.RegistroEvaluacionPersonal where IdRegistro= "+IdRegistro+"");
     while (rs.next())
     {
    p= new RegistroEvaluacionPersonal (rs.getInt("IdEmpleado"),rs.getInt("IdEvaluacion"),rs.getString("Respuesta1"),rs.getString("Respuesta2"),
     rs.getString("Respuesta3"),rs.getString("Respuesta4"),rs.getInt(1));
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

