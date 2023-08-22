package listaspoo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sara_
 */



public class ListasPoo {

    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
          int opc,d = 0, d2, nodosl2, contador, opc2;
        
        Lista L1 = new Lista(), L2 = new Lista(), L3 = new Lista();
               
        
        do{
            
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Insertar en una lista \n 2. Ordenar lista \n 3. Buscar dato \n 4. Otro... \n 5. Salir ","Menú Principal Listas ",1));
            
            
               switch(opc){
                   case 1: 
                       do{
                           
                       
                       opc2= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Insertar Inicio\n 2. Insertar Final \n 3. Insertar ordenado \n 4. Salir \n"));
                       switch (opc2){
                           case 1:
                                d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                                L1.InsertarInicio(d);
                                L1.MostrarLista();
                           break;
                           case 2:
                                d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                                L1.InsertarFinal(d);
                                L1.MostrarLista();
                                break;
                           case 3:
                               d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                               L1.InsertarOrdenado(d);
                               L1.MostrarLista();
                                break;
                           case 4: 
                               break;
                           
                        }
                       }while(opc2 !=4);
                   case 2: 
                     do{
                         
                     
                       opc2= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ordenar lista de forma ascendente\n 2. Ordenar lista de forma descendente \n 3. Salir \n"));
                       switch (opc2){
                           case 1: 
                                L1.OrdernarAscendente();
                                L1.MostrarLista();
                                break;
                           case 2:
                                L1.OrdernarDescendente();
                                L1.MostrarLista();
                                break;
                           case 3:
                               break;
                               
                       }
                     }while(opc2 != 3);
                     
                   case 3: 
                       
                      do{
                          
                      
                       opc2= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar posición \n 2. Eliminar dato \n 3. Reemplazar dato \n 4. Salir \n"));
                       switch(opc2){
                           case 1: 
                               d = Integer.parseInt(JOptionPane.showInputDialog("Inserte el dato del cual desea saber la posición"));
                               L1.MostrarPosición(d);
                               break;
                           case 2: 
                                L1.MostrarLista();
                                d= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea eliminar"));
                                L1.Eliminar(d);
                                L1.MostrarLista();
                                break;
                           case 3:
                               d= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea reemplazar"));
                               d2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato nuevo"));
                               L1.MostrarLista();
                               L1.ReemplazarDato(d,d2);
                               L1.MostrarLista();
                               break;
                           case 4:
                               break;
                            
                       }
                      }while(opc2 !=4);
                   case 4:
                       
                       do{
                           
                       
                        opc2= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar Intercalado \n 2. Distributiva \n 3. Salir "));
                        switch(opc2){
                            case 1:
                                nodosl2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de nodos para la lista 2"));
                                contador=0;
                                 while (contador < nodosl2){
                                     d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                                     L2.InsertarFinal(d);
                                     L2.MostrarLista();
                                     contador++;
                                }
               
                                JOptionPane.showMessageDialog(null, "La lista 1 es: \n");
                                L1.MostrarLista();
                                JOptionPane.showMessageDialog(null, "La lista 2 es: \n");
                                L2.MostrarLista();
                                JOptionPane.showMessageDialog(null, "Las listas intercaladas son: \n");
                                L3.Intercalado(L1, L2);
                                L3.MostrarLista();
                                break;
                            case 2: 
                                nodosl2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de nodos para la lista 2"));
                                contador=0;
                                while (contador < nodosl2){
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                                    L2.InsertarFinal(d);
                                    L2.MostrarLista();
                                    contador++;
                                }
                                JOptionPane.showMessageDialog(null, "La lista 1 es: \n");
                                L1.MostrarLista();
                                JOptionPane.showMessageDialog(null, "La lista 2 es: \n");
                                L2.MostrarLista();
                                JOptionPane.showMessageDialog(null, "Las listas multiplicadas son: \n");
                                L3.Multiplicacion(L1, L2);
                                L3.MostrarLista();
                                break;
                                
                            case 3:
                                break;
                                
                        }
                       }while(opc2!=3);
                       
                   case 5:
                       break;
                   
                       
               }
                   /*case 1 -> {
                       d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                      // System.out.println("Ingrese el dato");
                  
                       L1.InsertarInicio(d);
                       L1.MostrarLista();
                       break;
                }
                   case 2 -> {
                       d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                       L1.InsertarFinal(d);
                       L1.MostrarLista();
                       break;
                }
                   case 3 -> { 
                       d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                       L1.InsertarOrdenado(d);
                       L1.MostrarLista();
                       break;
                }
                   case 4 -> {
                       L1.OrdernarAscendente();
                       L1.MostrarLista();
                       break;
                }
                   case 5 -> {
                       L1.OrdernarDescendente();
                       L1.MostrarLista();
                       break;
                   }
                   case 6 -> {
                      d = Integer.parseInt(JOptionPane.showInputDialog("Inserte el dato del cual desea saber la posición"));
                      L1.MostrarPosición(d);
                   }
                   case 7 -> {
                       L1.MostrarLista();
                      d= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea eliminar"));
                       L1.Eliminar(d);
                       L1.MostrarLista();
                    
                       break;
                   }
                   case 8 -> {
                       d= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea reemplazar"));
                       d2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato nuevo"));
                       L1.MostrarLista();
                       L1.ReemplazarDato(d,d2);
                       L1.MostrarLista();
                   }
                   case 9 -> {
                      nodosl2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de nodos para la lista 2"));
                      contador=0;
                      while (contador < nodosl2){
                           d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                           L2.InsertarFinal(d);
                           L2.MostrarLista();
                           contador++;
                      }
               
                      JOptionPane.showMessageDialog(null, "La lista 1 es: \n");
                      L1.MostrarLista();
                      JOptionPane.showMessageDialog(null, "La lista 2 es: \n");
                      L2.MostrarLista();
                      JOptionPane.showMessageDialog(null, "Las listas intercaladas son: \n");
                      L3.Intercalado(L1, L2);
                      L3.MostrarLista();
                      break;
                   }
                   case 10 -> {
                       nodosl2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de nodos para la lista 2"));
                      contador=0;
                      while (contador < nodosl2){
                           d = Integer.parseInt(JOptionPane.showInputDialog("Insertar dato"));
                           L2.InsertarFinal(d);
                           L2.MostrarLista();
                           contador++;
                      }
                      JOptionPane.showMessageDialog(null, "La lista 1 es: \n");
                      L1.MostrarLista();
                      JOptionPane.showMessageDialog(null, "La lista 2 es: \n");
                      L2.MostrarLista();
                      JOptionPane.showMessageDialog(null, "Las listas multiplicadas son: \n");
                      L3.Multiplicacion(L1, L2);
                      L3.MostrarLista();
                   }
                   case 11 -> {
                       break;
                   }
                       
               }*/
            
        } while(opc!=11);
        
        
        
        
    }
    
    
}



    
    

