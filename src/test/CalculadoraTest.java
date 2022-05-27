package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora cal;
	
	@BeforeEach
	public void before() {
		System.out.println("Creo calculadora");
		cal = new Calculadora();
	}
	
	@AfterEach
	public void after() {
		System.out.println("Reseteo ans");
		cal.resetearAns();
	}

	@Test
	public void sumarTest() {
		System.out.println("Prueba sumarTest");
		int a = 3, b = 2;
		int resultado = cal.sumar(a, b);
		int esperado = 5; // 3 + 2 = 5
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void restarTest() {
		System.out.println("Prueba restarTest");
		int a = 3, b = 2;
		int resultado = cal.restar(a, b);
		int esperado = 1; // 3 - 2 = 1
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void multiplicarTest() {
		System.out.println("Prueba multiplicarTest");
		int a = 3, b = 2;
		int resultado = cal.multiplicar(a, b);
		int esperado = 6; // 3 * 2 = 6
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void dividirTest() {
		System.out.println("Prueba dividirTest");
		int a = 3, b = 3;
		int resultado = cal.dividir(a, b);
		int esperado = 1; // 3 / 3 = 1
		assertEquals(esperado, resultado);
	}

}
