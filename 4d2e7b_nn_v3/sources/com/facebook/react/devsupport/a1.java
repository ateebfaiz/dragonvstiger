package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.react.q;
import e6.i;
import k6.e;

class a1 implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h0 f3037a = new h0();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f3038b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f3039c;

    /* renamed from: d  reason: collision with root package name */
    private RedBoxContentView f3040d;

    class a extends Dialog {
        a(Context context, int i10) {
            super(context, i10);
        }

        public boolean onKeyUp(int i10, KeyEvent keyEvent) {
            if (i10 == 82) {
                a1.this.f3038b.B();
                return true;
            }
            if (a1.this.f3037a.b(i10, getCurrentFocus())) {
                a1.this.f3038b.r();
            }
            return super.onKeyUp(i10, keyEvent);
        }
    }

    public a1(e eVar) {
        this.f3038b = eVar;
    }

    public void a() {
        Dialog dialog = this.f3039c;
        if (dialog != null) {
            dialog.dismiss();
            c();
            this.f3039c = null;
        }
    }

    public boolean b() {
        if (this.f3040d != null) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f3040d = null;
    }

    public void d(String str) {
        this.f3038b.x();
        Activity j10 = this.f3038b.j();
        if (j10 == null || j10.isFinishing()) {
            String l10 = this.f3038b.l();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
            if (l10 == null) {
                l10 = "N/A";
            }
            sb2.append(l10);
            z2.a.j("ReactNative", sb2.toString());
            return;
        }
        RedBoxContentView redBoxContentView = new RedBoxContentView(j10);
        this.f3040d = redBoxContentView;
        redBoxContentView.e(this.f3038b).g((k6.i) null).c();
    }

    public boolean isShowing() {
        Dialog dialog = this.f3039c;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        return true;
    }

    public void show() {
        String l10 = this.f3038b.l();
        Activity j10 = this.f3038b.j();
        if (j10 == null || j10.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
            if (l10 == null) {
                l10 = "N/A";
            }
            sb2.append(l10);
            z2.a.j("ReactNative", sb2.toString());
            return;
        }
        RedBoxContentView redBoxContentView = this.f3040d;
        if (redBoxContentView == null || redBoxContentView.getContext() != j10) {
            d(NativeRedBoxSpec.NAME);
        }
        this.f3040d.d();
        if (this.f3039c == null) {
            a aVar = new a(j10, q.f20907b);
            this.f3039c = aVar;
            aVar.requestWindowFeature(1);
            this.f3039c.setContentView(this.f3040d);
        }
        this.f3039c.show();
    }
}
