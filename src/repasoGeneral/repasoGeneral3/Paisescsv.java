package repasoGeneral3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Paisescsv {
	
	public static void leerFichero(String fichero) {
		ArrayList<Pais> pais = new ArrayList<Pais>();
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(",");
				String nomPais = "";
				for (int i=0; i<palabra[0].length()-1; i++) {
					if (palabra[0].substring(i, i+1).equals("\"")) {
						
					}else {
						nomPais = nomPais + palabra[0].substring(i, i+1);
					}
				}
				Pais x = new Pais(nomPais);
				pais.add(x);
			}
			f.close();
			for(int i=0; i<pais.size(); i++) {
				System.out.println(pais.get(i).getNombre());
			}
			
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le�do");
		}
	}
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso3\\paises.csv";
		leerFichero(fichero);
	}

}
