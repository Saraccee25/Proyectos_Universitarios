
package Logica;

import Bean.Punto4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LPunto4 {
    
    public ArrayList<String> buscarCodigo(ArrayList<Punto4> arrayPunto4) {
        
        ArrayList<String> codigosRepetidos = new ArrayList<>();
        Iterator<Punto4> iterator = arrayPunto4.iterator();

        while (iterator.hasNext()) {
            Punto4 punto4 = iterator.next();
            String codigo = punto4.getCodigo();

            String patron = "(\\d)\\1";
            Pattern pattern = Pattern.compile(patron);
            Matcher matcher = pattern.matcher(codigo);

            if (matcher.find()) {
                codigosRepetidos.add(codigo);
            }
        }

        return codigosRepetidos;

    }//CIERRE DEL METODO
    
}//CIERRE DE LA CLASE