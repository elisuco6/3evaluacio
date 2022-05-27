package Practica2;

public class Poder {
    private int idPoder;
    private String nombrePoder;
    private int puntosPoder;

    public Poder(int idPoder, String nombrePoder, int puntosPoder) {
        this.idPoder = idPoder;
        this.nombrePoder = nombrePoder;
        this.puntosPoder = puntosPoder;
    }

    public int getIdPoder() {
        return idPoder;
    }

    public void setIdPoder(int idPoder) {
        this.idPoder = idPoder;
    }

    public String getNombrePoder() {
        return nombrePoder;
    }

    public void setNombrePoder(String nombrePoder) {
        this.nombrePoder = nombrePoder;
    }

    public int getPuntosPoder() {
        return puntosPoder;
    }

    public void setPuntosPoder(int puntosPoder) {
        this.puntosPoder = puntosPoder;
    }

    @Override
    public String toString() {
        return "Poder " +
                "ID: " + idPoder + ", NOMBRE: " + nombrePoder + ", POTENCIA: " + puntosPoder;
    }
}
