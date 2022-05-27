package practicasegundaparte;

/**
 * Pre: ---
 * Post: Es una simplelinkedlist modificada para poder alamacenar los nodos de club
 */
public class almacenar {
    private Node_Club first;
    private int size;

    public almacenar() {
        this.first = null;
        this.size = 0;
    }

    public almacenar(Node_Club first) {
        this.first = first;
        this.size = 1;
    }

    public Node_Club getFirst() {
        return first;
    }

    public void setFirst(Node_Club first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean add(Node_Club node) {
        try {
            if (size == 0) {
                first = node;
            } else {
                Node_Club p = first;
                for (int x = 1; x < size; x++) {
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

    public boolean add(int position, Node_Club node) {
        try {
            if (position == 0) {
                node.setNext(first);
                first = node;
            } else if (position == size - 1) {
                Node_Club p = first;
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

    public boolean delete(int position, Node_Club node) {
        try {
            if (position == 0) {
                node.setNext(first);
                first = node;
            } else {
                Node_Club p = first;
                for (int i = 0; i < position - 1; i++) {
                    p = p.getNext();
                }
                node.setNext(p.getNext());
                p.setNext(node);
            }
            size--;
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Node_Club get(int position) {
        try {
            if (position >= 0 || position < size) {
                Node_Club p = first;
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

    // Pasaremos dos club y uniremos los socios de uno a otro.
    public void unirclub(Club uno, Club dos) {
        for (int x = 0; x < dos.getSocio().getSize(); x++) {
            uno.getSocio().add(dos.getSocio().get(x));
        }
    }

    public void show() {
        Node_Club p = first;
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + p.getClub());
            p = p.getNext();
        }
    }
}
