package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    @ColumnInfo(name = "content_uri_triggers")
    private ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
    @ColumnInfo(name = "required_network_type")
    private NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    @ColumnInfo(name = "requires_battery_not_low")
    private boolean mRequiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    private boolean mRequiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    private boolean mRequiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    private boolean mRequiresStorageNotLow;
    @ColumnInfo(name = "trigger_content_update_delay")
    private long mTriggerContentUpdateDelay = -1;
    @ColumnInfo(name = "trigger_max_content_delay")
    private long mTriggerMaxContentDelay = -1;

    public static final class Builder {
        ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
        NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        boolean mRequiresBatteryNotLow = false;
        boolean mRequiresCharging = false;
        boolean mRequiresDeviceIdle = false;
        boolean mRequiresStorageNotLow = false;
        long mTriggerContentMaxDelay = -1;
        long mTriggerContentUpdateDelay = -1;

        public Builder() {
        }

        @RequiresApi(24)
        @NonNull
        public Builder addContentUriTrigger(@NonNull Uri uri, boolean z10) {
            this.mContentUriTriggers.add(uri, z10);
            return this;
        }

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.mRequiredNetworkType = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z10) {
            this.mRequiresBatteryNotLow = z10;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z10) {
            this.mRequiresCharging = z10;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setRequiresDeviceIdle(boolean z10) {
            this.mRequiresDeviceIdle = z10;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z10) {
            this.mRequiresStorageNotLow = z10;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentMaxDelay(long j10, @NonNull TimeUnit timeUnit) {
            this.mTriggerContentMaxDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentUpdateDelay(long j10, @NonNull TimeUnit timeUnit) {
            this.mTriggerContentUpdateDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentMaxDelay(Duration duration) {
            this.mTriggerContentMaxDelay = duration.toMillis();
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentUpdateDelay(Duration duration) {
            this.mTriggerContentUpdateDelay = duration.toMillis();
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull Constraints constraints) {
            this.mRequiresCharging = constraints.requiresCharging();
            int i10 = Build.VERSION.SDK_INT;
            this.mRequiresDeviceIdle = constraints.requiresDeviceIdle();
            this.mRequiredNetworkType = constraints.getRequiredNetworkType();
            this.mRequiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.mRequiresStorageNotLow = constraints.requiresStorageNotLow();
            if (i10 >= 24) {
                this.mTriggerContentUpdateDelay = constraints.getTriggerContentUpdateDelay();
                this.mTriggerContentMaxDelay = constraints.getTriggerMaxContentDelay();
                this.mContentUriTriggers = constraints.getContentUriTriggers();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.mRequiresCharging == constraints.mRequiresCharging && this.mRequiresDeviceIdle == constraints.mRequiresDeviceIdle && this.mRequiresBatteryNotLow == constraints.mRequiresBatteryNotLow && this.mRequiresStorageNotLow == constraints.mRequiresStorageNotLow && this.mTriggerContentUpdateDelay == constraints.mTriggerContentUpdateDelay && this.mTriggerMaxContentDelay == constraints.mTriggerMaxContentDelay && this.mRequiredNetworkType == constraints.mRequiredNetworkType) {
            return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ContentUriTriggers getContentUriTriggers() {
        return this.mContentUriTriggers;
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.mRequiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerContentUpdateDelay() {
        return this.mTriggerContentUpdateDelay;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerMaxContentDelay() {
        return this.mTriggerMaxContentDelay;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasContentUriTriggers() {
        if (this.mContentUriTriggers.size() > 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.mTriggerContentUpdateDelay;
        long j11 = this.mTriggerMaxContentDelay;
        return (((((((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.mContentUriTriggers.hashCode();
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.mRequiresCharging;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.mRequiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setContentUriTriggers(@Nullable ContentUriTriggers contentUriTriggers) {
        this.mContentUriTriggers = contentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresBatteryNotLow(boolean z10) {
        this.mRequiresBatteryNotLow = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresCharging(boolean z10) {
        this.mRequiresCharging = z10;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresDeviceIdle(boolean z10) {
        this.mRequiresDeviceIdle = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresStorageNotLow(boolean z10) {
        this.mRequiresStorageNotLow = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerContentUpdateDelay(long j10) {
        this.mTriggerContentUpdateDelay = j10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerMaxContentDelay(long j10) {
        this.mTriggerMaxContentDelay = j10;
    }

    Constraints(Builder builder) {
        this.mRequiresCharging = builder.mRequiresCharging;
        int i10 = Build.VERSION.SDK_INT;
        this.mRequiresDeviceIdle = builder.mRequiresDeviceIdle;
        this.mRequiredNetworkType = builder.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = builder.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = builder.mRequiresStorageNotLow;
        if (i10 >= 24) {
            this.mContentUriTriggers = builder.mContentUriTriggers;
            this.mTriggerContentUpdateDelay = builder.mTriggerContentUpdateDelay;
            this.mTriggerMaxContentDelay = builder.mTriggerContentMaxDelay;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.mRequiresCharging = constraints.mRequiresCharging;
        this.mRequiresDeviceIdle = constraints.mRequiresDeviceIdle;
        this.mRequiredNetworkType = constraints.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = constraints.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = constraints.mRequiresStorageNotLow;
        this.mContentUriTriggers = constraints.mContentUriTriggers;
    }
}
