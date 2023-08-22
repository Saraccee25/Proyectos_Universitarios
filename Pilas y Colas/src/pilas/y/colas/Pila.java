package pilas.y.colas;
//Límite = Lt, Tope = T, V = Vector.

import javax.swing.JOptionPane;

public class Pila {

    //Atributos
    private int Lt, T;
    private float V[];
    //Metodos
    public Pila(int N) {
        Lt = N - 1;
        T = -1;
        V = new float[N];
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }

    public float[] getV() {
        return V;
    }

    public void setV(float[] V) {
        this.V = V;
    }

    public float getV(int t) {
        return V[t];
    }

    public void setV(int t, int D) {
        V[t] = D;
    }

    public void Apilar(float D) {
        T++;
        V[T] = D;
    }

    public float Desapilar() {
        float R = V[T];

        T--;
        return (R);
    }

    public boolean PilaVacia() {
        if (T == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PilaLlena() {
        boolean R = false;

        if (T == Lt) {
            R = true;
        }
        return (R);
    }

    public void LlenarPila(Pila P) {
        while (P.PilaVacia() == false) {
            if (!PilaLlena()) {
                Apilar(P.Desapilar());
            }
        }
    }

    public void ApilarOrdenado(int D) {
        Pila PA = new Pila(Lt + 1);

        while (PilaVacia() == false && D < getV(T)) {
            PA.Apilar(Desapilar());
        }
        Apilar(D);
        if (PA.PilaVacia() == false) {
            LlenarPila(PA);
        }
    }

    public void OrdenarAsc() {
        Pila PA = new Pila(Lt + 1), PA2 = new Pila(Lt + 1);
        float Aux;
        PA.LlenarPila(this);
        do {
            Aux = PA.Desapilar();
            while (PA.PilaVacia() == false) {
                if (Aux > PA.getV(PA.T)) {
                    PA2.Apilar(Aux);
                    Aux = PA.Desapilar();
                } else {
                    PA2.Apilar(PA.Desapilar());
                }
            }
            Apilar(Aux);
            if (PA2.PilaVacia() == false) {
                PA.LlenarPila(PA2);
            }
        } while (PA.PilaVacia() == false);
    }

    public void OrdenarDes() {
        Pila PA = new Pila(Lt + 1), PA2 = new Pila(Lt + 1);
        float Aux;
        PA.LlenarPila(this);
        do {
            Aux = PA.Desapilar();
            while (PA.PilaVacia() == false) {
                if (Aux < PA.getV(PA.T)) {
                    PA2.Apilar(Aux);
                    Aux = PA.Desapilar();
                } else {
                    PA2.Apilar(PA.Desapilar());
                }
            }
            Apilar(Aux);
            if (PA2.PilaVacia() == false) {
                PA.LlenarPila(PA2);
            }
        } while (PA.PilaVacia() == false);
    }

    public void Eliminar(int D) {
        Pila PA = new Pila(Lt + 1);

        while (PilaVacia() == false) {
            if (D == getV(T)) {
                Desapilar();
            } else {
                PA.Apilar(Desapilar());
            }
        }
        if (PA.PilaVacia() == false) {
            LlenarPila(PA);
        }
    }

    public void Reemplazar(int D, int D2) {
        Pila PA = new Pila(Lt + 1);

        while (PilaVacia() == false) {
            if (D == getV(T)) {
                Desapilar();
                PA.Apilar(D2);
            } else {
                PA.Apilar(Desapilar());
            }
        }
        LlenarPila(PA);
    }

    public void Mostrar() {
        String S = "";
        Pila PA = new Pila(Lt + 1);
        float Aux;
        if (!PilaVacia()) {
            do {
                Aux = Desapilar();
                PA.Apilar(Aux);
                if (T != -1) {
                    S = S + "|" + Aux + "|\n";
                } else {
                    S = S + "|" + Aux + "|\n" + " __ ";
                }
            } while (!PilaVacia());
            LlenarPila(PA);
            JOptionPane.showMessageDialog(null, S);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía.", "", 1);
        }
    }

    
}
