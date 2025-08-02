package p8;

import com.fasterxml.jackson.databind.util.f;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: p8.a$a  reason: collision with other inner class name */
    static class C0154a {

        /* renamed from: d  reason: collision with root package name */
        private static final C0154a f12890d;

        /* renamed from: e  reason: collision with root package name */
        private static final RuntimeException f12891e;

        /* renamed from: a  reason: collision with root package name */
        private final Method f12892a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f12893b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f12894c;

        static {
            C0154a aVar = null;
            try {
                e = null;
                aVar = new C0154a();
            } catch (RuntimeException e10) {
                e = e10;
            }
            f12890d = aVar;
            f12891e = e;
        }

        private C0154a() {
            try {
                this.f12892a = Class.class.getMethod("getRecordComponents", (Class[]) null);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.f12893b = cls.getMethod("getName", (Class[]) null);
                this.f12894c = cls.getMethod("getType", (Class[]) null);
            } catch (Exception e10) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", new Object[]{e10.getClass().getName(), e10.getMessage()}), e10);
            }
        }

        public static C0154a b() {
            RuntimeException runtimeException = f12891e;
            if (runtimeException == null) {
                return f12890d;
            }
            throw runtimeException;
        }

        public String[] a(Class cls) {
            Object[] c10 = c(cls);
            String[] strArr = new String[c10.length];
            int i10 = 0;
            while (i10 < c10.length) {
                try {
                    strArr[i10] = (String) this.f12893b.invoke(c10[i10], (Object[]) null);
                    i10++;
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(i10), Integer.valueOf(c10.length), f.Q(cls)}), e10);
                }
            }
            return strArr;
        }

        /* access modifiers changed from: protected */
        public Object[] c(Class cls) {
            try {
                return (Object[]) this.f12892a.invoke(cls, (Object[]) null);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + f.Q(cls));
            }
        }
    }

    public static String[] a(Class cls) {
        return C0154a.b().a(cls);
    }
}
