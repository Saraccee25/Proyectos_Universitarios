package bean;

public class Curso {
	private String nivel;
    private String horario;
    private int codigo;

    public Curso(String nivel, String horario) {
        this.nivel = nivel;
        this.horario = horario;
    }

    public String getnivel() {
        return nivel;
    }

    public void setnivel(String grupo) {
        this.nivel= grupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
