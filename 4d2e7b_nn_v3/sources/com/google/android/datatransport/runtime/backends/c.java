package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

final class c extends CreationContext {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6453a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f6454b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f6455c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6456d;

    c(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f6453a = context;
            if (clock != null) {
                this.f6454b = clock;
                if (clock2 != null) {
                    this.f6455c = clock2;
                    if (str != null) {
                        this.f6456d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (!this.f6453a.equals(creationContext.getApplicationContext()) || !this.f6454b.equals(creationContext.getWallClock()) || !this.f6455c.equals(creationContext.getMonotonicClock()) || !this.f6456d.equals(creationContext.getBackendName())) {
            return false;
        }
        return true;
    }

    public Context getApplicationContext() {
        return this.f6453a;
    }

    public String getBackendName() {
        return this.f6456d;
    }

    public Clock getMonotonicClock() {
        return this.f6455c;
    }

    public Clock getWallClock() {
        return this.f6454b;
    }

    public int hashCode() {
        return ((((((this.f6453a.hashCode() ^ 1000003) * 1000003) ^ this.f6454b.hashCode()) * 1000003) ^ this.f6455c.hashCode()) * 1000003) ^ this.f6456d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f6453a + ", wallClock=" + this.f6454b + ", monotonicClock=" + this.f6455c + ", backendName=" + this.f6456d + "}";
    }
}
