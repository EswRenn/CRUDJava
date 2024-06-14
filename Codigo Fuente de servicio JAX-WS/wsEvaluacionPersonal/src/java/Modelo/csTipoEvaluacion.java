package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csTipoEvaluacion {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csTipoEvaluacion() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarTipoEvaluacion(int IdPregunta, String Evaluacion1,String Evaluacion2) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into .dbo.tipoevaluacion(IdPregunta,Evaluacion1,Evaluacion2)" 
                   + " values ('" + IdPregunta + "','" +Evaluacion1 + "','" + Evaluacion2 + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarTipoEvaluacion(int IdPregunta, String Evaluacion1,String Evaluacion2,int IdEvaluacion) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.tipoevaluacion SET IdPregunta=?, Evaluacion1=?, Evaluacion2=? WHERE IdEvaluacion=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, IdPregunta);
        pstmt.setString(2, Evaluacion1);
        pstmt.setString(3, Evaluacion2);
        pstmt.setInt(4, IdEvaluacion);

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
   
     public int EliminarTipoEvaluacion (int IdEvaluacion) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.tipoevaluacion where IdEvaluacion = "+ IdEvaluacion +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<TipoEvaluacion> ListarTipoEvaluacion()
     {
      TipoEvaluacion p = null;
     ArrayList<TipoEvaluacion> lista = new ArrayList<TipoEvaluacion>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.TipoEvaluacion");
     while (rs.next())
     {
     p= new TipoEvaluacion (rs.getInt("IdPregunta"),rs.getString("Evaluacion1"),
     rs.getString("Evaluacion2"),rs.getInt(1));
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
     
     public TipoEvaluacion ListarTipoEvaluacionPorId (int IdEvaluacion)
     {
     TipoEvaluacion p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.TipoEvaluacion where IdEvaluacion= "+IdEvaluacion+"");
     while (rs.next())
     {
      p= new TipoEvaluacion (rs.getInt("IdPregunta"),rs.getString("Evaluacion1"),
     rs.getString("Evaluacion2"),rs.getInt(1));
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
