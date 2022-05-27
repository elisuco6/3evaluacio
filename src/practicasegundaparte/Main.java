package practicasegundaparte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Pre: ---
 * Post: El main solo redirecciona a un metodo
 */
public class Main {
    public static void main(String[] args) {
        menuclub();
    }

    /*
     * Este metodo lo utilizare para almacenar los club en un fichero txt y asi poder listarlos posteriormente
     */
    public static almacenar almacenar(almacenar listaclub) {
        //pasamos la ruta por parametro
        File fileSalida = new File("src/practicasegundaparte/clubes");
        try {
            File[] archivos = fileSalida.listFiles();
            for (int x = 0; x < archivos.length; x++) {
                Scanner f = new Scanner(archivos[x]);
                //spliteamos por el txt
                Club Ankhal = new Club(archivos[x].getName().split(".txt")[0]);
                while (f.hasNextLine()) {
                    String linea = f.nextLine();
                    String[] lineaSep = linea.split(";");
                    Socio socio = new Socio(lineaSep[0], lineaSep[1], lineaSep[2], lineaSep[3]);
                    Node_Socio nodesocio = new Node_Socio(socio);
                    Ankhal.getSocio().add(nodesocio);
                }
                Node_Club nodeclub = new Node_Club(Ankhal);
                listaclub.add(nodeclub);
            }

        } catch (FileNotFoundException e) {

        }
        return listaclub;
    }

    /**
     * Pre: ---
     * Post: metodo menu donde nos redirecciona a un metodo que nos crea o nos escoge un club para su modificacion
     */

    public static void menuclub() {
        Scanner entrada = new Scanner(System.in);
        almacenar listaclub = new almacenar();
        boolean xd = true;
        while (xd) {
            System.out.println("1.- Crear un club");
            System.out.println("2.- Elegir un club");
            System.out.println("3.- Salir");
            int usuario = entrada.nextInt();
            if (usuario >= 0 & usuario <= 3) {
                if (usuario == 1) {
                    crearclub();
                } else if (usuario == 2) {
                    datoscarpeta(listaclub);
                } else if (usuario == 3) {
                    xd = false;
                }
            }
        }
    }

    /**
     * Pre: ---
     * Post: En caso de escoger la opcion de elegir club nos volvera a salir un menu de opciones con reenvio
     * a otros metodos.
     */
    public static void elegirclub(Club clubselecionado) {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("1.- Dar de alta un socio en el club elegido");
            System.out.println("2.- Dar de baja un socio en el club elegido");
            System.out.println("3.- Visualizar por pantalla los socios");
            System.out.println("4.- Unir club con otro");
            System.out.println("5.- Guardar en un fichero");
            System.out.println("6.- Salir");
            int usuario = entrada.nextInt();
            if (usuario >= 0 & usuario <= 6) {
                if (usuario == 1) {
                    crearsocio(clubselecionado);
                } else if (usuario == 2) {
                    eliminarsocio(clubselecionado);
                } else if (usuario == 3) {
                    clubselecionado.mostrarsocio();
                } else if (usuario == 4) {
                } else if (usuario == 5) {
                    guardarclub(clubselecionado);
                } else if (usuario == 6) {
                    break;
                }
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }

    /**
     * Pre: ---
     * Post: Como su nombre indica nos guarda un club, pero a su vez nos crea un fichero txt con el nombre del club
     * y dentro almacenara los socios pertenecientes al mismo.
     */
    public static void guardarclub(Club clubselecionado) {
        File fileSalida = new File("src/practicasegundaparte/clubes/" + clubselecionado.getNombre() + ".txt");

        try {
            Formatter salida = new Formatter(fileSalida);

            for (int x = 0; x < clubselecionado.getSocio().getSize(); x++) {
                System.out.println(clubselecionado.getSocio().get(x).getSocio());
                Socio objeto = clubselecionado.getSocio().get(x).getSocio();
                String caja = objeto.getNombre() + ";" + objeto.getPrimerapellido() +
                        ";" + objeto.getSegundoapellido() + ";" + objeto.getIncorporacion() + "\n";
                System.out.println(caja);
                salida.format(caja);

            }
            salida.flush();
            salida.close();
            System.out.println("Guardado Correctamente");
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * Pre: ---
     * Post: Lista por pantalla los clubes que tenemos ya creados para su posible seleccion o simplemente para la vista
     */
    public static void datoscarpeta(almacenar listaclub) {
        Scanner entrada = new Scanner(System.in);
        listaclub = almacenar(listaclub);
        for (int i = 0; i < listaclub.getSize(); i++) {
            System.out.println(i + " " + listaclub.get(i).getClub().getNombre());
        }
        int selecionarclub = entrada.nextInt();
        Club clubselecionado = listaclub.get(selecionarclub).getClub();
        elegirclub(clubselecionado);
    }

    /**
     * Pre: ---
     * Post: el nombre del metodo lo dice por si mismo, tras seleccionar un club nos lista sus participantes y podemos
     *       escoger cual eliminar
     */
    public static void eliminarsocio(Club clubselecionado) {
        Scanner entrada = new Scanner(System.in);
        for (int x = 0; x < clubselecionado.getSocio().getSize(); x++) {
            System.out.println(x + "" + clubselecionado.getSocio().get(x).getSocio().getNombre());
        }
        int usuario = entrada.nextInt();
        clubselecionado.getSocio().delete(usuario);
    }

    /**
     * Pre: ---
     * Post: este metodo es simple nos va pidiendo datos para la creacion de un socio en un club selecionado
     */
    public static void crearsocio(Club clubselecionado) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe tu nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Escribe tu primer apellido: ");
        String apellido1 = entrada.nextLine();
        System.out.print("Escribe tu segundo apellido: ");
        String apellido2 = entrada.nextLine();
        System.out.print("Introduce la incorporacion: ");
        String fecha = entrada.nextLine();
        Socio socio = new Socio(nombre, apellido1, apellido2, fecha);
        Node_Socio nodesocio = new Node_Socio(socio);
        clubselecionado.getSocio().add(nodesocio);
    }

    /**
     * Pre: ---
     * Post: metodo encargado de dar de alta un nuevo club y lo mandamos al metodo elegir para que se añada a
     *       la lista de clubes asi como poder rellenarlo con socios y otros parametros
     */
    public static void crearclub() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        Club clubnew = new Club(nombre);
        elegirclub(clubnew);
    }
}