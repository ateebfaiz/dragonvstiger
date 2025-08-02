package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class l extends o {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ m f7039h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(m mVar, zzx zzx, CharSequence charSequence) {
        super(zzx, charSequence);
        this.f7039h = mVar;
    }

    /* access modifiers changed from: package-private */
    public final int c(int i10) {
        return i10 + 1;
    }

    /* access modifiers changed from: package-private */
    public final int d(int i10) {
        zzo zzo = this.f7039h.f7040a;
        CharSequence charSequence = this.f7043c;
        int length = charSequence.length();
        zzs.zzb(i10, length, FirebaseAnalytics.Param.INDEX);
        while (i10 < length) {
            if (zzo.zza(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }
}
