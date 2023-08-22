package logica;

import bean.Curso;
import interfaces.ICrud;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


public class LCurso implements ICrud  {
	
	 public List<Curso> cursos;

	    public LCurso() {
	        cursos = new ArrayList<>();
	    }

	    public void cargarCursos() {
	        String archivo = "./archivos/Cursos.txt";

	        try ( BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] partes = linea.split(",");
	                if (partes.length == 3) {
	                    int codigo = Integer.parseInt(partes[0].trim());
	                    String grupo = partes[1].trim();
	                    String horario = partes[2].trim();

	                    Curso curso = new Curso(grupo, horario);
	                    curso.setCodigo(codigo);
	                    cursos.add(curso);
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }

	    public void mostrarCursosDisponibles() {
	        System.out.println("Cursos disponibles:");
	        for (Curso curso : cursos) {
	            System.out.println("Código: " + curso.getCodigo() + " | Grupo: " + curso.getnivel() + " | Horario: " + curso.getHorario());
	        }
	    }
	    
	    public void mostrarCursosDisponibles2() {
	        StringBuilder cursosDisponibles = new StringBuilder("Cursos disponibles:\n");

	        for (Curso curso : cursos) {
	            cursosDisponibles.append("Código: ").append(curso.getCodigo())
	                    .append(" | Grupo: ").append(curso.getnivel())
	                    .append(" | Horario: ").append(curso.getHorario())
	                    .append("\n");
	        }

	        JOptionPane.showMessageDialog(null, cursosDisponibles.toString(), "Cursos Disponibles", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public Curso elegirCursoPorCodigo() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese el código del curso que desea elegir: ");
	        int codigo = scanner.nextInt();

	        for (Curso curso : cursos) {
	            if (curso.getCodigo() == codigo) {
	                return curso;
	            }
	        }

	        System.out.println("No se encontró ningún curso con el código ingresado.");
	        return null;
	    }

	    public void registrarCursos(String cedula, int codigoCurso) {
	        try {
	            FileWriter archivo = new FileWriter("./archivos/Cursosregistros.txt", true);
	            BufferedWriter escribir = new BufferedWriter(archivo);
	            PrintWriter linea = new PrintWriter(escribir);
	            linea.append(cedula + "," + codigoCurso + "\n");
	            linea.close();
	            JOptionPane.showMessageDialog(null, "Registro de curso exitoso.");
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error al registrar el curso: " + e.getMessage());
	        }
	    }


	    public Curso buscarCursoPorCedula(String cedula) {
	        try ( BufferedReader reader = new BufferedReader(new FileReader("./archivos/Cursosregistros.txt"))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length >= 2 && datos[0].equals(cedula)) {
	                    int codigoCurso = Integer.parseInt(datos[1]);
	                    // Aquí puedes crear un objeto Curso y devolverlo
	                    Curso cursoEncontrado = buscarCursoPorCodigo(codigoCurso);
	                    cursoEncontrado.setCodigo(codigoCurso);
	                    return cursoEncontrado;
	                }
	            }
	            System.out.println("No se encontró un curso con la cédula proporcionada.");
	        } catch (IOException e) {
	            System.out.println("Error al buscar el curso: " + e.getMessage());
	        }
	        return null; 
	    }

	    public Curso buscarCursoPorCodigo(int codigo) {
	        try ( BufferedReader reader = new BufferedReader(new FileReader("./archivos/Cursos.txt"))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length >= 3) {
	                    int codigoCurso = Integer.parseInt(datos[0].trim());
	                    if (codigoCurso == codigo) {
	                        String nivel = datos[1].trim();
	                        String horario = datos[2].trim();
	                        return new Curso(nivel, horario);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al buscar el curso: " + e.getMessage());
	        }
	        return null; // Si no se encuentra el curso, se devuelve null
	    }

	    @Override
	    public boolean buscarCedula(String cedula){
	        try ( BufferedReader reader = new BufferedReader(new FileReader("./archivos/Cursosregistros.txt"))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length >= 2 && datos[0].equals(cedula)) {
	                    String codigoCurso = datos[1];
	                    System.out.println("Cédula: " + cedula);
	                    System.out.println("Código del curso: " + codigoCurso);
	                    return true; // Se encontró la cédula en cursos
	                }
	            }
	            System.out.println("No se encontró la cédula en cursos.");
	        } catch (IOException e) {
	            System.out.println("Error al buscar la cédula en cursos: " + e.getMessage());
	        }
	        return false; // No se encontró la cédula en cursos
	    }
	    
	    @Override
	    public void eliminarRegistro(String cedula) {
	        try {
	            File inputFile = new File("./archivos/Cursosregistros.txt");
	            File tempFile = new File("./archivos/Cursosregistros_temp.txt");

	            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	            String linea;
	            boolean encontrado = false;

	            while ((linea = reader.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length >= 2 && datos[0].equals(cedula)) {
	                    encontrado = true;
	                } else {
	                    writer.write(linea + System.lineSeparator());
	                }
	            }

	            reader.close();
	            writer.close();

	            if (encontrado) {
	                inputFile.delete();
	                tempFile.renameTo(inputFile);
	                JOptionPane.showMessageDialog(null, "El curso con la cédula " + cedula + " se eliminó exitosamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró un curso con la cédula proporcionada.");
	            }
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error al eliminar el curso: " + e.getMessage());
	        }
	    }



}

