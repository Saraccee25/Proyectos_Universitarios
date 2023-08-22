package polinomios;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Polinomios {

    static String Vs[];

    public static void main(String[] args) {

        int Mayor, Mayor2, sum, x = 0, mayor2;
        String Monomio, Monomio2, Monomio3;
        Scanner leer = new Scanner(System.in);
        int j = 0, nterm = 0, Exp;
        int opc = 0, opc2 = 0, opc3 = 0, opc4 = 0, opc5 = 0, opc6 = 0, opc7 = 0, opc8 = 0;
        String Vs2[], Vs3[], Vs4[], Vs5[];

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la forma a la cual quiere convertir el polinomio \n"
                    + "1. Forma 1 \n"
                    + "2. Forma 2\n"
                    + "3. Forma 3 \n"
                    + "4. Operaciones combinadas",
                    "Menú Principal Polinomios ", 2));
//           
            switch (opc) {
                case 1:
                    Mayor = Ingreso();

                    PF1 VPF1 = new PF1((Mayor));
                    VPF1.Ordenar(Vs);
                    VPF1.Forma1(Vs);

                    do {

                        opc2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Insertar término\n "
                                + "\n 2. Reconstruir polinomio"
                                + " \n 3. Evaluar polinomio"
                                + " \n 4. Eliminar termino"
                                + " \n 5. Operaciones con polinomios. "
                                + "\n 6. Salir"));

                        switch (opc2) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado el ingreso de un término");
                                Monomio = JOptionPane.showInputDialog("Ingrese un monomio");
                                Vs2 = VPF1.Ingreso2(Monomio);
                                if (Integer.parseInt(Vs2[1]) > VPF1.getVPF1(0)) {
                                    VPF1.RedimensionarG(Vs2);
                                } else {
                                    VPF1.InsetarPequeño(Vs2);
                                }

                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado la reconstrucción del polinomio");
                                VPF1.Reconstruir();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado evaluar el polinomio");
                                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un monomio"));
                                VPF1.Evaluar(x);
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado eliminar un termino");
                                VPF1.Eliminar();
                                break;
                            case 5:

                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado las operaciones ");
                                opc3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese operación a realizar:\n"
                                        + "1. Suma de polinomios \n"
                                        + "2. Multiplicación de polinomios \n"));
                                Mayor = Ingreso();
                                PF1 VPF1_2 = new PF1((Mayor));
                                VPF1_2.Ordenar(Vs);
                                VPF1_2.Forma1(Vs);
                                do {
                                    switch (opc3) {
                                        case 1:
                                            VPF1.SumaPolinomiosF1(VPF1_2);
                                            break;
                                        case 2:
                                            VPF1.MultiplicacionF1(VPF1_2);
                                            break;
                                        default:
                                            break;

                                    }
                                } while (opc3 != 3);
                                break;
                        }
                    } while (opc2 != 6);
                case 2:
                    Mayor = Ingreso();
                    for (int i = 0; Vs[i] != null; i += 2) {
                        nterm++;
                    }
                    PF2 VPF2 = new PF2(nterm);
                    VPF2.Forma2(Vs);
                    do {

                        opc4 = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Insertar término\n "
                                + "\n 2. Reconstruir polinomio"
                                + " \n 3. Evaluar polinomio"
                                + " \n 4. Eliminar termino"
                                + " \n 5. Operaciones con polinomios. \n"));
                        switch (opc4) {
                            case 1:
                                Monomio3 = JOptionPane.showInputDialog("Insertar monomio: ");
                                Vs5 = VPF2.Ingreso2(Monomio3);
                                VPF2.IngresarMonomio(Vs5);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado la reconstrucción del polinomio");
                                VPF2.Reconstruir();

                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado evaluar el polinomio");
                                VPF2.Evaluar();
                                break;
                            case 4:
                                VPF2.Eliminar();
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado operaciones con polinomios");
                                opc5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese operación a realizar:\n"
                                        + "1. Suma de polinomios \n"
                                        + "2. Multiplicación de polinomios \n"));
                                Mayor = Ingreso();
                                int nterm2 = 0;
                                for (int i = 0; Vs[i] != null; i += 2) {
                                    nterm2++;
                                }
                                PF2 F21 = new PF2(nterm2);
                                F21.Forma2(Vs);
                                PF2 VPF2_2 = new PF2(nterm);
                                VPF2_2.Forma2(Vs);

                                switch (opc5) {
                                    case 1:
                                        VPF2.SumaPolinomiosF2(F21);
                                        break;
                                    case 2:
                                        VPF2.Multiplicar(F21);
                                        break;

                                    case 3:
                                        break;
                                    default:
                                        break;
                                }

                                break;

                        }
                    } while (opc4 != 3);
                    break;

                case 3:

                    PF3 LPF3 = new PF3();
                    int i = 0;
                    while (i < Vs.length - 1 && Vs[i] != null) {
                        LPF3.InsertarFinal(Integer.parseInt(Vs[i]), Integer.parseInt(Vs[i + 1]));
                        i += 2;
                    }
                    LPF3.Mostrar();

                    do {

                        opc6 = Integer.parseInt(JOptionPane.showInputDialog(null, " 1. Insertar término \n"
                                + "2. Mostrar forma \n"
                                + "3. Reconstruir polinomio \n"
                                + "4. Evaluar polinomio \n"
                                + "5. Eliminar término \n"
                                + "6. Operaciones entre polinomios \n "));
                        switch (opc6) {
                            case 1:
                                Monomio = JOptionPane.showInputDialog("Ingrese monomio a insertar");
                                Vs3 = LPF3.Ingreso2(Monomio);
                                LPF3.InsertarOrdenado(Integer.parseInt(Vs3[0]), Integer.parseInt(Vs3[1]));
                                LPF3.Mostrar();

                                break;
                            case 2:
                                LPF3.Mostrar();
                                break;
                            case 3:
                                LPF3.reconstruirPolinomio();
                                break;
                            case 4:
                                x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese número para darle valor a x"));
                                LPF3.EvalPol(x);
                                break;
                            case 5:
                                Exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente del término a eliminar"));
                                LPF3.Eliminar(Exp);
                                LPF3.Mostrar();
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, "Usted ha seleccionado operaciones con polinomios");
                                PF3 LPF3_2 = new PF3();
                                int y = 0;
                                Monomio2 = JOptionPane.showInputDialog("Ingrese nuevo polinomio");
                                Vs4 = LPF3_2.Ingreso2(Monomio2);
                                while (y < Vs4.length - 1 && Vs4[y] != null) {
                                    LPF3_2.InsertarFinal(Integer.parseInt(Vs4[y]), Integer.parseInt(Vs4[y + 1]));
                                    y += 2;
                                }
                                LPF3_2.Mostrar();
                                opc7 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese operación a realizar:\n"
                                        + "1. Suma de polinomios \n"
                                        + "2. Multiplicación de polinomios \n"));
                                switch (opc7) {
                                    case 1:
                                        PF3 LR = new PF3();
                                        LR.SumarPolinomios(LPF3, LPF3_2);
                                        //LR.Mostrar();
                                        break;
                                    case 2:
                                        PF3 LR2 = new PF3();
                                        LR2.MultiplicarPolinomios(LPF3, LPF3_2);
                                        LR2.Mostrar();
                                        break;
                                }

                                break;

                        }
                    } while (opc7 != 3);
                case 4:
                    JOptionPane.showMessageDialog(null, "Usted ha seleccionado las operaciones combinadas con polinomios");
                    opc8 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese operación a realizar:\n"
                            + "1. Suma de polinomios forma 1 con forma 3 = forma 2 \n"
                            + "2. Multiplicación de polinomios forma 2 por forma 3 = forma 1 \n"));
                    switch (opc8) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ingrese el vector forma 1");
                            Mayor = Ingreso();
                            PF1 VPF1_3 = new PF1((Mayor));
                            VPF1_3.Ordenar(Vs);
                            VPF1_3.Forma1(Vs);
                            PF3 LPF3_3 = new PF3();
                            int y = 0;
                            String Monomio4 = JOptionPane.showInputDialog("Ingrese polinomio forma 3");
                            Vs5 = LPF3_3.Ingreso2(Monomio4);
                            while (y < Vs5.length - 1 && Vs5[y] != null) {
                                LPF3_3.InsertarFinal(Integer.parseInt(Vs5[y]), Integer.parseInt(Vs5[y + 1]));
                                y += 2;
                            }
                            LPF3_3.Mostrar();
                            PF2 F21 = new PF2();
                            F21.SumarF1F3(LPF3_3, VPF1_3);
                            break;
                        case 2:

                            JOptionPane.showMessageDialog(null, "Ingrese el vector forma 2");
                            Mayor = Ingreso();
                            for (int w = 0; Vs[w] != null; w += 2) {
                                nterm++;
                            }
                            PF2 VPF2_4 = new PF2(nterm);
                            VPF2_4.Forma2(Vs);
                            PF3 LPF3_4 = new PF3();
                            int z = 0;
                            String Monomio6 = JOptionPane.showInputDialog("Ingrese polinomio forma 3");
                            Vs5 = LPF3_4.Ingreso2(Monomio6);
                            while (z < Vs5.length - 1 && Vs5[z] != null) {
                                LPF3_4.InsertarFinal(Integer.parseInt(Vs5[z]), Integer.parseInt(Vs5[z + 1]));
                                z += 2;
                            }
                            LPF3_4.Mostrar();
                            PF1 VPF1_4 = new PF1();
                            VPF1_4.Forma1(Vs);
                            VPF1_4.MultiplicarF1F3(VPF2_4, LPF3_4);
                            break;
                        default:
                            break;

                    }

            }

        } while (opc2 != 3);
    }

    public static int Ingreso() {

        int j = 0;
        String s = "";
        String sPoli = JOptionPane.showInputDialog("Insertar polinomio: ");

        char Vc[] = sPoli.toCharArray();
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

                    if (!s.equals("")) {
                        Vs[j] = s;
                        s = "";
                        j++;
                    }
                    if ((i - 1) >= 0) {
                        if (i != Vc.length - 1) {
                            if (Vc[i + 1] != '^' && (Vc[i - 1] != '-' || Vc[i - 1] != '+')) {
                                Vs[j] = "1";
                                j++;
                            }
                            if (Vc[i + 1] != '^' && (Vc[i - 1] == '-' || Vc[i - 1] == '+')) {
                                Vs[j] = "1";
                                j++;
                            }
                            if (Vc[i] == 'x' && Vc[i + 1] == '^' && Vc[i - 1] == '+') {
                                Vs[j] = "1";
                                j++;
                            }
                        }
                    }

                    if (Vc[i] == 'x' && i == Vc.length - 1) {

                        if (s.equals("")) {
                            Vs[j] = "1";
                            j++;
                        }
                        if ((i - 1) > 0) {
                            if (Vc[i - 1] == '+') {
                                Vs[j] = "1";
                                j++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (Vc[0] == 'x' && Vc[1] == '^') {
                            Vs[j] = "1";
                            j++;
                        }
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

//        return Vs;
        int i = 1;
        j = 3;
        int Mayor = 0;
        int sum;
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
        return Mayor;
    }
}
