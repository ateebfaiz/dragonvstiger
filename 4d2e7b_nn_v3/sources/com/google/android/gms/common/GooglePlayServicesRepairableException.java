package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(int i10, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.zza = i10;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
