package com.onesignal;

import android.content.Context;
import androidx.work.WorkRequest;
import com.huawei.hms.common.ApiException;
import com.onesignal.g4;
import com.onesignal.o3;

class k4 implements g4 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10742a;

    /* renamed from: b  reason: collision with root package name */
    private static g4.a f10743b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10744a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g4.a f10745b;

        a(Context context, g4.a aVar) {
            this.f10744a = context;
            this.f10745b = aVar;
        }

        public void run() {
            int i10;
            try {
                k4.this.d(this.f10744a, this.f10745b);
            } catch (ApiException e10) {
                o3.b(o3.v.ERROR, "HMS ApiException getting Huawei push token!", e10);
                if (e10.getStatusCode() == 907135000) {
                    i10 = -26;
                } else {
                    i10 = -27;
                }
                this.f10745b.a((String) null, i10);
            }
        }
    }

    k4() {
    }

    private static void c() {
        try {
            Thread.sleep(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(android.content.Context r4, com.onesignal.g4.a r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.onesignal.OSUtils.p()     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0011
            r4 = 0
            r0 = -28
            r5.a(r4, r0)     // Catch:{ all -> 0x000f }
            monitor-exit(r3)
            return
        L_0x000f:
            r4 = move-exception
            goto L_0x004b
        L_0x0011:
            com.huawei.agconnect.config.AGConnectServicesConfig r0 = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(r4)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "client/app_id"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x000f }
            com.huawei.hms.aaid.HmsInstanceId r4 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r4)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "HCM"
            java.lang.String r4 = r4.getToken(r0, r1)     // Catch:{ all -> 0x000f }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0046
            com.onesignal.o3$v r0 = com.onesignal.o3.v.INFO     // Catch:{ all -> 0x000f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
            r1.<init>()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "Device registered for HMS, push token = "
            r1.append(r2)     // Catch:{ all -> 0x000f }
            r1.append(r4)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000f }
            com.onesignal.o3.a(r0, r1)     // Catch:{ all -> 0x000f }
            r0 = 1
            r5.a(r4, r0)     // Catch:{ all -> 0x000f }
            goto L_0x0049
        L_0x0046:
            r3.e(r5)     // Catch:{ all -> 0x000f }
        L_0x0049:
            monitor-exit(r3)
            return
        L_0x004b:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.k4.d(android.content.Context, com.onesignal.g4$a):void");
    }

    private void e(g4.a aVar) {
        c();
        if (!f10742a) {
            o3.a(o3.v.ERROR, "HmsMessageServiceOneSignal.onNewToken timed out.");
            aVar.a((String) null, -25);
        }
    }

    public void a(Context context, String str, g4.a aVar) {
        f10743b = aVar;
        new Thread(new a(context, aVar), "OS_HMS_GET_TOKEN").start();
    }
}
