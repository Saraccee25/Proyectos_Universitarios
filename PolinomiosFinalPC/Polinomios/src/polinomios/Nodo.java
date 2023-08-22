
package polinomios;

public class Nodo {
    
    //Atributos
    
    private int Coe, Exp;
    private Nodo Liga;
    
    public Nodo(){
        
    }

    public Nodo(int Coe, int Exp) {
        this.Coe = Coe;
        this.Exp = Exp;
        this.Liga = null;
    }

    public int getCoe() {
        return Coe;
    }

    public void setCoe(int Coe) {
        this.Coe = Coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }
    
    
    
}
