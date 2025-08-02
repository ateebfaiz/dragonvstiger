package k8;

import com.fasterxml.jackson.databind.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    Class value() default x.class;
}
