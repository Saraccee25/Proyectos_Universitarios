package listaspoo;

//La clase se nnombra generalmente en singular

import javax.swing.JOptionPane;

public class Lista {

    //Atributos
    Nodo Punta, Final;

    //Métodos (públicos)
    public Lista() {
        Punta = null;
    }

    public void InsertarFinal(int d) {
       
        Nodo p, x = new Nodo();
        x.setDato(d);
        

        if (Punta == null) {
            Punta = x;
        }
        else {
            p = Punta;

            while (p.getLD() != null) {
                p = p.getLD();
            }
            p.setLD(x);
            x.setLI(p);

        }

    }

    public void MostrarLista(){
        

       Nodo p = Punta;
       
       String s= " ";
       
       while (p != null){
           //sout tabulador para hacerlo más rápido
           System.out.print("|"+p.getDato()+"|-->");//Imprimir por consola
           //JOptionPane.showMessageDialog(null, "|");
           s = s + "|"+p.getDato()+"|--> \n";
            p = p.getLD();
           
       }
    }
    
    public void InsertarInicio(int d){
        
        Nodo x = new Nodo(d);
         
        if (Punta == null){
            Punta = x;
        }
        else{
            x.setLD(Punta);
            Punta.setLI(x);
            Punta = x;
        }
        
    }
    
    public void InsertarOrdenado(int d){
        Nodo x=new Nodo(d), A = null, P = Punta;
        
        if( Punta == null){
            Punta = x;
        }
        else{
            while(P != null && x.getDato()> P.getDato()){
                A=P;
                P= P.getLD();
            }
            if(P == Punta){
                x.setLD(Punta);
                P.setLI(x.getLD());
                Punta=x;
            }
            else{
                A.setLD(x);
                x.setLD(P);
                x.setLI(A.getLD());
            }
         
        }
    }
    
    public void Eliminar (int d){
        Nodo P=Punta, A;
        
        while(P != null){
            if( d != P.getDato()){
                P= P.getLD();
            }
            else{
                if ( P == Punta){
                    Punta = P.getLD();
                    P.setLD(null);
                    P = Punta;
                    P.setLI(null);
                }
                else{
                A= P.getLI();
                A.setLD(P.getLD());
                A=P.getLD();
                A.setLI(P.getLI());
                P.setLD(null);
                P.setLI(null);
                P = A;
                }
            }
        }
    }
    
    public void Multiplicacion(Lista L1, Lista L2){
        Nodo P= L1.Punta, Q= L2.Punta;
        int resultado;
        
        while (P != null){
            resultado = 0;
            while (Q != null){
               resultado = resultado + (Q.getDato() * P.getDato());
               Q = Q.getLD();
            }
        InsertarFinal(resultado);
        P = P.getLD();
        Q = L2.Punta;
        
         }
    }
    
    public void OrdernarDescendente (){
        Nodo A, P = Punta;
        int Aux;
        
        if (Punta == null){
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía");        }
        else{
            while(P.getLD() != null){
                A = P.getLD();
                
                while (A != null){
                    if (P.getDato() < A.getDato()){
                    Aux = A.getDato();
                    A.setDato(P.getDato());
                    P.setDato(Aux);
                 }
                    A= A.getLD();
                }
                P = P.getLD();
            }
        }
    }
    
    public void OrdernarAscendente (){
        
        Nodo A, P = Punta;
        int Aux;
        
        if (Punta == null){
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía");
        }
        else{
            while (P.getLD() != null){
                A = P.getLD();
                
                while (A != null){
                    if (P.getDato() > A.getDato()){
                        Aux = A.getDato();
                        A.setDato(P.getDato());
                        P.setDato(Aux);
                    }
                    A = A.getLD();
                }
                P = P.getLD();
            }
        }
    }
    
    public void Intercalado (Lista L1, Lista L2){
        
        Nodo P = L1.Punta, Q = L2.Punta;
        
        while (P!= null || Q != null){
            InsertarFinal(P.getDato());
            InsertarFinal(Q.getDato());
            P = P.getLD();
            Q = Q.getLD();
        }
    }
    
  public void ReemplazarDato (int d, int d2){
      Nodo P = Punta;
      
      if ( Punta == null){
          JOptionPane.showMessageDialog(null,"La lista se encuentra vacía");
      }
      else{
          while (P != null){
              if(P.getDato()!=d){
                  P = P.getLD();
              }
              else{
                  P.setDato(d2);
                  P = P.getLD();
              }
          }
      }
  }
  
  public void MostrarPosición(int d){
      Nodo P = Punta;
      int Contador = 0;
      
      if (Punta ==null){
           JOptionPane.showMessageDialog(null,"La lista se encuentra vacía");
      }
      else{
          while( P != null){
              Contador++;
              if (P.getDato() != d){
                  P = P.getLD();
              }
              else{
                   JOptionPane.showMessageDialog(null,"El dato que busca está en la posición número " + Contador);
                   P = P.getLD();
                      
              }
          }
      }
  }
  
  
    
    
    
}



