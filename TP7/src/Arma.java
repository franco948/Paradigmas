public class Arma extends Entity implements IArma {

    private String nombre;
    private int daño;
    private int alcance;

    public Arma(String nombre,int daño, int alcance)
    {
        setNombre(nombre);
        setDaño(daño);
        setAlcance(alcance);
    }

    @Override
    public void disparar(ISoldado soldado) {
        System.out.println("Disparando");
    }

    @Override
    public int getDaño() {
        return daño;
    }

    @Override
    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public int getAlcance() {
        return alcance;
    }

    @Override
    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
