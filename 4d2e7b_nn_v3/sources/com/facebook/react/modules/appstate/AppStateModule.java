package com.facebook.react.modules.appstate;

import com.facebook.fbreact.specs.NativeAppStateSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WindowFocusChangeListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

@s6.a(name = "AppState")
public final class AppStateModule extends NativeAppStateSpec implements LifecycleEventListener, WindowFocusChangeListener {
    public static final String APP_STATE_ACTIVE = "active";
    public static final String APP_STATE_BACKGROUND = "background";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String INITIAL_STATE = "initialAppState";
    public static final String NAME = "AppState";
    private String appState;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppStateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        String str;
        m.f(reactApplicationContext, "reactContext");
        reactApplicationContext.addLifecycleEventListener(this);
        reactApplicationContext.addWindowFocusChangeListener(this);
        if (reactApplicationContext.getLifecycleState() == LifecycleState.RESUMED) {
            str = "active";
        } else {
            str = APP_STATE_BACKGROUND;
        }
        this.appState = str;
    }

    private final WritableMap createAppStateEventMap() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("app_state", this.appState);
        m.e(createMap, "apply(...)");
        return createMap;
    }

    private final void sendAppStateChangeEvent() {
        sendEvent("appStateDidChange", createAppStateEventMap());
    }

    private final void sendEvent(String str, Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(str, obj);
        }
    }

    public void addListener(String str) {
    }

    public void getCurrentAppState(Callback callback, Callback callback2) {
        m.f(callback, FirebaseAnalytics.Param.SUCCESS);
        callback.invoke(createAppStateEventMap());
    }

    public Map<String, Object> getTypedExportedConstants() {
        return i0.d(t.a(INITIAL_STATE, this.appState));
    }

    public void invalidate() {
        super.invalidate();
        getReactApplicationContext().removeLifecycleEventListener(this);
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        this.appState = APP_STATE_BACKGROUND;
        sendAppStateChangeEvent();
    }

    public void onHostResume() {
        this.appState = "active";
        sendAppStateChangeEvent();
    }

    public void onWindowFocusChange(boolean z10) {
        sendEvent("appStateFocusChange", Boolean.valueOf(z10));
    }

    public void removeListeners(double d10) {
    }
}
