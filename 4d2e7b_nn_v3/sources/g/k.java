package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import f.a;
import i.v;
import java.util.concurrent.atomic.AtomicBoolean;
import w.d;
import x.h;

public class k {

    /* renamed from: h  reason: collision with root package name */
    public static final String f21555h = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final Context f21556a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f21557b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f21558c;

    /* renamed from: d  reason: collision with root package name */
    public f.a f21559d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f21560e;

    /* renamed from: f  reason: collision with root package name */
    public c f21561f;

    /* renamed from: g  reason: collision with root package name */
    public final IBinder.DeathRecipient f21562g = new a();

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        public void binderDied() {
            String unused = k.f21555h;
            f.a aVar = k.this.f21559d;
            if (aVar != null) {
                aVar.asBinder().unlinkToDeath(k.this.f21562g, 0);
                k kVar = k.this;
                kVar.f21559d = null;
                c cVar = kVar.f21561f;
                if (cVar != null) {
                    cVar.b();
                }
            }
        }
    }

    public class b implements ServiceConnection {
        public b(a aVar) {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String unused = k.f21555h;
            k.this.f21559d = a.C0268a.M(iBinder);
            k kVar = k.this;
            if (kVar.f21559d != null) {
                c cVar = kVar.f21561f;
                if (cVar != null) {
                    cVar.a();
                }
                try {
                    iBinder.linkToDeath(k.this.f21562g, 0);
                } catch (RemoteException unused2) {
                    String str = k.f21555h;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            String unused = k.f21555h;
        }
    }

    public interface c {
        void a();

        void b();
    }

    public k(Context context, boolean z10) {
        this.f21556a = context.getApplicationContext();
        this.f21557b = new AtomicBoolean(true);
        this.f21558c = z10;
    }

    public static boolean d(Context context, ServiceConnection serviceConnection) {
        try {
            return context.bindService(new Intent().setAction("mah.remote.service").setPackage(v.a(context)), serviceConnection, 1);
        } catch (Throwable th) {
            Log.getStackTraceString(th);
            return false;
        }
    }

    public void b(c cVar) {
        this.f21561f = cVar;
    }

    public void c(boolean z10) {
        if (this.f21557b.get()) {
            this.f21557b.set(false);
            f.a aVar = this.f21559d;
            if (aVar != null) {
                if (z10) {
                    try {
                        aVar.OooO00o();
                    } catch (RemoteException unused) {
                    }
                }
                this.f21559d = null;
            }
            ServiceConnection serviceConnection = this.f21560e;
            if (serviceConnection != null) {
                this.f21556a.unbindService(serviceConnection);
            }
        }
    }

    public f.a e() {
        return this.f21559d;
    }

    public boolean f() {
        if (!this.f21557b.get()) {
            return false;
        }
        return d(this.f21556a, this.f21560e);
    }

    public void g() {
        try {
            this.f21556a.unbindService(this.f21560e);
        } catch (Exception unused) {
        }
    }

    public boolean h() {
        if (this.f21558c) {
            d.k(f21555h, "Remote service mode");
            b bVar = new b((a) null);
            this.f21560e = bVar;
            boolean d10 = d(this.f21556a, bVar);
            if (d10) {
                return d10;
            }
            SystemClock.sleep(66);
            return d(this.f21556a, this.f21560e);
        }
        d.k(f21555h, "Local service mode");
        f.a a10 = h.b(this.f21556a).a();
        this.f21559d = a10;
        if (a10 == null) {
            return false;
        }
        c cVar = this.f21561f;
        if (cVar == null) {
            return true;
        }
        cVar.a();
        return true;
    }
}
