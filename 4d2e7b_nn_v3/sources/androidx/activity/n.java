package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.m;

final class n extends w {
    @DoNotInline
    public void a(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z10, boolean z11) {
        m.f(systemBarStyle, "statusBarStyle");
        m.f(systemBarStyle2, "navigationBarStyle");
        m.f(window, "window");
        m.f(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(systemBarStyle.getScrim$activity_release(z10));
        window.setNavigationBarColor(systemBarStyle2.getDarkScrim$activity_release());
        new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(!z10);
    }
}
