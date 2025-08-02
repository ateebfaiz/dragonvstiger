package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class PeriodicWorkRequest extends WorkRequest {
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j10, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.mWorkSpec.setPeriodic(timeUnit.toMillis(j10));
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder getThis() {
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public PeriodicWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet && this.mWorkSpec.constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!this.mWorkSpec.expedited) {
                return new PeriodicWorkRequest(this);
            } else {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration) {
            super(cls);
            this.mWorkSpec.setPeriodic(duration.toMillis());
        }

        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j10, @NonNull TimeUnit timeUnit, long j11, @NonNull TimeUnit timeUnit2) {
            super(cls);
            this.mWorkSpec.setPeriodic(timeUnit.toMillis(j10), timeUnit2.toMillis(j11));
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration, @NonNull Duration duration2) {
            super(cls);
            this.mWorkSpec.setPeriodic(duration.toMillis(), duration2.toMillis());
        }
    }

    PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
