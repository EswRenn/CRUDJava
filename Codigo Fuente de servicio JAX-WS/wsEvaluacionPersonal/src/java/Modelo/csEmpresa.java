package Modelo;

import Modelo.Empresa;
import Modelo.csConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csEmpresa {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csEmpresa() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarEmpresa(String Nombre, String Direccion, int Telefono, String Email) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.Empresa(Nombre,Direccion,Telefono,Email) " 
                   + "values ('" + Nombre + "', '" + Direccion + "', '" + Telefono + "', '" + Email + "' ) ");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarEmpresa(String Nombre, String Direccion, String Telefono, String Email,int IdEmpresa) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.Empresa SET Nombre=?, Direccion=?, Telefono=?, Email=? WHERE IdEmpresa=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Nombre);
        pstmt.setString(2, Direccion);
        pstmt.setString(3, Telefono);
        pstmt.setString(4, Email);
        pstmt.setInt(5, IdEmpresa);

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
   
     public int EliminarEmpresa (int IdEmpresa) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.Empresa where IdEmpresa = "+ IdEmpresa +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<Empresa> ListarEmpresa ()
     {
     Empresa p = null;
     ArrayList<Empresa> lista = new ArrayList<Empresa>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Empresa");
     while (rs.next())
     {
     p= new Empresa (rs.getString("Nombre"),rs.getString("Direccion"),
     rs.getString("Telefono"),rs.getString("Email"), 
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
     
     public Empresa ListarEmpresaPorId (int IdEmpresa)
     {
     Empresa p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Empresa where IdEmpresa= "+IdEmpresa+"");
     while (rs.next())
     {
     p= new Empresa (rs.getString("Nombre"),rs.getString("Direccion"),
     rs.getString("Telefono"),rs.getString("Email"), 
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
