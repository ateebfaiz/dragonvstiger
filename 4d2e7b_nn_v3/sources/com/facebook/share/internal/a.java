package com.facebook.share.internal;

import q5.g;

public enum a implements g {
    SHARE_CAMERA_EFFECT(20170417);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4416a;

    private a(int i10) {
        this.f4416a = i10;
    }

    public int a() {
        return this.f4416a;
    }

    public String b() {
        return "com.facebook.platform.action.request.CAMERA_EFFECT";
    }
}
