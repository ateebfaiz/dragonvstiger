package com.facebook.react.uimanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f3683a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static DisplayMetrics f3684b;

    /* renamed from: c  reason: collision with root package name */
    private static DisplayMetrics f3685c;

    private g() {
    }

    public static final WritableMap a(double d10) {
        if (f3684b == null) {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics".toString());
        } else if (f3685c != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            g gVar = f3683a;
            DisplayMetrics displayMetrics = f3684b;
            m.d(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
            writableNativeMap.putMap("windowPhysicalPixels", gVar.b(displayMetrics, d10));
            DisplayMetrics displayMetrics2 = f3685c;
            m.d(displayMetrics2, "null cannot be cast to non-null type android.util.DisplayMetrics");
            writableNativeMap.putMap("screenPhysicalPixels", gVar.b(displayMetrics2, d10));
            return writableNativeMap;
        } else {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics".toString());
        }
    }

    private final WritableMap b(DisplayMetrics displayMetrics, double d10) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(Snapshot.WIDTH, displayMetrics.widthPixels);
        writableNativeMap.putInt(Snapshot.HEIGHT, displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", (double) displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d10);
        writableNativeMap.putDouble("densityDpi", (double) displayMetrics.densityDpi);
        return writableNativeMap;
    }

    public static final DisplayMetrics c() {
        DisplayMetrics displayMetrics = f3685c;
        if (displayMetrics != null) {
            m.d(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
            return displayMetrics;
        }
        throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics".toString());
    }

    public static final DisplayMetrics d() {
        DisplayMetrics displayMetrics = f3684b;
        if (displayMetrics != null) {
            m.d(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
            return displayMetrics;
        }
        throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics".toString());
    }

    public static final void e(Context context) {
        m.f(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f3684b = displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        Object systemService = context.getSystemService("window");
        m.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics2);
        f3685c = displayMetrics2;
    }

    public static final void f(Context context) {
        m.f(context, "context");
        if (f3685c == null) {
            e(context);
        }
    }
}
