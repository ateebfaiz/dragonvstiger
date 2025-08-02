package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;

public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f5855a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5857c;

    public q(p pVar, boolean z10, String str) {
        this.f5855a = pVar;
        this.f5856b = z10;
        this.f5857c = str;
    }

    public final void run() {
        GTCaptcha4Client.OnSuccessListener onSuccessListener = this.f5855a.f5848d;
        if (onSuccessListener != null) {
            onSuccessListener.onSuccess(this.f5856b, this.f5857c);
        }
    }
}
