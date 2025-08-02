package z9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
