
package Bean;

public class Punto3 {
    
    private String cedula;
    private String categoria;
    private String fecha;

    public Punto3(String cedula, String categoria, String fecha) {
        this.cedula = cedula;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Categoría: " + categoria + ", Fecha: " + fecha;
    }
    
}//CIERRE DE LA CLASE
