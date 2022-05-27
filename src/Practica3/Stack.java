package Practica3;

public class Stack {
	private int size = 0;
	private Node1 last;
	
	public Stack() {}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node1 getLast() {
		return last;
	}

	public void setLast(Node1 last) {
		this.last = last;
	}
	
	public boolean isEmpty() {
		if(size == 0) return true;
		return false;
	}
	
	public boolean push(Node1 node) {
		try {
			if(isEmpty()) last = node;
			else {
				node.setNext(last);
				last = node;
			} size++; return true;
		} catch(Exception e) { System.out.println(e); }
		return false;
	}
	
	public Node1 pop() {
		try {
			if(!isEmpty()) { 
				Node1 p = last;
				last = last.getNext();
				size--;
				return p;
			}
		} catch(Exception e) { System.out.println(e); } 
		return null;
	}
	
	public void show() {
		Node1 p = last;
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "] -> Nombre: "+ p.getPasajeros().getNombre() +
					", DNI: " + p.getPasajeros().getDNI() +
					", "+p.getPasajeros().getIdAvion());
			p = p.getNext();
		}
	}
}