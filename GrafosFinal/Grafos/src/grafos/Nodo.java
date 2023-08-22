package grafos;

public class Nodo {

    private Nodo Liga;
    //private int dato;
    private String dato;

    public Nodo(String dato) {
        this.dato = dato;
        this.Liga = null;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    
}
