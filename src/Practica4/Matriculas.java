package Practica4;

public class Matriculas implements Comparable <Matriculas>{
    private int nip_alumno;
    private int codigo_asignaturas;

    public Matriculas(int nip_alumno, int codigo_asignaturas) {
        this.nip_alumno = nip_alumno;
        this.codigo_asignaturas = codigo_asignaturas;
    }

    public int getNip_alumno() {
        return nip_alumno;
    }

    public void setNip_alumno(int nip_alumno) {
        this.nip_alumno = nip_alumno;
    }

    public int getCodigo_asignaturas() {
        return codigo_asignaturas;
    }

    public void setCodigo_asignaturas(int codigo_asignaturas) {
        this.codigo_asignaturas = codigo_asignaturas;
    }

    @Override
    public String toString() {
        return "MATRICULAS{ "+" nip: "+nip_alumno+", codigo de asignatura: "+codigo_asignaturas+ '}';
    }

    @Override
    public int compareTo(Matriculas o) {
        if (this.getNip_alumno() < o.getNip_alumno()){
            return -1;
        }else if (this.getNip_alumno() > o.getNip_alumno()){
            return 1;
        }
        return 0;
    }
}