package bean;

public class Matricular {
	 private Estudiante estudiante;
	    private Curso curso;
	    private int codigo;

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }
	    
	    public Matricular(Estudiante estudiante,Curso curso ){
	        this.curso=curso;
	        this.estudiante=estudiante;
	    }
	    public Estudiante getEstudiante() {
	        return estudiante;
	    }

	    public void setEstudiante(Estudiante estudiante) {
	        this.estudiante = estudiante;
	    }

	    public Curso getCurso() {
	        return curso;
	    }

	    public void setCurso(Curso curso) {
	        this.curso = curso;
	    }

}
