package wsServicios;

import Modelo.Empresa;
import Modelo.csEmpresa;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvEmpresa")
public class srvEmpresa {

    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, 
            @WebParam(name = "telefono") int telefono, @WebParam(name = "email") String email)
    {
        csEmpresa e = new csEmpresa();
        return e.InsertarEmpresa(nombre, direccion, telefono, email);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizar(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, 
            @WebParam(name = "telefono") String telefono, @WebParam(name = "email") String email,
            @WebParam(name = "idEmpresa") int idEmpresa)
    {
        csEmpresa e = new csEmpresa();
        return e.ActualizarEmpresa(nombre, direccion, telefono, email, idEmpresa);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idEmpresa") int idEmpresa )
    {
        csEmpresa e = new csEmpresa();
        return e.EliminarEmpresa(idEmpresa);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList<Empresa> listar()
    {
        csEmpresa e = new csEmpresa();
        return e.ListarEmpresa();
    }
    
    @WebMethod(operationName = "listarporID")
    public Empresa listarPorID(@WebParam(name = "idEmpresa") int idEmpresa)
    {
        csEmpresa e = new csEmpresa();
        return e.ListarEmpresaPorId(idEmpresa);
    }
}
