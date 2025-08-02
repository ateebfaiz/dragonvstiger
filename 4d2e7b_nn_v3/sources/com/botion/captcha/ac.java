package com.botion.captcha;

import android.content.Context;
import kotlin.jvm.internal.m;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f18460a = new ac();

    /* renamed from: b  reason: collision with root package name */
    private static String f18461b = "Loading in trouble";

    /* renamed from: c  reason: collision with root package name */
    private static String f18462c = "Network error";

    /* renamed from: d  reason: collision with root package name */
    private static String f18463d = "Timeout of Network connection";

    /* renamed from: e  reason: collision with root package name */
    private static String f18464e = "Certificate error";

    /* renamed from: f  reason: collision with root package name */
    private static String f18465f = "Certificate expired";

    /* renamed from: g  reason: collision with root package name */
    private static String f18466g = "Illegal parameter";

    /* renamed from: h  reason: collision with root package name */
    private static String f18467h = "Captcha session is canceled";

    /* renamed from: i  reason: collision with root package name */
    private static String f18468i = "Unsupported WebView Component";

    private ac() {
    }

    public static String a() {
        return f18461b;
    }

    public static String b() {
        return f18464e;
    }

    public static String c() {
        return f18466g;
    }

    public static String d() {
        return f18467h;
    }

    public static String e() {
        return f18468i;
    }

    public static void a(Context context) {
        m.f(context, "context");
        String string = context.getApplicationContext().getString(ae.a(context, "boc_web_callback_error"));
        m.e(string, "context.applicationConte…boc_web_callback_error\"))");
        f18461b = string;
        String string2 = context.getApplicationContext().getString(ae.a(context, "boc_web_view_load_error"));
        m.e(string2, "context.applicationConte…oc_web_view_load_error\"))");
        f18462c = string2;
        String string3 = context.getApplicationContext().getString(ae.a(context, "boc_web_view_ssl_error"));
        m.e(string3, "context.applicationConte…boc_web_view_ssl_error\"))");
        f18464e = string3;
        String string4 = context.getApplicationContext().getString(ae.a(context, "boc_parameter_config_error"));
        m.e(string4, "context.applicationConte…parameter_config_error\"))");
        f18466g = string4;
        String string5 = context.getApplicationContext().getString(ae.a(context, "boc_user_cancel"));
        m.e(string5, "context.applicationConte…text, \"boc_user_cancel\"))");
        f18467h = string5;
        String string6 = context.getApplicationContext().getString(ae.a(context, "boc_device_not_supported"));
        m.e(string6, "context.applicationConte…c_device_not_supported\"))");
        f18468i = string6;
    }
}
