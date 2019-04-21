package ejercicio3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificadora {

    public static boolean validarEmail(String email) {

        String pattern =
                "[A-Za-z0-9]+@[A-Za-z]+.[A-Za-z]+.[A-Za-z]+";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public static boolean validarFecha() {
        return false;
    }
}
