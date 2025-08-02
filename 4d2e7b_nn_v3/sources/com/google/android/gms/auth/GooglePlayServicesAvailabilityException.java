package com.google.android.gms.auth;

import android.content.Intent;
import androidx.annotation.Nullable;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zza;

    GooglePlayServicesAvailabilityException(int i10, @Nullable String str, @Nullable Intent intent) {
        super(str, intent);
        this.zza = i10;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
