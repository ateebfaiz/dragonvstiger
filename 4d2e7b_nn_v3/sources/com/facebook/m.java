package com.facebook;

public final class m extends l {

    /* renamed from: b  reason: collision with root package name */
    private final t f20670b;

    public m(t tVar, String str) {
        super(str);
        this.f20670b = tVar;
    }

    public String toString() {
        FacebookRequestError facebookRequestError;
        t tVar = this.f20670b;
        if (tVar != null) {
            facebookRequestError = tVar.b();
        } else {
            facebookRequestError = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{FacebookGraphResponseException: ");
        kotlin.jvm.internal.m.e(sb2, "StringBuilder().append(\"…raphResponseException: \")");
        String message = getMessage();
        if (message != null) {
            sb2.append(message);
            sb2.append(" ");
        }
        if (facebookRequestError != null) {
            sb2.append("httpResponseCode: ");
            sb2.append(facebookRequestError.g());
            sb2.append(", facebookErrorCode: ");
            sb2.append(facebookRequestError.b());
            sb2.append(", facebookErrorType: ");
            sb2.append(facebookRequestError.d());
            sb2.append(", message: ");
            sb2.append(facebookRequestError.c());
            sb2.append("}");
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.m.e(sb3, "errorStringBuilder.toString()");
        return sb3;
    }
}
