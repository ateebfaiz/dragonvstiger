package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class b implements zaca {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6654a;

    /* renamed from: b  reason: collision with root package name */
    private final zabe f6655b;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f6656e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final zabi f6657f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final zabi f6658g;

    /* renamed from: h  reason: collision with root package name */
    private final Map f6659h;

    /* renamed from: i  reason: collision with root package name */
    private final Set f6660i = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: j  reason: collision with root package name */
    private final Api.Client f6661j;

    /* renamed from: k  reason: collision with root package name */
    private Bundle f6662k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ConnectionResult f6663l = null;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ConnectionResult f6664m = null;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f6665n = false;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Lock f6666o;

    /* renamed from: p  reason: collision with root package name */
    private int f6667p = 0;

    private b(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f6654a = context;
        this.f6655b = zabe;
        this.f6666o = lock;
        this.f6656e = looper;
        this.f6661j = client;
        Context context2 = context;
        zabe zabe2 = zabe;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabi zabi = r3;
        zabi zabi2 = new zabi(context2, zabe2, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zae, SignInOptions>) null, arrayList2, new a1(this, (zaw) null));
        this.f6657f = zabi;
        this.f6658g = new zabi(context2, zabe2, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new b1(this, (zay) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey put : map2.keySet()) {
            arrayMap.put(put, this.f6657f);
        }
        for (Api.AnyClientKey put2 : map.keySet()) {
            arrayMap.put(put2, this.f6658g);
        }
        this.f6659h = Collections.unmodifiableMap(arrayMap);
    }

    private final void a(ConnectionResult connectionResult) {
        int i10 = this.f6667p;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f6667p = 0;
            }
            this.f6655b.zaa(connectionResult);
        }
        b();
        this.f6667p = 0;
    }

    private final void b() {
        for (SignInConnectionListener onComplete : this.f6660i) {
            onComplete.onComplete();
        }
        this.f6660i.clear();
    }

    private final boolean c() {
        ConnectionResult connectionResult = this.f6664m;
        if (connectionResult == null || connectionResult.getErrorCode() != 4) {
            return false;
        }
        return true;
    }

    private final boolean d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabi = (zabi) this.f6659h.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabi, "GoogleApiClient is not configured to use the API required for this call.");
        return zabi.equals(this.f6658g);
    }

    private static boolean e(ConnectionResult connectionResult) {
        if (connectionResult == null || !connectionResult.isSuccess()) {
            return false;
        }
        return true;
    }

    public static b g(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        Map map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey<?> zab = api.zab();
            if (arrayMap.containsKey(zab)) {
                arrayMap3.put(api, (Boolean) map3.get(api));
            } else if (arrayMap2.containsKey(zab)) {
                arrayMap4.put(api, (Boolean) map3.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zat zat = (zat) arrayList.get(i10);
            if (arrayMap3.containsKey(zat.zaa)) {
                arrayList2.add(zat);
            } else if (arrayMap4.containsKey(zat.zaa)) {
                arrayList3.add(zat);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new b(context, zabe, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    static /* bridge */ /* synthetic */ void n(b bVar, int i10, boolean z10) {
        bVar.f6655b.zac(i10, z10);
        bVar.f6664m = null;
        bVar.f6663l = null;
    }

    static /* bridge */ /* synthetic */ void o(b bVar, Bundle bundle) {
        Bundle bundle2 = bVar.f6662k;
        if (bundle2 == null) {
            bVar.f6662k = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void p(b bVar) {
        ConnectionResult connectionResult;
        if (e(bVar.f6663l)) {
            if (e(bVar.f6664m) || bVar.c()) {
                int i10 = bVar.f6667p;
                if (i10 != 1) {
                    if (i10 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        bVar.f6667p = 0;
                        return;
                    }
                    ((zabe) Preconditions.checkNotNull(bVar.f6655b)).zab(bVar.f6662k);
                }
                bVar.b();
                bVar.f6667p = 0;
                return;
            }
            ConnectionResult connectionResult2 = bVar.f6664m;
            if (connectionResult2 == null) {
                return;
            }
            if (bVar.f6667p == 1) {
                bVar.b();
                return;
            }
            bVar.a(connectionResult2);
            bVar.f6657f.zar();
        } else if (bVar.f6663l == null || !e(bVar.f6664m)) {
            ConnectionResult connectionResult3 = bVar.f6663l;
            if (connectionResult3 != null && (connectionResult = bVar.f6664m) != null) {
                if (bVar.f6658g.zaf < bVar.f6657f.zaf) {
                    connectionResult3 = connectionResult;
                }
                bVar.a(connectionResult3);
            }
        } else {
            bVar.f6658g.zar();
            bVar.a((ConnectionResult) Preconditions.checkNotNull(bVar.f6663l));
        }
    }

    private final PendingIntent r() {
        if (this.f6661j == null) {
            return null;
        }
        return zal.zaa(this.f6654a, System.identityHashCode(this.f6655b), this.f6661j.getSignInIntent(), zal.zaa | GameControllerManager.DEVICEFLAG_VIBRATION);
    }

    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult zac(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult zad(Api api) {
        if (!Objects.equal(this.f6659h.get(api.zab()), this.f6658g)) {
            return this.f6657f.zad(api);
        }
        if (c()) {
            return new ConnectionResult(4, r());
        }
        return this.f6658g.zad(api);
    }

    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!d(apiMethodImpl)) {
            this.f6657f.zae(apiMethodImpl);
            return apiMethodImpl;
        } else if (c()) {
            apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
            return apiMethodImpl;
        } else {
            this.f6658g.zae(apiMethodImpl);
            return apiMethodImpl;
        }
    }

    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!d(apiMethodImpl)) {
            return this.f6657f.zaf(apiMethodImpl);
        }
        if (!c()) {
            return this.f6658g.zaf(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
        return apiMethodImpl;
    }

    public final void zaq() {
        this.f6667p = 2;
        this.f6665n = false;
        this.f6664m = null;
        this.f6663l = null;
        this.f6657f.zaq();
        this.f6658g.zaq();
    }

    public final void zar() {
        this.f6664m = null;
        this.f6663l = null;
        this.f6667p = 0;
        this.f6657f.zar();
        this.f6658g.zar();
        b();
    }

    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f6658g.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f6657f.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final void zat() {
        this.f6657f.zat();
        this.f6658g.zat();
    }

    public final void zau() {
        this.f6666o.lock();
        try {
            boolean zax = zax();
            this.f6658g.zar();
            this.f6664m = new ConnectionResult(4);
            if (zax) {
                new zaq(this.f6656e).post(new z0(this));
            } else {
                b();
            }
        } finally {
            this.f6666o.unlock();
        }
    }

    public final boolean zaw() {
        this.f6666o.lock();
        try {
            boolean z10 = false;
            if (this.f6657f.zaw() && (this.f6658g.zaw() || c() || this.f6667p == 1)) {
                z10 = true;
            }
            return z10;
        } finally {
            this.f6666o.unlock();
        }
    }

    public final boolean zax() {
        boolean z10;
        this.f6666o.lock();
        try {
            if (this.f6667p == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            return z10;
        } finally {
            this.f6666o.unlock();
        }
    }

    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.f6666o.lock();
        try {
            if (!zax()) {
                if (zaw()) {
                }
                this.f6666o.unlock();
                return false;
            }
            if (!this.f6658g.zaw()) {
                this.f6660i.add(signInConnectionListener);
                if (this.f6667p == 0) {
                    this.f6667p = 1;
                }
                this.f6664m = null;
                this.f6658g.zaq();
                this.f6666o.unlock();
                return true;
            }
            this.f6666o.unlock();
            return false;
        } catch (Throwable th) {
            this.f6666o.unlock();
            throw th;
        }
    }
}
