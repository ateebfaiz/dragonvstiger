package com.geetest.core;

import android.content.Context;
import com.geetest.core.e;

public class GeeGuard {

    public interface CallbackHandler {
        void onCompletion(Integer num, GeeGuardReceipt geeGuardReceipt);
    }

    public static GeeGuardReceipt fetchReceipt(Context context, String str) {
        e eVar = e.a.f5958a;
        String str2 = eVar.f5956a;
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        return c.a(context, eVar.f5956a, str);
    }

    @Deprecated
    public static String getData(Context context, GeeGuardConfiguration geeGuardConfiguration) {
        return Core.getData(context.getApplicationContext(), geeGuardConfiguration);
    }

    public static boolean getLogEnabled() {
        return a.f5898a;
    }

    public static String getVersion() {
        return "2.6.2.2";
    }

    public static void register(Context context, String str) {
        e.a.f5958a.a(context, str, (String) null, (CallbackHandler) null);
    }

    public static void setLogEnabled(boolean z10) {
        a.f5898a = z10;
    }

    public static void submitReceipt(Context context, String str, int i10, CallbackHandler callbackHandler) {
        e.a.f5958a.b(context, str, i10, callbackHandler);
    }

    public static void register(Context context, String str, CallbackHandler callbackHandler) {
        e.a.f5958a.a(context, str, (String) null, callbackHandler);
    }

    public static void submitReceipt(Context context, String str, CallbackHandler callbackHandler) {
        e.a.f5958a.b(context, str, 5000, callbackHandler);
    }

    public static void register(Context context, String str, String str2) {
        e.a.f5958a.a(context, str, str2, (CallbackHandler) null);
    }

    @Deprecated
    public static void submitReceipt(Context context, String str, String str2, int i10, CallbackHandler callbackHandler) {
        c.a(context, str, str2, i10, "https://riskct.geetest.com/g2/api/v1/client_report", callbackHandler);
    }

    @Deprecated
    public static GeeGuardReceipt fetchReceipt(Context context, String str, String str2) {
        return c.a(context, str, str2);
    }

    @Deprecated
    public static void submitReceipt(Context context, String str, String str2, CallbackHandler callbackHandler) {
        c.a(context, str, str2, 5000, "https://riskct.geetest.com/g2/api/v1/client_report", callbackHandler);
    }
}
