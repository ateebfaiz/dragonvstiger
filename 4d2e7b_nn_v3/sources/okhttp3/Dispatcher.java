package okhttp3;

import androidx.core.app.NotificationCompat;
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
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (m.b(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (m.b(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t10)) {
                runnable = this.idleCallback;
                Unit unit = Unit.f12577a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    private final boolean promoteAndExecute() {
        int i10;
        boolean z10;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                    m.e(it, "readyAsyncCalls.iterator()");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RealCall.AsyncCall next = it.next();
                        if (this.runningAsyncCalls.size() >= this.maxRequests) {
                            break;
                        } else if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                            it.remove();
                            next.getCallsPerHost().incrementAndGet();
                            m.e(next, "asyncCall");
                            arrayList.add(next);
                            this.runningAsyncCalls.add(next);
                        }
                    }
                    if (runningCallsCount() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Unit unit = Unit.f12577a;
                } finally {
                }
            }
            int size = arrayList.size();
            for (i10 = 0; i10 < size; i10++) {
                ((RealCall.AsyncCall) arrayList.get(i10)).executeOn(executorService());
            }
            return z10;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    /* renamed from: -deprecated_executorService  reason: not valid java name */
    public final ExecutorService m39deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        try {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                it.next().getCall().cancel();
            }
            Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
            while (it2.hasNext()) {
                it2.next().getCall().cancel();
            }
            Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
            while (it3.hasNext()) {
                it3.next().cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        m.f(asyncCall, NotificationCompat.CATEGORY_CALL);
        synchronized (this) {
            try {
                this.readyAsyncCalls.add(asyncCall);
                if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                    asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(RealCall realCall) {
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        this.runningSyncCalls.add(realCall);
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, synchronousQueue, Util.threadFactory(Util.okHttpName + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            m.c(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        m.f(asyncCall, NotificationCompat.CATEGORY_CALL);
        asyncCall.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
            ArrayList arrayList = new ArrayList(r.v(arrayDeque, 10));
            for (RealCall.AsyncCall call : arrayDeque) {
                arrayList.add(call.getCall());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
            m.e(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
            ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
            ArrayList arrayList = new ArrayList(r.v(arrayDeque2, 10));
            for (RealCall.AsyncCall call : arrayDeque2) {
                arrayList.add(call.getCall());
            }
            unmodifiableList = Collections.unmodifiableList(r.j0(arrayDeque, arrayList));
            m.e(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i10) {
        boolean z10 = true;
        if (i10 < 1) {
            z10 = false;
        }
        if (z10) {
            synchronized (this) {
                this.maxRequests = i10;
                Unit unit = Unit.f12577a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i10).toString());
    }

    public final void setMaxRequestsPerHost(int i10) {
        boolean z10 = true;
        if (i10 < 1) {
            z10 = false;
        }
        if (z10) {
            synchronized (this) {
                this.maxRequestsPerHost = i10;
                Unit unit = Unit.f12577a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i10).toString());
    }

    public final void finished$okhttp(RealCall realCall) {
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        finished(this.runningSyncCalls, realCall);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Dispatcher(ExecutorService executorService) {
        this();
        m.f(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }
}
