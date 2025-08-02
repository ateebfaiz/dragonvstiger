package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class f14841a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f14842b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f14843c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f14844d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f14845e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f14846f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f14847g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f14848a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f14849b;

        a(d dVar, Object obj) {
            this.f14848a = dVar;
            this.f14849b = obj;
        }

        public void run() {
            this.f14848a.f14854a = this.f14849b;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f14850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f14851b;

        b(Application application, d dVar) {
            this.f14850a = application;
            this.f14851b = dVar;
        }

        public void run() {
            this.f14850a.unregisterActivityLifecycleCallbacks(this.f14851b);
        }
    }

    /* renamed from: androidx.core.app.c$c  reason: collision with other inner class name */
    class C0187c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f14852a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f14853b;

        C0187c(Object obj, Object obj2) {
            this.f14852a = obj;
            this.f14853b = obj2;
        }

        public void run() {
            try {
                Method method = c.f14844d;
                if (method != null) {
                    method.invoke(this.f14852a, new Object[]{this.f14853b, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                c.f14845e.invoke(this.f14852a, new Object[]{this.f14853b, Boolean.FALSE});
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f14854a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f14855b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14856c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14857d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14858e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f14859f = false;

        d(Activity activity) {
            this.f14855b = activity;
            this.f14856c = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f14855b == activity) {
                this.f14855b = null;
                this.f14858e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f14858e && !this.f14859f && !this.f14857d && c.h(this.f14854a, this.f14856c, activity)) {
                this.f14859f = true;
                this.f14854a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f14855b == activity) {
                this.f14857d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a10 = a();
        f14841a = a10;
        f14844d = d(a10);
        f14845e = c(a10);
        f14846f = e(a10);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<List> cls2 = List.class;
                Class cls3 = Boolean.TYPE;
                Class<Configuration> cls4 = Configuration.class;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, cls2, cls2, Integer.TYPE, cls3, cls4, cls4, cls3, cls3});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26 || i10 == 27) {
            return true;
        }
        return false;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f14843c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i10) {
                    f14847g.postAtFrontOfQueue(new C0187c(f14842b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        Application application;
        d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f14846f == null) {
            return false;
        } else {
            if (f14845e == null && f14844d == null) {
                return false;
            }
            try {
                Object obj2 = f14843c.get(activity);
                if (obj2 == null || (obj = f14842b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f14847g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f14846f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
