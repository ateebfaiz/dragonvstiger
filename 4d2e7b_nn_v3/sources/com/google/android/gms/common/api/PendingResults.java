package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults {
    @KeepForSdk
    private PendingResults() {
    }

    @NonNull
    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(@NonNull R r10, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r10, "Result must not be null");
        Preconditions.checkArgument(!r10.getStatus().isSuccess(), "Status code must not be SUCCESS");
        c cVar = new c(googleApiClient, r10);
        cVar.setResult(r10);
        return cVar;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r10) {
        Preconditions.checkNotNull(r10, "Result must not be null");
        d dVar = new d((GoogleApiClient) null);
        dVar.setResult(r10);
        return new OptionalPendingResultImpl(dVar);
    }

    @NonNull
    public static <R extends Result> PendingResult<R> canceledPendingResult(@NonNull R r10) {
        Preconditions.checkNotNull(r10, "Result must not be null");
        Preconditions.checkArgument(r10.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        b bVar = new b(r10);
        bVar.cancel();
        return bVar;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r10, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r10, "Result must not be null");
        d dVar = new d(googleApiClient);
        dVar.setResult(r10);
        return new OptionalPendingResultImpl(dVar);
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
