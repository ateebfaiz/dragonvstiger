package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class a1 implements zabz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6653a;

    /* synthetic */ a1(b bVar, zaw zaw) {
        this.f6653a = bVar;
    }

    public final void zaa(ConnectionResult connectionResult) {
        this.f6653a.f6666o.lock();
        try {
            this.f6653a.f6663l = connectionResult;
            b.p(this.f6653a);
        } finally {
            this.f6653a.f6666o.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.f6653a.f6666o.lock();
        try {
            b.o(this.f6653a, bundle);
            this.f6653a.f6663l = ConnectionResult.RESULT_SUCCESS;
            b.p(this.f6653a);
        } finally {
            this.f6653a.f6666o.unlock();
        }
    }

    public final void zac(int i10, boolean z10) {
        Lock j10;
        this.f6653a.f6666o.lock();
        try {
            b bVar = this.f6653a;
            if (!bVar.f6665n && bVar.f6664m != null) {
                if (bVar.f6664m.isSuccess()) {
                    this.f6653a.f6665n = true;
                    this.f6653a.f6658g.onConnectionSuspended(i10);
                    j10 = this.f6653a.f6666o;
                    j10.unlock();
                }
            }
            this.f6653a.f6665n = false;
            b.n(this.f6653a, i10, z10);
            j10 = this.f6653a.f6666o;
            j10.unlock();
        } catch (Throwable th) {
            this.f6653a.f6666o.unlock();
            throw th;
        }
    }
}
