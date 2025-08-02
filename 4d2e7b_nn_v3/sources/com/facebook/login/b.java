package com.facebook.login;

public enum b {
    NONE((String) null),
    ONLY_ME("only_me"),
    FRIENDS("friends"),
    EVERYONE("everyone");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f20484a;

    private b(String str) {
        this.f20484a = str;
    }

    public final String a() {
        return this.f20484a;
    }
}
