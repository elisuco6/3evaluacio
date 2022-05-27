package Practica3;

public class Heap {
	private Node1 first;
	private Node1 last;
	private int size = 0;
	
	public Heap() {
		this.size = 0;
	}
	
	public Heap(Node1 first) {
		this.first = first;
		this.size = 1;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}else {
			return false;
		}
	}

	public Node1 getFirst() {
		return first;
	}

	public void setFirst(Node1 first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean push(Node1 node) {
		try {
			if (isEmpty()) {
				first = node;
				last = node;
			}else {
				last.setNext(node);
				last = node;
			}
			size++;
			return true;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Node1 pop() {
		try {
			if (isEmpty()) {
				return null;
			}else {
				Node1 p = first;
				first = first.getNext();
				size--;
				return p;
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public void show() {
		Node1 p = first;
		for (int i = 0; i <= size - 1; i++) {
			System.out.println("[" + i + "] -> Nombre: "+ p.getPasajeros().getNombre() +
											", DNI: " + p.getPasajeros().getDNI() +
											", "+p.getPasajeros().getIdAvion());
			p = p.getNext();
		}
	}
}