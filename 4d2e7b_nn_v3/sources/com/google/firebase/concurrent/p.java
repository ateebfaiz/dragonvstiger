package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class p extends AbstractResolvableFuture implements ScheduledFuture {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledFuture f9065a;

    class a implements b {
        a() {
        }

        public void a(Throwable th) {
            boolean unused = p.this.setException(th);
        }

        public void set(Object obj) {
            boolean unused = p.this.set(obj);
        }
    }

    interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    interface c {
        ScheduledFuture a(b bVar);
    }

    p(c cVar) {
        this.f9065a = cVar.a(new a());
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
        this.f9065a.cancel(wasInterrupted());
    }

    /* renamed from: c */
    public int compareTo(Delayed delayed) {
        return this.f9065a.compareTo(delayed);
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.f9065a.getDelay(timeUnit);
    }
}
