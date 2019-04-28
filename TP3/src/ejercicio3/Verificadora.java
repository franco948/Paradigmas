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

    public static boolean validarFecha(String fecha) {

        String pattern = "^(0?[1-9]|[12][0-9]|3[01])[\\/]([1-9]|(1[012]))[\\/]\\d{4}$";
                //"([0-2]?[0-9])|30\\/[0-9]|(1[0-2])\\/[0-9]{4}";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(fecha);

        return m.matches();
    }
}
