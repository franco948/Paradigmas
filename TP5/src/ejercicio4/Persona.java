package ejercicio4;

import ejercicio1.EntidadSerializable;
import ejercicio2.AtributoSerializable;

@EntidadSerializable(nombreAmigable = "\"Persona\"")
public class Persona {

    public Persona() { }

    public Persona (String nombre, String apellido, int edad, String direccion, boolean soltero, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.soltero = soltero;
        this.telefono = telefono;
    }

    @AtributoSerializable(nombreAmigable = "nombre")
    private String nombre;

    @AtributoSerializable(nombreAmigable = "apellido")
    private String apellido;

    @AtributoSerializable(nombreAmigable = "edad")
    private int edad;

    private String direccion;

    @AtributoSerializable(nombreAmigable = "soltero")
    private boolean soltero;

    private int telefono;

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setSoltero(boolean soltero) { this.soltero = soltero; }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public boolean getSoltero() { return soltero; }
}
