package vista;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.Usuario;
import logica.LUsuario;

public class VistaUsuario {

	Scanner lectura = new Scanner(System.in);

	public void datosUsuario() {
		Usuario usuario = new Usuario();
		System.out.println("Ingrese un usuario: ");
		usuario.setUsuario(lectura.next());
		System.out.println("Ingrese una clave: ");
		usuario.setClave(lectura.next());
		LUsuario x = new LUsuario();
		boolean validar = x.buscarUsuario2(usuario.getUsuario());
		if (validar == true) {
			while (validar != false) {
				System.out.println("Usuario existente, por favor ingrese uno nuevo");
				System.out.println("Ingrese un usuario: ");
				usuario.setUsuario(lectura.next());
				System.out.println("Ingrese una clave: ");
				usuario.setClave(lectura.next());
				validar = x.buscarUsuario2(usuario.getUsuario());
			}
			System.out.print("¡Perfecto!");
			x.insertar(usuario);
		} else {
			x.insertar(usuario);
		}

	}

	public void ingresar() {

		System.out.println("Ingrese el usuario: ");
		String usuario = lectura.next();
		System.out.println("Ingrese la clave: ");
		String clave = lectura.next();
		LUsuario x = new LUsuario();
		boolean ingreso = x.verificarCredenciales(usuario, clave);
		if (ingreso == true) {
			Menu menu = new Menu();
			menu.Menusecundario();
		} else {
			System.out.println("Usuario o contraseña incorrecta.");
			System.out.println("1. Intentar de nuevo");
			System.out.print("2. Registrarme");
			int siguiente = lectura.nextInt();
			switch (siguiente) {

			case 1:
				while (ingreso != true) {
					System.out.println("Ingrese el usuario: ");
					usuario = lectura.next();
					System.out.println("Ingrese la clave: ");
					clave = lectura.next();
					ingreso = x.verificarCredenciales(usuario, clave);
					if (ingreso == true) {
						Menu menu = new Menu();
						menu.Menusecundario();
					} else {
						System.out.println("Usuario o contraseña incorrecta.");
					}
					System.out.println("1. Olvidé mi contraseña");
					int siguiente2 = lectura.nextInt();
					switch (siguiente2) {
					case 1:
						System.out.println("Ingrese el usuario: ");
						usuario = lectura.next();
						String contraseña = x.recuperarContraseña(usuario);
						System.out.println("La contraseña del usuario: " + usuario + " es " + contraseña);
						break;

					}

				}
				break;
			case 2:
				datosUsuario();
				break;
			}
		}
	}

}
