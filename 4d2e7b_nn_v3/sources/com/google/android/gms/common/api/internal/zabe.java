package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.work.WorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zabe extends GoogleApiClient implements zabz {
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa = new LinkedList();
    @Nullable
    @VisibleForTesting
    zabx zab;
    final Map<Api.AnyClientKey<?>, Api.Client> zac;
    Set<Scope> zad;
    final ClientSettings zae;
    final Map<Api<?>, Boolean> zaf;
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> zag;
    @Nullable
    Set<zada> zah;
    final zadc zai;
    private final Lock zaj;
    private final zak zak;
    @Nullable
    private zaca zal = null;
    private final int zam;
    /* access modifiers changed from: private */
    public final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final v zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList<zat> zav;
    private Integer zaw;
    private final zaj zax;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i10, int i11, ArrayList<zat> arrayList) {
        long j10;
        Looper looper2 = looper;
        int i12 = i10;
        if (true != ClientLibraryUtils.isPackageSide()) {
            j10 = 120000;
        } else {
            j10 = WorkRequest.MIN_BACKOFF_MILLIS;
        }
        this.zaq = j10;
        this.zar = 5000;
        this.zad = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        r rVar = new r(this);
        this.zax = rVar;
        this.zan = context;
        this.zaj = lock;
        this.zak = new zak(looper, rVar);
        this.zao = looper2;
        this.zas = new v(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i12;
        if (i12 >= 0) {
            this.zaw = Integer.valueOf(i11);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        for (GoogleApiClient.ConnectionCallbacks zaf2 : list) {
            this.zak.zaf(zaf2);
        }
        for (GoogleApiClient.OnConnectionFailedListener zag2 : list2) {
            this.zak.zag(zag2);
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable<Api.Client> iterable, boolean z10) {
        boolean z11 = false;
        boolean z12 = false;
        for (Api.Client next : iterable) {
            z11 |= next.requiresSignIn();
            z12 |= next.providesSignIn();
        }
        if (!z11) {
            return 3;
        }
        if (!z12 || !z10) {
            return 1;
        }
        return 2;
    }

    static String zag(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    static /* bridge */ /* synthetic */ void zai(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zap) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void zaj(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zak()) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    private final void zal(int i10) {
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i10);
        } else if (num.intValue() != i10) {
            String zag2 = zag(i10);
            String zag3 = zag(this.zaw.intValue());
            StringBuilder sb2 = new StringBuilder(zag2.length() + 51 + zag3.length());
            sb2.append("Cannot use sign-in mode: ");
            sb2.append(zag2);
            sb2.append(". Mode was already set to ");
            sb2.append(zag3);
            throw new IllegalStateException(sb2.toString());
        }
        if (this.zal == null) {
            boolean z10 = false;
            boolean z11 = false;
            for (Api.Client next : this.zac.values()) {
                z10 |= next.requiresSignIn();
                z11 |= next.providesSignIn();
            }
            int intValue = this.zaw.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z10) {
                    this.zal = b.g(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav);
                    return;
                }
            } else if (!z10) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z11) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.zal = new zabi(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, this);
        }
    }

    /* access modifiers changed from: private */
    public final void zam(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z10) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new u(this, statusPendingResult, z10, googleApiClient));
    }

    private final void zan() {
        this.zak.zab();
        ((zaca) Preconditions.checkNotNull(this.zal)).zaq();
    }

    public final ConnectionResult blockingConnect() {
        boolean z10 = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            if (this.zam >= 0) {
                if (this.zaw == null) {
                    z10 = false;
                }
                Preconditions.checkState(z10, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            ConnectionResult zab2 = ((zaca) Preconditions.checkNotNull(this.zal)).zab();
            this.zaj.unlock();
            return zab2;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z10 = true;
        if (num != null && num.intValue() == 2) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            zam(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            s sVar = new s(this, atomicReference, statusPendingResult);
            t tVar = new t(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(sVar);
            builder.addOnConnectionFailedListener(tVar);
            builder.setHandler(this.zas);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    public final void connect() {
        this.zaj.lock();
        try {
            int i10 = 2;
            boolean z10 = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.zaw)).intValue();
            this.zaj.lock();
            if (intValue == 3 || intValue == 1) {
                i10 = intValue;
            } else if (intValue != 2) {
                i10 = intValue;
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Illegal sign-in mode: ");
                sb2.append(i10);
                Preconditions.checkArgument(z10, sb2.toString());
                zal(i10);
                zan();
                this.zaj.unlock();
                this.zaj.unlock();
            }
            z10 = true;
            StringBuilder sb22 = new StringBuilder(33);
            sb22.append("Illegal sign-in mode: ");
            sb22.append(i10);
            Preconditions.checkArgument(z10, sb22.toString());
            zal(i10);
            zan();
            this.zaj.unlock();
            this.zaj.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final void disconnect() {
        Lock lock;
        this.zaj.lock();
        try {
            this.zai.zab();
            zaca zaca = this.zal;
            if (zaca != null) {
                zaca.zar();
            }
            this.zau.zab();
            for (BaseImplementation.ApiMethodImpl next : this.zaa) {
                next.zan((s0) null);
                next.cancel();
            }
            this.zaa.clear();
            if (this.zal == null) {
                lock = this.zaj;
            } else {
                zak();
                this.zak.zaa();
                lock = this.zaj;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.zan);
        printWriter.append(str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t10) {
        String str;
        Lock lock;
        Api<?> api = t10.getApi();
        boolean containsKey = this.zac.containsKey(t10.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(str);
        sb2.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb2.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca == null) {
                this.zaa.add(t10);
                lock = this.zaj;
            } else {
                t10 = zaca.zae(t10);
                lock = this.zaj;
            }
            lock.unlock();
            return t10;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t10) {
        String str;
        Lock lock;
        Api<?> api = t10.getApi();
        boolean containsKey = this.zac.containsKey(t10.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(str);
        sb2.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb2.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca != null) {
                if (this.zap) {
                    this.zaa.add(t10);
                    while (!this.zaa.isEmpty()) {
                        BaseImplementation.ApiMethodImpl remove = this.zaa.remove();
                        this.zai.zaa(remove);
                        remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock = this.zaj;
                } else {
                    t10 = zaca.zaf(t10);
                    lock = this.zaj;
                }
                lock.unlock();
                return t10;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @NonNull
    public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c10 = (Api.Client) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c10, "Appropriate Api was not requested.");
        return c10;
    }

    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock;
        this.zaj.lock();
        try {
            if (!isConnected()) {
                if (!this.zap) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.zac.containsKey(api.zab())) {
                ConnectionResult zad2 = ((zaca) Preconditions.checkNotNull(this.zal)).zad(api);
                if (zad2 == null) {
                    if (this.zap) {
                        connectionResult = ConnectionResult.RESULT_SUCCESS;
                        lock = this.zaj;
                    } else {
                        Log.w("GoogleApiClientImpl", zaf());
                        Log.wtf("GoogleApiClientImpl", String.valueOf(api.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                        connectionResult = new ConnectionResult(8, (PendingIntent) null);
                        lock = this.zaj;
                    }
                    lock.unlock();
                    return connectionResult;
                }
                this.zaj.unlock();
                return zad2;
            }
            throw new IllegalArgumentException(String.valueOf(api.zad()).concat(" was never registered with GoogleApiClient"));
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final Context getContext() {
        return this.zan;
    }

    public final Looper getLooper() {
        return this.zao;
    }

    public final boolean hasApi(@NonNull Api<?> api) {
        return this.zac.containsKey(api.zab());
    }

    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.Client client;
        if (isConnected() && (client = this.zac.get(api.zab())) != null && client.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean isConnected() {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zaw()) {
            return false;
        }
        return true;
    }

    public final boolean isConnecting() {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zax()) {
            return false;
        }
        return true;
    }

    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zaj(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zak(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zay(signInConnectionListener)) {
            return false;
        }
        return true;
    }

    public final void maybeSignOut() {
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zau();
        }
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zag(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(@NonNull L l10) {
        this.zaj.lock();
        try {
            return this.zau.zaa(l10, this.zao, "NO_TYPE");
        } finally {
            this.zaj.unlock();
        }
    }

    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zam >= 0) {
            zak.zaa(lifecycleActivity).zae(this.zam);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    public final void zaa(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            zak();
        }
        if (!this.zap) {
            this.zak.zac(connectionResult);
            this.zak.zaa();
        }
    }

    public final void zab(@Nullable Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute(this.zaa.remove());
        }
        this.zak.zad(bundle);
    }

    public final void zac(int i10, boolean z10) {
        if (i10 == 1) {
            if (!z10 && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.zab = this.zat.zac(this.zan.getApplicationContext(), new w(this));
                    } catch (SecurityException unused) {
                    }
                }
                v vVar = this.zas;
                vVar.sendMessageDelayed(vVar.obtainMessage(1), this.zaq);
                v vVar2 = this.zas;
                vVar2.sendMessageDelayed(vVar2.obtainMessage(2), this.zar);
            }
            i10 = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(zadc.zaa);
        }
        this.zak.zae(i10);
        this.zak.zaa();
        if (i10 == 2) {
            zan();
        }
    }

    /* access modifiers changed from: package-private */
    public final String zaf() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabx = this.zab;
        if (zabx != null) {
            zabx.zab();
            this.zab = null;
        }
        return true;
    }

    public final void zao(zada zada) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zada);
            this.zaj.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r3 == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zap(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.lock()
            java.util.Set<com.google.android.gms.common.api.internal.zada> r0 = r2.zah     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0018
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0016 }
            r3.<init>()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x004c
        L_0x0016:
            r3 = move-exception
            goto L_0x0059
        L_0x0018:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0016 }
            if (r3 != 0) goto L_0x0029
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0016 }
            r3.<init>()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x004c
        L_0x0029:
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0016 }
            r3.lock()     // Catch:{ all -> 0x0016 }
            java.util.Set<com.google.android.gms.common.api.internal.zada> r3 = r2.zah     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x0038
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0016 }
            r3.unlock()     // Catch:{ all -> 0x0016 }
            goto L_0x0045
        L_0x0038:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0052 }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0016 }
            r0.unlock()     // Catch:{ all -> 0x0016 }
            if (r3 != 0) goto L_0x004c
        L_0x0045:
            com.google.android.gms.common.api.internal.zaca r3 = r2.zal     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x004c
            r3.zat()     // Catch:{ all -> 0x0016 }
        L_0x004c:
            java.util.concurrent.locks.Lock r3 = r2.zaj
            r3.unlock()
            return
        L_0x0052:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0016 }
            r0.unlock()     // Catch:{ all -> 0x0016 }
            throw r3     // Catch:{ all -> 0x0016 }
        L_0x0059:
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }

    public final ConnectionResult blockingConnect(long j10, @NonNull TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            ConnectionResult zac2 = ((zaca) Preconditions.checkNotNull(this.zal)).zac(j10, timeUnit);
            this.zaj.unlock();
            return zac2;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final void connect(int i10) {
        this.zaj.lock();
        boolean z10 = true;
        if (!(i10 == 3 || i10 == 1)) {
            if (i10 == 2) {
                i10 = 2;
            } else {
                z10 = false;
            }
        }
        try {
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i10);
            Preconditions.checkArgument(z10, sb2.toString());
            zal(i10);
            zan();
        } finally {
            this.zaj.unlock();
        }
    }
}
