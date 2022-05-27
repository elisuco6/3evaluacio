package recursividad2;

import recursividad2.Tupla;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		getDrivers("C:\\Users\\elisa\\Desktop\\drivers.csv");
	}
	
	/**
	 * Pre: [fichero] contiene el path+nombre del fichero drivers.csv
	 * Post: Lee el fichero [fichero] y muestra por pantalla el número
	 * 		de pilotos de cada una de las nacionalidades, ordenadas
	 * 		de mayor a menor.
	 */
	private static void getDrivers(String fichero) {
		File file = new File(fichero);
		ArrayList<Tupla> natList = new ArrayList<Tupla>();
		try {
			/*
			 * Se crea un objeto [Formatter] al que se asocia un fichero deno-
			 * minado [file].
			 */
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String next = f.nextLine();
				String nationality = next.split(",")[7].replace("\"", "").trim();
				insertNationality(natList, nationality);
			}
			/*
			 * Ordenamos la lista de mayor a menor segun ocurrencias
			 * y la mostramos por pantalla
			 */
			Collections.sort(natList);
			for(Tupla t : natList) {
				System.out.println("Nat: " + t.getNationality() + 
						" -> " + t.getOccurrences() + " occurrences");
			}
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Si [nationality] no se encuentra entre ninguna de las tuplas de la 
	 * 		lista la añade. En caso contrario, suma uno al numero de ocurrencias
	 * 		de la tupla correspondiente.
	 */
	private static void insertNationality(ArrayList<Tupla> natList, String nationality) {
		if(natList.size() == 0) {
			natList.add(new Tupla(nationality, 1));
		} else {
			boolean find = false;
			for(int i = 0; i < natList.size(); i++) {
				if(natList.get(i).getNationality().equalsIgnoreCase(nationality)) {
					natList.get(i).setOccurrences(natList.get(i).getOccurrences() + 1);
					find = true;
					break;
				}
			}
			/*
			 * Si no hemos encontrado la tupla, significa que debemos
			 * añadirla.
			 */
			if(!find) {
				natList.add(new Tupla(nationality, 1));
			}
		}
	}
}
