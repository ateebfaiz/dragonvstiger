package s6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean canOverrideExistingModule() default false;

    boolean hasConstants() default true;

    boolean isCxxModule() default false;

    String name();

    boolean needsEagerInit() default false;
}
