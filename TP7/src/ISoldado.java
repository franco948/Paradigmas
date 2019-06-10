public interface ISoldado extends IEntity {
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    void setApellido(String apellido);
    int getEdad();
    void setEdad(int edad);
    IArma getArma();
    void setArma(IArma arma);
}
