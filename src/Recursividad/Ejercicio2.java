package Recursividad;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introducir valor de n: ");
        int n = entrada.nextInt();
        System.out.println( factorial(n));
    }
    public static int factorial (int n) {
        if (n==0)
            return 1;
        else
            return n*(factorial(n-1));
    }
}
