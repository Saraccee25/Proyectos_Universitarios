
package pilas.y.colas;

import javax.swing.JOptionPane;

public class PilasYColas {

    public static void main(String[] args) {
        int D, D2, Opc, N, Cont=0;
        Pila P;
        
        N = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la pila: "));
        P = new Pila(N);
                
        do{
            Opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ingresar datos. \n" 
                                                                                 + "2. Insertar ordenardo.\n"
                                                                                 + "3. Ordenar ascendente.\n"
                                                                                 + "4. Eliminar dato. \n"
                                                                                 + "5. Reemplazar. \n" 
                                                                                 + "6. Mostrar. \n"
                                                                                 + "8. Salir.", "MENÚ BUSCAR",3));

            switch (Opc){
                                case 1: D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Dato: "));
                                        P.Apilar(D);
                                    break;
                                    
                                case 2: D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Dato: "));
                                        P.ApilarOrdenado(D);
                                    break;

                                case 3: P.Mostrar();
                                        P.OrdenarAsc();
                                        P.Mostrar();
                                    break;

                                case 4: D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Dato a Eliminar: "));
                                        P.Mostrar();
                                        P.Eliminar(D);
                                        P.Mostrar();
                                    break;

                                case 5: D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que desea reemplazar: "));
                                        D2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dato: "));
                                        P.Mostrar();
                                        P.Reemplazar(D, D2);
                                        P.Mostrar();
                                    break;
                                
                                case 6: P.Mostrar();
                                    break;
                                    
                                case 7: P.Mostrar();
                                        P.OrdenarDes();
                                        P.Mostrar();
                                    break;
                                    
                                case 8: 
                                    P.Juego();
                                    break;
                                    

                                default:
                                    JOptionPane.showInternalMessageDialog(null, "Opción incorrecta.");
            }
        }while(Opc != 8);
    }
    
}
