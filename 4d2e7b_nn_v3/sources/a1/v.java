package a1;

import android.os.SystemClock;
import android.util.Log;
import com.alibaba.pdns.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static String f13656a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13657b = Log.isLoggable("Volley", 2);

    static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f13658c = v.f13657b;

        /* renamed from: a  reason: collision with root package name */
        private final List f13659a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f13660b = false;

        /* renamed from: a1.v$a$a  reason: collision with other inner class name */
        private static class C0171a {

            /* renamed from: a  reason: collision with root package name */
            public final String f13661a;

            /* renamed from: b  reason: collision with root package name */
            public final long f13662b;

            /* renamed from: c  reason: collision with root package name */
            public final long f13663c;

            public C0171a(String str, long j10, long j11) {
                this.f13661a = str;
                this.f13662b = j10;
                this.f13663c = j11;
            }
        }

        a() {
        }

        private long c() {
            if (this.f13659a.size() == 0) {
                return 0;
            }
            long j10 = ((C0171a) this.f13659a.get(0)).f13663c;
            List list = this.f13659a;
            return ((C0171a) list.get(list.size() - 1)).f13663c - j10;
        }

        public synchronized void a(String str, long j10) {
            if (!this.f13660b) {
                this.f13659a.add(new C0171a(str, j10, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            this.f13660b = true;
            long c10 = c();
            if (c10 > 0) {
                long j10 = ((C0171a) this.f13659a.get(0)).f13663c;
                v.b("(%-4d ms) %s", Long.valueOf(c10), str);
                for (C0171a aVar : this.f13659a) {
                    long j11 = aVar.f13663c;
                    v.b("(+%-4d) [%2d] %s", Long.valueOf(j11 - j10), Long.valueOf(aVar.f13662b), aVar.f13661a);
                    j10 = j11;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            if (!this.f13660b) {
                b("Request on the loose");
                v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i10 = 2;
        while (true) {
            if (i10 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i10].getClass().equals(v.class)) {
                String className = stackTrace[i10].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + f.G + stackTrace[i10].getMethodName();
                break;
            } else {
                i10++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void b(String str, Object... objArr) {
        Log.d(f13656a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f13656a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f13656a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (f13657b) {
            Log.v(f13656a, a(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f13656a, a(str, objArr));
    }
}
