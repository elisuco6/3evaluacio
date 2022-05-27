package Recursividad;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introducir valor de n: ");
        int n = entrada.nextInt();
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(tablas(t, 0, n));
    }
    public static boolean tablas(int[] t, int n) {
        return tablas(t, n, 0);
    }

    private static boolean tablas(int[] t, int i, int n) {
        if (i < t.length) {
            if (n == t[i]) {
                return true;
            } else {
                return tablas(t,n, i + 1);
            }
        } else {
            return false;
        }
    }
}
