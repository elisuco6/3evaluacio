package Recursividad;

import java.util.Scanner;

public class Ejercicio3 {
    private static void tablas(int[] t, int i) {
        if (i<t.length) {
            System.out.println(t[i]);
            tablas(t, i + 1);
        }
    }

    public static void tablas(int[] t){
        tablas(t,0);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[]t ={1,2,3,4,5,6,7,8,9,10};
        tablas(t);
    }
}