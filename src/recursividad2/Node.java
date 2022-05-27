package recursividad2;

public class Node {
	private int content;
	private Node previous;
	private Node next;
	
	public Node(int content, Node previous, Node next) {
		this.content = content;
		this.previous = previous;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		String respond = "Node: " + content + " ";
		if(previous != null && next != null) {
			return respond + "- Next = " + next.getContent() + " - Previous: " + previous.getContent();
		} else if(previous != null && next == null) {
			return respond + "- Next = null - Previous: " + previous.getContent();
		} else if(previous == null && next != null) {
			return respond + "- Next = " + next.getContent() + " - Previous: null";
		} else {
			return respond + "- Next = null - Previous: null";
		}
	}
	
}
