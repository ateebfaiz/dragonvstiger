package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class b extends PersistedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f6564a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f6565b;

    /* renamed from: c  reason: collision with root package name */
    private final EventInternal f6566c;

    b(long j10, TransportContext transportContext, EventInternal eventInternal) {
        this.f6564a = j10;
        if (transportContext != null) {
            this.f6565b = transportContext;
            if (eventInternal != null) {
                this.f6566c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f6564a != persistedEvent.getId() || !this.f6565b.equals(persistedEvent.getTransportContext()) || !this.f6566c.equals(persistedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    public EventInternal getEvent() {
        return this.f6566c;
    }

    public long getId() {
        return this.f6564a;
    }

    public TransportContext getTransportContext() {
        return this.f6565b;
    }

    public int hashCode() {
        long j10 = this.f6564a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f6565b.hashCode()) * 1000003) ^ this.f6566c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f6564a + ", transportContext=" + this.f6565b + ", event=" + this.f6566c + "}";
    }
}
