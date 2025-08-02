package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.n;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.jvm.internal.m;

public abstract class q implements p {

    /* renamed from: c  reason: collision with root package name */
    public static final a f18557c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public q f18558b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static void a(n nVar, boolean z10, String str) {
        m.f(nVar, "request");
        m.f(str, DbParams.KEY_CHANNEL_RESULT);
        if (!nVar.a()) {
            if (z10) {
                nVar.c();
            }
            m.f(str, DbParams.KEY_CHANNEL_RESULT);
            try {
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = nVar.f18545h;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new n.c(nVar, z10, str));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                BOCaptchaClient.OnSuccessListener onSuccessListener = nVar.f18542e;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(z10, str);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void b(n nVar) {
        q qVar = this;
        do {
            m.f(nVar, "request");
            if (!nVar.a()) {
                if (qVar.a() >= nVar.f18540c) {
                    qVar.a(nVar);
                    return;
                }
                qVar = qVar.f18558b;
            } else {
                return;
            }
        } while (qVar != null);
    }

    public static void a(n nVar, String str) {
        m.f(nVar, "request");
        m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (!nVar.a()) {
            af afVar = af.f18475a;
            af.b("HandlerImpl.onFailure: ".concat(String.valueOf(str)));
            if (nVar.f18539b == u.FAIL) {
                nVar.c();
                nVar.a(str);
            }
        }
    }
}
