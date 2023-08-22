package pilas.y.colas;

import javax.swing.JOptionPane;


public class Lista {

    //Atributo
    Nodo Punta;

    //Métodos
    public Lista() {
        Punta = null;
    }

    public void Mostrar(float Prom) {
        Nodo P = Punta;
        String S = "";

        while (P != null) {
            //JOptionPane.showInternalMessageDialog(null, P.GetDato()+" -- " );
            //System.out.print(" "+P.GetDato()+" <--> ");
            S = S + P.getCed()+", " + P.getNom() + ", " + Prom ;
            P = P.getLiga();
        }
        JOptionPane.showMessageDialog(null, S);
    }

    public void InsertarInicio(int Ced, String Nom, String Car, String Ape) {
        Nodo X = new Nodo();

        if (Punta == null) {
            Punta = X;
        } else {
            X.setLiga(Punta);
            Punta.setLiga(X);
            Punta = X;
        }
    }

    public void InsertarFinal(int Ced, String Nom, String Car, String Ape) {
        Nodo P, X = new Nodo();
        float Mat, Hum, Ing, Dep ;
        X.setNom(Nom);
        X.setApe(Ape);
        X.setCed(Ced);
        X.setCar(Car);
        
        Mat = Float.parseFloat(JOptionPane.showInputDialog(null, "Nota definitiva de matemáticas:"));
        Hum = Float.parseFloat(JOptionPane.showInputDialog(null, "Nota definitiva de humanidades:"));
        Ing = Float.parseFloat(JOptionPane.showInputDialog(null, "Nota definitiva de ingles:"));
        Dep = Float.parseFloat(JOptionPane.showInputDialog(null, "Nota definitiva de deporte:"));
        X.P.Apilar(Mat);
        X.P.Apilar(Hum);
        X.P.Apilar(Ing);
        X.P.Apilar(Dep);
        if (Punta == null) {
            Punta = X;
        } else {
            P = Punta;

            while (P.GetLiga() != null) {
                P = P.GetLiga();
            }
            P.SetLiga(X);
        }
    }


    public void InsertarOrdenado(int D) {
        Nodo X = new Nodo(D), A = null, P = Punta;

        if (Punta == null) {
            Punta = X;
        } else {
            while (P != null && X.GetDato() > P.GetDato()) {
                {
                    A = P;
                    P = P.GetLigaD();
                }
            }
            if (P == Punta) {
                X.SetLigaD(Punta);
                P.SetLigaI(X.GetLigaD());
                Punta = X;
            } else {
                A.SetLigaD(X);
                X.SetLigaD(P);
                X.SetLigaI(A.GetLigaD());
            }
        }
    }

    public void OrdenaAscendente() {
        Nodo A, P = Punta;
        int Aux;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
        } else {
            while (P.GetLigaD() != null) {
                A = P.GetLigaD();

                while (A != null) {

                    if (P.GetDato() > A.GetDato()) {
                        Aux = A.GetDato();
                        A.SetDato(P.GetDato());
                        P.SetDato(Aux);
                    }
                    A = A.GetLigaD();
                }
                P = P.GetLigaD();
            }
            JOptionPane.showMessageDialog(null, "Lista #1 de forma ascendente:");
            Mostrar();
        }
    }

    public void OrdenaDescendente() {
        Nodo A, P = Punta;
        int Aux;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
        } else {
            while (P.GetLigaD() != null) {
                A = P.GetLigaD();

                while (A != null) {

                    if (P.GetDato() < A.GetDato()) {
                        Aux = A.GetDato();
                        A.SetDato(P.GetDato());
                        P.SetDato(Aux);
                    }
                    A = A.GetLigaD();
                }
                P = P.GetLigaD();
            }
            JOptionPane.showMessageDialog(null, "Lista #1 de forma descendente:");
            Mostrar();
        }
    }

    public void Eliminar() {
        Nodo P = Punta, A = null;
        int D;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
        } 
        else {
            D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que desea eliminar: "));
            while (P != null) {
                if (D != P.GetDato()) {
                    P = P.GetLigaD();
                } else {
                    if(A==null && (P.GetLigaD()==null) && P.GetLigaI()==null){
                        Punta=null;
                        JOptionPane.showMessageDialog(null, "La lista ha quedado vacía.");
                    }
                    else{
                        if (P == Punta) {
                            Punta = P.GetLigaD();
                            P.SetLigaD(null);
                            P = Punta;
                            P.SetLigaI(null);
                        }
                        else {
                            A = P.GetLigaI();
                            A.SetLigaD(P.GetLigaD());
                            A = P.GetLigaD();

                            if (A != null) {
                                A.SetLigaI(P.GetLigaI());
                            }
                            P.SetLigaD(null);
                            P.SetLigaI(null);
                            P = A;
                        }
                    }
                }
                if(Punta ==  null){
                    P = null;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Lista #1:");
        Mostrar();
    }

    public void Reemplazar() {
        Nodo P = Punta;
        int Dato, Dato2;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
        } else {
            Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que desea reemplazar: "));
            Dato2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato nuevo dato: "));
            while (P != null) {
                if (P.GetDato() != Dato) {
                    P = P.GetLigaD();
                } else {
                    P.SetDato(Dato2);
                    P = P.GetLigaD();
                }
            }
            JOptionPane.showMessageDialog(null, "Lista #1:");
            Mostrar();
        }
    }

    public void MostrarPosición() {
        Nodo P = Punta;
        int Cont = 0, D;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
        } else {
            D = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del cual desea saber la posición: "));
            while (P != null) {
                Cont = Cont + 1;
                if (P.GetDato() != D) {
                    P = P.GetLigaD();
                } else {
                    JOptionPane.showMessageDialog(null, "El dato buscado se encuentra en la posición #" + Cont);
                    P = P.GetLigaD();
                }
            }
        }
    }
}
