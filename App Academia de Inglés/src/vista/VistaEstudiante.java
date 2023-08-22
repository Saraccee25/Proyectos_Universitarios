package vista;

import bean.Estudiante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import logica.LEstudiante;

public class VistaEstudiante extends Estudiante {

	public VistaEstudiante(String cedula, String nombre, LocalDate fechaNacimiento, String correo) {
		super(nombre, cedula, fechaNacimiento, correo);
	}

	Scanner lectura = new Scanner(System.in);

	public void datosEstudiante() {
		System.out.println("Ingrese cedula del estudiante: ");
		super.setCedula(lectura.next());
		LEstudiante estu = new LEstudiante(super.getCedula(), super.getNombre(), super.getFechaNacimiento(),
				super.getCorreoElectronico());
		boolean ccexiste = estu.buscarCedula(super.getCedula());
		if (ccexiste == true) {
			while (ccexiste != false) {
				System.out.println(
						"ERROR! La cedula ingresada ya pertenece a un estudiante, por favor intente de nuevo: ");
				super.setCedula(lectura.next());
				ccexiste = estu.buscarCedula(super.getCedula());				
			}
			System.out.println("Cedula registrada con exito");
		}
		System.out.println("Ingrese nombre completo del estudiante: ");
		super.setNombre(lectura.next());
		System.out.println("Ingrese correo electrónico del estudiante: ");
		super.setCorreoElectronico(lectura.next());
		System.out.println("Ingrese fecha de nacimiento del estudiante (formato: dd-MM-yyyy): ");
		String fechaNacimientoStr = lectura.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
		super.setFechaNacimiento(fechaNacimiento);
	}

	public void MenuEstudiante() {

		byte opc = 0;
		// Estudiante x = new Estudiante(super.getCedula(), super.getNombre(), null,
		// super.getCorreoElectronico());
		LEstudiante est = new LEstudiante(super.getCedula(), super.getNombre(), super.getFechaNacimiento(),
				super.getCorreoElectronico());
		do {
			System.out.println("|Menu Estudiantes|");
			System.out.println("1. Ingresar un estudiante");
			System.out.println("2. Buscar un estudiante");
			System.out.println("3. Eliminar un estudiante");
			System.out.println("4. Obtener material de estudio");
			System.out.println("0. Salir");
			opc = lectura.nextByte();

			switch (opc) {
			case 1:
				System.out.println("!Bienvenido!");
				datosEstudiante();
				Estudiante x = new Estudiante(super.getCedula(), super.getNombre(), super.getFechaNacimiento(),
						super.getCorreoElectronico());
				est.registrarEstudiante(x);
				break;
			case 2:
				System.out.println("Ingrese cedula del estudiante: ");
				String ced = lectura.next();
				est.buscarEstudiantePorCedula(ced);
				break;
			case 3:
				System.out.println("Ingrese cedula del estudiante: ");
				String ced2 = lectura.next();
				est.eliminarRegistro(ced2);
				break;
			case 4:
				VistaMaterial vista = new VistaMaterial();
				vista.VistaMaterial();
				break;

			}

		} while (opc != 0);

	}
}
