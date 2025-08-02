package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class b1 implements zabz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6670a;

    /* synthetic */ b1(b bVar, zay zay) {
        this.f6670a = bVar;
    }

    public final void zaa(ConnectionResult connectionResult) {
        this.f6670a.f6666o.lock();
        try {
            this.f6670a.f6664m = connectionResult;
            b.p(this.f6670a);
        } finally {
            this.f6670a.f6666o.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.f6670a.f6666o.lock();
        try {
            this.f6670a.f6664m = ConnectionResult.RESULT_SUCCESS;
            b.p(this.f6670a);
        } finally {
            this.f6670a.f6666o.unlock();
        }
    }

    public final void zac(int i10, boolean z10) {
        Lock j10;
        this.f6670a.f6666o.lock();
        try {
            b bVar = this.f6670a;
            if (bVar.f6665n) {
                bVar.f6665n = false;
                b.n(this.f6670a, i10, z10);
                j10 = this.f6670a.f6666o;
            } else {
                bVar.f6665n = true;
                this.f6670a.f6657f.onConnectionSuspended(i10);
                j10 = this.f6670a.f6666o;
            }
            j10.unlock();
        } catch (Throwable th) {
            this.f6670a.f6666o.unlock();
            throw th;
        }
    }
}
