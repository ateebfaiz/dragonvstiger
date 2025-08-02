package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.l;
import com.facebook.react.m;
import com.facebook.react.o;
import k6.e;
import k6.h;
import p5.a;

class v0 implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Supplier f3172a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f3173b;

    public v0(Supplier supplier) {
        this.f3172a = supplier;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        Dialog dialog = this.f3173b;
        if (dialog != null) {
            dialog.dismiss();
            this.f3173b = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(String str, e.a aVar) {
        Dialog dialog = this.f3173b;
        if (dialog != null) {
            dialog.dismiss();
        }
        Context context = (Context) this.f3172a.get();
        if (context != null) {
            View inflate = LayoutInflater.from(context).inflate(o.f20874c, (ViewGroup) null);
            Dialog dialog2 = new Dialog(context);
            this.f3173b = dialog2;
            dialog2.setContentView(inflate);
            this.f3173b.setCancelable(false);
            ((TextView) a.c((TextView) inflate.findViewById(m.f20858o))).setText(str);
            ((View) a.c(inflate.findViewById(m.f20861r))).setOnClickListener(new u0(aVar));
            Window window = this.f3173b.getWindow();
            if (window != null) {
                window.setGravity(48);
                window.setBackgroundDrawableResource(l.f20843a);
            }
            this.f3173b.show();
        }
    }

    public void g() {
        UiThreadUtil.runOnUiThread(new t0(this));
    }

    public void i(String str, e.a aVar) {
        UiThreadUtil.runOnUiThread(new s0(this, str, aVar));
    }
}
