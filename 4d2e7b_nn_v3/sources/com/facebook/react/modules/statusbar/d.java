package com.facebook.react.modules.statusbar;

import android.view.View;
import android.view.WindowInsets;
import com.facebook.react.modules.statusbar.StatusBarModule;

public final /* synthetic */ class d implements View.OnApplyWindowInsetsListener {
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return StatusBarModule.c.b(view, windowInsets);
    }
}
