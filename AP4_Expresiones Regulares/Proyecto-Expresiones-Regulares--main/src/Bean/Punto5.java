
package Bean;

public class Punto5 {
    
    private String tipo;
    private long numero;
    private String fecha;
    private String nombre;
    private String apellido;
    private int codigo;

    public Punto5(String tipo, long numero, String fecha, String nombre, String apellido, int codigo) {
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    public Punto5() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return "Tipo: " + tipo + "\nNúmero: " + numero + "\nFecha: " + fecha + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCódigo: " + codigo;
    }
    
}//CIERRE DE LA CLASE
