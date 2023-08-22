
package matricesdispersas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

public class MatricesDispersas {

    public static void main(String[] args) {
        
        int opcion0, opcion1, opcion2, opcion3;
        
//        NumerosAleatorios();
//        int Mat[][] = MatrizAleatoria();
//        int ContD = contarDatosDiferentesDeCero(Mat);
//        
//        System.out.println("");
//        System.out.println("");
//        
//        NumerosAleatorios();
//        int Mat2[][] = MatrizAleatoria();
//        int cont2 = contarDatosDiferentesDeCero(Mat2);

        //MATRIZ 1 DE PRUEBA
        int Mat[][]= new int[4][3];
        Mat[0][0]=20;
        Mat[0][2]=7;
        Mat[1][2]=5;
        Mat[2][1]=20;
        Mat[2][0]=3;

        int ContD=5;
               
        //MATRIZ 2 DE PRUEBA
        int Mat2[][]= new int[3][4];
        Mat2[0][1]=19;
        Mat2[0][2]=-11;
        Mat2[1][1]=1;
        Mat2[2][0]=2;
        Mat2[2][2]=5;

        int cont2=5;
        do {
            opcion0= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Tripletas.\n"
                                                                    +  "2. Forma 1.\n"
                                                                    +  "3. Forma 2.\n"
                                                                    +  "4. F1 + F2 = T\n"
                                                                    +  "0. Salir", "MENÚ PRINCIPAL",0));
            switch (opcion0) {
                case 1:
                    
                    Tripleta T = new Tripleta(ContD);
                    T.Construir(Mat, ContD);
                    Tripleta T2 = new Tripleta(cont2);
                    T2.Construir(Mat2, cont2);
                    
                    do {
                            opcion1= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar tripleta.\n"
                                                                                    +  "2. Mostrar matriz.\n"
                                                                                    +  "3. Sumar filas.\n"
                                                                                    +  "4. Sumar columnas.\n"
                                                                                    +  "5. Eliminar dato por dato.\n"
                                                                                    +  "6. Eliminar dato por posición.\n"
                                                                                    +  "7. Insertar dato.\n"
                                                                                    +  "8. Sumar  dos tripletas.\n"
                                                                                    +  "9. Multiplicar dos tripletas.\n"
                                                                                    +  "0. Salir", "MENÚ TRIPLETAS",1));
                            switch (opcion1) {
                                case 1:
                                    T.MostrarTripleta();
                                    System.out.println();
                                    break;
                                case 2:
                                    MostrarMatrizNormal(Mat);
                                    System.out.println();
                                    break;
                                case 3:
                                    T.SumaFilas();
                                    System.out.println();
                                    break;
                                case 4:
                                    T.SumaColumnas();
                                    System.out.println();
                                    break;
                                case 5:
                                    int d=Integer.parseInt(JOptionPane.showInputDialog("Insertar dato a eliminar: "));
                                    T.EliminarDatoDato(d);
                                    break;
                                case 6:
                                    int f=Integer.parseInt(JOptionPane.showInputDialog("Insertar fila a eliminar: "));
                                    int c=Integer.parseInt(JOptionPane.showInputDialog("Insertar columna a eliminar: "));
                                    T.EliminarDatoPos(f,c);
                                    break;
                                case 7:
                                    int x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar: "));
                                    int f1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila donde desea insertar el dato: "));
                                    int c1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna donde desea insertar el dato: "));
                                    T.Insertar(x, f1, c1);
                                    break;
                                case 8:
                                    MostrarMatrizNormal(Mat2);
                                    System.out.println();
                                    System.out.println();
                                    T2.MostrarTripleta();
                                    System.out.println();
                                    System.out.println();
                                    if(T.getTripleta().length==T2.getTripleta().length){
                                        T.SumarTripletas(T2);
                                        System.out.println();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "No se pueden sumar ");
                                    }
                                    break;
                                case 9:
                                    MostrarMatrizNormal(Mat2);
                                    System.out.println();
                                    System.out.println();
                                    T2.MostrarTripleta();
                                    System.out.println();
                                    System.out.println();
                                    if(T.getTripleta(0, 0)==T2.getTripleta(0, 1)){
                                        T.MultiplicarTripletas(T2);
                                    }
                                    else{
                                        System.out.println("Las matrices no se pueden multiplicar ");
                                    }
                                    System.out.println();
                                    break;
                                case 0:

                                    break;
                                default:
                                    System.out.println("Opción inválida, por favor elija otra.");
                            }
                        } while (opcion1 != 0);
                    break;
                case 2:
                    
                    Forma1 F1 = new Forma1();
                    F1.Construir(Mat);
                    Forma1 F12 = new Forma1();
                    F12.Construir(Mat2);
                    
                    do {
                            opcion2= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar forma 1.\n"
                                                                                    +  "2. Mostrar matriz.\n"
                                                                                    +  "3. Sumar filas.\n"
                                                                                    +  "4. Sumar columnas.\n"
                                                                                    +  "5. Eliminar dato por dato.\n"
                                                                                    +  "6. Eliminar dato por posición.\n"
                                                                                    +  "7. Insertar dato.\n"
                                                                                    +  "8. Sumar  dos forma 1.\n"
                                                                                    +  "9. Multiplicar dos forma 1.\n"
                                                                                    +  "0. Salir", " MENÚ FORMA 1 ",2));
                            switch (opcion2) {
                                case 1:
                                    F1.MostrarForma1();
                                    System.out.println();
                                    break;
                                case 2:
                                    MostrarMatrizNormal(Mat);
                                    System.out.println();
                                    break;
                                case 3:
                                    F1.SumaFilas();
                                    System.out.println();
                                    break;
                                case 4:
                                    F1.SumaColumnas();
                                    System.out.println();
                                    break;
                                case 5:
                                    int d=Integer.parseInt(JOptionPane.showInputDialog("Insertar dato a eliminar: "));
                                    F1.EliminarDatoDato(d);
                                    break;
                                case 6:
                                    int f=Integer.parseInt(JOptionPane.showInputDialog("Insertar fila a eliminar: "));
                                    int c=Integer.parseInt(JOptionPane.showInputDialog("Insertar columna a eliminar: "));
                                    F1.EliminarDatoPos(f,c);
                                    break;
                                case 7:
                                    int x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar: "));
                                    int f1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila donde desea insertar el dato: "));
                                    int c1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna donde desea insertar el dato: "));
                                    F1.Insertar(x, f1, c1);
                                    break;
                                case 8:
                                    if(F1.Punta.getFila()==F12.Punta.getFila() && F1.Punta.getCol()==F12.Punta.getCol()){
                                        F1.SumarForma1(F12);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Las matrices no se pueden sumar ");
                                    }
                                    break;
                                case 9:
                                    F12.MostrarForma1();
                                    System.out.println();
                                    System.out.println();
                                    MostrarMatrizNormal(Mat2);
                                    System.out.println();
                                    System.out.println();
                                    F1.MultiplicarForma1(F12);
                                    break;
                                case 0:

                                    break;
                                default:
                                    System.out.println("Opción inválida, por favor elija otra.");
                            }
                        } while (opcion2 != 0);
                    break;
                case 3:
                    
                    Forma2 F2 = new Forma2();
                    F2.Crear(Mat);
                    Forma2 F22 = new Forma2();
                    F22.Crear(Mat2);
                    
                    do {
                            opcion3= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar forma 2.\n"
                                                                                    +  "2. Mostrar matriz.\n"
                                                                                    +  "3. Sumar filas.\n"
                                                                                    +  "4. Sumar columnas.\n"
                                                                                    +  "5. Eliminar dato por dato.\n"
                                                                                    +  "6. Eliminar dato por posición.\n"
                                                                                    +  "7. Insertar dato.\n"
                                                                                    +  "8. Sumar  dos forma 2.\n"
                                                                                    +  "9. Multiplicar dos forma 2.\n"
                                                                                    +  "0. Salir", " MENÚ FORMA 2 ",3));
                            switch (opcion3) {
                                case 1:
                                    F2.MostrarForma2();
                                    break;
                                case 2:
                                    MostrarMatrizNormal(Mat);
                                    System.out.println();
                                    break;
                                case 3:
                                    F2.SumaFilas();
                                    System.out.println();
                                    break;
                                case 4:
                                    F2.SumaColumnas();
                                    System.out.println();
                                    break;
                                case 5:
                                    int d=Integer.parseInt(JOptionPane.showInputDialog("Insertar dato a eliminar: "));
                                    F2.EliminarDatoDato(d);
                                    break;
                                case 6:
                                    int f=Integer.parseInt(JOptionPane.showInputDialog("Insertar fila a eliminar: "));
                                    int c=Integer.parseInt(JOptionPane.showInputDialog("Insertar columna a eliminar: "));
                                    F2.EliminarDatoPos(f,c);
                                    break;
                                case 7:
                                    int x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar: "));
                                    int f1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila donde desea insertar el dato: "));
                                    int c1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna donde desea insertar el dato: "));
                                    F2.Insertar(x, f1, c1);
                                    break;
                                case 8:
                                    if(F2.Punta.getFila()==F22.Punta.getFila() && F2.Punta.getCol()==F22.Punta.getCol()){
                                        F2.SumarForma2(F22);
                                    }
                                    else{
                                        System.out.println("Las matrices no se pueden sumar ");
                                    }
                                    break;
                                case 9:
                                    F2.MultiplicarForma2(F22);
                                    break;
                                case 0:

                                    break;
                                default:
                                    System.out.println("Opción inválida, por favor elija otra.");
                            }
                        } while (opcion3 != 0);
                    break;
                case 4:
                    Forma1 F13 = new Forma1();
                    F13.Construir(Mat);
                    Forma2 F23 = new Forma2();
                    F23.Crear(Mat2);
                    Tripleta T3 = new Tripleta(F13.Punta.getFila()*F13.Punta.getCol()+1);
                    if(F13.Punta.getFila()==F23.Punta.getFila() && F13.Punta.getCol()==F23.Punta.getCol()){
                        T3.SumaF1F2(F13, F23);
                    }
                    else{
                        System.out.println("Las matrices no se pueden sumar porque no tienen el mismo tamaño");
                    }
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opción inválida, por favor elija otra.");
            }
        } while (opcion0 != 0);

    }//CIERRE DEL PRINCIPAL
    
    public static void MostrarMatrizNormal(int[][] Mat) {

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                System.out.print("|" + Mat[i][j] + "|");
            }
            System.out.println();
        }
    }//CIERRE DEL METODO
    
    public static void NumerosAleatorios(){
        
        try {
            FileWriter writer = new FileWriter("./archivos/numeros.txt");
            Random rand = new Random();
            int num_elementos = rand.nextInt(50) + 1;
            for (int i = 0; i < num_elementos; i++) {
                int num = rand.nextInt(10);
                writer.write(Integer.toString(num));
                if (i != num_elementos - 1) {
                    writer.write(",");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }//CIERRE DEL METODO
    
    public static int[][] MatrizAleatoria(){
        
         // Generar un tamaño aleatorio para la matriz
        Random rand = new Random();
        int tam = rand.nextInt(10) + 1; // Genera un número aleatorio entre 1 y 10

        // Crear la matriz
        int[][] matriz = new int[tam][tam];

        String archivo = "./archivos/numeros.txt";
        ArrayList<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] numerosLinea = linea.split(",");
                for (int i = 0; i < numerosLinea.length; i++) {
                    numeros.add(Integer.parseInt(numerosLinea[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(numeros);
        int numElementos = Math.min(numeros.size(), tam*tam/2);
        for (int i = 0; i < numElementos; i++) {
            int fila = rand.nextInt(tam);
            int columna = rand.nextInt(tam);
            while (matriz[fila][columna] != 0) {
                fila = rand.nextInt(tam);
                columna = rand.nextInt(tam);
            }
            matriz[fila][columna] = numeros.get(i);
        }

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        
        return matriz;
        
    }//CIERRE DEL METODO
    
    public static int contarDatosDiferentesDeCero(int[][] matriz) {
        
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    cont++;
                }
            }
        }
        return cont;
        
    }//CIERRE DEL METODO
    
}//CIERRE DE LA CLASE
