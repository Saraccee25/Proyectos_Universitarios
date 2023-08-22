
package pilas.y.colas;

import javax.swing.JOptionPane;

public class Nodo {
    //Atributos

    private int Ced;
    private String Nom;
    private String Ape;
    private String Car;
    Pila P;  
    private Nodo Liga;

    //Métodos

    public Nodo() {
        Ced = 0;
        Nom = "";
        Ape = "";
        Car = "";
        P = new Pila(4);
        Liga = null;
    }


    public int getCed() {
        return Ced;
    }

    public void setCed(int Ced) {
        this.Ced = Ced;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getApe() {
        return Ape;
    }

    public void setApe(String Ape) {
        this.Ape = Ape;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String Car) {
        this.Car = Car;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public Pila getP() {
        return P;
    }

    public void setP(Pila P) {
        this.P = P;
    }
}
