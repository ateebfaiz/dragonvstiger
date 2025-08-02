package j2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import l2.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22139a = a.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f22140b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f22141c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f22142d;

    /* renamed from: e  reason: collision with root package name */
    private static ServiceConnection f22143e;

    /* renamed from: f  reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f22144f;

    /* renamed from: g  reason: collision with root package name */
    private static Intent f22145g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static Object f22146h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f22147i = new a();

    /* renamed from: j2.a$a  reason: collision with other inner class name */
    public static final class C0290a implements ServiceConnection {
        C0290a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.f(componentName, "name");
            m.f(iBinder, NotificationCompat.CATEGORY_SERVICE);
            a.f22146h = d.a(o.f(), iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            m.f(componentName, "name");
        }
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: j2.a$b$a  reason: collision with other inner class name */
        static final class C0291a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final C0291a f22148a = new C0291a();

            C0291a() {
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        Context f10 = o.f();
                        a aVar = a.f22147i;
                        aVar.f(f10, d.i(f10, a.f22146h), false);
                        aVar.f(f10, d.j(f10, a.f22146h), true);
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        /* renamed from: j2.a$b$b  reason: collision with other inner class name */
        static final class C0292b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final C0292b f22149a = new C0292b();

            C0292b() {
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        Context f10 = o.f();
                        a aVar = a.f22147i;
                        ArrayList i10 = d.i(f10, a.f22146h);
                        if (i10.isEmpty()) {
                            i10 = d.g(f10, a.f22146h);
                        }
                        aVar.f(f10, i10, false);
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        b() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityResumed(Activity activity) {
            m.f(activity, "activity");
            try {
                o.p().execute(C0291a.f22148a);
            } catch (Exception unused) {
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
            m.f(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            m.f(activity, "activity");
            try {
                if (m.b(a.f22142d, Boolean.TRUE) && m.b(activity.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                    o.p().execute(C0292b.f22149a);
                }
            } catch (Exception unused) {
            }
        }
    }

    private a() {
    }

    private final void e() {
        boolean z10;
        if (f22141c == null) {
            boolean z11 = false;
            if (h.a("com.android.vending.billing.IInAppBillingService$Stub") != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            f22141c = valueOf;
            if (!m.b(valueOf, Boolean.FALSE)) {
                if (h.a("com.android.billingclient.api.ProxyBillingActivity") != null) {
                    z11 = true;
                }
                f22142d = Boolean.valueOf(z11);
                d.b();
                Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                m.e(intent, "Intent(\"com.android.vend…ge(\"com.android.vending\")");
                f22145g = intent;
                f22143e = new C0290a();
                f22144f = new b();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void f(Context context, ArrayList arrayList, boolean z10) {
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    String string = new JSONObject(str).getString("productId");
                    m.e(string, "sku");
                    m.e(str, FirebaseAnalytics.Event.PURCHASE);
                    hashMap.put(string, str);
                    arrayList2.add(string);
                } catch (JSONException e10) {
                    Log.e(f22139a, "Error parsing in-app purchase data.", e10);
                }
            }
            for (Map.Entry entry : d.k(context, arrayList2, f22146h, z10).entrySet()) {
                String str2 = (String) entry.getValue();
                String str3 = (String) hashMap.get((String) entry.getKey());
                if (str3 != null) {
                    m.e(str3, "it");
                    d.f(str3, str2, z10);
                }
            }
        }
    }

    public static final void g() {
        a aVar = f22147i;
        aVar.e();
        if (!m.b(f22141c, Boolean.FALSE) && d.c()) {
            aVar.h();
        }
    }

    private final void h() {
        if (f22140b.compareAndSet(false, true)) {
            Context f10 = o.f();
            if (f10 instanceof Application) {
                Application application = (Application) f10;
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f22144f;
                if (activityLifecycleCallbacks == null) {
                    m.u("callbacks");
                }
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                Intent intent = f22145g;
                if (intent == null) {
                    m.u("intent");
                }
                ServiceConnection serviceConnection = f22143e;
                if (serviceConnection == null) {
                    m.u("serviceConnection");
                }
                f10.bindService(intent, serviceConnection, 1);
            }
        }
    }
}
