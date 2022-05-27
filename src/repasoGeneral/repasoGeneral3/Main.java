package repasoGeneral3;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		DoubleLinkedList x = new DoubleLinkedList();
		Node n1 = new Node(10, null, null);
		Node n2 = new Node(20, null, null);
		Node n3 = new Node(30, null, null);
		Node n4 = new Node(40, null, null);
		Node n5 = new Node(50, null, null);
		Node n6 = new Node(60, null, null);
		Node n7 = new Node(70, null, null);
		Node n8 = new Node(80, null, null);
		Node n9 = new Node(90, null, null);
		Node n10 = new Node(100, null, null);
		
		ArrayList<Node> listaNodes = new ArrayList<Node>();
		listaNodes.add(n1);
		listaNodes.add(n2);
		listaNodes.add(n3);
		listaNodes.add(n4);
		listaNodes.add(n5);
		listaNodes.add(n6);
		listaNodes.add(n7);
		listaNodes.add(n8);
		listaNodes.add(n9);
		listaNodes.add(n10);
		
		x.addSome(listaNodes);
		x.show();
		
		System.out.println();
		
		int[] deletePositions = {3, 7};
		x.deleteSome(deletePositions);
		x.show();
	}
}
