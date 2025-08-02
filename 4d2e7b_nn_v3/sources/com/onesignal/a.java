package com.onesignal;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewTreeObserver;
import com.onesignal.c3;
import com.onesignal.o3;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class a implements c3.b {

    /* renamed from: d  reason: collision with root package name */
    private static final Map f10331d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Map f10332e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final Map f10333f = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final OSFocusHandler f10334a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f10335b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10336c = false;

    /* renamed from: com.onesignal.a$a  reason: collision with other inner class name */
    class C0123a extends Thread {
        C0123a() {
        }

        public void run() {
            o3.b0().c();
            a.this.f10334a.k("FOCUS_LOST_WORKER_TAG", 2000, o3.f10882b);
        }
    }

    static abstract class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Activity activity);

        /* access modifiers changed from: package-private */
        public void b(Activity activity) {
        }
    }

    static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        private final c3.c f10338a;

        /* renamed from: b  reason: collision with root package name */
        private final c3.b f10339b;

        /* renamed from: c  reason: collision with root package name */
        private final String f10340c;

        /* synthetic */ c(c3.b bVar, c3.c cVar, String str, C0123a aVar) {
            this(bVar, cVar, str);
        }

        public void onGlobalLayout() {
            if (!m3.j(new WeakReference(o3.Q()))) {
                this.f10339b.a(this.f10340c, this);
                this.f10338a.c();
            }
        }

        private c(c3.b bVar, c3.c cVar, String str) {
            this.f10339b = bVar;
            this.f10338a = cVar;
            this.f10340c = str;
        }
    }

    public a(OSFocusHandler oSFocusHandler) {
        this.f10334a = oSFocusHandler;
    }

    private void f() {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "ActivityLifecycleHandler handleFocus, nextResumeIsFirstActivity: " + this.f10336c);
        if (this.f10334a.f() || this.f10336c) {
            o3.d1(vVar, "ActivityLifecycleHandler reset background state, call app focus");
            this.f10336c = false;
            this.f10334a.j();
            return;
        }
        o3.d1(vVar, "ActivityLifecycleHandler cancel background lost focus worker");
        this.f10334a.e("FOCUS_LOST_WORKER_TAG", o3.f10882b);
    }

    private void g() {
        o3.d1(o3.v.DEBUG, "ActivityLifecycleHandler Handling lost focus");
        OSFocusHandler oSFocusHandler = this.f10334a;
        if (oSFocusHandler == null) {
            return;
        }
        if (!oSFocusHandler.f() || this.f10334a.g()) {
            new C0123a().start();
        }
    }

    private void h() {
        String str;
        o3.v vVar = o3.v.DEBUG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("curActivity is NOW: ");
        if (this.f10335b != null) {
            str = "" + this.f10335b.getClass().getName() + ":" + this.f10335b;
        } else {
            str = "null";
        }
        sb2.append(str);
        o3.a(vVar, sb2.toString());
    }

    private void i(int i10, Activity activity) {
        if (i10 == 2) {
            o3.v vVar = o3.v.DEBUG;
            o3.d1(vVar, "Configuration Orientation Change: LANDSCAPE (" + i10 + ") on activity: " + activity);
        } else if (i10 == 1) {
            o3.v vVar2 = o3.v.DEBUG;
            o3.d1(vVar2, "Configuration Orientation Change: PORTRAIT (" + i10 + ") on activity: " + activity);
        }
    }

    private void q(Activity activity) {
        g();
        for (Map.Entry value : f10331d.entrySet()) {
            ((b) value.getValue()).b(activity);
        }
        for (Map.Entry value2 : f10331d.entrySet()) {
            ((b) value2.getValue()).a(this.f10335b);
        }
        ViewTreeObserver viewTreeObserver = this.f10335b.getWindow().getDecorView().getViewTreeObserver();
        for (Map.Entry entry : f10332e.entrySet()) {
            c cVar = new c(this, (c3.c) entry.getValue(), (String) entry.getKey(), (C0123a) null);
            viewTreeObserver.addOnGlobalLayoutListener(cVar);
            f10333f.put((String) entry.getKey(), cVar);
        }
        f();
    }

    public void a(String str, c cVar) {
        Activity activity = this.f10335b;
        if (activity != null) {
            activity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(cVar);
        }
        f10333f.remove(str);
        f10332e.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void c(String str, b bVar) {
        f10331d.put(str, bVar);
        Activity activity = this.f10335b;
        if (activity != null) {
            bVar.a(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str, c3.c cVar) {
        Activity activity = this.f10335b;
        if (activity != null) {
            ViewTreeObserver viewTreeObserver = activity.getWindow().getDecorView().getViewTreeObserver();
            c cVar2 = new c(this, cVar, str, (C0123a) null);
            viewTreeObserver.addOnGlobalLayoutListener(cVar2);
            f10333f.put(str, cVar2);
        }
        f10332e.put(str, cVar);
    }

    public Activity e() {
        return this.f10335b;
    }

    /* access modifiers changed from: package-private */
    public void j(Activity activity) {
    }

    /* access modifiers changed from: package-private */
    public void k(Activity activity) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "onActivityDestroyed: " + activity);
        f10333f.clear();
        if (activity == this.f10335b) {
            this.f10335b = null;
            g();
        }
        h();
    }

    /* access modifiers changed from: package-private */
    public void l(Activity activity) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "onActivityPaused: " + activity);
        if (activity == this.f10335b) {
            this.f10335b = null;
            g();
        }
        h();
    }

    /* access modifiers changed from: package-private */
    public void m(Activity activity) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "onActivityResumed: " + activity);
        s(activity);
        h();
        f();
    }

    /* access modifiers changed from: package-private */
    public void n(Activity activity) {
        this.f10334a.l();
    }

    /* access modifiers changed from: package-private */
    public void o(Activity activity) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "onActivityStopped: " + activity);
        if (activity == this.f10335b) {
            this.f10335b = null;
            g();
        }
        for (Map.Entry value : f10331d.entrySet()) {
            ((b) value.getValue()).b(activity);
        }
        h();
        if (this.f10335b == null) {
            this.f10334a.m();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(Configuration configuration, Activity activity) {
        Activity activity2 = this.f10335b;
        if (activity2 != null && OSUtils.q(activity2, 128)) {
            i(configuration.orientation, activity);
            q(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(String str) {
        f10331d.remove(str);
    }

    public void s(Activity activity) {
        this.f10335b = activity;
        for (Map.Entry value : f10331d.entrySet()) {
            ((b) value.getValue()).a(this.f10335b);
        }
        try {
            ViewTreeObserver viewTreeObserver = this.f10335b.getWindow().getDecorView().getViewTreeObserver();
            for (Map.Entry entry : f10332e.entrySet()) {
                c cVar = new c(this, (c3.c) entry.getValue(), (String) entry.getKey(), (C0123a) null);
                viewTreeObserver.addOnGlobalLayoutListener(cVar);
                f10333f.put((String) entry.getKey(), cVar);
            }
        } catch (RuntimeException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z10) {
        this.f10336c = z10;
    }
}
