
package pilas.y.colas;

import javax.swing.JOptionPane;


public class Cola {
    private int Lt, T;
    private Lista L;

    public Cola(int N) {
        Lt = N-1;
        T = 0;
        L = new Lista();
    }

    public int getLt() {
        return Lt;
    }


    public int getT() {
        return T;
    }

    public Nodo getL() {
        Nodo R = L.Punta;
        return R;
    }
    
    public void Encolar(int D){
        T++;
        L.InsertarFinal(D);
    }
    
    public Nodo Desencolar() {
        Nodo R = L.Punta;
        
        L.Punta = L.Punta.GetLiga();
        R.SetLiga(null);
        T--;
        return R;
    }
    
    public boolean ColaVacia() {
        if (T == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ColaLlena() {
        boolean R = false;

        if (T == Lt+1) {
            R = true;
        }
        return (R);
    }
    
    public void EncolarOrdenado(int D){
        Cola CA = new Cola(Lt);
        Nodo X = new Nodo(D);
        
        while (!ColaVacia() && D> L.Punta.GetDato()){
        }
    }
}
