package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i10) {
        return this.zaa.get(i10, -1);
    }

    public final int zab(@NonNull Context context, @NonNull Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i10 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa2 = zaa(context, minApkVersion);
        if (zaa2 == -1) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.zaa.size()) {
                    i10 = -1;
                    break;
                }
                int keyAt = this.zaa.keyAt(i11);
                if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                    break;
                }
                i11++;
            }
            if (i10 == -1) {
                zaa2 = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
            } else {
                zaa2 = i10;
            }
            this.zaa.put(minApkVersion, zaa2);
        }
        return zaa2;
    }

    public final void zac() {
        this.zaa.clear();
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
