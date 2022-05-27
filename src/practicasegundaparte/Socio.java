package practicasegundaparte;

public class Socio {
	private String nombre;
	private String primerapellido;
	private String segundoapellido;
	private String incorporacion;
	
	
	public Socio(String nombre, String primerapellido, String segundoapellido, String incorporacion) {
		this.nombre = nombre;
		this.primerapellido = primerapellido;
		this.segundoapellido = segundoapellido;
		this.incorporacion = incorporacion;
	}

	public Socio() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerapellido() {
		return primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getIncorporacion() {
		return incorporacion;
	}

	public void setIncorporacion(String incorporacion) {
		this.incorporacion = incorporacion;
	}

	
	@Override
	public String toString() {
		return "Nombre= " + nombre + ", Primer apellido= " + primerapellido + " Segundo apellido= " + segundoapellido
				+ " Incorporacion=" + incorporacion;
	}
	
	
			
}
