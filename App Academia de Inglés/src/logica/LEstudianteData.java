package logica;

import bean.EstudianteData;
import bean.Estudiante;
import bean.EstudianteData;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.io.EOFException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LEstudianteData {
	
	public LEstudianteData() {
		
	}
    
	public void LeerArchivo() {
        try {
            FileInputStream ruta_entrada = new FileInputStream("./archivos/EstudiantesMayores.txt");
            ObjectInputStream leer_datos = new ObjectInputStream(ruta_entrada);

            ArrayList<EstudianteData> mayor = (ArrayList<EstudianteData>) leer_datos.readObject();
            leer_datos.close();

            StringBuilder cadena = new StringBuilder();

            for (int i = 0; i < mayor.size(); i++) {
                cadena.append("Nombre: ").append(mayor.get(i).getNombre())
                        .append(" Fecha de nacimiento: ").append(mayor.get(i).getFechaNacimiento())
                        .append("\n");
            }

            JOptionPane.showMessageDialog(null, cadena.toString(), "Datos Leídos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas con el acceso al archivo de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	

}
