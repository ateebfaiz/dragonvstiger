package com.geetest.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Objects;

public class x5 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6215a;

    /* renamed from: b  reason: collision with root package name */
    public final b5 f6216b;

    /* renamed from: c  reason: collision with root package name */
    public final a f6217c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws d5, RemoteException;
    }

    public x5(Context context, b5 b5Var, a aVar) {
        if (context instanceof Application) {
            this.f6215a = context;
        } else {
            this.f6215a = context.getApplicationContext();
        }
        this.f6216b = b5Var;
        this.f6217c = aVar;
    }

    public static void a(Context context, Intent intent, b5 b5Var, a aVar) {
        x5 x5Var = new x5(context, b5Var, aVar);
        try {
            if (x5Var.f6215a.bindService(intent, x5Var, 1)) {
                Objects.toString(intent);
                return;
            }
            throw new d5("Service binding failed");
        } catch (Exception unused) {
            ((z4) x5Var.f6216b).f6235b.countDown();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        ((com.geetest.core.z4) r4.f6216b).f6235b.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.f6215a.unbindService(r4);
        r6 = new java.lang.StringBuilder();
        r6.append("Service has been unbound: ");
        r6.append(r5.getClassName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.f6215a.unbindService(r4);
        r5.getClassName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Service has been unbound: "
            r5.getClassName()
            com.geetest.core.x5$a r1 = r4.f6217c     // Catch:{ Exception -> 0x0040 }
            java.lang.String r6 = r1.a(r6)     // Catch:{ Exception -> 0x0040 }
            if (r6 == 0) goto L_0x0038
            int r1 = r6.length()     // Catch:{ Exception -> 0x0040 }
            if (r1 == 0) goto L_0x0038
            com.geetest.core.b5 r1 = r4.f6216b     // Catch:{ Exception -> 0x0040 }
            com.geetest.core.z4 r1 = (com.geetest.core.z4) r1     // Catch:{ Exception -> 0x0040 }
            java.lang.String[] r2 = r1.f6234a     // Catch:{ Exception -> 0x0040 }
            r3 = 0
            r2[r3] = r6     // Catch:{ Exception -> 0x0040 }
            java.util.concurrent.CountDownLatch r6 = r1.f6235b     // Catch:{ Exception -> 0x0040 }
            r6.countDown()     // Catch:{ Exception -> 0x0040 }
            android.content.Context r6 = r4.f6215a     // Catch:{ Exception -> 0x005d }
            r6.unbindService(r4)     // Catch:{ Exception -> 0x005d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r6.<init>()     // Catch:{ Exception -> 0x005d }
            r6.append(r0)     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = r5.getClassName()     // Catch:{ Exception -> 0x005d }
            r6.append(r5)     // Catch:{ Exception -> 0x005d }
            goto L_0x005d
        L_0x0036:
            r6 = move-exception
            goto L_0x005e
        L_0x0038:
            com.geetest.core.d5 r6 = new com.geetest.core.d5     // Catch:{ Exception -> 0x0040 }
            java.lang.String r1 = "OAID/AAID acquire failed"
            r6.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0040 }
            throw r6     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            com.geetest.core.b5 r6 = r4.f6216b     // Catch:{ all -> 0x0036 }
            com.geetest.core.z4 r6 = (com.geetest.core.z4) r6     // Catch:{ all -> 0x0036 }
            java.util.concurrent.CountDownLatch r6 = r6.f6235b     // Catch:{ all -> 0x0036 }
            r6.countDown()     // Catch:{ all -> 0x0036 }
            android.content.Context r6 = r4.f6215a     // Catch:{ Exception -> 0x005d }
            r6.unbindService(r4)     // Catch:{ Exception -> 0x005d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r6.<init>()     // Catch:{ Exception -> 0x005d }
            r6.append(r0)     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = r5.getClassName()     // Catch:{ Exception -> 0x005d }
            r6.append(r5)     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            return
        L_0x005e:
            android.content.Context r0 = r4.f6215a     // Catch:{ Exception -> 0x0066 }
            r0.unbindService(r4)     // Catch:{ Exception -> 0x0066 }
            r5.getClassName()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.x5.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
