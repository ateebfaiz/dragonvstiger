package com.facebook.share.internal;

import q5.g;

public enum h implements g {
    MESSAGE_DIALOG(20140204),
    PHOTOS(20140324),
    VIDEO(20141218),
    MESSENGER_GENERIC_TEMPLATE(20171115),
    MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE(20171115),
    MESSENGER_MEDIA_TEMPLATE(20171115);
    

    /* renamed from: a  reason: collision with root package name */
    private int f4526a;

    private h(int i10) {
        this.f4526a = i10;
    }

    public int a() {
        return this.f4526a;
    }

    public String b() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }
}
