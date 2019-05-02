package ejercicio1;

import java.lang.annotation.*;

@Documented
@Target( {ElementType.TYPE} )
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EntidadSerializable {
    String nombreAmigable();
}
