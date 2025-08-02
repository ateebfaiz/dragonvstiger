package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.b1;
import com.facebook.react.devsupport.h0;
import k6.e;
import m6.a;
import w6.b;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f20927a;

    /* renamed from: b  reason: collision with root package name */
    private ReactRootView f20928b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20929c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f20930d;

    /* renamed from: e  reason: collision with root package name */
    private h0 f20931e = new h0();

    /* renamed from: f  reason: collision with root package name */
    private k0 f20932f;

    /* renamed from: g  reason: collision with root package name */
    private x f20933g;

    /* renamed from: h  reason: collision with root package name */
    private a f20934h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20935i;

    public w(Activity activity, k0 k0Var, String str, Bundle bundle, boolean z10) {
        boolean z11 = ReactFeatureFlags.useTurboModules;
        this.f20935i = z10;
        this.f20927a = activity;
        this.f20929c = str;
        this.f20930d = bundle;
        this.f20932f = k0Var;
    }

    private e c() {
        x xVar;
        if (ReactFeatureFlags.enableBridgelessArchitecture && (xVar = this.f20933g) != null && xVar.h() != null) {
            return this.f20933g.h();
        }
        if (!e().w() || e().p() == null) {
            return null;
        }
        return e().p().D();
    }

    private k0 e() {
        return this.f20932f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (this.f20932f.w() && this.f20932f.p() != null) {
            this.f20932f.p().i0();
        }
    }

    /* access modifiers changed from: protected */
    public ReactRootView b() {
        ReactRootView reactRootView = new ReactRootView(this.f20927a);
        reactRootView.setIsFabric(g());
        return reactRootView;
    }

    public g0 d() {
        return e().p();
    }

    public ReactRootView f() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            return (ReactRootView) this.f20934h.getView();
        }
        return this.f20928b;
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return this.f20935i;
    }

    public void i() {
        j(this.f20929c);
    }

    public void j(String str) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            if (this.f20934h == null) {
                a c10 = this.f20933g.c(this.f20927a, str, this.f20930d);
                this.f20934h = c10;
                this.f20927a.setContentView(c10.getView());
            }
            this.f20934h.start();
        } else if (this.f20928b == null) {
            ReactRootView b10 = b();
            this.f20928b = b10;
            b10.t(e().p(), str, this.f20930d);
        } else {
            throw new IllegalStateException("Cannot loadApp while app is already running.");
        }
    }

    public void k(int i10, int i11, Intent intent, boolean z10) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.f20933g.onActivityResult(this.f20927a, i10, i11, intent);
        } else if (e().w() && z10) {
            e().p().W(this.f20927a, i10, i11, intent);
        }
    }

    public boolean l() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.f20933g.b();
            return true;
        } else if (!e().w()) {
            return false;
        } else {
            e().p().X();
            return true;
        }
    }

    public void m() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            a aVar = this.f20934h;
            if (aVar != null) {
                aVar.stop();
                this.f20934h = null;
            }
            this.f20933g.f(this.f20927a);
            return;
        }
        ReactRootView reactRootView = this.f20928b;
        if (reactRootView != null) {
            reactRootView.u();
            this.f20928b = null;
        }
        if (e().w()) {
            e().p().Z(this.f20927a);
        }
    }

    public void n() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.f20933g.e(this.f20927a);
        } else if (e().w()) {
            e().p().b0(this.f20927a);
        }
    }

    public void o() {
        Activity activity = this.f20927a;
        if (!(activity instanceof b)) {
            throw new ClassCastException("Host Activity does not implement DefaultHardwareBackBtnHandler");
        } else if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.f20933g.d(activity, (b) activity);
        } else if (e().w()) {
            g0 p10 = e().p();
            Activity activity2 = this.f20927a;
            p10.d0(activity2, (b) activity2);
        }
    }

    public void p(boolean z10) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.f20933g.onWindowFocusChange(z10);
        } else if (e().w()) {
            e().p().f0(z10);
        }
    }

    public void q() {
        e c10 = c();
        if (c10 != null) {
            if (!(c10 instanceof b1)) {
                c10.r();
            } else if (ReactFeatureFlags.enableBridgelessArchitecture) {
                x xVar = this.f20933g;
                if (xVar != null) {
                    xVar.g("ReactDelegate.reload()");
                }
            } else {
                UiThreadUtil.runOnUiThread(new v(this));
            }
        }
    }

    public boolean r(int i10, KeyEvent keyEvent) {
        e c10 = c();
        if (c10 != null && !(c10 instanceof b1)) {
            if (i10 == 82) {
                c10.B();
                return true;
            } else if (((h0) p5.a.c(this.f20931e)).b(i10, this.f20927a.getCurrentFocus())) {
                c10.r();
                return true;
            }
        }
        return false;
    }
}
