package Modelo;

public class TipoPregunta {
        private int IdTipo;
        private String Tipo1, Tipo2, Tipo3, Tipo4;
    
    public TipoPregunta (String Tipo1, String Tipo2, String Tipo3, String Tipo4, int IdTipo)
    {
        this.Tipo1=Tipo1;
        this.Tipo2=Tipo2;
        this.Tipo3=Tipo3;
        this.Tipo4=Tipo4;
    }

    public int getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(int IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getTipo1() {
        return Tipo1;
    }

    public void setTipo1(String Tipo1) {
        this.Tipo1 = Tipo1;
    }

    public String getTipo2() {
        return Tipo2;
    }

    public void setTipo2(String Tipo2) {
        this.Tipo2 = Tipo2;
    }

    public String getTipo3() {
        return Tipo3;
    }

    public void setTipo3(String Tipo3) {
        this.Tipo3 = Tipo3;
    }

    public String getTipo4() {
        return Tipo4;
    }

    public void setTipo4(String Tipo4) {
        this.Tipo4 = Tipo4;
    }
    
}
