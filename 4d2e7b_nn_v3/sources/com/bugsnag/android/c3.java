package com.bugsnag.android;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public final class c3 {

    /* renamed from: a  reason: collision with root package name */
    public static final c3 f18655a = new c3();

    /* renamed from: b  reason: collision with root package name */
    private static i3 f18656b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f18657c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f18658d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f18659e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f18660f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f18661g;

    /* renamed from: h  reason: collision with root package name */
    private static Method f18662h;

    /* renamed from: i  reason: collision with root package name */
    private static Method f18663i;

    /* renamed from: j  reason: collision with root package name */
    private static Method f18664j;

    private c3() {
    }

    private final Method c(String str, Class... clsArr) {
        i3 i3Var = f18656b;
        if (i3Var == null) {
            return null;
        }
        return i3Var.getClass().getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
    }

    public final Map a() {
        Method method = f18660f;
        if (method == null) {
            return null;
        }
        Object invoke = method.invoke(f18656b, (Object[]) null);
        if (invoke != null) {
            return (Map) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");
    }

    public final Map b() {
        Method method = f18661g;
        if (method == null) {
            return null;
        }
        Object invoke = method.invoke(f18656b, (Object[]) null);
        if (invoke != null) {
            return (Map) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean>");
    }

    public final void d(Map map) {
        Method method = f18662h;
        if (method != null) {
            method.invoke(f18656b, new Object[]{map});
        }
    }

    public final void e(String str) {
        Method method = f18663i;
        if (method != null) {
            method.invoke(f18656b, new Object[]{str});
        }
    }

    public final void f(boolean z10) {
        Method method = f18657c;
        if (method != null) {
            method.invoke(f18656b, new Object[]{Boolean.valueOf(z10)});
        }
    }

    public final void g(i3 i3Var) {
        if (i3Var != null) {
            f18656b = i3Var;
            f18657c = c("setInternalMetricsEnabled", Boolean.TYPE);
            Class<Map> cls = Map.class;
            f18658d = c("setStaticData", cls);
            f18659e = c("getSignalUnwindStackFunction", new Class[0]);
            f18660f = c("getCurrentCallbackSetCounts", new Class[0]);
            f18661g = c("getCurrentNativeApiCallUsage", new Class[0]);
            f18662h = c("initCallbackCounts", cls);
            Class<String> cls2 = String.class;
            f18663i = c("notifyAddCallback", cls2);
            f18664j = c("notifyRemoveCallback", cls2);
        }
    }

    public final void h(Map map) {
        Method method = f18658d;
        if (method != null) {
            method.invoke(f18656b, new Object[]{map});
        }
    }
}
