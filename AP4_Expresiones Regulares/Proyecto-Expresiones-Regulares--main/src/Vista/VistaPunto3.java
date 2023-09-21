
package Vista;

import Bean.Punto3;
import Logica.LPunto3;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VistaPunto3 {
    
     public void vistaPunto3(ArrayList<Punto3> docentes, ArrayList<Punto3> docentesSeptiembre) {

        LPunto3 lPunto3 = new LPunto3();
        int erroresCedula = 0;

        while (true) {
            String cedula = JOptionPane.showInputDialog("Ingrese el número de cédula (sin puntos ni comas):");
            if (!lPunto3.validarCedula(cedula)) {
                erroresCedula++;
                JOptionPane.showMessageDialog(null, "Cédula incorrecta. Inténtelo de nuevo.");
                continue;
            }
            String categoria;

            do {
                categoria = JOptionPane.showInputDialog("Ingrese la categoría del docente (Docente de Planta, Docente Ocasional o Docente de Cátedra):");

                if (!lPunto3.validarCategoria(categoria)) {
                    JOptionPane.showMessageDialog(null, "Categoría incorrecta. Ingrese una categoría válida.");
                }
            } while (!lPunto3.validarCategoria(categoria));

            String fecha = JOptionPane.showInputDialog("Ingrese la fecha (dd-mm-yyyy):");

            if (!lPunto3.validarFecha(fecha)) {
                JOptionPane.showMessageDialog(null, "Fecha incorrecta. Inténtelo de nuevo.");
                continue;
            }

            Punto3 docente = new Punto3(cedula, categoria, fecha);
            docentes.add(docente);

            if (categoria.equals("Docente de Cátedra") && fecha.contains("-09-")) {
                docentesSeptiembre.add(docente);
            }

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro docente?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                break;
            }
        }//cierre del ciclo

        lPunto3.lPunto3(docentes, erroresCedula, docentesSeptiembre);
        
    }//CIERRE DEL METODO
    
    public void impresion(double porcentajePlanta, double porcentajeOcasional, double porcentajeCatedra, int erroresCedula, ArrayList<Punto3> docentesSeptiembre) {

        JOptionPane.showMessageDialog(null,
                "Porcentaje de Docentes de Planta: " + porcentajePlanta + "%\n"
                + "Porcentaje de Docentes Ocasionales: " + porcentajeOcasional + "%\n"
                + "Porcentaje de Docentes de Cátedra: " + porcentajeCatedra + "%\n"
                + "Cantidad de errores en la cédula: " + erroresCedula);

        StringBuilder docentesCatedraSeptiembre = new StringBuilder("Docentes de Cátedra con fechas en septiembre:\n");
        for (Punto3 docente : docentesSeptiembre) {
            docentesCatedraSeptiembre.append(docente.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, docentesCatedraSeptiembre.toString());
        
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
