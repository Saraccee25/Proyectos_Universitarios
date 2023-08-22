package bean;

import java.time.LocalDate;

public class Estudiante {
	 private String nombre;
	    private String cedula;
	    private LocalDate fechaNacimiento;
	    private String correoElectronico;


	    public Estudiante(String cedula, String nombre, LocalDate fechaNacimiento, String correo) {
	        this.nombre = nombre;
	        this.cedula = cedula;
	        this.fechaNacimiento = fechaNacimiento;
	        this.correoElectronico = correo;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCedula() {
	        return cedula;
	    }

	    public LocalDate getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public String getCorreoElectronico() {
	        return correoElectronico;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setCedula(String cedula) {
	        this.cedula = cedula;
	    }

	    public void setFechaNacimiento(LocalDate fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public void setCorreoElectronico(String correoElectronico) {
	        this.correoElectronico = correoElectronico;
	    }
}
