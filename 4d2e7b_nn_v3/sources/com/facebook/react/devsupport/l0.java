package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import e6.i;
import k6.e;
import kotlin.jvm.internal.m;
import o7.c;
import p5.a;

public final class l0 implements i {

    /* renamed from: a  reason: collision with root package name */
    private final e f3134a;

    /* renamed from: b  reason: collision with root package name */
    private View f3135b;

    /* renamed from: c  reason: collision with root package name */
    private k0 f3136c;

    public l0(e eVar) {
        m.f(eVar, "devSupportManager");
        this.f3134a = eVar;
    }

    public void a() {
        ViewParent viewParent;
        if (isShowing()) {
            View view = this.f3135b;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent;
            if (viewGroup != null) {
                viewGroup.removeView(this.f3135b);
            }
            k0 k0Var = this.f3136c;
            if (k0Var != null) {
                k0Var.dismiss();
            }
            this.f3136c = null;
        }
    }

    public boolean b() {
        if (this.f3135b != null) {
            return true;
        }
        return false;
    }

    public void c() {
        View view = this.f3135b;
        if (view != null) {
            this.f3134a.d(view);
            this.f3135b = null;
        }
    }

    public void d(String str) {
        m.f(str, "appKey");
        a.b(m.b(str, "LogBox"), "This surface manager can only create LogBox React application");
        View a10 = this.f3134a.a("LogBox");
        this.f3135b = a10;
        if (a10 == null) {
            c.a("Unable to launch logbox because react was unable to create the root view");
        }
    }

    public boolean isShowing() {
        k0 k0Var = this.f3136c;
        if (k0Var != null) {
            return k0Var.isShowing();
        }
        return false;
    }

    public void show() {
        if (!isShowing() && b()) {
            Activity j10 = this.f3134a.j();
            if (j10 == null || j10.isFinishing()) {
                c.a("Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
                return;
            }
            k0 k0Var = new k0(j10, this.f3135b);
            this.f3136c = k0Var;
            k0Var.setCancelable(false);
            k0Var.show();
        }
    }
}
