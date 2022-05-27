package practicasegundaparte;

public class Node_Club {
    private Club club;
    private Node_Club next;

    public Node_Club(Club club) {
        this.club = club;
    }

    public Node_Club() {

    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Node_Club getNext() {
        return next;
    }

    public void setNext(Node_Club next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Club=" + club;
    }


}
