package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabi implements zaca, zau {
    final Map<Api.AnyClientKey<?>, Api.Client> zaa;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap();
    @Nullable
    final ClientSettings zac;
    final Map<Api<?>, Boolean> zad;
    @Nullable
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> zae;
    int zaf;
    final zabe zag;
    final zabz zah;
    /* access modifiers changed from: private */
    public final Lock zai;
    private final Condition zaj;
    private final Context zak;
    private final GoogleApiAvailabilityLight zal;
    private final y zam;
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public volatile zabf zan;
    @Nullable
    private ConnectionResult zao = null;

    public zabi(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, @Nullable ClientSettings clientSettings, Map<Api<?>, Boolean> map2, @Nullable Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zat> arrayList, zabz zabz) {
        this.zak = context;
        this.zai = lock;
        this.zal = googleApiAvailabilityLight;
        this.zaa = map;
        this.zac = clientSettings;
        this.zad = map2;
        this.zae = abstractClientBuilder;
        this.zag = zabe;
        this.zah = zabz;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).zaa(this);
        }
        this.zam = new y(this, looper);
        this.zaj = lock.newCondition();
        this.zan = new zaax(this);
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zai.lock();
        try {
            this.zan.zag(bundle);
        } finally {
            this.zai.unlock();
        }
    }

    public final void onConnectionSuspended(int i10) {
        this.zai.lock();
        try {
            this.zan.zai(i10);
        } finally {
            this.zai.unlock();
        }
    }

    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z10) {
        this.zai.lock();
        try {
            this.zan.zah(connectionResult, api, z10);
        } finally {
            this.zai.unlock();
        }
    }

    public final ConnectionResult zab() {
        zaq();
        while (this.zan instanceof zaaw) {
            try {
                this.zaj.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (this.zan instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public final ConnectionResult zac(long j10, TimeUnit timeUnit) {
        zaq();
        long nanos = timeUnit.toNanos(j10);
        while (this.zan instanceof zaaw) {
            if (nanos <= 0) {
                try {
                    zar();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zaj.awaitNanos(nanos);
            }
        }
        if (this.zan instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @Nullable
    public final ConnectionResult zad(@NonNull Api<?> api) {
        Api.AnyClientKey<?> zab2 = api.zab();
        if (!this.zaa.containsKey(zab2)) {
            return null;
        }
        if (this.zaa.get(zab2).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zab.containsKey(zab2)) {
            return this.zab.get(zab2);
        }
        return null;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zae(@NonNull T t10) {
        t10.zak();
        this.zan.zaa(t10);
        return t10;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaf(@NonNull T t10) {
        t10.zak();
        return this.zan.zab(t10);
    }

    /* access modifiers changed from: package-private */
    public final void zai() {
        this.zai.lock();
        try {
            this.zag.zak();
            this.zan = new zaaj(this);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaj() {
        this.zai.lock();
        try {
            this.zan = new zaaw(this, this.zac, this.zad, this.zal, this.zae, this.zai, this.zak);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zak(@Nullable ConnectionResult connectionResult) {
        this.zai.lock();
        try {
            this.zao = connectionResult;
            this.zan = new zaax(this);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zal(x xVar) {
        this.zam.sendMessage(this.zam.obtainMessage(1, xVar));
    }

    /* access modifiers changed from: package-private */
    public final void zam(RuntimeException runtimeException) {
        this.zam.sendMessage(this.zam.obtainMessage(2, runtimeException));
    }

    public final void zaq() {
        this.zan.zae();
    }

    public final void zar() {
        if (this.zan.zaj()) {
            this.zab.clear();
        }
    }

    public final void zas(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zan);
        for (Api next : this.zad.keySet()) {
            printWriter.append(str).append(next.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull(this.zaa.get(next.zab()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final void zat() {
        if (this.zan instanceof zaaj) {
            ((zaaj) this.zan).zaf();
        }
    }

    public final void zau() {
    }

    public final boolean zaw() {
        return this.zan instanceof zaaj;
    }

    public final boolean zax() {
        return this.zan instanceof zaaw;
    }

    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        return false;
    }
}
