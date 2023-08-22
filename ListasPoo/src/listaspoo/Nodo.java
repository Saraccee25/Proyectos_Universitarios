/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaspoo;


public class Nodo {
    
    //Atributos
    
    private int Dato;
    private Nodo LD,LI; //liga que no puede faltar (selección de datos en poo: abstracción)
    
    //Métodos
    //Constructor
    public Nodo() {
        Dato= 0; //Atributo se nombra igual que el parámetro
        LD = null;
        LI = null;
    }
    
    public Nodo(int d) {
        this.Dato = d; //Atributo se nombra igual que el parámetro
        this.LD = null;
        this.LI = null;
    }
    //Esto último se podría considerar como sobrecaraga

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public Nodo getLD() {
        return LD;
    
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }
    
    public Nodo getLI(){
        return LI;
    }
    
    public void setLI (Nodo LI){
        this.LI = LI;
    }
    
   
}
