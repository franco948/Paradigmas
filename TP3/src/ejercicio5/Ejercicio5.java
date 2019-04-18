package ejercicio5;

import java.util.Stack;

public class Ejercicio5 {

    public static boolean estaBalanceada(String expresion) {

        if (expresion == "") return true;

        Stack<String> pila = new Stack<String>();

        String[] caracteres = expresion.split("");

        for ( int i = 0; i < caracteres.length; i++) {

            String caracter = caracteres[i];

            switch (caracter) {
                case "(":
                    pila.push("(");
                    break;
                case "[":
                    pila.push("[");
                    break;
                case "{":
                    pila.push("{");
                    break;
            }

            if (caracter.equals(")") || caracter.equals("]") || caracter.equals("}")) {

                if (pila.empty()) return false;

                switch (caracter) {
                    case ")":
                        caracter = "(";
                        break;
                    case "]":
                        caracter = "[";
                        break;
                    case "}":
                        caracter = "{";
                        break;
                }

                String top = pila.pop();

                if (!top.equals(caracter)) {
                    return false;
                }
            }
        }

        return true;
    }
}
