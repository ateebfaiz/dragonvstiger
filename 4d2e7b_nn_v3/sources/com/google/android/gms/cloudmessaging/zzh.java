package com.google.android.gms.cloudmessaging;

public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ c zza;

    public /* synthetic */ zzh(c cVar) {
        this.zza = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(r3.length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        android.util.Log.d("MessengerIpcClient", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        r3 = r0.f6641f.zzb;
        r4 = r0.f6637b;
        r5 = android.os.Message.obtain();
        r5.what = r1.f6646c;
        r5.arg1 = r1.f6644a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.b());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.f6647d);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.f6638c.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a4, code lost:
        r0.a(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.cloudmessaging.c r0 = r8.zza
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.f6636a     // Catch:{ all -> 0x000a }
            r2 = 2
            if (r1 == r2) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r1 = move-exception
            goto L_0x00ad
        L_0x000d:
            java.util.Queue r1 = r0.f6639d     // Catch:{ all -> 0x000a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x001a
            r0.f()     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x001a:
            java.util.Queue r1 = r0.f6639d     // Catch:{ all -> 0x000a }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x000a }
            com.google.android.gms.cloudmessaging.f r1 = (com.google.android.gms.cloudmessaging.f) r1     // Catch:{ all -> 0x000a }
            android.util.SparseArray r3 = r0.f6640e     // Catch:{ all -> 0x000a }
            int r4 = r1.f6644a     // Catch:{ all -> 0x000a }
            r3.put(r4, r1)     // Catch:{ all -> 0x000a }
            com.google.android.gms.cloudmessaging.zzs r3 = r0.f6641f     // Catch:{ all -> 0x000a }
            java.util.concurrent.ScheduledExecutorService r3 = r3.zzc     // Catch:{ all -> 0x000a }
            com.google.android.gms.cloudmessaging.zzk r4 = new com.google.android.gms.cloudmessaging.zzk     // Catch:{ all -> 0x000a }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x000a }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x000a }
            r6 = 30
            r3.schedule(r4, r6, r5)     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r3 = "MessengerIpcClient"
            r4 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r4)
            if (r3 == 0) goto L_0x0065
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r4 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r4 = r4 + 8
            r5.<init>(r4)
            java.lang.String r4 = "Sending "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "MessengerIpcClient"
            java.lang.String r4 = r5.toString()
            android.util.Log.d(r3, r4)
        L_0x0065:
            com.google.android.gms.cloudmessaging.zzs r3 = r0.f6641f
            android.content.Context r3 = r3.zzb
            android.os.Messenger r4 = r0.f6637b
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.f6646c
            r5.what = r6
            int r6 = r1.f6644a
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = "oneWay"
            boolean r7 = r1.b()
            r4.putBoolean(r6, r7)
            java.lang.String r6 = "pkg"
            java.lang.String r3 = r3.getPackageName()
            r4.putString(r6, r3)
            java.lang.String r3 = "data"
            android.os.Bundle r1 = r1.f6647d
            r4.putBundle(r3, r1)
            r5.setData(r4)
            com.google.android.gms.cloudmessaging.d r1 = r0.f6638c     // Catch:{ RemoteException -> 0x00a3 }
            r1.a(r5)     // Catch:{ RemoteException -> 0x00a3 }
            goto L_0x0002
        L_0x00a3:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.a(r2, r1)
            goto L_0x0002
        L_0x00ad:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzh.run():void");
    }
}
