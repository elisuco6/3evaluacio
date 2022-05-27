package recursividad2;

public class ListaDoblementeEnlazada {
	private int size;
	private Node first;
	
	public ListaDoblementeEnlazada() {
		size = 0;
		first = null;
	}
	
	/**
	 * Pre: node != null
	 * Post: inserta [node] en la posición [index] de la lista
	 * 		doblemente enlazada. Si [index] no está dentro del rango
	 * 		válido, se le notifica al usuario y no se realiza la 
	 * 		inserción.
	 */
	public void add(Node node, int index) {
		if(0 <= index && size >= index) {
			if(isEmpty()) {
				/*
				 * Si la lista está vacía simplemente lo ponemos 
				 * como primer nodo. 
				 */
				first = node;
			} else {
				/*
				 * Si la lista no esta vacía diferenciamos si queremos
				 * situarlo en la primera posición o en el resto.
				 */
				if(index == 0) {
					/*
					 * Si queremos ponerlo en primera posición, primero
					 * le indicamos a [node] que su siguiente es el nodo
					 * que ahora mismo está primero, después le indicamos a 
					 * este nodo que ahora su anterior va a ser [node], y por 
					 * último apuntamos a [node] desde first.
					 */
					first.setPrevious(node);
					node.setNext(first);
					first = node;
				} else {
					/*
					 * Si queremos insertar en cualquier otra posición vamos
					 * iterando hasta llegar al nodo anterior a la posición
					 * en la que queremos añadir [node]
					 */
					Node pointer = first;
					for(int i = 1; i <= index; i++) {
						if(i == index) {
							/*
							 * Una vez tenemos el nodo anterior, le indicamos a [node]
							 * que su anterior va a ser el nodo al que estamos apuntando
							 * ahora mismo desde [pointer]
							 */
							node.setPrevious(pointer);
							/*
							 * Le decimos a [node] que su siguiente, va a ser el nodo siguiente
							 * a [pointer]. Porque vamos a situarlo justo en medio.
							 */
							node.setNext(pointer.getNext());
							/*
							 * Si el el nodo anterior, tiene valor null en nodoSiguiente (es decir, a ningun nodo)
							 * significa que es el último, y que [node] lo queremos añadir en la ultima posicion.
							 * En caso de no añadirlo en la últimoa posición, debemos decirle al nodo que
							 * va a ir despues de [node], que su anterior ahora cambia, y su anterior
							 * tiene que ser [node].
							 */
							if(pointer.getNext() != null) {
								pointer.getNext().setPrevious(node);
							}
							/*
							 * Indicamos al nodo anterior que ahora su siguiente es [node]
							 */
							pointer.setNext(node);
						} pointer = pointer.getNext();
					}
				}
			} size++; // Aumentamos en uno el tamaño de la lista
		} else {
			System.out.println("Please index between [0 - " + size + "] included.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: devuelve el nodo situado en la posición [index] en la lista
	 * 		doblemente enlazada. En caso de que el [indice] esté fuera de 
	 * 		rango, devuelve null.
	 */
	public Node extract(int index) {
		if(0 <= index && size > index) {
			/*
			 * Si queremos obtener el nodo en la primera posición, lo que 
			 * hacemos es indicar que puntero al primero debe apuntar
			 * al siguiente nodo del actual. Además, tenemos que indicarle
			 * a este nuevo primer nodo que no tiene anterior, ya que
			 * él es el primero de la lista.
			 */
			if(index == 0) {
				Node node = first;
				first = first.getNext();
				first.setPrevious(null);
				size--;
				return node;
			} else {
				/*
				 * En cualquier otro caso iteramos hasta llegar al nodo anterior
				 * al que queremos extraer.
				 */
				Node pointer = first;
				for(int i = 1; i <= index; i++) {
					if(i == index) {
						/* 
						 * Una vez hemos llegado al nodo anterior al que queremos extraer,
						 * almacenamos el nodo a devolver (el siguiente) para meterlo en el return
						 * más tarde.
						 */
						Node node = pointer.getNext();
						/*
						 * Después le decimos al nodo anterior que su siguiente tiene que 
						 * ser el siguiente nodo del siguiente.
						 */
						pointer.setNext(pointer.getNext().getNext());
						/*
						 * Si le hemos asignado un valor null, significa que es el último
						 * nodo el que queremos extraer, por lo tanto no haríamos nada. En caso 
						 * contrario, tenemos que decirle al nodo siguiente al extraído, que su
						 * nodo anterior ha cambiado y que ahora es el anterior al nodo anterior.
						 */
						if(pointer.getNext() != null) {
							pointer.getNext().setPrevious(pointer);
						}
						size--; // Restamos uno al número de nodos que tiene la lista
						return node;
					} pointer = pointer.getNext();
				}
			}
		} return null;
	}
	
	/**
	 * Pre: 
	 * Post: Devuelte true sí y solo sí la lista doblemente
	 * 		enlazada está vacía. Devuelve false en caso contrario.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: muestra por pantalla la posición de todos los nodos de la 
	 * 		lista doblemente enlazada, junto a su contenido. 
	 * 		Si está vacía, indica con un mensaje que
	 * 		la cola no tiene contenido.
	 */
	public void show() {
		if(!isEmpty()) {
			Node node = first;
			for(int i = 0; i < size; i++) {
				System.out.println("[" + i + "] -> " + node.toString());
				node = node.getNext();
			}
		} else {
			System.out.println("¡Is empty!");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: devuelve true sí y solo sí, el número pasado como parámetro 
	 * 		se puede obtener de la suma de dos de los nodos de la lista.
	 */
	public boolean sePuedeObtener(int n) {
		/*
		 * Hacemos uso de los bucles anidados
		 */
		for(int i = 0; i < size; i++) {
			Node pointer = getNode(i);
			for(int j = i + 1; j < size; j++) {
				Node secondPointer = getNode(j);
				if(pointer.getContent() + secondPointer.getContent() == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Pre: ---
	 * Post: devuelve el nodo situado en la posicion [index] de la lista
	 * 		doblemente enlazada. Si no existe ningún nodo, devuelve [null]
	 */
	private Node getNode(int index) {
		if(index == 0) {
			return first;
		} else {
			Node pointer = first;
			for(int i = 1; i <= size; i++) {
				pointer = pointer.getNext();
				if(i == index) {
					return pointer;
				}
			}
		} return null;
	}
}
