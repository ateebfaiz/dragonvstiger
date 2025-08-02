package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zaae extends zap {
    private final ArraySet<ApiKey<?>> zad = new ArraySet<>();
    private final GoogleApiManager zae;

    @VisibleForTesting
    zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    @MainThread
    public static void zad(Activity activity, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaae = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaae == null) {
            zaae = new zaae(fragment, googleApiManager, GoogleApiAvailability.getInstance());
        }
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zaae.zad.add(apiKey);
        googleApiManager.zaC(zaae);
    }

    private final void zae() {
        if (!this.zad.isEmpty()) {
            this.zae.zaC(this);
        }
    }

    public final void onResume() {
        super.onResume();
        zae();
    }

    public final void onStart() {
        super.onStart();
        zae();
    }

    public final void onStop() {
        super.onStop();
        this.zae.zaD(this);
    }

    /* access modifiers changed from: package-private */
    public final ArraySet<ApiKey<?>> zaa() {
        return this.zad;
    }

    /* access modifiers changed from: protected */
    public final void zab(ConnectionResult connectionResult, int i10) {
        this.zae.zaz(connectionResult, i10);
    }

    /* access modifiers changed from: protected */
    public final void zac() {
        this.zae.zaA();
    }
}
