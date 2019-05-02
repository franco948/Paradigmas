package ejercicio7;

import java.lang.annotation.*;

@Documented
@Target( {ElementType.METHOD} )
@Inherited
@Retention( RetentionPolicy.RUNTIME )
public @interface Ejecutable {
}
