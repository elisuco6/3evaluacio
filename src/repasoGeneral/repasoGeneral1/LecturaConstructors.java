package repasoGeneral.repasoGeneral1;

import java.io.File;
import java.util.Scanner;

public class LecturaConstructors {
	
	public void leerFichero(String fichero, int num) {
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()) {
				System.out.println("he entrado");
				String linea = f.nextLine();
				String[] palabra = linea.split(",");
				for(int i=0; i<palabra.length; i++) {
					System.out.println(palabra[i]);
				}
			}
			f.close();
		} catch (Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído con éxito");
		}
	}
}
