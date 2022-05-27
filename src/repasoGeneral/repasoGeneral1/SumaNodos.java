package repasoGeneral.repasoGeneral1;

public class SumaNodos {
	
	public static void main(String[] args) {
		Node n1 = new Node(3, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, null, null);
		Node n4 = new Node(10, null, null);
		Node n5 = new Node(2, null, null);
		
		DoubleLinkedList d = new DoubleLinkedList();
		d.add(n1);
		d.add(n2);
		d.add(n3);
		d.add(n4);
		d.add(n5);
		d.show();
		boolean result = d.sePuedeObtener(30);
		if (result == false) {
			System.out.println("Lo sentimos pero no hemos podido realizar la suma");
		}
	}
}
