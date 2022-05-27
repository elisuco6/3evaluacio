package repasoGeneral2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FicherosdeTexto {
	private static ArrayList<String> texto = new ArrayList<String>();
	
	public static void almacenarString(String linea) {
		texto.add(linea);
	}
	
	public static void escribirFichero() {
		try {
			Formatter salida = new Formatter("C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso2\\texto.txt");
			for (int i=0; i<texto.size(); i++) {
				salida.format(texto.get(i));
				salida.format("\n");
			}
			salida.flush();
			salida.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero no ha podido ser creado.");
		}
	}
	
	public static void leerFicheros(String fichero) {
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				almacenarString(linea);
			}
			f.close();
			
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser le�do");
		}
	}
	
	public static void main(String[] args) {
		String fichero1 = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso2\\texto1.txt";
		String fichero2 = "C:\\Users\\Luisao\\Desktop\\RepasoProgramacion\\Repaso2\\texto2.txt";
		leerFicheros(fichero1);
		leerFicheros(fichero2);
		escribirFichero();
	}
}
