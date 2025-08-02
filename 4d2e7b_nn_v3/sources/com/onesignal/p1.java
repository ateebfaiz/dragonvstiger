package com.onesignal;

import oa.a;

class p1 {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f10959b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private o1 f10960a;

    p1() {
    }

    public o1 a(v3 v3Var, d3 d3Var, c2 c2Var, y2 y2Var, a aVar) {
        if (this.f10960a == null) {
            synchronized (f10959b) {
                try {
                    if (this.f10960a == null) {
                        this.f10960a = new o1(v3Var, d3Var, c2Var, y2Var, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10960a;
    }
}
