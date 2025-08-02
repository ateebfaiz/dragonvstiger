package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class q implements Subscriber, Publisher {

    /* renamed from: a  reason: collision with root package name */
    private final Map f8996a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue f8997b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f8998c;

    q(Executor executor) {
        this.f8998c = executor;
    }

    private synchronized Set c(Event event) {
        Set set;
        try {
            Map map = (Map) this.f8996a.get(event.getType());
            if (map == null) {
                set = Collections.emptySet();
            } else {
                set = map.entrySet();
            }
        } catch (Throwable th) {
            throw th;
        }
        return set;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Queue<Event> queue;
        synchronized (this) {
            try {
                queue = this.f8997b;
                if (queue != null) {
                    this.f8997b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (queue != null) {
            for (Event publish : queue) {
                publish(publish);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r0 = c(r5).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = (java.util.Map.Entry) r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(new com.google.firebase.components.p(r1, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publish(com.google.firebase.events.Event r5) {
        /*
            r4 = this;
            com.google.firebase.components.Preconditions.checkNotNull(r5)
            monitor-enter(r4)
            java.util.Queue r0 = r4.f8997b     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            r0.add(r5)     // Catch:{ all -> 0x000d }
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r5 = move-exception
            goto L_0x0034
        L_0x000f:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            java.util.Set r0 = r4.c(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            com.google.firebase.components.p r3 = new com.google.firebase.components.p
            r3.<init>(r1, r5)
            r2.execute(r3)
            goto L_0x0018
        L_0x0033:
            return
        L_0x0034:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.q.publish(com.google.firebase.events.Event):void");
    }

    public synchronized void subscribe(Class cls, Executor executor, EventHandler eventHandler) {
        try {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(eventHandler);
            Preconditions.checkNotNull(executor);
            if (!this.f8996a.containsKey(cls)) {
                this.f8996a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f8996a.get(cls)).put(eventHandler, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unsubscribe(java.lang.Class r2, com.google.firebase.events.EventHandler r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.firebase.components.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0028 }
            com.google.firebase.components.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0028 }
            java.util.Map r0 = r1.f8996a     // Catch:{ all -> 0x0028 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)
            return
        L_0x0011:
            java.util.Map r0 = r1.f8996a     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0028 }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x0028 }
            r0.remove(r3)     // Catch:{ all -> 0x0028 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            java.util.Map r3 = r1.f8996a     // Catch:{ all -> 0x0028 }
            r3.remove(r2)     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r2 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.q.unsubscribe(java.lang.Class, com.google.firebase.events.EventHandler):void");
    }

    public void subscribe(Class cls, EventHandler eventHandler) {
        subscribe(cls, this.f8998c, eventHandler);
    }
}
