package Repaso3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio1_rep3 {
    public static void main(String[] args) {
        String nombre = "C:\\Users\\elisa\\Desktop\\paises.csv";
        ArrayList<Paises2> paises = new ArrayList<Paises2>();
        File file = new File(nombre);
        try {
            Scanner f = new Scanner(file);
            f.nextLine();
            while (f.hasNextLine()) {
                String linea = f.nextLine();
                linea = linea.replaceAll("\"", "");
                String[] linesep = linea.split(",");
                int posicion = buscarLetra(paises, linesep[0].charAt(0));
                if (posicion > -1) {
                    paises.get(posicion).setContador(paises.get(posicion).getContador() + 1);
                } else {
                    paises.add(new Paises2(linesep[0].charAt(0), 1));
                }
            }
            f.close();
            Collections.sort(paises);

            for (int i = 0; i < paises.size(); i++) {
                System.out.println(paises.get(i).getLetra() + " " + paises.get(i).getContador());
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
        }
    }

    public static int buscarLetra(ArrayList<Paises2> paises, char c) {
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i).getLetra() == (c)) {
                return i;
            }
        }
        return -1;
    }
}
