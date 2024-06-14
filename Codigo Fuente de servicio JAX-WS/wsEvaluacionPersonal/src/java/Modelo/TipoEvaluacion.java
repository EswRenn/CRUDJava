package Modelo;

public class TipoEvaluacion {
        private int IdEvaluacion,IdPregunta;
        private String Evaluacion1, Evaluacion2;
    
    public TipoEvaluacion (int IdPregunta, String Evaluacion1, String Evaluacion2, int IdEvaluacion)
    {
        this.Evaluacion1=Evaluacion1;
        this.Evaluacion2=Evaluacion2;
    }

    public int getIdEvaluacion() {
        return IdEvaluacion;
    }

    public void setIdEvaluacion(int IdEvaluacion) {
        this.IdEvaluacion = IdEvaluacion;
    }

    public int getIdPregunta() {
        return IdPregunta;
    }

    public void setIdPregunta(int IdPregunta) {
        this.IdPregunta = IdPregunta;
    }

    public String getEvaluacion1() {
        return Evaluacion1;
    }

    public void setEvaluacion1(String Evaluacion1) {
        this.Evaluacion1 = Evaluacion1;
    }

    public String getEvaluacion2() {
        return Evaluacion2;
    }

    public void setEvaluacion2(String Evaluacion2) {
        this.Evaluacion2 = Evaluacion2;
    }

  
}
