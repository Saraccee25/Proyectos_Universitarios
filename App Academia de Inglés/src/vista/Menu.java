package vista;

import java.util.Scanner;

import bean.Curso;
import bean.Estudiante;
import logica.LCurso;
import logica.LEstudiante;
import logica.LEstudianteData;
import logica.LMatricular;
import logica.LMatricularData;

public class Menu {

	public Menu() {

	}

	Scanner lectura = new Scanner(System.in);

	public void MenuPrincipal() {

		byte opc = 0;
		do {
			System.out.println("|Aplicacion Academia de Ingles");
			System.out.println("1. Ingresar");
			System.out.println("2. Listar serializados");
			System.out.println("0. Salir");
			opc = lectura.nextByte();

			switch (opc) {
			case 1:
				Menusecundario();
				break;
			case 2:
				LMatricular uno = new LMatricular(null, null);
				uno.serializarPrimerasTresLineas2("./archivos/DatosSerializados.txt");
				LMatricularData dos = new LMatricularData(0, null, 0);
				dos.LeerArchivo();
				break;

			}

		} while (opc != 0);
	}

	public void Menusecundario() {
		byte opc = 0;
		do {
			System.out.println("|Aplicacion Academia de Ingles|");
			System.out.println("1. Estudiantes");
			System.out.println("2. Cursos");
			System.out.println("3. Matriculas");
			System.out.println("4. Consultar estudiantes mayores de edad");
			System.out.println("0. Salir");
			System.out.println("Nota: Si desea entrar a [Matriculas] debe separar un curso primero ");
			opc = lectura.nextByte();

			switch (opc) {
			case 1:
				VistaEstudiante ve = new VistaEstudiante(null, null, null, null);
				ve.MenuEstudiante();
				break;
			case 2:
				VistaCursos vc = new VistaCursos();
				vc.MenuCursos();
				break;
			case 3:
				LEstudiante x = new LEstudiante(null, null, null, null);
				System.out.println("Ingrese cedula del estudiante: ");
				String cedula = lectura.next();
				Estudiante z = x.buscarEstudiante(cedula);
				LCurso lcurso = new LCurso();
				Curso y = lcurso.buscarCursoPorCedula(cedula);
				VistaMatricular vm = new VistaMatricular(z, y);
				vm.MenuMatriculas();
				break;
			case 4:
				LEstudiante uno = new LEstudiante(null, null, null, null);
				uno.crearArchivoSerializadoMayoresEdad("./archivos/EstudiantesMayores.txt");
				LEstudianteData dos = new LEstudianteData();
				dos.LeerArchivo();
				break;
			}

		} while (opc != 0);
	}

	public void Menu1(){
    	int opc=0;
    	VistaUsuario vistau = new VistaUsuario();
    	System.out.println("|Aplicacion Academia de Ingles|");
    	System.out.println("1. Observar cursos disponibles");
    	System.out.println("2. Registrarme");
    	System.out.println("3. Ingresar");
    	System.out.println("0. Salir");
    	opc = lectura.nextInt();
    	do {
    	switch(opc) {
    	case 1:
    		LCurso x = new LCurso();
    		x.mostrarCursosDisponibles();
    		break;
    	case 2:
    		vistau.datosUsuario();
    		break;
    	case 3:
    		vistau.ingresar();
    		break;
    	}
    		
    	}while(opc!=0);
    }

}
