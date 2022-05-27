package test;

public class Calculadora {
	
	private int ans;
	
	public Calculadora() {
		ans = 0;
	}
	
	public int sumar(int a, int b) {
		int suma = a + b;
		ans = suma;
		return suma;
	}
	
	public int restar(int a, int b) {
		int resta = a - b;
		ans = resta;
		return resta;
	}
	
	public int dividir(int a, int b) {
		int dividir = a / b;
		ans = dividir;
		return dividir;
	}
	
	public int multiplicar(int a, int b) {
		int multiplicar = a * b;
		ans = multiplicar;
		return multiplicar;
	}
	
	public void resetearAns() {
		ans = 0;
	}
}
