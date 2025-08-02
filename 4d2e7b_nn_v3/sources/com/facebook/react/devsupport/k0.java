package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.facebook.react.q;
import kotlin.jvm.internal.m;

public final class k0 extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(Activity activity, View view) {
        super(activity, q.f20906a);
        m.f(activity, "context");
        requestWindowFeature(1);
        if (view != null) {
            setContentView(view);
        }
    }
}
