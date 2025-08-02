package yc;

import java.security.AccessController;
import java.security.PrivilegedAction;

public abstract class a {

    /* renamed from: yc.a$a  reason: collision with other inner class name */
    static class C0037a implements PrivilegedAction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2209a;

        C0037a(String str) {
            this.f2209a = str;
        }

        public Object run() {
            try {
                return Class.forName(this.f2209a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static Class a(Class cls, String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return classLoader.loadClass(str);
            }
            return (Class) AccessController.doPrivileged(new C0037a(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
