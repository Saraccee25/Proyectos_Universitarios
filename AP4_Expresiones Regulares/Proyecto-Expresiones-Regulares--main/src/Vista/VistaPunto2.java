package Vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class VistaPunto2 {

    public void Vista2() {
        ArrayList<ArrayList<Integer>> arrayListOfArrayLists = new ArrayList<>();
        int cNodos = 0;
        int num = 3;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);

        do {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad de nodos que quiere que tenga el ArrayList principal: ");

            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                cNodos = Integer.parseInt(input);
                break; 
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        } while (true);

        for (int i = 0; i < cNodos; i++) {
            int numeroconquesecompara = 0;

            do {
                String input = JOptionPane.showInputDialog("Ingrese un número: ");

                Matcher matcher = pattern.matcher(input);

                if (matcher.matches()) {
                    numeroconquesecompara = Integer.parseInt(input);
                    break; 
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            } while (true);

            ArrayList<Integer> arraylistInterno = new ArrayList<>();
            arrayListOfArrayLists.add(arraylistInterno);

            for (int j = 0; j < num; j++) {
                int num2;
                do {
                    num2 = (int) (Math.random() * 20) + 1;
                } while (num2 >= numeroconquesecompara); 

                arraylistInterno.add(num2);
            }

            if (!arraylistInterno.isEmpty()) {
                int numMayor = Collections.max(arraylistInterno);
                JOptionPane.showMessageDialog(null, "El mayor número del ArrayList interno " + (i + 1) + " es " + numMayor);
            } else {
                JOptionPane.showMessageDialog(null, "El ArrayList interno " + (i + 1) + " está vacío.");
            }

            num += 2;
        }
        int numMayorPrincipal = obtenerNumeroMayorPrincipal(arrayListOfArrayLists);
        JOptionPane.showMessageDialog(null, "El mayor número del ArrayList principal es " + numMayorPrincipal);
        
    }//CIERRE DEL METODO
    
    public  int obtenerNumeroMayorPrincipal(ArrayList<ArrayList<Integer>> arrayListOfArrayLists) {
        
        int max = Integer.MIN_VALUE;

        for (ArrayList<Integer> arraylistInterno : arrayListOfArrayLists) {
            if (!arraylistInterno.isEmpty()) {
                int numMayor = Collections.max(arraylistInterno);
                if (numMayor > max) {
                    max = numMayor;
                }
            }
        }

        return max;
        
    }//CIERRE DEL METODO
    
} //CIERRE DE LA CLASE