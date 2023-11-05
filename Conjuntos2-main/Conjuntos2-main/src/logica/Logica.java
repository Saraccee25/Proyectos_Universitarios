package logica;

import bean.Profesor;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Logica {

    public Logica() {
    }

    public void cargarProfesoresEnArrayLists(ArrayList<Profesor> profesoresTiempoCompleto, ArrayList<Profesor> profesoresCatedra, ArrayList<Profesor> profesoresOcasional) throws ParseException {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            BufferedReader br = new BufferedReader(new FileReader("./datos/profesores.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 9) {
                    String tipoContrato = parts[8];
                    LocalDate fechaNacimiento = LocalDate.parse(parts[7], dateFormatter);
                    Profesor profesor = new Profesor(parts[0], parts[1], parts[2], parts[3], parts[4],
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), fechaNacimiento, tipoContrato);

                    // Agregar el profesor a los ArrayList correspondientes
                    if (tipoContrato.contains("Tiempo Completo")) {
                        profesoresTiempoCompleto.add(profesor);
                    }
                    if (tipoContrato.contains("Cátedra")) {
                        profesoresCatedra.add(profesor);
                    }
                    if (tipoContrato.contains("Ocasional")) {
                        profesoresOcasional.add(profesor);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//CIERRE DEL METODO

    public void ingresarNuevoProfesor(Profesor nuevoProfesor) throws ParseException {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaNacimientoFormatted = nuevoProfesor.getFechaNacimiento().format(dateFormatter); // Formatea la fecha
            PrintWriter writer = new PrintWriter(new FileWriter("./datos/profesores.txt", true));
            writer.println(nuevoProfesor.getCedula() + ", " + nuevoProfesor.getNombreCompleto() + ", " + nuevoProfesor.getSexo() + ", "
                    + nuevoProfesor.getFacultad() + ", " + nuevoProfesor.getTitulo() + ", " + nuevoProfesor.getAsignaturasDictadas() + ", "
                    + nuevoProfesor.getHorasDictadasPorSemana() + ", " + fechaNacimientoFormatted + ", " + nuevoProfesor.getTipoProfesor());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo profesor en el archivo.");
        }
        JOptionPane.showMessageDialog(null, "Nuevo profesor ingresado con éxito.");

    }//CIERRE DEL METODO

    public void CantidadSexos(ArrayList<Profesor> profesoresTiempoCompleto, ArrayList<Profesor> profesoresCatedra, ArrayList<Profesor> profesoresOcasional) {

        Set<Profesor> hombresTiempoCompleto = new HashSet<>();
        Set<Profesor> mujeresTiempoCompleto = new HashSet<>();
        Set<Profesor> hombresCatedra = new HashSet<>();
        Set<Profesor> mujeresCatedra = new HashSet<>();
        Set<Profesor> hombresOcasional = new HashSet<>();
        Set<Profesor> mujeresOcasional = new HashSet<>();

        for (Profesor profesor : profesoresTiempoCompleto) {
            if (profesor.getSexo().equalsIgnoreCase("Masculino")) {
                hombresTiempoCompleto.add(profesor);
            } else if (profesor.getSexo().equalsIgnoreCase("Femenino")) {
                mujeresTiempoCompleto.add(profesor);
            }
        }

        for (Profesor profesor : profesoresCatedra) {
            if (profesor.getSexo().equalsIgnoreCase("Masculino")) {
                hombresCatedra.add(profesor);
            } else if (profesor.getSexo().equalsIgnoreCase("Femenino")) {
                mujeresCatedra.add(profesor);
            }
        }

        for (Profesor profesor : profesoresOcasional) {
            if (profesor.getSexo().equalsIgnoreCase("Masculino")) {
                hombresOcasional.add(profesor);
            } else if (profesor.getSexo().equalsIgnoreCase("Femenino")) {
                mujeresOcasional.add(profesor);
            }
        }
        mostrarResultados("Profesores de Tiempo Completo:", hombresTiempoCompleto, mujeresTiempoCompleto);
        mostrarResultados("Profesores de Cátedra:", hombresCatedra, mujeresCatedra);
        mostrarResultados("Profesores Ocasionales:", hombresOcasional, mujeresOcasional);

    }//CIERRE DEL METODO

    public void mostrarResultados(String titulo, Set<Profesor> hombres, Set<Profesor> mujeres) {

        StringBuilder mensaje = new StringBuilder(titulo + "\n");
        mensaje.append("Hombres: ").append(hombres.size()).append("\n");
        mensaje.append("Mujeres: ").append(mujeres.size());

        JOptionPane.showMessageDialog(null, mensaje.toString());

    }//CIERRE DEL METODO

    public void CantidadFacultad(ArrayList<Profesor> profesores) {

        Set<Profesor> ingenieria = new HashSet<>();
        Set<Profesor> deportes = new HashSet<>();
        Set<Profesor> comunicacion = new HashSet<>();
        Set<Profesor> administracion = new HashSet<>();
        Set<Profesor> idiomas = new HashSet<>();
        Set<Profesor> cienciasBasicas = new HashSet<>();

        for (Profesor profesor : profesores) {
            String facultad = profesor.getFacultad();
            if (facultad.equals("Ingeniería")) {
                ingenieria.add(profesor);
            } else if (facultad.equals("Deportes")) {
                deportes.add(profesor);
            } else if (facultad.equals("Comunicación")) {
                comunicacion.add(profesor);
            } else if (facultad.equals("Administración")) {
                administracion.add(profesor);
            } else if (facultad.equals("Idiomas")) {
                idiomas.add(profesor);
            } else if (facultad.equals("Ciencias Básicas")) {
                cienciasBasicas.add(profesor);
            }
        }

        listarHashSet("Ingeniería", ingenieria);
        listarHashSet("Deportes", deportes);
        listarHashSet("Comunicación", comunicacion);
        listarHashSet("Administración", administracion);
        listarHashSet("Idiomas", idiomas);
        listarHashSet("Ciencias Básicas", cienciasBasicas);

    }//CIERRE DEL METODO

    public void listarHashSet(String nombreFacultad, Set<Profesor> facultadSet) {
        StringBuilder message = new StringBuilder("Facultad: " + nombreFacultad + "\n\n");

        for (Profesor profesor : facultadSet) {
            message.append("Cédula: ").append(profesor.getCedula()).append("\n");
            message.append("Nombre: ").append(profesor.getNombreCompleto()).append("\n");
            message.append("\n");
        }

        message.append("Cantidad de Profesores en " + nombreFacultad + ": " + facultadSet.size());

        JOptionPane.showMessageDialog(null, message.toString());

    }//CIERRE DEL METODO

    public void listarArrayList(ArrayList<Profesor> lista) {
        StringBuilder message = new StringBuilder("Lista de profesores:\n");

        for (Profesor profesor : lista) {
            message.append("Cédula: ").append(profesor.getCedula()).append("\n");
            message.append("Nombre: ").append(profesor.getNombreCompleto()).append("\n");
            message.append("Sexo: ").append(profesor.getSexo()).append("\n");
            message.append("Facultad: ").append(profesor.getFacultad()).append("\n");
            message.append("Título: ").append(profesor.getTitulo()).append("\n");
            message.append("Asignaturas Dictadas: ").append(profesor.getAsignaturasDictadas()).append("\n");
            message.append("Horas Dictadas Por Semana: ").append(profesor.getHorasDictadasPorSemana()).append("\n");
            message.append("Fecha de Nacimiento: ").append(profesor.getFechaNacimiento()).append("\n");
            message.append("Tipo de Profesor: ").append(profesor.getTipoProfesor()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        JOptionPane.showMessageDialog(null, scrollPane);

    }//CIERRE DEL METODO

    

}//CIERRE DEL LA CLASE
