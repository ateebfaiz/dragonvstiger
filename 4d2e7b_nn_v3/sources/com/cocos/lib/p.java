package com.cocos.lib;

import java.util.concurrent.CountDownLatch;

class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f19395a;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f19396b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19397c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19398d;

    p(CountDownLatch countDownLatch, boolean[] zArr, int i10, String str) {
        this.f19395a = countDownLatch;
        this.f19396b = zArr;
        this.f19397c = i10;
        this.f19398d = str;
    }

    public void run() {
        this.f19396b[0] = CocosWebViewHelper._shouldStartLoading(this.f19397c, this.f19398d);
        this.f19395a.countDown();
    }
}
