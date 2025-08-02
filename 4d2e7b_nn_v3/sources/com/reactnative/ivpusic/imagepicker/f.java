package com.reactnative.ivpusic.imagepicker;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import java.util.concurrent.atomic.AtomicInteger;

class f {

    /* renamed from: a  reason: collision with root package name */
    private Promise f11187a;

    /* renamed from: b  reason: collision with root package name */
    private int f11188b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11189c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicInteger f11190d;

    /* renamed from: e  reason: collision with root package name */
    private WritableArray f11191e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11192f;

    f() {
    }

    private synchronized boolean a() {
        if (this.f11192f) {
            Log.w("image-crop-picker", "Skipping result, already sent...");
            return false;
        } else if (this.f11187a != null) {
            return true;
        } else {
            Log.w("image-crop-picker", "Trying to notify success but promise is not set");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b(String str, String str2) {
        if (a()) {
            Log.e("image-crop-picker", "Promise rejected. " + str2);
            this.f11187a.reject(str, str2);
            this.f11192f = true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(String str, Throwable th) {
        if (a()) {
            Log.e("image-crop-picker", "Promise rejected. " + th.getMessage());
            this.f11187a.reject(str, th);
            this.f11192f = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(com.facebook.react.bridge.WritableMap r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.a()     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            boolean r0 = r2.f11189c     // Catch:{ all -> 0x0027 }
            r1 = 1
            if (r0 == 0) goto L_0x0029
            com.facebook.react.bridge.WritableArray r0 = r2.f11191e     // Catch:{ all -> 0x0027 }
            r0.pushMap(r3)     // Catch:{ all -> 0x0027 }
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f11190d     // Catch:{ all -> 0x0027 }
            int r3 = r3.addAndGet(r1)     // Catch:{ all -> 0x0027 }
            int r0 = r2.f11188b     // Catch:{ all -> 0x0027 }
            if (r3 != r0) goto L_0x0030
            com.facebook.react.bridge.Promise r3 = r2.f11187a     // Catch:{ all -> 0x0027 }
            com.facebook.react.bridge.WritableArray r0 = r2.f11191e     // Catch:{ all -> 0x0027 }
            r3.resolve(r0)     // Catch:{ all -> 0x0027 }
            r2.f11192f = r1     // Catch:{ all -> 0x0027 }
            goto L_0x0030
        L_0x0027:
            r3 = move-exception
            goto L_0x0032
        L_0x0029:
            com.facebook.react.bridge.Promise r0 = r2.f11187a     // Catch:{ all -> 0x0027 }
            r0.resolve(r3)     // Catch:{ all -> 0x0027 }
            r2.f11192f = r1     // Catch:{ all -> 0x0027 }
        L_0x0030:
            monitor-exit(r2)
            return
        L_0x0032:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.f.d(com.facebook.react.bridge.WritableMap):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void e(int i10) {
        this.f11188b = i10;
        this.f11190d = new AtomicInteger(0);
    }

    /* access modifiers changed from: package-private */
    public synchronized void f(Promise promise, boolean z10) {
        this.f11187a = promise;
        this.f11189c = z10;
        this.f11192f = false;
        this.f11188b = 0;
        this.f11190d = new AtomicInteger(0);
        if (z10) {
            this.f11191e = new WritableNativeArray();
        }
    }
}
