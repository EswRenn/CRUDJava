package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class csEmpleados{
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public csEmpleados() {
        this.con = null;
        this.stm = null;
    }
            
    public int InsertarEmpleados(int IdEmpresa, int IdPuesto, String Nombre, String Direccion, String Telefono, String Email) {
        int respuesta = 0;
    
        csConexion c1 = new csConexion();
    
        con = c1.conectar();
   
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate("insert into dbo.empleados(IdEmpresa,IdPuesto,Nombre,Direccion,Telefono,Email)" 
                   + " values ('" + IdEmpresa + "','" + IdPuesto + "','" + Nombre + "','" + Direccion + "','" + Telefono + "','" + Email + "')");
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            return 0;
        }
   
        return respuesta;
    }
    
   public int ActualizarEmpleados(int IdEmpresa, int IdPuesto,String Nombre, String Direccion, String Telefono, String Email,int IdEmpleado) {
    int respuesta = 0;

    csConexion c1 = new csConexion();
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = c1.conectar();
        String sql = "UPDATE dbo.empleado SET IdEmpresa=?, IdPuesto=?, Nombre=?, Direccion=?, Telefono=?, Email=? WHERE IdEmpleado=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, IdEmpresa);
        pstmt.setInt(2,IdPuesto);
        pstmt.setString(3, Nombre);
        pstmt.setString(4, Direccion);
        pstmt.setString(5, Telefono);
        pstmt.setString(6, Email);
        pstmt.setInt(7, IdEmpleado);

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
   
     public int EliminarEmpleados (int IdEmpleado) 
     {
         int respuesta = 0;
         csConexion c1 = new csConexion();
         con=c1.conectar();
         try
         {
             stm=con.createStatement();
             respuesta=stm.executeUpdate("delete from dbo.empleados where IdEmpleado = "+ IdEmpleado +"");
             c1.desconectar();
             con.close();
             stm.close();
         }
         catch (Exception ex)
         {
         }
         return respuesta;
     }
     
     public ArrayList<Empleados> ListarEmpleados ()
     {
     Empleados p = null;
     ArrayList<Empleados> lista = new ArrayList<Empleados>();
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Empleados");
     while (rs.next())
     {
     p= new Empleados (rs.getInt("IdEmpresa"),rs.getInt("IdPuesto"),rs.getString("Nombre"),rs.getString("Direccion"),
     rs.getString("Telefono"),rs.getString("Email"), rs.getInt(1));
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
     
     public Empleados ListarEmpleadosPorId (int IdEmpleado)
     {
     Empleados p = null;
    
     csConexion c1 = new csConexion();
     con=c1.conectar();
     rs=null;
     try
     {
     stm= con.createStatement();
     rs = stm.executeQuery("select * from dbo.Empleados where IdEmpleado= "+IdEmpleado+"");
     while (rs.next())
     {
     p= new Empleados(rs.getInt("IdEmpresa"),rs.getInt("IdPuesto"),rs.getString("Nombre"),rs.getString("Direccion"),
     rs.getString("Telefono"),rs.getString("Email"), rs.getInt(1)); 
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
