package ejercicio6;

public abstract class Asistente
{
    private String nombre;
    private String apellido;
    private Congreso congreso;
    private String instituto;

    public Asistente(String nombre,String apellido, String instituto)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.instituto = instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public abstract float descuento();

    public float calcularPrecio(float precioBase)
    {
        float precio = precioBase;

        // todo descontar al inicio o al final?
        precio -= precio * descuento();
        precio += new HotelServices().precioDesayuno();
        return precio;
    }

    public String imprimirCredencial()
    {
        String credencial = "";
        credencial += "Congreso: " + congreso.getNombre() + "\n";
        credencial += "Nombre y Apellido: " + getNombre() + " " + getApellido() + "\n";
        credencial += "Instituto: " + getInstituto() + "\n";
        return credencial;
    }

    public void setCongreso(Congreso congreso) {
        this.congreso = congreso;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
}
