package com.geetest.core;

import android.content.Context;

public class c6 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5947a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f5948b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5949c;

    public c6(Context context) {
        this.f5947a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f5948b = cls;
            this.f5949c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    public boolean a() {
        return this.f5949c != null;
    }

    public void a(b5 b5Var) {
        if (this.f5947a != null && b5Var != null) {
            Class<?> cls = this.f5948b;
            if (cls == null || this.f5949c == null) {
                new d5("Xiaomi IdProvider not exists");
                ((z4) b5Var).f6235b.countDown();
                return;
            }
            try {
                String str = (String) cls.getMethod("getOAID", new Class[]{Context.class}).invoke(this.f5949c, new Object[]{this.f5947a});
                if (str == null || str.length() == 0) {
                    throw new d5("OAID query failed");
                }
                z4 z4Var = (z4) b5Var;
                z4Var.f6234a[0] = str;
                z4Var.f6235b.countDown();
            } catch (Exception unused) {
                ((z4) b5Var).f6235b.countDown();
            }
        }
    }
}
