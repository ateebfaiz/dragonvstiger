package n2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import c6.a;
import com.facebook.o;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import q5.p0;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22820a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f22821b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f22822c = new c();

    public enum a {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f22826a;

        private a(String str) {
            this.f22826a = str;
        }

        public String toString() {
            return this.f22826a;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f22827a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        private IBinder f22828b;

        public final IBinder a() {
            this.f22827a.await(5, TimeUnit.SECONDS);
            return this.f22828b;
        }

        public void onNullBinding(ComponentName componentName) {
            m.f(componentName, "name");
            this.f22827a.countDown();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.f(componentName, "name");
            m.f(iBinder, "serviceBinder");
            this.f22828b = iBinder;
            this.f22827a.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            m.f(componentName, "name");
        }
    }

    /* renamed from: n2.c$c  reason: collision with other inner class name */
    public enum C0313c {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR
    }

    static {
        String simpleName = c.class.getSimpleName();
        m.e(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        f22820a = simpleName;
    }

    private c() {
    }

    private final Intent a(Context context) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent("ReceiverService");
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null && q5.m.a(context, "com.facebook.katana")) {
                    return intent;
                }
                Intent intent2 = new Intent("ReceiverService");
                intent2.setPackage("com.facebook.wakizashi");
                if (packageManager.resolveService(intent2, 0) == null || !q5.m.a(context, "com.facebook.wakizashi")) {
                    return null;
                }
                return intent2;
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final boolean b() {
        boolean z10;
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            if (f22821b == null) {
                if (f22822c.a(o.f()) != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                f22821b = Boolean.valueOf(z10);
            }
            Boolean bool = f22821b;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final C0313c c(String str, List list) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "applicationId");
            m.f(list, "appEvents");
            return f22822c.d(a.CUSTOM_APP_EVENTS, str, list);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final C0313c d(a aVar, String str, List list) {
        Context f10;
        b bVar;
        String str2;
        C0313c cVar;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            C0313c cVar2 = C0313c.SERVICE_NOT_AVAILABLE;
            l2.b.b();
            f10 = o.f();
            Intent a10 = a(f10);
            if (a10 == null) {
                return cVar2;
            }
            bVar = new b();
            if (!f10.bindService(a10, bVar, 1)) {
                return C0313c.SERVICE_ERROR;
            }
            try {
                IBinder a11 = bVar.a();
                if (a11 != null) {
                    c6.a M = a.C0225a.M(a11);
                    Bundle a12 = b.a(aVar, str, list);
                    if (a12 != null) {
                        M.f(a12);
                        String str3 = f22820a;
                        p0.f0(str3, "Successfully sent events to the remote service: " + a12);
                    }
                    cVar2 = C0313c.OPERATION_SUCCESS;
                }
                f10.unbindService(bVar);
                p0.f0(f22820a, "Unbound from the remote service");
                return cVar2;
            } catch (InterruptedException e10) {
                cVar = C0313c.SERVICE_ERROR;
                str2 = f22820a;
                p0.e0(str2, e10);
                f10.unbindService(bVar);
                p0.f0(str2, "Unbound from the remote service");
                return cVar;
            } catch (RemoteException e11) {
                cVar = C0313c.SERVICE_ERROR;
                str2 = f22820a;
                p0.e0(str2, e11);
                f10.unbindService(bVar);
                p0.f0(str2, "Unbound from the remote service");
                return cVar;
            }
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final C0313c e(String str) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "applicationId");
            return f22822c.d(a.MOBILE_APP_INSTALL, str, r.l());
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }
}
