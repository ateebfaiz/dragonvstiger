package a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.mah.sdk.crashcatch.JniUtils;
import i.u;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    public static final b f13552e = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f13553f = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List f13554a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b  reason: collision with root package name */
    public int f13555b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13556c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Stack f13557d = new Stack();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13558a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13560c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f13561d;

        public a(String str, String str2, String str3, c cVar) {
            this.f13558a = str;
            this.f13559b = str2;
            this.f13560c = str3;
            this.f13561d = cVar;
        }

        public void run() {
            this.f13561d.a(b.l(this.f13558a, this.f13559b, this.f13560c));
        }
    }

    /* renamed from: a.b$b  reason: collision with other inner class name */
    public class C0168b implements Runnable {
        public C0168b() {
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                JniUtils.exitCrash();
                throw th;
            }
            JniUtils.exitCrash();
        }
    }

    public static int a(Context context, c cVar, boolean z10) {
        return f13552e.b(context, cVar, Boolean.valueOf(z10), (ThreadPoolExecutor) null).f13574a;
    }

    public static Throwable d(Throwable th, Set set) {
        try {
            Throwable cause = new Throwable(th).getCause();
            for (Throwable th2 = cause; th2 != null; th2 = th2.getCause()) {
                th2.getMessage();
                StackTraceElement[] stackTrace = th2.getStackTrace();
                ArrayList arrayList = new ArrayList(stackTrace.length);
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            arrayList.add(stackTraceElement);
                            break;
                        }
                        if (stackTraceElement.getClassName().startsWith((String) it.next())) {
                            break;
                        }
                    }
                }
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
            return cause;
        } catch (Throwable unused) {
            return th;
        }
    }

    public static List e(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\n");
        ArrayList arrayList = new ArrayList(split.length);
        for (String trim : split) {
            String replace = trim.trim().replace("  ", " ");
            String[] split2 = replace.split(" ");
            if (split2.length >= 4) {
                String replaceFirst = split2[2].replaceFirst("0*", "0x");
                String str3 = split2[3];
                try {
                    str2 = replace.substring(replace.indexOf(str3) + str3.length() + 1);
                } catch (StringIndexOutOfBoundsException unused) {
                    str2 = "nil";
                }
                arrayList.add(split2[0] + " pc=" + replaceFirst + " module=" + str3 + " function=" + str2);
            } else {
                arrayList.add(replace);
            }
        }
        return arrayList;
    }

    public static b k() {
        return f13552e;
    }

    public static String l(String str, String str2, String str3) {
        String str4 = str + " thread:" + str3;
        List e10 = e(str2);
        if (e10 == null) {
            return str4;
        }
        return str4 + "\n" + TextUtils.join("\n", e10);
    }

    public d b(Context context, c cVar, Boolean bool, ThreadPoolExecutor threadPoolExecutor) {
        Thread.currentThread().getName();
        if (context == null) {
            return d.SDK_PARA_ERROR;
        }
        if (!this.f13554a.contains(cVar)) {
            synchronized (this.f13554a) {
                this.f13554a.add(cVar);
            }
        }
        int i10 = this.f13555b;
        int i11 = i10 & 1;
        if (i11 > 0 && (i10 & 2) > 0) {
            return d.SUCCESS;
        }
        if (i11 == 0) {
            this.f13555b = i10 | 1;
            this.f13557d.push(Thread.getDefaultUncaughtExceptionHandler());
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (bool.booleanValue()) {
            int i12 = this.f13555b;
            if ((i12 & 2) == 0) {
                this.f13555b = i12 | 2;
                m();
                d a10 = d.a(JniUtils.initCrashLib(Build.VERSION.SDK_INT, 128));
                int i13 = a10.f13574a;
                return a10;
            }
        }
        return d.SUCCESS;
    }

    public void f() {
        u.b(new C0168b());
    }

    public void g(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        try {
            th.getMessage();
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } catch (Throwable unused) {
        }
    }

    public void h(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) this.f13557d.pop();
        Objects.toString(uncaughtExceptionHandler);
        this.f13557d.size();
        if (uncaughtExceptionHandler != null) {
            g(uncaughtExceptionHandler, thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public void i(String str, String str2, String str3) {
        if (this.f13554a.size() > 0) {
            synchronized (this.f13554a) {
                try {
                    for (c aVar : this.f13554a) {
                        u.b(new a(str, str2, str3, aVar));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|12|13|21|18|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0014, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(java.lang.Thread r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            java.util.List r0 = r4.f13554a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0034
            r6.getMessage()
            java.util.List r0 = r4.f13554a
            monitor-enter(r0)
            java.util.List r1 = r4.f13554a     // Catch:{ all -> 0x002a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x002a }
        L_0x0014:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x002a }
            a.c r2 = (a.c) r2     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = a.a.a(r6)     // Catch:{ Exception -> 0x002c }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x002c }
            r2.b(r5, r3)     // Catch:{ Exception -> 0x002c }
            goto L_0x0014
        L_0x002a:
            r5 = move-exception
            goto L_0x0032
        L_0x002c:
            r2.b(r5, r6)     // Catch:{ all -> 0x002a }
            goto L_0x0014
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            goto L_0x0034
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r5
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.j(java.lang.Thread, java.lang.Throwable):void");
    }

    public void m() {
        JniUtils.getABI();
        JniUtils.getVersion();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = f13553f
            monitor-enter(r0)
            boolean r1 = r2.f13556c     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x0011
            r2.h(r3, r4)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r3 = move-exception
            goto L_0x0025
        L_0x0011:
            r1 = 1
            r2.f13556c = r1     // Catch:{ all -> 0x000f }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x000f }
            r1.<init>()     // Catch:{ all -> 0x000f }
            java.lang.Throwable r4 = d(r4, r1)     // Catch:{ all -> 0x000f }
            r2.j(r3, r4)     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r2.h(r3, r4)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
