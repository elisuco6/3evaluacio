package Practica3;

public class Pasajeros {
    String nombre;
    String DNI;
    private Avion idAvion;

    private Pasajeros next;

    public Pasajeros(String nombre, String DNI, Avion idAvion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.idAvion = idAvion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public Avion getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Avion idAvion) {
        this.idAvion = idAvion;
    }

    public Pasajeros getNext() {
        return next;
    }

    public void setNext(Pasajeros next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Pasajero: " + "nombre='" + nombre + ", DNI='" + DNI;
    }
}