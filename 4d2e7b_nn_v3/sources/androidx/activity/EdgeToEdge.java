package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class EdgeToEdge {
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static x Impl;

    public static final void enable(ComponentActivity componentActivity) {
        m.f(componentActivity, "<this>");
        enable$default(componentActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, (Function1) null, 4, (Object) null);
        }
        if ((i10 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, (Function1) null, 4, (Object) null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        m.f(componentActivity, "<this>");
        m.f(systemBarStyle, "statusBarStyle");
        enable$default(componentActivity, systemBarStyle, (SystemBarStyle) null, 2, (Object) null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        m.f(componentActivity, "<this>");
        m.f(systemBarStyle, "statusBarStyle");
        m.f(systemBarStyle2, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        Function1<Resources, Boolean> detectDarkMode$activity_release = systemBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        m.e(resources, "view.resources");
        boolean booleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        Function1<Resources, Boolean> detectDarkMode$activity_release2 = systemBarStyle2.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        m.e(resources2, "view.resources");
        boolean booleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        x xVar = Impl;
        if (xVar == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                xVar = new v();
            } else if (i10 >= 29) {
                xVar = new u();
            } else if (i10 >= 28) {
                xVar = new q();
            } else if (i10 >= 26) {
                xVar = new o();
            } else {
                xVar = new n();
            }
        }
        Window window = componentActivity.getWindow();
        m.e(window, "window");
        xVar.a(systemBarStyle, systemBarStyle2, window, decorView, booleanValue, booleanValue2);
        Window window2 = componentActivity.getWindow();
        m.e(window2, "window");
        xVar.b(window2);
    }
}
