package com.geetest.core;

import java.util.concurrent.CountDownLatch;

public class z4 implements b5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f6234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f6235b;

    public z4(String[] strArr, CountDownLatch countDownLatch) {
        this.f6234a = strArr;
        this.f6235b = countDownLatch;
    }

    public void a(String str) {
        this.f6234a[0] = str;
        this.f6235b.countDown();
    }
}
