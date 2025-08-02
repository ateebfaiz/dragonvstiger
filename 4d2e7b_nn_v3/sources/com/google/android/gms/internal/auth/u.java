package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

final class u extends ContentObserver {
    u(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z10) {
        zzcb.zzk.set(true);
    }
}
