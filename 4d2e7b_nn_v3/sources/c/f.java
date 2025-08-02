package c;

import java.util.Hashtable;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static Hashtable f17204a = new Hashtable();

    public static f a(String str, int i10) {
        d.a(b(str).get(new Integer(i10)));
        return null;
    }

    public static Hashtable b(String str) {
        Hashtable hashtable = (Hashtable) f17204a.get(str);
        if (hashtable != null) {
            return hashtable;
        }
        throw new RuntimeException("Extensions not supported by " + str + com.alibaba.pdns.f.G);
    }

    public static void c(String str, f fVar) {
        b(str);
    }
}
