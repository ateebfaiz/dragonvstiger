package org.cocos2dx.okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.a;
import org.cocos2dx.okhttp3.internal.Util;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<a.b> readyAsyncCalls = new ArrayDeque();
    private final Deque<a.b> runningAsyncCalls = new ArrayDeque();
    private final Deque<a> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    private boolean promoteAndExecute() {
        int i10;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<a.b> it = this.readyAsyncCalls.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.b next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                        it.remove();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                if (runningCallsCount() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
                while (true) {
                }
            }
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((a.b) arrayList.get(i10)).e(executorService());
        }
        return z10;
    }

    private int runningCallsForHost(a.b bVar) {
        int i10 = 0;
        for (a.b next : this.runningAsyncCalls) {
            if (!next.f().f1556f && next.g().equals(bVar.g())) {
                i10++;
            }
        }
        return i10;
    }

    public synchronized void cancelAll() {
        try {
            for (a.b f10 : this.readyAsyncCalls) {
                f10.f().cancel();
            }
            for (a.b f11 : this.runningAsyncCalls) {
                f11.f().cancel();
            }
            for (a cancel : this.runningSyncCalls) {
                cancel.cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueue(a.b bVar) {
        synchronized (this) {
            this.readyAsyncCalls.add(bVar);
        }
        promoteAndExecute();
    }

    /* access modifiers changed from: package-private */
    public synchronized void executed(a aVar) {
        this.runningSyncCalls.add(aVar);
    }

    public synchronized ExecutorService executorService() {
        try {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.executorService;
    }

    /* access modifiers changed from: package-private */
    public void finished(a.b bVar) {
        finished(this.runningAsyncCalls, bVar);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (a.b f10 : this.readyAsyncCalls) {
                arrayList.add(f10.f());
            }
        } catch (Throwable th) {
            throw th;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(this.runningSyncCalls);
            for (a.b f10 : this.runningAsyncCalls) {
                arrayList.add(f10.f());
            }
        } catch (Throwable th) {
            throw th;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequests = i10;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i10);
    }

    public void setMaxRequestsPerHost(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i10;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i10);
    }

    /* access modifiers changed from: package-private */
    public void finished(a aVar) {
        finished(this.runningSyncCalls, aVar);
    }

    private <T> void finished(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t10)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    public Dispatcher() {
    }
}
