package e2;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.o;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21125a;

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f21126b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static String f21127c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f21128d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f21129e = new b();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21130a = new a();

        a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    b.f21129e.c();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String simpleName = b.class.getSimpleName();
        m.e(simpleName, "AnalyticsUserIDStore::class.java.simpleName");
        f21125a = simpleName;
    }

    private b() {
    }

    public static final String b() {
        if (!f21128d) {
            Log.w(f21125a, "initStore should have been called before calling setUserID");
            f21129e.c();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f21126b;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str = f21127c;
            reentrantReadWriteLock.readLock().unlock();
            return str;
        } catch (Throwable th) {
            f21126b.readLock().unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        if (!f21128d) {
            ReentrantReadWriteLock reentrantReadWriteLock = f21126b;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (f21128d) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                f21127c = PreferenceManager.getDefaultSharedPreferences(o.f()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", (String) null);
                f21128d = true;
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                f21126b.writeLock().unlock();
                throw th;
            }
        }
    }

    public static final void d() {
        if (!f21128d) {
            m.f21204b.a().execute(a.f21130a);
        }
    }
}
