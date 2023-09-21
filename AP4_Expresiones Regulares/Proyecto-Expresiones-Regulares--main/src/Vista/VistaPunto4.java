package Vista;

import Bean.Punto4;
import Logica.LPunto4;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class VistaPunto4 {

    public void vistaPunto4(ArrayList<Punto4> arrayPunto4) {

        LPunto4 lPunto4 = new LPunto4();

        String regex1 = "^[A-Z][a-z]+[0-9]{3} [0-9]{3}-[0-9]{6}$";
        String regex2 = "^1[0-9]{3}[A-Z]{6}[3-9]{2}$";
        String regex4 = "^[3-9]{2}$";
        String regex3 = "^E-ISSN [0-9]{4}-[0-9]{4}$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);

        boolean continuar = true;

        while (continuar) {
            Punto4 punto4 = new Punto4();

            String numero1, numero2, codigo;
            boolean valido = false;

            do {
                numero1 = JOptionPane.showInputDialog("Ingrese un número donde la primera sea una letra mayúscula, seguida de 3 números, un espacio, 3 números, un guion y finalice con 6 números: ");
                if (pattern1.matcher(numero1).matches()) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Formato incorrecto. Debe seguir el formato especificado.");
                }
            } while (!valido);

            valido = false;

            do {
                numero2 = JOptionPane.showInputDialog("Ingrese un número que inicie con 4 números donde el primero es el 1, seguido de 6 letras en mayúscula y finalice con 2 números entre el 3 y el 9: ");
                if (pattern2.matcher(numero2).matches() && pattern4.matcher(numero2.substring(10, 12)).matches()) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Formato incorrecto. Debe seguir el formato especificado.");
                }
            } while (!valido);

            valido = false;

            do {
                codigo = JOptionPane.showInputDialog("Ingrese un código que inicie con la letra \"E\", seguida de un guion, \"ISSN\", un espacio, 4 números, un guion y finalizando con 4 números: ");
                if (pattern3.matcher(codigo).matches()) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Formato incorrecto. Debe seguir el formato especificado.");
                }
            } while (!valido);

            punto4.setNumero1(numero1);
            punto4.setNumero2(numero2);
            punto4.setCodigo(codigo);

            arrayPunto4.add(punto4);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar más información?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }
        
        lPunto4.buscarCodigo(arrayPunto4);
        
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
