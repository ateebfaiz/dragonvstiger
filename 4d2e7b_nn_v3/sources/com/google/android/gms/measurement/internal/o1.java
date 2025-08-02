package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class o1 implements f4 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhx f7654a;

    o1(zzhx zzhx) {
        this.f7654a = zzhx;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f7654a.zzF("auto", "_err", bundle, str);
        } else {
            this.f7654a.zzD("auto", "_err", bundle);
        }
    }
}
