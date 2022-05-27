package Practica4;

public class Asignaturas{
    private String codigo_asignatura;
    private String creditos;
    private String trimestre;
    private String tipologia;
    private String nombre;

    public Asignaturas(String codigo_asignatura, String creditos, String trimestre, String tipologia, String nombre) {
        this.codigo_asignatura = codigo_asignatura;
        this.creditos = creditos;
        this.trimestre = trimestre;
        this.tipologia = tipologia;
        this.nombre = nombre;
    }

    public String getCodigo_asignatura() {
        return codigo_asignatura;
    }

    public void setCodigo_asignatura(String codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo_asignatura + ", creditos: " + creditos + ", trimestre: " + trimestre + ", tipologia: " + tipologia + ", nombre: "+ nombre;
    }
}