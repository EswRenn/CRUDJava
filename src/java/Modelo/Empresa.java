package Modelo;

public class Empresa {
        private String Nombre, Direccion, Telefono, Email;
    private int IdEmpresa;
    
    public Empresa (String Nombre, String Direccion, String Telefono, String Email,int IdEmpresa)
    {
    this.Nombre=Nombre;
    this.Direccion=Direccion;
    this.Telefono=Telefono;
    this.Email=Email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }
    
}
