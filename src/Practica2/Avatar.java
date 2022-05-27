package Practica2;

public class Avatar {
    private int idAvatar;
    private String nombreAvatar;
    private int vidaAvatar;

    public Avatar(int idAvatar, String nombreAvatar, int vidaAvatar) {
        this.idAvatar = idAvatar;
        this.nombreAvatar = nombreAvatar;
        this.vidaAvatar = vidaAvatar;
    }

    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getNombreAvatar() {
        return nombreAvatar;
    }

    public void setNombreAvatar(String nombreAvatar) {
        this.nombreAvatar = nombreAvatar;
    }

    public int getVidaAvatar() {
        return vidaAvatar;
    }

    public void setVidaAvatar(int vidaAvatar) {
        this.vidaAvatar = vidaAvatar;
    }

    @Override
    public String toString() {
        return "ID: " + idAvatar + ", NOMBRE: " + nombreAvatar + ", VIDA: " + vidaAvatar;
    }
}
