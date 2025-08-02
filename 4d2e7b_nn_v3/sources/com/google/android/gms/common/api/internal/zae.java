package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zai {
    protected final A zaa;

    public zae(int i10, A a10) {
        super(i10);
        this.zaa = (BaseImplementation.ApiMethodImpl) Preconditions.checkNotNull(a10, "Null methods are not runnable.");
    }

    public final void zad(@NonNull Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    public final void zae(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb2.append(simpleName);
        sb2.append(": ");
        sb2.append(localizedMessage);
        try {
            this.zaa.setFailedResult(new Status(10, sb2.toString()));
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    public final void zaf(zabq<?> zabq) throws DeadObjectException {
        try {
            this.zaa.run(zabq.zaf());
        } catch (RuntimeException e10) {
            zae(e10);
        }
    }

    public final void zag(@NonNull zaad zaad, boolean z10) {
        zaad.zac(this.zaa, z10);
    }
}
