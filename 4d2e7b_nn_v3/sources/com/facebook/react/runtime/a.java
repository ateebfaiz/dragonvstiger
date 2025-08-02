package com.facebook.react.runtime;

class a {

    /* renamed from: a  reason: collision with root package name */
    volatile Object f3418a;

    /* renamed from: b  reason: collision with root package name */
    Object f3419b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f3420c;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f3421d;

    /* renamed from: com.facebook.react.runtime.a$a  reason: collision with other inner class name */
    interface C0054a {
        Object get();
    }

    enum b {
        Init,
        Creating,
        Success,
        Failure
    }

    public a(Object obj) {
        this.f3418a = obj;
        this.f3419b = obj;
        this.f3420c = b.Init;
        this.f3421d = "";
    }

    public synchronized Object a() {
        return p5.a.c(this.f3418a);
    }

    public synchronized Object b() {
        return this.f3418a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r0 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.f3418a = r6.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r5.f3420c = r1;
        notifyAll();
        r6 = a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r5.f3420c = com.facebook.react.runtime.a.b.f3425d;
        r5.f3421d = java.util.Objects.toString(r6.getMessage(), "null");
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        throw new java.lang.RuntimeException("BridgelessAtomicRef: Failed to create object.", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005c, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        if (r5.f3420c != com.facebook.react.runtime.a.b.f3423b) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0069, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006b, code lost:
        if (r4 == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0078, code lost:
        if (r5.f3420c == com.facebook.react.runtime.a.b.f3425d) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x007a, code lost:
        r6 = a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007e, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007f, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0098, code lost:
        throw new java.lang.RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + r5.f3421d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(com.facebook.react.runtime.a.C0054a r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.facebook.react.runtime.a$b r0 = r5.f3420c     // Catch:{ all -> 0x000d }
            com.facebook.react.runtime.a$b r1 = com.facebook.react.runtime.a.b.Success     // Catch:{ all -> 0x000d }
            if (r0 != r1) goto L_0x0010
            java.lang.Object r6 = r5.a()     // Catch:{ all -> 0x000d }
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            return r6
        L_0x000d:
            r6 = move-exception
            goto L_0x00b4
        L_0x0010:
            com.facebook.react.runtime.a$b r0 = r5.f3420c     // Catch:{ all -> 0x000d }
            com.facebook.react.runtime.a$b r2 = com.facebook.react.runtime.a.b.Failure     // Catch:{ all -> 0x000d }
            if (r0 == r2) goto L_0x009b
            com.facebook.react.runtime.a$b r0 = r5.f3420c     // Catch:{ all -> 0x000d }
            com.facebook.react.runtime.a$b r2 = com.facebook.react.runtime.a.b.Creating     // Catch:{ all -> 0x000d }
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x0022
            r5.f3420c = r2     // Catch:{ all -> 0x000d }
            r0 = r3
            goto L_0x0023
        L_0x0022:
            r0 = r4
        L_0x0023:
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x005c
            java.lang.Object r6 = r6.get()     // Catch:{ RuntimeException -> 0x003b }
            r5.f3418a = r6     // Catch:{ RuntimeException -> 0x003b }
            monitor-enter(r5)     // Catch:{ RuntimeException -> 0x003b }
            r5.f3420c = r1     // Catch:{ all -> 0x0038 }
            r5.notifyAll()     // Catch:{ all -> 0x0038 }
            java.lang.Object r6 = r5.a()     // Catch:{ all -> 0x0038 }
            monitor-exit(r5)     // Catch:{ all -> 0x0038 }
            return r6
        L_0x0038:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0038 }
            throw r6     // Catch:{ RuntimeException -> 0x003b }
        L_0x003b:
            r6 = move-exception
            monitor-enter(r5)
            com.facebook.react.runtime.a$b r0 = com.facebook.react.runtime.a.b.Failure     // Catch:{ all -> 0x0059 }
            r5.f3420c = r0     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "null"
            java.lang.String r0 = java.util.Objects.toString(r0, r1)     // Catch:{ all -> 0x0059 }
            r5.f3421d = r0     // Catch:{ all -> 0x0059 }
            r5.notifyAll()     // Catch:{ all -> 0x0059 }
            monitor-exit(r5)     // Catch:{ all -> 0x0059 }
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "BridgelessAtomicRef: Failed to create object."
            r0.<init>(r1, r6)
            throw r0
        L_0x0059:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0059 }
            throw r6
        L_0x005c:
            monitor-enter(r5)
        L_0x005d:
            com.facebook.react.runtime.a$b r6 = r5.f3420c     // Catch:{ all -> 0x0067 }
            com.facebook.react.runtime.a$b r0 = com.facebook.react.runtime.a.b.Creating     // Catch:{ all -> 0x0067 }
            if (r6 != r0) goto L_0x006b
            r5.wait()     // Catch:{ InterruptedException -> 0x0069 }
            goto L_0x005d
        L_0x0067:
            r6 = move-exception
            goto L_0x0099
        L_0x0069:
            r4 = r3
            goto L_0x005d
        L_0x006b:
            if (r4 == 0) goto L_0x0074
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0067 }
            r6.interrupt()     // Catch:{ all -> 0x0067 }
        L_0x0074:
            com.facebook.react.runtime.a$b r6 = r5.f3420c     // Catch:{ all -> 0x0067 }
            com.facebook.react.runtime.a$b r0 = com.facebook.react.runtime.a.b.Failure     // Catch:{ all -> 0x0067 }
            if (r6 == r0) goto L_0x0080
            java.lang.Object r6 = r5.a()     // Catch:{ all -> 0x0067 }
            monitor-exit(r5)     // Catch:{ all -> 0x0067 }
            return r6
        L_0x0080:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r0.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = "BridgelessAtomicRef: Failed to create object. Reason: "
            r0.append(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r5.f3421d     // Catch:{ all -> 0x0067 }
            r0.append(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0067 }
            r6.<init>(r0)     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0099:
            monitor-exit(r5)     // Catch:{ all -> 0x0067 }
            throw r6
        L_0x009b:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x000d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            r0.<init>()     // Catch:{ all -> 0x000d }
            java.lang.String r1 = "BridgelessAtomicRef: Failed to create object. Reason: "
            r0.append(r1)     // Catch:{ all -> 0x000d }
            java.lang.String r1 = r5.f3421d     // Catch:{ all -> 0x000d }
            r0.append(r1)     // Catch:{ all -> 0x000d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x000d }
            r6.<init>(r0)     // Catch:{ all -> 0x000d }
            throw r6     // Catch:{ all -> 0x000d }
        L_0x00b4:
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.runtime.a.c(com.facebook.react.runtime.a$a):java.lang.Object");
    }

    public synchronized void d() {
        this.f3418a = this.f3419b;
        this.f3420c = b.Init;
        this.f3421d = "";
    }

    public a() {
        this((Object) null);
    }
}
