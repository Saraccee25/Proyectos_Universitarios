package logica;

import bean.Curso;
import bean.Estudiante;
import bean.EstudianteData;
import bean.Matricular;
import bean.MatricularData;
import interfaces.ICrud;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class LMatricular extends Matricular implements ICrud {
	public LMatricular(Estudiante estudiante, Curso curso) {
		super(estudiante, curso);
	}

	public void matricular() {
		try (RandomAccessFile file = new RandomAccessFile("./archivos/Matriculas.txt", "rw")) {
			int codigo = obtenerUltimoCodigoMatricula();
			long fileLength = file.length();
			file.seek(fileLength);
			String linea = codigo + " " + getEstudiante().getCedula() + " " + getCurso().getCodigo();
			file.writeBytes(linea + System.lineSeparator());
			System.out.println("Matrícula realizada con éxito.");
			System.out.println(
					"Matrícula registrada: " + "Codigo de matricula:" + " " + codigo + " " + "Identificacion: " + " "
							+ getEstudiante().getCedula() + " " + "Codigo del curso:  " + " " + getCurso().getCodigo());
			// codigoMatriculaActual++;
		} catch (IOException e) {
			System.out.println("Error al realizar la matrícula: " + e.getMessage());
		}
	}

	private int obtenerUltimoCodigoMatricula() {
		int c = 0;
		try {
			RandomAccessFile archivo = new RandomAccessFile("./archivos/Matriculas.txt", "rw");
			while (archivo.getFilePointer() < archivo.length()) {
				String linea = archivo.readLine();
				String[] partes = linea.split(" ");
				int codigo = Integer.parseInt(partes[0]);
				if (codigo > c) {
					c = codigo;
				}
			}
			archivo.close();
		} catch (IOException e) {
			// Manejo de errores
		}
		return c + 1;
	}

	public int buscarRegistroMatriculaPorCedula(String cedula) {
	    int codigoMatricula = 0;
	    try {
	        RandomAccessFile archivo = new RandomAccessFile("./archivos/Matriculas.txt", "r");
	        while (archivo.getFilePointer() < archivo.length()) {
	            String linea = archivo.readLine();
	            String[] partes = linea.split(" ");
	            int codigo = Integer.parseInt(partes[0]);
	            String cedulaActual = partes[1];
	            int codigoCurso = Integer.parseInt(partes[2]);

	            if (cedulaActual.equals(cedula)) {
	                codigoMatricula = codigo;
	                String mensaje = "Código de matrícula: " + codigo + "\n"
	                        + "Identificación: " + cedula + "\n"
	                        + "Código del curso: " + codigoCurso;
	                JOptionPane.showMessageDialog(null, mensaje);
	                break;
	            }
	        }
	        archivo.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al buscar el registro de matrícula: " + e.getMessage());
	    }

	    if (codigoMatricula == 0) {
	        JOptionPane.showMessageDialog(null, "No se encontró un registro de matrícula con la cédula proporcionada.");
	    }

	    return codigoMatricula;
	}


	public void eliminarRegistro(String cedula) {
		try {
			File inputFile = new File("./archivos/Matriculas.txt");
			File tempFile = new File("./archivos/Matriculas_temp.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(" ");
				if (datos.length >= 3 && datos[1].equals(cedula)) {
					continue;
				}
				writer.write(linea);
				writer.newLine();
			}

			writer.close();
			reader.close();

			if (inputFile.delete()) {
				tempFile.renameTo(inputFile);
				System.out.println("Matrícula eliminada con éxito.");
			} else {
				System.out.println("Error al eliminar la matrícula.");
			}
		} catch (IOException e) {
			System.out.println("Error al eliminar la matrícula: " + e.getMessage());
		}
	}
	
	public void crearArchivoSerializado(String nombreArchivo) {
		List<MatricularData> registros = new ArrayList<>();
		int cont =0;

		try {
			Path archivoMatriculas = Paths.get("./archivos/Matriculas.txt");
			List<String> lineas = Files.readAllLines(archivoMatriculas);
			for (String linea : lineas) {
				String[] datos = linea.split("");
				if (datos.length >= 3) {
					String cmatricula = datos[0];
					String cedula = datos[1];
					String ccurso = datos[2];					
					if (cont<=3) {
						registros.add(new MatricularData(Integer.parseInt(cmatricula), cedula, Integer.parseInt(ccurso)));
					}
				}
				if(cont ==3) {
					break;
				}
				cont++;
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo Estudiantes.txt: " + e.getMessage());
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
			oos.writeObject(registros);
			System.out.println("Archivo serializado creado exitosamente.");
		} catch (IOException e) {
			System.out.println("Error al crear el archivo serializado: " + e.getMessage());
		}
	}
	
	public void serializarPrimerasTresLineas(String nombreArchivo) {
		
	    List<MatricularData> registros = new ArrayList<>();
	    
	    try {
	        Path archivoMatriculas = Paths.get("./archivos/Matriculas.txt");
	        Charset charset = Charset.forName("UTF-8");
	        
	        try (BufferedReader reader = Files.newBufferedReader(archivoMatriculas, charset)) {
	            String linea;
	            int contador = 0;	            
	            while ((linea = reader.readLine()) != null && contador < 3) {
	                String[] datos = linea.split(" ");
	                String cmatricula = datos[0];
	                String cedula = datos[1];
	                String ccurso = datos[2];

	                registros.add(new MatricularData(Integer.parseInt(cmatricula), cedula, Integer.parseInt(ccurso)));

	                contador++;
	            }

	        }
	    } catch (IOException e) {
	        System.out.println("Error al leer el archivo Matriculas.txt: " + e.getMessage());
	        return;
	    }

	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
	        oos.writeObject(registros);
	        System.out.println("Archivo serializado creado exitosamente.");
	    } catch (IOException e) {
	        System.out.println("Error al crear el archivo serializado: " + e.getMessage());
	    }
	}
	
public void serializarPrimerasTresLineas2(String nombreArchivo) {
    List<MatricularData> registros = new ArrayList<>();

    try {
        RandomAccessFile archivoMatriculas = new RandomAccessFile("./archivos/Matriculas.txt", "r");

        for (int contador = 0; contador < 3; contador++) {
            String linea = archivoMatriculas.readLine();
            if (linea == null) {
                break;
            }

            int cmatricula = archivoMatriculas.readInt();
            byte[] cedulaBytes = new byte[20];
            archivoMatriculas.readFully(cedulaBytes);
            String cedula = new String(cedulaBytes, StandardCharsets.UTF_8).trim();
            int ccurso = archivoMatriculas.readInt();

            registros.add(new MatricularData(cmatricula, cedula, ccurso));
        }

        archivoMatriculas.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo Matriculas.txt: " + e.getMessage());
        return;
    }

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
        oos.writeObject(registros);
        System.out.println("Archivo serializado creado exitosamente.");
    } catch (IOException e) {
        System.out.println("Error al crear el archivo serializado: " + e.getMessage());
    }
}


	// no se utiliza
	@Override
	public boolean buscarCedula(String c) {
		return false;
	}
}
