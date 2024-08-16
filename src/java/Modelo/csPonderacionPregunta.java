package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csPonderacionPregunta {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csPonderacionPregunta() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarPonderacionPregunta(int Punteo1, int Punteo2,int Punteo3, int Punteo4) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.ponderacionpregunta(Punteo1,Punteo2,Punteo3,Punteo4)" 
                   + " values ('" + Punteo1 + "','" + Punteo2 + "','" + Punteo3 + "','" + Punteo4 + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarPonderacionPregunta(int Punteo1, int Punteo2,int Punteo3,int Punteo4, int IdPonderacion) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.ponderacionpregunta SET Punteo1=?, Punteo2=?,Punteo3=?, Punteo4=? WHERE IdPonderacion=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, Punteo1);
        pstmt.setInt(2, Punteo2);
        pstmt.setInt(3, Punteo3);
        pstmt.setInt(4, Punteo4);
        pstmt.setInt(5, IdPonderacion);

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
   
     public int EliminarPonderacionPregunta (int IdPonderacion) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.ponderacionpregunta where IdPonderacion = "+ IdPonderacion +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<PonderacionPregunta> ListarPonderacionPregunta()
     {
      PonderacionPregunta p = null;
     ArrayList<PonderacionPregunta> lista = new ArrayList<PonderacionPregunta>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.PonderacionPregunta");
     while (rs.next())
     {
     p= new PonderacionPregunta (rs.getInt("Punteo1"),rs.getInt("Punteo2"),
     rs.getInt("Punteo3"),rs.getInt("Punteo4"),
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
     
     public PonderacionPregunta ListarPonderacionPreguntaPorId (int IdPonderacion)
     {
    PonderacionPregunta p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.PonderacionPregunta where IdPonderacion= "+IdPonderacion+"");
     while (rs.next())
     {
    p= new PonderacionPregunta (rs.getInt("Punteo1"),rs.getInt("Punteo2"),
     rs.getInt("Punteo3"),rs.getInt("Punteo4"),rs.getInt(1));
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
