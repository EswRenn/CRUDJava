package Modelo;

public class CargaMasiva  {
    private int IdCarga,IdRegistro,IdEmpleado, IdPuesto;
    
    public CargaMasiva (int IdRegistro, int IdEmpleado, int IdPuesto, int IdCarga)
    {
    }

    public int getIdCarga() {
        return IdCarga;
    }

    public void setIdCarga(int IdCarga) {
        this.IdCarga = IdCarga;
    }

    public int getIdRegistro() {
        return IdRegistro;
    }

    public void setIdRegistro(int IdRegistro) {
        this.IdRegistro = IdRegistro;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdPuesto() {
        return IdPuesto;
    }

    public void setIdPuesto(int IdPuesto) {
        this.IdPuesto = IdPuesto;
    }


}
