package com.geetest.captcha;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<z> f5883a = new ArrayList<>();

    public final void a(z zVar) {
        if (zVar != null) {
            synchronized (this.f5883a) {
                if (!this.f5883a.contains(zVar)) {
                    this.f5883a.add(zVar);
                } else {
                    throw new IllegalStateException(("Observer " + zVar + " is already registered.").toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The observer is null.".toString());
    }

    public final void a(String str, String str2, JSONObject jSONObject) {
        m.f(str, "errorCode");
        m.f(str2, "errorMsg");
        m.f(jSONObject, "errorDesc");
        Iterator<z> it = this.f5883a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, jSONObject);
        }
    }

    public final void a(boolean z10, String str) {
        m.f(str, DbParams.KEY_CHANNEL_RESULT);
        Iterator<z> it = this.f5883a.iterator();
        while (it.hasNext()) {
            it.next().a(z10, str);
        }
    }
}
