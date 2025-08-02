package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zaa;
    private final PendingResult<?>[] zab;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    @NonNull
    public Status getStatus() {
        return this.zaa;
    }

    @NonNull
    public <R extends Result> R take(@NonNull BatchResultToken<R> batchResultToken) {
        boolean z10;
        if (batchResultToken.mId < this.zab.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "The result token does not belong to this batch");
        return this.zab[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
