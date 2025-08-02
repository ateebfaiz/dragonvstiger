package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class r0 extends zac {
    protected final TaskCompletionSource<Object> zaa;

    public r0(int i10, TaskCompletionSource taskCompletionSource) {
        super(i10);
        this.zaa = taskCompletionSource;
    }

    /* access modifiers changed from: protected */
    public abstract void zac(zabq zabq);

    public final void zad(@NonNull Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    public final void zae(@NonNull Exception exc) {
        this.zaa.trySetException(exc);
    }

    public final void zaf(zabq<?> zabq) throws DeadObjectException {
        try {
            zac(zabq);
        } catch (DeadObjectException e10) {
            zad(zai.zah(e10));
            throw e10;
        } catch (RemoteException e11) {
            zad(zai.zah(e11));
        } catch (RuntimeException e12) {
            this.zaa.trySetException(e12);
        }
    }
}
