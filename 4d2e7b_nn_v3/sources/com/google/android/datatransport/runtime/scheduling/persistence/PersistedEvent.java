package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PersistedEvent {
    public static PersistedEvent create(long j10, TransportContext transportContext, EventInternal eventInternal) {
        return new b(j10, transportContext, eventInternal);
    }

    public abstract EventInternal getEvent();

    public abstract long getId();

    public abstract TransportContext getTransportContext();
}
