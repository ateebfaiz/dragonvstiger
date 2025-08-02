package com.facebook.react.modules.accessibilityinfo;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.fbreact.specs.NativeAccessibilityInfoSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "AccessibilityInfo")
public final class AccessibilityInfoModule extends NativeAccessibilityInfoSpec implements LifecycleEventListener {
    private static final String ACCESSIBILITY_SERVICE_EVENT_NAME = "accessibilityServiceDidChange";
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String REDUCE_MOTION_EVENT_NAME = "reduceMotionDidChange";
    private static final String TOUCH_EXPLORATION_EVENT_NAME = "touchExplorationDidChange";
    private final AccessibilityManager accessibilityManager;
    private final b accessibilityServiceChangeListener = new b();
    private boolean accessibilityServiceEnabled;
    private final ContentObserver animationScaleObserver = new d(this, UiThreadUtil.getUiThreadHandler());
    private final ContentResolver contentResolver;
    private int recommendedTimeout;
    private boolean reduceMotionEnabled;
    private boolean touchExplorationEnabled;
    private final c touchExplorationStateChangeListener = new c();

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b implements AccessibilityManager.AccessibilityStateChangeListener {
        public b() {
        }

        public void onAccessibilityStateChanged(boolean z10) {
            AccessibilityInfoModule.this.updateAndSendAccessibilityServiceChangeEvent(z10);
        }
    }

    private final class c implements AccessibilityManager.TouchExplorationStateChangeListener {
        public c() {
        }

        public void onTouchExplorationStateChanged(boolean z10) {
            AccessibilityInfoModule.this.updateAndSendTouchExplorationChangeEvent(z10);
        }
    }

    public static final class d extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccessibilityInfoModule f3197a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AccessibilityInfoModule accessibilityInfoModule, Handler handler) {
            super(handler);
            this.f3197a = accessibilityInfoModule;
        }

        public void onChange(boolean z10) {
            onChange(z10, (Uri) null);
        }

        public void onChange(boolean z10, Uri uri) {
            if (this.f3197a.getReactApplicationContext().hasActiveReactInstance()) {
                this.f3197a.updateAndSendReduceMotionChangeEvent();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccessibilityInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "context");
        Object systemService = reactApplicationContext.getApplicationContext().getSystemService("accessibility");
        m.d(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager2;
        ContentResolver contentResolver2 = getReactApplicationContext().getContentResolver();
        m.e(contentResolver2, "getContentResolver(...)");
        this.contentResolver = contentResolver2;
        this.touchExplorationEnabled = accessibilityManager2.isTouchExplorationEnabled();
        this.accessibilityServiceEnabled = accessibilityManager2.isEnabled();
        this.reduceMotionEnabled = isReduceMotionEnabledValue();
    }

    @TargetApi(21)
    private final boolean isReduceMotionEnabledValue() {
        float f10;
        String string = Settings.Global.getString(this.contentResolver, "transition_animation_scale");
        if (string != null) {
            f10 = Float.parseFloat(string);
        } else {
            f10 = 1.0f;
        }
        if (f10 == 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void updateAndSendAccessibilityServiceChangeEvent(boolean z10) {
        if (this.accessibilityServiceEnabled != z10) {
            this.accessibilityServiceEnabled = z10;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                getReactApplicationContext().emitDeviceEvent(ACCESSIBILITY_SERVICE_EVENT_NAME, Boolean.valueOf(this.accessibilityServiceEnabled));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateAndSendReduceMotionChangeEvent() {
        boolean isReduceMotionEnabledValue = isReduceMotionEnabledValue();
        if (this.reduceMotionEnabled != isReduceMotionEnabledValue) {
            this.reduceMotionEnabled = isReduceMotionEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                reactApplicationContextIfActiveOrWarn.emitDeviceEvent(REDUCE_MOTION_EVENT_NAME, Boolean.valueOf(this.reduceMotionEnabled));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateAndSendTouchExplorationChangeEvent(boolean z10) {
        if (this.touchExplorationEnabled != z10) {
            this.touchExplorationEnabled = z10;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                getReactApplicationContext().emitDeviceEvent(TOUCH_EXPLORATION_EVENT_NAME, Boolean.valueOf(this.touchExplorationEnabled));
            }
        }
    }

    public void announceForAccessibility(String str) {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.getText().add(str);
            obtain.setClassName(AccessibilityInfoModule.class.getName());
            obtain.setPackageName(getReactApplicationContext().getPackageName());
            this.accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    public void getRecommendedTimeoutMillis(double d10, Callback callback) {
        int i10;
        m.f(callback, "successCallback");
        if (Build.VERSION.SDK_INT < 29) {
            callback.invoke(Integer.valueOf((int) d10));
            return;
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            i10 = accessibilityManager2.getRecommendedTimeoutMillis((int) d10, 4);
        } else {
            i10 = 0;
        }
        this.recommendedTimeout = i10;
        callback.invoke(Integer.valueOf(i10));
    }

    public void initialize() {
        boolean z10;
        getReactApplicationContext().addLifecycleEventListener(this);
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        boolean z11 = false;
        if (accessibilityManager2 == null || !accessibilityManager2.isTouchExplorationEnabled()) {
            z10 = false;
        } else {
            z10 = true;
        }
        updateAndSendTouchExplorationChangeEvent(z10);
        AccessibilityManager accessibilityManager3 = this.accessibilityManager;
        if (accessibilityManager3 != null && accessibilityManager3.isEnabled()) {
            z11 = true;
        }
        updateAndSendAccessibilityServiceChangeEvent(z11);
        updateAndSendReduceMotionChangeEvent();
    }

    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    public void isAccessibilityServiceEnabled(Callback callback) {
        m.f(callback, "successCallback");
        callback.invoke(Boolean.valueOf(this.accessibilityServiceEnabled));
    }

    public void isReduceMotionEnabled(Callback callback) {
        m.f(callback, "successCallback");
        callback.invoke(Boolean.valueOf(this.reduceMotionEnabled));
    }

    public void isTouchExplorationEnabled(Callback callback) {
        m.f(callback, "successCallback");
        callback.invoke(Boolean.valueOf(this.touchExplorationEnabled));
    }

    public void onHostDestroy() {
    }

    @TargetApi(21)
    public void onHostPause() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        AccessibilityManager accessibilityManager3 = this.accessibilityManager;
        if (accessibilityManager3 != null) {
            accessibilityManager3.removeAccessibilityStateChangeListener(this.accessibilityServiceChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
    }

    @TargetApi(21)
    public void onHostResume() {
        boolean z10;
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        AccessibilityManager accessibilityManager3 = this.accessibilityManager;
        if (accessibilityManager3 != null) {
            accessibilityManager3.addAccessibilityStateChangeListener(this.accessibilityServiceChangeListener);
        }
        boolean z11 = false;
        this.contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        AccessibilityManager accessibilityManager4 = this.accessibilityManager;
        if (accessibilityManager4 == null || !accessibilityManager4.isTouchExplorationEnabled()) {
            z10 = false;
        } else {
            z10 = true;
        }
        updateAndSendTouchExplorationChangeEvent(z10);
        AccessibilityManager accessibilityManager5 = this.accessibilityManager;
        if (accessibilityManager5 != null && accessibilityManager5.isEnabled()) {
            z11 = true;
        }
        updateAndSendAccessibilityServiceChangeEvent(z11);
        updateAndSendReduceMotionChangeEvent();
    }

    public void setAccessibilityFocus(double d10) {
    }
}
