package ejercicio1;

public class Ejercicio1 {

    public static double calcular(String expresion) {

        String[] operandos = expresion.split(" ");

        double resultado = 0;
        int operando1 = Integer.parseInt(operandos[0]);
        int operando2 = Integer.parseInt(operandos[2]);

        String operador = operandos[1];

        switch (operador) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                resultado = operando1 / operando2;
                break;
        }

        System.out.println(resultado);

        return resultado;
    }
}
