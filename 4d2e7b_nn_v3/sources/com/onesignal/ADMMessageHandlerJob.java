package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerJobBase;
import com.onesignal.l0;
import com.onesignal.o3;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class ADMMessageHandlerJob extends ADMMessageHandlerJobBase {

    public static final class a implements l0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f10253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f10254b;

        a(Bundle bundle, Context context) {
            this.f10253a = bundle;
            this.f10254b = context;
        }

        public void a(l0.f fVar) {
            if (fVar == null || !fVar.c()) {
                JSONObject a10 = l0.a(this.f10253a);
                m.e(a10, "bundleAsJSONObject(bundle)");
                d2 d2Var = new d2(a10);
                i2 i2Var = new i2(this.f10254b);
                Context context = this.f10254b;
                i2Var.q(a10);
                i2Var.o(context);
                i2Var.r(d2Var);
                l0.m(i2Var, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMessage(Context context, Intent intent) {
        Bundle bundle;
        if (intent == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        l0.h(context, bundle, new a(bundle, context));
    }

    /* access modifiers changed from: protected */
    public void onRegistered(Context context, String str) {
        o3.a(o3.v.INFO, m.n("ADM registration ID: ", str));
        h4.c(str);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(Context context, String str) {
        o3.v vVar = o3.v.ERROR;
        o3.a(vVar, m.n("ADM:onRegistrationError: ", str));
        if (m.b("INVALID_SENDER", str)) {
            o3.a(vVar, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        h4.c((String) null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(Context context, String str) {
        o3.a(o3.v.INFO, m.n("ADM:onUnregistered: ", str));
    }
}
