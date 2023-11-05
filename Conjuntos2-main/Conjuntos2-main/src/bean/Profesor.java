
package bean;

import java.time.LocalDate;

public class Profesor {
    private String cedula;
    private String nombreCompleto;
    private String sexo;
    private String facultad;
    private String titulo;
    private int asignaturasDictadas;
    private int horasDictadasPorSemana;
    private LocalDate fechaNacimiento;
    private String tipoProfesor;

    // Constructor
    public Profesor(String cedula, String nombreCompleto, String sexo, String facultad, String titulo,
                    int asignaturasDictadas, int horasDictadasPorSemana, LocalDate fechaNacimiento, String tipoProfesor) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.facultad = facultad;
        this.titulo = titulo;
        this.asignaturasDictadas = asignaturasDictadas;
        this.horasDictadasPorSemana = horasDictadasPorSemana;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoProfesor = tipoProfesor;
    }

    public Profesor() {
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAsignaturasDictadas() {
        return asignaturasDictadas;
    }

    public void setAsignaturasDictadas(int asignaturasDictadas) {
        this.asignaturasDictadas = asignaturasDictadas;
    }

    public int getHorasDictadasPorSemana() {
        return horasDictadasPorSemana;
    }

    public void setHorasDictadasPorSemana(int horasDictadasPorSemana) {
        this.horasDictadasPorSemana = horasDictadasPorSemana;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public void setTipoProfesor(String tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }
}