package ejercicio2;

import ejercicio2.visitor.Resultado;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio2 {

    public static final String PIEDRA = "PIEDRA";
    public static final String PAPEL = "PAPEL";
    public static final String TIJERA = "TIJERA";

    public static void main(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese PIEDRA, PAPEL o TIJERA: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals(PIEDRA) || input.equals(TIJERA) || input.equals(PAPEL)) {

                String maquina = "";

                switch (generarRandom()) {
                    case 0:
                        maquina = PAPEL;
                        break;
                    case 1:
                        maquina = PIEDRA;
                        break;
                    case 2:
                        maquina = TIJERA;
                        break;
                }

                System.out.println();
                System.out.println("Su entrada: " + input);
                System.out.println("La maquina: " + maquina);
                System.out.println();

                Resultado resultado = Ejercicio2.jugar(input, maquina);

                if (resultado == Resultado.Victoria) {
                    System.out.println("Felicidades!, gano la partida");
                }
                else if (resultado == Resultado.Derrota) {
                    System.out.println("Perdiste!, vuelva a intentarlo");
                }
                else if (resultado == Resultado.Empate) {
                    System.out.println("Empate");
                }
                
                System.out.println();
                System.out.println("Presione ENTER para seguir jugando.");
                scanner.nextLine();
            }
            else {
                System.out.println();
                System.out.println("La entrada es incorrecta. Vuelva a intentarlo.\n");
                System.out.println("Presione ENTER para seguir jugando.");

                scanner.nextLine();
            }
        }
    }

    public static Resultado jugar(String jugador1, String jugador2) {

        if (jugador1.equals(PIEDRA)) {
            switch (jugador2) {
                case PIEDRA:
                    return Resultado.Empate;
                case PAPEL:
                    return Resultado.Derrota;
                case TIJERA:
                    return Resultado.Victoria;
            }
        }
        else if (jugador1.equals(PAPEL)) {
            switch (jugador2) {
                case PIEDRA:
                    return Resultado.Victoria;
                case PAPEL:
                    return Resultado.Empate;
                case TIJERA:
                    return Resultado.Derrota;
            }
        }
        else if (jugador1.equals(TIJERA)){
            switch (jugador2) {
                case PIEDRA:
                    return Resultado.Derrota;
                case PAPEL:
                    return Resultado.Victoria;
                case TIJERA:
                    return Resultado.Empate;
            }
        }

        throw new IllegalStateException();
    }

    public static int generarRandom() {
        return ((int)(Math.random() * 100)) % 3;
    }
}
