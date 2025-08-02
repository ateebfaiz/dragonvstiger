package aa;

import java.lang.reflect.Type;

public abstract class k {
    public static boolean a(Type type) {
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return false;
        }
        return true;
    }
}
