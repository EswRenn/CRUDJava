package Modelo;

public class Puesto {
    private String Nombre, Caracteristicas, Sueldo;
    private int IdPuesto;
    
    public Puesto (String Nombre, String Caracteristicas, String Sueldo, int IdPuesto)
    {
    this.Nombre=Nombre;
    this.Caracteristicas=Caracteristicas;
    this.Sueldo=Sueldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public String getSueldo() {
        return Sueldo;
    }

    public void setSueldo(String Sueldo) {
        this.Sueldo = Sueldo;
    }

    public int getIdPuesto() {
        return IdPuesto;
    }

    public void setIdPuesto(int IdPuesto) {
        this.IdPuesto = IdPuesto;
    }
    
}
