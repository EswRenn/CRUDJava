package Modelo;

public class Preguntas {
        private int IdPreguntas, IdTipo, IdPonderacion;
        private String Pregunta1, Pregunta2, Pregunta3, Pregunta4;
    
    public Preguntas (int IdTipo, int IdPonderacion,String Pregunta1, String Pregunta2, String Pregunta3, String Pregunta4, int IdPreguntas)
    {
        this.Pregunta1=Pregunta1;
        this.Pregunta2=Pregunta2;
        this.Pregunta3=Pregunta3;
        this.Pregunta4=Pregunta4;
    }

    public int getIdPreguntas() {
        return IdPreguntas;
    }

    public void setIdPreguntas(int IdPreguntas) {
        this.IdPreguntas = IdPreguntas;
    }

    public int getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(int IdTipo) {
        this.IdTipo = IdTipo;
    }

    public int getIdPonderacion() {
        return IdPonderacion;
    }

    public void setIdPonderacion(int IdPonderacion) {
        this.IdPonderacion = IdPonderacion;
    }

    public String getPregunta1() {
        return Pregunta1;
    }

    public void setPregunta1(String Pregunta1) {
        this.Pregunta1 = Pregunta1;
    }

    public String getPregunta2() {
        return Pregunta2;
    }

    public void setPregunta2(String Pregunta2) {
        this.Pregunta2 = Pregunta2;
    }

    public String getPregunta3() {
        return Pregunta3;
    }

    public void setPregunta3(String Pregunta3) {
        this.Pregunta3 = Pregunta3;
    }

    public String getPregunta4() {
        return Pregunta4;
    }

    public void setPregunta4(String Pregunta4) {
        this.Pregunta4 = Pregunta4;
    }

 
}
