package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.facebook.react.bridge.UiThreadUtil;
import e6.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i2 implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f3777a;

    /* renamed from: b  reason: collision with root package name */
    private final j2 f3778b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3779a;

        a(List list) {
            this.f3779a = list;
        }

        public void run() {
            for (ViewManager trimMemory : this.f3779a) {
                trimMemory.trimMemory();
            }
        }
    }

    public i2(j2 j2Var) {
        this.f3777a = f.b();
        this.f3778b = j2Var;
    }

    private ViewManager d(String str) {
        ViewManager b10 = this.f3778b.b(str);
        if (b10 != null) {
            this.f3777a.put(str, b10);
        }
        return b10;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).invalidate();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(List list, int i10) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).onSurfaceStopped(i10);
        }
    }

    public synchronized ViewManager c(String str) {
        try {
            ViewManager viewManager = (ViewManager) this.f3777a.get(str);
            if (viewManager != null) {
                return viewManager;
            }
            String str2 = "RCT" + str;
            ViewManager viewManager2 = (ViewManager) this.f3777a.get(str2);
            if (viewManager2 != null) {
                return viewManager2;
            }
            if (this.f3778b != null) {
                ViewManager d10 = d(str);
                if (d10 != null) {
                    return d10;
                }
                ViewManager d11 = d(str2);
                if (d11 != null) {
                    return d11;
                }
                throw new s("ViewManagerResolver returned null for either " + str + " or " + str2 + ", existing names are: " + this.f3778b.a());
            }
            throw new s("No ViewManager found for class " + str);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized ViewManager e(String str) {
        ViewManager viewManager = (ViewManager) this.f3777a.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.f3778b == null) {
            return null;
        }
        return d(str);
    }

    public void f() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f3777a.values());
        }
        g2 g2Var = new g2(arrayList);
        if (UiThreadUtil.isOnUiThread()) {
            g2Var.run();
        } else {
            UiThreadUtil.runOnUiThread(g2Var);
        }
    }

    public void i(int i10) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f3777a.values());
        }
        h2 h2Var = new h2(arrayList, i10);
        if (UiThreadUtil.isOnUiThread()) {
            h2Var.run();
        } else {
            UiThreadUtil.runOnUiThread(h2Var);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        onTrimMemory(0);
    }

    public void onTrimMemory(int i10) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f3777a.values());
        }
        a aVar = new a(arrayList);
        if (UiThreadUtil.isOnUiThread()) {
            aVar.run();
        } else {
            UiThreadUtil.runOnUiThread(aVar);
        }
    }

    public i2(List list) {
        HashMap b10 = f.b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ViewManager viewManager = (ViewManager) it.next();
            b10.put(viewManager.getName(), viewManager);
        }
        this.f3777a = b10;
        this.f3778b = null;
    }
}
