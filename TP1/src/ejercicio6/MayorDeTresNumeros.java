package ejercicio6;

public class MayorDeTresNumeros {

    public void escribirDeMenorAMayor(float a, float b, float c) {
        float menor;
        float medio;
        float mayor;

        if (a > b){
            if(a > c) {
                mayor = a;

                if (b > c) {
                    medio = b;
                    menor = c;
                }
                else {
                    medio = c;
                    menor = b;
                }
            }
            else {
                mayor = c;
                medio = a;
                menor = b;
            }
        }
        else if (b > c) {
            mayor = b;

            if (a > c) {
                medio = a;
                menor = c;
            }
            else {
                medio = c;
                menor = a;
            }
        }
        else {
            mayor = c;
            medio = b;
            menor = a;
        }

        System.out.printf("%.4f %.4f %.4f\n", menor, medio, mayor);
    }
}
