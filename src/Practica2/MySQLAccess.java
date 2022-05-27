package Practica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLAccess {

    /*
     * Almacenamos la conexión con nuestra bd en
     * un objeto de tipo Connection. La abrimos cuando
     * queremos empezar a operar con la BD y siempre
     * debemos cerrarla al finalizar.
     */
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    /*
     * Almacena el resultado de las consultas en un dato de
     * tipo ResultSet, que tiene sus propios métodos para trabajar
     * con las tablas y columnas.
     */
    private ResultSet resultSet = null;

    /*
     * Almacenamos los datos de conexión con nuestra BD.
     */
    final private String host = "localhost:3306/videojuego";
    final private String user = "root";
    final private String passwd = "1234";

    public void readPregunta(String nombrePregunta, int desencadenanteIzq, int desencadenanteDrch, String respuestaIzq, String respuestaDrch) throws Exception {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);
            /*
             * Cuando queremos utilizar variables para realizar las consultas y
             * además queremos hacerlas de forma más eficiente podemos usar
             * preparedStatement.
             */
            preparedStatement = connect
                    .prepareStatement("insert into preguntas(nombrePregunta, desencadenanteIzq, desencadenanteDrch" +
                            ", respuestaIzq, respuestaDrch) values (?, ?, ?, ?, ?)");
            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setString(1, nombrePregunta);
            preparedStatement.setInt(2, desencadenanteIzq);
            preparedStatement.setInt(3, desencadenanteDrch);
            preparedStatement.setString(4, respuestaIzq);
            preparedStatement.setString(5, respuestaDrch);

            //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            // mostrar query
            System.out.println("QUERY ---> insert into preguntas(nombrePregunta, desencadenanteIzq, desencadenanteDrch" +
                    ", respuestaIzq, respuestaDrch) values (?, ?, ?, ?, ?)");
            preparedStatement.executeUpdate();
            System.out.println("hecho");

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void readArma(int dañoArma, String nombreArma) throws Exception {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);
            /*
             * Cuando queremos utilizar variables para realizar las consultas y
             * además queremos hacerlas de forma más eficiente podemos usar
             * preparedStatement.
             */
            preparedStatement = connect
                    .prepareStatement("insert into arma(dañoArma, nombreArma) values (?, ?)");
            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setInt(1, dañoArma);
            preparedStatement.setString(2, nombreArma);

            //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            // mostrar query
            System.out.println("QUERY ---> insert into arma(dañoArma, nombreArma) values (?, ?)");
            preparedStatement.executeUpdate();
            System.out.println("hecho");

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void readAvatar(String nombreAvatar, int vidaAvatar) throws SQLException, ClassNotFoundException {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);
            /*
             * Cuando queremos utilizar variables para realizar las consultas y
             * además queremos hacerlas de forma más eficiente podemos usar
             * preparedStatement.
             */
            preparedStatement = connect
                    .prepareStatement("insert into avatar (nombreAvatar, vidaAvatar) values (?, ?)");
            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setString(1, nombreAvatar);
            preparedStatement.setInt(2, vidaAvatar);

            //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            // mostrar query
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void readPoder(String nombrePoder, int puntosPoder) throws SQLException, ClassNotFoundException {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);
            /*
             * Cuando queremos utilizar variables para realizar las consultas y
             * además queremos hacerlas de forma más eficiente podemos usar
             * preparedStatement.
             */
            preparedStatement = connect
                    .prepareStatement("insert into poder(nombrePoder, puntosPoder) values (?, ?)");
            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setString(1, nombrePoder);
            preparedStatement.setInt(2, puntosPoder);

            //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            // mostrar query
            System.out.println("QUERY ---> insert into poder(nombrePoder, puntosPoder) values (?, ?)");
            preparedStatement.executeUpdate();
            System.out.println("hecho");

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void readRanking(String nombreAvatar, int puntuacionFinal) throws SQLException, ClassNotFoundException {
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);
            /*
             * Cuando queremos utilizar variables para realizar las consultas y
             * además queremos hacerlas de forma más eficiente podemos usar
             * preparedStatement.
             */
            preparedStatement = connect
                    .prepareStatement("insert into Ranking(nombreAvatar, puntuacionFinal) values (?, ?)");
            /*
             * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
             * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con
             * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
             * EMPIEZAN DESDE 1!.
             */
            preparedStatement.setString(1, nombreAvatar);
            preparedStatement.setInt(2, puntuacionFinal);

            //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            // mostrar query

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public ArrayList<Poder> poder() throws SQLException {
        ArrayList<Poder> poder = new ArrayList<Poder>();
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM poder");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPoder = resultSet.getInt(1);
                String nombrePoder = resultSet.getString(2);
                int puntosPoder = resultSet.getInt(3);
                poder.add(new Poder(idPoder, nombrePoder, puntosPoder));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return poder;
    }

    public ArrayList<Arma> arma() throws SQLException {
        ArrayList<Arma> arma = new ArrayList<Arma>();
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM arma");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idArma = resultSet.getInt(1);
                int dañoArma = resultSet.getInt(2);
                String nombreArma = resultSet.getString(3);

                arma.add(new Arma(idArma, dañoArma, nombreArma));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return arma;
    }

    public ArrayList<Avatar> avatar() throws SQLException {
        ArrayList<Avatar> avatar = new ArrayList<Avatar>();
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM avatar");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idAvatar = resultSet.getInt(1);
                String nombreAvatar = resultSet.getString(2);
                int vidaAvatar = resultSet.getInt(3);

                avatar.add(new Avatar(idAvatar, nombreAvatar, vidaAvatar));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return avatar;
    }

    public ArrayList<Preguntas> pregunta() throws SQLException {
        ArrayList<Preguntas> preguntas = new ArrayList<Preguntas>();
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM preguntas");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt(1);
                String nombrePregunta = resultSet.getString(2);
                int desencadenanteIqz = resultSet.getInt(3);
                int desencadenanteDrch = resultSet.getInt(4);
                String respuestaIzq = resultSet.getString(5);
                String respuestaDrch = resultSet.getString(6);

                preguntas.add(new Preguntas(idPregunta, nombrePregunta, desencadenanteIqz, desencadenanteDrch, respuestaIzq, respuestaDrch));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return preguntas;
    }

    public ArrayList<Ranking> rankings() throws SQLException {
        ArrayList<Ranking> ranking = new ArrayList<Ranking>();
        try {
            /*
             * Cargamos el driver MySQL que hemos descargado anteriormente.
             * Cada BD tiene su propio driver, este únicamente es para
             * las BD MysSQL.
             */
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            /*
             * Establecemos la conexión con nuestra BD utilizando
             * los datos de conexión que teníamos almacenados
             * anteriormente.
             */
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + host + "?"
                            + "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM ranking");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idRanking = resultSet.getInt(1);
                String nombreAvatar = resultSet.getString(2);
                int puntuacionFinal = resultSet.getInt(3);

                ranking.add(new Ranking(idRanking, nombreAvatar, puntuacionFinal));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return ranking;
    }

    /**
     * Pre: ---
     * Post: cerramos todas las conexiones abiertas, el resultSet
     * y el statement. Si no se cierran correctamente, puede
     * ocurrir que las consultas no devuelvan el resultado esperado.
     * Además, si dejamos muchas conexiones a la BD abiertas
     * podemos llegar a saturarla y no aceptará más conexiones.
     */
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }

}