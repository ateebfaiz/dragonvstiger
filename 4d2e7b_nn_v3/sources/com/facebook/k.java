package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class k extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20370d = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f20371b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20372c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(String str, int i10, String str2) {
        super(str);
        this.f20371b = i10;
        this.f20372c = str2;
    }

    public String toString() {
        String str = "{FacebookDialogException: " + "errorCode: " + this.f20371b + ", message: " + getMessage() + ", url: " + this.f20372c + "}";
        m.e(str, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return str;
    }
}
