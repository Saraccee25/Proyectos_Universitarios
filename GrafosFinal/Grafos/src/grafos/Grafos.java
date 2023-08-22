package grafos;

import Mostrar.MostrarGrafico;
import java.util.Scanner;
import java.util.ArrayList;

public class Grafos {

    public static void main(String[] args) {
        int opc = 0;
        Grafo g = new Grafo();

        //Ingreso de datos       
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese los vertices: ");
        String Vertices = lectura.next();
        System.out.println("Ingrese los lados: ");
        String Lados = lectura.next();

        //Separar datos
        String VecV[] = Vertices.split(",");
        g.setVertices(VecV);
        char VecAux[] = Lados.toCharArray();
        ArrayList<Character> VecL = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < VecAux.length; i++) {
            if (Character.isLetterOrDigit(VecAux[i])) {
                VecL.add(VecAux[i]);
                j++;
            }
        }

        //MENU
        do {
            System.out.println("|Menú Principal Grafos|");
            System.out.println("1. Matriz de adyacencia");
            System.out.println("2. Lista de adyacencia");
            System.out.println("3. Matriz de incidencia");
            System.out.println("4. Matriz de adyacencia con pesos");
            System.out.println("5. Distancia mínima entre dos nodos");
            System.out.println("6. BFS");
            System.out.println("7. DFS");
            System.out.println("8. Mostrar");
            System.out.println("0. Salir");
            opc = lectura.nextInt();

            switch (opc) {
                case 1:
                    g.matrizAdyacencia(VecV.length, VecV, VecL);
                    break;
                case 2:
                    g.ListaAdyacencia(VecV.length, g.getMA(), VecV);
                    break;
                case 3:
                    g.matrizIncidencia(VecL, VecV);
                    break;
                case 4:
                    g.matrizAdyacenciaPesos(VecV.length, VecV, VecL);
                    break;
                case 5:
                    System.out.println("Ingrese vertice 1");
                    char vertice1 = lectura.next().charAt(0);
                    System.out.println("Ingrese vertice 2");
                    char vertice2 = lectura.next().charAt(0);
                    g.distanciaMinima(vertice1, vertice2, VecV, g.getMAP());
                    break;
                case 6:
                    g.BFS(g.getMA(), VecV);
                    break;
                case 7:
                    g.matrizAdyacencia(VecV.length, VecV, VecL);
                    g.ListaAdyacencia(VecV.length, g.getMA(), VecV);
                    //g.DFS( VecV[2]);

                    break;
                case 8:
                    g.matrizAdyacencia(VecV.length, VecV, VecL);
                    MostrarGrafico grafico = new MostrarGrafico(g.getMA(), VecV);
                    grafico.mostrar();

            }
        } while (opc != 0);

    }

}
