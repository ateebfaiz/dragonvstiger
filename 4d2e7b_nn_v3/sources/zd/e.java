package zd;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

public abstract class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f2245a = new ThreadLocal();

    static class a implements PrivilegedAction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2246a;

        a(String str) {
            this.f2246a = str;
        }

        public Object run() {
            Map map = (Map) e.f2245a.get();
            if (map != null) {
                return map.get(this.f2246a);
            }
            return System.getProperty(this.f2246a);
        }
    }

    private static String b(String str) {
        return (String) AccessController.doPrivileged(new a(str));
    }

    public static boolean c(String str) {
        try {
            String b10 = b(str);
            if (b10 != null) {
                return "true".equals(f.d(b10));
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }
}
