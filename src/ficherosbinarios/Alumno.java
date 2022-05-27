package ficherosbinarios;

public class Alumno {

    private int asignaturasCursadas;
    private int asignaturasAprobadas;
    private int asignaturasSuspendidas;
    private double precio;

    public Alumno(int asignaturasCursadas, int asignaturasAprobadas, int asignaturasSuspendidas, double precio) {
        this.asignaturasCursadas = asignaturasCursadas;
        this.asignaturasAprobadas = asignaturasAprobadas;
        this.asignaturasSuspendidas = asignaturasSuspendidas;
        this.precio = precio;
    }

    public int getAsignaturasCursadas() {
        return asignaturasCursadas;
    }

    public void setAsignaturasCursadas(int asignaturasCursadas) {
        this.asignaturasCursadas = asignaturasCursadas;
    }

    public int getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    public void setAsignaturasAprobadas(int asignaturasAprobadas) {
        this.asignaturasAprobadas = asignaturasAprobadas;
    }

    public int getAsignaturasSuspendidas() {
        return asignaturasSuspendidas;
    }

    public void setAsignaturasSuspendidas(int asignaturasSuspendidas) {
        this.asignaturasSuspendidas = asignaturasSuspendidas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "asignaturasCursadas=" + asignaturasCursadas +
                ", asignaturasAprobadas=" + asignaturasAprobadas +
                ", asignaturasSuspendidas=" + asignaturasSuspendidas +
                ", precio=" + precio + '}';
    }
}
