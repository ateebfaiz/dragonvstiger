package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class a4 implements f4 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzkt f7391a;

    a4(zzkt zzkt) {
        this.f7391a = zzkt;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzkt zzkt = this.f7391a;
            if (zzkt.zzn != null) {
                zzkt.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.f7391a.zzaz().zzp(new z3(this, str, "_err", bundle));
    }
}
