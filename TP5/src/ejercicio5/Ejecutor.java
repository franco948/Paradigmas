package ejercicio5;

import ejercicio7.Ejecutable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ejecutor {

    public void ejectuarMetodoSinParametros(Object objeto, String nombre) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Class tipo = objeto.getClass();

        tipo.getMethod(nombre).invoke(objeto);
    }

    public void run(Class tipo) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        int cantidad = 0;

        Method metodoEjecutable = null;

        for ( Method m : tipo.getMethods() )
        {
            if ( m.getAnnotation(Ejecutable.class) != null )
            {
                metodoEjecutable = m;
                cantidad++;
            }
        }

        if (cantidad == 0 || cantidad > 1)
        {
            throw new IllegalStateException();
        }
        else
        {
            metodoEjecutable.invoke(tipo.newInstance());
        }
    }
}
