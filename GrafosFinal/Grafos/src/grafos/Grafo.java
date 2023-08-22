package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Grafo {

    private Nodo Punta;
    private int[][] MA;
    private int[][] MAP;
    private Nodo ady[];
    private String vertices[];

    public Grafo() {
        this.Punta = Punta;
        this.MA = MA;
        this.MAP = MAP;
    }

    public String[] getVertices() {
        return vertices;
    }

    public void setVertices(String[] vertices) {
        this.vertices = vertices;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public int[][] getMA() {
        return MA;
    }

    public void setMA(int[][] MA) {
        this.MA = MA;
    }

    public int[][] getMAP() {
        return MAP;
    }

    public void setMAP(int[][] MI) {
        this.MAP = MI;
    }

    public Nodo[] getAdy() {
        return ady;
    }

    public void setAdy(Nodo[] ady) {
        this.ady = ady;
    }

    public void matrizAdyacencia(int n, String[] VecV, ArrayList<Character> VecL) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < VecL.size(); i += 3) {//no se di de 2 en dos
            char lado1 = VecL.get(i);
            char lado2 = VecL.get(i + 1);

            int i1 = buscarIndice(VecV, lado1);
            int i2 = buscarIndice(VecV, lado2);

            if (i1 != -1 && i2 != -1) {
                mat[i1][i2] += 1;

                if (NoDirigido(VecV, VecL)) {
                    mat[i2][i1] += 1;
                }
            }
        }
        setMA(mat);
   
        imprimirMatriz(mat);
    }
    public void matrizAdyacenciaPesos(int n, String[] VecV, ArrayList<Character> VecL) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < VecL.size(); i += 3) {
            char lado1 = VecL.get(i);
            char lado2 = VecL.get(i + 1);
            char pesoChar = VecL.get(i + 2);

            int i1 = buscarIndice(VecV, lado1);
            int i2 = buscarIndice(VecV, lado2);

            if (i1 != -1 && i2 != -1) {
                int peso = Character.getNumericValue(pesoChar);

                mat[i1][i2] = peso;

                if (NoDirigido(VecV, VecL)) {
                    mat[i2][i1] = peso;
                }
            }
        }

        setMAP(mat);
        imprimirMatriz(mat);
    }

    public int buscarIndice(String[] vector, char caracter) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].charAt(0) == caracter) {
                return i;
            }
        }
        return -1;
    }

    public boolean NoDirigido(String[] VecV, ArrayList<Character> VecL) {
        for (int i = 0; i < VecL.size(); i += 3) {
            char lado1 = VecL.get(i);
            char lado2 = VecL.get(i + 1);

            if (VecL.indexOf(lado2) < VecL.indexOf(lado1)) {
                return false;
            }
        }
        return true;
    }
    

    
 

    public void imprimirMatriz(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void ListaAdyacencia(int n, int Mat[][], String[] vertices) {
        Nodo[] Vec = new Nodo[n];
        for (int i = 0; i < Mat.length; i++) {
            Nodo x = null;
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    if (x == null) {
                        x = new Nodo(vertices[j]);
                        Vec[i] = x;
                    } else {
                        Nodo p = new Nodo(vertices[j]);
                        x.setLiga(p);
                        x = p;
                    }
                }
            }
        }
        for (int i = 0; i < Vec.length; i++) {
            Nodo p = Vec[i];

            System.out.print("Vec[" + i + "]: ");

            while (p != null) {
                System.out.print(p.getDato() + " ");
                p = p.getLiga();
            }

            System.out.println();
        }
        setAdy(Vec);

    }

    int contarLados(ArrayList<Character> VecL) {
        int numL = 0;
        for (int i = 0; i < VecL.size(); i += 3) {
            numL++;
        }
        return numL;
    }

    void matrizIncidencia(ArrayList<Character> vecL, String VecV[]) {
        ArrayList<Character> pesos = VectorPeso(vecL);
        int mat[][] = new int[VecV.length][pesos.size()];
        int x = 0;
        for (int i = 0; i < vecL.size(); i += 3) {

            int pos1 = buscarIndice(VecV, vecL.get(i));
            int pos2 = buscarIndice(VecV, vecL.get(i + 1));

            mat[pos1][(Character.getNumericValue(pesos.get(x))) - 1] = 1;
            mat[pos2][(Character.getNumericValue(pesos.get(x))) - 1] = 2;

            x++;
        }

        imprimirMatriz(mat);

    }

    ArrayList<Character> VectorPeso(ArrayList<Character> VecL) {

        ArrayList<Character> pesos = new ArrayList<>();

        for (int i = 2; i < VecL.size(); i += 3) {
            pesos.add(VecL.get(i));
        }
        return pesos;
    }

    public void DFS(int v) {

        Nodo p;
        int w;
        int Visitado[] = new int[v];
    }

    public void distanciaMinima(char v1, char v2, String[] VecV, int mat[][]) {

        int ind1 = buscarIndice(VecV, v1);
        int ind2 = buscarIndice(VecV, v2);

        int numVertices = VecV.length;
        int[] distancias = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        int[] antecesores = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
            antecesores[i] = -1;
        }
        distancias[ind1] = 0;
        for (int count = 0; count < numVertices - 1; count++) {
            int u = obtenerVerticeNoVisitadoConDistanciaMinima(distancias, visitados);
            visitados[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visitados[v] && mat[u][v] != 0 && distancias[u] != Integer.MAX_VALUE
                        && distancias[u] + mat[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + mat[u][v];
                    antecesores[v] = u;
                }
            }
        }

        if (distancias[ind2] != Integer.MAX_VALUE) {
            System.out.println("La distancia mínima entre " + v1 + " y " + v2 + " es: " + distancias[ind2]);

            // Construir el camino más corto
            ArrayList<Character> camino = construirCaminoMasCorto(ind2, antecesores, VecV);
            System.out.print("Camino: ");
            for (int i = camino.size() - 1; i >= 0; i--) {
                System.out.print(camino.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("No existe un camino válido entre " + v1 + " y " + v2);
        }
    }

    private int obtenerVerticeNoVisitadoConDistanciaMinima(int[] distancias, boolean[] visitados) {
        int minDistancia = Integer.MAX_VALUE;
        int minVertice = -1;

        for (int v = 0; v < distancias.length; v++) {
            if (!visitados[v] && distancias[v] <= minDistancia) {
                minDistancia = distancias[v];
                minVertice = v;
            }
        }

        return minVertice;
    }

    private ArrayList<Character> construirCaminoMasCorto(int destino, int[] antecesores, String[] VecV) {
        ArrayList<Character> camino = new ArrayList<>();
        int vertice = destino;
        while (vertice != -1) {
            camino.add(VecV[vertice].charAt(0));
            vertice = antecesores[vertice];
        }
        return camino;
    }

    public void BFS(int[][] MatrizAdy, String[] vertex) {
        boolean[] visitado = new boolean[vertex.length];

        for (int i = 0; i < vertex.length; i++) {
            visitado[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int inicio = 0;
        visitado[inicio] = true;
        queue.offer(inicio);

        while (!queue.isEmpty()) {

            int v = queue.poll();
            System.out.print(vertex[v] + " ");
            for (int i = 0; i < vertex.length; i++) {
                if (MatrizAdy[v][i] == 1 && !visitado[i]) {

                    visitado[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
