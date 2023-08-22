package matricesdispersas;
import java.util.Random;

public class Tripleta {

    //Atributos
    private int Tripleta[][];

    public Tripleta(int D) {//datos diferentes de 0
        Tripleta = new int[D + 1][3];
    }

    public int[][] getTripleta() {
        return Tripleta;
    }

    public void setTripleta(int[][] Tripleta) {
        this.Tripleta = Tripleta;
    }

    public int getTripleta(int i, int j) {
        return Tripleta[i][j];
    }

    public void setTripleta(int i, int j, int d) {
        this.Tripleta[i][j] = d;
    }

    public void Construir(int[][] Mat, int ContD) {

        int k = 1;

        Tripleta[0][0] = Mat.length;
        Tripleta[0][1] = Mat[0].length;
        Tripleta[0][2] = ContD;

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {

                if (Mat[i][j] != 0) {
                    Tripleta[k][0] = i;
                    Tripleta[k][1] = j;
                    Tripleta[k][2] = Mat[i][j];
                    k++;
                }
            }
        }
    }//CIERRE DEL CONSTRUIR

    public void MostrarTripleta() {

        for (int i = 0; i < Tripleta.length; i++) {
            for (int j = 0; j < Tripleta[0].length; j++) {
                System.out.print("|" + Tripleta[i][j] + "|");
            }
            System.out.println();
        }
        
    }//CIERRE DEL MOSTRAR

    public void SumaFilas() {

        int k = 1;
        int VF[] = new int[Tripleta[0][0]];

        while (k <= Tripleta[0][2]) {
            VF[Tripleta[k][0]] += Tripleta[k][2];
            k++;
        }
        System.out.print("Suma filas tripleta: ");
        for (int i = 0; i < VF.length; i++) {
            System.out.print("|" + VF[i] + "|");
        }
        
    }//CIERRE DEL SUMARFILAS

    public void SumaColumnas() {

        int k = 1;
        int VF[] = new int[Tripleta[0][1]];

        while (k <= Tripleta[0][2]) {
            VF[Tripleta[k][1]] += Tripleta[k][2];
            k++;
        }
        System.out.print("Suma columnas tripleta: ");
        for (int i = 0; i < VF.length; i++) {
            System.out.print("|" + VF[i] + "|");
        }
        
    }//CIERRE DEL SUMARCOLUMNAS

    public void EliminarDatoDato(int d) {

        int k = 1, cont = 0;

        while (k <= Tripleta[0][2]) {
            if (Tripleta[k][2] != d) {
                k++;
            } else {
                if (Tripleta[k][2] == d) {
                    cont++;
                    Tripleta[k][0] = 0;
                    Tripleta[k][1] = 0;
                    Tripleta[k][2] = 0;
                    k++;
                }
            }
        }

        RedimensionarP(cont);
        
    }//CIERRE DEL ELIMINAR

    public void EliminarDatoPos(int f, int c) {

        int k = 1, cont = 0;

        while (k <= Tripleta[0][2]) {

            if (Tripleta[k][0] != f && Tripleta[k][1] != c) {
                k++;
            } else {
                if (Tripleta[k][0] == f && Tripleta[k][1] == c) {

                    Tripleta[k][0] = 0;
                    Tripleta[k][1] = 0;
                    Tripleta[k][2] = 0;
                    cont++;
                    k++;
                } else {
                    k++;
                }
            }
        }

        RedimensionarP(cont);

    }//CIERRE DEL ELIMINAR

    public void RedimensionarP(int cont) {

        int Tripleta2[][] = new int[(Tripleta[0][2] + 1) - cont][3];
        int x = 0, y = 0;
        boolean algo = false;

        for (int i = 0; i <= Tripleta[0][2]; i++) {
            for (int j = 0; j < 3; j++) {

                if (Tripleta[i][2] != 0) {
                    algo = false;
                    Tripleta2[x][y] = Tripleta[i][j];

                    if (y < 3) {
                        y++;
                    }
                } else {
                    algo = true;
                    break;
                }
            }
            y = 0;
            if (algo == false) {
                if (x <= (Tripleta[0][2] + 1) - cont) {
                    x++;
                }
            }
        }

        Tripleta2[0][2] = Tripleta[0][2] - cont;
        this.setTripleta(Tripleta2);

        MostrarTripleta();
        
    }//CIERRE DEL METODO

    public void Insertar(int d, int f1, int c1) {
        int k = 1;
        int i = 1;
        boolean algo = true;
        int Tripleta2[][] = new int[Tripleta[0][2] + 2][3];

        while (k <= Tripleta[0][2]) {
            if (algo) {
                if (f1 >= Tripleta[k][0] && c1 >= Tripleta[k][1]) {
                    if (f1 == Tripleta[k][0] && c1 == Tripleta[k][1]) {
                        Tripleta[k][2] = Tripleta[k][2] + d;
                    } else {
                        k++;
                    }
                } else {
                    //redimen
                    if (Tripleta[k][0] == f1 && Tripleta[k][1] > c1) {
                        //Tripleta2 =RedimGrande(Tripleta2,k,f1,c1,d);
                        Tripleta2[0][0] = Tripleta[0][0];
                        Tripleta2[0][1] = Tripleta[0][1];
                        Tripleta2[0][2] = Tripleta[0][2] + 1;

                        while (i < k) {
                            Tripleta2[i][0] = Tripleta[i][0];
                            Tripleta2[i][1] = Tripleta[i][1];
                            Tripleta2[i][2] = Tripleta[i][2];
                            i++;
                        }
                        Tripleta2[i][0] = f1;
                        Tripleta2[i][1] = c1;
                        Tripleta2[i][2] = d;
                        i++;
                        algo = false;
                    } else {
                        if (Tripleta[k][0] > f1) {
                            //redi
                             //Tripleta2 =RedimGrande(Tripleta2,k,f1,c1,d);
                        Tripleta2[0][0] = Tripleta[0][0];
                        Tripleta2[0][1] = Tripleta[0][1];
                        Tripleta2[0][2] = Tripleta[0][2] + 1;

                        while (i < k) {
                            Tripleta2[i][0] = Tripleta[i][0];
                            Tripleta2[i][1] = Tripleta[i][1];
                            Tripleta2[i][2] = Tripleta[i][2];
                            i++;
                        }
                        Tripleta2[i][0] = f1;
                        Tripleta2[i][1] = c1;
                        Tripleta2[i][2] = d;
                        i++;
                        algo = false;
                        } else {
                            k++;
                        }
                    }
                }
            } else//algo
            {
                Tripleta2[i][0] = Tripleta[k][0];
                Tripleta2[i][1] = Tripleta[k][1];
                Tripleta2[i][2] = Tripleta[k][2];
                k++;
                i++;
            }
        }
        if (algo) {
            //redim
            Tripleta2[0][0] = Tripleta[0][0];
            Tripleta2[0][1] = Tripleta[0][1];
            Tripleta2[0][2] = Tripleta[0][2] + 1;

            while (i < k) {
                Tripleta2[i][0] = Tripleta[i][0];
                Tripleta2[i][1] = Tripleta[i][1];
                Tripleta2[i][2] = Tripleta[i][2];
                i++;
            }
            Tripleta2[i][0] = f1;
            Tripleta2[i][1] = c1;
            Tripleta2[i][2] = d;
            i++;
        }
        setTripleta(Tripleta2);
        MostrarTripleta();
        
    }//CIERRE DEL INSERTAR
    
    public void MultiplicarTripletas(Tripleta T2){
        
         int TRes[][] = new int[Tripleta[0][0] * T2.getTripleta(0, 1) + 1][3];
        int i = 1, j = 1, k = 1, fila = 0, columna = 0, pos, cont = 0, c2 = -1, f2 = -1; //columna avanza cuando i acaba, avanza columna reinicia i
        boolean algo2 = false;
        boolean finalDeColumna = false;

        while (i <= Tripleta[0][2]) {
            pos = i;
            fila = Tripleta[i][0];
            while (columna < T2.getTripleta(0, 1)) {
                if (Tripleta[i][0] == fila) {
                    while (j <= T2.getTripleta(0, 2)) {
                        if (Tripleta[i][1] == T2.getTripleta(j, 0) && columna == T2.getTripleta(j, 1)) {
                            if (Tripleta[i][2] * T2.getTripleta(j, 2) != 0) {
                                if (f2 == fila && c2 == columna) {
                                    TRes[k - 1][2] = TRes[k - 1][2] + (Tripleta[i][2] * T2.getTripleta(j, 2));
                                } else {
                                    TRes[k][2] = Tripleta[i][2] * T2.getTripleta(j, 2);
                                    TRes[k][0] = fila;
                                    TRes[k][1] = columna;
                                    if (k < TRes.length) {
                                        k++;
                                    }
                                    cont++;
                                    if (k == cont) {
                                        break;
                                    }
                                }
                                f2 = fila;
                                c2 = columna;
                            }
                        }
                        j++;
                    }
                    j = 1;
                    if (i < Tripleta[0][2]) {
                        i++;

                    } else {
                        if (i == Tripleta[0][2]) {
                            algo2 = true;
                            i = pos + 1;
                        }
                    }

                    if (algo2 == true) {
                        if (columna == T2.getTripleta(0, 1) - 1) {
                            break;
                        } else {
                            if (columna < T2.getTripleta(0, 1)) {
                                columna++;
                                //i = pos+1;
                            }
                        }
                        algo2 = false;
                    }
                } else {
                    if (columna == T2.getTripleta(0, 1) - 1) {
                        columna++;
                        pos = i;
                        fila = Tripleta[i][0];
                    } else {
                        if (columna < T2.getTripleta(0, 1)) {
                            columna++;
                            i = pos;
                        }
                    }

                }

            }
            
            if (i == Tripleta[0][2] && columna == T2.getTripleta(0, 1) - 1) {
                break;
            }

            columna = 0;

        }

        TRes[0][0] = Tripleta[0][0];
        TRes[0][1] = T2.getTripleta(0, 1);
        TRes[0][2] = cont;
        setTripleta(TRes);
        int Tripleta2[][] = new int[cont + 1][3];
        int x = 0, y = 0;
        boolean algo = false;

        for (i = 0; i <= Tripleta[0][2]; i++) {
            for (j = 0; j < 3; j++) {

                if (Tripleta[i][2] != 0) {
                    algo = false;
                    Tripleta2[x][y] = Tripleta[i][j];

                    if (y < 3) {
                        y++;
                    }
                } else {
                    algo = true;
                    break;
                }
            }
            y = 0;
            if (algo == false) {
                if (x <= (cont + 1)) {
                    x++;
                }
            }
        }
        setTripleta(Tripleta2);
        Tripleta[0][2] = cont;
        MostrarTripleta();
 
        
    }//CIERRE DEL MULTIPLICAR
    
    public void SumarTripletas(Tripleta T2){
        
        int TRes[][] = new int[Tripleta[0][0]*Tripleta[0][1]+1][Tripleta[0][1]];
        int k=1,i=1,j=1, cont=0;
        
        TRes[0][0]=Tripleta[0][0];
        TRes[0][1]=Tripleta[0][1];
        
        while(k<=Tripleta[0][2] || i<=T2.getTripleta(0, 2)){
            
            if(Tripleta[k][0]==Tripleta[i][0] && Tripleta[k][1]==T2.getTripleta(i, 1)){
                
                TRes[j][0]=Tripleta[k][0];
                TRes[j][1]=Tripleta[k][1];
                TRes[j][2]=Tripleta[k][2]+T2.getTripleta(i, 2);
                cont++;
                
                if(TRes[j][2]!=0){
                    j++;
                }
                k++; i++;
            }
            else{
                if((Tripleta[k][0]==T2.getTripleta(i, 0) && Tripleta[k][1]<T2.getTripleta(i, 1)) || (Tripleta[k][0]<T2.getTripleta(i, 0))){
                    
                    TRes[j][0]=Tripleta[k][0];
                    TRes[j][1]=Tripleta[k][1];
                    TRes[j][2]=Tripleta[k][2];
                    k++; j++;
                    cont++;
                }
                else{
                    if(T2.getTripleta(i, 0)<Tripleta[k][0] || (T2.getTripleta(i, 0)==Tripleta[k][0] && T2.getTripleta(i, 1)<Tripleta[k][1])){
                        TRes[j][0]=T2.getTripleta(i, 0);
                        TRes[j][1]=T2.getTripleta(i, 1);
                        TRes[j][2]=T2.getTripleta(i, 2);
                        i++; j++;
                        cont++;
                    }             
                }
            }
            
            if(i==T2.getTripleta().length && k<Tripleta.length){
                TRes[j][0]=Tripleta[k][0];
                TRes[j][1]=Tripleta[k][1];
                TRes[j][2]=Tripleta[k][2];
                k++; j++;
                cont++;
            }
            if(k==Tripleta.length && i<T2.getTripleta().length){
                TRes[j][0]=T2.getTripleta(i, 0);
                TRes[j][1]=T2.getTripleta(i, 1);
                TRes[j][2]=T2.getTripleta(i, 2);
                i++; j++;
                cont++;
            }
            
        }
        TRes[0][2]=cont;
        setTripleta(TRes);
        int Tripleta2[][] = new int[cont+1][3];
        int x = 0, y = 0;
        boolean algo = false;

        for (i = 0; i <= Tripleta[0][2]; i++) {
            for (j = 0; j < 3; j++) {

                if (Tripleta[i][2] != 0) {
                    algo = false;
                    Tripleta2[x][y] = Tripleta[i][j];

                    if (y < 3) {
                        y++;
                    }
                } else {
                    algo = true;
                    break;
                }
            }
            y = 0;
            if (algo == false) {
                if (x <= (cont+1)) {
                    x++;
                }
            }
        }
        setTripleta(Tripleta2);
        Tripleta[0][2]=cont;
        MostrarTripleta();
        
    }//CIERRE DEL SUMAR
    
    public void SumaF1F2(Forma1 x, Forma2 y){
        
        Tripleta[0][0]=x.Punta.getFila();
        Tripleta[0][1]=x.Punta.getCol();
        Nodo p=x.Punta.getLiga(), q=p.getLigaF(), r=y.Punta, s=r.getLigaF();
        int k=1, cont=0;
        
        while(p!=x.Punta && s!=y.Punta){
            
            if(q==null && s!=y.Punta){
                Tripleta[k][0]=s.getFila();
                Tripleta[k][1]=s.getCol();
                Tripleta[k][2]=s.getDato();

                k++;
                cont++;
                s=s.getLigaF();
            }
            else{
                if(s==null && p!=x.Punta){
                    Tripleta[k][0]=q.getFila();
                    Tripleta[k][1]=q.getCol();
                    Tripleta[k][2]=q.getDato();
                    
                    k++;
                    cont++;
                    q=q.getLigaF(); 
                }
                else{
                   if(q.getFila()==s.getFila() && q.getCol()==s.getCol()){
                
                    Tripleta[k][0]=q.getFila();
                    Tripleta[k][1]=q.getCol();
                    Tripleta[k][2]=q.getDato()+s.getDato();

                    k++;
                    cont++;
                    q=q.getLigaF();
                    s=s.getLigaF();

                    }
                    else{
                        if(q.getFila()==s.getFila() && q.getCol()<s.getCol()){

                            Tripleta[k][0]=q.getFila();
                            Tripleta[k][1]=q.getCol();
                            Tripleta[k][2]=q.getDato();

                            k++;
                            cont++;
                            q=q.getLigaF();

                        }
                        else{
                            if(q.getFila()==s.getFila() && q.getCol()>s.getCol()){

                                Tripleta[k][0]=s.getFila();
                                Tripleta[k][1]=s.getCol();
                                Tripleta[k][2]=s.getDato();

                                k++;
                                cont++;
                                s=s.getLigaF();
                            }
                            else{
                                if(q.getFila()<s.getFila()){

                                    Tripleta[k][0]=q.getFila();
                                    Tripleta[k][1]=q.getCol();
                                    Tripleta[k][2]=q.getDato();

                                    k++;
                                    cont++;
                                    q=q.getLigaF();
                                }
                                else{
                                    if(q.getFila()>s.getFila()){

                                        Tripleta[k][0]=s.getFila();
                                        Tripleta[k][1]=s.getCol();
                                        Tripleta[k][2]=s.getDato();

                                        k++;
                                        cont++;
                                        s=s.getLigaF();
                                    }
                                }
                            }
                        }
                    } 
                }
            }
            
            if(q==p){
                p=p.getLiga();
                q=p.getLigaF();
            }
        }
        
        Tripleta[0][2]=cont;
        int Tripleta2[][] = new int[cont+1][3];
        int a = 0, b = 0;
        boolean algo = false;

        for (int i = 0; i <= Tripleta[0][2]; i++) {
            for (int j = 0; j < 3; j++) {

                if (Tripleta[i][2] != 0) {
                    algo = false;
                    Tripleta2[a][b] = Tripleta[i][j];

                    if (b < 3) {
                        b++;
                    }
                } else {
                    algo = true;
                    break;
                }
            }
            b = 0;
            if (algo == false) {
                if (a <= (cont+1)) {
                    a++;
                }
            }
        }
        setTripleta(Tripleta2);
        Tripleta[0][2]=cont;
        MostrarTripleta();
        
    }//CIERRE DEL SUMARF1F2
    
}//CIERRE DE LA CLASE



//public int[][] RedimGrande(int Tripleta2[][], int k, int f1, int c1, int d) {
//        int i = 1;
//        Tripleta2[0][0] = Tripleta[0][0];
//        Tripleta2[0][1] = Tripleta[0][1];
//        Tripleta2[0][2] = Tripleta[0][2] + 1;
//
//        while (i < k) {
//            Tripleta2[i][0] = Tripleta[i][0];
//            Tripleta2[i][1] = Tripleta[i][1];
//            Tripleta2[i][2] = Tripleta[i][2];
//            i++;
//        }
//        Tripleta2[i][0] = f1;
//        Tripleta2[i][1] = c1;
//        Tripleta2[i][2] = d;
//        i++;
//
//        return Tripleta2;
//    }
/*
    public void Insertar(int d, int f1, int c1){
        
        int Tripleta2[][]=new int[Tripleta[0][2]+2][3];
        int k=1,x=0,y=0,i=0,j=0;
        boolean algo=false;
        
        while(k<=Tripleta[0][2]){
            if(Tripleta[k][0]==f1 && Tripleta[k][1]==c1){
                
                algo=true;
                Tripleta[k][2] = Tripleta[k][2] + d;
                k++;
            }
            else{
                k++;
            }
        } //funciona
        
        if(algo==false){
            
            k=1;
            while(k<=Tripleta[0][2]){

                if(Tripleta[k][0]==f1 && c1<Tripleta[k][1]){

                    for(i=0 ; i<=k-1 ; i++){
                        for(j=0 ; j<3 ; j++ ){

                            Tripleta2[x][y] = Tripleta[i][j];

                            if(y<3){
                                y++;
                            }
                        }
                        y=0;
                        if(x<=k-1){  //x<=Tripleta[k-1][0]  
                            x++;
                        }
                    }

                    Tripleta2[x][2]=d;
                    Tripleta2[x][0]=f1;
                    Tripleta2[x][1]=c1;
                    x++;
                    y=0;

                    for(i=k ; i<=Tripleta[0][2] ; i++){
                        for(j=0 ; j<3 ; j++){
                            Tripleta2[x][y]=Tripleta[i][j];

                            if(y<3){
                                y++;
                            }
                        }
                        y=0;
                        if(x<=Tripleta[0][2]+1){    
                            x++;
                        }
                    }
                    break;
                }
                else{
                    if(Tripleta[k][0]==f1 && c1>Tripleta[k][1]){
                        
                        while(Tripleta[k+1][0]==f1 && k<Tripleta[0].length){//problema

                            k++;
                        }

                        if(c1>Tripleta[k][1]){

                            for(i=0; i<=k ; i++){
                                for(j=0; j<3; j++){

                                    Tripleta2[x][y]=Tripleta[i][j];

                                    if(y<3){
                                        y++;
                                    }
                                }
                                y=0;
                                if(x<=k){    
                                    x++;
                                }
                            }
                            Tripleta2[x][2]=d;
                            Tripleta2[x][1]=c1;
                            Tripleta2[x][0]=f1;
                            x++;
                            y=0;

                            for(i=i; i<Tripleta[0][2]+1; i++){
                                for(j=0; j<3; j++){
                                    Tripleta2[x][y]=Tripleta[i][j];

                                    if(y<3){
                                        y++;
                                    }
                                }
                                y=0;
                                if(x<=Tripleta[0][2]+2){    
                                    x++;
                                }
                            }
                            Tripleta2[0][2]=Tripleta[0][2]+1;
                            break;
                        }
                    } //funciona
                    else{
                        if(Tripleta[k][0]==f1 && c1>Tripleta[k][1] && c1<Tripleta[k+1][1]){
                            
                            
                            
                        }
                        else{
                            k++;
                        }
                    }
                }
            }
        this.setTripleta(Tripleta2);
        }
 
        MostrarTripleta();
    }
        
    }*/
