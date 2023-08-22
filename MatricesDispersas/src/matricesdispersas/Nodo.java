
package matricesdispersas;

public class Nodo {
    
    //Atributos
    private int dato,fila,col;
    private Nodo liga, ligaF, ligaC;

    public Nodo(int dato, int fila, int col) {
        this.dato = dato;
        this.fila = fila;
        this.col = col;
        this.liga = null;
        this.ligaF = null;
        this.ligaC = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLigaF() {
        return ligaF;
    }

    public void setLigaF(Nodo ligaF) {
        this.ligaF = ligaF;
    }

    public Nodo getLigaC() {
        return ligaC;
    }

    public void setLigaC(Nodo ligaC) {
        this.ligaC = ligaC;
    }
    
}
