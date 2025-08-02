package com.facebook.react.devsupport;

import android.content.DialogInterface;
import k6.d;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f3113a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d[] f3114b;

    public /* synthetic */ i(a0 a0Var, d[] dVarArr) {
        this.f3113a = a0Var;
        this.f3114b = dVarArr;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f3113a.E0(this.f3114b, dialogInterface, i10);
    }
}
