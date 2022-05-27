package ListaEnlazadaSimple;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList l = new SimpleLinkedList();
        Node n1 = new Node(20,null);
        l.add(n1);
        l.show();
        System.out.println("-------------------");
        Node n2 = new Node(15,null);
        l.add(n2);
        l.show();
    }
}