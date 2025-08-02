package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity zza;
    private final int zzb;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int i10) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
        this.zzb = i10;
    }

    @KeepForSdk
    public final void onFailure(@NonNull Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.zza, this.zzb);
            } catch (IntentSender.SendIntentException e10) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e10);
                onUnresolvableFailure(new Status(8));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onSuccess(@NonNull R r10);

    public abstract void onUnresolvableFailure(@NonNull Status status);
}
