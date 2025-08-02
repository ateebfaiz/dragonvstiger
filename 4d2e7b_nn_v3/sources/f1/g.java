package f1;

import c.d;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final Set f21377a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader[] f21378b;

    g(Collection collection) {
        this.f21378b = (ClassLoader[]) collection.toArray(new ClassLoader[0]);
    }

    private String[] a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return new String[]{String.format("_%s_DslJsonConverter", new Object[]{str})};
        }
        String substring = str.substring(0, lastIndexOf);
        String substring2 = str.substring(lastIndexOf + 1);
        return new String[]{String.format("%s._%s_DslJsonConverter", new Object[]{substring, substring2}), String.format("dsl_json.%s._%s_DslJsonConverter", new Object[]{substring, substring2}), String.format("dsl_json.%s.%sDslJsonConverter", new Object[]{substring, substring2})};
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b(Class cls, f fVar) {
        String name = cls.getName();
        if (!this.f21377a.add(name)) {
            return false;
        }
        String[] a10 = a(name);
        for (ClassLoader classLoader : this.f21378b) {
            int length = a10.length;
            int i10 = 0;
            while (i10 < length) {
                try {
                    Class<?> loadClass = classLoader.loadClass(a10[i10]);
                    if (!d.class.isAssignableFrom(loadClass)) {
                        i10++;
                    } else {
                        d.a(loadClass.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
                        throw null;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
            }
        }
        return false;
    }
}
