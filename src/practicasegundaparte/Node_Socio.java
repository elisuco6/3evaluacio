package practicasegundaparte;

public class Node_Socio {
    private Socio socio;
    private Node_Socio next;

    public Node_Socio(Socio socio) {
        super();
        this.socio = socio;
    }

    public Node_Socio() {

    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Node_Socio getNext() {
        return next;
    }

    public void setNext(Node_Socio next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Socio=" + socio;
    }


}
