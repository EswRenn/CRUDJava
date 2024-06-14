package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csPreguntas {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csPreguntas() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarPreguntas(int IdTipo, int IdPonderacion,String Pregunta1, String Pregunta2, String Pregunta3, String Pregunta4) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.preguntas(IdTipo,IdPonderacion,Pregunta1,Pregunta2,Pregunta3,Pregunta4)" 
                   + " values ('" + IdTipo + "','" + IdPonderacion + "','" + Pregunta1 + "','" + Pregunta2 + "','" + Pregunta3 + "','" + Pregunta4 + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarPreguntas(int IdTipo, int IdPonderacion, String Pregunta1, String Pregunta2, String Pregunta3, String Pregunta4, int IdPregunta) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.preguntas SET IdTipo=?, IdPonderacion=?, Pregunta1=?, Pregunta2=?, Pregunta3=?, Pregunta4=? WHERE IdTipo=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, IdTipo);
        pstmt.setInt(2, IdPonderacion);
        pstmt.setString(3, Pregunta1);
        pstmt.setString(4, Pregunta2);
        pstmt.setString(5, Pregunta3);
        pstmt.setString(6, Pregunta4);
        pstmt.setInt(7, IdPregunta);

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
   
     public int EliminarPreguntas (int IdPregunta) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.preguntas where IdPregunta = "+ IdPregunta+"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<Preguntas> ListarPreguntas()
     {
     Preguntas p = null;
     ArrayList<Preguntas> lista = new ArrayList<Preguntas>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Pregunta");
     while (rs.next())
     {
     p= new Preguntas (rs.getInt("IdTipo"),rs.getInt("IdPonderacion"),rs.getString("Pregunta1"),rs.getString("Pregunta2"),
     rs.getString("Pregunta3"),rs.getString("Pregunta4"),rs.getInt(1));
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
     
     public Preguntas ListarPreguntasPorId(int IdPregunta)
     {
    Preguntas p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Preguntas where IdPregunta= "+IdPregunta+"");
     while (rs.next())
     {
   p= new Preguntas (rs.getInt("IdTipo"),rs.getInt("IdPonderacion"),rs.getString("Pregunta1"),rs.getString("Pregunta2"),
     rs.getString("Pregunta3"),rs.getString("Pregunta4"),rs.getInt(1));
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
