package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6849a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f6850b;

    e(Context context, Intent intent) {
        this.f6849a = context;
        this.f6850b = intent;
    }

    public final void onClick(View view) {
        try {
            this.f6849a.startActivity(this.f6850b);
        } catch (ActivityNotFoundException e10) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e10);
        }
    }
}
