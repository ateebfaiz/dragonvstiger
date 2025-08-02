package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class q extends l {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20706c = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final FacebookRequestError f20707b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(FacebookRequestError facebookRequestError, String str) {
        super(str);
        m.f(facebookRequestError, "requestError");
        this.f20707b = facebookRequestError;
    }

    public final FacebookRequestError a() {
        return this.f20707b;
    }

    public String toString() {
        String str = "{FacebookServiceException: " + "httpResponseCode: " + this.f20707b.g() + ", facebookErrorCode: " + this.f20707b.b() + ", facebookErrorType: " + this.f20707b.d() + ", message: " + this.f20707b.c() + "}";
        m.e(str, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return str;
    }
}
