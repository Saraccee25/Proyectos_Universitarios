
package matricesdispersas;

public class Forma2 {
    
        Nodo Punta;

    public Forma2() {
        Punta = null;
    }
    
    public void Crear(int Mat[][]){
     
        Paso1(Mat);
        Paso2();

    }//CIERRE DEL METODO
    
    private void Paso1(int Mat[][]){
        
        Nodo x = new Nodo(0,Mat.length,Mat[0].length);
        Punta=x;
        Nodo  p=Punta, q=p;
        int i=0, j=0;
        
        while(i<Punta.getFila()){
            while(j<Punta.getCol()){
                if(Mat[i][j]!=0){
                    Nodo y = new Nodo(Mat[i][j],i,j);
                    q.setLigaF(y);
                    q=q.getLigaF();
                }
                j++;
            }
            i++;
            j=0;
        }
        q.setLigaF(p);
        
    }//CIERRE DEL METODO
    
    private void Paso2(){
        
        int col=0;
        Nodo p=Punta.getLigaF(), a=Punta;
                
        while(col<Punta.getCol()){
            while(p!=Punta){
                if(p.getCol()==col){
                    a.setLigaC(p);
                    a=p;
                    p=p.getLigaF();
                }
                else{
                    p=p.getLigaF();
                }
            }
            p=Punta.getLigaF();
            col++;
        }
        a.setLigaC(Punta);
        
    }//CIERRE DEL METODO
    
    public void MostrarForma2(){
        
        Nodo p=Punta.getLigaF();
        
        System.out.print("[" + Punta.getLigaC() + "]" + "[" + Punta.getFila() + "]" + "[" + Punta.getCol() + "]" + "[" + Punta.getLigaF()+ "]"); 
        System.out.println("[" + Punta.getDato()+ "]" + "--> "); 
        
        while(p!=Punta){
            
            System.out.print("[" + p.getLigaC() + "]" + "[" + p.getFila() + "]" + "[" + p.getCol() + "]" + "[" + p.getLigaF()+ "]"); 
            System.out.println("[" + p.getDato()+ "]" + "--> ");
            
            p=p.getLigaF();
        }
        
    }//CIERRE MOSTRAR FORMA
    
    public void SumaFilas(){
        
        Nodo p=Punta.getLigaF();
        int fila=0;
        int vr[]=new int[Punta.getFila()];
        
        while(fila<Punta.getFila()){
            while(p!=Punta){
                
                if(p.getFila()==fila){
                vr[fila]+= p.getDato();
                }
                p=p.getLigaF();
            }
            fila++;
             p=Punta.getLigaF();
        }
        
        System.out.print("Suma filas forma 2: ");
        for (int i = 0; i < vr.length; i++) {
            System.out.print("|" + vr[i] + "|");
        }
        
    }//CIERRE SUMAR FILAS
    
    public void SumaColumnas(){
        
        Nodo p=Punta.getLigaF();
        int columna=0;
        int vr[]=new int[Punta.getCol()];
        
        while(columna<Punta.getCol()){
            while(p!=Punta){
                
                if(p.getCol()==columna){
                vr[columna]+= p.getDato();
                }
                p=p.getLigaF();
            }
            columna++;
             p=Punta.getLigaF();
        }
        
        System.out.print("Suma columnas forma 2: ");
        for (int i = 0; i < vr.length; i++) {
            System.out.print("|" + vr[i] + "|");
        }
        
    }//CIERRE SUMAR COLUMNAS
    
    public void EliminarDatoDato(int d){
        
        Nodo p=Punta.getLigaF(), a=Punta;
        int col=0;
        
        while(p!=Punta){
            if(p.getDato()==d){
                a.setLigaF(p.getLigaF());
                col=p.getCol();
                a=p;
                p=p.getLigaF();
            }
            a=p;
            p=p.getLigaF();
        }
        
        a=Punta;
        p=Punta.getLigaC();
        
        while(p!=Punta){
            if(p.getDato()==d){
                a.setLigaC(p.getLigaC());
                col=p.getCol();
                p=p.getLigaC();
            }
            else{
                p=p.getLigaC();
            }
            
            if(p.getCol()<=col && p.getDato()!=d){
                a=p;
            }
        }
        
        MostrarForma2();
        
    }//CIERRE ELIMINARDATO
    
    public void EliminarDatoPos(int f, int c){
        
        Nodo p=Punta.getLigaF(), a=Punta;
        int col=0;
        
        while(p!=Punta){
            if(p.getFila()==f && p.getCol()==c){
                a.setLigaF(p.getLigaF());
                col=p.getCol();
                a=p;
                p=p.getLigaF();
            }
            a=p;
            p=p.getLigaF();
        }
        
        a=Punta;
        p=Punta.getLigaC();
        
        while(p!=Punta){
            if(p.getFila()==f && p.getCol()==c){
                a.setLigaC(p.getLigaC());
                col=p.getCol();
                p=p.getLigaC();
            }
            else{
                p=p.getLigaC();
            }
            
            if(p.getCol()<=col && p.getFila()!=f && p.getCol()!=c){
                a=p;
            }
        }
        
        MostrarForma2();
        
    }//CIERRE ELIMINARPOS
    
    public void Insertar(int d, int f1, int c1){
        
        if (d == 0) {
            System.out.println("El dato es 0, no se puede insertar"); 
        } else {
            Nodo x = new Nodo(d, f1, c1);
            Nodo P = Punta.getLigaF();
            Nodo A = null;

            // Pa saber donde tiene que insertar
            while (P != Punta && (P.getFila() < f1 || (P.getFila() == f1 && P.getCol() < c1))) {
                A = P;
                P = P.getLigaF();
            }
            // Si hay en la misma pos se suman
            if (P != Punta && P.getFila() == f1 && P.getCol() == c1) {
                P.setDato(P.getDato() + d);
            } else {                
                x.setLigaF(P);
                if (A == null) {
                    Punta.setLigaF(x);
                } else {
                    A.setLigaF(x);
                }

                Nodo y = P;
                A = null;

                while (P != Punta) {
                    A = P;
                    P = P.getLigaF();
                    y = P;

                    if (P.getCol() == c1 && A.getFila() > f1) {
                        break;
                    }
                }

                x.setLigaC(y);
                if (A == null) {
                    Punta.setLigaC(x);
                } else {
                    A.setLigaC(x);
                }
            }
        }

        MostrarForma2();
        
    }//CIERRE INSERTAR
    
    public void SumarForma2(Forma2 F22){
        
        Forma2 Resultado = new Forma2();
        Nodo x = new Nodo(0, Punta.getFila(), Punta.getCol());
        Resultado.Punta = x;
        Nodo p = this.Punta.getLigaF(), q = F22.Punta.getLigaF(), s = Resultado.Punta;
        int suma;
        while (p != this.Punta || q != F22.Punta) {
            // Si la fila y la columna son iguales
            if (p.getFila() == q.getFila() && p.getCol() == q.getCol()) {
                suma = p.getDato() + q.getDato();
                if (suma != 0) {
                    Nodo y = new Nodo(suma, p.getFila(), p.getCol());
                    s.setLigaF(y);
                    s = s.getLigaF();
                }
                p = p.getLigaF();
                q = q.getLigaF();
            // Si la fila de la primera matriz es menor
            } else if (p.getFila() < q.getFila() || (p.getFila() == q.getFila() && p.getCol() < q.getCol())) {
                Nodo y = new Nodo(p.getDato(), p.getFila(), p.getCol());
                s.setLigaF(y);
                s = s.getLigaF();
                p = p.getLigaF();
            // Si la fila de la segunda matriz es menor
            } else {
                Nodo y = new Nodo(q.getDato(), q.getFila(), q.getCol());
                s.setLigaF(y);
                s = s.getLigaF();
                q = q.getLigaF();
            }
        }
        s.setLigaF(Resultado.Punta);
        Resultado.Paso2();
        Resultado.MostrarForma2();
        
    }//CIERRE SUMAR
    
    public void MultiplicarForma2(Forma2 F22){
        
        if (Punta.getCol() != F22.Punta.getFila()) {
            System.out.println("\"Las matrices no son compatibles para multiplicar\"");
            return;
        }

        int filas = Punta.getFila();
        int columnas = F22.Punta.getCol();
        int[][] resultado = new int[filas][columnas];

        Nodo r=Punta.getLigaF();
        Nodo s;

        while (r != Punta) {

            s = F22.Punta.getLigaF();

            while (s != F22.Punta) {
                if (r.getCol() == s.getFila()) {
                    resultado[r.getFila()][s.getCol()] += r.getDato() * s.getDato();
                }
                s = s.getLigaF();
            }

            r = r.getLigaF();
        }

        Forma2 result = new Forma2();
        result.Paso1(resultado);
        result.Paso2();
        result.MostrarForma2();

  
    }//CIERRE MULTIPLICAR
    
}//CIERRE DE LA CLASE
