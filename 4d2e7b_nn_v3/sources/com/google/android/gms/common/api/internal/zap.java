package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zaq;
import d.a;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference<u0> zab = new AtomicReference<>((Object) null);
    protected final GoogleApiAvailability zac;
    private final Handler zad = new zaq(Looper.getMainLooper());

    @VisibleForTesting
    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zac = googleApiAvailability;
    }

    /* access modifiers changed from: private */
    public final void zaa(ConnectionResult connectionResult, int i10) {
        this.zab.set((Object) null);
        zab(connectionResult, i10);
    }

    /* access modifiers changed from: private */
    public final void zad() {
        this.zab.set((Object) null);
        zac();
    }

    private static final int zae(@Nullable u0 u0Var) {
        if (u0Var == null) {
            return -1;
        }
        return u0Var.a();
    }

    public final void onActivityResult(int i10, int i11, Intent intent) {
        u0 u0Var = this.zab.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    zad();
                    return;
                } else if (u0Var != null) {
                    if (u0Var.b().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i11 == -1) {
            zad();
            return;
        } else if (i11 == 0) {
            if (u0Var != null) {
                int i12 = 13;
                if (intent != null) {
                    i12 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                zaa(new ConnectionResult(i12, (PendingIntent) null, u0Var.b().toString()), zae(u0Var));
                return;
            }
            return;
        }
        if (u0Var != null) {
            zaa(u0Var.b(), u0Var.a());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, (PendingIntent) null), zae(this.zab.get()));
    }

    public final void onCreate(@Nullable Bundle bundle) {
        u0 u0Var;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference<u0> atomicReference = this.zab;
            if (bundle.getBoolean("resolving_error", false)) {
                u0Var = new u0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                u0Var = null;
            }
            atomicReference.set(u0Var);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        u0 u0Var = this.zab.get();
        if (u0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", u0Var.a());
            bundle.putInt("failed_status", u0Var.b().getErrorCode());
            bundle.putParcelable("failed_resolution", u0Var.b().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zab(ConnectionResult connectionResult, int i10);

    /* access modifiers changed from: protected */
    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i10) {
        u0 u0Var = new u0(connectionResult, i10);
        if (a.a(this.zab, (Object) null, u0Var)) {
            this.zad.post(new w0(this, u0Var));
        }
    }
}
