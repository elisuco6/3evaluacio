package Practica2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        ArrayList<Poder> poder = dao.poder();
        ArrayList<Arma> arma = dao.arma();
        ArrayList<Avatar> avatar = dao.avatar();
        ArrayList<Preguntas> preguntas = dao.pregunta();
        ArrayList<Ranking> ranking = dao.rankings();

        menuGeneral(dao, poder, arma, avatar, preguntas, ranking);
    }

    public static void menuGeneral(MySQLAccess dao, ArrayList<Poder> poder, ArrayList<Arma> arma, ArrayList<Avatar> avatar,
                                   ArrayList<Preguntas> preguntas, ArrayList<Ranking> ranking) throws Exception {

        Scanner entrada = new Scanner(System.in);
        System.out.println("+------------  Menu  ------------+");
        System.out.println("+----------- 1- Jugar -----------+");
        System.out.println("+-------- 2- Añadir Datos -------+");
        System.out.println("+---------- 3- Ranking ----------+");
        int n = entrada.nextInt();
        if (n == 1) {
            partida(dao, poder, arma, avatar, preguntas, ranking);
        } else if (n == 2) {
            menuDatos(dao);
        }else if (n==3){
            for (int i=0;i<ranking.size();i++){
                System.out.println(ranking.get(i));
            }
        }
    }

    public static void partida(MySQLAccess dao, ArrayList<Poder> poder, ArrayList<Arma> arma, ArrayList<Avatar> avatar,
                               ArrayList<Preguntas> preguntas, ArrayList<Ranking> ranking) throws SQLException, ClassNotFoundException {
        ArrayList<Ranking> guardado = new ArrayList<Ranking>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("----------- selecciona jugador -----------");
        for (int i = 0; i < avatar.size(); i++) {
            System.out.println(avatar.get(i));
        }
        int selectoravatar = entrada.nextInt();
        avatar.get(selectoravatar - 1);
        int vidactual = avatar.get(selectoravatar - 1).getVidaAvatar();
        String nombreAvatarJugando = avatar.get(selectoravatar - 1).getNombreAvatar();
        System.out.println("Avatar seleccionado: " + avatar.get(selectoravatar - 1));

        System.out.println("----------- selecciona Arma -----------");
        for (int i = 0; i < arma.size(); i++) {
            System.out.println(arma.get(i));
        }
        int selectorarma = entrada.nextInt();
        arma.get(selectorarma - 1);
        System.out.println("Arma seleccionada: " + arma.get(selectorarma - 1));

        System.out.println("----------- selecciona Poder -----------");
        for (int i = 0; i < poder.size(); i++) {
            System.out.println(poder.get(i));
        }
        int selectorpoder = entrada.nextInt();
        poder.get(selectorpoder - 1);
        System.out.println("Poder seleccionado: " + poder.get(selectorpoder - 1));
        System.out.println("JUGUEMOS");

        boolean perder = false;
        for (int i = 0; i < preguntas.size(); i++) {
            if (vidactual <= 0){
                perder = true;
                break;
            }
            if (i == 0) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Te levantaste y empeoraste tus heridas");
                    System.out.println(vidactual + "-" + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Te inspeccionaste y te curaste");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 1) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    if (arma.get(selectorarma).getDañoArma() >= preguntas.get(i).getDesencadenanteIqz()) {
                        System.out.println("Derrotaste al caiman y avanzaste.");
                        System.out.println("Vida: " + vidactual);
                    } else {
                        System.out.println("Tu arma tiene poco daño!");
                        System.out.println("El caiman te ha mordido y te fuiste corriendo.");
                        System.out.println("-" + preguntas.get(i).getDesencadenanteDrch());
                        vidactual = vidactual - preguntas.get(i).getDesencadenanteDrch();
                        System.out.println("Vida: " + vidactual);
                    }
                } else {
                    System.out.println("Te fuiste corriendo y seguiste tu camino.");
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 2) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Es un cofre trampa, te hiciste daño.");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Rompiste el cofre trampa y te recuperaste de tus heridas.");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 3) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Vamoos, el liquido era regenerativo");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Ouch te has cortado al romperlo");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 4) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Bien le tenemos, vamos a atacarle...");
                    System.out.println("le atacas al brujo con " + arma.get(selectorarma).getNombreArma() +
                            " Fuerza ataque: " + arma.get(selectorarma).getDañoArma());
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("El brujo te lanza un bola de fuego y te alcanza");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 5) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Continuas tu camino sin saber que podria haber pasado al hablarle");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Al hablarle te da un camino mejor y unas bendas para las heridas");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 6) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Aceptaste y le has pillado amañando los dados");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Lo rechazaste asi que debes pagar con vida para avanzar");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 7) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("No ha sido muy buena idea, te has resfriado");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("Hiciste lo correcto, aunque estas algo agotado");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 8) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Woooow, este es el momento adecuado para hacerlo");
                    System.out.println("invocoooo aaaaaa: " + poder.get(selectorpoder).getNombrePoder());
                    System.out.println("El poder lo hizo cenizas, no se si eso es muy bueno :(");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("pfff a por elloooo");
                    System.out.println("Disfruta mi: " + arma.get(selectorarma).getNombreArma());
                    System.out.println("No es el momento de que se rompaaa nooooo");
                    System.out.println("Ese fenix te ha dejado tocado");
                    System.out.println(vidactual + " - " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual - preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            } else if (i == 9) {
                System.out.println(preguntas.get(i).getNombrePregunta());
                System.out.println("Por suerte");
                System.out.println("1.- " + preguntas.get(i).getRespuestaIzq());
                System.out.println("2.- " + preguntas.get(i).getRespuestaDrch());
                int opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println("Ya vale por hoy");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteIqz());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteIqz();
                    System.out.println("Vida: " + vidactual);
                } else {
                    System.out.println("ya vale por hoy");
                    System.out.println(vidactual + " + " + preguntas.get(i).getDesencadenanteDrch());
                    vidactual = vidactual + preguntas.get(i).getDesencadenanteDrch();
                    System.out.println("Vida: " + vidactual);
                }
            }
        }

        if (perder){
            System.out.println("¡Vayaaa has ido al Valhalla a ver si ahi te va mejor!");
        }

        dao.readRanking(nombreAvatarJugando, vidactual);
        for (int r = 0; r < ranking.size(); r++) {
            System.out.println(ranking.get(r));
        }

    }

    public static void menuDatos(MySQLAccess dao) throws Exception {

        Scanner entrada = new Scanner(System.in);
        System.out.println("+-------- 1- Añadir Arma --------+");
        System.out.println("+-------- 2- Añadir Avatar ------+");
        System.out.println("+-------- 3- Añadir Poder -------+");
        int n = entrada.nextInt();

        if (n == 1) {
            System.out.println("Introduzca nombre del arma: ");
            String nombreArma = entrada.next();
            System.out.println("Introduzca daño arma: ");
            int daño = entrada.nextInt();
            //Añadimos a la base de datos el arma
            dao.readArma(daño, nombreArma);
            System.out.println("Arma añadida correctamente");

        }
        if (n == 2) {
            System.out.println("Nombre del avatar: ");
            String nombreAvatar = entrada.next();
            System.out.println("vida del avatar: ");
            int vidaAvatar = entrada.nextInt();
            dao.readAvatar(nombreAvatar, vidaAvatar);
            System.out.println("Avatar añadido correctamente");

        }
        if (n == 3) {
            System.out.println("Nombre del poder: ");
            String nombrePoder = entrada.next();
            System.out.println("Puntos del poder: ");
            int puntosPoder = entrada.nextInt();
            dao.readPoder(nombrePoder, puntosPoder);
            System.out.println("Poder añadido correctamente");
        }
    }
}