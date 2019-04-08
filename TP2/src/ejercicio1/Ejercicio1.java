package ejercicio1;

public class Ejercicio1 {

    public int[] devolverDosMasAltos(int[] array) {
        if(array.length == 0) return new int[0];
        if(array.length == 1) return new int[] {array[0]};

        int n = array.length;
        int mayor = array[0];
        int segundoMayor = array[0];

        for (int i = 1; i < n; i++) {

            if (array[i] > segundoMayor){
                segundoMayor = array[i];
            }

            if(segundoMayor > mayor) {
                int aux = mayor;
                mayor = segundoMayor;
                segundoMayor = aux;
            }
        }

        return new int[] {mayor, segundoMayor};
    }
}
