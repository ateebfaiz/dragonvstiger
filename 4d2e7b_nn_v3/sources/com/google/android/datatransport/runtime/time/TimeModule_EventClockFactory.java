package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_EventClockFactory implements Factory<Clock> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_EventClockFactory f6603a = new TimeModule_EventClockFactory();
    }

    public static TimeModule_EventClockFactory create() {
        return a.f6603a;
    }

    public static Clock eventClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return eventClock();
    }
}
