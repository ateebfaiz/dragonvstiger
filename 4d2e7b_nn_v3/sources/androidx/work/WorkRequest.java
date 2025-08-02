package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @NonNull
    private UUID mId;
    @NonNull
    private Set<String> mTags;
    @NonNull
    private WorkSpec mWorkSpec;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.mId = uuid;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.mId.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        boolean mBackoffCriteriaSet = false;
        UUID mId = UUID.randomUUID();
        Set<String> mTags = new HashSet();
        WorkSpec mWorkSpec;
        Class<? extends ListenableWorker> mWorkerClass;

        Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.mWorkerClass = cls;
            this.mWorkSpec = new WorkSpec(this.mId.toString(), cls.getName());
            addTag(cls.getName());
        }

        @NonNull
        public final B addTag(@NonNull String str) {
            this.mTags.add(str);
            return getThis();
        }

        @NonNull
        public final W build() {
            boolean z10;
            W buildInternal = buildInternal();
            Constraints constraints = this.mWorkSpec.constraints;
            if ((Build.VERSION.SDK_INT < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && !constraints.requiresDeviceIdle()) {
                z10 = false;
            } else {
                z10 = true;
            }
            WorkSpec workSpec = this.mWorkSpec;
            if (workSpec.expedited) {
                if (z10) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.mId = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec2;
            workSpec2.f17025id = this.mId.toString();
            return buildInternal;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract W buildInternal();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract B getThis();

        @NonNull
        public final B keepResultsForAtLeast(long j10, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(j10);
            return getThis();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j10, @NonNull TimeUnit timeUnit) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j10));
            return getThis();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.mWorkSpec.constraints = constraints;
            return getThis();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public B setExpedited(@NonNull OutOfQuotaPolicy outOfQuotaPolicy) {
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = outOfQuotaPolicy;
            return getThis();
        }

        @NonNull
        public B setInitialDelay(long j10, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.initialDelay = timeUnit.toMillis(j10);
            if (LocationRequestCompat.PASSIVE_INTERVAL - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialRunAttemptCount(int i10) {
            this.mWorkSpec.runAttemptCount = i10;
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.mWorkSpec.state = state;
            return getThis();
        }

        @NonNull
        public final B setInputData(@NonNull Data data) {
            this.mWorkSpec.input = data;
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setPeriodStartTime(long j10, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.periodStartTime = timeUnit.toMillis(j10);
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setScheduleRequestedAt(long j10, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(j10);
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            this.mWorkSpec.minimumRetentionDuration = duration.toMillis();
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(duration.toMillis());
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public B setInitialDelay(@NonNull Duration duration) {
            this.mWorkSpec.initialDelay = duration.toMillis();
            if (LocationRequestCompat.PASSIVE_INTERVAL - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
