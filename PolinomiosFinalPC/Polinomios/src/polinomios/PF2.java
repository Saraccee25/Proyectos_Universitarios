package polinomios;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class PF2 {

    //Atributos 
    private int Du, VPF2[];

    public PF2(int NTer) {
        Du = NTer * 2;
        VPF2 = new int[Du + 1];
    }

    public PF2() {
        Du = 0;
        VPF2 = new int[20];
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getVPF2(int pos) {
        return VPF2[pos];
    }

    public void Forma2(String[] Vs) {

        int contt = 0, valormayorf2 = 0, j = 1;

        for (int i = 0; i < Vs.length; i += 2) {

            if (Vs[i] != null) {

                if (Integer.parseInt(Vs[i]) != 0) {
                    contt++;
                }
                if (Integer.parseInt(Vs[i]) > valormayorf2) {
                    valormayorf2 = Integer.parseInt(Vs[i]);
                }
            }

        }

        VPF2[0] = contt;

        for (int i = 0; i < Vs.length; i += 2) {
            if (Vs[i] != null) {
                VPF2[j + 1] = Integer.parseInt(Vs[i + 1]);
                VPF2[j] = Integer.parseInt(Vs[i]);
                j += 2;
            }

        }
        int nterm = 0;
        for (int i = 0; Vs[i] != null; i += 2) {
            nterm++;
        }

        int TamV = (nterm * 2) + 1;
        int nuevovec[] = new int[TamV];

        for (int i = 0; i < nuevovec.length; i++) {
            nuevovec[i] = VPF2[i];
        }

        this.setVPF2(nuevovec);

        System.out.println("\n");
        for (int i = 0; i < TamV; i++) {
            System.out.print("[" + VPF2[i] + "]");

        }

        System.out.println("");
    }

    public void Redimensionar(String Vs) {

    }

    public void Reconstruir() {

        for (int i = 1; i < VPF2.length - 1; i += 2) {

            if (VPF2[i] != 0) {

                if (VPF2[i + 1] == 0) {
                    if (VPF2[i] < 0) {

                        System.out.print(VPF2[i]);
                    } else {
                        System.out.print("+" + VPF2[i]);
                    }
                } else if (VPF2[i + 1] == 1) {

                    if (VPF2[i] < 0) {

                        System.out.print(VPF2[i] + "x");
                    } else {
                        System.out.print("+" + VPF2[i] + "x");
                    }
                } else if (VPF2[i + 1] < 0) {
                    System.out.print(VPF2[i] + "x" + "^" + VPF2[i + 1]);
                } else {
                    System.out.print("+" + VPF2[i] + "x" + "^" + VPF2[i + 1]);
                }
            }

        }
    }

    public void Evaluar() {

        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un numero: ", "Ingreso", -1));
        int suma = 0, e;

        for (int i = 1; i < VPF2.length - 1; i += 2) {
            e = (int) Math.round(Math.pow(num, VPF2[i + 1]));
            suma += VPF2[i] * e;

        }
        System.out.println("");
        System.out.println(suma);
    }

    public void Multiplicar(PF2 F21) {
        int Vr[] = new int[Du + F21.getDu() + 1];
        int k = 1;
        Vr[0] = VPF2[0] + F21.getVPF2(0);
        for (int i = 1; i < VPF2.length; i += 2) {
            for (int j = 1; j < VPF2.length; j += 2) {
                int Exp = VPF2[i + 1] + F21.getVPF2(j + 1);
                int Coe = VPF2[i] * F21.getVPF2(j);
                int pos = BuscarExp(Vr, Exp) - 1;

                if (pos > 0) {
                    Vr[pos] += Coe;
                    Vr[pos + 1] = Exp;
                } else {
                    Vr[k] = Coe;
                    Vr[k + 1] = Exp;
                    k += 2;
                }
            }
        }
        organizarVector(Vr);
        Imprimir(Vr);

    }

    public void Imprimir(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.print("[" + vec[i] + "]");
        }
        System.out.println("\n");
    }

    public static int BuscarExp(int vec[], int exp) {

        int pos = -1;
        for (int i = 2; i < vec.length; i += 2) {
            if (vec[i] == exp) {
                pos = i;
            }
        }

        return pos;
    }

    public void organizarVector(int[] Vr) {

        int numTerminos = Vr[0];

        int[] terminosOrdenados = new int[Vr.length];

        terminosOrdenados[0] = numTerminos;

        for (int i = 1; i <= numTerminos; i++) {

            int im = i;
            int exponenteMayor = Vr[im * 2];
            for (int j = i + 1; j <= numTerminos; j++) {
                int exponenteActual = Vr[j * 2];
                if (exponenteActual > exponenteMayor) {
                    im = j;
                    exponenteMayor = exponenteActual;
                }
            }

            terminosOrdenados[i * 2 - 1] = Vr[im * 2 - 1];
            terminosOrdenados[i * 2] = Vr[im * 2];

            int coeficienteMayor = Vr[im * 2 - 1];
            int exponenteFinal = Vr[i * 2];
            Vr[im * 2 - 1] = Vr[i * 2 - 1];
            Vr[im * 2] = Vr[i * 2];
            Vr[i * 2 - 1] = coeficienteMayor;
            Vr[i * 2] = exponenteMayor;
        }

        for (int i = 0; i < Vr.length; i++) {
            Vr[i] = terminosOrdenados[i];
        }
    }

    public void SumarF1F3(PF3 Polf3, PF1 Polf1) {
        Nodo P = Polf3.Punta;
        int i = 1, j = 1, Exp = 0;

        while (P != null || i <= Polf1.getDu()) {

            if (P != null && i <= Polf1.getDu()) {
                if (i <= Polf1.getDu()) {
                    Exp = Polf1.getDu() - i;
                }
                if (Polf1.getVPF1(i) == 0) {
                    i++;
                } else {
                    if (Exp == P.getExp()) {
                        VPF2[j] = Polf1.getVPF1(i) + P.getCoe();
                        VPF2[j + 1] = Exp;
                        j += 2;
                        i++;
                        P = P.getLiga();
                    } else {
                        if (Exp > P.getExp()) {
                            VPF2[j] = Polf1.getVPF1(i);
                            VPF2[j + 1] = Exp;
                            j += 2;
                            i++;
                        } else {
                            if (Exp < P.getExp()) {
                                VPF2[j] = P.getCoe();
                                VPF2[j + 1] = P.getExp();
                                j += 2;
                                P = P.getLiga();
                            }
                        }
                    }
                }
            } else {
                if (P == null) {
                    Exp = Polf1.getDu() - i;
                    VPF2[j] = Polf1.getVPF1(i);
                    VPF2[j + 1] = Exp;
                    j += 2;
                    i++;
                } else {
                    if (i > Polf1.getDu()) {
                        VPF2[j] = P.getCoe();
                        VPF2[j + 1] = P.getExp();
                        P = P.getLiga();
                        j += 2;
                    }
                }
            }
        }

        VPF2[0] = j / 2;

        String s = "";
        s = s + "[" + VPF2[0] + "]";
        for (int k = 1; VPF2[k] != 0; k += 2) {
            s = s + "[" + VPF2[k] + "]";
            s = s + "[" + VPF2[k + 1] + "]";
        }
        JOptionPane.showMessageDialog(null, s);
    }

    public void SumaPolinomiosF2(PF2 F21) {

        int i = 2, j = 2, k = 2;
        while (i < this.Du || j < F21.Du) {
            if ((i < this.getDu() && j < F21.getDu()) && this.getVPF2(i) == F21.getVPF2(j)) {
                VPF2[k] = this.getVPF2(i);
                VPF2[k - 1] = this.getVPF2(i - 1) + F21.getVPF2(j - 1);
                i = i + 2;
                j = j + 2;
            } else if ((i < this.getDu() && j < F21.Du) && this.getVPF2(i) > F21.getVPF2(j)) {
                VPF2[k] = this.getVPF2(i);
                VPF2[k - 1] = this.getVPF2(i - 1);
                i = i + 2;
            } else if ((i < this.Du && j < F21.getDu())) {
                VPF2[k] = F21.getVPF2(j);
                VPF2[k - 1] = F21.getVPF2(j - 1);
                j = j + 2;
            } else {
                if (i < this.getDu()) {
                    VPF2[k] = this.getVPF2(i);
                    VPF2[k - 1] = this.getVPF2(i - 1);
                    i = i + 2;
                } else {
                    VPF2[k] = F21.getVPF2(j);
                    VPF2[k - 1] = F21.getVPF2(j - 1);
                    j = j + 2;
                }
            }
            k = k + 2;
            VPF2[0] += 1;
        }

        System.out.println("\n");
        for (i = 0; i < VPF2.length; i++) {
            System.out.print("[" + VPF2[i] + "]");
        }
    }

    public void imprimirPolinomio(int[] polinomio) {
        System.out.print("[");
        for (int i = 0; i < polinomio.length; i++) {
            System.out.print(polinomio[i]);
            if (i < polinomio.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void Eliminar() {

        int Exp, i = 0;
        Exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente del monomio a eliminar"));

        while (i < VPF2.length) {
            if (Exp == VPF2[i]) {
                VPF2[i] = 0;
                VPF2[i - 1] = 0;
                VPF2[0] = VPF2[0] - 1;
            }
            i += 2;
        }

        RedimensionarP();

        for (i = 0; i < VPF2.length; i++) {
            System.out.print("[" + VPF2[i] + "]");
        }

    }

    public void RedimensionarP() {

        int cont = 0, i = 1, j = 1, k = 1;

        while (i < VPF2.length) {
            if (VPF2[i] == 0) {
                cont++;
            }
            i += 2;
        }

        int[] NewVc = new int[VPF2.length - (cont + 1)];
        NewVc[0] = VPF2[0];

        while (j < VPF2.length) {

            if (VPF2[j] != 0) {
                NewVc[k] = VPF2[j];
                j++;
                k++;
            } else {
                j++;
            }
        }
        setVPF2(NewVc);
    }

    public void IngresarMonomio(String[] Vs3) {

        int i = 3, j;

        if (Integer.parseInt(Vs3[1]) > VPF2[2]) {
            int nuevovec[] = new int[Du + 3];
            nuevovec[0] = VPF2[0] + 1;
            nuevovec[1] = Integer.parseInt(Vs3[0]);
            nuevovec[2] = Integer.parseInt(Vs3[1]);

            for (j = 1; i < nuevovec.length; j++) {
                nuevovec[i] = VPF2[j];
                i++;
            }
            this.setVPF2(nuevovec);
        } else {
            int expmon = Integer.parseInt(Vs3[1]);
            int k;
            int expf2 = 0;
            boolean encontrado = false, algo = false;

            for (k = 2; k < VPF2.length; k += 2) {
                expf2 = VPF2[k];

                if (expmon == expf2) {
                    encontrado = true;
                    VPF2[k - 1] = VPF2[k - 1] + Integer.parseInt(Vs3[0]);
                }
            }
            if (encontrado == false) {
                for (k = 2; k < VPF2.length; k += 2) {
                    expf2 = VPF2[k];

                    if (expmon < VPF2[k] && expmon > VPF2[k + 2]) {
                        int nuevovec2[] = new int[Du + 3];
                        int m = 1;
                        nuevovec2[0] = VPF2[0] + 1;

                        for (k = 1; k < expf2; k++) {

                            nuevovec2[m] = VPF2[k];//no funciona

                            if (k == expmon && k > 1) {
                                k++;
                                algo = true;
                                break;
                            }
                            m++;
                        }
                        if (algo == true) {
                            m++;
                        }
                        nuevovec2[m] = Integer.parseInt(Vs3[0]);
                        nuevovec2[m + 1] = Integer.parseInt(Vs3[1]);

                        for (m = m + 2; m < nuevovec2.length; m++) {
                            nuevovec2[m] = VPF2[k];
                            k++;
                        }

                        this.setVPF2(nuevovec2);
                    }
                }
            }
        }
        for (i = 0; i < VPF2.length; i++) {
            System.out.print("[" + VPF2[i] + "]");
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
