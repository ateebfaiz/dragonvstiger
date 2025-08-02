package com.facebook.react.runtime;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.SurfaceHandlerBinding;
import com.facebook.react.uimanager.events.e;
import e7.f;
import java.util.concurrent.atomic.AtomicReference;
import m6.a;
import m6.b;

public class d1 implements a {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f3452a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f3453b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3454c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3455d;

    public d1(Context context, String str, Bundle bundle) {
        this(new SurfaceHandlerBinding(str), context);
        NativeMap nativeMap;
        if (bundle == null) {
            nativeMap = new WritableNativeMap();
        } else {
            nativeMap = (NativeMap) Arguments.fromBundle(bundle);
        }
        this.f3454c.setProps(nativeMap);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f3454c.setLayoutConstraints(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE), 0, 0, f(context), o(context), j(context));
    }

    public static d1 e(Context context, String str, Bundle bundle) {
        d1 d1Var = new d1(context, str, bundle);
        d1Var.c(new ReactSurfaceView(context, d1Var));
        return d1Var;
    }

    private static boolean f(Context context) {
        return com.facebook.react.modules.i18nmanager.a.f().d(context);
    }

    private static float j(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static boolean o(Context context) {
        return com.facebook.react.modules.i18nmanager.a.f().i(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        ReactSurfaceView reactSurfaceView = (ReactSurfaceView) getView();
        if (reactSurfaceView != null) {
            reactSurfaceView.removeAllViews();
            reactSurfaceView.setId(-1);
        }
    }

    public void b(ReactHostImpl reactHostImpl) {
        if (!d.a.a(this.f3453b, (Object) null, reactHostImpl)) {
            throw new IllegalStateException("This surface is already attached to a host!");
        }
    }

    public void c(ReactSurfaceView reactSurfaceView) {
        if (d.a.a(this.f3452a, (Object) null, reactSurfaceView)) {
            this.f3455d = reactSurfaceView.getContext();
            return;
        }
        throw new IllegalStateException("Trying to call ReactSurface.attachView(), but the view is already attached.");
    }

    public void d() {
        UiThreadUtil.runOnUiThread(new c1(this));
    }

    public Context g() {
        return this.f3455d;
    }

    public ViewGroup getView() {
        return (ViewGroup) this.f3452a.get();
    }

    /* access modifiers changed from: package-private */
    public e h() {
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f3453b.get();
        if (reactHostImpl == null) {
            return null;
        }
        return reactHostImpl.k0();
    }

    public String i() {
        return this.f3454c.getModuleName();
    }

    /* access modifiers changed from: package-private */
    public ReactHostImpl k() {
        return (ReactHostImpl) this.f3453b.get();
    }

    /* access modifiers changed from: package-private */
    public b l() {
        return this.f3454c;
    }

    public int m() {
        return this.f3454c.getSurfaceId();
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        if (this.f3453b.get() != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.f3454c.isRunning();
    }

    /* access modifiers changed from: package-private */
    public synchronized void r(int i10, int i11, int i12, int i13) {
        this.f3454c.setLayoutConstraints(i10, i11, i12, i13, f(this.f3455d), o(this.f3455d), j(this.f3455d));
    }

    public l6.a start() {
        if (this.f3452a.get() == null) {
            return f.l(new IllegalStateException("Trying to call ReactSurface.start(), but view is not created."));
        }
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f3453b.get();
        if (reactHostImpl == null) {
            return f.l(new IllegalStateException("Trying to call ReactSurface.start(), but no ReactHost is attached."));
        }
        return reactHostImpl.D1(this);
    }

    public l6.a stop() {
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f3453b.get();
        if (reactHostImpl == null) {
            return f.l(new IllegalStateException("Trying to call ReactSurface.stop(), but no ReactHost is attached."));
        }
        return reactHostImpl.F1(this);
    }

    d1(b bVar, Context context) {
        this.f3452a = new AtomicReference((Object) null);
        this.f3453b = new AtomicReference((Object) null);
        this.f3454c = bVar;
        this.f3455d = context;
    }
}
