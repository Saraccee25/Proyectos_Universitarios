
package matricesdispersas;

public class Forma1 {
    
    Nodo Punta;

    public Forma1() {
        Punta = null;
    }
    
    public void Construir(int Mat[][]){
        
        Paso1(Mat.length,Mat[0].length);
        Paso2(Mat);
        Paso3();
    }
    
    private void Paso1(int n, int m){
        
        int mayor=0;
        
        if(n>m){
            mayor=n;
        }
        else{
            if(n<m)
            mayor=m;
            else
                if(n==m)
                    mayor=n;
        }
        
        Nodo x=new Nodo(0,n,m);
        Punta=x;
        Nodo p=x;
        int i=0;
        
        while(i<mayor){
            Nodo y=new Nodo(0,i,i);
            p.setLiga(y);
            p=y;
            i++;
        }
        p.setLiga(Punta);
        
    }//CIERRE PASO 1
    
    private void Paso2(int Mat[][]){
        
        Nodo p=Punta.getLiga(), q=p;
        int i=0, j=0;
        
        while(i<Punta.getFila()){
            while(j<Punta.getCol()){
                if(Mat[i][j]!=0){
                    Nodo x = new Nodo(Mat[i][j],i,j);
                    q.setLigaF(x);
                    q=q.getLigaF();
                }
                j++;
            }
            q.setLigaF(p);
            p=p.getLiga();
            q=p;
            i++;
            j=0;
        }
        
    }//CIERRE PASO 2
    
    private void Paso3(){
        
        Nodo p=Punta.getLiga(), q=p.getLigaF();
        Nodo rc=p, a=rc;
        
        while(rc!=Punta){
            while(p!=Punta){
                while(q!=p){
                    if(q!=null){
                        if(q.getCol()==rc.getCol()){
                            a.setLigaC(q);
                            a=q;
                            q=q.getLigaF();
                        }
                        else{
                            q=q.getLigaF();
                        }
                    }
                    else{
                        break;
                    }
                }
                p=p.getLiga();
                q=p.getLigaF();
            }
            a.setLigaC(rc);
            rc=rc.getLiga();
            p=Punta.getLiga();
            q=p.getLigaF();
            a=rc;
        }
    }//CIERRE PASO 3
    
    public void MostrarForma1(){
        
        Nodo p=Punta.getLiga(), q=p.getLigaF();
        
        System.out.print("[" + Punta.getLigaC() + "]" + "[" + Punta.getFila() + "]" + "[" + Punta.getCol() + "]" + "[" + Punta.getLigaF()+ "]"); 
        System.out.println("[" + Punta.getDato()+ "]" + "[" + Punta.getLiga()+ "]"); 
        System.out.println("        |");
        System.out.println("        V");
        
        while (p != Punta) {        
            
            System.out.print("[" + p.getLigaC() + "]" + "[" + p.getFila() + "]" + "[" + p.getCol() + "]" + "[" + p.getLigaF()+ "]"); 
            System.out.println("[" + p.getDato()+ "]" + "[" + p.getLiga()+ "]" + "--> "); 
            
            while(q!=p && q!=null){

                System.out.print("[" + q.getLigaC() + "]" + "[" + q.getFila() + "]" + "[" + q.getCol() + "]" + "[" + q.getLigaF()+ "]"); 
                System.out.println("[" + q.getDato()+ "]" + "[" + q.getLiga()+ "]" + "--> "); 

                q = q.getLigaF();
            }
            System.out.println("        |");
            System.out.println("        V");
            p = p.getLiga();
            q=p.getLigaF();
        }
        
    }//CIERRE MOSTRAR FORMA
    
    public void SumaFilas(){
        
        Nodo p = Punta.getLiga(), q=p.getLigaF();
        int i=0;
        int vr[]=new int[Punta.getFila()];
        
        while (i<Punta.getFila()) {                   
            while(q!=p && q!=null){

                vr[i]+= q.getDato();

                q = q.getLigaF();
            }
            i++;
            p = p.getLiga();
            q=p.getLigaF();
        }
        System.out.print("Suma filas forma 1: ");
        for ( i = 0; i < vr.length; i++) {
            System.out.print("|" + vr[i] + "|");
        }
        
    }//CIERRE SUMAR FILAS
    
    public void SumaColumnas(){
        
        Nodo p=Punta.getLiga(), q=p.getLigaF();
        Nodo rc=p, a=rc;
        int vr[]=new int[Punta.getCol()];
        int i=0;
        
        while(rc!=Punta){
            while(p!=Punta){
                while(q!=p && q!=null){
                        if(q.getCol()==rc.getCol()){
                            vr[i]+=q.getDato();
                            q=q.getLigaF();
                        }
                        else{
                            q=q.getLigaF();
                        }
                }
                p=p.getLiga();
                q=p.getLigaF();
            }
            i++;
            rc=rc.getLiga();
            p=Punta.getLiga();
            q=p.getLigaF();
            a=rc;
        }
        System.out.print("Suma columnas forma 1: ");
        for (i = 0; i < vr.length; i++) {
            System.out.print("|" + vr[i] + "|");
        }
        
    }//CIERRE SUMAR COLUMNAS
    
public void EliminarDatoDato(int d){
        
        Nodo p = Punta.getLiga(), q = p.getLigaF(), a=q;
        
        Nodo rc=p, e=rc;
        
        while(rc!=Punta){
            while(p!=Punta){
                while(q!=p && q!=null){
                        if(q.getCol()==rc.getCol() && q.getDato()==d){
                            e.setLigaC(q.getLigaC());
                            e=e.getLigaC();
                            q.setLigaC(null);
                            q=q.getLigaF();
                        }
                        else{
                            q=q.getLigaF();
                        }
                }
                p=p.getLiga();
                q=p.getLigaF();
            }
            e.setLigaC(rc);
            rc=rc.getLiga();
            p=Punta.getLiga();
            q=p.getLigaF();
            e=rc;
        }
        
        p = Punta.getLiga();
        q = p.getLigaF();

        while(p!=Punta){
            while(q!=p && q!=null){
                
                if(q.getDato()==d){
                    q.setFila(0);
                    q.setCol(0);
                    
                    if(q!=a){
                        a.setLigaF(q.getLigaF());
                    }
                    else{
                        p.setLigaF(q.getLigaF());
                    }
                    q.setLigaF(null);
                    q=a;
                    q=q.getLigaF();
                    
                }
                else{
                    q=q.getLigaF();
                    
                    if(q.getDato()!=d){
                        a=a.getLigaF();
                    }
                }
            }
            
            p = p.getLiga();
            q = p.getLigaF();
            a=q;
        }
        
        MostrarForma1();
        
    }//CIERRE ELIMINAR DATO
    
    public void EliminarDatoPos(int f, int c){
        
        Nodo p = Punta.getLiga(), q = p.getLigaF(), a=q;
        
        Nodo rc=p, e=rc;
        
        while(rc!=Punta){
            while(p!=Punta){
                while(q!=p && q!=null){
                        if(q.getCol()==rc.getCol() && q.getFila()==f && q.getCol()==c){
                            e.setLigaC(q.getLigaC());
                            e=e.getLigaC();
                            q.setLigaC(null);
                            q=q.getLigaF();
                        }
                        else{
                            q=q.getLigaF();
                        }
                }
                p=p.getLiga();
                q=p.getLigaF();
            }
            e.setLigaC(rc);
            rc=rc.getLiga();
            p=Punta.getLiga();
            q=p.getLigaF();
            e=rc;
        }
        
        p = Punta.getLiga();
        q = p.getLigaF();

        while(p!=Punta){
            while(q!=p && q!=null){
                
                if(q.getFila()==f && q.getCol()==c){
                    q.setFila(0);
                    q.setCol(0);
                    
                    if(q!=a){
                        a.setLigaF(q.getLigaF());
                    }
                    else{
                        p.setLigaF(q.getLigaF());
                    }
                    q.setLigaF(null);
                    q=a;
                    q=q.getLigaF();
                    
                }
                else{
                    q=q.getLigaF();
                    
                    if(q.getFila()!=f && q.getCol()!=c){
                        a=a.getLigaF();
                    }
                }
            }
            
            p = p.getLiga();
            q = p.getLigaF();
            a=q;
        }
        
        MostrarForma1();
        
    }//CIERRE ELIMINAR POS
    
    public void Insertar(int d, int f1, int c1){
        
        if(d==0){
            System.out.println("No se puede ingresar porque el dato ya es 0 ");
        }
        else{
        
            Nodo p=Punta.getLiga(), q=p.getLigaF(), a=q.getLigaF();
            Nodo x=new Nodo(d,f1,c1);
            boolean algo=false;

                while(p!=Punta){
                    if(q.getFila()!=f1){
                        p=p.getLiga();
                        q=p.getLigaF(); 
                        a=q.getLigaF();
                    }
                    else{
                        if(q.getFila()==f1){
                            if(a!=p){
                                if(q.getCol()==c1){
                                    q.setDato(q.getDato()+d);
                                    algo=true;
                                }
                                if(q.getCol()<c1 && a.getCol()<c1){
                                    q=q.getLigaF();
                                    a=q.getLigaF();
                                }
                                else{
                                    if(q.getCol()<c1 && a.getCol()>c1){
                                        q.setLigaF(x);
                                        x.setLigaF(a);
                                        algo=true;
                                    }
                                    else{
                                        if(q.getCol()>c1){
                                            p.setLigaF(x);
                                            x.setLigaF(q);
                                            algo=true;
                                        }
                                        else{
                                        q=q.getLigaF();
                                        a=q.getLigaF();
                                        }
                                    }
                                }
                            }
                            else{
                                if(a==p){
                                    if(q.getCol()<c1){
                                        q.setLigaF(x);
                                        x.setLigaF(p);
                                        algo=true;
                                    }
                                    else{
                                        if(q.getCol()>c1){
                                            x.setLigaF(q);
                                            p.setLigaF(x);
                                            algo=true;
                                        }
                                    }
                                }
                                if(p==q){
                                    q.setLigaF(x);
                                    x.setLigaF(p);
                                    algo=true;
                                }
                            }
                        }
                        if(algo==true){
                            break;
                        }
                    }
                }
                p=Punta.getLiga();
                q=p.getLigaF();

                while(p!=Punta){
                    while(q!=p && q!=null){

                        if(q.getFila()<f1 && q.getCol()==c1){
                            a=q;
                        }
                        q=q.getLigaF();
                    }
                    p=p.getLiga();
                    q=p.getLigaF();
                }
                x.setLigaC(a.getLigaC());
                a.setLigaC(x);

            MostrarForma1();
        }   
        
    }//CIERRE INSERTAR
    
    public void SumarForma1(Forma1 F12){
        
        Nodo p=Punta.getLiga(), q=p.getLigaF();
        Nodo r=F12.Punta.getLiga(), s=r.getLigaF();
        Forma1 Res = new Forma1();
        Res.Paso1(Punta.getFila(), Punta.getCol());
        Nodo t=Res.Punta.getLiga(), a=t;
        
        MostrarForma1();
        F12.MostrarForma1();
        
        while(p!=Punta){
            while((q!=p || s!=r) && q!=null && s!=null){
                
                if(q.getFila()==s.getFila() && q.getCol()==s.getCol()){
                    Nodo x=new Nodo(q.getDato()+s.getDato(),q.getFila(),q.getCol());
                    a.setLigaF(x);
                    x.setLigaF(t);
                    q=q.getLigaF();
                    s=s.getLigaF();
                    a=a.getLigaF();
                }
                else{
                    if(q.getFila()==s.getFila() && q.getCol()<s.getCol() && s!=r && q!=p){
                        Nodo x=new Nodo(q.getDato(), q.getFila(), q.getCol());
                        a.setLigaF(x);
                        x.setLigaF(t);
                        q=q.getLigaF();
                        a=a.getLigaF();
                    }
                    else{
                        if(q.getFila()==s.getFila() && q.getCol()>s.getCol() && s!=r && q!=p){
                            Nodo x=new Nodo(s.getDato(), s.getFila(), s.getCol());
                            a.setLigaF(x);
                            x.setLigaF(t);
                            s=s.getLigaF();
                            a=a.getLigaF();
                        }
                    }
                    
                    if(s==r && q!=p && s.getLigaF()==r.getLigaF()){
                        Nodo x=new Nodo(q.getDato(), q.getFila(), q.getCol());
                        a.setLigaF(x);
                        x.setLigaF(t);
                        q=q.getLigaF();
                        a=a.getLigaF();
                    }
                    if(q==p && s!=r && q.getLigaF()==p.getLigaF()){
                        Nodo x=new Nodo(s.getDato(), s.getFila(), s.getCol());
                        a.setLigaF(x);
                        x.setLigaF(t);
                        s=s.getLigaF();
                        a=a.getLigaF();
                    }
                    if(q==p && s==r){
                        break;
                    }
                }
                
            }
            p=p.getLiga();
            q=p.getLigaF();
            r=r.getLiga();
            s=r.getLigaF();
            t=t.getLiga();
            a=t;
            
        }
        Res.Paso3();
        Res.MostrarForma1();
        
    }//CIERRE SUMAR
    
    public void MultiplicarForma1(Forma1 F12){
        
        Nodo p = Punta.getLiga(), q = p.getLigaF(), r = F12.Punta.getLiga(), s = r;
        Forma1 resultado = new Forma1();
        resultado.Paso1(Punta.getFila(), F12.Punta.getCol()); 
        while (p != Punta) {
            while (r != F12.Punta) {
                int suma = 0;
                q = p.getLigaF();
                s = r.getLigaC();

                while (q != p && s != r && q != null && s != null) {
                    if (q.getCol() == s.getFila()) {
                        suma += q.getDato() * s.getDato();
                        q = q.getLigaF();
                        s = s.getLigaC();
                    } else if (q.getCol() > s.getFila()) {
                        s = s.getLigaC();
                    } else {
                        q = q.getLigaF();
                    }
                }

                if (suma != 0) {
                    int fila = p.getFila();
                    int col = r.getCol();
                    resultado.Paso2_0(suma, fila, col); 
                }

                r = r.getLiga();
            }

            p = p.getLiga();
            if (p != null) {
                q = p.getLigaF();
            }

            r = F12.Punta.getLiga();
    }

    resultado.MostrarForma1();
        
    }//CIERRE MULTIPLICAR
    
    public void Paso2_0(int dato, int fila, int col) {
        Nodo nuevo = new Nodo(dato, fila, col);
        Nodo p = Punta.getLiga();

        while (p != Punta && p.getFila() < fila) {
            p = p.getLiga();
        }

        while (p.getLigaF() != null && p.getLigaF().getFila() == fila && p.getLigaF().getCol() < col) {
            p = p.getLigaF();
        }

        nuevo.setLigaF(p.getLigaF());
        p.setLigaF(nuevo);

        p = Punta.getLiga();
        while (p.getLigaC() != null && p.getLigaC().getCol() != col) {
            p = p.getLigaC();
        }

        nuevo.setLigaC(p.getLigaC());
        p.setLigaC(nuevo);
        
    }//CIERRE DEL METODO
 
}//CIERRE DE LA CLASE
