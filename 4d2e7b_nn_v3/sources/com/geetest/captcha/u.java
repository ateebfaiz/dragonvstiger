package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.GTCaptcha4Client;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.jvm.internal.m;

public abstract class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public u f5862a;

    public void a(p pVar, boolean z10, String str) {
        m.f(pVar, "request");
        m.f(str, DbParams.KEY_CHANNEL_RESULT);
        if (!pVar.a()) {
            if (z10) {
                pVar.b();
            }
            m.f(str, DbParams.KEY_CHANNEL_RESULT);
            try {
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = pVar.f5851g;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new q(pVar, z10, str));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                GTCaptcha4Client.OnSuccessListener onSuccessListener = pVar.f5848d;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(z10, str);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void b(p pVar) {
        m.f(pVar, "request");
        if (!pVar.a()) {
            if (a() >= 0) {
                a(pVar);
                return;
            }
            u uVar = this.f5862a;
            if (uVar != null) {
                uVar.b(pVar);
            }
        }
    }

    public void a(p pVar, String str) {
        m.f(pVar, "request");
        m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (!pVar.a()) {
            h0 h0Var = h0.f5812d;
            h0Var.c("HandlerImpl.onFailure: " + str);
            if (pVar.f5846b == x.FAIL) {
                pVar.b();
                pVar.a(str);
            }
        }
    }
}
