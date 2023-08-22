package vista;

import bean.Curso;
import bean.Estudiante;
import logica.LMatricular;
import java.util.Scanner;
import logica.LCurso;
import logica.LEstudiante;

public class VistaMatricular extends LMatricular {
	public VistaMatricular(Estudiante estudiante, Curso curso) {
		super(estudiante, curso);
	}

	public void MenuMatriculas() {
		byte opc = 0;
		Scanner lectura = new Scanner(System.in);

		do {
			System.out.println("|Menu Matriculas|");
			System.out.println("1. Continuar con mi matricula");
			System.out.println("2. Consultar matricula");
			System.out.println("3. Cancelar matricula");
			System.out.println("0. Salir");
			opc = lectura.nextByte();

			switch (opc) {
			case 1:
				System.out.println("!Bienvenido!");
				try {
					super.matricular();
				} catch (Exception e) {
					System.out.println("Por favor registrese en un curso antes de realizar la matricula");
				}
				break;
			case 2:
				System.out.println("!Bienvenido!");
				try {
					// System.out.println("Ingrese cedula del estudiante matriculado: ");
					String ced = super.getEstudiante().getCedula();
					super.buscarRegistroMatriculaPorCedula(ced);
				} catch (Exception e) {
					System.out.println("Asegurese de estar matriculado");
				}
				break;
			case 3:
				LEstudiante e = new LEstudiante(null, null, null, null);
				boolean encontrado = e.buscarCedula(super.getEstudiante().getCedula());
				if (encontrado == true) {
					System.out.println("Estos fueron los datos del estudiante encontrado.");
					System.out.println("¿Desea continuar con la cancelacion de matricula?");
					System.out.println("1. Si");
					System.out.println("2. No");
					byte res = lectura.nextByte();
					while (res != 1 && res != 2) {
						System.out.println("Opcion incorrecta, seleccione 1 o 2 por favor");
						res = lectura.nextByte();
					}
					if (res == 1) {
						super.eliminarRegistro(super.getEstudiante().getCedula());
						e.eliminarRegistro(super.getEstudiante().getCedula());
						LCurso c = new LCurso();
						c.eliminarRegistro(super.getEstudiante().getCorreoElectronico());
						System.out.println("Proceso finalizado");
					} else {
						System.out.println("La matrícula sigue vigente");
					}
				}
				break;

			}

		} while (opc != 0);

	}

}
