package com.facebook.share.internal;

import q5.g;

public enum o implements g {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4549a;

    private o(int i10) {
        this.f4549a = i10;
    }

    public int a() {
        return this.f4549a;
    }

    public String b() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }
}
