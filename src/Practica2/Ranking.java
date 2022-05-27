package Practica2;

public class Ranking {
    private int idRanking;
    private String nombreAvatar;
    private int puntuacionFinal;

    public Ranking(int idRanking, String nombreAvatar, int puntuacionFinal) {
        this.idRanking = idRanking;
        this.nombreAvatar = nombreAvatar;
        this.puntuacionFinal = puntuacionFinal;
    }

    public int getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }

    public String getNombreAvatar() {
        return nombreAvatar;
    }

    public void setNombreAvatar(String nombreAvatar) {
        this.nombreAvatar = nombreAvatar;
    }

    public int getPuntuacionFinal() {
        return puntuacionFinal;
    }

    public void setPuntuacionFinal(int puntuacionFinal) {
        this.puntuacionFinal = puntuacionFinal;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "idRanking=" + idRanking +
                ", nombreAvatar='" + nombreAvatar + '\'' +
                ", puntuacionFinal=" + puntuacionFinal +
                '}';
    }
}
