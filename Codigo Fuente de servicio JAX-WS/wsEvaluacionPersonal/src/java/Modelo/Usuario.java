package Modelo;

public class Usuario {
    private int IdUsuario,IdEmpleado;
    private String Usuario,Nombre;
    
    public Usuario(int IdUsuario, int IdEmpleado, String Usuario, String Nombre)
    {
    this.IdUsuario= IdUsuario;
    this.IdEmpleado= IdEmpleado;
    this.Usuario=Usuario;
    this.Nombre=Nombre;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }   
}

