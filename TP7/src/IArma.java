public interface IArma extends IEntity {
    void disparar(ISoldado soldado);
    //ISoldado getSoldado();
    String getNombre();
    void setNombre(String nombre);
    int getDaño();
    void setDaño(int daño);
    int getAlcance();
    void setAlcance(int alcance);
}
