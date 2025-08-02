package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f9253a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9254b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9255c;

    /* renamed from: d  reason: collision with root package name */
    final ArrayDeque f9256d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    private final Executor f9257e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9258f = false;

    private m0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f9253a = sharedPreferences;
        this.f9254b = str;
        this.f9255c = str2;
        this.f9257e = executor;
    }

    private boolean c(boolean z10) {
        if (z10 && !this.f9258f) {
            j();
        }
        return z10;
    }

    static m0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        m0 m0Var = new m0(sharedPreferences, str, str2, executor);
        m0Var.e();
        return m0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r6 = this;
            java.util.ArrayDeque r0 = r6.f9256d
            monitor-enter(r0)
            java.util.ArrayDeque r1 = r6.f9256d     // Catch:{ all -> 0x0033 }
            r1.clear()     // Catch:{ all -> 0x0033 }
            android.content.SharedPreferences r1 = r6.f9253a     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = r6.f9254b     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = r6.f9255c     // Catch:{ all -> 0x0033 }
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0021
            goto L_0x004b
        L_0x0021:
            java.lang.String r2 = r6.f9255c     // Catch:{ all -> 0x0033 }
            r3 = -1
            java.lang.String[] r1 = r1.split(r2, r3)     // Catch:{ all -> 0x0033 }
            int r2 = r1.length     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = "FirebaseMessaging"
            java.lang.String r3 = "Corrupted queue. Please check the queue contents and item separator provided"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0035
        L_0x0033:
            r1 = move-exception
            goto L_0x004d
        L_0x0035:
            int r2 = r1.length     // Catch:{ all -> 0x0033 }
            r3 = 0
        L_0x0037:
            if (r3 >= r2) goto L_0x0049
            r4 = r1[r3]     // Catch:{ all -> 0x0033 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0033 }
            if (r5 != 0) goto L_0x0046
            java.util.ArrayDeque r5 = r6.f9256d     // Catch:{ all -> 0x0033 }
            r5.add(r4)     // Catch:{ all -> 0x0033 }
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x0037
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.m0.e():void");
    }

    /* access modifiers changed from: private */
    public void i() {
        synchronized (this.f9256d) {
            this.f9253a.edit().putString(this.f9254b, h()).commit();
        }
    }

    private void j() {
        this.f9257e.execute(new l0(this));
    }

    public boolean b(String str) {
        boolean c10;
        if (TextUtils.isEmpty(str) || str.contains(this.f9255c)) {
            return false;
        }
        synchronized (this.f9256d) {
            c10 = c(this.f9256d.add(str));
        }
        return c10;
    }

    public String f() {
        String str;
        synchronized (this.f9256d) {
            str = (String) this.f9256d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean c10;
        synchronized (this.f9256d) {
            c10 = c(this.f9256d.remove(obj));
        }
        return c10;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f9256d.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(this.f9255c);
        }
        return sb2.toString();
    }
}
