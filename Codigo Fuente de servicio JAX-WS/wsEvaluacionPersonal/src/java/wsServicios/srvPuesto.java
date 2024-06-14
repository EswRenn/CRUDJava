package wsServicios;

import Modelo.Puesto;
import Modelo.csPuesto;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvPuesto")
public class srvPuesto {

    @WebMethod(operationName = "InsertarPuesto")
    public int InsertarPuesto(@WebParam(name="Nombre")String Nombre,
            @WebParam(name="Caracteristicas")String Caracteristicas,@WebParam(name="Sueldo" )String Sueldo)
            {
                csPuesto p = new csPuesto(); 
        return p.InsertarPuesto(Nombre,Caracteristicas,Sueldo);
    }
    
     @WebMethod(operationName = "ActualizarPuesto")
    public int ActualizarPuesto(@WebParam(name="Nombre")String Nombre, 
         @WebParam(name="Caracteristicas")String Caracteristicas, @WebParam(name="Sueldo" )String Sueldo, 
         @WebParam(name = "IdPuesto") int IdPuesto)
            {
                csPuesto p = new csPuesto(); 
       return p.ActualizarPuesto(Nombre,Caracteristicas,Sueldo,IdPuesto);
    }
    
     @WebMethod(operationName = "EliminarPuesto")
    public int EliminarPuesto(@WebParam(name = "IdPuesto") int IdPuesto)
            {
                csPuesto p = new csPuesto(); 
        return p.EliminarPuesto(IdPuesto);
    }
    
    @WebMethod(operationName = "ListarPuesto")
    public ArrayList<Puesto>ListarPuesto()
            {
                csPuesto p = new csPuesto(); 
        return p.ListarPuesto();
    }
    
    @WebMethod(operationName = "ListarPuestoPorId")
    public Puesto ListarPuestoPorId(@WebParam(name = "IdPuesto") int IdPuesto)
            {
                csPuesto p = new csPuesto(); 
        return p.ListarPuestoPorId(IdPuesto);
    }
}
