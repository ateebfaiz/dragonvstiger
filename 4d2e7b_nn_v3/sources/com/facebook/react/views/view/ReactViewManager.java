package com.facebook.react.views.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.x;
import com.facebook.react.uimanager.y;
import e6.f;
import java.util.Map;

@s6.a(name = "RCTView")
public class ReactViewManager extends ReactClippingViewManager<ReactViewGroup> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;
    private static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";
    public static final String REACT_CLASS = "RCTView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5, 9, 10, 11};

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactViewGroup f4360a;

        a(ReactViewGroup reactViewGroup) {
            this.f4360a = reactViewGroup;
        }

        public void onClick(View view) {
            e c10 = k1.c((ReactContext) this.f4360a.getContext(), this.f4360a.getId());
            if (c10 != null) {
                c10.c(new g(k1.e(this.f4360a.getContext()), this.f4360a.getId()));
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4362a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4362a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4362a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4362a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewManager.b.<clinit>():void");
        }
    }

    public ReactViewManager() {
        setupViewRecycling();
    }

    private void handleHotspotUpdate(ReactViewGroup reactViewGroup, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        }
        reactViewGroup.drawableHotspotChanged(g0.c(readableArray.getDouble(0)), g0.c(readableArray.getDouble(1)));
    }

    private void handleSetPressed(ReactViewGroup reactViewGroup, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    public Map<String, Integer> getCommandsMap() {
        return f.e(HOTSPOT_UPDATE_KEY, 1, "setPressed", 2);
    }

    public String getName() {
        return REACT_CLASS;
    }

    @h7.a(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(ReactViewGroup reactViewGroup, int i10) {
        reactViewGroup.setNextFocusDownId(i10);
    }

    @h7.a(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(ReactViewGroup reactViewGroup, int i10) {
        reactViewGroup.setNextFocusForwardId(i10);
    }

    @h7.a(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(ReactViewGroup reactViewGroup, int i10) {
        reactViewGroup.setNextFocusLeftId(i10);
    }

    @h7.a(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(ReactViewGroup reactViewGroup, int i10) {
        reactViewGroup.setNextFocusRightId(i10);
    }

    @h7.a(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(ReactViewGroup reactViewGroup, int i10) {
        reactViewGroup.setNextFocusUpId(i10);
    }

    @h7.a(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z10) {
        reactViewGroup.setFocusable(z10);
    }

    @h7.a(name = "backfaceVisibility")
    public void setBackfaceVisibility(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBackfaceVisibility(str);
    }

    @h7.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor", "borderBlockColor", "borderBlockEndColor", "borderBlockStartColor"})
    public void setBorderColor(ReactViewGroup reactViewGroup, int i10, Integer num) {
        float f10;
        float f11 = Float.NaN;
        if (num == null) {
            f10 = Float.NaN;
        } else {
            f10 = (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        }
        if (num != null) {
            f11 = (float) (num.intValue() >>> 24);
        }
        reactViewGroup.setBorderColor(SPACING_TYPES[i10], f10, f11);
    }

    @h7.b(names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius", "borderEndEndRadius", "borderEndStartRadius", "borderStartEndRadius", "borderStartStartRadius"})
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i10, Dynamic dynamic) {
        x c10 = x.c(dynamic);
        if (!(i7.a.c(reactViewGroup) == 2 || c10 == null || c10.a() != y.PERCENT)) {
            c10 = null;
        }
        reactViewGroup.setBorderRadius(m7.a.values()[i10], c10);
    }

    @h7.a(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, @Nullable String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @h7.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i10, float f10) {
        if (!com.facebook.yoga.e.a(f10) && f10 < 0.0f) {
            f10 = Float.NaN;
        }
        if (!com.facebook.yoga.e.a(f10)) {
            f10 = g0.d(f10);
        }
        reactViewGroup.setBorderWidth(SPACING_TYPES[i10], f10);
    }

    @h7.a(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z10) {
    }

    @h7.a(name = "collapsableChildren")
    public void setCollapsableChildren(ReactViewGroup reactViewGroup, boolean z10) {
    }

    @h7.a(name = "focusable")
    public void setFocusable(ReactViewGroup reactViewGroup, boolean z10) {
        if (z10) {
            reactViewGroup.setOnClickListener(new a(reactViewGroup));
            reactViewGroup.setFocusable(true);
            return;
        }
        reactViewGroup.setOnClickListener((View.OnClickListener) null);
        reactViewGroup.setClickable(false);
    }

    @h7.a(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, Dynamic dynamic) {
        int i10;
        int i11;
        int i12;
        int i13 = b.f4362a[dynamic.getType().ordinal()];
        if (i13 == 1) {
            ReadableMap asMap = dynamic.asMap();
            int i14 = 0;
            if (asMap.hasKey("left")) {
                i10 = (int) g0.c(asMap.getDouble("left"));
            } else {
                i10 = 0;
            }
            if (asMap.hasKey("top")) {
                i11 = (int) g0.c(asMap.getDouble("top"));
            } else {
                i11 = 0;
            }
            if (asMap.hasKey("right")) {
                i12 = (int) g0.c(asMap.getDouble("right"));
            } else {
                i12 = 0;
            }
            if (asMap.hasKey("bottom")) {
                i14 = (int) g0.c(asMap.getDouble("bottom"));
            }
            reactViewGroup.setHitSlopRect(new Rect(i10, i11, i12, i14));
        } else if (i13 != 2) {
            if (i13 != 3) {
                z2.a.G("ReactNative", "Invalid type for 'hitSlop' value " + dynamic.getType());
            }
            reactViewGroup.setHitSlopRect((Rect) null);
        } else {
            int c10 = (int) g0.c(dynamic.asDouble());
            reactViewGroup.setHitSlopRect(new Rect(c10, c10, c10, c10));
        }
    }

    @h7.a(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, @Nullable ReadableMap readableMap) {
        Drawable drawable;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = d.a(reactViewGroup.getContext(), readableMap);
        }
        reactViewGroup.setTranslucentBackgroundDrawable(drawable);
    }

    @h7.a(name = "nativeForegroundAndroid")
    public void setNativeForeground(ReactViewGroup reactViewGroup, @Nullable ReadableMap readableMap) {
        Drawable drawable;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = d.a(reactViewGroup.getContext(), readableMap);
        }
        reactViewGroup.setForeground(drawable);
    }

    @h7.a(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z10) {
        reactViewGroup.setNeedsOffscreenAlphaCompositing(z10);
    }

    @h7.a(name = "overflow")
    public void setOverflow(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setOverflow(str);
    }

    @h7.a(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, @Nullable String str) {
        reactViewGroup.setPointerEvents(h0.d(str));
    }

    @h7.a(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(ReactViewGroup reactViewGroup, boolean z10) {
        if (z10) {
            reactViewGroup.setFocusable(true);
            reactViewGroup.setFocusableInTouchMode(true);
            reactViewGroup.requestFocus();
        }
    }

    public ReactViewGroup createViewInstance(e1 e1Var) {
        return new ReactViewGroup(e1Var);
    }

    /* access modifiers changed from: protected */
    public ReactViewGroup prepareToRecycleView(@NonNull e1 e1Var, ReactViewGroup reactViewGroup) {
        super.prepareToRecycleView(e1Var, reactViewGroup);
        reactViewGroup.recycleView();
        return reactViewGroup;
    }

    public void setOpacity(@NonNull ReactViewGroup reactViewGroup, float f10) {
        reactViewGroup.setOpacityIfPossible(f10);
    }

    /* access modifiers changed from: protected */
    public void setTransformProperty(@NonNull ReactViewGroup reactViewGroup, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        super.setTransformProperty(reactViewGroup, readableArray, readableArray2);
        reactViewGroup.setBackfaceVisibilityDependantOpacity();
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, int i10, @Nullable ReadableArray readableArray) {
        if (i10 == 1) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        } else if (i10 == 2) {
            handleSetPressed(reactViewGroup, readableArray);
        }
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setPressed")) {
            handleSetPressed(reactViewGroup, readableArray);
        } else if (str.equals(HOTSPOT_UPDATE_KEY)) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        }
    }

    public void setBorderRadius(ReactViewGroup reactViewGroup, int i10, float f10) {
        setBorderRadius(reactViewGroup, i10, (Dynamic) new DynamicFromObject(Float.valueOf(f10)));
    }
}
