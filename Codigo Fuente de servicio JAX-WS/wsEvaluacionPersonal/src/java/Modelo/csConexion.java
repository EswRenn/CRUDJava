
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class csConexion {
    public String user,password;
    public String url, driver;
    public Connection cn;
    
    public csConexion()
    {
        this.user="sa";
        this.password="1234";
        this.url="jdbc:sqlserver://localhost\\SQLEXPRESS01:1433;databaseName=EvaluacionPersonal;encrypt=true;trustServerCertificate=true";
        this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.cn=null;
    }
    public Connection conectar()
    {
        try
        {
        Class.forName(this.driver);
        cn = DriverManager.getConnection(url, user, password);
        return cn;
        }
        catch (Exception ex)
        {
            return null;
        }
    }    
   public void desconectar() throws SQLException
   {
       cn.close();
   }
}
