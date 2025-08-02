package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_UptimeClockFactory f6604a = new TimeModule_UptimeClockFactory();
    }

    public static TimeModule_UptimeClockFactory create() {
        return a.f6604a;
    }

    public static Clock uptimeClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return uptimeClock();
    }
}
