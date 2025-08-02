package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabq<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {
    final /* synthetic */ GoogleApiManager zaa;
    private final Queue<zai> zab = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public final Api.Client zac;
    /* access modifiers changed from: private */
    public final ApiKey<O> zad;
    private final zaad zae;
    private final Set<zal> zaf = new HashSet();
    private final Map<ListenerHolder.ListenerKey<?>, zaci> zag = new HashMap();
    private final int zah;
    @Nullable
    private final zact zai;
    private boolean zaj;
    private final List<e0> zak = new ArrayList();
    @Nullable
    private ConnectionResult zal = null;
    private int zam = 0;

    @WorkerThread
    public zabq(GoogleApiManager googleApiManager, GoogleApi<O> googleApi) {
        this.zaa = googleApiManager;
        Api.Client zab2 = googleApi.zab(googleApiManager.zat.getLooper(), this);
        this.zac = zab2;
        this.zad = googleApi.getApiKey();
        this.zae = new zaad();
        this.zah = googleApi.zaa();
        if (zab2.requiresSignIn()) {
            this.zai = googleApi.zac(googleApiManager.zak, googleApiManager.zat);
        } else {
            this.zai = null;
        }
    }

    @WorkerThread
    @Nullable
    private final Feature zaB(@Nullable Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(r3);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l10 = (Long) arrayMap.get(feature2.getName());
                if (l10 == null || l10.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @WorkerThread
    private final void zaC(ConnectionResult connectionResult) {
        String str;
        for (zal next : this.zaf) {
            if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                str = this.zac.getEndpointPackageName();
            } else {
                str = null;
            }
            next.zac(this.zad, connectionResult, str);
        }
        this.zaf.clear();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zaD(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zaE(status, (Exception) null, false);
    }

    @WorkerThread
    private final void zaE(@Nullable Status status, @Nullable Exception exc, boolean z10) {
        boolean z11;
        Preconditions.checkHandlerThread(this.zaa.zat);
        boolean z12 = true;
        if (status != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (exc != null) {
            z12 = false;
        }
        if (z11 != z12) {
            Iterator<zai> it = this.zab.iterator();
            while (it.hasNext()) {
                zai next = it.next();
                if (!z10 || next.zac == 2) {
                    if (status != null) {
                        next.zad(status);
                    } else {
                        next.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    @WorkerThread
    private final void zaF() {
        ArrayList arrayList = new ArrayList(this.zab);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            zai zai2 = (zai) arrayList.get(i10);
            if (this.zac.isConnected()) {
                if (zaL(zai2)) {
                    this.zab.remove(zai2);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zaG() {
        zan();
        zaC(ConnectionResult.RESULT_SUCCESS);
        zaK();
        Iterator<zaci> it = this.zag.values().iterator();
        while (it.hasNext()) {
            zaci next = it.next();
            if (zaB(next.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    next.zaa.registerListener(this.zac, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        zaF();
        zaI();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zaH(int i10) {
        zan();
        this.zaj = true;
        this.zae.zae(i10, this.zac.getLastDisconnectMessage());
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zat.sendMessageDelayed(Message.obtain(googleApiManager.zat, 9, this.zad), this.zaa.zae);
        GoogleApiManager googleApiManager2 = this.zaa;
        googleApiManager2.zat.sendMessageDelayed(Message.obtain(googleApiManager2.zat, 11, this.zad), this.zaa.zaf);
        this.zaa.zam.zac();
        for (zaci zaci : this.zag.values()) {
            zaci.zac.run();
        }
    }

    private final void zaI() {
        this.zaa.zat.removeMessages(12, this.zad);
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zat.sendMessageDelayed(googleApiManager.zat.obtainMessage(12, this.zad), this.zaa.zag);
    }

    @WorkerThread
    private final void zaJ(zai zai2) {
        zai2.zag(this.zae, zaz());
        try {
            zai2.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @WorkerThread
    private final void zaK() {
        if (this.zaj) {
            this.zaa.zat.removeMessages(11, this.zad);
            this.zaa.zat.removeMessages(9, this.zad);
            this.zaj = false;
        }
    }

    @WorkerThread
    private final boolean zaL(zai zai2) {
        if (!(zai2 instanceof zac)) {
            zaJ(zai2);
            return true;
        }
        zac zac2 = (zac) zai2;
        Feature zaB = zaB(zac2.zab(this));
        if (zaB == null) {
            zaJ(zai2);
            return true;
        }
        String name = this.zac.getClass().getName();
        String name2 = zaB.getName();
        long version = zaB.getVersion();
        StringBuilder sb2 = new StringBuilder(name.length() + 77 + String.valueOf(name2).length());
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(name2);
        sb2.append(", ");
        sb2.append(version);
        sb2.append(").");
        Log.w("GoogleApiManager", sb2.toString());
        if (!this.zaa.zau || !zac2.zaa(this)) {
            zac2.zae(new UnsupportedApiCallException(zaB));
            return true;
        }
        e0 e0Var = new e0(this.zad, zaB, (zabr) null);
        int indexOf = this.zak.indexOf(e0Var);
        if (indexOf >= 0) {
            e0 e0Var2 = this.zak.get(indexOf);
            this.zaa.zat.removeMessages(15, e0Var2);
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zat.sendMessageDelayed(Message.obtain(googleApiManager.zat, 15, e0Var2), this.zaa.zae);
            return false;
        }
        this.zak.add(e0Var);
        GoogleApiManager googleApiManager2 = this.zaa;
        googleApiManager2.zat.sendMessageDelayed(Message.obtain(googleApiManager2.zat, 15, e0Var), this.zaa.zae);
        GoogleApiManager googleApiManager3 = this.zaa;
        googleApiManager3.zat.sendMessageDelayed(Message.obtain(googleApiManager3.zat, 16, e0Var), this.zaa.zaf);
        ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
        if (zaM(connectionResult)) {
            return false;
        }
        this.zaa.zaG(connectionResult, this.zah);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return false;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zaM(@androidx.annotation.NonNull com.google.android.gms.common.ConnectionResult r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.GoogleApiManager.zac
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.zaa     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zaae r2 = r1.zaq     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0029
            java.util.Set r1 = r1.zar     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.ApiKey<O> r2 = r3.zad     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.zaa     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zaae r1 = r1.zaq     // Catch:{ all -> 0x0027 }
            int r2 = r3.zah     // Catch:{ all -> 0x0027 }
            r1.zah(r4, r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 1
            return r4
        L_0x0027:
            r4 = move-exception
            goto L_0x002c
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 0
            return r4
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabq.zaM(com.google.android.gms.common.ConnectionResult):boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final boolean zaN(boolean z10) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (!this.zac.isConnected() || this.zag.size() != 0) {
            return false;
        }
        if (this.zae.zag()) {
            if (z10) {
                zaI();
            }
            return false;
        }
        this.zac.disconnect("Timing out service connection.");
        return true;
    }

    static /* bridge */ /* synthetic */ void zal(zabq zabq, e0 e0Var) {
        if (!zabq.zak.contains(e0Var) || zabq.zaj) {
            return;
        }
        if (!zabq.zac.isConnected()) {
            zabq.zao();
        } else {
            zabq.zaF();
        }
    }

    static /* bridge */ /* synthetic */ void zam(zabq zabq, e0 e0Var) {
        Feature[] zab2;
        if (zabq.zak.remove(e0Var)) {
            zabq.zaa.zat.removeMessages(15, e0Var);
            zabq.zaa.zat.removeMessages(16, e0Var);
            Feature a10 = e0Var.f6686b;
            ArrayList arrayList = new ArrayList(zabq.zab.size());
            for (zai next : zabq.zab) {
                if ((next instanceof zac) && (zab2 = ((zac) next).zab(zabq)) != null && ArrayUtils.contains((T[]) zab2, a10)) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zai zai2 = (zai) arrayList.get(i10);
                zabq.zab.remove(zai2);
                zai2.zae(new UnsupportedApiCallException(a10));
            }
        }
    }

    public final void onConnected(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.zaa.zat.getLooper()) {
            zaG();
        } else {
            this.zaa.zat.post(new a0(this));
        }
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zar(connectionResult, (Exception) null);
    }

    public final void onConnectionSuspended(int i10) {
        if (Looper.myLooper() == this.zaa.zat.getLooper()) {
            zaH(i10);
        } else {
            this.zaa.zat.post(new b0(this, i10));
        }
    }

    @WorkerThread
    public final boolean zaA() {
        return zaN(true);
    }

    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z10) {
        throw null;
    }

    public final int zab() {
        return this.zah;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zac() {
        return this.zam;
    }

    @WorkerThread
    @Nullable
    public final ConnectionResult zad() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        return this.zal;
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map<ListenerHolder.ListenerKey<?>, zaci> zah() {
        return this.zag;
    }

    @WorkerThread
    public final void zan() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        this.zal = null;
    }

    @WorkerThread
    public final void zao() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (!this.zac.isConnected() && !this.zac.isConnecting()) {
            try {
                GoogleApiManager googleApiManager = this.zaa;
                int zab2 = googleApiManager.zam.zab(googleApiManager.zak, this.zac);
                if (zab2 != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(zab2, (PendingIntent) null);
                    String name = this.zac.getClass().getName();
                    String obj = connectionResult.toString();
                    StringBuilder sb2 = new StringBuilder(name.length() + 35 + obj.length());
                    sb2.append("The service for ");
                    sb2.append(name);
                    sb2.append(" is not available: ");
                    sb2.append(obj);
                    Log.w("GoogleApiManager", sb2.toString());
                    zar(connectionResult, (Exception) null);
                    return;
                }
                GoogleApiManager googleApiManager2 = this.zaa;
                Api.Client client = this.zac;
                g0 g0Var = new g0(googleApiManager2, client, this.zad);
                if (client.requiresSignIn()) {
                    ((zact) Preconditions.checkNotNull(this.zai)).zae(g0Var);
                }
                try {
                    this.zac.connect(g0Var);
                } catch (SecurityException e10) {
                    zar(new ConnectionResult(10), e10);
                }
            } catch (IllegalStateException e11) {
                zar(new ConnectionResult(10), e11);
            }
        }
    }

    @WorkerThread
    public final void zap(zai zai2) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (!this.zac.isConnected()) {
            this.zab.add(zai2);
            ConnectionResult connectionResult = this.zal;
            if (connectionResult == null || !connectionResult.hasResolution()) {
                zao();
            } else {
                zar(this.zal, (Exception) null);
            }
        } else if (zaL(zai2)) {
            zaI();
        } else {
            this.zab.add(zai2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zaq() {
        this.zam++;
    }

    @WorkerThread
    public final void zar(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zact zact = this.zai;
        if (zact != null) {
            zact.zaf();
        }
        zan();
        this.zaa.zam.zac();
        zaC(connectionResult);
        if ((this.zac instanceof zap) && connectionResult.getErrorCode() != 24) {
            this.zaa.zah = true;
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zat.sendMessageDelayed(googleApiManager.zat.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (connectionResult.getErrorCode() == 4) {
            zaD(GoogleApiManager.zab);
        } else if (this.zab.isEmpty()) {
            this.zal = connectionResult;
        } else if (exc != null) {
            Preconditions.checkHandlerThread(this.zaa.zat);
            zaE((Status) null, exc, false);
        } else if (this.zaa.zau) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult), (Exception) null, true);
            if (!this.zab.isEmpty() && !zaM(connectionResult) && !this.zaa.zaG(connectionResult, this.zah)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zaj = true;
                }
                if (this.zaj) {
                    GoogleApiManager googleApiManager2 = this.zaa;
                    googleApiManager2.zat.sendMessageDelayed(Message.obtain(googleApiManager2.zat, 9, this.zad), this.zaa.zae);
                    return;
                }
                zaD(GoogleApiManager.zaH(this.zad, connectionResult));
            }
        } else {
            zaD(GoogleApiManager.zaH(this.zad, connectionResult));
        }
    }

    @WorkerThread
    public final void zas(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        Api.Client client = this.zac;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb2 = new StringBuilder(name.length() + 25 + valueOf.length());
        sb2.append("onSignInFailed for ");
        sb2.append(name);
        sb2.append(" with ");
        sb2.append(valueOf);
        client.disconnect(sb2.toString());
        zar(connectionResult, (Exception) null);
    }

    @WorkerThread
    public final void zat(zal zal2) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        this.zaf.add(zal2);
    }

    @WorkerThread
    public final void zau() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (this.zaj) {
            zao();
        }
    }

    @WorkerThread
    public final void zav() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zaD(GoogleApiManager.zaa);
        this.zae.zaf();
        for (ListenerHolder.ListenerKey zah2 : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(zah2, new TaskCompletionSource()));
        }
        zaC(new ConnectionResult(4));
        if (this.zac.isConnected()) {
            this.zac.onUserSignOut(new d0(this));
        }
    }

    @WorkerThread
    public final void zaw() {
        Status status;
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (this.zaj) {
            zaK();
            GoogleApiManager googleApiManager = this.zaa;
            if (googleApiManager.zal.isGooglePlayServicesAvailable(googleApiManager.zak) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            zaD(status);
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zay() {
        return this.zac.isConnected();
    }

    public final boolean zaz() {
        return this.zac.requiresSignIn();
    }
}
