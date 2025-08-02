package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"period_start_time"})})
public final class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new a();
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    @NonNull
    public BackoffPolicy backoffPolicy;
    @NonNull
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @ColumnInfo(name = "id")
    @NonNull
    @PrimaryKey

    /* renamed from: id  reason: collision with root package name */
    public String f17025id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @ColumnInfo(name = "input")
    @NonNull
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @ColumnInfo(name = "out_of_quota_policy")
    @NonNull
    public OutOfQuotaPolicy outOfQuotaPolicy;
    @ColumnInfo(name = "output")
    @NonNull
    public Data output;
    @ColumnInfo(name = "period_start_time")
    public long periodStartTime;
    @ColumnInfo(name = "run_attempt_count")
    @IntRange(from = 0)
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    @NonNull
    public WorkInfo.State state = WorkInfo.State.ENQUEUED;
    @ColumnInfo(name = "worker_class_name")
    @NonNull
    public String workerClassName;

    public static class IdAndState {
        @ColumnInfo(name = "id")

        /* renamed from: id  reason: collision with root package name */
        public String f17026id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.f17026id.equals(idAndState.f17026id);
        }

        public int hashCode() {
            return (this.f17026id.hashCode() * 31) + this.state.hashCode();
        }
    }

    public static class WorkInfoPojo {
        @ColumnInfo(name = "id")

        /* renamed from: id  reason: collision with root package name */
        public String f17027id;
        @ColumnInfo(name = "output")
        public Data output;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        public List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        public int runAttemptCount;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        public List<String> tags;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.runAttemptCount != workInfoPojo.runAttemptCount) {
                return false;
            }
            String str = this.f17027id;
            if (str == null ? workInfoPojo.f17027id != null : !str.equals(workInfoPojo.f17027id)) {
                return false;
            }
            if (this.state != workInfoPojo.state) {
                return false;
            }
            Data data = this.output;
            if (data == null ? workInfoPojo.output != null : !data.equals(workInfoPojo.output)) {
                return false;
            }
            List<String> list = this.tags;
            if (list == null ? workInfoPojo.tags != null : !list.equals(workInfoPojo.tags)) {
                return false;
            }
            List<Data> list2 = this.progress;
            List<Data> list3 = workInfoPojo.progress;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            String str = this.f17027id;
            int i14 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i15 = i10 * 31;
            WorkInfo.State state2 = this.state;
            if (state2 != null) {
                i11 = state2.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i15 + i11) * 31;
            Data data = this.output;
            if (data != null) {
                i12 = data.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (((i16 + i12) * 31) + this.runAttemptCount) * 31;
            List<String> list = this.tags;
            if (list != null) {
                i13 = list.hashCode();
            } else {
                i13 = 0;
            }
            int i18 = (i17 + i13) * 31;
            List<Data> list2 = this.progress;
            if (list2 != null) {
                i14 = list2.hashCode();
            }
            return i18 + i14;
        }

        @NonNull
        public WorkInfo toWorkInfo() {
            Data data;
            List<Data> list = this.progress;
            if (list == null || list.isEmpty()) {
                data = Data.EMPTY;
            } else {
                data = this.progress.get(0);
            }
            return new WorkInfo(UUID.fromString(this.f17027id), this.state, this.output, this.tags, data, this.runAttemptCount);
        }
    }

    class a implements Function {
        a() {
        }

        /* renamed from: a */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
            }
            return arrayList;
        }
    }

    public WorkSpec(@NonNull String str, @NonNull String str2) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f17025id = str;
        this.workerClassName = str2;
    }

    public long calculateNextRunTime() {
        long j10;
        long j11;
        if (isBackedOff()) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                j11 = this.backoffDelayDuration * ((long) this.runAttemptCount);
            } else {
                j11 = (long) Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            return this.periodStartTime + Math.min(WorkRequest.MAX_BACKOFF_MILLIS, j11);
        }
        long j12 = 0;
        if (isPeriodic()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j13 = this.periodStartTime;
            if (j13 == 0) {
                j10 = currentTimeMillis + this.initialDelay;
            } else {
                j10 = j13;
            }
            long j14 = this.flexDuration;
            long j15 = this.intervalDuration;
            if (j14 != j15) {
                if (j13 == 0) {
                    j12 = j14 * -1;
                }
                return j10 + j15 + j12;
            }
            if (j13 != 0) {
                j12 = j15;
            }
            return j10 + j12;
        }
        long j16 = this.periodStartTime;
        if (j16 == 0) {
            j16 = System.currentTimeMillis();
        }
        return j16 + this.initialDelay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkSpec.class != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.expedited != workSpec.expedited || !this.f17025id.equals(workSpec.f17025id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName != null : !str.equals(workSpec.inputMergerClassName)) {
            return false;
        }
        if (!this.input.equals(workSpec.input) || !this.output.equals(workSpec.output) || !this.constraints.equals(workSpec.constraints) || this.backoffPolicy != workSpec.backoffPolicy) {
            return false;
        }
        if (this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy) {
            return true;
        }
        return false;
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int i10;
        int hashCode = ((((this.f17025id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String str = this.inputMergerClassName;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        long j10 = this.initialDelay;
        long j11 = this.intervalDuration;
        long j12 = this.flexDuration;
        long j13 = this.backoffDelayDuration;
        long j14 = this.periodStartTime;
        long j15 = this.minimumRetentionDuration;
        long j16 = this.scheduleRequestedAt;
        return ((((((((((((((((((((((((((((hashCode + i10) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.expedited ? 1 : 0)) * 31) + this.outOfQuotaPolicy.hashCode();
    }

    public boolean isBackedOff() {
        if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
            return false;
        }
        return true;
    }

    public boolean isPeriodic() {
        if (this.intervalDuration != 0) {
            return true;
        }
        return false;
    }

    public void setBackoffDelayDuration(long j10) {
        if (j10 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j10 = 18000000;
        }
        if (j10 < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
            j10 = 10000;
        }
        this.backoffDelayDuration = j10;
    }

    public void setPeriodic(long j10) {
        if (j10 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS)}), new Throwable[0]);
            j10 = 900000;
        }
        setPeriodic(j10, j10);
    }

    @NonNull
    public String toString() {
        return "{WorkSpec: " + this.f17025id + "}";
    }

    public void setPeriodic(long j10, long j11) {
        if (j10 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS)}), new Throwable[0]);
            j10 = 900000;
        }
        if (j11 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)}), new Throwable[0]);
            j11 = 300000;
        }
        if (j11 > j10) {
            Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j10)}), new Throwable[0]);
            j11 = j10;
        }
        this.intervalDuration = j10;
        this.flexDuration = j11;
    }

    public WorkSpec(@NonNull WorkSpec workSpec) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f17025id = workSpec.f17025id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
        this.expedited = workSpec.expedited;
        this.outOfQuotaPolicy = workSpec.outOfQuotaPolicy;
    }
}
