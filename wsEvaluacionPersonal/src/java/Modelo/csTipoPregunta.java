package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csTipoPregunta {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csTipoPregunta() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarTipoPregunta(String Tipo1, String Tipo2,String Tipo3, String Tipo4) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.tipopregunta(Tipo1,Tipo2,Tipo3,Tipo4)" 
                   + " values ('" + Tipo1 + "','" + Tipo2 + "','" + Tipo3 + "','" + Tipo4 + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarTipoPregunta(String Tipo1, String Tipo2, String Tipo3, String Tipo4, int IdTipo) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.tipopregunta SET Tipo1=?, Tipo2=?, Tipo3=?, Tipo4=? WHERE IdTipo=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Tipo1);
        pstmt.setString(2, Tipo2);
        pstmt.setString(3, Tipo3);
        pstmt.setString(3, Tipo4);
        pstmt.setInt(4, IdTipo);

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
   
     public int EliminarTipoPregunta (int IdTipo) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.tipopregunta where IdTipo = "+ IdTipo +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<TipoPregunta> ListarTipoPregunta()
     {
      TipoPregunta p = null;
     ArrayList<TipoPregunta> lista = new ArrayList<TipoPregunta>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.TipoPregunta");
     while (rs.next())
     {
     p= new TipoPregunta (rs.getString("Tipo1"),rs.getString("Tipo2"),
     rs.getString("Tipo3"),rs.getString("Tipo4"),
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
     
     public TipoPregunta ListarTipoPreguntaPorId (int IdTipo)
     {
     TipoPregunta p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.TipoPregunta where IdTipo= "+IdTipo+"");
     while (rs.next())
     {
    p= new TipoPregunta (rs.getString("Tipo1"),rs.getString("Tipo2"),
     rs.getString("Tipo3"),rs.getString("Tipo4"),rs.getInt(1));
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

