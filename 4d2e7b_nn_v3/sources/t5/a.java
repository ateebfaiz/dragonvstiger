package t5;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import com.facebook.o;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;
import s5.b;
import s5.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f24159a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final ScheduledExecutorService f24160b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: c  reason: collision with root package name */
    private static String f24161c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final Runnable f24162d = C0338a.f24164a;

    /* renamed from: e  reason: collision with root package name */
    public static final a f24163e = new a();

    /* renamed from: t5.a$a  reason: collision with other inner class name */
    static final class C0338a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C0338a f24164a = new C0338a();

        C0338a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    Object systemService = o.f().getSystemService("activity");
                    if (systemService != null) {
                        a.a((ActivityManager) systemService);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
                } catch (Exception unused) {
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private a() {
    }

    public static final void a(ActivityManager activityManager) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls) && activityManager != null) {
            try {
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == f24159a) {
                            Looper mainLooper = Looper.getMainLooper();
                            m.e(mainLooper, "Looper.getMainLooper()");
                            Thread thread = mainLooper.getThread();
                            m.e(thread, "Looper.getMainLooper().thread");
                            String d10 = f.d(thread);
                            if (!m.b(d10, f24161c)) {
                                if (f.g(thread)) {
                                    f24161c = d10;
                                    b.a.a(processErrorStateInfo.shortMsg, d10).g();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void b() {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f24160b.scheduleAtFixedRate(f24162d, 0, (long) 500, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
