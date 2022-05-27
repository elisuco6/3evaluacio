package repasoGeneral2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Accidentalidad {
	
	public static void leerFichero(String fichero) {
		ArrayList<Accidente> tipo = new ArrayList<Accidente>();
		boolean encontrado = false;
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				int num = 0;
				String linea = f.nextLine();
				String[] palabra = linea.split(";");
				String tipoAccidente = palabra[6];
				for (int i=0; i<tipo.size(); i++) {
					if (tipoAccidente.equals(tipo.get(i).getTipoAccidente())) {
						encontrado = true;
						num = i;
						break;
					}
				}
				if (encontrado) {
					tipo.get(num).setVeces(tipo.get(num).getVeces()+1);
					encontrado = false;
				} else {
					Accidente x = new Accidente(tipoAccidente, 1);
					tipo.add(x);
				}
			}
			f.close();
			for(int i=0; i<tipo.size(); i++) {
				System.out.println(tipo.get(i).getTipoAccidente() + " // " + tipo.get(i).getVeces());
			}
			
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le�do");
		}
	}
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso2\\2021_Accidentalidad.csv";
		leerFichero(fichero);
	}

}
