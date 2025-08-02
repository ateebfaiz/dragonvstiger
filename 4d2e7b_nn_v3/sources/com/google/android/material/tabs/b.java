package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

class b extends c {
    b() {
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        float f11;
        int i10 = (f10 > 0.5f ? 1 : (f10 == 0.5f ? 0 : -1));
        if (i10 >= 0) {
            view = view2;
        }
        RectF a10 = c.a(tabLayout, view);
        if (i10 < 0) {
            f11 = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, 0.5f, f10);
        } else {
            f11 = AnimationUtils.lerp(0.0f, 1.0f, 0.5f, 1.0f, f10);
        }
        drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (f11 * 255.0f));
    }
}
