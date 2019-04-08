package ejercicio2;

public class Ejercicio2 {

    public int devolverNumeroConMayorCantidadDePares(int[] array) {
        if (array.length == 0) return -1;

        int cantidadMasGrande = 0;
        int numeroConMayorCantidad = -1;

        for(int i = 0; i < array.length; i++) {
            int aux = Math.abs(array[i]);
            int cantidad = 0;

            while (aux % 10 != 0 || aux / 10 != 0) {

                if (aux % 2 == 0) {
                    cantidad++;
                }

                aux /= 10;
            }

            if (cantidad > cantidadMasGrande){
                cantidadMasGrande = cantidad;
                numeroConMayorCantidad = array[i];
            }
        }

        return numeroConMayorCantidad;
    }
}
