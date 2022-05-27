package repasoGeneral.repasoGeneral1;

public class MainConstructors {
	
	public static void main(String[] args) throws Exception {
		repasoGeneral1.MySQLAccess dao = new repasoGeneral1.MySQLAccess();
		LecturaConstructors lec = new LecturaConstructors();
		String fichero1 = "C:\\Users\\Luisao\\Desktop\\Repaso1";
		String fichero2 = "";
		lec.leerFichero(fichero1, 0);
	}

}
