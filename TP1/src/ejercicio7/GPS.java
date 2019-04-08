package ejercicio7;

public class GPS {

    public float calcularTiempoLlegadaEnMinutos(float velocidadPromedioKmPorH, float kmRestantes) {
        if(kmRestantes == 0) return 0;
        if (kmRestantes < 0) return -1;
        if (velocidadPromedioKmPorH <= 0) return -1;

        return (kmRestantes / velocidadPromedioKmPorH) * 60;
    }
}
