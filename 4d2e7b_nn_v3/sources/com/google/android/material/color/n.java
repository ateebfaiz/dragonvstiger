package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

abstract class n {
    static void a(Context context, int i10) {
        Resources.Theme b10;
        context.getTheme().applyStyle(i10, true);
        if ((context instanceof Activity) && (b10 = b((Activity) context)) != null) {
            b10.applyStyle(i10, true);
        }
    }

    private static Resources.Theme b(Activity activity) {
        View peekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window == null || (peekDecorView = window.peekDecorView()) == null || (context = peekDecorView.getContext()) == null) {
            return null;
        }
        return context.getTheme();
    }
}
