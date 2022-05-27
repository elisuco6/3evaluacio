package Practica3;

/**
 * Pre: ---
 * Post: Nodo de tipo avion con sus propios atributos
 */
public class Node {
    private Avion avion;
    private Node next;

    public Node(Avion avion, Node next) {
        this.avion = avion;
        this.next = next;
    }
    //constructor
    public Node(){}
    //getters y setters
    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    //puntero
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //Mostrar valores
    @Override
    public String toString() {
        return "Avion = " + avion;
    }
}