package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class j1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f18803a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18804b;

    public j1(String str, String str2) {
        this.f18803a = str;
        this.f18804b = str2;
    }

    public final String a() {
        return this.f18803a;
    }

    public final String b() {
        return this.f18804b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j1(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "https://notify.bugsnag.com" : str, (i10 & 2) != 0 ? "https://sessions.bugsnag.com" : str2);
    }
}
