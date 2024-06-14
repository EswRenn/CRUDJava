package wsServicios;

import Modelo.Preguntas;
import Modelo.csPreguntas;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvPreguntas")
public class srvPreguntas {

    @WebMethod(operationName = "InsertarPreguntas")
    public int InsertarPreguntas(@WebParam(name="IdTipo")int IdTipo,
            @WebParam(name="IdPonderacion")int IdPonderacion,@WebParam(name="Pregunta1" )String Pregunta1,
            @WebParam(name="Pregunta2" )String Pregunta2,@WebParam(name="Pregunta3" )String Pregunta3,
            @WebParam(name="Pregunta4" )String Pregunta4)
            {
                csPreguntas p = new csPreguntas(); 
        return p.InsertarPreguntas(IdTipo, IdPonderacion, Pregunta1, Pregunta2, Pregunta3, Pregunta4);
    }
    
     @WebMethod(operationName = "ActualizarPreguntas")
    public int ActualizarPreguntas (@WebParam(name="IdTipo")int IdTipo,@WebParam(name="IdPonderacion")int IdPonderacion,
            @WebParam(name="Pregunta1" )String Pregunta1,@WebParam(name="Pregunta2" )String Pregunta2,
            @WebParam(name="Pregunta3" )String Pregunta3,@WebParam(name="Pregunta4" )String Pregunta4,
            @WebParam(name = "IdPregunta") int IdPregunta)
       
            {
                csPreguntas p = new csPreguntas(); 
       return p.ActualizarPreguntas(IdTipo, IdPonderacion, Pregunta1, Pregunta2, Pregunta3, Pregunta4, IdPregunta);
    }
    
     @WebMethod(operationName = "EliminarPreguntas")
    public int EliminarPreguntas (@WebParam(name = "IdPregunta") int IdPregunta)
            {
                csPreguntas p = new csPreguntas(); 
        return p.EliminarPreguntas(IdPregunta);
    }
    
    @WebMethod(operationName = "ListarPreguntas")
    public ArrayList<Preguntas>ListarPreguntas()
            {
                csPreguntas p = new csPreguntas(); 
        return p.ListarPreguntas();
    }
    
    @WebMethod(operationName = "listarPreguntasPorId")
    public Preguntas ListarPreguntasPorId(@WebParam(name = "IdPregunta") int IdPregunta)
            {
                csPreguntas p = new csPreguntas(); 
        return p.ListarPreguntasPorId(IdPregunta);
    }
}
