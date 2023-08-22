package logica;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.EstudianteData;
import bean.MatricularData;

public class LMatricularData extends MatricularData{

	public LMatricularData(int codigoMatricula, String cedula, int codigoCurso) {
		super(codigoMatricula, cedula, codigoCurso);
	
	}
	
	  public void LeerArchivo() {
	        try {
	            FileInputStream ruta_entrada = new FileInputStream("./archivos/DatosSerializados.txt");
	            ObjectInputStream leer_datos = new ObjectInputStream(ruta_entrada);

	            ArrayList<MatricularData> mayor = (ArrayList<MatricularData>) leer_datos.readObject();
	            leer_datos.close();

	            StringBuilder cadena = new StringBuilder();

	            for (int i = 0; i < mayor.size(); i++) {
	                cadena.append("Codigo matricula: ").append(mayor.get(i).getCodigoMatricula())
	                        .append(" Cedula: ").append(mayor.get(i).getCedula())
	                        .append(" Curso: ").append(mayor.get(i).getCodigoCurso())
	                        .append("\n");
	            }

	            JOptionPane.showMessageDialog(null, cadena.toString(), "Datos Leídos", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Problemas con el acceso al archivo de datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

}
