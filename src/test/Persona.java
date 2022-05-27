package test;

public class Persona {
	private String nombre;
	private int sueldo;
	
	public Persona(String nombre, int sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public boolean equals(Object o) {
		Persona p = (Persona) o;
		if(nombre.equalsIgnoreCase(p.getNombre()) && 
				sueldo == p.getSueldo()) {
			return true;
		} return false;
	}
	
}
