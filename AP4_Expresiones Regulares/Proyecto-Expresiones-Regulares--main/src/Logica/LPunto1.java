package Logica;

import Bean.Punto1;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class LPunto1 {

    public void añadiendoNumero(ArrayList<Punto1> arrayNumero, int cant, Punto1 numero) {
        
        if (arrayNumero.size() < cant) {
            arrayNumero.add(numero);
        }
    }//CIERRE DEL METODO

    public boolean verificarCadena(String cadena) {

        String patron = "\\d+ \\d+ \\d+";

        if (Pattern.matches(patron, cadena)) {

            String[] numeros = cadena.split(" ");
            int num1 = Integer.parseInt(numeros[0]);
            int num2 = Integer.parseInt(numeros[1]);
            int num3 = Integer.parseInt(numeros[2]);

            return num2 > num1 && num3 > num2;
        } else {
            return false;
        }
        
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
