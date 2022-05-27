package recursividad2;

public class Ejercicio3 {
	public static void main(String[] args) {
		ListaDoblementeEnlazada l = new ListaDoblementeEnlazada();
		l.add(new Node(3, null, null), 0);
		l.add(new Node(8, null, null), 1);
		l.add(new Node(1, null, null), 2);
		l.add(new Node(4, null, null), 3);
		l.add(new Node(1, null, null), 4);
		l.add(new Node(2, null, null), 5);
		l.add(new Node(10, null, null), 6);
		System.out.println("¿Encuentra el 12? -> " + l.sePuedeObtener(12));
		System.out.println("¿Encuentra el 11? -> " + l.sePuedeObtener(11));
		System.out.println("¿Encuentra el 5? -> " + l.sePuedeObtener(5));
		System.out.println("¿Encuentra el 4? -> " + l.sePuedeObtener(4));
		System.out.println("¿Encuentra el 20? -> " + l.sePuedeObtener(20));
		System.out.println("¿Encuentra el 9? -> " + l.sePuedeObtener(9));
	}
}
