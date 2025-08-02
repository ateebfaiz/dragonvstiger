package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;

abstract class k implements Closeable {

    interface a {
        a a(Context context);

        k build();
    }

    k() {
    }

    /* access modifiers changed from: package-private */
    public abstract EventStore a();

    /* access modifiers changed from: package-private */
    public abstract TransportRuntime b();

    public void close() {
        a().close();
    }
}
