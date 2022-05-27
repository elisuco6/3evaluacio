package Practica3;

/**
 * Pre: ---
 * Post: nodo de tipo pasajero con sus propios atributos
 */
public class Node1 {
    private Pasajeros pasajeros;
    private Practica3.Node1 next;

    //constructor
    public Node1(){}
    //segundo constructor
    public Node1(Pasajeros pasajeros, Practica3.Node1 next) {
        this.pasajeros = pasajeros;
        this.next = next;
    }

    //getters y setters
    public Pasajeros getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajeros pasajeros) {
        this.pasajeros = pasajeros;
    }
    //puntero
    public Practica3.Node1 getNext() {
        return next;
    }

    public void setNext(Practica3.Node1 next) {
        this.next = next;
    }

    //Mostrar
    @Override
    public String toString() {
        return "Avion = " + pasajeros;
    }
}