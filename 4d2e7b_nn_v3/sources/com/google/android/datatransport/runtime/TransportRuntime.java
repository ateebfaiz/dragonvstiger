package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;

public class TransportRuntime implements j {
    private static volatile k instance;
    private final Clock eventClock;
    private final Scheduler scheduler;
    private final Uploader uploader;
    private final Clock uptimeClock;

    TransportRuntime(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler2, Uploader uploader2, WorkInitializer workInitializer) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler2;
        this.uploader = uploader2;
        workInitializer.ensureContextsScheduled();
    }

    private EventInternal convert(SendRequest sendRequest) {
        return EventInternal.builder().setEventMillis(this.eventClock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(sendRequest.g()).setEncodedPayload(new EncodedPayload(sendRequest.b(), sendRequest.d())).setCode(sendRequest.c().getCode()).build();
    }

    public static TransportRuntime getInstance() {
        k kVar = instance;
        if (kVar != null) {
            return kVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<Encoding> getSupportedEncodings(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).getSupportedEncodings());
        }
        return Collections.singleton(Encoding.of("proto"));
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (instance == null) {
                        instance = d.h().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    static void withInstance(k kVar, Callable<Void> callable) throws Throwable {
        k kVar2;
        synchronized (TransportRuntime.class) {
            kVar2 = instance;
            instance = kVar;
        }
        try {
            callable.call();
            synchronized (TransportRuntime.class) {
                instance = kVar2;
            }
        } catch (Throwable th) {
            synchronized (TransportRuntime.class) {
                instance = kVar2;
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Uploader getUploader() {
        return this.uploader;
    }

    @Deprecated
    public TransportFactory newFactory(String str) {
        return new g(getSupportedEncodings((Destination) null), TransportContext.builder().setBackendName(str).build(), this);
    }

    public void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.scheduler.schedule(sendRequest.f().withPriority(sendRequest.c().getPriority()), convert(sendRequest), transportScheduleCallback);
    }

    public TransportFactory newFactory(Destination destination) {
        return new g(getSupportedEncodings(destination), TransportContext.builder().setBackendName(destination.getName()).setExtras(destination.getExtras()).build(), this);
    }
}
