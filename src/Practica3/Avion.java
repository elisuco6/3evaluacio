package Practica3;

import java.util.ArrayList;

/**
 * Pre: ---
 * Post: creamos la clase avion que contiene un id de tipo entero y un arraylist que almacenara los pasajeros
 */
public class Avion {
    private int id;
    private ArrayList<Pasajeros> listapasajerosenelavion = new ArrayList<Pasajeros>();

    //Aqui tenemos su metodo constructor
    public Avion(int id) {
        this.id = id;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Pasajeros> getListapasajerosenelavion() {
        return listapasajerosenelavion;
    }

    public void setListapasajerosenelavion(ArrayList<Pasajeros> listapasajerosenelavion) {
        this.listapasajerosenelavion = listapasajerosenelavion;
    }

    @Override
    public String toString() {
        return "Avion: " + "id=" + id;
    }

    /**
     * Pre: ---
     * Post: metodo para poder recorrer la lista y mostrar los pasajeros
     */
    public void mostrarpasajeros() {
        for (int i = 0; i< listapasajerosenelavion.size(); i++){
            System.out.println(listapasajerosenelavion.get(i).toString());
        }
    }
}