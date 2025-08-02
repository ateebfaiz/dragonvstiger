package com.geetest.gtc4;

import a9.b;
import android.content.Context;
import com.geetest.gtc4.GeeGuard;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f6283a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f6284a = new c();
    }

    public void a(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            this.f6283a = str;
            new Thread(new b(this, context)).start();
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        String str = this.f6283a;
        if (str != null && !str.isEmpty()) {
            b.a(context, this.f6283a, (String) null, 5000, (GeeGuard.CallbackHandler) null);
        }
    }
}
