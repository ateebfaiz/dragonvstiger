package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.t;

@s6.a(name = "RNCSafeAreaContext")
public final class SafeAreaContextModule extends NativeSafeAreaContextSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "RNCSafeAreaContext";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafeAreaContextModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final Map<String, Object> getInitialWindowMetrics() {
        View view;
        View view2;
        Window window;
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null) {
            view = null;
        } else {
            view = window.getDecorView();
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            view2 = viewGroup.findViewById(16908290);
        } else {
            view2 = null;
        }
        if (view2 == null) {
            return null;
        }
        a e10 = g.e(viewGroup);
        c a10 = g.a(viewGroup, view2);
        if (e10 == null || a10 == null) {
            return null;
        }
        return i0.i(t.a("insets", o.a(e10)), t.a("frame", o.c(a10)));
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        return i0.d(t.a("initialWindowMetrics", getInitialWindowMetrics()));
    }
}
