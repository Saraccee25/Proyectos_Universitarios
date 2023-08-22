package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class MatricularData implements Serializable {

	
	int codigoMatricula;
	String cedula;
	int codigoCurso;

	public MatricularData(int codigoMatricula, String cedula, int codigoCurso) {
		this.codigoMatricula= codigoMatricula;
		this.cedula=cedula;
		this.codigoCurso=codigoCurso;
	}

	public int getCodigoMatricula() {
		return codigoMatricula;
	}

	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	

	

}
