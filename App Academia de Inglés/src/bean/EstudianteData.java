
package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class EstudianteData implements Serializable {

	private String nombre;
	private LocalDate fechaNacimiento;

	public EstudianteData(String nombre, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public EstudianteData() {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

}

