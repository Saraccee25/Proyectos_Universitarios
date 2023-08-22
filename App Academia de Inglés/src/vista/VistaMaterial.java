package vista;

import java.util.Scanner;
import bean.Curso;
import logica.LCurso;
import logica.LMaterial;

public class VistaMaterial {
	
	public VistaMaterial(){
		
	}
	
	public void VistaMaterial() {
		
		Scanner lectura = new Scanner(System.in);
		
		System.out.println("Ingrese cédula del estudiante");
		String cedula = lectura.next();
		LCurso elegir = new LCurso();
		Curso curso = elegir.buscarCursoPorCedula(cedula);
		System.out.println("Curso: " + curso.getCodigo());
		LMaterial material = new LMaterial();
		String enlace = material.buscarEnlacePorCodigo(curso.getCodigo());
		System.out.println("Aquí tienes material para tu clase: " + enlace);
	
		
	}
}
