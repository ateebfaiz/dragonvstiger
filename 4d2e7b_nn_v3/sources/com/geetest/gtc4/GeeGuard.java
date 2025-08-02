package com.geetest.gtc4;

import android.content.Context;
import com.geetest.gtc4.c;

public class GeeGuard {

    public interface CallbackHandler {
        void onCompletion(Integer num, GeeGuardReceipt geeGuardReceipt);
    }

    public static GeeGuardReceipt fetchReceipt(Context context, String str) {
        c cVar = c.a.f6284a;
        String str2 = cVar.f6283a;
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        return b.a(context, cVar.f6283a, str);
    }

    @Deprecated
    public static String getData(Context context, GeeGuardConfiguration geeGuardConfiguration) {
        return Core.getData(context.getApplicationContext(), geeGuardConfiguration);
    }

    public static boolean getLogEnabled() {
        return a.f6282a;
    }

    public static String getVersion() {
        return "2.3.0.3";
    }

    public static void register(Context context, String str) {
        c.a.f6284a.a(context, str);
    }

    public static void setLogEnabled(boolean z10) {
        a.f6282a = z10;
    }

    public static void submitReceipt(Context context, String str, int i10, CallbackHandler callbackHandler) {
        c cVar = c.a.f6284a;
        String str2 = cVar.f6283a;
        if (str2 != null && !str2.isEmpty()) {
            b.a(context, cVar.f6283a, str, i10, callbackHandler);
        }
    }

    @Deprecated
    public static GeeGuardReceipt fetchReceipt(Context context, String str, String str2) {
        return b.a(context, str, str2);
    }

    public static void submitReceipt(Context context, String str, CallbackHandler callbackHandler) {
        c cVar = c.a.f6284a;
        String str2 = cVar.f6283a;
        if (str2 != null && !str2.isEmpty()) {
            b.a(context, cVar.f6283a, str, 5000, callbackHandler);
        }
    }

    @Deprecated
    public static void submitReceipt(Context context, String str, String str2, int i10, CallbackHandler callbackHandler) {
        b.a(context, str, str2, i10, callbackHandler);
    }

    @Deprecated
    public static void submitReceipt(Context context, String str, String str2, CallbackHandler callbackHandler) {
        b.a(context, str, str2, 5000, callbackHandler);
    }
}
