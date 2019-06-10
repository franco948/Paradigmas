public class NullArma extends Entity implements IArma {

    public NullArma(int id)
    {
        setId(id);
    }

    @Override
    public void disparar(ISoldado soldado) {
        // No implementado
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {
        // No implementado
    }

    @Override
    public int getDaño()
    {
        return 0;
    }

    @Override
    public void setDaño(int daño)
    {
        // No implementado
    }

    @Override
    public int getAlcance() {
        return 0;
    }

    @Override
    public void setAlcance(int alcance)
    {
        // No implementado
    }

}
