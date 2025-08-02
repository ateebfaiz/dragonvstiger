package com.geetest.core;

import android.content.Context;
import android.webkit.URLUtil;
import com.geetest.core.GeeGuard;
import java.lang.ref.WeakReference;
import z8.f;
import z8.g;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f5956a;

    /* renamed from: b  reason: collision with root package name */
    public String f5957b = "https://riskct.geetest.com/g2/api/v1/client_report";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f5958a = new e();
    }

    public void a(Context context, String str, String str2, GeeGuard.CallbackHandler callbackHandler) {
        if (str != null && !str.isEmpty()) {
            this.f5956a = str;
        }
        if (str2 != null && !str2.isEmpty() && URLUtil.isValidUrl(str2)) {
            this.f5957b = str2;
        }
        if (!this.f5957b.equals("https://riskct.geetest.com/g2/api/v1/client_report")) {
            new Thread(new f(this, context)).start();
        } else {
            new Thread(new g(this, context, callbackHandler)).start();
        }
    }

    public void b(Context context, String str, int i10, GeeGuard.CallbackHandler callbackHandler) {
        new Thread(new z8.e(this, context, str, i10, callbackHandler)).start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        b(context, (String) null, 5000, (GeeGuard.CallbackHandler) null);
    }

    /* access modifiers changed from: private */
    public void a(Context context, GeeGuard.CallbackHandler callbackHandler) {
        String str = this.f5956a;
        String str2 = this.f5957b;
        if (context == null) {
            a.a("Context is null", new IllegalArgumentException("Context is null"));
            if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        } else if (str == null) {
            a.a("Empty App ID", new IllegalArgumentException("Empty App ID"));
            if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        } else {
            GeeGuardReceipt a10 = c.a(context, str, (String) null);
            if (a10 != null) {
                try {
                    new g6().a((Context) new WeakReference(context).get(), new b(a10, str, str2, 5000, callbackHandler, context, (String) null));
                } catch (Exception unused) {
                    if (callbackHandler != null) {
                        callbackHandler.onCompletion(-300, a10);
                    }
                }
            } else if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, String str, int i10, GeeGuard.CallbackHandler callbackHandler) {
        c.a(context, this.f5956a, str, i10, this.f5957b, callbackHandler);
    }
}
