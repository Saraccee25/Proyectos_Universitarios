package bean;

public class Usuario {
	
	private String usuario;
	private String clave;

	public Usuario() {
		usuario = "";
		clave = "";
		
	}

	public Usuario(String usuario, String clave, boolean estado) {
		this.usuario = usuario;
		this.clave = clave;
	
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
}
