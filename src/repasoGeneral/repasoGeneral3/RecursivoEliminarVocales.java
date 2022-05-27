package repasoGeneral3;

public class RecursivoEliminarVocales {
	
	public static void eliminarVocales(String palabra, String sinVocales, int i) {
		if (i<palabra.length()) {
			if(!palabra.substring(i, i+1).equals("a") && !palabra.substring(i, i+1).equals("e") && !palabra.substring(i, i+1).equals("i") && 
					!palabra.substring(i, i+1).equals("o") && !palabra.substring(i, i+1).equals("u")) {
				sinVocales = sinVocales + palabra.substring(i, i+1);
			}
			
			eliminarVocales(palabra, sinVocales, i+1);
		} else {
			System.out.println(sinVocales);;
		}
	}
	public static void main(String[] args) {
		String palabra = "murcielago";
		String sinVocales = "";
		eliminarVocales(palabra, sinVocales, 0);
	}

}
