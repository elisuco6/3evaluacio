package repasoGeneral2;

public class RecursivoPalidromo {
	
	public static boolean esPolidromo(String palabra, int i, int j) {
		if(i<j) {
			if (palabra.substring(i, i+1).equals(palabra.substring(j-1, j))) {
				return esPolidromo(palabra, i+1, j-1);
			} else {
				return false;
			}
		} else {
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		String palabra = "abcfa";
		int i = 0;
		int j = palabra.length();
		boolean respuesta = esPolidromo(palabra, i, j);
		if(respuesta) {
			System.out.println("La cadena " + palabra + " es un polídromo");
		} else {
			System.out.println("La cadena " + palabra + " NO es un polídromo");
		}
	}

}
