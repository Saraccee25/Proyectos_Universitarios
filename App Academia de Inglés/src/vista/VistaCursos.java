package vista;
import bean.Curso;
import bean.Estudiante;
import java.util.Scanner;
import logica.LCurso;
import logica.LEstudiante;
import java.util.ArrayList;
import java.util.List;

public class VistaCursos extends LCurso{
	 public VistaCursos() {
	        cursos = new ArrayList<>();
	    }

	    public void MenuCursos() {
	        byte opc = 0;
	        Scanner lectura = new Scanner(System.in);
	        LCurso curso = new LCurso();

	        do {
	            System.out.println("|Menu Cursos|");
	            System.out.println("1. Listar Cursos");
	            System.out.println("2. Separar cupo en un curso");
	            System.out.println("3. Matricularme en un curso");
	            System.out.println("0. Salir");
	            opc = lectura.nextByte();

	            switch (opc) {
	                case 1:
	                    System.out.println("!Bienvenido!");
	                    super.cargarCursos();
	                    super.mostrarCursosDisponibles();
	                    break;
	                case 2:
	                    System.out.println("!Bienvenido! Aquí separas cupo en alguno de nuestros cursos");
	                    System.out.println("Ingrese cedula del estudinate: ");
	                    String cedula = lectura.next();
	                    LEstudiante lest = new LEstudiante(null, null, null, null);
	                    boolean exist = lest.buscarCedula(cedula);
	                    if (exist == false) {
	                        System.out.println("El estudiante no se encunetra registrado, por favor registrarlo primero");
	                        VistaEstudiante estu = new VistaEstudiante(null, null, null, null);
	                        estu.datosEstudiante();
	                        lest.registrarEstudiante(estu);
	                        super.cargarCursos();
	                        super.mostrarCursosDisponibles();
	                        System.out.println("Ingrese codigo del curso que le interesa: ");
	                        int codigo = lectura.nextInt();
	                        super.registrarCursos(estu.getCedula(), codigo);
	                    } else {
	                        VistaEstudiante estu = new VistaEstudiante(null, null, null, null);
	                        super.cargarCursos();
	                        super.mostrarCursosDisponibles();
	                        System.out.println("Ingrese codigo del curso que le interesa: ");
	                        int codigo = lectura.nextInt();
	                        super.registrarCursos(estu.getCedula(), codigo);
	                    }
	                    break;

	                case 3:
	                    System.out.println("!Bienvenido! Aquí te matricularas en un curso, recuerda que debes separar tu cupo primero");
	                    System.out.println("Ingrese identificación de estudiante a matricular: ");
	                    String ced = lectura.next();
	                    boolean existe = super.buscarCedula(ced);
	                    if (existe == false) {
	                        super.cargarCursos();
	                        super.cargarCursos();
	                        super.mostrarCursosDisponibles();
	                        Curso curso2 = super.elegirCursoPorCodigo();
	                        LEstudiante estudiante = new LEstudiante(null, null, null, null);
	                        Estudiante est = estudiante.buscarEstudiante(ced);
	                        VistaMatricular vm = new VistaMatricular(est, curso2);
	                        vm.MenuMatriculas();
	                    } else {
	                        Curso curso2 = super.buscarCursoPorCedula(ced);
	                        LEstudiante estudiante = new LEstudiante(null, null, null, null);
	                        Estudiante est = estudiante.buscarEstudiante(ced);
	                        VistaMatricular vm = new VistaMatricular(est, curso2);
	                        vm.MenuMatriculas();
	                    }
//	                    LEstudiante estudiante = new LEstudiante(null, null, null, null);
//	                    Estudiante est = estudiante.buscarEstudiante(ced);
//	                    VistaMatriculas vm = new VistaMatriculas(est, curso2);
//	                    vm.MenuMatriculas();

	                    break;

	            }

	        } while (opc != 0);

	    }
}
