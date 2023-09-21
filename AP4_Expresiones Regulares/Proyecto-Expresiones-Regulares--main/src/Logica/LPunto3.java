
package Logica;

import Bean.Punto3;
import Vista.VistaPunto3;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LPunto3 {
    
    public boolean validarCedula(String cedula) {
        String regex = "^[0-9]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cedula);
        return matcher.matches();
        
    }//CIERRE DEL METODO

    public boolean validarFecha(String fecha) {
        String regex = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
        
    }//CIERRE DEL METODO
    
    public boolean validarCategoria(String categoria) {
        String regex = "^(Docente de Cátedra|Docente Ocasional|Docente de Planta)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(categoria);
        return matcher.matches();
        
    }//CIERRE DEL METODO

    
    public void lPunto3(ArrayList<Punto3> docentes, int erroresCedula, ArrayList<Punto3> docentesSeptiembre) {
        
        VistaPunto3 vPunto3 = new VistaPunto3();
        
        int totalDocentes = docentes.size();
        int plantaCount = 0,
                ocasionalCount = 0,
                catedraCount = 0;

        for (Punto3 docente : docentes) {
            if (docente.getCategoria().equals("Docente de Planta")) {
                plantaCount++;
            } else if (docente.getCategoria().equals("Docente Ocasional")) {
                ocasionalCount++;
            } else if (docente.getCategoria().equals("Docente de Cátedra")) {
                catedraCount++;
            }
        }

        double porcentajePlanta = (double) plantaCount / totalDocentes * 100;
        double porcentajeOcasional = (double) ocasionalCount / totalDocentes * 100;
        double porcentajeCatedra = (double) catedraCount / totalDocentes * 100;
        
        vPunto3.impresion(porcentajePlanta, porcentajeOcasional, porcentajeCatedra, erroresCedula, docentesSeptiembre);

    }//CIERRE DEL METODO
    
}//CIERRE DE LA CLASE
