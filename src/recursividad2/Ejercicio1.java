package recursividad2;

public class Ejercicio1 {
	public static void main(String[] args) {
		String cadena = "Hola";
		reverse(cadena);
	}
	
	public static void reverse(String cadena) {
		System.out.println(reverseUp(cadena, 0));
		System.out.println(reverseDown(cadena, cadena.length()));
	}
	
	private static String reverseUp(String cadena, int i) {
		if(i < cadena.length()) {
			return reverseUp(cadena, i + 1) + cadena.substring(i, i+1);
		} return "";
	}
	
	private static String reverseDown(String cadena, int i) {
		if(i > 0) {
			return cadena.substring(i - 1, i) + reverseDown(cadena, i - 1);
		} return "";
	}
}
