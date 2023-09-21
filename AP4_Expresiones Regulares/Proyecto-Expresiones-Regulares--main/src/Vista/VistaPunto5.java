package Vista;

import Bean.Punto5;
import Logica.LPunto5;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VistaPunto5 {

    public ArrayList<Punto5> vistaPunto5(ArrayList<Punto5> tCredito) {
        
        LPunto5 lPunto5 = new LPunto5();

        do {
            Punto5 tarjetaCredito = new Punto5();

            String tipo;
            do {
                tipo = JOptionPane.showInputDialog("Ingrese el tipo de tarjeta (Visa o MasterCard):");
            } while (!tipo.matches("Visa|MasterCard"));

            String numeroStr;
            do {
                numeroStr = JOptionPane.showInputDialog("Ingrese un número de 16 dígitos: ");
            } while (!numeroStr.matches("\\d{16}"));

            long numero = Long.parseLong(numeroStr);

            String fecha;
            do {
                fecha = JOptionPane.showInputDialog("Ingrese la fecha (mm/yy):");
            } while (!fecha.matches("\\d{2}/\\d{2}"));

            String nombre;
            do {
                nombre = JOptionPane.showInputDialog("Ingrese el nombre (solo mayúsculas):");
            } while (!nombre.matches("[A-Z]+"));

            String apellido;
            do {
                apellido = JOptionPane.showInputDialog("Ingrese el apellido (solo mayúsculas):");
            } while (!apellido.matches("[A-Z]+"));

            String codigoStr;
            do {
                codigoStr = JOptionPane.showInputDialog("Ingrese el código de 3 dígitos: ");
            } while (!codigoStr.matches("\\d{3}"));

            int codigo = Integer.parseInt(codigoStr);

            tarjetaCredito.setTipo(tipo);
            tarjetaCredito.setNumero(numero);
            tarjetaCredito.setFecha(fecha);
            tarjetaCredito.setNombre(nombre);
            tarjetaCredito.setApellido(apellido);
            tarjetaCredito.setCodigo(codigo);

            tCredito.add(tarjetaCredito);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otra tarjeta de crédito?", "Continuar", JOptionPane.YES_NO_OPTION);

            if (opcion != JOptionPane.YES_OPTION) {
                break;
            }

        } while (true);

        return tCredito;
        
    }//CIERRE DEL METODO
    
    public void mostrarTarjetas(String titulo, ArrayList<Punto5> tarjetas) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(titulo).append("\n");

        for (Punto5 tarjeta : tarjetas) {
            mensaje.append(tarjeta).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
