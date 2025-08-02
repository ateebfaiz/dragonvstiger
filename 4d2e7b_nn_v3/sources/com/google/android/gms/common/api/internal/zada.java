package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    @Nullable
    public ResultTransform<? super R, ? extends Result> zaa = null;
    /* access modifiers changed from: private */
    @Nullable
    public zada<? extends Result> zab = null;
    @Nullable
    private volatile ResultCallbacks<? super R> zac = null;
    @Nullable
    private PendingResult<R> zad = null;
    /* access modifiers changed from: private */
    public final Object zae = new Object();
    @Nullable
    private Status zaf = null;
    /* access modifiers changed from: private */
    public final WeakReference<GoogleApiClient> zag;
    /* access modifiers changed from: private */
    public final q0 zah;
    private boolean zai = false;

    public zada(WeakReference<GoogleApiClient> weakReference) {
        Looper looper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        if (googleApiClient != null) {
            looper = googleApiClient.getLooper();
        } else {
            looper = Looper.getMainLooper();
        }
        this.zah = new q0(this, looper);
    }

    /* access modifiers changed from: private */
    public final void zaj(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    private final void zak() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = this.zag.get();
            if (!(this.zai || this.zaa == null || googleApiClient == null)) {
                googleApiClient.zao(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zal(status);
                return;
            }
            PendingResult<R> pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    private final void zal(Status status) {
        synchronized (this.zae) {
            try {
                ResultTransform<? super R, ? extends Result> resultTransform = this.zaa;
                if (resultTransform != null) {
                    ((zada) Preconditions.checkNotNull(this.zab)).zaj((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
                } else if (zam()) {
                    ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean zam() {
        GoogleApiClient googleApiClient = this.zag.get();
        if (this.zac == null || googleApiClient == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e10) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e10);
            }
        }
    }

    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z10;
        synchronized (this.zae) {
            boolean z11 = false;
            if (this.zac == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Cannot call andFinally() twice.");
            if (this.zaa == null) {
                z11 = true;
            }
            Preconditions.checkState(z11, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zak();
        }
    }

    public final void onResult(R r10) {
        synchronized (this.zae) {
            try {
                if (!r10.getStatus().isSuccess()) {
                    zaj(r10.getStatus());
                    zan(r10);
                } else if (this.zaa != null) {
                    zaco.zaa().submit(new p0(this, r10));
                } else if (zam()) {
                    ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(r10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z10;
        zada<? extends Result> zada;
        synchronized (this.zae) {
            boolean z11 = false;
            if (this.zaa == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Cannot call then() twice.");
            if (this.zac == null) {
                z11 = true;
            }
            Preconditions.checkState(z11, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zada = new zada<>(this.zag);
            this.zab = zada;
            zak();
        }
        return zada;
    }

    /* access modifiers changed from: package-private */
    public final void zah() {
        this.zac = null;
    }

    public final void zai(PendingResult<?> pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zak();
        }
    }
}
