package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i10, T t10) {
        return new a(Integer.valueOf(i10), t10, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i10, T t10) {
        return new a(Integer.valueOf(i10), t10, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i10, T t10) {
        return new a(Integer.valueOf(i10), t10, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t10) {
        return new a((Integer) null, t10, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t10) {
        return new a((Integer) null, t10, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t10) {
        return new a((Integer) null, t10, Priority.HIGHEST);
    }
}
