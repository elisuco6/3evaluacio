package repasoGeneral2;

public class LinkedList {
	
	private Node first;
	private int size;
	
	public LinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public LinkedList(Node first) {
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
			if (size==0) {
				first = node;
			} else {
				Node p = first;
				for(int i=1; i<size; i++) {
					p = p.getNext();
				}p.setNext(node);
			} size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		if(position==0) {
			node.setNext(first);
			first = node;
		} else if(position == (size-1)) {
			return add(node);
		} else {
			Node p = first;
			for(int i=1; i<position; i++) {
				p = p.getNext();
			}
			node.setNext(p.getNext());
			p.setNext(node);
			size++;
		}
		return true;
	}
	
	public boolean delete(int position) {
		if(position==0) {
			first = first.getNext();
			size--;
		} else if(position == (size)) {
			Node p = first;
			for(int i=1; i<size; i++) {
				p = p.getNext();
			}
			p.setNext(null);
			size--;
		} else {
			Node p = first;
			for(int i=1; i<position; i++) {
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
			size--;
		}
		return true;
	}
	
	public void addComplex(Node node) {
		Node p = first;
		for (int i=0; i<size; i++) {
			if (node.getContent() == p.getContent()) {
				delete(i);
				break;
			}
			p = p.getNext();
		}
		add(node);
	}
	
	public void show() {
		Node p = first;
		for (int i=0; i<size; i++) {
			System.out.println("[" + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}

}
