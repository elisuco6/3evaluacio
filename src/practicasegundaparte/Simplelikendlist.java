package practicasegundaparte;

/**
 * Pre: ---
 * Post: ListaEnlazadaSimple para los socios
 */
public class Simplelikendlist {
	private Node_Socio first;
	private int size;
	public Simplelikendlist() {
		this.first = null;
		this.size = 0;
	}
	
	public Simplelikendlist(Node_Socio first) {
		this.first = first;
		this.size = 1;
	}

	public Node_Socio getFirst() {
		return first;
	}

	public void setFirst(Node_Socio first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean add(Node_Socio node) {
		try {
			if(size==0) {
				first = node;
			} else {
				Node_Socio p = first;
				int posicion = 0;
				for(;posicion < size; posicion++) {
					if(p.getSocio().getNombre().compareTo(node.getSocio().getNombre()) > 0) {
						break;
					}
					if(posicion<size -1) {
						p = p.getNext();
					}
					
				}
				if(posicion==size) {
					node.setNext(p.getNext());
					p.setNext(node);
				}else {
					add(posicion, node);
					size--;
				}
			}
			size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node_Socio node) {
		try {
			if(position==0) {
				node.setNext(first);
				first = node;
			} else if(position == size-1){
				Node_Socio p = first;
				for(int i=1; i < position; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.setNext(node);
			} size++; return true;
		  } catch(Exception e) {
				System.out.println(e.toString());
				return false;
			}
	}
	
	public boolean delete(int position) {
		try {
			if(position==0) {
				if(size ==1) {
					first = null;
				}else {
					first = first.getNext();
				}
				
			} else {
				Node_Socio p = first;
				for(int i=0; i < position -1; i++) {
					p = p.getNext();
				}
				p.setNext(p.getNext().getNext());
			} size--; return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Node_Socio get(int position) {
		try {
			if(position>=0 || position <size) {
				Node_Socio p = first;
				for(int i =1; i<=position; i++) {
					p = p.getNext();
				}return p;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}return null;
	}
	
	public boolean buscarsocio(Socio socio) {
		for(int i=0; i<size -1; i++){
			if(this.get(i).getSocio().getNombre().equals(socio.getNombre()) 
					&& this.get(i).getSocio().getPrimerapellido().equals(socio.getPrimerapellido())
					&& this.get(i).getSocio().getSegundoapellido().equals(socio.getSegundoapellido())
					&&this.get(i).getSocio().getIncorporacion()==(socio.getIncorporacion())){
				return true;
				
			}
		}
		return false;
	}
	
	public void show() {
		Node_Socio p= first;
		for(int  i=0; i<size; i++) {
			System.out.println(i + " -> " + p.getSocio());
			p = p.getNext();
		}
	}
}
