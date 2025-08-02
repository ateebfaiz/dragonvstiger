package com.swmansion.reanimated;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.uimanager.x;
import com.swmansion.reanimated.ReactNativeUtils;
import k7.a;
import m7.c;

public class BorderRadiiDrawableUtils {
    public static ReactNativeUtils.BorderRadii getBorderRadii(View view) {
        float f10;
        Drawable background = view.getBackground();
        if (!(background instanceof a)) {
            return new ReactNativeUtils.BorderRadii(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        a aVar = (a) background;
        x b10 = aVar.g().b();
        if (b10 != null) {
            f10 = b10.b((float) view.getWidth(), (float) view.getHeight());
        } else {
            f10 = Float.NaN;
        }
        float f11 = f10;
        c i10 = aVar.i();
        return new ReactNativeUtils.BorderRadii(f11, i10.c(), i10.d(), i10.a(), i10.b());
    }
}
