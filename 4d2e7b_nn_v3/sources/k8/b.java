package k8;

import com.fasterxml.jackson.annotation.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface b {

    public @interface a {
        p.a include() default p.a.NON_NULL;

        String propName() default "";

        String propNamespace() default "";

        boolean required() default false;

        String value();
    }

    /* renamed from: k8.b$b  reason: collision with other inner class name */
    public @interface C0148b {
        p.a include() default p.a.NON_NULL;

        String name() default "";

        String namespace() default "";

        boolean required() default false;

        Class type() default Object.class;

        Class value();
    }

    a[] attrs() default {};

    boolean prepend() default false;

    C0148b[] props() default {};
}
