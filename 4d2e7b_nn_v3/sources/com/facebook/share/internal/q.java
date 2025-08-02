package com.facebook.share.internal;

import q5.g;

public enum q implements g {
    SHARE_STORY_ASSET(20170417);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4564a;

    private q(int i10) {
        this.f4564a = i10;
    }

    public int a() {
        return this.f4564a;
    }

    public String b() {
        return "com.facebook.platform.action.request.SHARE_STORY";
    }
}
