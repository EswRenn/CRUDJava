package wsServicios;

import Modelo.csUsuario;
import Modelo.Usuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "srvUsuario")
public class srvUsuario {

    @WebMethod(operationName = "autenticar")
    public Usuario autenticar(@WebParam(name = "Usuario") String Usuario,@WebParam(name = "Contraseña") String Contraseña) 
    {
       csUsuario u= new csUsuario();
       return u.autenticar(Usuario,Contraseña);
    }
}

