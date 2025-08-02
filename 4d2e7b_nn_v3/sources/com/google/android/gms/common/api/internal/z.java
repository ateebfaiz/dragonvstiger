package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class z implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f6756a;

    z(GoogleApiManager googleApiManager) {
        this.f6756a = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z10) {
        GoogleApiManager googleApiManager = this.f6756a;
        googleApiManager.zat.sendMessage(googleApiManager.zat.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
