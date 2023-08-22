package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class LMaterial {

	
	public String buscarEnlacePorCodigo(int codigoClase) {
	    String enlace = null;

	    try {
	        BufferedReader archivo = new BufferedReader(new FileReader("./archivos/Material.txt"));

	        String linea;
	        while ((linea = archivo.readLine()) != null) {
	            //System.out.println(linea); 

	            String[] partes = linea.split(" ");
	            if (partes.length >= 2 && Integer.parseInt(partes[0]) == codigoClase) {
	                enlace = partes[1];
	                break;
	            }
	        }

	        archivo.close();
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(null, "Error al leer el archivo de materiales.");

	    }

	    return enlace;
	}



}
