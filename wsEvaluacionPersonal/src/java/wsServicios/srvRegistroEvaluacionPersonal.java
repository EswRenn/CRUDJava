package wsServicios;

import Modelo.RegistroEvaluacionPersonal;
import Modelo.csRegistroEvaluacionPersonal;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvRegistroEvaluacionPersonal")
public class srvRegistroEvaluacionPersonal {

    @WebMethod(operationName = "InsertarRegistroEvaluacionPersonal")
    public int InsertarRegistroEvaluacionPersonal(@WebParam(name = "IdEmpleado") int IdEmpleado,
            @WebParam(name="IdEvaluacion")int IdEvaluacion, @WebParam(name="Respuesta1")String Respuesta1,
            @WebParam(name="Respuesta2" )String Respuesta2,@WebParam(name="Respuesta3" )String Respuesta3,
            @WebParam(name="Respuesta4" )String Respuesta4)
            {
                csRegistroEvaluacionPersonal p = new csRegistroEvaluacionPersonal(); 
        return p.InsertarRegistroEvaluacionPersonal(IdEmpleado,IdEvaluacion,Respuesta1,Respuesta2,Respuesta3,Respuesta4);
    }
    
     @WebMethod(operationName = "ActualizarRegistroEvaluacionPersonal")
    public int ActualizarRegistroEvaluacionPersonal(@WebParam(name = "IdEmpleado") int IdEmpleado,
            @WebParam(name="IdEvaluacion")int IdEvaluacion, @WebParam(name="Respuesta1")String Respuesta1,
            @WebParam(name="Respuesta2" )String Respuesta2,@WebParam(name="Respuesta3" )String Respuesta3,
            @WebParam(name="Respuesta4" )String Respuesta4,@WebParam(name = "IdRegistro") int IdRegistro)
            {
                csRegistroEvaluacionPersonal p = new csRegistroEvaluacionPersonal(); 
       return p.ActualizarRegistroEvaluacionPersonal(IdEmpleado,IdEvaluacion,Respuesta1,Respuesta2,Respuesta3,Respuesta4,IdRegistro);
    }
    
     @WebMethod(operationName = "EliminarRegistroEvaluacionPersonal")
    public int EliminarRegistroEvaluacionPersonal(@WebParam(name = "IdRegistro") int IdRegistro)
            {
                csRegistroEvaluacionPersonal p = new csRegistroEvaluacionPersonal(); 
        return p.EliminarRegistroEvaluacionPersonal(IdRegistro);
    }
    
    @WebMethod(operationName = "ListarRegistroEvaluacionPersonal")
    public ArrayList<RegistroEvaluacionPersonal>ListarRegistroEvaluacionPersonal()
            {
                csRegistroEvaluacionPersonal p = new csRegistroEvaluacionPersonal(); 
        return p.ListarRegistroEvaluacionPersonal();
    }
    
    @WebMethod(operationName = "ListarRegistroEvaluacionPersonalPorId")
    public RegistroEvaluacionPersonal ListarRegistroEvaluacionPersonalPorId(@WebParam(name = "IdRegistro") int IdRegistro )
            {
                csRegistroEvaluacionPersonal p = new csRegistroEvaluacionPersonal(); 
        return p.ListarRegistroEvaluacionPersonalPorId(IdRegistro);
    }
}

