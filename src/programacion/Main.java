package programacion;

public class Main {
	public static void main(String[] args) throws Exception {
		programacion.MySQLAccess dao = new programacion.MySQLAccess();
		dao.readDataBase(); 
	}
}