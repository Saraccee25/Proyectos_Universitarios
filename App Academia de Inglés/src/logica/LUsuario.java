package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.Usuario;

public class LUsuario {

	public void insertar(Usuario x) {

		try {
			RandomAccessFile archivo = new RandomAccessFile("./archivos/Usuario.txt", "rw");
			archivo.seek(archivo.length());

			archivo.writeBytes(x.getUsuario());
			archivo.writeBytes("\n");
			archivo.writeBytes(x.getClave());
			archivo.writeBytes("\n");
			archivo.writeBytes("\n");
		
			JOptionPane.showMessageDialog(null, "Registro exitoso");
			archivo.close();
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "El archivo no existe o no se han registrado usuarios");
		}
	}

	public ArrayList listar() {
		
		ArrayList<Usuario> listaDiscos = new ArrayList();
		try {
			RandomAccessFile archivo = new RandomAccessFile("./archivos/Usuario.txt", "r");
			archivo.seek(0);
			while (archivo.getFilePointer() < archivo.length()) {
				Usuario x = new Usuario();

				x.setUsuario(archivo.readUTF());
				x.setClave(archivo.readUTF());
				//x.setEstado(archivo.readBoolean());

				listaDiscos.add(x);
			}
		} catch (IOException e) {
			// System.out.print(e);
			System.out.print("El archivo no Existe o no se han registrado Usuarios");
		}
		return listaDiscos;

	}
	
	
	public boolean buscarUsuario2(String usuario) {
	    boolean existe = false;
	    
	    try {
	        RandomAccessFile archivo = new RandomAccessFile("./archivos/Usuario.txt", "r");
	        archivo.seek(0);
	        
	        while (archivo.getFilePointer() < archivo.length()) {
	            String usuarioArchivo = archivo.readLine();
	            
	            if (usuarioArchivo.equals(usuario)) {
	                existe = true;
	                break;
	            }
	            
	            // Salta la línea de la contraseña
	            archivo.readLine();
	        }
	        
	        archivo.close();
	    } catch (IOException e) {
	        System.out.print("El archivo no existe o no se han registrado usuarios.");
	    }
	    
	    return existe;
	}
	

	
	public boolean verificarCredenciales(String usuario, String clave) {
	    boolean existe = false;

	    try {
	        RandomAccessFile archivo = new RandomAccessFile("./archivos/Usuario.txt", "r");
	        archivo.seek(0);

	        while (archivo.getFilePointer() < archivo.length()) {
	            String usuarioArchivo = archivo.readLine();
	            String claveArchivo = archivo.readLine();
	            archivo.readLine(); // Salta la línea vacía

	            if (usuarioArchivo.equals(usuario) && claveArchivo.equals(clave)) {
	                existe = true;
	                break;
	            }
	        }

	        archivo.close();
	    } catch (IOException e) {
	        System.out.print("El archivo no existe o no se han registrado usuarios.");
	    }

	    return existe;
	}
	
	public String recuperarContraseña(String usuario) {
	    String contraseña = null;

	    try {
	        RandomAccessFile archivo = new RandomAccessFile("./archivos/Usuario.txt", "r");
	        archivo.seek(0);

	        while (archivo.getFilePointer() < archivo.length()) {
	            String usuarioArchivo = archivo.readLine();
	            String contraseñaArchivo = archivo.readLine();
	            archivo.readLine(); // Salta la línea vacía

	            if (usuarioArchivo.equals(usuario)) {
	                contraseña = contraseñaArchivo;
	                break;
	            }
	        }

	        archivo.close();
	    } catch (IOException e) {
	        System.out.print("El archivo no existe o no se han registrado usuarios.");
	    }

	    return contraseña;
	}




}
