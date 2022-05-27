package Practica4;

public class Alumno {
    private String nip;
    private String apellido;
    private String nombre;

    public Alumno(String nip, String apellido, String nombre) {
        this.nip = nip;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nip: "+ nip + ", apellidos: " + apellido + ", nombre: " + nombre;
    }
}
