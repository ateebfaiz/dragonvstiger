package d3;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import y2.q;

public class a {

    /* renamed from: h  reason: collision with root package name */
    private static a f21023h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f21024i = TimeUnit.MINUTES.toMillis(2);

    /* renamed from: a  reason: collision with root package name */
    private volatile StatFs f21025a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile File f21026b;

    /* renamed from: c  reason: collision with root package name */
    private volatile StatFs f21027c = null;

    /* renamed from: d  reason: collision with root package name */
    private volatile File f21028d;

    /* renamed from: e  reason: collision with root package name */
    private long f21029e;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f21030f = new ReentrantLock();

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f21031g = false;

    /* renamed from: d3.a$a  reason: collision with other inner class name */
    public enum C0260a {
        INTERNAL,
        EXTERNAL
    }

    protected a() {
    }

    protected static StatFs a(String str) {
        return new StatFs(str);
    }

    private void b() {
        if (!this.f21031g) {
            this.f21030f.lock();
            try {
                if (!this.f21031g) {
                    this.f21026b = Environment.getDataDirectory();
                    this.f21028d = Environment.getExternalStorageDirectory();
                    g();
                    this.f21031g = true;
                }
            } finally {
                this.f21030f.unlock();
            }
        }
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f21023h == null) {
                    f21023h = new a();
                }
                aVar = f21023h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private void e() {
        if (this.f21030f.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f21029e > f21024i) {
                    g();
                }
            } finally {
                this.f21030f.unlock();
            }
        }
    }

    private void g() {
        this.f21025a = h(this.f21025a, this.f21026b);
        this.f21027c = h(this.f21027c, this.f21028d);
        this.f21029e = SystemClock.uptimeMillis();
    }

    private StatFs h(StatFs statFs, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (statFs == null) {
            try {
                statFs = a(file.getAbsolutePath());
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Throwable th) {
                throw q.a(th);
            }
        } else {
            statFs.restat(file.getAbsolutePath());
        }
        return statFs;
    }

    public long c(C0260a aVar) {
        StatFs statFs;
        b();
        e();
        if (aVar == C0260a.INTERNAL) {
            statFs = this.f21025a;
        } else {
            statFs = this.f21027c;
        }
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return 0;
    }

    public boolean f(C0260a aVar, long j10) {
        b();
        long c10 = c(aVar);
        if (c10 <= 0 || c10 < j10) {
            return true;
        }
        return false;
    }
}
