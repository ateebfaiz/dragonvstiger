package com.geetest.captcha;

import android.content.Context;
import kotlin.jvm.internal.m;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static String f5789a = "加载遇到一点麻烦";

    /* renamed from: b  reason: collision with root package name */
    public static String f5790b = "证书错误";

    /* renamed from: c  reason: collision with root package name */
    public static String f5791c = "参数不合法";

    /* renamed from: d  reason: collision with root package name */
    public static String f5792d = "验证会话已取消";

    /* renamed from: e  reason: collision with root package name */
    public static String f5793e = "不支持的 WebView 组件";

    /* renamed from: f  reason: collision with root package name */
    public static final e0 f5794f = new e0();

    public final void a(Context context) {
        m.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        g0 g0Var = g0.f5806a;
        String string = applicationContext.getString(g0Var.a(context, "gt4_web_callback_error"));
        m.e(string, "context.applicationConte…gt4_web_callback_error\"))");
        f5789a = string;
        m.e(context.getApplicationContext().getString(g0Var.a(context, "gt4_web_view_load_error")), "context.applicationConte…t4_web_view_load_error\"))");
        String string2 = context.getApplicationContext().getString(g0Var.a(context, "gt4_web_view_ssl_error"));
        m.e(string2, "context.applicationConte…gt4_web_view_ssl_error\"))");
        f5790b = string2;
        String string3 = context.getApplicationContext().getString(g0Var.a(context, "gt4_parameter_config_error"));
        m.e(string3, "context.applicationConte…parameter_config_error\"))");
        f5791c = string3;
        String string4 = context.getApplicationContext().getString(g0Var.a(context, "gt4_user_cancel"));
        m.e(string4, "context.applicationConte…text, \"gt4_user_cancel\"))");
        f5792d = string4;
        String string5 = context.getApplicationContext().getString(g0Var.a(context, "gt4_device_not_supported"));
        m.e(string5, "context.applicationConte…4_device_not_supported\"))");
        f5793e = string5;
    }
}
