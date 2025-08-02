package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import c.d;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class r implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    static final r f18417g = new r();

    /* renamed from: h  reason: collision with root package name */
    private static final Activity f18418h = new Activity();

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList f18419a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final List f18420b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final Map f18421c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private int f18422d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f18423e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18424f = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f18425a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f18426b;

        a(Activity activity, Object obj) {
            this.f18425a = activity;
            this.f18426b = obj;
        }

        public void run() {
            try {
                Window window = this.f18425a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f18426b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    r() {
    }

    private void a(Activity activity, Lifecycle.Event event) {
        b(activity, event, (List) this.f18421c.get(activity));
        b(activity, event, (List) this.f18421c.get(f18418h));
    }

    private void b(Activity activity, Lifecycle.Event event, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                d.a(it.next());
                throw null;
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.f18421c.remove(activity);
            }
        }
    }

    private Object c() {
        Object d10 = d();
        if (d10 != null) {
            return d10;
        }
        return e();
    }

    private Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e10.getMessage());
            return null;
        }
    }

    private Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e10.getMessage());
            return null;
        }
    }

    private void h(Activity activity, boolean z10) {
        if (!this.f18420b.isEmpty()) {
            Iterator it = this.f18420b.iterator();
            if (it.hasNext()) {
                d.a(it.next());
                if (z10) {
                    throw null;
                }
                throw null;
            }
        }
    }

    private void i(Activity activity, boolean z10) {
        if (z10) {
            try {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } catch (Exception unused) {
            }
        } else {
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                s.l(new a(activity, tag), 100);
            }
        }
    }

    private static void j() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get((Object) null)).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            }
        }
    }

    private void k(Activity activity) {
        if (!this.f18419a.contains(activity)) {
            this.f18419a.addFirst(activity);
        } else if (!((Activity) this.f18419a.getFirst()).equals(activity)) {
            this.f18419a.remove(activity);
            this.f18419a.addFirst(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public Application f() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object c10 = c();
            if (c10 == null || (invoke = cls.getMethod("getApplication", (Class[]) null).invoke(c10, (Object[]) null)) == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    /* access modifiers changed from: package-private */
    public void l(Application application) {
        this.f18419a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f18419a.size() == 0) {
            h(activity, true);
        }
        e.a(activity);
        j();
        k(activity);
        a(activity, Lifecycle.Event.ON_CREATE);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f18419a.remove(activity);
        s.b(activity);
        a(activity, Lifecycle.Event.ON_DESTROY);
    }

    public void onActivityPaused(Activity activity) {
        a(activity, Lifecycle.Event.ON_PAUSE);
    }

    public void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPostDestroyed(Activity activity) {
    }

    public void onActivityPostPaused(Activity activity) {
    }

    public void onActivityPostResumed(Activity activity) {
    }

    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityPostStarted(Activity activity) {
    }

    public void onActivityPostStopped(Activity activity) {
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPreDestroyed(Activity activity) {
    }

    public void onActivityPrePaused(Activity activity) {
    }

    public void onActivityPreResumed(Activity activity) {
    }

    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityPreStarted(Activity activity) {
    }

    public void onActivityPreStopped(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        k(activity);
        if (this.f18424f) {
            this.f18424f = false;
            h(activity, true);
        }
        i(activity, false);
        a(activity, Lifecycle.Event.ON_RESUME);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (!this.f18424f) {
            k(activity);
        }
        int i10 = this.f18423e;
        if (i10 < 0) {
            this.f18423e = i10 + 1;
        } else {
            this.f18422d++;
        }
        a(activity, Lifecycle.Event.ON_START);
    }

    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f18423e--;
        } else {
            int i10 = this.f18422d - 1;
            this.f18422d = i10;
            if (i10 <= 0) {
                this.f18424f = true;
                h(activity, false);
            }
        }
        i(activity, true);
        a(activity, Lifecycle.Event.ON_STOP);
    }
}
