package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zaa = new x0();
    public static final /* synthetic */ int zad = 0;
    @KeepName
    private y0 mResultGuardian;
    @NonNull
    protected final CallbackHandler<R> zab;
    @NonNull
    protected final WeakReference<GoogleApiClient> zac;
    private final Object zae;
    private final CountDownLatch zaf;
    private final ArrayList<PendingResult.StatusListener> zag;
    @Nullable
    private ResultCallback<? super R> zah;
    private final AtomicReference<s0> zai;
    /* access modifiers changed from: private */
    @Nullable
    public R zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    @Nullable
    private ICancelToken zao;
    private volatile zada<R> zap;
    private boolean zaq;

    @Deprecated
    BasePendingResult() {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(Looper.getMainLooper());
        this.zac = new WeakReference<>((Object) null);
    }

    private final R zaa() {
        R r10;
        synchronized (this.zae) {
            Preconditions.checkState(!this.zal, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r10 = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        s0 andSet = this.zai.getAndSet((Object) null);
        if (andSet != null) {
            andSet.f6735a.zab.remove(this);
        }
        return (Result) Preconditions.checkNotNull(r10);
    }

    private final void zab(R r10) {
        this.zaj = r10;
        this.zak = r10.getStatus();
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            ResultCallback<? super R> resultCallback = this.zah;
            if (resultCallback != null) {
                this.zab.removeMessages(2);
                this.zab.zaa(resultCallback, zaa());
            } else if (this.zaj instanceof Releasable) {
                this.mResultGuardian = new y0(this, (zar) null);
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zag;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onComplete(this.zak);
        }
        this.zag.clear();
    }

    public static void zal(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e10) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e10);
            }
        }
    }

    public final void addStatusListener(@NonNull PendingResult.StatusListener statusListener) {
        boolean z10;
        if (statusListener != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    statusListener.onComplete(this.zak);
                } else {
                    this.zag.add(statusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean z10 = true;
        Preconditions.checkState(!this.zal, "Result has already been consumed");
        if (this.zap != null) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zaa();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|13|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0016 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zae
            monitor-enter(r0)
            boolean r1 = r2.zam     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0029
            boolean r1 = r2.zal     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0029
        L_0x000c:
            com.google.android.gms.common.internal.ICancelToken r1 = r2.zao     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0016
            r1.cancel()     // Catch:{ RemoteException -> 0x0016 }
            goto L_0x0016
        L_0x0014:
            r1 = move-exception
            goto L_0x002b
        L_0x0016:
            R r1 = r2.zaj     // Catch:{ all -> 0x0014 }
            zal(r1)     // Catch:{ all -> 0x0014 }
            r1 = 1
            r2.zam = r1     // Catch:{ all -> 0x0014 }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.RESULT_CANCELED     // Catch:{ all -> 0x0014 }
            com.google.android.gms.common.api.Result r1 = r2.createFailedResult(r1)     // Catch:{ all -> 0x0014 }
            r2.zab(r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract R createFailedResult(@NonNull Status status);

    @KeepForSdk
    @Deprecated
    public final void forceFailureUnlessReady(@NonNull Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z10;
        synchronized (this.zae) {
            z10 = this.zam;
        }
        return z10;
    }

    @KeepForSdk
    public final boolean isReady() {
        if (this.zaf.getCount() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void setCancelToken(@NonNull ICancelToken iCancelToken) {
        synchronized (this.zae) {
            this.zao = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(@NonNull R r10) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r10);
                    return;
                }
                isReady();
                Preconditions.checkState(!isReady(), "Results have already been set");
                Preconditions.checkState(!this.zal, "Result has already been consumed");
                zab(r10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(@androidx.annotation.Nullable com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000c
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r5 = move-exception
            goto L_0x003c
        L_0x000c:
            boolean r1 = r4.zal     // Catch:{ all -> 0x000a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r1, r3)     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.zada<R> r1 = r4.zap     // Catch:{ all -> 0x000a }
            if (r1 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r1)     // Catch:{ all -> 0x000a }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0028
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x0028:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r1 = r4.zab     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.Result r2 = r4.zaa()     // Catch:{ all -> 0x000a }
            r1.zaa(r5, r2)     // Catch:{ all -> 0x000a }
            goto L_0x003a
        L_0x0038:
            r4.zah = r5     // Catch:{ all -> 0x000a }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z10;
        TransformedResult<S> then;
        Preconditions.checkState(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                boolean z11 = false;
                if (this.zap == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10, "Cannot call then() twice.");
                if (this.zah == null) {
                    z11 = true;
                }
                Preconditions.checkState(z11, "Cannot call then() if callbacks are set.");
                Preconditions.checkState(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new zada<>(this.zac);
                then = this.zap.then(resultTransform);
                if (isReady()) {
                    this.zab.zaa(this.zap, zaa());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return then;
    }

    public final void zak() {
        boolean z10 = true;
        if (!this.zaq && !zaa.get().booleanValue()) {
            z10 = false;
        }
        this.zaq = z10;
    }

    public final boolean zam() {
        boolean isCanceled;
        synchronized (this.zae) {
            try {
                if (this.zac.get() != null) {
                    if (!this.zaq) {
                    }
                    isCanceled = isCanceled();
                }
                cancel();
                isCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return isCanceled;
    }

    public final void zan(@Nullable s0 s0Var) {
        this.zai.set(s0Var);
    }

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zaq {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e10) {
                    BasePendingResult.zal(result);
                    throw e10;
                }
            } else if (i10 != 2) {
                StringBuilder sb2 = new StringBuilder(45);
                sb2.append("Don't know how to handle message: ");
                sb2.append(i10);
                Log.wtf("BasePendingResult", sb2.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        }

        public final void zaa(@NonNull ResultCallback<? super R> resultCallback, @NonNull R r10) {
            int i10 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.checkNotNull(resultCallback), r10)));
        }

        public CallbackHandler(@NonNull Looper looper) {
            super(looper);
        }
    }

    @KeepForSdk
    @Deprecated
    protected BasePendingResult(@NonNull Looper looper) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(looper);
        this.zac = new WeakReference<>((Object) null);
    }

    @NonNull
    public final R await(long j10, @NonNull TimeUnit timeUnit) {
        if (j10 > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z10 = true;
        Preconditions.checkState(!this.zal, "Result has already been consumed.");
        if (this.zap != null) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j10, timeUnit)) {
                forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zaa();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(@androidx.annotation.NonNull com.google.android.gms.common.api.ResultCallback<? super R> r5, long r6, @androidx.annotation.NonNull java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000c
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r5 = move-exception
            goto L_0x004a
        L_0x000c:
            boolean r1 = r4.zal     // Catch:{ all -> 0x000a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r1, r3)     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.zada<R> r1 = r4.zap     // Catch:{ all -> 0x000a }
            if (r1 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r1)     // Catch:{ all -> 0x000a }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0028
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x0028:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r6 = r4.zab     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.Result r7 = r4.zaa()     // Catch:{ all -> 0x000a }
            r6.zaa(r5, r7)     // Catch:{ all -> 0x000a }
            goto L_0x0048
        L_0x0038:
            r4.zah = r5     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r5 = r4.zab     // Catch:{ all -> 0x000a }
            long r6 = r8.toMillis(r6)     // Catch:{ all -> 0x000a }
            r8 = 2
            android.os.Message r8 = r5.obtainMessage(r8, r4)     // Catch:{ all -> 0x000a }
            r5.sendMessageDelayed(r8, r6)     // Catch:{ all -> 0x000a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    @KeepForSdk
    protected BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zac = new WeakReference<>(googleApiClient);
    }

    @KeepForSdk
    @VisibleForTesting
    protected BasePendingResult(@NonNull CallbackHandler<R> callbackHandler) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zac = new WeakReference<>((Object) null);
    }
}
