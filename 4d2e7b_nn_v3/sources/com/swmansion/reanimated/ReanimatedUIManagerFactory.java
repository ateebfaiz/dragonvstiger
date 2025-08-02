package com.swmansion.reanimated;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ReanimatedUIManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.y0;
import java.lang.reflect.Field;
import java.util.List;

public class ReanimatedUIManagerFactory {
    static UIManagerModule create(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i10) {
        i2 i2Var = new i2((List) list);
        ReanimatedUIManager reanimatedUIManager = new ReanimatedUIManager(reactApplicationContext, list, i10);
        y0 y0Var = new y0(reactApplicationContext, i2Var, reanimatedUIManager.getEventDispatcher(), i10);
        Class<? super ReanimatedUIManager> superclass = ReanimatedUIManager.class.getSuperclass();
        if (superclass == null) {
            Log.e("reanimated", "unable to resolve super class of ReanimatedUIManager");
            return reanimatedUIManager;
        }
        try {
            Field declaredField = superclass.getDeclaredField("mUIImplementation");
            declaredField.setAccessible(true);
            try {
                Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
            } catch (IllegalAccessException | NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            declaredField.set(reanimatedUIManager, y0Var);
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            e11.printStackTrace();
        }
        return reanimatedUIManager;
    }
}
