package interfaces;

public interface ICrud<D> {
	
	public boolean buscarCedula(String c);

	public void eliminarRegistro(String c);

}
