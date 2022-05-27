package Repaso2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class repaso2 {
    public static void main(String[] args) {
    leerFichero("C:\\Users\\elisa\\Desktop\\2021_Accidentalidad.csv");
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
        while(f.hasNextLine()) {
            String next = f.nextLine();
            String acidentality = next.split(";")[6].replace("\"", "").trim();
            insertAccidentality(natList, acidentality);
        }
        Collections.sort(natList);
        for (Tupla t : natList){
            System.out.println("Nat: " + t.getAccidentality() + " -> " + t.getOccurrences()+"ocurrences");
        }

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
    public static void insertAccidentality(ArrayList<Tupla> natList, String accidentality){
        if (natList.size()==0){
            natList.add(new Repaso2.Tupla(accidentality, 1));
        } else {
            boolean find = false;
            for(int i = 0; i < natList.size(); i++) {
                if (natList.get(i).getAccidentality().equalsIgnoreCase(accidentality)){
                    natList.get(i).setOccurrences(natList.get(i).getOccurrences()+1);
                    find = true;
                    break;
                }
            }
            if(!find) {
                natList.add(new Tupla(accidentality, 1));
            }
        }
    }
}
