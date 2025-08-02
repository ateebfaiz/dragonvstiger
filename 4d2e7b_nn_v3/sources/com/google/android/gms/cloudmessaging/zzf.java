package com.google.android.gms.cloudmessaging;

import android.os.Handler;

public final /* synthetic */ class zzf implements Handler.Callback {
    public final /* synthetic */ c zza;

    public /* synthetic */ zzf(c cVar) {
        this.zza = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        r2.c(new com.google.android.gms.cloudmessaging.zzq(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        r2.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            com.google.android.gms.cloudmessaging.c r0 = r4.zza
            int r1 = r5.arg1
            java.lang.String r2 = "MessengerIpcClient"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)
            if (r2 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 41
            r2.<init>(r3)
            java.lang.String r3 = "Received response to request: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r3 = "MessengerIpcClient"
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r3, r2)
        L_0x0025:
            monitor-enter(r0)
            android.util.SparseArray r2 = r0.f6640e     // Catch:{ all -> 0x004a }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004a }
            com.google.android.gms.cloudmessaging.f r2 = (com.google.android.gms.cloudmessaging.f) r2     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x004c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r2 = 50
            r5.<init>(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "Received response for unknown request: "
            r5.append(r2)     // Catch:{ all -> 0x004a }
            r5.append(r1)     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "MessengerIpcClient"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004a }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x004a }
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            goto L_0x0072
        L_0x004a:
            r5 = move-exception
            goto L_0x0074
        L_0x004c:
            android.util.SparseArray r3 = r0.f6640e     // Catch:{ all -> 0x004a }
            r3.remove(r1)     // Catch:{ all -> 0x004a }
            r0.f()     // Catch:{ all -> 0x004a }
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.cloudmessaging.zzq r5 = new com.google.android.gms.cloudmessaging.zzq
            java.lang.String r0 = "Not supported by GmsCore"
            r1 = 0
            r3 = 4
            r5.<init>(r3, r0, r1)
            r2.c(r5)
            goto L_0x0072
        L_0x006f:
            r2.a(r5)
        L_0x0072:
            r5 = 1
            return r5
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.handleMessage(android.os.Message):boolean");
    }
}
