package Repaso3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        leerFichero("C:\\Users\\elisa\\Desktop\\paises.csv");
    }

    public static void leerFichero(String fichero) {
        File file = new File(fichero);
        ArrayList<Tupla> natList = new ArrayList<Tupla>();
        try {
            /*
             * Se crea un objeto [Formatter] al que se asocia un fichero deno-
             * minado [file].
             */
            Scanner f = new Scanner(file);
            f.nextLine();
            while (f.hasNextLine()) {
                String next = f.nextLine();
                String[] paises = next.split(",");
                int posicion = insertPaises(natList, paises[0].charAt(1));
                if (posicion > -1) {
                    natList.get(posicion).setOccurrences(natList.get(posicion).getOccurrences() + 1);
                } else {
                    natList.add(new Tupla(paises[0].charAt(1), 1));
                }
            }
            f.close();
            Collections.sort(natList);

            for (int i=0; i< natList.size();i++) {
                System.out.println(natList.get(i).getPaises()+ " " +natList.get(i).getOccurrences());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertPaises(ArrayList<Tupla> natList, char paises) {
        for (int i = 0; i < natList.size(); i++) {
            if (natList.get(i).getPaises() == (paises)) {
                return i;
            }
        }
        return -1;
    }
}