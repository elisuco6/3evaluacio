package ficherosbinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    /**
     * Pre: El objeto [f] está asociado a un fichero en modo escritura de datos
     * Post: Escribe, al final del fichero asociado a [f], los datos [producto],
     * [cliente], [cantidad] y [precio] todo ellos codificados en binario.
     */
    private static void escribir(DataOutputStream f, int asignaturas, int aprobadas,
                                 int suspendidas, double precio) {
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
        try {
            /*
             * Se crea un objbeto [DataOutputStream] al que se asocia un fichero
             * denominado [nombre].
             */
            DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
            /*
             * Se escriben los datos de cada una de las ventas en el fichero [f]
             */
            escribir(f, 10, 8, 2, 300.12);
            escribir(f, 10, 5, 5, 300.12);
            escribir(f, 10, 7, 3, 350.89);
            escribir(f, 10, 5, 7, 340.23);
            escribir(f, 10, 5, 5, 367.23);
            escribir(f, 10, 8, 2, 300.23);
            escribir(f, 10, 6, 4, 340.23);
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
                System.out.println("CURSADAS  APROBADAS  SUSPENDIDAS  M. HONOR");
                System.out.println("========  =========  ===========  ========");
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
                        System.out.printf(" %6d%10d%9d%16.2f  -- ¡ERROR EN LAS ASIGNATURAS!%n",
                                cursadas, aprobadas, suspendidas, precio);
                    }
                }
            } catch (EOFException e) {
                double mediaAprobadas = (totalAprobadas / nAlumnos);
                double mediaPrecio = (totalPrecio / nAlumnos);
                System.out.println("==========================================");
                System.out.println("Media de aprobadas: " + mediaAprobadas);
                System.out.println("Número de matrículas de honor: " + mediaPrecio);
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
