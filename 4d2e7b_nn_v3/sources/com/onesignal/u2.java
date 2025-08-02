package com.onesignal;

import com.onesignal.a4;
import ma.e;

class u2 {

    /* renamed from: a  reason: collision with root package name */
    private a4.f f11075a = null;

    u2() {
    }

    private void p(boolean z10) {
        z3.j(z3.f11153a, "PREFS_OS_RECEIVE_RECEIPTS_ENABLED", z10);
    }

    private void r(boolean z10) {
        z3.j(z3.f11153a, "OS_RESTORE_TTL_FILTER", this.f11075a.f10371g);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f11075a = null;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return z3.b(z3.f11153a, "OS_CLEAR_GROUP_SUMMARY_CLICK", true);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return z3.b(z3.f11153a, "GT_FIREBASE_TRACKING_ENABLED", false);
    }

    /* access modifiers changed from: package-private */
    public a4.f d() {
        return this.f11075a;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return z3.b(z3.f11153a, "ONESIGNAL_USER_PROVIDED_CONSENT", false);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        a4.f fVar = this.f11075a;
        if (fVar == null || fVar.f10377m == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return z3.b(z3.f11153a, "PREFS_OS_DISABLE_GMS_MISSING_PROMPT", false);
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return z3.b(z3.f11153a, "PREFS_OS_LOCATION_SHARED", true);
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return z3.b(z3.f11153a, "PREFS_OS_REQUIRES_USER_PRIVACY_CONSENT", false);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return z3.b(z3.f11153a, "PREFS_OS_RECEIVE_RECEIPTS_ENABLED", false);
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        if (this.f11075a != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return z3.b(z3.f11153a, "OS_RESTORE_TTL_FILTER", true);
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z10) {
        z3.j(z3.f11153a, "PREFS_OS_DISABLE_GMS_MISSING_PROMPT", z10);
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z10) {
        z3.j(z3.f11153a, "PREFS_OS_LOCATION_SHARED", z10);
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10) {
        z3.j(z3.f11153a, "PREFS_OS_REQUIRES_USER_PRIVACY_CONSENT", z10);
    }

    /* access modifiers changed from: package-private */
    public void q(a4.f fVar, e eVar, y2 y2Var, c2 c2Var) {
        this.f11075a = fVar;
        String str = z3.f11153a;
        z3.j(str, "GT_FIREBASE_TRACKING_ENABLED", fVar.f10370f);
        r(fVar.f10371g);
        z3.j(str, "OS_CLEAR_GROUP_SUMMARY_CLICK", fVar.f10372h);
        z3.j(str, y2Var.h(), fVar.f10378n.f10364h);
        p(fVar.f10373i);
        c2Var.b("OneSignal saveInfluenceParams: " + fVar.f10378n.toString());
        eVar.j(fVar.f10378n);
        Boolean bool = fVar.f10374j;
        if (bool != null) {
            m(bool.booleanValue());
        }
        Boolean bool2 = fVar.f10375k;
        if (bool2 != null) {
            s(bool2.booleanValue());
        }
        Boolean bool3 = fVar.f10376l;
        if (bool3 != null) {
            o3.N1(bool3.booleanValue());
        }
        Boolean bool4 = fVar.f10377m;
        if (bool4 != null) {
            o(bool4.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        z3.j(z3.f11153a, "PREFS_OS_UNSUBSCRIBE_WHEN_NOTIFICATIONS_DISABLED", z10);
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return z3.b(z3.f11153a, "PREFS_OS_UNSUBSCRIBE_WHEN_NOTIFICATIONS_DISABLED", true);
    }
}
