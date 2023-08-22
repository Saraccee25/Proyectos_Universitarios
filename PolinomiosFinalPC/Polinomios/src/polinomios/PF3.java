package polinomios;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class PF3 {

    //Atributos
    public Nodo Punta;

    public PF3() {

        Punta = null;

    }

    public void InsertarFinal(int c, int e) {

        Nodo p, x = new Nodo(c, e);

        if (Punta == null) {
            Punta = x;
        } else {
            p = Punta;
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }

    }

    public void InsertarOrdenado(int c, int e) {
        Nodo x = new Nodo(c, e), A = null, P = Punta;

        if (Punta == null) {
            Punta = x;
        } else {
            while (P != null && x.getExp() < P.getExp()) {
                A = P;
                P = P.getLiga();
            }
            if (P == Punta) {
                x.setLiga(Punta);
                Punta = x;
            } else {
                A.setLiga(x);
                x.setLiga(P);
            }

        }
    }

    public void reconstruirPolinomio() {
        String polinomio = "";
        Nodo P = Punta;
        while (P != null) {
            int coeficiente = P.getCoe();
            int exponente = P.getExp();
            String termino = "";
            if (exponente == 0) {
                termino = String.valueOf(coeficiente);
            } else if (exponente == 1) {
                termino = coeficiente + "x";
            } else {
                termino = coeficiente + "x^" + exponente;
            }
            if (coeficiente != 0) {
                if (polinomio.isEmpty()) {
                    polinomio = termino;
                } else {
                    if (coeficiente > 0) {
                        polinomio += "+";
                    }
                    polinomio += termino;
                }
            }
            P = P.getLiga();
        }

        JOptionPane.showMessageDialog(null, "El polinomio es: " + polinomio);

    }

    public int EvalPol(int x) {
        int Vcom = 0;

        Nodo p = new Nodo();
        p = Punta;
        while (p != null) {
            Vcom += p.getCoe() * (int) Math.round(Math.pow(x, p.getExp()));
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, Vcom);
        return Vcom;
    }

    public void SumarPolinomios(PF3 LPF3, PF3 LPF3_2) {
        Nodo x = new Nodo();
        Nodo p = new Nodo();
        x = LPF3.Punta;
        p = LPF3_2.Punta;
        while (x != null || p != null) {
            if ((x != null && p != null) && (x.getExp() == p.getExp())) {
                InsertarFinal((x.getCoe() + p.getCoe()), x.getExp());
                x = x.getLiga();
                p = p.getLiga();
            } else if ((x != null && p != null) && (x.getExp() > p.getExp())) {
                InsertarFinal(x.getCoe(), x.getExp());
                x = x.getLiga();
            } else if ((x != null && p != null) && (p.getExp() > x.getExp())) {
                InsertarFinal(p.getCoe(), p.getExp());
                p = p.getLiga();
            } else {
                if (p != null) {
                    InsertarFinal(p.getCoe(), p.getExp());
                    p = p.getLiga();
                } else {
                    InsertarFinal(x.getCoe(), x.getExp());
                    x = x.getLiga();
                }
            }
        }
        Mostrar();
    }


    public void MultiplicarPolinomios(PF3 P1, PF3 P2) {
        Nodo x = P1.Punta;
        while (x != null) {
            Nodo p = P2.Punta;
            while (p != null) {
                InsertarOrdenado2(x.getCoe() * p.getCoe(), x.getExp() + p.getExp());
                p = p.getLiga();
            }
            x = x.getLiga();
        }
    }

    public void InsertarOrdenado2(int coef, int exp) {
        Nodo ant = null;
        Nodo p = Punta;
        while (p != null && p.getExp() > exp) {
            ant = p;
            p = p.getLiga();
        }
        if (p != null && p.getExp() == exp) {
            
            p.setCoe(p.getCoe() + coef);
        } else {
           
            Nodo nuevo = new Nodo(coef, exp);
            if (ant == null) {
                Punta = nuevo;
            } else {
                ant.setLiga(nuevo);
            }
            nuevo.setLiga(p);
        }
    }

    public void Mostrar() {

        Nodo p = Punta;
        String s = "";

        while (p != null) {
            s = s + "[" + p.getCoe() + "]" + "[" + p.getExp() + "]" + "--> ";
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, s);

    }

    public void Eliminar(int e) {
        Nodo P = Punta, a = null;
        while (P != null) {
            if (e != P.getExp()) {
                a = P;
                P = P.getLiga();
            } else {
                if (P == Punta) {
                    Punta = P.getLiga();
                    P.setLiga(null);
                    P = Punta;
                } else {
                    a.setLiga(P.getLiga());
                    P.setLiga(null);
                    P = a.getLiga();
                }
                break;
            }
        }
    }

    public String[] Ingreso2(String monomio) {
        int j = 0;
        String s = "";
        String Vs[];

        char Vc[] = monomio.toCharArray();
        Vs = new String[Vc.length];

        for (int i = 0; i < Vc.length; i++) {
            System.out.print("[" + Vc[i] + "]");
        }

        for (int i = 0; i < Vc.length; i++) {

            if (Character.isDigit(Vc[i]) || Vc[i] == '-') {

                s = s + Vc[i];

                if (Character.isDigit(Vc[i]) && i != Vc.length - 1 && (Vc[i + 1] == '-' || Vc[i + 1] == '+')) {
                    Vs[j] = s;
                    j++;
                    Vs[j] = "0";
                    s = "";
                    j++;
                }

            } else {
                if ((i - 1) >= 0) {
                    if (Vc[i] == 'x' && Vc[i - 1] == '-') {//s.equals("-");
                        s = s + "1";
                        Vs[j] = s;
                        s = "";
                        j++;
                    }
                }

                if (Vc[i] == 'x') {

                    if (Vc[i] == 'x') {
                        if (i == 0) { // Si la x está en la primera posición
                            if (!s.equals("")) {
                                Vs[j] = s;
                            } else {
                                Vs[j] = "1"; // Si no hay coeficiente, se asume un 1
                            }
                            Vs[j + 1] = "1"; // Se agrega el exponente 1
                            s = "";
                            j += 2;
                        } else {
                            if (!s.equals("")) {
                                Vs[j] = s;
                                s = "";
                                j++;
                            }
                            // Resto del código para el caso normal
                            // ...
                        }
                    }

                    if (!s.equals("")) {
                        Vs[j] = s;
                        s = "";
                        j++;
                    }

                    if (i != Vc.length - 1) {
                        if (Vc[i + 1] != '^' && (Vc[i - 1] != '-' || Vc[i - 1] != '+')) {
                            Vs[j] = "1";
                            j++;
                        }
                    }

                    if (Vc[i] == 'x' && i == Vc.length - 1) {

                        if (s.equals("")) {
                            Vs[j] = "1";
                            j++;

                            if (monomio.charAt(0) == 'x') {

                                int[] VE = new int[Vs.length];
                                for (i = 0; i < Vs.length; i++) {
                                    VE[i] = Integer.parseInt(Vs[i]);
                                }
                                int nuevaLongitud = Vs.length + 1;
                                int[] nuevoVec = Arrays.copyOf(VE, nuevaLongitud);
                                nuevoVec[1] = 1;

                                String[] Vss = new String[nuevoVec.length];
                                for (i = 0; i < nuevoVec.length; i++) {
                                    Vss[i] = String.valueOf(nuevoVec[i]);
                                }
                                System.out.println("\n");
                                for (i = 0; i < Vss.length; i++) {
                                    System.out.print("[" + Vss[i] + "]");
                                }
                                return Vss;
                            }
                        }
                        if ((i - 1) > 0) {
                            if (Vc[i - 1] == '+') {
                                Vs[j] = "1";
                                j++;
                            }
                        }
                    }
                    if (Vc[0] == 'x' && Vc[1] == '^') {
                        Vs[j] = "1";
                        j++;
                    }
                }
            }

            if (Vc[i] == '^') {
                Vs[j] = Character.toString(Vc[i + 1]);
                i++;
                j++;
            }

        }

        if (!s.equals("")) {
            Vs[j] = s;
            j++;
            Vs[j] = "0";
            j++;
        }

        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {
            System.out.print("[" + Vs[i] + "]");
        }
        return Vs;
    }

}
