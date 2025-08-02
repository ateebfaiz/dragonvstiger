package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class zak extends zap {
    private final SparseArray<t0> zad = new SparseArray<>();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zak = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zak != null) {
            return zak;
        }
        return new zak(fragment);
    }

    @Nullable
    private final t0 zai(int i10) {
        if (this.zad.size() <= i10) {
            return null;
        }
        SparseArray<t0> sparseArray = this.zad;
        return sparseArray.get(sparseArray.keyAt(i10));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i10 = 0; i10 < this.zad.size(); i10++) {
            t0 zai = zai(i10);
            if (zai != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zai.f6737a);
                printWriter.println(":");
                zai.f6738b.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z10 = this.zaa;
        String valueOf = String.valueOf(this.zad);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
        sb2.append("onStart ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        if (this.zab.get() == null) {
            for (int i10 = 0; i10 < this.zad.size(); i10++) {
                t0 zai = zai(i10);
                if (zai != null) {
                    zai.f6738b.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i10 = 0; i10 < this.zad.size(); i10++) {
            t0 zai = zai(i10);
            if (zai != null) {
                zai.f6738b.disconnect();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zab(ConnectionResult connectionResult, int i10) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i10 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        t0 t0Var = this.zad.get(i10);
        if (t0Var != null) {
            zae(i10);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = t0Var.f6739e;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zac() {
        for (int i10 = 0; i10 < this.zad.size(); i10++) {
            t0 zai = zai(i10);
            if (zai != null) {
                zai.f6738b.connect();
            }
        }
    }

    public final void zad(int i10, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z10;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        if (this.zad.indexOfKey(i10) < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Already managing a GoogleApiClient with id ");
        sb2.append(i10);
        Preconditions.checkState(z10, sb2.toString());
        u0 u0Var = this.zab.get();
        boolean z11 = this.zaa;
        String valueOf = String.valueOf(u0Var);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 49);
        sb3.append("starting AutoManage for client ");
        sb3.append(i10);
        sb3.append(" ");
        sb3.append(z11);
        sb3.append(" ");
        sb3.append(valueOf);
        Log.d("AutoManageHelper", sb3.toString());
        t0 t0Var = new t0(this, i10, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(t0Var);
        this.zad.put(i10, t0Var);
        if (this.zaa && u0Var == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.connect();
        }
    }

    public final void zae(int i10) {
        t0 t0Var = this.zad.get(i10);
        this.zad.remove(i10);
        if (t0Var != null) {
            t0Var.f6738b.unregisterConnectionFailedListener(t0Var);
            t0Var.f6738b.disconnect();
        }
    }
}
