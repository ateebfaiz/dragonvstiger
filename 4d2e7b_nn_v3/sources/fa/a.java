package fa;

import aa.b;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Objects;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Class f12079a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f12080b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12081c;

    private a(Type type) {
        Objects.requireNonNull(type);
        Type b10 = b.b(type);
        this.f12080b = b10;
        this.f12079a = b.k(b10);
        this.f12081c = b10.hashCode();
    }

    public static a a(Class cls) {
        return new a(cls);
    }

    public static a b(Type type) {
        return new a(type);
    }

    public static a c(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        if (type instanceof Class) {
            Class cls = (Class) type;
            TypeVariable[] typeParameters = cls.getTypeParameters();
            int length = typeParameters.length;
            int length2 = typeArr.length;
            if (length2 == length) {
                for (int i10 = 0; i10 < length; i10++) {
                    Type type2 = typeArr[i10];
                    Class k10 = b.k(type2);
                    TypeVariable typeVariable = typeParameters[i10];
                    Type[] bounds = typeVariable.getBounds();
                    int length3 = bounds.length;
                    int i11 = 0;
                    while (i11 < length3) {
                        if (b.k(bounds[i11]).isAssignableFrom(k10)) {
                            i11++;
                        } else {
                            throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                        }
                    }
                }
                return new a(b.n((Type) null, type, typeArr));
            }
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
    }

    public final Class d() {
        return this.f12079a;
    }

    public final Type e() {
        return this.f12080b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a) || !b.f(this.f12080b, ((a) obj).f12080b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f12081c;
    }

    public final String toString() {
        return b.t(this.f12080b);
    }
}
