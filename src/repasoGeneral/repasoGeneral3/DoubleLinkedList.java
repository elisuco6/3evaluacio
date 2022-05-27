package repasoGeneral3;

import java.util.ArrayList;

public class DoubleLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	public DoubleLinkedList(Node first) {
		this.first = first;
		this.size = 1;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		if (size>0) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean add(Node node) {
		try {
			if (size==0) {
				first = node;
				last = node;
				first.setNext(null);
				first.setPrevious(null);
				last.setNext(null);
				first.setPrevious(null);
			} else {
				Node p = last;
				p.setNext(node);
				last = node;
				last.setPrevious(p);
			} size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		try {
			if(position==0) {
				Node p = first;
				p.setPrevious(node);
				first = node;
				first.setNext(p);
				size++;
			} else if(position == (size-1)) {
				return add(node);
			} else {
				Node p = first;
				for(int i=1; i<position; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.getNext().setPrevious(node);
				p.setNext(node);
				node.setPrevious(p);
				size++;
			}
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	public void addSome(ArrayList<Node> lista) {
		for (int i=0; i<lista.size(); i++) {
			add(lista.get(i));
		}
	}
	
	public boolean delete(int position) {
		if (position==0) {
			first = first.getNext();
			first.setPrevious(null);
			size--;
		} else if (position==size) {
			last = last.getPrevious();
			last.setNext(null);
			size--;
		} else {
			Node p = first;
			for (int i=1; i<position; i++) {
				p = p.getNext();
			}
			p.getNext().getNext().setPrevious(p);
			p.setNext(p.getNext().getNext());
			size--;
		}
		return true;
	}
	
	public void deleteSome(int[] position) {
		for(int i=0; i<position.length; i++) {
			delete(position[i]);
		}
	}
	
	public void show() {
		Node p = first;
		for (int i=0; i<size; i++) {
			System.out.println("[" + i + "] Contenido-> " + p.getContent());
			p = p.getNext();
		}
	}

}
