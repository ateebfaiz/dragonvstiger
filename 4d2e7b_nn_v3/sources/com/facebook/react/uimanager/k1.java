package com.facebook.react.uimanager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.j;
import i7.a;

public abstract class k1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3793a = "com.facebook.react.uimanager.k1";

    public static float[] a(Context context) {
        EditText editText = new EditText(context);
        return new float[]{g0.b((float) ViewCompat.getPaddingStart(editText)), g0.b((float) ViewCompat.getPaddingEnd(editText)), g0.b((float) editText.getPaddingTop()), g0.b((float) editText.getPaddingBottom())};
    }

    public static e b(ReactContext reactContext, int i10) {
        if (reactContext.isBridgeless()) {
            if (reactContext instanceof e1) {
                reactContext = ((e1) reactContext).b();
            }
            return ((j) reactContext).getEventDispatcher();
        }
        UIManager h10 = h(reactContext, i10, false);
        if (h10 == null) {
            String str = f3793a;
            ReactSoftExceptionLogger.logSoftException(str, new ReactNoCrashSoftException("Unable to find UIManager for UIManagerType " + i10));
            return null;
        }
        e eVar = (e) h10.getEventDispatcher();
        if (eVar == null) {
            String str2 = f3793a;
            ReactSoftExceptionLogger.logSoftException(str2, new IllegalStateException("Cannot get EventDispatcher for UIManagerType " + i10));
        }
        return eVar;
    }

    public static e c(ReactContext reactContext, int i10) {
        e b10 = b(reactContext, a.a(i10));
        if (b10 == null) {
            String str = f3793a;
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot get EventDispatcher for reactTag " + i10));
        }
        return b10;
    }

    public static ReactContext d(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static int e(Context context) {
        if (context instanceof e1) {
            return ((e1) context).c();
        }
        return -1;
    }

    public static int f(View view) {
        if (view instanceof r0) {
            r0 r0Var = (r0) view;
            if (r0Var.getUIManagerType() == 2) {
                return r0Var.getRootViewTag();
            }
            return -1;
        }
        int id2 = view.getId();
        if (a.a(id2) == 1) {
            return -1;
        }
        Context context = view.getContext();
        if (!(context instanceof e1) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        int e10 = e(context);
        if (e10 == -1) {
            String str = f3793a;
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Fabric View [" + id2 + "] does not have SurfaceId associated with it"));
        }
        return e10;
    }

    public static UIManager g(ReactContext reactContext, int i10) {
        return h(reactContext, i10, true);
    }

    private static UIManager h(ReactContext reactContext, int i10, boolean z10) {
        if (reactContext.isBridgeless()) {
            UIManager fabricUIManager = reactContext.getFabricUIManager();
            if (fabricUIManager != null) {
                return fabricUIManager;
            }
            ReactSoftExceptionLogger.logSoftException(f3793a, new ReactNoCrashSoftException("Cannot get UIManager because the instance hasn't been initialized yet."));
            return null;
        } else if (!reactContext.hasCatalystInstance()) {
            ReactSoftExceptionLogger.logSoftException(f3793a, new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        } else {
            if (!reactContext.hasActiveReactInstance()) {
                ReactSoftExceptionLogger.logSoftException(f3793a, new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
                if (z10) {
                    return null;
                }
            }
            CatalystInstance catalystInstance = reactContext.getCatalystInstance();
            Class cls = UIManagerModule.class;
            if (i10 != 2) {
                return (UIManager) catalystInstance.getNativeModule(cls);
            }
            try {
                return reactContext.getFabricUIManager();
            } catch (IllegalArgumentException unused) {
                String str = f3793a;
                ReactSoftExceptionLogger.logSoftException(str, new ReactNoCrashSoftException("Cannot get UIManager for UIManagerType: " + i10));
                return (UIManager) catalystInstance.getNativeModule(cls);
            }
        }
    }

    public static UIManager i(ReactContext reactContext, int i10) {
        return g(reactContext, a.a(i10));
    }
}
