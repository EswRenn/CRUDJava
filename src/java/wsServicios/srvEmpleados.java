package wsServicios;

import Modelo.Empleados;
import Modelo.csEmpleados;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvEmpleados")
public class srvEmpleados {

    @WebMethod(operationName = "InsertarEmpleados")
    public int InsertarEmpleados(@WebParam(name = "IdEmpresa") int IdEmpresa,
            @WebParam(name = "IdPuesto") int IdPuesto,@WebParam(name="Nombre")String Nombre,
            @WebParam(name="Direcccion")String Direccion,@WebParam(name="Telefono" )String Telefono,
            @WebParam(name="Email" )String Email)
            {
                csEmpleados p = new csEmpleados(); 
        return p.InsertarEmpleados(IdEmpresa,IdPuesto,Nombre,Direccion,Telefono,Email);
    }
    
     @WebMethod(operationName = "ActualizarEmpleados")
    public int ActualizarEmpleados(@WebParam(name = "IdEmpresa") int IdEmpresa,
            @WebParam(name = "IdPuesto") int IdPuesto,@WebParam(name="Nombre")String Nombre,
            @WebParam(name="Direcccion")String Direccion,@WebParam(name="Telefono" )String Telefono,
            @WebParam(name="Email" )String Email,@WebParam(name = "IdEmpleado") int IdEmpleado)
            {
                csEmpleados p = new csEmpleados(); 
       return p.ActualizarEmpleados(IdEmpresa,IdPuesto,Nombre,Direccion,Telefono,Email,IdEmpleado);
    }
    
     @WebMethod(operationName = "EliminarEmpleados")
    public int EliminarEmpleados(@WebParam(name = "IdEmpleado") int IdEmpleado)
            {
                csEmpleados p = new csEmpleados(); 
        return p.EliminarEmpleados(IdEmpleado);
    }
    
    @WebMethod(operationName = "ListarEmpleados")
    public ArrayList<Empleados> ListarEmpleados()
            {
        csEmpleados p = new csEmpleados(); 
        return p.ListarEmpleados();
    }
    
    @WebMethod(operationName = "listarPorId")
    public Empleados ListarEmpleadosPorId(@WebParam(name = "IdEmpleado") int IdEmpleado)
            {
                csEmpleados p = new csEmpleados(); 
        return p.ListarEmpleadosPorId(IdEmpleado);
    }
}
