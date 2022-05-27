package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class OperacionesTest {
	
	@Test
	public void multiplicarTablaTest() {
		int[] tabla = {1, 2, 3, 4};
		int multiplicador = 2;
		int[] esperado = {2, 4, 6, 8}; // tabla * 2
		int[] resultado = Operaciones.multiplicarTabla(tabla, multiplicador);
		assertArrayEquals(esperado, resultado);
	}
	
	@Test
	public void calcularSueldoTest() {
		Persona persona = new Persona("Alvaro", 2000);
		int trienios = 1;
		Persona resultado = Operaciones.calcularSueldo(persona, trienios);
		Persona esperado = new Persona("Alvaro", 2070);
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void devolverPersonasIgualesTest() {
		Persona[] personas = new Persona[3];
		personas[0] = new Persona("Alvaro", 2000);
		personas[1] = new Persona("Clara", 2400);
		personas[2] = new Persona("Alvaro", 100);
		Persona[] resultado = Operaciones.devolverPersonasIguales(personas, "Alvaro");
		Persona[] esperado = new Persona[2];
		esperado[0] = new Persona("Alvaro", 2000);
		esperado[1] = new Persona("Alvaro", 100);
		assertArrayEquals(esperado, resultado);
	}
	
	@Test
	@Timeout(value = 5500, unit = TimeUnit.MILLISECONDS)
	public void algoritmoComplejoTest() {
		Operaciones.algoritmoComplejo();
	}
	

}
