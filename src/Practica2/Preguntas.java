package Practica2;

public class Preguntas {
    private int idPregunta;
    private String nombrePregunta;
    private int desencadenanteIqz;
    private int DesencadenanteDrch;
    private String respuestaIzq;
    private String respuestaDrch;

    public Preguntas(int idPregunta, String nombrePregunta, int desencadenanteIqz, int desencadenanteDrch, String respuestaIzq, String respuestaDrch) {
        this.idPregunta = idPregunta;
        this.nombrePregunta = nombrePregunta;
        this.desencadenanteIqz = desencadenanteIqz;
        this.DesencadenanteDrch = desencadenanteDrch;
        this.respuestaIzq = respuestaIzq;
        this.respuestaDrch = respuestaDrch;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getNombrePregunta() {
        return nombrePregunta;
    }

    public void setNombrePregunta(String nombrePregunta) {
        this.nombrePregunta = nombrePregunta;
    }

    public int getDesencadenanteIqz() {
        return desencadenanteIqz;
    }

    public void setDesencadenanteIqz(int desencadenanteIqz) {
        this.desencadenanteIqz = desencadenanteIqz;
    }

    public int getDesencadenanteDrch() {
        return DesencadenanteDrch;
    }

    public void setDesencadenanteDrch(int desencadenanteDrch) {
        DesencadenanteDrch = desencadenanteDrch;
    }

    public String getRespuestaIzq() {
        return respuestaIzq;
    }

    public void setRespuestaIzq(String respuestaIzq) {
        respuestaIzq = respuestaIzq;
    }

    public String getRespuestaDrch() {
        return respuestaDrch;
    }

    public void setRespuestaDrch(String respuestaDrch) {
        respuestaDrch = respuestaDrch;
    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "idPregunta=" + idPregunta +
                ", nombrePregunta='" + nombrePregunta + '\'' +
                ", desencadenanteIqz=" + desencadenanteIqz +
                ", DesencadenanteDrch=" + DesencadenanteDrch +
                ", respuestaIzq='" + respuestaIzq + '\'' +
                ", respuestaDrch='" + respuestaDrch + '\'' +
                '}';
    }
}