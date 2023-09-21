
package Logica;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class LPunto2 {

    public int buscarNumeroMayor(ArrayList<Integer> arraylistInterno) {
        
        Pattern patron = Pattern.compile("^([0-9]+)$");

        int numeroMayor = arraylistInterno.get(0);

        for (int numero : arraylistInterno) {
            
            if (numero > numeroMayor) {
                numeroMayor = numero;
            }
        }

        return numeroMayor;
        
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
