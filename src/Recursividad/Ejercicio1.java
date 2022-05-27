package Recursividad;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introducir valor de n: ");
        int n = entrada.nextInt();
        System.out.println( sumar(n));
    }

    public static int sumar(int n) {
    if (n==0)
        return n;
    else
        return n+(sumar(n-1));
    }
}
