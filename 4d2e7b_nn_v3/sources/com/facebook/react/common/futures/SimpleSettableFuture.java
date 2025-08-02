package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleSettableFuture implements Future {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f2902a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private Object f2903b;

    /* renamed from: c  reason: collision with root package name */
    private Exception f2904c;

    private void a() {
        if (this.f2902a.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }

    public Object b() {
        try {
            return get();
        } catch (InterruptedException | ExecutionException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void c(Object obj) {
        a();
        this.f2903b = obj;
        this.f2902a.countDown();
    }

    public boolean cancel(boolean z10) {
        throw new UnsupportedOperationException();
    }

    public void d(Exception exc) {
        a();
        this.f2904c = exc;
        this.f2902a.countDown();
    }

    public Object get() {
        this.f2902a.await();
        if (this.f2904c == null) {
            return this.f2903b;
        }
        throw new ExecutionException(this.f2904c);
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        if (this.f2902a.getCount() == 0) {
            return true;
        }
        return false;
    }

    public Object get(long j10, TimeUnit timeUnit) {
        if (!this.f2902a.await(j10, timeUnit)) {
            throw new TimeoutException("Timed out waiting for result");
        } else if (this.f2904c == null) {
            return this.f2903b;
        } else {
            throw new ExecutionException(this.f2904c);
        }
    }
}
