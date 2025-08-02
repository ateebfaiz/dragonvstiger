package com.geetest.captcha;

import android.content.Context;

public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f5795a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f5796b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f5797c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f5798d;

    public f(g gVar, Context context, v vVar, z zVar) {
        this.f5795a = gVar;
        this.f5796b = context;
        this.f5797c = vVar;
        this.f5798d = zVar;
    }

    public final void run() {
        try {
            this.f5795a.b(this.f5796b, this.f5797c, this.f5798d);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
