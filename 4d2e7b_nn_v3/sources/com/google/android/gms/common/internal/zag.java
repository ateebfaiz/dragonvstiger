package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, @Nullable Intent intent, int i10) {
        return new a(intent, activity, i10);
    }

    public static zag zac(@NonNull Fragment fragment, @Nullable Intent intent, int i10) {
        return new b(intent, fragment, i10);
    }

    public static zag zad(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i10) {
        return new c(intent, lifecycleFragment, 2);
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            zaa();
        } catch (ActivityNotFoundException e10) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains("generic")) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e10);
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();
}
