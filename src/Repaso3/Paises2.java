package Repaso3;

public class Paises2 implements Comparable{
    public char letra;
    public int contador;

    public char getLetra() {
        return letra;
    }
    public void setLetra(char letra) {
        this.letra = letra;
    }
    public int getContador() {
        return contador;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }
    public Paises2(char letra, int contador) {
        super();
        this.letra = letra;
        this.contador = contador;
    }
    public Paises2() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compareTo(Object o) {
        Paises2 p = (Paises2) o;
        if(p.getContador() < contador) {
            return 1;
        }
        else if (p.getContador() == contador){
            return 0;
        }
        else {
            return -1;
        }
    }
}
