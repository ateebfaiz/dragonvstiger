package com.onesignal;

import android.content.Context;
import com.onesignal.o3;
import org.json.JSONObject;

public class f2 {

    /* renamed from: a  reason: collision with root package name */
    private final i2 f10635a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10636b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10637c;

    f2(i2 i2Var, boolean z10, boolean z11) {
        this.f10636b = z10;
        this.f10637c = z11;
        this.f10635a = i2Var;
    }

    private i2 a(Context context, d2 d2Var, JSONObject jSONObject, Long l10) {
        i2 i2Var = new i2(context);
        i2Var.q(jSONObject);
        i2Var.z(l10);
        i2Var.y(this.f10636b);
        i2Var.r(d2Var);
        return i2Var;
    }

    private void e(d2 d2Var) {
        this.f10635a.r(d2Var);
        if (this.f10636b) {
            l0.e(this.f10635a);
            return;
        }
        this.f10635a.p(false);
        l0.n(this.f10635a, true, false);
        o3.F0(this.f10635a);
    }

    static void h(Context context) {
        String f10 = OSUtils.f(context, "com.onesignal.NotificationServiceExtension");
        if (f10 == null) {
            o3.d1(o3.v.VERBOSE, "No class found, not setting up OSRemoteNotificationReceivedHandler");
            return;
        }
        o3.v vVar = o3.v.VERBOSE;
        o3.d1(vVar, "Found class: " + f10 + ", attempting to call constructor");
        try {
            Class.forName(f10).newInstance();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        } catch (ClassNotFoundException e12) {
            e12.printStackTrace();
        }
    }

    public i2 b() {
        return this.f10635a;
    }

    public n2 c() {
        return new n2(this, this.f10635a.f());
    }

    public boolean d() {
        if (!o3.k0().l()) {
            return true;
        }
        if (this.f10635a.f().h() + ((long) this.f10635a.f().l()) > o3.w0().b() / 1000) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(d2 d2Var, d2 d2Var2) {
        if (d2Var2 != null) {
            boolean I = OSUtils.I(d2Var2.e());
            boolean d10 = d();
            if (!I || !d10) {
                e(d2Var);
            } else {
                this.f10635a.r(d2Var2);
                l0.k(this, this.f10637c);
            }
            if (this.f10636b) {
                OSUtils.V(100);
                return;
            }
            return;
        }
        e(d2Var);
    }

    public void g(boolean z10) {
        this.f10637c = z10;
    }

    public String toString() {
        return "OSNotificationController{notificationJob=" + this.f10635a + ", isRestoring=" + this.f10636b + ", isBackgroundLogic=" + this.f10637c + '}';
    }

    f2(Context context, d2 d2Var, JSONObject jSONObject, boolean z10, boolean z11, Long l10) {
        this.f10636b = z10;
        this.f10637c = z11;
        this.f10635a = a(context, d2Var, jSONObject, l10);
    }
}
