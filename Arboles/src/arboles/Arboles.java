
package arboles;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Arboles {

    public static void main(String[] args) {
        
        String letras = JOptionPane.showInputDialog(null, "Ingrese un arbol: ");
        String Arbol= letras.toUpperCase();
        char vArbol[]= Arbol.toCharArray();
        Arbol arbol = new Arbol();
        int i=0;
        
        arbol.crearArbol(vArbol);
        
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Recorrer inorden ");
            System.out.println("2. Recorrer preorden ");
            System.out.println("3. Recorrer posorden ");
            System.out.println("4. Mostrar árbol ");
            System.out.println("5. Contar hojas ");
            System.out.println("6. Contar padres ");
            System.out.println("7. Insertar dato ");
            System.out.println("8. Mostrar el hermano de un dato ingresado ");
            System.out.println("9. Mostrar el nivel de un dato ingresado ");
            System.out.println("10. Mostrar la altura de un dato ingresado ");
            System.out.println("11. Mostrar los primos hermanos de un dato ingresado ");
            System.out.println("12. Mostrar los ancestros de un dato ingresado ");
            System.out.println("13. AVL ");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("");
                    arbol.Inorden(arbol.getPunta());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    arbol.Preorden(arbol.getPunta());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    arbol.Posorden(arbol.getPunta());
                    System.out.println("");
                    System.out.println("");                    
                    break;
                case 4:
                    arbol.MostrarArbol(arbol.getPunta(), i);
                    break;
                case 5:
                    int hojas = arbol.contarHojas(arbol.getPunta(), i);
                    System.out.println("El numero de hojas es: "+ hojas);
                    break;
                case 6:
                    int padres = arbol.contarPadres(arbol.getPunta(), i);
                    System.out.println("El numero de padres es: "+ padres);
                    break;
                case 7:
                    System.out.println("Ingrese el dato a insertar: ");
                    char dat = scanner.next().charAt(0);
                    boolean algo=false;
                    Nodo nPunta= arbol.insertarDato(arbol.getPunta(), dat, algo);
                    arbol.MostrarArbol(nPunta, i);
                    break;
                case 8:
                    System.out.println("Ingrese el dato a buscar hermano: ");
                    char da = scanner.next().charAt(0);
                    boolean algo1=false;
                    Nodo a= arbol.getPunta();
                    if(da>arbol.getPunta().getDato()){
                        a=arbol.getPunta().getLD();
                    }
                    else{
                        if(da<arbol.getPunta().getDato()){
                            a=arbol.getPunta().getLI();
                        }
                    }
                    
                    arbol.hermano(arbol.getPunta(), da, a, algo1);
                    break;
                case 9:
                    int nivel, j=1;
                    System.out.println("Ingrese el dato a saber el nivel: ");
                    char dato = scanner.next().charAt(0);
                    nivel = arbol.nivel(arbol.getPunta(), j, dato);
                    System.out.println("el nivel del dato ingresado es: "+ nivel);
                    break;
                case 10:
                    System.out.println("Ingrese el dato a saber la altura: ");
                    char d = scanner.next().charAt(0);
                    Nodo p = arbol.Buscar(arbol.getPunta(), d);
                    int altura = arbol.altura(p, 0);
                    System.out.println("La altura del nodo: " + altura);
                    break;

                case 11:
                    System.out.println("Ingrese el dato a buscar primos hermanos: ");
                    dato = scanner.next().charAt(0);
                    algo = false;
                    a = arbol.getPunta();
                    Nodo b = a;
                    if (dato > arbol.getPunta().getDato()) {
                        a = arbol.getPunta().getLD();
                        b = a.getLD();
                    } else {
                        if (dato < arbol.getPunta().getDato()) {
                            a = arbol.getPunta().getLI();
                            b = a.getLI();
                        }
                    }
                    
                    arbol.primosHermanos(arbol.getPunta(), dato, a, b, algo);
                    break;
                case 12:
                    System.out.println("Ingrese el dato a buscar ancestros: ");
                    dato = scanner.next().charAt(0);
                    arbol.ancestros(arbol.getPunta(), dato);
                    break;
                case 13:
                    arbol.organizararbolconvectorarbol(vArbol);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Seleccione una opción válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
        
    }//CIERRE DEL METODO
 
}//CIERRE DE LA CLASE
