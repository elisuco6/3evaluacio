package repasoGeneral4;

public class Fosa implements Comparable<Fosa>{
	
	private String nombre;
	private int contador;
	
	public Fosa (String nombre, int contador) {
		this.nombre = nombre;
		this.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getContador() {
		return contador;
	}
	
	public void setContador(int contador) {
		this.contador = contador;
	}
	

	@Override
	public String toString() {
		return "Fosa [nombre=" + nombre + ", contador=" + contador + "]";
	}

	@Override
	public int compareTo(Fosa o) {
		if(this.contador > o.getContador()) {
			return -1;
		} else if (this.contador < o.getContador()) {
			return 1;
		}
		return 0;
	}

	
}
