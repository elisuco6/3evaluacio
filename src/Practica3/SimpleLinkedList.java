package Practica3;

public class SimpleLinkedList {
    private Node first;
    private int size;

    public SimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public SimpleLinkedList(Node first) {
        this.first = first;
        this.size = 1;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean add(Node node) {
        try {
            if (size == 0) {
                first = node;
            } else {
                Node p = first;
                for (int i = 1; i < size; i++) {
                    p = p.getNext();
                }
                p.setNext(node);
            }
            size++;
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean add(int position, Node node) {
        try {
            if (position == 0) {
                node.setNext(first);
                first = node;
            } else if (position == size) {
                return add(node);
            } else {
                Node p = first;
                for (int i = 1; i < position; i++) {
                    p = p.getNext();
                }
                node.setNext(p.getNext());
                p.setNext(node);
            }
            size++;
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Node get(int position) {
        try {
            if (position >= 0 && position < size) {
                Node p = first;
                for (int i = 1; i <= position; i++) {
                    p = p.getNext();
                }
                return p;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public Node getIdAvion(int id) {
        try {
            Node p = first;
            for (int i = 1; i <= size; i++) {
                if (p.getAvion().getId() == id){
                    return p;
                } else {
                    p = p.getNext();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }


    public void show() {
        Node p = first;
        for (int i = 0; i < size; i++) {
            System.out.println("[ " + i + "] -> " + p.getAvion().toString());
            p.getAvion().mostrarpasajeros();
            p = p.getNext();
        }
    }
}