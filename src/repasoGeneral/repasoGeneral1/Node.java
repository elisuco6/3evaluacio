package repasoGeneral.repasoGeneral1;

public class Node {
	
	private int content;
	private Node next;
	private Node previous;
	
	public Node (int content, Node next, Node previous) {
		this.content = content;
		this.next = next;
		this.previous = previous;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}
	
}
