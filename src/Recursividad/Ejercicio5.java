package Recursividad;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] t = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {3, 89, 5, 7, 8, 2, 1, 9, 0, 5}
        };
        tablas(t, 0, 0);
    }

    public static void tablas(int[][] t) {
        tablas(t,0,0);
    }

    private static void tablas(int[][] t, int i, int j) {
        if (i<t.length && j==t[i].length){
            System.out.println();
            tablas(t,i+1,0);
        }else if (i<t.length && j<t[i].length){
            System.out.print(t[i][j]+" ");
            tablas(t,i,j+1);
        }
    }
}