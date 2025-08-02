package com.onesignal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;

class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static b f10380a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static a f10381b;

    /* renamed from: c  reason: collision with root package name */
    private static ComponentCallbacks f10382c;

    class a implements ComponentCallbacks {
        a() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            b.f10381b.p(configuration, b.f10381b.e());
        }

        public void onLowMemory() {
        }
    }

    b() {
    }

    public static a b() {
        return f10381b;
    }

    static void c(Application application) {
        if (f10380a == null) {
            b bVar = new b();
            f10380a = bVar;
            application.registerActivityLifecycleCallbacks(bVar);
        }
        if (f10381b == null) {
            f10381b = new a(new OSFocusHandler());
        }
        if (f10382c == null) {
            a aVar = new a();
            f10382c = aVar;
            application.registerComponentCallbacks(aVar);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.j(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.k(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.l(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.m(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.n(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        a aVar = f10381b;
        if (aVar != null) {
            aVar.o(activity);
        }
    }
}
