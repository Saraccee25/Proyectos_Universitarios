/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.polinomiosfinal;

import Clases.PF1;
import Clases.PF2;
import Clases.PF3;
import Clases.Nodo;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

        
public class PolinomiosFinal {
    
    static int tam;
    static String polinomio = "";
    static String vecTrans[];
   
 public static void main(String[] args) {
       // Scanner leer = new Scanner(System.in);
        
         //System.out.println("Ingrese el polinomio: ");
         // polinomio = leer.nextLine();
         polinomio = JOptionPane.showInputDialog(null, "Ingrese el polinomio:","Polinomio",-1);
         validaciones(polinomio);
        
int op = 0,opcF = 0;


do{
    op = Menu();
    //opcF = MenuOpci();
    
    switch(op){
       
        case 1: 
            
            PF1 Polif1 = new PF1(tam+3);
            Polif1.Convertir(vecTrans);
            
            do{
                
            
            opcF = MenuOpci();
             
            
             switch(opcF){
                 
                 case 1: //Insertar  
                     
                     break;
                 case 2: //Eliminar
                     break;
                 case 3: //Reconstruccion
                     Polif1.Reconstruir();
                     break;
                 case 4: //Evaluacion con la x
                     Polif1.cambiox();
                     break;
                 case 5: //suma de los polinomios de la misma forma 
                     
                     
                     Polif1.sumapol();
                     /*
                     String polinomioSum = JOptionPane.showInputDialog(null, "Ingrese un nuevo polinomio:","Polinomio Nuevo",-1);
                            validaciones(polinomioSum);
                              PF1 PoliSumaf1 = new PF1(tam+8);
                              Polif1.Convertir(polinomioSum)
                     */
                        
                     break;
                 case 6: //multiplicacion de los polinomios de la misma forma 
                     Polif1.multipol();
                     break;
                 default:
                      JOptionPane.showMessageDialog(null, "Saliendo...","Opciones",-1);
                     break;
                   
             }
            }while(opcF!=7); // fin de l while de la forma 1
             break;
             
            
        case 2:
                PF2 Polif2 = new PF2(tam+3);
                Polif2.Convertir(vecTrans);
                
              do{  
              opcF = MenuOpci();
               
               
               switch(opcF){
                   
                   case 1: //suma 
                     
                     break;
                 case 2: //multiplicacion
                     break;
                 case 3: //Reconstruccion
                     Polif2.Reconstruir();
                     break;
                 case 4: //Evaluacion con x 
                     Polif2.cambiox();
                     break;
                 case 5: //suma de los polinomios de la misma forma 
                     
                     break;
                 case 6: //multiplicacion de los polinomios de la misma forma 
                     break;
                 default:
                      JOptionPane.showMessageDialog(null, "Saliendo...","Opciones",-1);
                     break;
             
             }
          }while(opcF!=7); // fin del while de la forma 2
            
            break;
            
        case 3:
              opcF = MenuOpci();
               
               
              do{
               switch(opcF){
                   case 1: //suma 
                     
                     break;
                 case 2: //multiplicacion
                     break;
                 case 3:
                     break;
                 case 4:
                     break;
                 case 5: //suma de los polinomios de la misma forma 
                     break;
                 case 6: //multiplicacion de los polinomios de la misma forma 
                     break;
                 default:
                      JOptionPane.showMessageDialog(null, "Saliendo...","Opciones",-1);
                     break;
             
             }
          }while(opcF!=7); // fin del while de la forma 3 
            
               
            break;
      
        default:
            JOptionPane.showMessageDialog(null, "Saliendo...","Opciones",-1);
    }
}while(op!=4);

    }
    
     public static int Menu() //Menu principal
         
{
     int opc = 0;
     opc = Integer.parseInt(JOptionPane.showInputDialog(null,"*** MENU ***"+
                                 "\n1. Ingresar Forma 1"+
                                 "\n2. Ingresar Forma 2"+
                                 "\n3. Ingresar Forma 3"+
                                 "\n4. Salir "+
                                 "\n\n Por favor, ingrese la opcion: ","Opciones",-1));
     return opc;
                                 
 }


      public static int MenuOpci() //Menu de las formas 
        {
            int opc = 0;
         opc = Integer.parseInt(JOptionPane.showInputDialog(null,"*** MENU DE LAS FORMAS ***"+
                                                            "\n1. Sumar"+ 
                                                "\n2. Multiplicar"+ 
                                                "\n3. Recordar polinomio (reconstruir) "+
                                                "\n4. Evaluar cambiando el valor de la x"+
                                                "\n5. Sumar con otro polinomio (DE LA MISMA FORMA)"+
                                                "\n6. Multiplicar con otro polinomio (DE LA MISMA FORMA)"+
                                                "\n7. Salir "+
                                                "\n\nIngrese la opcion:","Opciones",-1 ));
                return opc;
        }
      
       public static void validaciones(String pol){
     
      int j = 0; 
///    Scanner leer = new Scanner(System.in);
       String s = "";
      // String cadena = "2x+2";
      char vc[] = pol.toCharArray();
      tam = vc.length;
      String vecString[] = new String[tam]; //----------------> aqui se asigna el valor del tamaño del vector vc (vector cadena ) al vectorString para que tenga el mismo tamaño
      vecTrans = new String[tam];
       
     for (int i = 0; i < vc.length; i++) {
            vecTrans = vecString; //Aquí igualo el String global con el String local
            if(vc[i] == '+' ){
                
            }
            else {
                
                if(vc[i] == '-'){
                    s = "-";
                }
                else{
                    
                    if (i+1 == vc.length && Character.isDigit(vc[i]) && j % 2 == 0) {
                             s+= vc[i];
                        vecString[j] = s;
                        s="";
                        j++;
                        s="0";
                        vecString[j] = s;
                        s = "";
                        j++;
                      
                    }
                    else
                    {
                         if(i+1 == vc.length && Character.isDigit(vc[i]) && j % 2 == 1){
                               s+= vc[i];
                            vecString[j] = s;
                            s="";
                            j++;
                        
                         }
                         else 
                         {
                         
                         if((vc[i+1] == '+' || vc[i+1] == '-') && Character.isDigit(vc[i]) && j % 2 == 0){
                               s += vc[i];
                        vecString[j] = s;
                        s = "0";
                        vecString[j+1] = s;
                        s = "";
                        j+=2;
                        i++;
                         }
                    else
                    {
                        if((vc[i+1] == '+' || vc[i+1] == '-') && Character.isDigit(vc[i]) && j % 2 == 1){
                              s+= vc[i];
                                vecString[j] = s;
                                s = "";
                                j++;
                   
                        }
                        else{
                            if(Character.isDigit(vc[i]) && ( Character.isDigit(vc[i+1]))){
                              s+= vc[i];
                            }
                            else
                            {
                            
                            if(Character.isDigit(vc[i]) && vc[i+1] == 'x'){
                                s+= vc[i];    
                               /* vecString[j] = s;
                                s="";
                                j++;
*/
                            }
                            else{
                                if(vc[i] == 'x' && (vc[i+1] == '+' || vc[i+1] == '-' || Character.isDigit(vc[i+1]) || i+1 == vc.length) && Character.isDigit(vc[i-1])){
                                    vecString[j] = s;
                                    s = "1";
                                    vecString[j+1] = s;
                                    s = "";
                                    j+=2;
                                }
                                else
                                {
                                    
                                    if(vc[i] == 'x' && (vc[i+1] == '+' || vc[i+1] == '-' || Character.isDigit(vc[i+1]) || i+1 == vc.length) && (vc[i-1] == '+' || vc[i-1] == '-')){
                                        
                                     s += "1";   
                                     vecString[j] = s;
                                     s = "1";
                                    vecString[j+1] = s;
                                    s = "";
                                    j+=2;
                                 
                                    }
                                
                                
                                else{
                                    if(vc[i] == 'x' && vc[i+1] == '^'){
                                        vecString[j] = s;
                                        s = "";
                                        i++;
                                        j++;
                                        
                                    }
                                    }//Cierre del else de la x que tiene un numero en la posicion anterior
                                }// Cierre del else de la x que tiene el gorrito en la posicion siguiente
                                    
                            
                            } //Cierre del else del numero que tiene una x en la posicion siguiente
                          } //Cierre del else del numero que tiene un signo en la posicion siguiente (Exponente)  
                        }//Cierre del else del numero que tiene un signo en la posicion siguiente (Constante)
                    
                       }//Cierre del else del numero que está en el final pero es un ------ (Exponente)
                       }//Cierre del else del numero que está en el final pero es una ----- (Constante)
                    }//Cierre del else del numero que tiene un numero en la posicion siguiente  
                }// Cierre del else del signo de la resta
                
            }//Cierre del else del signo de la suma (inicial)
            }//Cierre del para 
     
       for (int i = 0; i < vecString.length; i++) {
            System.out.print("["+ vecString[i]+"]"); 
        }
           System.out.println("");
       
     
 } 

}
