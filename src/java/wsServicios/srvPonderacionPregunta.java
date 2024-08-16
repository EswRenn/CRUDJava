package wsServicios;

import Modelo.PonderacionPregunta;
import Modelo.csPonderacionPregunta;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvPonderacionPregunta")
public class srvPonderacionPregunta {

    @WebMethod(operationName = "InsertarPonderacionPregunta")
    public int InsertarPonderacionPregunta(@WebParam(name="Punteo1")int Punteo1,
            @WebParam(name="Punteo2")int Punteo2,@WebParam(name="Punteo3" )int Punteo3,@WebParam(name="Punteo4" )int Punteo4)
            {
                csPonderacionPregunta p = new csPonderacionPregunta(); 
        return p.InsertarPonderacionPregunta(Punteo1,Punteo2,Punteo3,Punteo4);
    }
    
     @WebMethod(operationName = "ActualizarPonderacionPregunta")
    public int ActualizarPonderacionPregunta(@WebParam(name="Punteo1")int Punteo1, 
         @WebParam(name="Punteo2")int Punteo2, @WebParam(name="Punteo3" )int Punteo3, @WebParam(name="Punteo4" )int Punteo4,
         @WebParam(name = "IdPonderacion") int IdPonderacion)
            {
                csPonderacionPregunta p = new csPonderacionPregunta(); 
       return p.ActualizarPonderacionPregunta(Punteo1,Punteo2,Punteo3,Punteo4,IdPonderacion);
    }
    
     @WebMethod(operationName = "EliminarPonderacionPregunta")
    public int EliminarPonderacionPregunta(@WebParam(name = "IdPonderacion") int IdPonderacion)
            {
                csPonderacionPregunta p = new csPonderacionPregunta(); 
        return p.EliminarPonderacionPregunta(IdPonderacion);
    }
    
    @WebMethod(operationName = "ListarPonderacionPregunta")
    public ArrayList<PonderacionPregunta>ListarPonderacionPregunta()
            {
                csPonderacionPregunta p = new csPonderacionPregunta(); 
        return p.ListarPonderacionPregunta();
    }
    
    @WebMethod(operationName = "ListarPonderacionPreguntaPorId")
    public PonderacionPregunta ListarPonderacionPreguntaPorId(@WebParam(name = "IdPonderacion") int IdPonderacion)
            {
                csPonderacionPregunta p = new csPonderacionPregunta(); 
        return p.ListarPonderacionPreguntaPorId(IdPonderacion);
    }
}
