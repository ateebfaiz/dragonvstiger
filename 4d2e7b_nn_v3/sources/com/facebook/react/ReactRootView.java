package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.g;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.r0;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.s0;
import com.facebook.react.uimanager.t;
import com.facebook.react.uimanager.u;
import com.facebook.react.uimanager.z0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactRootView extends FrameLayout implements z0, r0 {
    private int C = View.MeasureSpec.makeMeasureSpec(0, 0);
    private int N0 = View.MeasureSpec.makeMeasureSpec(0, 0);
    private int O0 = 0;
    private int P0 = 0;
    private int Q0 = Integer.MIN_VALUE;
    private int R0 = Integer.MIN_VALUE;
    private int S0 = 1;
    private final AtomicInteger T0 = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private g0 f20721a;

    /* renamed from: b  reason: collision with root package name */
    private String f20722b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f20723c;

    /* renamed from: d  reason: collision with root package name */
    private a f20724d;

    /* renamed from: e  reason: collision with root package name */
    private int f20725e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20726f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20727g;

    /* renamed from: h  reason: collision with root package name */
    private u f20728h;

    /* renamed from: i  reason: collision with root package name */
    private t f20729i;

    /* renamed from: j  reason: collision with root package name */
    private final t f20730j = new t(this);

    /* renamed from: w  reason: collision with root package name */
    private boolean f20731w = false;

    private class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f20732a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20733b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20734c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f20735d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f20736e = 0;

        a() {
            g.f(ReactRootView.this.getContext().getApplicationContext());
            this.f20732a = new Rect();
            this.f20733b = (int) g0.d(60.0f);
        }

        private void a() {
            g();
        }

        private void b() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.f20736e != rotation) {
                this.f20736e = rotation;
                g.e(ReactRootView.this.getContext().getApplicationContext());
                f(rotation);
            }
        }

        private void c() {
            boolean a10;
            int i10;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.f20732a);
            WindowInsets rootWindowInsets = ReactRootView.this.getRootView().getRootWindowInsets();
            if (rootWindowInsets != null && (a10 = rootWindowInsets.isVisible(WindowInsets.Type.ime())) != this.f20734c) {
                this.f20734c = a10;
                if (a10) {
                    int a11 = rootWindowInsets.getInsets(WindowInsets.Type.ime()).bottom - rootWindowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;
                    ViewGroup.LayoutParams layoutParams = ReactRootView.this.getRootView().getLayoutParams();
                    p5.a.a(layoutParams instanceof WindowManager.LayoutParams);
                    if (((WindowManager.LayoutParams) layoutParams).softInputMode == 48) {
                        i10 = this.f20732a.bottom - a11;
                    } else {
                        i10 = this.f20732a.bottom;
                    }
                    ReactRootView.this.q("keyboardDidShow", e((double) g0.b((float) i10), (double) g0.b((float) this.f20732a.left), (double) g0.b((float) this.f20732a.width()), (double) g0.b((float) a11)));
                    return;
                }
                ReactRootView.this.q("keyboardDidHide", e((double) g0.b((float) this.f20732a.height()), 0.0d, (double) g0.b((float) this.f20732a.width()), 0.0d));
            }
        }

        private void d() {
            int i10;
            WindowInsets rootWindowInsets;
            DisplayCutout a10;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.f20732a);
            if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = ReactRootView.this.getRootView().getRootWindowInsets()) == null || (a10 = rootWindowInsets.getDisplayCutout()) == null) {
                i10 = 0;
            } else {
                i10 = a10.getSafeInsetTop();
            }
            int i11 = g.d().heightPixels;
            Rect rect = this.f20732a;
            int i12 = rect.bottom;
            int i13 = (i11 - i12) + i10;
            int i14 = this.f20735d;
            if (i14 != i13 && i13 > this.f20733b) {
                this.f20735d = i13;
                this.f20734c = true;
                ReactRootView.this.q("keyboardDidShow", e((double) g0.b((float) i12), (double) g0.b((float) this.f20732a.left), (double) g0.b((float) this.f20732a.width()), (double) g0.b((float) this.f20735d)));
            } else if (i14 != 0 && i13 <= this.f20733b) {
                this.f20735d = 0;
                this.f20734c = false;
                ReactRootView.this.q("keyboardDidHide", e((double) g0.b((float) rect.height()), 0.0d, (double) g0.b((float) this.f20732a.width()), 0.0d));
            }
        }

        private WritableMap e(double d10, double d11, double d12, double d13) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble(Snapshot.HEIGHT, d13);
            createMap2.putDouble("screenX", d11);
            createMap2.putDouble(Snapshot.WIDTH, d12);
            createMap2.putDouble("screenY", d10);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }

        private void f(int i10) {
            String str;
            double d10;
            boolean z10 = false;
            if (i10 != 0) {
                if (i10 == 1) {
                    str = "landscape-primary";
                    d10 = -90.0d;
                } else if (i10 == 2) {
                    str = "portrait-secondary";
                    d10 = 180.0d;
                } else if (i10 == 3) {
                    str = "landscape-secondary";
                    d10 = 90.0d;
                } else {
                    return;
                }
                z10 = true;
            } else {
                str = "portrait-primary";
                d10 = 0.0d;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", str);
            createMap.putDouble("rotationDegrees", d10);
            createMap.putBoolean("isLandscape", z10);
            ReactRootView.this.q("namedOrientationDidChange", createMap);
        }

        private void g() {
            DeviceInfoModule deviceInfoModule;
            ReactContext currentReactContext = ReactRootView.this.getCurrentReactContext();
            if (currentReactContext != null && (deviceInfoModule = (DeviceInfoModule) currentReactContext.getNativeModule(DeviceInfoModule.class)) != null) {
                deviceInfoModule.emitUpdateDimensionsEvent();
            }
        }

        public void onGlobalLayout() {
            if (ReactRootView.this.h() && ReactRootView.this.n()) {
                if (Build.VERSION.SDK_INT >= 30) {
                    c();
                } else {
                    d();
                }
                b();
                a();
            }
        }
    }

    public interface b {
    }

    public ReactRootView(Context context) {
        super(context);
        j();
    }

    private void e() {
        c8.a.c(0, "attachToReactInstanceManager");
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START);
        if (getId() != -1) {
            ReactSoftExceptionLogger.logSoftException("ReactRootView", new s("Trying to attach a ReactRootView with an explicit id already set to [" + getId() + "]. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID."));
        }
        try {
            if (!this.f20726f) {
                this.f20726f = true;
                ((g0) p5.a.c(this.f20721a)).r(this);
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
                c8.a.g(0);
            }
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
            c8.a.g(0);
        }
    }

    private a getCustomGlobalLayoutListener() {
        if (this.f20724d == null) {
            this.f20724d = new a();
        }
        return this.f20724d;
    }

    private void j() {
        setRootViewTag(s0.a());
        setClipChildren(false);
    }

    private boolean k() {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return false;
        } else if (this.f20728h == null) {
            z2.a.G("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
            return false;
        } else if (!ReactFeatureFlags.dispatchPointerEvents || this.f20729i != null) {
            return true;
        } else {
            z2.a.G("ReactRootView", "Unable to dispatch pointer events to JS before the dispatcher is available");
            return false;
        }
    }

    private boolean l() {
        if (getUIManagerType() == 2) {
            return true;
        }
        return false;
    }

    private boolean m() {
        int i10 = this.f20725e;
        if (i10 == 0 || i10 == -1) {
            return false;
        }
        return true;
    }

    private void p() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    private void r() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.C = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
        this.N0 = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
    }

    private void v(boolean z10, int i10, int i11) {
        UIManager g10;
        int i12;
        int i13;
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_START);
        if (!i()) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            z2.a.G("ReactRootView", "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        boolean l10 = l();
        if (!l10 || m()) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (!(currentReactContext == null || (g10 = k1.g(currentReactContext, getUIManagerType())) == null)) {
                if (l10) {
                    Point b10 = a1.b(this);
                    i12 = b10.x;
                    i13 = b10.y;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                if (!(!z10 && i12 == this.Q0 && i13 == this.R0)) {
                    g10.updateRootLayoutSpecs(getRootViewTag(), i10, i11, i12, i13);
                }
                this.Q0 = i12;
                this.R0 = i13;
            }
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            return;
        }
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
        z2.a.j("ReactRootView", "Unable to update root layout specs for ReactRootView: no rootViewTag set yet");
    }

    public void a(View view, MotionEvent motionEvent) {
        e b10;
        t tVar;
        if (k() && (b10 = k1.b(getCurrentReactContext(), getUIManagerType())) != null) {
            this.f20728h.e(motionEvent, b10);
            if (view != null && (tVar = this.f20729i) != null) {
                tVar.p(view, motionEvent, b10);
            }
        }
    }

    public void b(int i10) {
        if (i10 == 101) {
            o();
        }
    }

    public void c(View view, MotionEvent motionEvent) {
        e b10;
        if (k() && (b10 = k1.b(getCurrentReactContext(), getUIManagerType())) != null) {
            this.f20728h.d(motionEvent, b10);
            t tVar = this.f20729i;
            if (tVar != null) {
                tVar.o();
            }
        }
    }

    public void d() {
        c8.a.c(0, "ReactRootView.runApplication");
        try {
            if (i()) {
                if (n()) {
                    ReactContext currentReactContext = getCurrentReactContext();
                    if (currentReactContext == null) {
                        c8.a.g(0);
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (this.f20731w) {
                        v(true, this.C, this.N0);
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                    Bundle appProperties = getAppProperties();
                    if (appProperties != null) {
                        writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                    }
                    this.f20727g = true;
                    ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    c8.a.g(0);
                }
            }
        } finally {
            c8.a.g(0);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e10) {
            handleException(e10);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f20730j.d(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void f(MotionEvent motionEvent, boolean z10) {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.f20729i != null) {
            e b10 = k1.b(getCurrentReactContext(), getUIManagerType());
            if (b10 != null) {
                this.f20729i.k(motionEvent, b10, z10);
            }
        } else if (ReactFeatureFlags.dispatchPointerEvents) {
            z2.a.G("ReactRootView", "Unable to dispatch pointer events to JS before the dispatcher is available");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
        p5.a.b(!this.f20726f, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    /* access modifiers changed from: protected */
    public void g(MotionEvent motionEvent) {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.f20728h == null) {
            z2.a.G("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            e b10 = k1.b(getCurrentReactContext(), getUIManagerType());
            if (b10 != null) {
                this.f20728h.c(motionEvent, b10);
            }
        }
    }

    @Nullable
    public Bundle getAppProperties() {
        return this.f20723c;
    }

    @Nullable
    public ReactContext getCurrentReactContext() {
        return this.f20721a.C();
    }

    public int getHeightMeasureSpec() {
        return this.N0;
    }

    public String getJSModuleName() {
        return (String) p5.a.c(this.f20722b);
    }

    @Nullable
    public g0 getReactInstanceManager() {
        return this.f20721a;
    }

    public ViewGroup getRootViewGroup() {
        return this;
    }

    public int getRootViewTag() {
        return this.f20725e;
    }

    public AtomicInteger getState() {
        return this.T0;
    }

    @Nullable
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    public int getUIManagerType() {
        return this.S0;
    }

    public int getWidthMeasureSpec() {
        return this.C;
    }

    public boolean h() {
        g0 g0Var = this.f20721a;
        if (g0Var == null || g0Var.C() == null) {
            return false;
        }
        return true;
    }

    public void handleException(Throwable th) {
        if (h()) {
            getCurrentReactContext().handleException(new s(th.getMessage(), this, th));
            return;
        }
        throw new RuntimeException(th);
    }

    public boolean i() {
        if (this.f20721a != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f20726f;
    }

    public void o() {
        this.f20728h = new u(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.f20729i = new t(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (n()) {
            p();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (n()) {
            p();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z10, i10, rect);
            return;
        }
        this.f20730j.a();
        super.onFocusChanged(z10, i10, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        f(motionEvent, false);
        return super.onHoverEvent(motionEvent);
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        f(motionEvent, true);
        return super.onInterceptHoverEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (s(motionEvent)) {
            g(motionEvent);
        }
        f(motionEvent, true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f20731w && l()) {
            v(false, this.C, this.N0);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ all -> 0x0019 }, LOOP:0: B:17:0x0033->B:19:0x0039, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A[Catch:{ all -> 0x0019 }, LOOP:1: B:26:0x0066->B:28:0x006c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f A[ADDED_TO_REGION, Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "ReactRootView.onMeasure"
            r1 = 0
            c8.a.c(r1, r0)
            com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_START
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)
            int r0 = r10.C     // Catch:{ all -> 0x0019 }
            r3 = 1
            r4 = 0
            if (r11 != r0) goto L_0x001c
            int r0 = r10.N0     // Catch:{ all -> 0x0019 }
            if (r12 == r0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r0 = r4
            goto L_0x001d
        L_0x0019:
            r11 = move-exception
            goto L_0x00bd
        L_0x001c:
            r0 = r3
        L_0x001d:
            r10.C = r11     // Catch:{ all -> 0x0019 }
            r10.N0 = r12     // Catch:{ all -> 0x0019 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x0019 }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x0031
            if (r5 != 0) goto L_0x002c
            goto L_0x0031
        L_0x002c:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x0019 }
            goto L_0x0057
        L_0x0031:
            r11 = r4
            r5 = r11
        L_0x0033:
            int r7 = r10.getChildCount()     // Catch:{ all -> 0x0019 }
            if (r5 >= r7) goto L_0x0057
            android.view.View r7 = r10.getChildAt(r5)     // Catch:{ all -> 0x0019 }
            int r8 = r7.getLeft()     // Catch:{ all -> 0x0019 }
            int r9 = r7.getMeasuredWidth()     // Catch:{ all -> 0x0019 }
            int r8 = r8 + r9
            int r9 = r7.getPaddingLeft()     // Catch:{ all -> 0x0019 }
            int r8 = r8 + r9
            int r7 = r7.getPaddingRight()     // Catch:{ all -> 0x0019 }
            int r8 = r8 + r7
            int r11 = java.lang.Math.max(r11, r8)     // Catch:{ all -> 0x0019 }
            int r5 = r5 + 1
            goto L_0x0033
        L_0x0057:
            int r5 = android.view.View.MeasureSpec.getMode(r12)     // Catch:{ all -> 0x0019 }
            if (r5 == r6) goto L_0x0065
            if (r5 != 0) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            int r12 = android.view.View.MeasureSpec.getSize(r12)     // Catch:{ all -> 0x0019 }
            goto L_0x008a
        L_0x0065:
            r12 = r4
        L_0x0066:
            int r5 = r10.getChildCount()     // Catch:{ all -> 0x0019 }
            if (r4 >= r5) goto L_0x008a
            android.view.View r5 = r10.getChildAt(r4)     // Catch:{ all -> 0x0019 }
            int r6 = r5.getTop()     // Catch:{ all -> 0x0019 }
            int r7 = r5.getMeasuredHeight()     // Catch:{ all -> 0x0019 }
            int r6 = r6 + r7
            int r7 = r5.getPaddingTop()     // Catch:{ all -> 0x0019 }
            int r6 = r6 + r7
            int r5 = r5.getPaddingBottom()     // Catch:{ all -> 0x0019 }
            int r6 = r6 + r5
            int r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x0019 }
            int r4 = r4 + 1
            goto L_0x0066
        L_0x008a:
            r10.setMeasuredDimension(r11, r12)     // Catch:{ all -> 0x0019 }
            r10.f20731w = r3     // Catch:{ all -> 0x0019 }
            boolean r4 = r10.i()     // Catch:{ all -> 0x0019 }
            if (r4 == 0) goto L_0x009f
            boolean r4 = r10.n()     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x009f
            r10.e()     // Catch:{ all -> 0x0019 }
            goto L_0x00b0
        L_0x009f:
            if (r0 != 0) goto L_0x00a9
            int r0 = r10.O0     // Catch:{ all -> 0x0019 }
            if (r0 != r11) goto L_0x00a9
            int r0 = r10.P0     // Catch:{ all -> 0x0019 }
            if (r0 == r12) goto L_0x00b0
        L_0x00a9:
            int r0 = r10.C     // Catch:{ all -> 0x0019 }
            int r4 = r10.N0     // Catch:{ all -> 0x0019 }
            r10.v(r3, r0, r4)     // Catch:{ all -> 0x0019 }
        L_0x00b0:
            r10.O0 = r11     // Catch:{ all -> 0x0019 }
            r10.P0 = r12     // Catch:{ all -> 0x0019 }
            com.facebook.react.bridge.ReactMarkerConstants r11 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r11)
            c8.a.g(r1)
            return
        L_0x00bd:
            com.facebook.react.bridge.ReactMarkerConstants r12 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r12)
            c8.a.g(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (s(motionEvent)) {
            g(motionEvent);
        }
        f(motionEvent, false);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.f20727g) {
            this.f20727g = false;
            ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, getJSModuleName(), this.f20725e);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(String str, WritableMap writableMap) {
        if (i()) {
            getCurrentReactContext().emitDeviceEvent(str, writableMap);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!h() || !n()) {
            z2.a.G("ReactRootView", "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        this.f20730j.e(view2);
        super.requestChildFocus(view, view2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z10);
        }
    }

    public boolean s(MotionEvent motionEvent) {
        return true;
    }

    public void setAppProperties(@Nullable Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.f20723c = bundle;
        if (m()) {
            d();
        }
    }

    public void setEventListener(@Nullable b bVar) {
    }

    public void setIsFabric(boolean z10) {
        int i10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        this.S0 = i10;
    }

    public void setRootViewTag(int i10) {
        this.f20725e = i10;
    }

    public void setShouldLogContentAppeared(boolean z10) {
        this.f20727g = z10;
    }

    public void t(g0 g0Var, String str, Bundle bundle) {
        boolean z10;
        c8.a.c(0, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            if (this.f20721a == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p5.a.b(z10, "This root view has already been attached to a catalyst instance manager");
            this.f20721a = g0Var;
            this.f20722b = str;
            this.f20723c = bundle;
            g0Var.x();
            if (ReactFeatureFlags.enableEagerRootViewAttachment) {
                if (!this.f20731w) {
                    r();
                }
                e();
            }
            c8.a.g(0);
        } catch (Throwable th) {
            c8.a.g(0);
            throw th;
        }
    }

    public void u() {
        UiThreadUtil.assertOnUiThread();
        g0 g0Var = this.f20721a;
        if (g0Var != null && this.f20726f) {
            g0Var.A(this);
            this.f20726f = false;
        }
        this.f20721a = null;
        this.f20727g = false;
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j();
    }
}
