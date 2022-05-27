package practicasegundaparte;


/**
 * Objeto Club con sus atributos
 */
public class Club {
    private String nombre;
    private Simplelikendlist listasocio;


    public Club(String nombre, Simplelikendlist socio) {
        super();
        this.nombre = nombre;
        this.listasocio = socio;
    }

    public Club(String nombre) {
        this.nombre = nombre;
        this.listasocio = new Simplelikendlist();
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Simplelikendlist getSocio() {
        return listasocio;
    }


    /**
     * Pre: ---
     * Post: Creamos el metodo setsocio que realmente solo selecciona el socio
     * que posteriormente vamos a eliminar
     */
    public void setSocio(Simplelikendlist socio) {
        this.listasocio = socio;
    }

    /**
     * Pre: ---
     * Post: Con este metodo podemos agregar socios a la lista de un club
     */
    public void metersocio(Node_Socio socio) {
        if (listasocio.add(socio)) {
            listasocio.show();
        }
    }

    /**
     * pre: ---
     * Post: con este metodo podemos eliminar a los usuarios por posicion
     */
    public void eliminarsocio(int position, Node_Socio socio) {
        if (listasocio.delete(0)) {
            System.out.println("Eliminado");
        } else {
            System.out.println("Socio no encontrado");
        }
    }

    /**
     * Pre: ---
     * Post: recorremos la lista y mostramos los socios por pantalla
     */
    public void mostrarsocio() {
        for (int x = 0; x < listasocio.getSize(); x++) {
            System.out.println(listasocio.get(x));
        }
    }


    @Override
    public String toString() {
        return "Nombre=" + nombre + " Socio=" + listasocio;
    }

}