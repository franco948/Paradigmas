package ejercicio3;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio3 {

    public static void main(String[] args) {

        String piedra = "PIEDRA";
        String papel = "PAPEL";
        String tijera = "TIJERA";

        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese PIEDRA, PAPEL o TIJERA: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals(piedra) || input.equals(tijera) || input.equals(papel)) {

                String resultado = "";

                switch (generarRandom()) {
                    case 0:
                        resultado = papel;
                        break;
                    case 1:
                        resultado = piedra;
                        break;
                    case 2:
                        resultado = tijera;
                        break;
                }


                System.out.println();
                System.out.println("Su entrada: " + input);
                System.out.println("La maquina: " + resultado);

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

    public static int generarRandom() {
        return ((int)(Math.random() * 100)) % 3;
    }
}
