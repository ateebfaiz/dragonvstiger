package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h0 {

    /* renamed from: b  reason: collision with root package name */
    private static final a f3111b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f3112a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final void c(h0 h0Var) {
        m.f(h0Var, "this$0");
        h0Var.f3112a = false;
    }

    public final boolean b(int i10, View view) {
        if (i10 == 46 && !(view instanceof EditText)) {
            if (this.f3112a) {
                this.f3112a = false;
                return true;
            }
            this.f3112a = true;
            new Handler(Looper.getMainLooper()).postDelayed(new g0(this), 200);
        }
        return false;
    }
}
