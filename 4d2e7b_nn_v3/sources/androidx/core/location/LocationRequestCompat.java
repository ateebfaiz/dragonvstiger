package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Class f14974a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f14975b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f14976c;

        /* renamed from: d  reason: collision with root package name */
        private static Method f14977d;

        /* renamed from: e  reason: collision with root package name */
        private static Method f14978e;

        /* renamed from: f  reason: collision with root package name */
        private static Method f14979f;

        public static Object a(LocationRequestCompat locationRequestCompat, String str) {
            try {
                if (f14974a == null) {
                    f14974a = Class.forName("android.location.LocationRequest");
                }
                if (f14975b == null) {
                    Method declaredMethod = f14974a.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});
                    f14975b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = f14975b.invoke((Object) null, new Object[]{str, Long.valueOf(locationRequestCompat.getIntervalMillis()), Float.valueOf(locationRequestCompat.getMinUpdateDistanceMeters()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                if (f14976c == null) {
                    Method declaredMethod2 = f14974a.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});
                    f14976c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f14976c.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getQuality())});
                if (f14977d == null) {
                    Method declaredMethod3 = f14974a.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});
                    f14977d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f14977d.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getMinUpdateIntervalMillis())});
                if (locationRequestCompat.getMaxUpdates() < Integer.MAX_VALUE) {
                    if (f14978e == null) {
                        Method declaredMethod4 = f14974a.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});
                        f14978e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f14978e.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.getMaxUpdates())});
                }
                if (locationRequestCompat.getDurationMillis() < LocationRequestCompat.PASSIVE_INTERVAL) {
                    if (f14979f == null) {
                        Method declaredMethod5 = f14974a.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});
                        f14979f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f14979f.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.getDurationMillis())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    private static class b {
        @DoNotInline
        public static LocationRequest a(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.getIntervalMillis()).setQuality(locationRequestCompat.getQuality()).setMinUpdateIntervalMillis(locationRequestCompat.getMinUpdateIntervalMillis()).setDurationMillis(locationRequestCompat.getDurationMillis()).setMaxUpdates(locationRequestCompat.getMaxUpdates()).setMinUpdateDistanceMeters(locationRequestCompat.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(locationRequestCompat.getMaxUpdateDelayMillis()).build();
        }
    }

    LocationRequestCompat(long j10, int i10, long j11, int i11, long j12, float f10, long j13) {
        this.mIntervalMillis = j10;
        this.mQuality = i10;
        this.mMinUpdateIntervalMillis = j12;
        this.mDurationMillis = j11;
        this.mMaxUpdates = i11;
        this.mMinUpdateDistanceMeters = f10;
        this.mMaxUpdateDelayMillis = j13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        if (this.mQuality == locationRequestCompat.mQuality && this.mIntervalMillis == locationRequestCompat.mIntervalMillis && this.mMinUpdateIntervalMillis == locationRequestCompat.mMinUpdateIntervalMillis && this.mDurationMillis == locationRequestCompat.mDurationMillis && this.mMaxUpdates == locationRequestCompat.mMaxUpdates && Float.compare(locationRequestCompat.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) == 0 && this.mMaxUpdateDelayMillis == locationRequestCompat.mMaxUpdateDelayMillis) {
            return true;
        }
        return false;
    }

    @IntRange(from = 1)
    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    @IntRange(from = 0)
    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    @IntRange(from = 0)
    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    @FloatRange(from = 0.0d, to = 3.4028234663852886E38d)
    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    @IntRange(from = 0)
    public long getMinUpdateIntervalMillis() {
        long j10 = this.mMinUpdateIntervalMillis;
        if (j10 == -1) {
            return this.mIntervalMillis;
        }
        return j10;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        long j10 = this.mIntervalMillis;
        long j11 = this.mMinUpdateIntervalMillis;
        return (((this.mQuality * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    @RequiresApi(31)
    @NonNull
    public LocationRequest toLocationRequest() {
        return b.a(this);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (this.mIntervalMillis != PASSIVE_INTERVAL) {
            sb2.append("@");
            TimeUtils.formatDuration(this.mIntervalMillis, sb2);
            int i10 = this.mQuality;
            if (i10 == 100) {
                sb2.append(" HIGH_ACCURACY");
            } else if (i10 == 102) {
                sb2.append(" BALANCED");
            } else if (i10 == 104) {
                sb2.append(" LOW_POWER");
            }
        } else {
            sb2.append("PASSIVE");
        }
        if (this.mDurationMillis != PASSIVE_INTERVAL) {
            sb2.append(", duration=");
            TimeUtils.formatDuration(this.mDurationMillis, sb2);
        }
        if (this.mMaxUpdates != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.mMaxUpdates);
        }
        long j10 = this.mMinUpdateIntervalMillis;
        if (j10 != -1 && j10 < this.mIntervalMillis) {
            sb2.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, sb2);
        }
        if (((double) this.mMinUpdateDistanceMeters) > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.mMinUpdateDistanceMeters);
        }
        if (this.mMaxUpdateDelayMillis / 2 > this.mIntervalMillis) {
            sb2.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, sb2);
        }
        sb2.append(']');
        return sb2.toString();
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public LocationRequest toLocationRequest(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        return p0.a(a.a(this, str));
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long j10) {
            setIntervalMillis(j10);
            this.mQuality = LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY;
            this.mDurationMillis = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        @NonNull
        public LocationRequestCompat build() {
            boolean z10;
            if (this.mIntervalMillis == LocationRequestCompat.PASSIVE_INTERVAL && this.mMinUpdateIntervalMillis == -1) {
                z10 = false;
            } else {
                z10 = true;
            }
            Preconditions.checkState(z10, "passive location requests must have an explicit minimum update interval");
            long j10 = this.mIntervalMillis;
            return new LocationRequestCompat(j10, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, j10), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        }

        @NonNull
        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        @NonNull
        public Builder setDurationMillis(@IntRange(from = 1) long j10) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(j10, 1, (long) LocationRequestCompat.PASSIVE_INTERVAL, "durationMillis");
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(@IntRange(from = 0) long j10) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(j10, 0, (long) LocationRequestCompat.PASSIVE_INTERVAL, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long j10) {
            this.mMaxUpdateDelayMillis = j10;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(j10, 0, (long) LocationRequestCompat.PASSIVE_INTERVAL, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int i10) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(i10, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f10) {
            this.mMinUpdateDistanceMeters = f10;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(f10, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long j10) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(j10, 0, (long) LocationRequestCompat.PASSIVE_INTERVAL, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int i10) {
            boolean z10;
            if (i10 == 104 || i10 == 102 || i10 == 100) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i10));
            this.mQuality = i10;
            return this;
        }

        public Builder(@NonNull LocationRequestCompat locationRequestCompat) {
            this.mIntervalMillis = locationRequestCompat.mIntervalMillis;
            this.mQuality = locationRequestCompat.mQuality;
            this.mDurationMillis = locationRequestCompat.mDurationMillis;
            this.mMaxUpdates = locationRequestCompat.mMaxUpdates;
            this.mMinUpdateIntervalMillis = locationRequestCompat.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = locationRequestCompat.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = locationRequestCompat.mMaxUpdateDelayMillis;
        }
    }
}
