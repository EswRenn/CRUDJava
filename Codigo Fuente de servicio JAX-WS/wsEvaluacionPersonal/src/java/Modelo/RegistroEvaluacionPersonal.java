package Modelo;

public class RegistroEvaluacionPersonal {
        private int IdEvaluacion, IdEmpleado, IdRegistro;
        private String Respuesta1, Respuesta2, Respuesta3, Respuesta4;
    
    public RegistroEvaluacionPersonal ( int IdEmpleado, int IdEvaluacion,String Respuesta1, String Respuesta2, String Respuesta3, String Respuesta4, int IdRegistro)
    {
        this.Respuesta1=Respuesta1;
        this.Respuesta2=Respuesta2;
        this.Respuesta3=Respuesta3;
        this.Respuesta4=Respuesta4;
    }

    public int getIdEvaluacion() {
        return IdEvaluacion;
    }

    public void setIdEvaluacion(int IdEvaluacion) {
        this.IdEvaluacion = IdEvaluacion;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdRegistro() {
        return IdRegistro;
    }

    public void setIdRegistro(int IdRegistro) {
        this.IdRegistro = IdRegistro;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(String Respuesta1) {
        this.Respuesta1 = Respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String Respuesta2) {
        this.Respuesta2 = Respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(String Respuesta3) {
        this.Respuesta3 = Respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(String Respuesta4) {
        this.Respuesta4 = Respuesta4;
    }
    
}
