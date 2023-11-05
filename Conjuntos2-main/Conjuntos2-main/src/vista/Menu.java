package vista;

import bean.Profesor;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logica.Logica;

public class Menu {

    ArrayList<Profesor> profesoresTiempoCompleto = new ArrayList<>();
    ArrayList<Profesor> profesoresCatedra = new ArrayList<>();
    ArrayList<Profesor> profesoresOcasional = new ArrayList<>();

    public void menu() throws ParseException {

        Logica logica = new Logica();

        logica.cargarProfesoresEnArrayLists(profesoresTiempoCompleto, profesoresCatedra, profesoresOcasional);

        ArrayList<Profesor> profesores = new ArrayList<>();
        HashSet<Profesor> profesoresSet = new HashSet<>();
        profesoresSet.addAll(profesoresTiempoCompleto);
        profesoresSet.addAll(profesoresCatedra);
        profesoresSet.addAll(profesoresOcasional);
        profesores.addAll(profesoresSet);

        while (true) {

            String opcion = JOptionPane.showInputDialog(
                    "Menú de Profesores\n"
                    + "1. Listar y contar los profesores de tiempo completo solamente\n"
                    + "2. Listar y contar los profesores de cátedra solamente\n"
                    + "3. Listar y contar los profesores ocasionales solamente\n"
                    + "4. Listar y contar el total de profesores\n"
                    + "5. Listar y contar los profesores de tiempo completo y cátedra\n"
                    + "6. Listar y contar los profesores ocasionales y cátedra\n"
                    + "7. Listar y contar profesores que tengan las 3 condiciones (cátedra, completo y ocasional)\n"
                    + "8. Cantidad de hombres y mujeres por cada tipo de contrato\n"
                    + "9. Listar y contar profesores por facultad\n"
                    + "10. Listar y contar profesores de tiempo completo y ocasional\n"
                    + "11. Ingresar un nuevo profesor\n"
                    + "0. Salir\n"
                    + "Seleccione una opción:"
            );

            switch (opcion) {
                case "1":
                    ArrayList<Profesor> profesoresTiempoCompletoCopia = new ArrayList<>(profesoresTiempoCompleto);
                    profesoresTiempoCompletoCopia.removeAll(profesoresCatedra);
                    profesoresTiempoCompletoCopia.removeAll(profesoresOcasional);
                    logica.listarArrayList(profesoresTiempoCompletoCopia);
                    String message1 = "\nNúmero de profesores de Tiempo Completo que no están en Cátedra ni en Ocasional: " + profesoresTiempoCompletoCopia.size();
                    JOptionPane.showMessageDialog(null, message1);
                    break;
                case "2":
                    ArrayList<Profesor> profesoresCatedraCopia = new ArrayList<>(profesoresCatedra);
                    profesoresCatedraCopia.removeAll(profesoresTiempoCompleto);
                    profesoresCatedraCopia.removeAll(profesoresOcasional);
                    logica.listarArrayList(profesoresCatedraCopia);
                    String message2 = "\nNúmero de profesores de Cátedra que no están en Tiempo Completo ni en Ocasional: " + profesoresCatedraCopia.size();
                    JOptionPane.showMessageDialog(null, message2);
                    break;
                case "3":
                    ArrayList<Profesor> profesoresOcasionalCopia = new ArrayList<>(profesoresOcasional);
                    profesoresOcasionalCopia.removeAll(profesoresCatedra);
                    profesoresOcasionalCopia.removeAll(profesoresTiempoCompleto);
                    logica.listarArrayList(profesoresOcasionalCopia);
                    String message3 = "\nNúmero de profesores de Ocasional que no están en Cátedra ni en Tiempo Completo: " + profesoresOcasionalCopia.size();
                    JOptionPane.showMessageDialog(null, message3);
                    break;
                case "4":
                    logica.listarArrayList(profesores);
                    String message4 = "\nNúmero total de profesores: " + profesores.size();
                    JOptionPane.showMessageDialog(null, message4);
                    break;
                case "5":
                    profesoresTiempoCompleto.retainAll(profesoresCatedra);
                    logica.listarArrayList(profesoresTiempoCompleto);
                    String message5 = "\nNúmero total de profesores de tiempo completo y a la vez de cátedra: " + profesoresTiempoCompleto.size();
                    JOptionPane.showMessageDialog(null, message5);
                    break;
                case "6":
                    profesoresOcasional.retainAll(profesoresCatedra);
                    logica.listarArrayList(profesoresOcasional);
                    String message6 = "\nNúmero total de profesores ocasionales y a la vez de cátedra: " + profesoresOcasional.size();
                    JOptionPane.showMessageDialog(null, message6);
                    break;
                case "7":
                    profesoresTiempoCompleto.retainAll(profesoresCatedra);
                    profesoresTiempoCompleto.retainAll(profesoresOcasional);
                    logica.listarArrayList(profesoresTiempoCompleto);
                    String message7 = "\nNúmero total de profesores que tienen los 3 tipos de contrato: " + profesoresTiempoCompleto.size();
                    JOptionPane.showMessageDialog(null, message7);
                    break;
                case "8":
                    logica.CantidadSexos(profesoresTiempoCompleto, profesoresCatedra, profesoresOcasional);
                    break;
                case "9":
                    logica.CantidadFacultad(profesores);
                    break;
                case "10":
                    profesoresTiempoCompleto.retainAll(profesoresOcasional);
                    logica.listarArrayList(profesoresTiempoCompleto);
                    String message8 = "\nNúmero total de profesores de tiempo completo y ocasionales: " + profesoresTiempoCompleto.size();
                    JOptionPane.showMessageDialog(null, message8);
                    break;
                case "11":
                    Profesor profe =validarProfesor();
                    logica.ingresarNuevoProfesor(profe);
                    break;
                case "0":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }

        }//CIERRE DEL MENU

    }//CIERRE DEL METODO

    private Profesor validarProfesor() throws ParseException {
        String cedula;
        String nombreCompleto;
        String sexo;
        String facultad;
        String titulo;
        int asignaturasDictadas;
        int horasDictadasPorSemana;
        String tipoProfesor;

        // Validacion cedula
        do {
            cedula = JOptionPane.showInputDialog("Ingrese la cédula del profesor:");
        } while (!cedula.matches("\\d{8,}"));

        // Validacion nombre
        do {
            nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del profesor:");
        } while (!nombreCompleto.matches("^[a-zA-Z ]+$"));

        // Validacion sexo
        sexo = (String) JOptionPane.showInputDialog(null, "Seleccione el sexo del profesor:",
                "Sexo", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Masculino", "Femenino"}, "Masculino");

        // Validacin facultad
        facultad = (String) JOptionPane.showInputDialog(null, "Seleccione la facultad del profesor:",
                "Facultad", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Ingeniería", "Deportes", "Comunicación", "Administración", "Idiomas", "Ciencias Básicas"}, "Ingeniería");

        // Validacion titulo
        titulo = (String) JOptionPane.showInputDialog(null, "Seleccione el título del profesor:",
                "Título", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Pregrado", "Especialista", "Maestría", "Doctorado"}, "Pregrado");

        // asignaturas dictadas
        do {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad de asignaturas que dicta:");
            if (input.matches("^(?:[1-9]|10)$")) {
                asignaturasDictadas = Integer.parseInt(input);
                break;
            }
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido en el rango de 1 a 10.");
        } while (true);

        // horas dictadas por semana
        do {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad de horas dictadas por semana:");
            if (input.matches("^(?:[1-9]|1[0-9]|20)$")) {
                horasDictadasPorSemana = Integer.parseInt(input);
                break;
            }
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido en el rango de 1 a 20.");
        } while (true);

        // fecha
        String fechaNacimientoStr;
        LocalDate fechaNacimiento = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            fechaNacimientoStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (formato: dd/MM/yyyy):");
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, dateFormatter);
            } catch (DateTimeParseException e) {
                fechaNacimiento = null;
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida. Debe tener el formato dd/MM/yyyy.");
            }
        } while (fechaNacimiento == null);

        JOptionPane.showMessageDialog(null, "La fecha de nacimiento es válida: " + fechaNacimiento.format(dateFormatter));

        // tipo de profesor
        tipoProfesor = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de contrato:",
                "Contrato", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Tiempo Completo", "Cátedra", "Ocasional", "Tiempo Completo-Cátedra", "Ocasional-Cátedra", "Tiempo Completo-Ocasional", "Tiempo Completo-Cátedra-Ocasional"}, "Tiempo Completo");

        Profesor nuevoProfesor = new Profesor(cedula, nombreCompleto, sexo, facultad, titulo,
                asignaturasDictadas, horasDictadasPorSemana, fechaNacimiento, tipoProfesor);

        if (nuevoProfesor.getTipoProfesor().contains("Tiempo Completo")) {
            profesoresTiempoCompleto.add(nuevoProfesor);
        }
        if (nuevoProfesor.getTipoProfesor().contains("Cátedra")) {
            profesoresCatedra.add(nuevoProfesor);
        }
        if (nuevoProfesor.getTipoProfesor().contains("Ocasional")) {
            profesoresOcasional.add(nuevoProfesor);
        }

        return nuevoProfesor;

    }//CIERRE DEL METODO
    

}//CIERRE DE LA CLASE