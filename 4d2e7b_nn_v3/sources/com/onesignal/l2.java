package com.onesignal;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class l2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10769a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f10770b;

    public l2(Context context, JSONObject jSONObject) {
        m.f(context, "context");
        m.f(jSONObject, "fcmPayload");
        this.f10769a = context;
        this.f10770b = jSONObject;
    }

    public final boolean a() {
        if (!k2.f10738a.a(this.f10769a) || b() != null) {
            return false;
        }
        return true;
    }

    public final Uri b() {
        int i10;
        boolean z10;
        k2 k2Var = k2.f10738a;
        if (!k2Var.a(this.f10769a) || k2Var.b(this.f10769a)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(this.f10770b.optString("custom"));
        if (jSONObject.has("u")) {
            String optString = jSONObject.optString("u");
            if (!m.b(optString, "")) {
                m.e(optString, ImagesContract.URL);
                int length = optString.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    if (!z11) {
                        i10 = i11;
                    } else {
                        i10 = length;
                    }
                    if (m.g(optString.charAt(i10), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z11) {
                        if (!z10) {
                            z11 = true;
                        } else {
                            i11++;
                        }
                    } else if (!z10) {
                        break;
                    } else {
                        length--;
                    }
                }
                return Uri.parse(optString.subSequence(i11, length + 1).toString());
            }
        }
        return null;
    }
}
