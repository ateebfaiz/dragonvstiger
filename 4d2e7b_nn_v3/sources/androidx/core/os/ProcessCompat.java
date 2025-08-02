package androidx.core.os;

import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

public final class ProcessCompat {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Object f15039a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private static Method f15040b;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f15041c;

        static boolean a(int i10) {
            try {
                synchronized (f15039a) {
                    if (!f15041c) {
                        f15041c = true;
                        f15040b = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                Method method = f15040b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke((Object) null, new Object[]{Integer.valueOf(i10)});
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            } catch (Throwable th) {
                while (true) {
                }
                throw th;
            }
            return true;
        }
    }

    static class b {
        static boolean a(int i10) {
            return Process.isApplicationUid(i10);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(i10);
        }
        return a.a(i10);
    }
}
