package OooOoO0;

import OooO0o0.OooO0Oo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.mah.sdk.MahProxyAddress;
import d.b;
import f.a;
import w.d;
import x.f;
import x.j;

public class OooO0oO extends Service {

    /* renamed from: e  reason: collision with root package name */
    public static final String f13545e = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public j f13546a;

    /* renamed from: b  reason: collision with root package name */
    public f f13547b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f13548c;

    /* renamed from: d  reason: collision with root package name */
    public final Binder f13549d = new a();

    public class a extends a.C0268a {

        /* renamed from: OooOoO0.OooO0oO$a$a  reason: collision with other inner class name */
        public class C0167a implements Runnable {
            public C0167a() {
            }

            public void run() {
                String unused = OooO0oO.f13545e;
                System.exit(0);
            }
        }

        public a() {
        }

        public void OooO00o() {
            String unused = OooO0oO.f13545e;
            try {
                OooO0oO.this.f13547b.S(0);
                OooO0oO.this.f13546a.a();
            } catch (Throwable unused2) {
                String str = OooO0oO.f13545e;
            }
            OooO0oO.this.f13548c.postDelayed(new C0167a(), 10);
        }

        public MahProxyAddress c(int i10) {
            try {
                return OooO0oO.this.f13547b.h(b.a(i10));
            } catch (Throwable unused) {
                String unused2 = OooO0oO.f13545e;
                return null;
            }
        }

        public void d(f.b bVar) {
            try {
                OooO0oO.this.f13546a.d(bVar);
            } catch (Throwable unused) {
                String unused2 = OooO0oO.f13545e;
            }
        }

        public void e(f.b bVar) {
            try {
                OooO0oO.this.f13546a.e(bVar);
            } catch (Throwable unused) {
                String unused2 = OooO0oO.f13545e;
            }
        }

        public int x(OooO0Oo oooO0Oo) {
            String unused = OooO0oO.f13545e;
            try {
                return OooO0oO.this.f13547b.y(oooO0Oo);
            } catch (Throwable unused2) {
                String str = OooO0oO.f13545e;
                return -6;
            }
        }
    }

    public static void c(Context context) {
        if (d.d(context)) {
            d.c(new w.b(context));
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f13549d;
    }

    public void onCreate() {
        super.onCreate();
        c(this);
        this.f13546a = new j();
        this.f13547b = new f(this, false, this.f13546a);
        this.f13548c = new Handler();
    }

    public void onDestroy() {
        super.onDestroy();
        d.k(f13545e, "All process which use mah_remote has been exit, mah_remote process exit");
        System.exit(0);
    }
}
