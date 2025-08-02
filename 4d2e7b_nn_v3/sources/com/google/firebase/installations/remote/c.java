package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class c {

    /* renamed from: d  reason: collision with root package name */
    private static final long f9171d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f9172e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final Utils f9173a = Utils.getInstance();

    /* renamed from: b  reason: collision with root package name */
    private long f9174b;

    /* renamed from: c  reason: collision with root package name */
    private int f9175c;

    c() {
    }

    private synchronized long a(int i10) {
        if (!c(i10)) {
            return f9171d;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.f9175c) + ((double) this.f9173a.getRandomDelayForSyncPrevention()), (double) f9172e);
    }

    private static boolean c(int i10) {
        return i10 == 429 || (i10 >= 500 && i10 < 600);
    }

    private static boolean d(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    private synchronized void e() {
        this.f9175c = 0;
    }

    public synchronized boolean b() {
        boolean z10;
        if (this.f9175c == 0 || this.f9173a.currentTimeInMillis() > this.f9174b) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f9175c++;
        this.f9174b = this.f9173a.currentTimeInMillis() + a(i10);
    }
}
