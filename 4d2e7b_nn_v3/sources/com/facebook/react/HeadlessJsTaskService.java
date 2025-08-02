package com.facebook.react;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import r6.c;
import r6.d;

public abstract class HeadlessJsTaskService extends Service implements d {

    /* renamed from: b  reason: collision with root package name */
    private static PowerManager.WakeLock f20713b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Set f20714a = new CopyOnWriteArraySet();

    class a implements y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r6.a f20715a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g0 f20716b;

        a(r6.a aVar, g0 g0Var) {
            this.f20715a = aVar;
            this.f20716b = g0Var;
        }

        public void a(ReactContext reactContext) {
            HeadlessJsTaskService.this.h(reactContext, this.f20715a);
            this.f20716b.n0(this);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20718a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r6.a f20719b;

        b(c cVar, r6.a aVar) {
            this.f20718a = cVar;
            this.f20719b = aVar;
        }

        public void run() {
            HeadlessJsTaskService.this.f20714a.add(Integer.valueOf(this.f20718a.m(this.f20719b)));
        }
    }

    public static void e(Context context) {
        PowerManager.WakeLock wakeLock = f20713b;
        if (wakeLock == null || !wakeLock.isHeld()) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) p5.a.c((PowerManager) context.getSystemService("power"))).newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
            f20713b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            f20713b.acquire();
        }
    }

    /* access modifiers changed from: private */
    public void h(ReactContext reactContext, r6.a aVar) {
        c e10 = c.e(reactContext);
        e10.c(this);
        UiThreadUtil.runOnUiThread(new b(e10, aVar));
    }

    public void a(int i10) {
        this.f20714a.remove(Integer.valueOf(i10));
        if (this.f20714a.size() == 0) {
            stopSelf();
        }
    }

    public void b(int i10) {
    }

    /* access modifiers changed from: protected */
    public k0 f() {
        return ((u) getApplication()).getReactNativeHost();
    }

    /* access modifiers changed from: protected */
    public r6.a g(Intent intent) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void i(r6.a aVar) {
        UiThreadUtil.assertOnUiThread();
        e(this);
        g0 p10 = f().p();
        ReactContext C = p10.C();
        if (C == null) {
            p10.q(new a(aVar, p10));
            p10.x();
            return;
        }
        h(C, aVar);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        ReactContext C;
        super.onDestroy();
        if (f().w() && (C = f().p().C()) != null) {
            c.e(C).i(this);
        }
        PowerManager.WakeLock wakeLock = f20713b;
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        r6.a g10 = g(intent);
        if (g10 == null) {
            return 2;
        }
        i(g10);
        return 3;
    }
}
