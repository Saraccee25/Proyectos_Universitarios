
package Logica;

import Bean.Punto5;
import Vista.VistaPunto5;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LPunto5 {
    
    public void visaomaster(ArrayList<Punto5> tCredito){
        
        ArrayList<Punto5> masterCards = new ArrayList<>();
        ArrayList<Punto5> visas = new ArrayList<>();
        VistaPunto5 vPunto5 = new VistaPunto5();

        for (Punto5 tarjeta : tCredito) {
            if (tarjeta.getTipo().matches("MasterCard")) {
                masterCards.add(tarjeta);
            } else if (tarjeta.getTipo().matches("Visa")) {
                visas.add(tarjeta);
            }
        }
        
        vPunto5.mostrarTarjetas("Tarjetas MasterCard:", masterCards);
        vPunto5.mostrarTarjetas("Tarjetas Visa:", visas);
        
        String año = JOptionPane.showInputDialog("Ingrese el año que quiere filtrar: ");
        
        buscarTarjetasPorAño(año, masterCards);
        buscarTarjetasPorAño(año, visas);
        
    }//CIERRE DEL METODO
    
    public static void buscarTarjetasPorAño(String año, ArrayList<Punto5> tarjetas) {
        
        StringBuilder mensaje = new StringBuilder("Tarjetas con año '" + año + "':\n");

        for (Punto5 tarjeta : tarjetas) {
            String fecha = tarjeta.getFecha();
            if (fecha.matches(".*\\d{2}/" + año + ".*")) {
                mensaje.append(tarjeta).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
        
    }//CIERRE DEL METODO  
    
}//CIERRE DE LA CLASE
