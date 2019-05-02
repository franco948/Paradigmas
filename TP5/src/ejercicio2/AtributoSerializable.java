package ejercicio2;

import java.lang.annotation.*;

@Documented
@Target( { ElementType.FIELD } )
@Inherited
@Retention( RetentionPolicy.RUNTIME )
public @interface AtributoSerializable {
    String nombreAmigable();
}
