package ejercicio4;

import ejercicio1.EntidadSerializable;
import ejercicio2.AtributoSerializable;

@EntidadSerializable(nombreAmigable = "\"Persona\"")
public class Persona {

    public Persona (String nombre, String apellido, short edad, String direccion, boolean soltero, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.soltero = soltero;
        this.telefono = telefono;
    }

    @AtributoSerializable(nombreAmigable = "\"nombre\"")
    private String nombre;

    @AtributoSerializable(nombreAmigable = "\"apellido\"")
    private String apellido;

    @AtributoSerializable(nombreAmigable = "\"edad\"")
    private short edad;

    private String direccion;

    @AtributoSerializable(nombreAmigable = "\"soltero\"")
    private boolean soltero;

    private int telefono;
}
