package arboles;

public class Arbol {

    private Nodo Punta = null;

    public Arbol() {
        Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }
    
    Nodo crearArbol(char vArbol[]) {

        int i = 0;
        Nodo p = Punta, a = new Nodo(vArbol[0]);
        boolean algo = false;

        if (p == null) {
            Punta = a;
            p = a;
            i++;
        }

        while (i < vArbol.length) {

            Nodo x = new Nodo(vArbol[i]);

            if (x.getDato() < p.getDato() && p.getLI() != null && algo == false) {
                p = p.getLI();
            }

            if (x.getDato() < p.getDato() && p.getLI() == null) {
                p.setLI(x);
                i++;
                p = Punta;
                algo = true;
            }

            if (x.getDato() > p.getDato() && p.getLD() != null && algo == false) {
                p = p.getLD();
            }

            if (x.getDato() > p.getDato() && p.getLD() == null) {
                p.setLD(x);
                i++;
                p = Punta;
                algo = true;
            }

            algo = false;
        }

        i = 0;
        MostrarArbol(Punta, i);

        return Punta;

    }//CIERRE DEL METODO
    
    void organizararbolconvectorarbol(char vArbol[]){
        
        int i=1;
        Nodo a = new Nodo(vArbol[0]);
        Punta = null;
   
        if (Punta == null) {
            Punta = a;
        }

        while (i<vArbol.length) {

            Punta = organizarArbolcondato(vArbol[i]);
            i++;

        }

        i = 0;
        MostrarArbol(Punta, i);

    }

    Nodo organizarArbolcondato(char d) {

        Nodo p = Punta;
        boolean algo = false, algo1=false;
        Nodo nose = new Nodo(' ');
        Nodo y= new Nodo(' ');
        Nodo nododeldatoqueinserto = new Nodo(d);
        TresValores<Boolean, Nodo, Nodo> result = factorDeBalance(Punta, nose, algo1);

        while (p!=null) {

            if (nododeldatoqueinserto.getDato()<p.getDato()) {
                y=p;
                p=p.getLI();
            }
            else{
                y=p;
                p=p.getLD();
            }
        }
            if(d<y.getDato()){
                y.setLI(nododeldatoqueinserto);
                
                result = factorDeBalance(Punta, nose, algo1);                
                Punta = AVL(result);
            }
            else{
                y.setLD(nododeldatoqueinserto);
                
                result = factorDeBalance(Punta, nose, algo1);                
                Punta = AVL(result);
            }
        
        

        return Punta;

    }//CIERRE DEL METODO
    
    Nodo AVL(TresValores<Boolean, Nodo, Nodo> result){

        Nodo arriba = result.getValue3();
 
        if (result.getValue1() == true) {
            
            Nodo q = hijoMayor(result.getValue2()); 

            if (result.getValue2().getFb() > 0 && q.getFb() > 0) {
                rotacionDerecha(result.getValue2(), arriba);
            } else {
                if (result.getValue2().getFb() < 0 && q.getFb() < 0) {
                    rotacionIzquierda(result.getValue2(), arriba);
                }
                else{
                   if(result.getValue2().getFb() > 0 && q.getFb() < 0){
                       rotacionDobleDerecha(result.getValue2(), q, arriba);
                   }
                   else{
                       if (result.getValue2().getFb() < 0 && q.getFb() > 0) {
                           rotacionDobleIzquierda(result.getValue2(), q, arriba);
                       } 
                   }
                }
            }
        }

        return Punta;
        
    }//CIERRE DEL METODO

    TresValores<Boolean, Nodo, Nodo> factorDeBalance(Nodo r, Nodo arribader, boolean algo) {

        int i = 0;
        int alturaI, alturaD;
        Nodo x = new Nodo(' ');

        if (r != null && algo==false) {

            TresValores<Boolean, Nodo, Nodo> result = factorDeBalance(r.getLI(), r, algo);
            if (result.getValue1() == true) {
                return result; 
            }
            result = factorDeBalance(r.getLD(), r, algo);
            if (result.getValue1() == true) {
                return result;
            }
            if(algo==false){
            
                if (r.getLI() != null) {
                    i = 1;
                    alturaI = altura(r.getLI(), i);
                } else {
                    alturaI = 0;
                }

                if (r.getLD() != null) {
                    i = 1;
                    alturaD = altura(r.getLD(), i);
                } else {
                    alturaD = 0;
                }

                int resultado = alturaI - alturaD;
                r.setFb(resultado);

                if (resultado >= 2 || resultado <= -2) {
                    x = r;
                    algo = true;
                }
            }

        }

        return new TresValores<>(algo, x, arribader);

    }//CIERRE DEL METODO
    
    private void rotacionDerecha(Nodo p, Nodo A) {
        
        Nodo q = p.getLI();
        if(q.getLD()!=null){
            p.setLI(q.getLD());
        }
        else{
            p.setLI(null);
        }
        q.setLD(p);
        if (p == Punta) {
            Punta = q;
        } else {
            if (A.getLI() == p) {
                A.setLI(q);
            } else {
                A.setLD(q);
            }
        }

    }//CIERRE DEL METODO

    private void rotacionIzquierda(Nodo p, Nodo A) {

        Nodo q = p.getLD();
        if (q.getLI() != null) {
            p.setLD(q.getLI());
        }
        else{
            p.setLD(null);
        }
        q.setLI(p);
        if (p == Punta) {
            Punta = q;
        } else {
            if (A.getLI() == p) {
                A.setLI(q);
            } else {
                A.setLD(q);
            }
        }
        
    }//CIERRE DEL METODO
    
    private void rotacionDobleDerecha(Nodo P, Nodo Q, Nodo arribadeP){
        
        Nodo R = hijoMayor(Q);
        
        Q.setLD(R.getLI());
        P.setLI(R.getLD());
        R.setLI(Q);
        R.setLD(P);

        if (P == Punta) {
            Punta = R;
        } else {
            if (arribadeP.getLI() == P) {
                arribadeP.setLI(R);
            } else {
                arribadeP.setLD(R);
            }
        }
        
    }//CIERRE DEL METODO
    
    private void rotacionDobleIzquierda (Nodo P, Nodo Q, Nodo arribadeP){
        
        Nodo R = hijoMayor(Q);
        
        Q.setLI(R.getLD());
        P.setLD(R.getLI());
        R.setLD(Q);
        R.setLI(P);

        if (P == Punta) {
            Punta = R;
        } else {
            if (arribadeP.getLD() == P) {
                arribadeP.setLD(R);
            } else {
                arribadeP.setLI(R);
            }
        }
        
    }//CIERRE DEL METODO
    
    private Nodo hijoMayor(Nodo x) {
        
        int altHI = 0, altHD = 0;
        Nodo hijoMayor = new Nodo(' ');

        if (x.getLI() != null) {

            altHI = altura(x.getLI(), 1);
        }
        if (x.getLD() != null) {

            altHD = altura(x.getLD(), 1);

        }

        if (altHI != 0 && altHD != 0) {
            if (altHI > altHD) {
                hijoMayor = x.getLI();
            } else {
                if (altHI < altHD) {
                    hijoMayor = x.getLD();
                }
            }
        } else {
            if (altHI == 0) {
                hijoMayor = x.getLD();
            } else {
                if (altHD == 0) {
                    hijoMayor = x.getLI();
                }
            }
        }
        
        return hijoMayor;
    }


    static int altura(Nodo x, int cont) {

        if (x.getLI() == null && x.getLD() == null) {
            return cont;
        } else if (x.getLI() == null) {
            return altura(x.getLD(), cont + 1);
        } else if (x.getLD() == null) {
            return altura(x.getLI(), cont + 1);
        } else {
            int alturaI = altura(x.getLI(), cont + 1);
            int alturaD = altura(x.getLD(), cont + 1);
            return Math.max(alturaI, alturaD);
        }

    }//CIERRE DEL METODO

    public Nodo Buscar(Nodo p, char dato) {
        if (p != null) {
            if (p.getDato() == dato) {
                return p;
            }
            Nodo izq = Buscar(p.getLI(), dato);//si el dato en p no es igual al dato, izq sigue siendo null, solo cambia cuando es igual
            if (izq != null) {
                return izq;
            }
            Nodo der = Buscar(p.getLD(), dato);
            if (der != null) {
                return der;
            }
        }

        return null;

    }//CIERRE DEL METODO

    void MostrarArbol(Nodo p, int cont) {

        if (p == null) {
            return;
        } else {
            MostrarArbol(p.getLD(), cont + 1);
            for (int i = 0; i < cont; i++) {
                System.out.print("    ");
            }
            char dato = (char) p.getDato();
            System.out.println(dato);
            MostrarArbol(p.getLI(), cont + 1);
        }

    }//CIERRE DEL METODO

public void Inorden(Nodo p) {
        if (p != null) {
            Inorden(p.getLI());
            char dato = (char) p.getDato();
            System.out.print(dato + "->");
            Inorden(p.getLD());
        }
    }//CIERRE DEL METODO

    public void Preorden(Nodo p) {
        if (p != null) {
            char dato = (char) p.getDato();
            System.out.print(dato + "->");
            Preorden(p.getLI());
            Preorden(p.getLD());
        }
    }//CIERRE DEL METODO

    public void Posorden(Nodo p) {

        if (p != null) {
            Posorden(p.getLI());
            Posorden(p.getLD());
            char dato = (char) p.getDato();
            System.out.print(dato + "->");
        }
    }//CIERRE DEL METODO

    int nivel(Nodo r, int cont, char dato) {

        if (r != null && r.getDato() != dato) {
            nivel(r.getLI(), cont++, dato);
            nivel(r.getLD(), cont++ , dato);
        }
        return cont;
        
    }//CIERRE DEL METODO

    int contarHojas(Nodo r, int cont) {

        if (r != null) {

            cont = contarHojas(r.getLI(), cont);
            if (r.getLI() == null && r.getLD() == null) {
                cont++;
            }
            cont = contarHojas(r.getLD(), cont);
        }

        return cont;

    }//CIERRE DEL METODO

    int contarPadres(Nodo r, int cont) {

        if (r != null) {

            cont = contarPadres(r.getLI(), cont);
            if (r.getLI() != null || r.getLD() != null) {
                cont++;
            }
            cont = contarPadres(r.getLD(), cont);
        }

        return cont;

    }//CIERRE DEL METODO

    Nodo insertarDato(Nodo r, char d, boolean algo) {
        
        if(r!=null){
            if(d<r.getDato()){
                r.setLI(insertarDato(r.getLI(), d, algo));
            }
            else{
                if(d>r.getDato()){
                    r.setLD(insertarDato(r.getLD(), d, algo));
                }
            }
            
            if (algo == false) {
                if (d < r.getDato() && r.getLI() == null) {
                    r.setLI(new Nodo(d));
                    algo= true;
                } else if (d > r.getDato() && r.getLD() == null) {
                    r.setLD(new Nodo(d));
                    algo = true;
                }
            }
        }
        
        return r;

    }//CIERRE DEL METODO
    
    void hermano(Nodo r, char d, Nodo a, boolean algo) {

        if (r != null && algo==false) {
            
            if(r.getDato()==d){
                algo=true;
            }
            hermano(r.getLI(), d, r, algo);
            hermano(r.getLD(), d, r, algo);

        }
        
        if (algo == true) {

            if (d > a.getDato()) {
                if(a.getLI()!=null){
                    a = a.getLI();
                    char dato = (char) a.getDato();
                    System.out.println("el hermano de " + d + " es " + dato);
                }
                else{
                    System.out.println(d + " no tiene hermano ");
                }
            } else {
                if (d < a.getDato()) {
                    if (a.getLD() != null) {
                        a = a.getLD();
                        char dato = (char) a.getDato();
                        System.out.println("el hermano de " + d + " es " + dato);                      
                    } else {
                        System.out.println(d + " no tiene hermano ");
                    }
                }
            }
        }

    }//CIERRE DEL METODO
    
    void primosHermanos(Nodo r, char d, Nodo a, Nodo b, boolean algo){
        
        if (r != null && algo==false) {
            
            if(r.getDato()==d){
                algo=true;
            }
            if(algo==false){
                primosHermanos(r.getLI(), d, r, a, algo);
                primosHermanos(r.getLD(), d, r, a, algo);
            }

        }
        
        if (algo == true) {
            
            char hijoIzq=' ', hijoDer=' ';

            if (d > b.getDato()) {
                if(b.getLI()!=null){
                    b = b.getLI();
                    if(b.getLI()!=null){
                        hijoIzq= (char) b.getLI().getDato();
                    }
                    if(b.getLD()!=null){
                        hijoDer= (char) b.getLD().getDato();      
                    }
                    if(b.getLI()!=null && b.getLD()!=null){
                        System.out.println("Los primos hermanos de " + d + " son " + hijoIzq + " y " + hijoDer);
                    }
                    else{
                        if(b.getLI()!=null && b.getLD()==null){
                            System.out.println("El primo hermano de " + d + " es " + hijoIzq);
                        }
                        else{
                            if (b.getLI() == null && b.getLD() != null) {
                                System.out.println("El primo hermano de " + d + " es " + hijoDer);
                            }
                        }
                    }
                }
                else{
                    System.out.println(d + " no tiene primos hermanos ");
                }
            } else {
                if (d < b.getDato()) {
                    if (b.getLD() != null) {
                        b = b.getLD();
                        if (b.getLI() != null) {
                            hijoIzq = (char) b.getLI().getDato();
                        }
                        if (b.getLD() != null) {
                            hijoDer = (char) b.getLD().getDato();
                        }
                        if (b.getLI() != null && b.getLD() != null) {
                            System.out.println("Los primos hermanos de " + d + " son " + hijoIzq + " y " + hijoDer);
                        } else {
                            if (b.getLI() != null && b.getLD() == null) {
                                System.out.println("El primo hermano de " + d + " es " + hijoIzq);
                            } else {
                                if (b.getLI() == null && b.getLD() != null) {
                                    System.out.println("El primo hermano de " + d + " es " + hijoDer);
                                }
                            }
                        }
                    }
                    else {
                        System.out.println(d + " no tiene primos hermanos ");
                    }
                }
            }
        }        
        
    }//CIERRE DEL METODO
    
    void ancestros(Nodo r, char d){
        
        if (r != null) {
            if (d < r.getDato()) {
                ancestros(r.getLI(), d);
            } else {
                if (d > r.getDato()) {
                    ancestros(r.getLD(), d);
                }
            }
                
            if(d!=r.getDato()){
                char dato = (char) r.getDato();
                System.out.println("Ancestro de " + d + " : " + dato);
            }
            
        }
  
    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
