package ejercicio6;

import java.util.LinkedList;
import java.util.List;

public class Congreso {
    private List<Asistente> asistentes;

    private float precioBase;
    private String nombre;

    public static void main(String[] args)
    {
        Asistente a1 = new Alumno("Hernan","Gomez","UAI", 3);
        Asistente a2 = new Alumno("Emanuel","Lopez","UADE", 4);
        Asistente a3 = new Presentador("Mariano","Gonzales", "Telecentro");
        Asistente a4 = new Particular("Esteban", "Rodriguez","Lugar1","Jujuy");
        Asistente a5 = new Particular("Sebastian", "Ramirez","Lugar2","Buenos Aires");

        Congreso c = new Congreso("CITII", 100);
        c.agregar(a1);
        c.agregar(a2);
        c.agregar(a3);
        c.agregar(a4);
        c.agregar(a5);

        c.imprimirAsistentes();
        a1.imprimirCredencial();

       System.out.println(c.precioACobrar(a1));
        System.out.println(c.precioACobrar(a2));
        System.out.println(c.precioACobrar(a3));
        System.out.println(c.precioACobrar(a4));
        System.out.println(c.precioACobrar(a5));
    }

    public Congreso(String nombre,float precioBase)
    {
        if(precioBase < 0) throw new IllegalStateException();

        asistentes = new LinkedList<>();

        this.precioBase = precioBase;
        this.nombre = nombre;
    }

    public void agregar(Asistente asistente)
    {
        asistente.setCongreso(this);
        this.asistentes.add(asistente);
    }

    public String imprimirAsistentes()
    {
        String listaAsistentes = "";

        for (Asistente asistente: asistentes) {
            String nombreYApellido = asistente.getNombre() + " " + asistente.getApellido();
            listaAsistentes += nombreYApellido + "\n";
        }

        return listaAsistentes;
    }

    public float precioACobrar(Asistente asistente)
    {
        return asistente.calcularPrecio(precioBase);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }
}

