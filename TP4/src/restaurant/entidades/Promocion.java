package restaurant.entidades;

public class Promocion {
    private String nombre;
    private String plato;
    private String bebida;
    private float precio;

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPlato(String plato) { this.plato = plato; }
    public void setBebida(String bebida) { this.bebida = bebida; }
    public void setPrecio(float precio) { this.precio = precio; }

    public String getNombre() { return nombre; }
    public String getPlato() { return plato; }
    public String getBebida() { return bebida; }
    public float getPrecio() { return precio; }
}
