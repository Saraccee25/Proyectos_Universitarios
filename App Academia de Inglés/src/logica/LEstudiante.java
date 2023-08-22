package logica;

import bean.Estudiante;
import bean.Estudiante;
import bean.EstudianteData;
import interfaces.ICrud;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LEstudiante extends Estudiante implements ICrud {

	public LEstudiante(String cedula, String nombre, LocalDate fechaNacimiento, String correo) {
		super(cedula, nombre, fechaNacimiento, correo);
	}

	public void registrarEstudiante(Estudiante x) {

		try {
			FileWriter archivo = new FileWriter("./archivos/Estudiantes.txt", true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(x.getCedula() + "," + x.getNombre() + "," + x.getCorreoElectronico() + ","
					+ x.getFechaNacimiento() + "\n");
			linea.close();
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar");
		}
	}

	public void buscarEstudiantePorCedula(String cedula) {
	    try (BufferedReader reader = new BufferedReader(new FileReader("./archivos./Estudiantes.txt"))) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            String[] datos = linea.split(",");
	            if (datos.length >= 4 && datos[0].equals(cedula)) {
	                String nombre = datos[1];
	                String correoElectronico = datos[2];
	                String fecha = datos[3];
	                
	                StringBuilder mensaje = new StringBuilder();
	                mensaje.append("Cédula: ").append(cedula).append("\n");
	                mensaje.append("Nombre: ").append(nombre).append("\n");
	                mensaje.append("Correo electrónico: ").append(correoElectronico).append("\n");
	                mensaje.append("Fecha de nacimiento: ").append(fecha);
	                
	                JOptionPane.showMessageDialog(null, mensaje.toString());
	                
	                return;
	            }
	        }
	        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con la cédula proporcionada.");
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al buscar el estudiante: " + e.getMessage());
	    }
	}



	@Override
	public boolean buscarCedula(String cedula) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./archivos/Estudiantes.txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 4 && datos[0].equals(cedula)) {
					String nombre = datos[1];
					String correoElectronico = datos[2];
					String fecha = datos[3];
					JOptionPane.showMessageDialog(null, "Cédula: " + cedula + "\nNombre: " + nombre + "\nCorreo electrónico: " + correoElectronico + "\nFecha de nacimiento: " + fecha);
					return true;
				}
			}
			JOptionPane.showMessageDialog(null, "No se encontró estudiante con la cédula proporcionada");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar el estudiante");
		}
		return false;
	}

	public boolean validarcc(String cedula) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./archivos/Estudiantes.txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 4 && datos[0].equals(cedula)) {
					String nombre = datos[1];
					String correoElectronico = datos[2];
					String fecha = datos[3];
					JOptionPane.showMessageDialog(null, "Cédula: " + cedula + "\nNombre: " + nombre + "\nCorreo electrónico: " + correoElectronico + "\nFecha de nacimiento: " + fecha);
					return true;
				}
			}
			//JOptionPane.showMessageDialog(null, "No se encontró estudiante con la cédula proporcionada");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar el estudiante");
		}
		return false;
	}

	public Estudiante buscarEstudiante(String cedula) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./archivos/Estudiantes.txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 4 && datos[0].equals(cedula)) {
					String Cedula = datos[0];
					String nombre = datos[1];
					String correoElectronico = datos[2];
					String fechaNacimientoString = datos[3];
					LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);

					return new Estudiante(Cedula, nombre, fechaNacimiento, correoElectronico);
				}
			}
			System.out.println("No se encontró un estudiante con la cédula proporcionada.");
		} catch (IOException e) {
			System.out.println("Error al buscar el estudiante: " + e.getMessage());
		}

		return null;
	}

	@Override
	public void eliminarRegistro(String cedula) {
	    boolean encontrado = false;
	    String estudianteEliminado = "";
	    try (BufferedReader reader = new BufferedReader(new FileReader("./archivos/Estudiantes.txt"))) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            String[] datos = linea.split(",");
	            if (datos.length >= 3 && datos[0].equals(cedula)) {
	                encontrado = true;
	                estudianteEliminado = linea;
	                break;
	            }
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al buscar el estudiante: " + e.getMessage());
	    }

	    if (encontrado) {
	        try {
	            File archivoOriginal = new File("./archivos/Estudiantes.txt");
	            File archivoTemp = new File("./archivos/EstudiantesTemp.txt");

	            BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp));

	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                if (!linea.equals(estudianteEliminado)) {
	                    writer.write(linea);
	                    writer.newLine();
	                }
	            }

	            writer.close();
	            reader.close();

	            if (archivoOriginal.delete()) {
	                archivoTemp.renameTo(new File("./archivos/Estudiantes.txt"));
	                JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante");
	            }
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante: " + e.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
	    }
	}


	public int calcularEdad(String cedula) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./archivos/Estudiantes.txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 4 && datos[0].equals(cedula)) {
					LocalDate fechaNacimiento = LocalDate.parse(datos[3]);
					LocalDate fechaActual = LocalDate.now();
					Period periodo = Period.between(fechaNacimiento, fechaActual);
					return periodo.getYears();
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de estudiantes: " + e.getMessage());
		}
		return -1; // Retornar un valor negativo si no se encuentra la cédula en el archivo
	}

	public void crearArchivoSerializadoMayoresEdad(String nombreArchivo) {
		List<EstudianteData> estudiantesMayoresEdad = new ArrayList<>();

		try {
			Path archivoEstudiantes = Paths.get("./archivos/Estudiantes.txt");
			List<String> lineas = Files.readAllLines(archivoEstudiantes);
			for (String linea : lineas) {
				String[] datos = linea.split(",");
				if (datos.length >= 4) {
					String nombre = datos[1];
					LocalDate fechaNacimiento = LocalDate.parse(datos[3]);
					int edad = calcularEdad(fechaNacimiento);
					if (edad >= 18) {
						estudiantesMayoresEdad.add(new EstudianteData(nombre, fechaNacimiento));
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo Estudiantes.txt: " + e.getMessage());
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
			oos.writeObject(estudiantesMayoresEdad);
			System.out.println("Archivo serializado creado exitosamente.");
		} catch (IOException e) {
			System.out.println("Error al crear el archivo serializado: " + e.getMessage());
		}
	}

	private int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaNacimiento, fechaActual).getYears();
	}

}
