package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.l0;
import com.onesignal.o3;
import org.json.JSONObject;

public class ADMMessageHandler extends ADMMessageHandlerBase {
    private static final int JOB_ID = 123891;

    class a implements l0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f10250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f10251b;

        a(Bundle bundle, Context context) {
            this.f10250a = bundle;
            this.f10251b = context;
        }

        public void a(l0.f fVar) {
            if (!fVar.c()) {
                JSONObject a10 = l0.a(this.f10250a);
                d2 d2Var = new d2(a10);
                i2 i2Var = new i2(this.f10251b);
                i2Var.q(a10);
                i2Var.o(this.f10251b);
                i2Var.r(d2Var);
                l0.m(i2Var, true);
            }
        }
    }

    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    /* access modifiers changed from: protected */
    public void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        l0.h(applicationContext, extras, new a(extras, applicationContext));
    }

    /* access modifiers changed from: protected */
    public void onRegistered(String str) {
        o3.v vVar = o3.v.INFO;
        o3.a(vVar, "ADM registration ID: " + str);
        h4.c(str);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(String str) {
        o3.v vVar = o3.v.ERROR;
        o3.a(vVar, "ADM:onRegistrationError: " + str);
        if ("INVALID_SENDER".equals(str)) {
            o3.a(vVar, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        h4.c((String) null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(String str) {
        o3.v vVar = o3.v.INFO;
        o3.a(vVar, "ADM:onUnregistered: " + str);
    }
}
