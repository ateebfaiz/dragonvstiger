package com.swmansion.rnscreens;

import android.view.View;
import com.adjust.sdk.Constants;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import com.facebook.react.uimanager.v0;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.swmansion.rnscreens.Screen;
import e6.f;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.t;
import p7.u;

@s6.a(name = "RNSScreen")
public class ScreenViewManager extends ViewGroupManager<Screen> implements u {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreen";
    private final c2 delegate = new t(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return i0.j(kotlin.t.a("topDismissed", f.d("registrationName", "onDismissed")), kotlin.t.a("topWillAppear", f.d("registrationName", "onWillAppear")), kotlin.t.a("topAppear", f.d("registrationName", "onAppear")), kotlin.t.a("topWillDisappear", f.d("registrationName", "onWillDisappear")), kotlin.t.a("topDisappear", f.d("registrationName", "onDisappear")), kotlin.t.a("topHeaderHeightChange", f.d("registrationName", "onHeaderHeightChange")), kotlin.t.a("topHeaderBackButtonClicked", f.d("registrationName", "onHeaderBackButtonClicked")), kotlin.t.a("topTransitionProgress", f.d("registrationName", "onTransitionProgress")));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    public void setCustomAnimationOnSwipe(Screen screen, boolean z10) {
    }

    public void setFullScreenSwipeEnabled(Screen screen, boolean z10) {
    }

    public void setFullScreenSwipeShadowEnabled(Screen screen, boolean z10) {
    }

    public void setGestureResponseDistance(Screen screen, ReadableMap readableMap) {
    }

    public void setHideKeyboardOnSwipe(Screen screen, boolean z10) {
    }

    public void setHomeIndicatorHidden(Screen screen, boolean z10) {
    }

    public void setPreventNativeDismiss(Screen screen, boolean z10) {
    }

    public void setSheetAllowedDetents(Screen screen, String str) {
        m.f(screen, "view");
    }

    public void setSheetCornerRadius(Screen screen, float f10) {
    }

    public void setSheetExpandsWhenScrolledToEdge(Screen screen, boolean z10) {
    }

    public void setSheetGrabberVisible(Screen screen, boolean z10) {
    }

    public void setSheetLargestUndimmedDetent(Screen screen, String str) {
        m.f(screen, "view");
    }

    public void setSwipeDirection(Screen screen, String str) {
    }

    public void setTransitionDuration(Screen screen, int i10) {
    }

    /* access modifiers changed from: protected */
    public Screen createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new Screen(e1Var);
    }

    public void setActivityState(Screen screen, float f10) {
        m.f(screen, "view");
        setActivityState(screen, (int) f10);
    }

    @h7.a(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setGestureEnabled(z10);
    }

    @h7.a(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setNativeBackButtonDismissalEnabled(z10);
    }

    @h7.a(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(Screen screen, Integer num) {
        m.f(screen, "view");
        screen.setNavigationBarColor(num);
    }

    @h7.a(name = "navigationBarHidden")
    public void setNavigationBarHidden(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setNavigationBarHidden(Boolean.valueOf(z10));
    }

    @h7.a(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setNavigationBarTranslucent(Boolean.valueOf(z10));
    }

    @h7.a(name = "replaceAnimation")
    public void setReplaceAnimation(Screen screen, String str) {
        Screen.b bVar;
        m.f(screen, "view");
        if (str == null ? true : m.b(str, "pop")) {
            bVar = Screen.b.POP;
        } else if (m.b(str, Constants.PUSH)) {
            bVar = Screen.b.PUSH;
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown replace animation type " + str);
        }
        screen.setReplaceAnimation(bVar);
    }

    @h7.a(name = "screenOrientation")
    public void setScreenOrientation(Screen screen, String str) {
        m.f(screen, "view");
        screen.setScreenOrientation(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4.equals("flip") != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        if (r4.equals("simple_push") != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a8, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown animation type " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r4.equals("default") != false) goto L_0x00a9;
     */
    @h7.a(name = "stackAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r3, r0)
            if (r4 == 0) goto L_0x00a9
            int r0 = r4.hashCode()
            switch(r0) {
                case -1418955385: goto L_0x0089;
                case -1198710326: goto L_0x007e;
                case -427095442: goto L_0x0073;
                case -349395819: goto L_0x0068;
                case 104461: goto L_0x005d;
                case 3135100: goto L_0x0052;
                case 3145837: goto L_0x0049;
                case 3387192: goto L_0x003e;
                case 182437661: goto L_0x0032;
                case 1500346553: goto L_0x0026;
                case 1544803905: goto L_0x001c;
                case 1601504978: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0092
        L_0x0010:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_BOTTOM
            goto L_0x00ab
        L_0x001c:
            java.lang.String r0 = "default"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            goto L_0x00a9
        L_0x0026:
            java.lang.String r0 = "ios_from_right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.IOS_FROM_RIGHT
            goto L_0x00ab
        L_0x0032:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.FADE_FROM_BOTTOM
            goto L_0x00ab
        L_0x003e:
            java.lang.String r0 = "none"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.NONE
            goto L_0x00ab
        L_0x0049:
            java.lang.String r0 = "flip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            goto L_0x00a9
        L_0x0052:
            java.lang.String r0 = "fade"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.FADE
            goto L_0x00ab
        L_0x005d:
            java.lang.String r0 = "ios"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.IOS
            goto L_0x00ab
        L_0x0068:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_RIGHT
            goto L_0x00ab
        L_0x0073:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_LEFT
            goto L_0x00ab
        L_0x007e:
            java.lang.String r0 = "ios_from_left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.IOS_FROM_LEFT
            goto L_0x00ab
        L_0x0089:
            java.lang.String r0 = "simple_push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0092
            goto L_0x00a9
        L_0x0092:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown animation type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x00a9:
            com.swmansion.rnscreens.Screen$c r4 = com.swmansion.rnscreens.Screen.c.DEFAULT
        L_0x00ab:
            r3.setStackAnimation(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r4.equals("containedModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r4.equals("modal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r4 = com.swmansion.rnscreens.Screen.d.f11503b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4.equals("transparentModal") != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r4 = com.swmansion.rnscreens.Screen.d.f11504c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r3.setStackPresentation(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r4.equals("formSheet") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r4.equals("fullScreenModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r4.equals("containedTransparentModal") != false) goto L_0x0051;
     */
    @h7.a(name = "stackPresentation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackPresentation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r3, r0)
            if (r4 == 0) goto L_0x0057
            int r0 = r4.hashCode()
            switch(r0) {
                case -76271493: goto L_0x0049;
                case 3452698: goto L_0x003e;
                case 104069805: goto L_0x0033;
                case 438078970: goto L_0x002a;
                case 955284238: goto L_0x0021;
                case 1171936146: goto L_0x0018;
                case 1798290171: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0057
        L_0x000f:
            java.lang.String r0 = "formSheet"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0018:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0021:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x0051
        L_0x002a:
            java.lang.String r0 = "containedModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0033:
            java.lang.String r0 = "modal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x003b:
            com.swmansion.rnscreens.Screen$d r4 = com.swmansion.rnscreens.Screen.d.MODAL
            goto L_0x0053
        L_0x003e:
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            com.swmansion.rnscreens.Screen$d r4 = com.swmansion.rnscreens.Screen.d.PUSH
            goto L_0x0053
        L_0x0049:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x0051:
            com.swmansion.rnscreens.Screen$d r4 = com.swmansion.rnscreens.Screen.d.TRANSPARENT_MODAL
        L_0x0053:
            r3.setStackPresentation(r4)
            return
        L_0x0057:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown presentation type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @h7.a(name = "statusBarAnimation")
    public void setStatusBarAnimation(Screen screen, String str) {
        m.f(screen, "view");
        screen.setStatusBarAnimated(Boolean.valueOf(str != null && !m.b(DevicePublicKeyStringDef.NONE, str)));
    }

    @h7.a(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(Screen screen, Integer num) {
        m.f(screen, "view");
        screen.setStatusBarColor(num);
    }

    @h7.a(name = "statusBarHidden")
    public void setStatusBarHidden(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setStatusBarHidden(Boolean.valueOf(z10));
    }

    @h7.a(name = "statusBarStyle")
    public void setStatusBarStyle(Screen screen, String str) {
        m.f(screen, "view");
        screen.setStatusBarStyle(str);
    }

    @h7.a(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(Screen screen, boolean z10) {
        m.f(screen, "view");
        screen.setStatusBarTranslucent(Boolean.valueOf(z10));
    }

    public Object updateState(Screen screen, v0 v0Var, d1 d1Var) {
        m.f(screen, "view");
        return super.updateState(screen, v0Var, d1Var);
    }

    @h7.a(name = "activityState")
    public final void setActivityState(Screen screen, int i10) {
        m.f(screen, "view");
        if (i10 != -1) {
            if (i10 == 0) {
                screen.setActivityState(Screen.a.INACTIVE);
            } else if (i10 == 1) {
                screen.setActivityState(Screen.a.TRANSITIONING_OR_BELOW_TOP);
            } else if (i10 == 2) {
                screen.setActivityState(Screen.a.ON_TOP);
            }
        }
    }
}
