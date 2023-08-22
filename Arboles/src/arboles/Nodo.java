
package arboles;

public class Nodo {
    
    //ATRIBUTOS
    private char dato;
    private Nodo LI, LD;
    private int fb;
    
    public Nodo(char dato) {
        this.dato = dato;
        this.LI = null;
        this.LD = null;
        this.fb = 0;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getLI() {
        return LI;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

}//CIERRE DE LA CLASE
