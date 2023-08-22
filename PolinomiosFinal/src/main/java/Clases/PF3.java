
package Clases;

public class PF3 {

//Atributos
Nodo Punta,Final;

//Metodos 

    public PF3() {
        Punta = null;
        Final = null;
    }
    
    public void insertarFinal(int coe, int exp){
        Nodo x = new Nodo(coe,exp);
        
        if(Punta == null){
            Punta = x;
            Final = x;
        }
        else{
            Final.setLiga(x);
            Final = x;
            
        }
        
        
    }

    


}
