package ejercicio3;

public class Ejercicio3 {

    public static int encontrarCuatroDigitos() {

        for (int X = 0; X <= 9; X++){
            for (int Y = 0; Y <= 9; Y++){
                for (int Z = 0; Z <= 9; Z++){
                    for (int W = 0; W <= 9; W++){

                        double potencia = Math.pow(X, Y) * Math.pow(Z, W);
                        int numero = X * 1000 + Y * 100 + Z * 10 + W * 1;

                        if (potencia == numero) {
                            return numero;
                        }
                    }
                }
            }
        } // fin de for mas externo

        throw new ArithmeticException();
    }
}

