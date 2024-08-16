package wsServicios;

import Modelo.TipoEvaluacion;
import Modelo.csTipoEvaluacion;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvTipoEvaluacion")
public class srvTipoEvaluacion {

    @WebMethod(operationName = "InsertarTipoEvaluacion")
    public int InsertarTipoEvaluacion(@WebParam(name = "IdPregunta") int IdPregunta,
            @WebParam(name="Evaluacion1")String Evaluacion1,@WebParam(name="Evaluacion2")String Evaluacion2)
            {
                csTipoEvaluacion p = new csTipoEvaluacion(); 
        return p.InsertarTipoEvaluacion(IdPregunta, Evaluacion1, Evaluacion2);
    }
    
     @WebMethod(operationName = "ActualizarTipoEvaluacion")
    public int ActualizarTipoEvaluacion(@WebParam(name = "IdPregunta") int IdPregunta,@WebParam(name="Evaluacion1")String Evaluacion1,
            @WebParam(name="Evaluacion2")String Evaluacion2, @WebParam(name = "IdTipoEvaluacion") int IdEvaluacion)
            {
                csTipoEvaluacion p = new csTipoEvaluacion(); 
       return p.ActualizarTipoEvaluacion(IdPregunta, Evaluacion1, Evaluacion2,IdEvaluacion);
    }
    
     @WebMethod(operationName = "EliminarTipoEvaluacion")
    public int EliminarTipoEvaluacion(@WebParam(name = "IdEvaluacion") int IdEvaluacion)
            {
                csTipoEvaluacion p = new csTipoEvaluacion(); 
        return p.EliminarTipoEvaluacion(IdEvaluacion);
    }
    
    @WebMethod(operationName = "ListarTipoEvaluacion")
    public ArrayList<TipoEvaluacion>ListarTipoEvaluacion()
            {
                csTipoEvaluacion p = new csTipoEvaluacion(); 
        return p.ListarTipoEvaluacion();
    }
    
    @WebMethod(operationName = "ListarPorId")
    public TipoEvaluacion ListarTipoEvaluacionPorId(@WebParam(name = "IdEvaluacion") int IdEvaluacion)
            {
                csTipoEvaluacion p = new csTipoEvaluacion(); 
        return p.ListarTipoEvaluacionPorId(IdEvaluacion);
    }
}
