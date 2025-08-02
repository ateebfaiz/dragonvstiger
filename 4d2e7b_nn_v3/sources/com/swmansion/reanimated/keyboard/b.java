package com.swmansion.reanimated.keyboard;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class b implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowsInsetsManager f11449a;

    public /* synthetic */ b(WindowsInsetsManager windowsInsetsManager) {
        this.f11449a = windowsInsetsManager;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f11449a.onApplyWindowInsetsListener(view, windowInsetsCompat);
    }
}
