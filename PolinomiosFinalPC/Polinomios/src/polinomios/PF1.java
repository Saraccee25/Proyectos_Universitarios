package polinomios;

import static polinomios.Polinomios.Vs;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class PF1 {

    //Atributos
    private int Du;
    private int VPF1[];

    //Métodos
    public PF1() {
        Du = 0;
        VPF1 = new int[20];
    }

    public PF1(int Expm) {
        Du = Expm + 1;
        VPF1 = new int[Du + 1];
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] VAux) {
        VPF1 = VAux;
    }

    public int getVPF1(int pos) {
        return VPF1[pos];
    }

    public void setVPF1(int pos, int d) {
        this.VPF1[pos] = d;
    }

    public int Ordenar(String Vs[]) {

        int i = 1, j = 3;
        int Mayor = 0;
        int sum, Expm;
        String AuxE = "";
        String AuxC = "";

        while (Vs[i] != null) {

            if (Integer.parseInt(Vs[i]) > Mayor) {
                Mayor = Integer.parseInt(Vs[i]);
            }
            i += 2;
        }
        i = 1;
        j = 3;

        while (Vs[i] != null && Vs[j] != null) {

            if (Integer.parseInt(Vs[i]) == Integer.parseInt(Vs[j])) {
                sum = Integer.parseInt(Vs[i - 1]) + Integer.parseInt(Vs[j - 1]);
                Vs[i - 1] = String.valueOf(sum);
                Vs[j] = "0";
                Vs[j - 1] = "0";
                j += 2;
            } else {
                j += 2;
            }
            if (Vs[j] == null) {
                i += 2;
                j = i + 2;
            }
        }

        i = 1;
        j = 3;

        do {
            while (Vs[i] != null) {

                if (Integer.parseInt(Vs[i]) < Integer.parseInt(Vs[j])) {

                    AuxE = Vs[i];
                    AuxC = Vs[i - 1];

                    Vs[i] = Vs[j];
                    Vs[i - 1] = Vs[j - 1];

                    Vs[j] = AuxE;
                    Vs[j - 1] = AuxC;
                }

                if (Vs[i + 2] != null && Vs[j + 2] != null) {
                    i += 2;
                    j += 2;
                } else {
                    break;
                }
            }
            i = 1;
            j = 3;
        } while (Integer.parseInt(Vs[1]) != Mayor);

        System.out.println("\n");
        for (i = 0; i < Vs.length; i++) {
            System.out.print("[" + Vs[i] + "]");
        }

        Expm = Integer.parseInt(Vs[1]);
        return Expm;

    }

    public void Forma1(String Vs[]) {

        int i = 0, j = 1, pos = 0, exp;
        int expM = Integer.parseInt(Vs[1]);

        VPF1[0] = expM;

        while (Vs[i] != null) {
            i++;
        }

        while (j < i) {
            pos = Du - Integer.parseInt(Vs[j]);
            VPF1[pos] = VPF1[pos] + Integer.parseInt(Vs[j - 1]);
            j += 2;
        }

        System.out.println("\n");
        for (int x = 0; x < VPF1.length; x++) {
            System.out.print("[" + VPF1[x] + "]");
        }

    }

    public void MultiplicarF1F3(PF2 V2, PF3 V3) {
        Nodo P = V3.Punta;
        int i, Pos = 0;

        VPF1[0] = V2.getVPF2(2) + P.getExp();

        while (P != null) {
            i = 2;
            while (i <= V2.getDu()) {
                Pos = Du - (V2.getVPF2(i) + P.getExp());
                VPF1[Pos] = VPF1[Pos] + (V2.getVPF2(i - 1) * P.getCoe());
                i += 2;
            }
            P = P.getLiga();
        }
        
        System.out.println("\n");
        for (int x = 0; x < VPF1.length; x++) {
            System.out.print("[" + VPF1[x] + "]");
        }
    }

    public int Ajustar() {

        int i = 1;
        int cont = 0;

        while (i <= Du && VPF1[i] == 0) {
            cont++;
            i++;
        }
        while (i <= Du) {
            VPF1[i - cont] = VPF1[i];
            i++;
        }
        Du = VPF1[0] - cont + 1;
        VPF1[0] = VPF1[0] - Du;

        System.out.println("\n");
        for (int x = 0; x < VPF1.length; x++) {
            System.out.print("[" + VPF1[x] + "]");
        }
        RedimensionarP(cont);
        return cont;

    }

    public void RedimensionarP(int cont) {

        int VA[] = new int[Du + 1];
        int i = 0, j = 0;

        while (j <= Du) {
            VA[j] = VPF1[i];
            i++;
            j++;
        }
        this.setVPF1(VA);

        System.out.println("\n");
        for (i = 0; i < VPF1.length; i++) {
            System.out.print("[" + VPF1[i] + "]");
        }
    }

    public void RedimensionarG(String Vs2[]) { //revisar

        int NE, i, j;

        NE = Integer.parseInt(Vs2[1]) - VPF1[0];
        int VA[] = new int[Integer.parseInt(Vs2[1]) + NE];
        VA[0] = Integer.parseInt(Vs2[1]);
        VA[1] = Integer.parseInt(Vs2[0]);

        i = (VA[0] + 1) - VPF1[0];
        j = 1;

        while (i <= (VA[0] + 1)) {
            VA[i] = VPF1[j];
            i++;
            j++;
        }

        this.setVPF1(VA);

        System.out.println("\n");
        for (i = 0; i < VPF1.length; i++) {
            System.out.print("[" + VPF1[i] + "]");
        }

    }

    public void InsetarPequeño(String Vs2[]) {

        int Pos = 0, i = 0;
        Pos = Du - Integer.parseInt(Vs2[1]);
        VPF1[Pos] = VPF1[Pos] + Integer.parseInt(Vs2[0]);
        System.out.println("\n");
        for (i = 0; i < VPF1.length; i++) {
            System.out.print("[" + VPF1[i] + "]");
        }

    }

    public void Eliminar() {

        int i;
        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar: "));

        for (i = 1; i < VPF1.length; i++) {
            int Exp = Du - i;
            int Pos = Du - Exp;

            if (e == Exp) {
                VPF1[Pos] = 0;

                if (e == Exp && Pos == 1) {
                    VPF1[Pos] = 0;
                    VPF1[0] = 0;
                }
            }
        }
        for (i = 0; i < VPF1.length; i++) {
            System.out.print("[" + VPF1[i] + "]");
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

    public void Evaluar(int x) {

        int i, Exp;
        double Res = 0;

        for (i = 1; i < VPF1.length; i++) {
            Exp = Du - i;
            Res = Res + (VPF1[i] * Math.pow(x, Exp));
        }

        System.out.println("El resultado es: \n" + Res);

        for (i = 0; i < VPF1.length; i++) {
            System.out.print("[" + VPF1[i] + "]");
        }
    }

    public void Reconstruir() {

        int exp;

        for (int i = 1; i < VPF1.length; i++) {

            exp = VPF1[0] - (i - 1);

            if (VPF1[i] != 0) {

                if (exp == 0) {

                    if (VPF1[i] < 0) {
                        System.out.print(VPF1[i]);
                    } else {
                        if (i != 1) {
                            System.out.print("+" + VPF1[i]);
                        } else {
                            System.out.print(VPF1[i]);
                        }
                    }

                } else if (exp == 1) {
                    if (VPF1[i] < 0) {
                        System.out.print(VPF1[i] + "x");
                    } else {
                        if (i != 1) {
                            System.out.print("+" + VPF1[i] + "x");
                        } else {
                            System.out.print(VPF1[i] + "x");
                        }
                    }

                } else if (VPF1[i] > 0) {
                    if (i != 1) {
                        System.out.print("+" + VPF1[i] + "x" + "^" + exp);
                    } else {
                        System.out.print(VPF1[i] + "x" + "^" + exp);
                    }
                } else {
                    System.out.print(+VPF1[i] + "x" + "^" + exp);
                }
            }
        }
    }

    public void SumaPolinomiosF1(PF1 F12) {

        int i, j, k, exp1, exp2, n;
        boolean igual = false, vpmayor = false, f12mayor = false;

        if ((VPF1[0] + 1) == (F12.getDu())) {
            igual = true;
        } else {
            if ((VPF1[0] + 1) > (F12.getVPF1()[0] + 1)) {
                vpmayor = true;
            } else {
                f12mayor = true;
            }

            if (igual == true || vpmayor == true) {
                n = Du + 1;
            } else {
                n = F12.getDu() + 1;
            }
            int[] VecR = new int[n];

            if (igual == true || vpmayor == true) {
                VecR[0] = VPF1[0];
            } else {
                VecR[0] = F12.getVPF1()[0];
            }
            i = 1;
            j = 1;

            for (k = 1; k <= (VecR[0] + 1); k++) {
                exp1 = (VPF1[0] + 1) - i;
                exp2 = (F12.getVPF1()[0] + 1) - j;

                if (exp1 == exp2) {
                    VecR[k] = VPF1[i] + F12.getVPF1()[j];
                    i++;
                    j++;
                } else {
                    if (exp1 > exp2) {
                        VecR[k] = VPF1[i];
                        i++;
                    } else {
                        VecR[k] = F12.getVPF1()[i];
                        j++;
                    }
                }
            }
            System.out.println("\n");
            for (i = 0; i < VecR.length; i++) {
                System.out.print("[" + VecR[i] + "]");
            }
        }
    }

    public void MultiplicacionF1(PF1 F13) {

        int i = 1, j = 1, Res = 0;
        int VecR[] = new int[Du + F13.Du];

        VecR[0] = (Du - 1) + F13.Du - 1;

        for (j = 1; j <= F13.Du; j++) {
            for (i = 1; i <= Du; i++) {
                int ExpA = Du - i, ExpB = F13.Du - j, ExpC = ExpA + ExpB;
                int pos = (VecR[0] + 1) - ExpC;
                Res = VPF1[i] * F13.getVPF1()[j];
                VecR[pos] = VecR[pos] + Res;
            }
            i = 1;
        }
        System.out.println("\n");
        for (i = 0; i < VecR.length; i++) {
            System.out.print("[" + VecR[i] + "]");
        }
    }

}
