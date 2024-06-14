package wsServicios;

import Modelo.CargaMasiva;
import Modelo.csCargaMasiva;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvCargaMasiva")
public class srvCargaMasiva {

    @WebMethod(operationName = "InsertarCargaMasiva")
    public int InsertarCargaMasiva(@WebParam(name = "IdRegistro") int IdRegistro,
            @WebParam(name = "IdEmpleado") int IdEmpleado,@WebParam(name = "IdPuesto") int IdPuesto)
            {
                csCargaMasiva p = new csCargaMasiva(); 
        return p.InsertarCargaMasiva(IdRegistro,IdEmpleado,IdPuesto);
    }
    
     @WebMethod(operationName = "ActualizarCargaMasiva")
    public int ActualizarCargaMasiva(@WebParam(name = "IdRegistro") int IdRegistro,@WebParam(name = "IdEmpleado") int IdEmpleado,
            @WebParam(name = "IdPuesto") int IdPuesto,@WebParam(name = "IdCarga") int IdCarga)
            {
                csCargaMasiva p = new csCargaMasiva(); 
       return p.ActualizarCargaMasiva(IdCarga,IdRegistro,IdEmpleado,IdPuesto);
    }
    
     @WebMethod(operationName = "EliminarCargaMasiva")
    public int EliminarCargaMasiva(@WebParam(name = "IdCarga") int IdCarga)
            {
                csCargaMasiva p = new csCargaMasiva(); 
        return p.EliminarCargaMasiva(IdCarga);
    }
    
    @WebMethod(operationName = "ListarCargaMasiva")
    public ArrayList<CargaMasiva>ListarCargaMasiva()
            {
                csCargaMasiva p = new csCargaMasiva(); 
        return p.ListarCargaMasiva();
    }
    
    @WebMethod(operationName = "listarPorId")
    public CargaMasiva ListarCargaMasivaPorId(@WebParam(name = "IdCarga") int IdCarga)
            {
                csCargaMasiva p = new csCargaMasiva(); 
        return p.ListarCargaMasivaPorId(IdCarga);
    }
}

