package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f11099a = new x();

    private x() {
    }

    private final Intent b(Uri uri) {
        if (uri == null) {
            return null;
        }
        return OSUtils.O(uri);
    }

    private final boolean c(boolean z10, JSONObject jSONObject) {
        boolean z11;
        if (u1.a(jSONObject) != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return z10 | z11;
    }

    public final w a(Context context, JSONObject jSONObject) {
        m.f(context, "context");
        m.f(jSONObject, "fcmPayload");
        l2 l2Var = new l2(context, jSONObject);
        return new w(context, b(l2Var.b()), c(l2Var.a(), jSONObject));
    }
}
