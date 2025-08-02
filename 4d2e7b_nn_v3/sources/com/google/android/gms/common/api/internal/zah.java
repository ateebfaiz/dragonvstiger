package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends r0 {
    public final ListenerHolder.ListenerKey<?> zab;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    public final boolean zaa(zabq<?> zabq) {
        zaci zaci = zabq.zah().get(this.zab);
        if (zaci == null || !zaci.zaa.zab()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Feature[] zab(zabq<?> zabq) {
        zaci zaci = zabq.zah().get(this.zab);
        if (zaci == null) {
            return null;
        }
        return zaci.zaa.getRequiredFeatures();
    }

    public final void zac(zabq<?> zabq) throws RemoteException {
        zaci remove = zabq.zah().remove(this.zab);
        if (remove != null) {
            remove.zab.unregisterListener(zabq.zaf(), this.zaa);
            remove.zaa.clearListener();
            return;
        }
        this.zaa.trySetResult(Boolean.FALSE);
    }

    public final /* bridge */ /* synthetic */ void zag(@NonNull zaad zaad, boolean z10) {
    }
}
