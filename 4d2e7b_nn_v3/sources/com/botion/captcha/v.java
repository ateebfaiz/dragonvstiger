package com.botion.captcha;

import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<w> f18577a = new ArrayList<>();

    public final void a(w wVar) {
        if (wVar != null) {
            synchronized (this.f18577a) {
                if (!this.f18577a.contains(wVar)) {
                    this.f18577a.add(wVar);
                } else {
                    throw new IllegalStateException(("Observer " + wVar + " is already registered.").toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The observer is null.".toString());
    }

    public final void b() {
        Iterator<w> it = this.f18577a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public final void a() {
        Iterator<w> it = this.f18577a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void a(String str) {
        m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Iterator<w> it = this.f18577a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject) {
        m.f(str, "errorCode");
        m.f(str2, "errorMsg");
        m.f(jSONObject, "errorDesc");
        Iterator<w> it = this.f18577a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, jSONObject);
        }
    }

    public final void a(boolean z10, String str) {
        m.f(str, DbParams.KEY_CHANNEL_RESULT);
        Iterator<w> it = this.f18577a.iterator();
        while (it.hasNext()) {
            it.next().a(z10, str);
        }
    }
}
