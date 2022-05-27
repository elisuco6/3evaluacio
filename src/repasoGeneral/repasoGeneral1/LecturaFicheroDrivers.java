package repasoGeneral.repasoGeneral1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaFicheroDrivers {
	
	public static void leerFichero(String fichero, ArrayList<Drivers> drivers) {
		File file = new File(fichero);
		int contador = 0;
		boolean encontrado = false;
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(",");
				String country = "";
				for (int i=0; i<palabra[7].length()-1; i++) {
					if (palabra[7].substring(i, i+1).equals("\"")) {
						
					}else {
						country = country + palabra[7].substring(i, i+1);
					}
				}
				for (int i=0; i<drivers.size(); i++) {
					if (country.equals(drivers.get(i).getCountry())) {
						encontrado = true;
						contador = i;
						break;
					}
				}
				if (encontrado) {
					drivers.get(contador).setCount(drivers.get(contador).getCount()+1);
					encontrado = false;
				} else {
					Drivers x = new Drivers(country, 1);
					drivers.add(x);
				}
			}
			f.close();
			for (int i=0; i<drivers.size(); i++) {
				System.out.println("Country--> " + drivers.get(i).getCountry() + " " + drivers.get(i).getCount() + " veces");
			}
		} catch (Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leido con �xito");
		}
	}
	
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso1\\drivers.csv";
		ArrayList<Drivers> drivers = new ArrayList<Drivers>();
		leerFichero(fichero, drivers);
	}

}
