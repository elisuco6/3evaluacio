package repasoGeneral4;

import java.io.File;
import java.util.Scanner;

public class Textotxt {
	
	public static void leerFicheros(String fichero) {
		File file = new File(fichero);
		int contador = 0;
		try {
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(" ");
				
				for(int i=0; i<palabra.length; i++) {
					for(int j=0; j<palabra[i].length(); j++) {
						if(palabra[i].substring(j, j+1).equalsIgnoreCase("a")) {
							contador++;
						}
						if(palabra[i].substring(j, j+1).equalsIgnoreCase("e")) {
							contador++;
						}
						if(palabra[i].substring(j, j+1).equalsIgnoreCase("i")) {
							contador++;
						}
						if(palabra[i].substring(j, j+1).equalsIgnoreCase("o")) {
							contador++;
						}
						if(palabra[i].substring(j, j+1).equalsIgnoreCase("u")) {
							contador++;
						}
					}
					if (contador>=3) {
						System.out.println(palabra[i]);
					}
					contador = 0;
				}
			}
			f.close();
			
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le�do");
		}
	}
	
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso4\\texto.txt";
		leerFicheros(fichero);
	}

}
