package wsServicios;

import Modelo.TipoPregunta;
import Modelo.csTipoPregunta;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvTipoPregunta")
public class srvTipoPregunta {

    @WebMethod(operationName = "InsertarTipoPregunta")
    public int InsertarTipoPregunta(@WebParam(name="Tipo1")String Tipo1,
            @WebParam(name="Tipo2")String Tipo2,@WebParam(name="Tipo3" )String Tipo3,@WebParam(name="Tipo4" )String Tipo4)
            {
               csTipoPregunta p = new csTipoPregunta(); 
        return p.InsertarTipoPregunta(Tipo1,Tipo2,Tipo3,Tipo4);
    }
    
     @WebMethod(operationName = "ActualizarTipoPregunta")
    public int ActualizarTipoPregunta(@WebParam(name="Tipo1")String Tipo1, 
         @WebParam(name="Tipo2")String Tipo2, @WebParam(name="Tipo3" )String Tipo3, @WebParam(name="Tipo4" )String Tipo4,
         @WebParam(name = "IdTipo") int IdTipo)
            {
                csTipoPregunta p = new csTipoPregunta(); 
       return p.ActualizarTipoPregunta(Tipo1,Tipo2,Tipo3,Tipo4,IdTipo);
    }
    
     @WebMethod(operationName = "EliminarTipoPregunta")
    public int EliminarTipoPregunta(@WebParam(name = "IdTipo") int IdTipo)
            {
                csTipoPregunta p = new csTipoPregunta(); 
        return p.EliminarTipoPregunta(IdTipo);
    }
    
    @WebMethod(operationName = "ListarTipoPregunta")
    public ArrayList<TipoPregunta>ListarTipoPregunta()
            {
                csTipoPregunta p = new csTipoPregunta(); 
        return p.ListarTipoPregunta();
    }
    
    @WebMethod(operationName = "ListarTipoPreguntaPorId")
    public TipoPregunta ListarTipoPreguntaPorId(@WebParam(name = "IdTipo") int IdTipo)
            {
                csTipoPregunta p = new csTipoPregunta(); 
        return p.ListarTipoPreguntaPorId(IdTipo);
    }
}

