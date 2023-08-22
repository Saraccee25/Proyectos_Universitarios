package bean;

public class Material {
	private String nombre;
	private String enlace;
	private String curso;

	public Material(String nombre, String enlace, String curso) {
		this.nombre = nombre;
		this.enlace = enlace;
		this.curso = curso;
	}
	
	public Material() {
		this.nombre = nombre;
		this.enlace = enlace;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
