package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaad {
    /* access modifiers changed from: private */
    public final Map<BasePendingResult<?>, Boolean> zaa = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */
    public final Map<TaskCompletionSource<?>, Boolean> zab = Collections.synchronizedMap(new WeakHashMap());

    private final void zah(boolean z10, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.zaa) {
            hashMap = new HashMap(this.zaa);
        }
        synchronized (this.zab) {
            hashMap2 = new HashMap(this.zab);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult<? extends Result> basePendingResult, boolean z10) {
        this.zaa.put(basePendingResult, Boolean.valueOf(z10));
        basePendingResult.addStatusListener(new c(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final <TResult> void zad(TaskCompletionSource<TResult> taskCompletionSource, boolean z10) {
        this.zab.put(taskCompletionSource, Boolean.valueOf(z10));
        taskCompletionSource.getTask().addOnCompleteListener(new d(this, taskCompletionSource));
    }

    /* access modifiers changed from: package-private */
    public final void zae(int i10, @Nullable String str) {
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        zah(true, new Status(20, sb2.toString()));
    }

    public final void zaf() {
        zah(false, GoogleApiManager.zaa);
    }

    /* access modifiers changed from: package-private */
    public final boolean zag() {
        if (!this.zaa.isEmpty() || !this.zab.isEmpty()) {
            return true;
        }
        return false;
    }
}
