package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f6610a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6611b;

    /* renamed from: c  reason: collision with root package name */
    final CountDownLatch f6612c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    boolean f6613d = false;

    public b(AdvertisingIdClient advertisingIdClient, long j10) {
        this.f6610a = new WeakReference(advertisingIdClient);
        this.f6611b = j10;
        start();
    }

    private final void a() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f6610a.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.zza();
            this.f6613d = true;
        }
    }

    public final void run() {
        try {
            if (!this.f6612c.await(this.f6611b, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
