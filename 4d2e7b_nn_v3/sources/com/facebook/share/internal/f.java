package com.facebook.share.internal;

import q5.g;

public enum f implements g {
    LIKE_DIALOG(20140701);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4517a;

    private f(int i10) {
        this.f4517a = i10;
    }

    public int a() {
        return this.f4517a;
    }

    public String b() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }
}
