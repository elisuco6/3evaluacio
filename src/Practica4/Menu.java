package Practica4;

import java.io.*;
import java.util.*;

/**
 * Pre: ---
 * Post: programa Java que trabaja con varios ficheros que almacenan información sobre alumnos de GS de una titulación,
 *       sobre las asignaturas de su plan de estudios y sobre las asignaturas matriculadas por cada alumno.
 */
public class Menu {

    /**
     * Pre: ---
     * Post: En el metodo main almacenamos en variables las rutas de los ficheros y creamos los array de los objetos
     *       de cada fichero
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Asignaturas> listaasignaturas = new ArrayList<Asignaturas>();
        ArrayList<Alumno> listaalumnos = new ArrayList<Alumno>();
        ArrayList<Matriculas> matriculas = new ArrayList<Matriculas>();
        // Gestor de ordenacion de objetos, generado con un metodo dentro del objeto
        Collections.sort(matriculas);

        // rutas de los ficheros
        String Alumnos = "C:/Users/elisa/Desktop/Alumnos.csv";
        String Asignaturas = "C:/Users/elisa/Desktop/asignaturas.txt";
        String Matriculas = "C:/Users/elisa/Desktop/matriculas.dat";

        // metodos para la lectura de ficheros
        leerFicheroCsv(Alumnos, listaalumnos);
        leerFicheroTxt(Asignaturas, listaasignaturas);
        leerFicheroDat(Matriculas, matriculas);
        // metodo para el menu de opciones del programa
        opciones(listaasignaturas, listaalumnos, matriculas);
    }

    /**
     * pre: ---
     * Post: En este metodo leeremos el fichero asignaturas en formato txt y lo almacenamos en un arraylist para su
     *       posterior modificacion.
     */
    private static void leerFicheroTxt(String Asignaturas, ArrayList<Asignaturas> listaasignaturas) {
        File file = new File(Asignaturas);
        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String linea = f.nextLine();
                String[] asignas = linea.split(" ");
                String nombrecompleto = "";
                // unimos en una misma casilla los valores
                for (int i = 4; i < asignas.length; i++) {
                    nombrecompleto += asignas[i] + " ";
                }
                Asignaturas asignar = new Asignaturas(asignas[0].trim(), asignas[1].trim(), asignas[2].trim(),
                                                      asignas[3].trim(), nombrecompleto);
                //Añadimos al array los datos del fichero habiendo spliteado antes por: " "
                listaasignaturas.add(asignar);
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        //lectura de comprobacion
        for (int i = 0; i < listaasignaturas.size(); i++) {
            //System.out.println(listaasignaturas.get(i));
        }
        System.out.println();
    }

    /**
     * Pre: ---
     * Post: En este metodo leeremos el fichero alumnos en formato csv y lo almacenamos en un arraylist para su
     *       posterior modificacion.
     */
    private static void leerFicheroCsv(String alumnos, ArrayList<Alumno> listaalumnos) {
        File file = new File(alumnos);
        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String linea = f.nextLine();
                String[] alumnitos = linea.split(";");
                //Añadimos al array los datos del fichero habiendo spliteado antes por: ";"
                listaalumnos.add(new Alumno(alumnitos[0], alumnitos[2], alumnitos[1]));
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        //lectura de comprobacion
        for (int i = 0; i < listaalumnos.size(); i++) {
            //System.out.println(listaalumnos.get(i));
        }
        System.out.println("");
    }

    /**
     * Pre: ---
     * Post: En este metodo leeremos el fichero alumnos en formato csv y lo almacenamos en un arraylist para su
     *       posterior modificacion.
     */
    private static void leerFicheroDat(String Matriculas, ArrayList<Matriculas> matriculas) {
        try {
            /*
             * Se crea un objeto [DataInputStream] al que se asocia un fichero denominado
             * [nombre].
             */
            DataInputStream f = new DataInputStream(new FileInputStream(Matriculas));
            try {
                while (true) {
                    int nip_alumno = f.readInt();
                    int codigo_asignatura = f.readInt();
                    //System.out.println(nip_alumno + " " + codigo_asignatura);

                    Matriculas nuevas = new Matriculas(nip_alumno, codigo_asignatura);
                    matriculas.add(nuevas);
                }
            } catch (EOFException e) {
                System.out.println(e);
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + Matriculas + " no ha podido ser abierto");
        } catch (IOException e) {
            System.out.println("Error en operación de E/S con el fichero " + Matriculas);
        }
        for (int i = 0; i < matriculas.size(); i++) {
            //System.out.println(matriculas.get(i));
        }
    }

    /**
     * Pre: ---
     * Post:
     */
    private static void escribirFicheroDat(DataOutputStream f, int nip_alumno, int codigo_asignatura) {
        try {
            f.writeInt(nip_alumno);
            f.writeInt(codigo_asignatura);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }
    }

    /**
     * Pre: ---
     * Post:
     */
    public static void contarmatriculas(ArrayList<Matriculas> matriculas, ArrayList<Asignaturas> listaasignaturas) {
        for (int i = 0; i < listaasignaturas.size(); i++) {
            int contador = 0;
            for (int x = 0; x < matriculas.size(); x++) {
                //System.out.println(matriculas.get(x).getCodigo_asignaturas()+" "+listaasignaturas.get(i).getCodigo_asignatura());
                if (Integer.parseInt(listaasignaturas.get(i).getCodigo_asignatura()) == matriculas.get(x).getCodigo_asignaturas()) {
                    contador++;
                }
            }
            System.out.println(listaasignaturas.get(i).getNombre() + " Tiene: " + contador + " alumnos");
        }
    }

    /**
     * Pre: ---
     * Post:
     */
    public static void asignaturasnip(ArrayList<Matriculas> matriculas, ArrayList<Asignaturas> listaasignaturas,
                                      int nip, String opcion) {
        ArrayList<Asignaturas> asigna2 = new ArrayList<Asignaturas>();
        //System.out.println("entraste");

        //recorremos asignaturas
        for (int i = 0; i < listaasignaturas.size(); i++) {
            //recorremos matriculas
            for (int x = 0; x < matriculas.size(); x++) {
                //comprobamos el nip que se ha introducido y comaparamos los nip de los array para que coincidan
                if (Integer.parseInt(listaasignaturas.get(i).getCodigo_asignatura()) == matriculas.get(x).getCodigo_asignaturas()) {
                    if (matriculas.get(x).getNip_alumno() == nip) {
                     asigna2.add(listaasignaturas.get(i));
                    }
                }
            }
        }
        for (int i = 0; i < asigna2.size(); i++) {
            if (opcion.equalsIgnoreCase("a")) {
                asigna2.sort(Comparator.comparing(Asignaturas::getNombre));
                System.out.println(asigna2.get(i));
            } else if (opcion.equalsIgnoreCase("c")) {
                asigna2.sort(Comparator.comparing(Asignaturas::getCodigo_asignatura));
                System.out.println(asigna2.get(i).toString());
            } else {
                asigna2.sort(Comparator.comparing(Asignaturas::getCodigo_asignatura));
                System.out.println(asigna2.get(i).toString());
            }
        }
    }

    /**
     * Pre: ---
     * Post:
     */
    public static void alumnoscodigo(ArrayList<Matriculas> matriculas, ArrayList<Asignaturas> listaasignaturas,
                                     ArrayList<Alumno> listaalumnos, int codigoasignatura,String datos) {
        ArrayList<Alumno> alumn2 = new ArrayList<Alumno>();

        //recorremos alumnos
        for (int i = 0; i < listaalumnos.size(); i++) {
            //recorremos matriculas
            for (int x = 0; x < matriculas.size(); x++) {
                if (Integer.parseInt(listaasignaturas.get(i).getCodigo_asignatura())==matriculas.get(x).getCodigo_asignaturas()){
                    if (matriculas.get(x).getCodigo_asignaturas() == codigoasignatura){
                        alumn2.add(listaalumnos.get(x));
                    }
                }
            }
        }
        for (int i = 0; i < alumn2.size(); i++) {
            if (datos.equalsIgnoreCase("a")) {
                alumn2.sort(Comparator.comparing(Alumno::getNombre));
                System.out.println(alumn2.get(i));
            } else if (datos.equalsIgnoreCase("n")) {
                alumn2.sort(Comparator.comparing(Alumno::getNip));
                System.out.println(alumn2.get(i).toString());
            } else {
                alumn2.sort(Comparator.comparing(Alumno::getNip));
                System.out.println(alumn2.get(i).toString());
            }
        }
    }

    /**
     * Pre: ---
     * Post:
     */
    public static void opciones(ArrayList<Asignaturas> listaasignaturas,
                                ArrayList<Alumno> listaalumnos,
                                ArrayList<Matriculas> matriculas) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("******** CATALOGO DE ORDENES ********");
        System.out.println("              Matrículas             ");
        System.out.println("        Asignaturas nip [A | C]      ");
        System.out.println("        Alumnos código  [A | N]      ");
        System.out.println("        Eliminar nip { código }      ");
        System.out.println("    Matricular nip código { código } ");
        System.out.println("                 Fin                 ");
        boolean bucle = true;

        while (bucle) {
            System.out.print("Orden> ");
            String seleccion = entrada.nextLine();
            String[] datos = seleccion.split(" ");

            //Matriculas
            if (datos[0].equalsIgnoreCase("Matriculas")) {
                contarmatriculas(matriculas, listaasignaturas);

                //Asignaturas nip(alumno) [A | C]
            } else if (datos[0].equalsIgnoreCase("Asignaturas")) {
                //System.out.println("entramos");
                int nip = Integer.parseInt(datos[1]);
                if (datos.length == 3) {
                    asignaturasnip(matriculas, listaasignaturas, nip, datos[2]);
                }else{
                    asignaturasnip(matriculas, listaasignaturas, nip, " ");
                }
            // Alumnos código [A | N]
            }else if (datos[0].equalsIgnoreCase("Alumnos")){
                int codigoasignatura = Integer.parseInt(datos[1]);
                if (datos.length == 3) {
                    alumnoscodigo(matriculas, listaasignaturas, listaalumnos, codigoasignatura, datos[2]);
                }else{
                    alumnoscodigo(matriculas, listaasignaturas, listaalumnos, codigoasignatura, " ");
                }

            }else if (datos[0].equalsIgnoreCase("Eliminar")){

            }else if (datos[0].equalsIgnoreCase("Matricular")){

            }else if (datos[0].equalsIgnoreCase("fin")){
                bucle=false;
            }
        }
    }
}
// Asignaturas 627867 A
// Alumnos 30201 A