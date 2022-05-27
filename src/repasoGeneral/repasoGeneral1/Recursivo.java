package repasoGeneral.repasoGeneral1;

public class Recursivo {
	
	public static String invertirCadena(String cadena) {
		if (cadena.length() <= 1) {
	        return cadena;
	    }
	    return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
	}
	
	public static void main (String[] args) {
		String cadena = "siuL";
		System.out.println(invertirCadena(cadena));
	}

}
