package Vista;

import Bean.Punto1;
import Logica.LPunto1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VistaPunto1 {

    ArrayList<Punto1> arrayNumero = new ArrayList<>();

    public void VistaNumero() {
        String cadena = "";
        int i = 1;
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de nodos deseada para la lista, el número debe ser un número primo "));
        while (!esPrimo(cant)) {
            JOptionPane.showMessageDialog(null, "La cantidad ingresada no es un número primo, intente de nuevo");
            cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de nodos deseada para la lista, el número debe ser un número primo "));
        }
        JOptionPane.showMessageDialog(null, "Se ha creado la lista con " + cant + "\n " + "nodos");
        while (arrayNumero.size() < cant) {
            cadena = JOptionPane.showInputDialog("Ingrese cadena de 3 números, el tercer número debe ser mayor a los dos anteriores");
            LPunto1 lnumero = new LPunto1();
            while (!lnumero.verificarCadena(cadena)) {
                JOptionPane.showMessageDialog(null, "La cadena ingresada no es válida, intente de nuevo");
                cadena = JOptionPane.showInputDialog("Ingrese cadena de 3 números, el tercer número debe ser mayor a los dos anteriores");
            }
            Punto1 numero = new Punto1();
            String numeros[] = cadena.split(" ");
            numero.setNumero1(Integer.parseInt(numeros[0]));
            numero.setNumero2(Integer.parseInt(numeros[1]));
            numero.setNumero3(Integer.parseInt(numeros[2]));
            i++;
            lnumero.añadiendoNumero(arrayNumero, cant, numero);
        }
        String resultado = concatenarPromedios(arrayNumero);
        String mensaje = "Resultado del recorrido: " + resultado;
        JOptionPane.showMessageDialog(null, mensaje);

    }//CIERRE DEL METODO

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;

    }//CIERRE DEL METODO

    private String concatenarPromedios(ArrayList<Punto1> arrayNumero) {
        int longitud = arrayNumero.size();
        int indiceCentral = longitud / 2;
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < longitud / 2; i++) {
            resultado.append(calcularPromedio(arrayNumero.get(i))).append(" ");
            resultado.append(calcularPromedio(arrayNumero.get(longitud - 1 - i))).append(" ");
        }

        if (longitud % 2 != 0) {
            resultado.append(calcularPromedio(arrayNumero.get(indiceCentral))).append(" ");
        }

        return resultado.toString();

    }//CIERRE DEL METODO

    private double calcularPromedio(Punto1 punto) {
        return (punto.getNumero1() + punto.getNumero2() + punto.getNumero3()) / 3;

    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
