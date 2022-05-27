package repasoGeneral4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fosascsv {
	public static void leerFichero(String fichero) {
		ArrayList<Fosa> tipo = new ArrayList<Fosa>();
		boolean encontrado = false;
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				int num = 0;
				String linea = f.nextLine();
				String[] palabra = linea.split(";");
				String provincia = palabra[1];
				for (int i=0; i<tipo.size(); i++) {
					if (provincia.equals(tipo.get(i).getNombre())) {
						encontrado = true;
						num = i;
						break;
					}
				}
				if (encontrado) {
					tipo.get(num).setContador(tipo.get(num).getContador()+1);
					encontrado = false;
				} else {
					Fosa x = new Fosa(provincia, 1);
					tipo.add(x);
				}
			}
			f.close();
			Collections.sort(tipo);
			for(int i=0; i<tipo.size(); i++) {
				System.out.println(tipo.get(i).getNombre() + " // " + tipo.get(i).getContador());
			}
			
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le�do");
		}
	}
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso4\\fosas.csv";
		leerFichero(fichero);
	}

}
