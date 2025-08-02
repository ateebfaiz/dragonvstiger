package com.cocos.lib;

import android.view.View;

public class Utils {
    public static void hideVirtualButton() {
        if (GlobalObject.getActivity() != null) {
            Class cls = View.class;
            int intValue = ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION")).intValue();
            int intValue2 = ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN")).intValue();
            int intValue3 = ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_HIDE_NAVIGATION")).intValue();
            int intValue4 = ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_FULLSCREEN")).intValue();
            Object[] objArr = {Integer.valueOf(intValue | ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_STABLE")).intValue() | intValue2 | intValue3 | intValue4 | ((Integer) CocosReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_IMMERSIVE_STICKY")).intValue())};
            CocosReflectionHelper.invokeInstanceMethod(GlobalObject.getActivity().getWindow().getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, objArr);
        }
    }
}
