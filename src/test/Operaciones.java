package test;

import java.util.ArrayList;

public class Operaciones {
	public static int[] multiplicarTabla(int[] tabla, int multiplicador) {
		for(int i = 0; i < tabla.length; i++) {
			tabla[i] = tabla[i] * multiplicador;
		} return tabla;
	}
	
	public static Persona calcularSueldo(Persona persona, int trienios) {
		persona.setSueldo(persona.getSueldo() + (trienios * 70));
		return persona;
	}
	
	public static Persona[] devolverPersonasIguales(Persona[] personas, String nombre) {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		for(int i = 0; i < personas.length; i++) {
			if(personas[i].getNombre().equalsIgnoreCase(nombre)) {
				listaPersonas.add(personas[i]);
			}
		}
		// Paso el arraylist a tabla que es lo que quiero devolver
		Persona[] personasIguales = new Persona[listaPersonas.size()];
		for(int i = 0; i < personasIguales.length; i++) {
			personasIguales[i] = listaPersonas.get(i);
		} return personasIguales;
	}
	
	public static void algoritmoComplejo() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
