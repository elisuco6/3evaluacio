package ficherosbinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Eje1 {

    /**
     * Pre: El objeto [f] está asociado a un fichero en modo escritura de datos
     * Post: Escribe, al final del fichero asociado a [f], los datos [producto],
     * [cliente], [cantidad] y [precio] todo ellos codificados en binario.
     */
    private static void escribir(DataOutputStream f, int asignaturas, int aprobadas, int suspendidas, double precio) {
        try {
            f.writeInt(asignaturas);
            f.writeInt(aprobadas);
            f.writeInt(suspendidas);
            f.writeDouble(precio);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }
    }

    /**
     * Pre: ---
     * Post: Crea un fichero de ventas denominado [nombre] y almacena en él los
     * valores definidos en la tabla de ventas. Cada venta está caracterizada
     * por la cuadrápula de valores (producto, cliente, cantidad, precio).
     */
    private static void crearFichero(String nombre) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Alumno> lista = new ArrayList<Alumno>();

        try {
            /*
             * Se crea un objbeto [DataOutputStream] al que se asocia un fichero
             * denominado [nombre].
             */
            DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
            /*
             * Se escriben los datos de cada una de las ventas en el fichero [f]
             */
            boolean repetir = true;
            while (repetir) {

                System.out.println("Numero total de asignaturas cursadas: ");
                int asignaturas = entrada.nextInt();
                System.out.println("Numero de asignaturas suspendidas: ");
                int asignaturassuspendidas = entrada.nextInt();
                System.out.println("Numero de asignaturas aprobadas: ");
                int asignaturasaprobadas = entrada.nextInt();
                System.out.println("introducir precio: ");
                double precio = entrada.nextInt();

                Alumno actual = new Alumno(asignaturas, asignaturassuspendidas, asignaturasaprobadas, precio);
                lista.add(actual);
                escribir(f, asignaturas, asignaturasaprobadas, asignaturassuspendidas, precio);

                System.out.println("¿Deseas seguir?");
                if (entrada.next().equalsIgnoreCase("no")) {
                    repetir = false;
                    break;
                }
            }

            /*
             * Se libera el fichero asociado al objeto [f]
             */
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombre + " no ha podido ser abierto");
        } catch (IOException e) {
            System.out.println("Error en operación de E/S con el fichero " + nombre);
        }
    }

    /**
     * Pre: ---
     * Post: Presenta por pantalla los datos almacenados en un fichero de ventas
     * denominado [nombre]. En el caso de que no haya ningún fichero accesible con
     * ese nombre informa con un mensaje de la circunstancia.
     */
    private static void leerFichero(String nombre) {
        double totalAprobadas = 0;
        double nAlumnos = 0;
        double totalPrecio = 0;
        try {
            /*
             * Se crea un objeto [DataInputStream] al que se asocia un fichero denominado
             * [nombre].
             */
            DataInputStream f = new DataInputStream(new FileInputStream(nombre));
            try {
                /*
                 * Se escriben por pantalla las dos líneas que encabezan la tabla de ventas
                 */
                System.out.println("CURSADAS  APROBADAS  SUSPENDIDAS  PRECIO");
                System.out.println("========  =========  ===========  ======");
                while (true) {
                    /*
                     * Se esriben por pantalla los datos de una de las ventas, tras
                     * haberlos leídos del fichero asociado a [f].
                     */
                    int cursadas = f.readInt();
                    int aprobadas = f.readInt();
                    int suspendidas = f.readInt();
                    double precio = f.readDouble();
                    if (cursadas == (aprobadas + suspendidas)) {
                        System.out.printf(" %6d%10d%9d%16.2f%n", cursadas, aprobadas, suspendidas, precio);
                        /*
                         * Almacenamos la información para mostrar el resumen al final
                         */
                        nAlumnos++;
                        totalAprobadas = totalAprobadas + aprobadas;
                        totalPrecio = totalPrecio + precio;
                    } else {
                        System.out.printf(" %6d%10d%9d%16.2f  -- ¡ERROR NO COINCIDE EL NUMERO DE ASIGNATURAS!%n",
                                cursadas, aprobadas, suspendidas, precio);
                    }
                }
            } catch (EOFException e) {
                double mediaAprobadas = (totalAprobadas / nAlumnos);
                double mediaPrecio = (totalPrecio / nAlumnos);
                System.out.println("==========================================");
                System.out.println("Media de aprobados: " + mediaAprobadas);
                System.out.println("Media del precio: " + mediaPrecio);
            }
            /*
             * Se libera el fichero asociado al objeto [f]
             */
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombre + " no ha podido ser abierto");
        } catch (IOException e) {
            System.out.println("Error en operación de E/S con el fichero " + nombre);
        }
    }

    /**
     * Pre: ---
     * Post: ejecuta el programa de prueba de escitura y lectura de un fichero binario
     * que almacena ventas.
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*
         * Solicitamos el path+nombre del fichero. Si existe, almacena la información
         * seguida de la que ya estaba. Si no existe, lo crea nuevo.
         */
        System.out.println("Indica el nombre del fichero binario: ");
        String nombre = entrada.nextLine();
        System.out.println();
        crearFichero(nombre);
        leerFichero(nombre);
    }
}