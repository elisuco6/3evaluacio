package Practica2;

public class Arma {
    private int idarma;
    private int dañoArma;
    private String nombreArma;

    public Arma(int idarma, int dañoArma, String nombreArma) {
        this.idarma = idarma;
        this.dañoArma = dañoArma;
        this.nombreArma = nombreArma;
    }

    public int getIdarma() {
        return idarma;
    }

    public void setIdarma(int idarma) {
        this.idarma = idarma;
    }

    public int getDañoArma() {
        return dañoArma;
    }

    public void setDañoArma(int dañoArma) {
        this.dañoArma = dañoArma;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    @Override
    public String toString() {
        return "ID: " + idarma + ", DAÑO: " + dañoArma +", NOMBRE: "+ nombreArma;
    }
}
