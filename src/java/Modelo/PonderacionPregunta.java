package Modelo;

public class PonderacionPregunta {
        private int IdPonderacion, Punteo1, Punteo2, Punteo3, Punteo4;
    
    public PonderacionPregunta (int Tipo1, int  Tipo2, int Tipo3,int Tipo4, int IdTipo)
    {
    }

    public int getIdPonderacion() {
        return IdPonderacion;
    }

    public void setIdPonderacion(int IdPonderacion) {
        this.IdPonderacion = IdPonderacion;
    }

    public int getPunteo1() {
        return Punteo1;
    }

    public void setPunteo1(int Punteo1) {
        this.Punteo1 = Punteo1;
    }

    public int getPunteo2() {
        return Punteo2;
    }

    public void setPunteo2(int Punteo2) {
        this.Punteo2 = Punteo2;
    }

    public int getPunteo3() {
        return Punteo3;
    }

    public void setPunteo3(int Punteo3) {
        this.Punteo3 = Punteo3;
    }

    public int getPunteo4() {
        return Punteo4;
    }

    public void setPunteo4(int Punteo4) {
        this.Punteo4 = Punteo4;
    }


    
}
