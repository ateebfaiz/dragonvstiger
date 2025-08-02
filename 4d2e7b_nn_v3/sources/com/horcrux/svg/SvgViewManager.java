package com.horcrux.svg;

import android.graphics.Rect;
import android.util.SparseArray;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import p7.w1;
import p7.x1;

class SvgViewManager extends ReactViewManager implements x1 {
    public static final String REACT_CLASS = "RNSVGSvgViewAndroid";
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final SparseArray<SvgView> mTagToSvgView = new SparseArray<>();
    private final c2 mDelegate = new w1(this);

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9716a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9716a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9716a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9716a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.SvgViewManager.a.<clinit>():void");
        }
    }

    static SvgView getSvgViewByTag(int i10) {
        return mTagToSvgView.get(i10);
    }

    static void runWhenViewIsAvailable(int i10, Runnable runnable) {
        mTagToRunnable.put(i10, runnable);
    }

    static void setSvgView(int i10, SvgView svgView) {
        mTagToSvgView.put(i10, svgView);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i10);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i10);
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public ReactViewGroup createViewInstance(e1 e1Var) {
        return new SvgView(e1Var);
    }

    public void onDropViewInstance(ReactViewGroup reactViewGroup) {
        super.onDropViewInstance(reactViewGroup);
        mTagToSvgView.remove(reactViewGroup.getId());
    }

    public void setAccessible(SvgView svgView, boolean z10) {
        super.setAccessible(svgView, z10);
    }

    @h7.a(name = "align")
    public void setAlign(SvgView svgView, String str) {
        svgView.setAlign(str);
    }

    public void setBackfaceVisibility(SvgView svgView, String str) {
        super.setBackfaceVisibility(svgView, str);
    }

    @h7.a(name = "bbHeight")
    public void setBbHeight(SvgView svgView, Dynamic dynamic) {
        svgView.setBbHeight(dynamic);
    }

    @h7.a(name = "bbWidth")
    public void setBbWidth(SvgView svgView, Dynamic dynamic) {
        svgView.setBbWidth(dynamic);
    }

    public void setBorderBlockColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 9, num);
    }

    public void setBorderBlockEndColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 10, num);
    }

    public void setBorderBlockStartColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 11, num);
    }

    public void setBorderBottomColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 4, num);
    }

    public void setBorderBottomEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 8, dynamic);
    }

    public void setBorderBottomLeftRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 4, dynamic);
    }

    public void setBorderBottomRightRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 3, dynamic);
    }

    public void setBorderBottomStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 7, dynamic);
    }

    public void setBorderColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 0, num);
    }

    public void setBorderEndColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 6, num);
    }

    public void setBorderEndEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 9, dynamic);
    }

    public void setBorderEndStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 10, dynamic);
    }

    public void setBorderLeftColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 1, num);
    }

    public void setBorderRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 0, dynamic);
    }

    public void setBorderRightColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 2, num);
    }

    public void setBorderStartColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 5, num);
    }

    public void setBorderStartEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 11, dynamic);
    }

    public void setBorderStartStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 12, dynamic);
    }

    public void setBorderStyle(SvgView svgView, String str) {
        super.setBorderStyle(svgView, str);
    }

    public void setBorderTopColor(SvgView svgView, Integer num) {
        super.setBorderColor(svgView, 3, num);
    }

    public void setBorderTopEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 6, dynamic);
    }

    public void setBorderTopLeftRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 1, dynamic);
    }

    public void setBorderTopRightRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 2, dynamic);
    }

    public void setBorderTopStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius((ReactViewGroup) svgView, 5, dynamic);
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(SvgView svgView, Integer num) {
        svgView.setCurrentColor(num);
    }

    public void setFocusable(SvgView svgView, boolean z10) {
        super.setFocusable(svgView, z10);
    }

    public void setHasTVPreferredFocus(SvgView svgView, boolean z10) {
        super.setTVPreferredFocus(svgView, z10);
    }

    public void setHitSlop(SvgView svgView, Dynamic dynamic) {
        int i10 = a.f9716a[dynamic.getType().ordinal()];
        if (i10 == 1) {
            ReadableMap asMap = dynamic.asMap();
            int i11 = 0;
            int c10 = asMap.hasKey("left") ? (int) g0.c(asMap.getDouble("left")) : 0;
            int c11 = asMap.hasKey("top") ? (int) g0.c(asMap.getDouble("top")) : 0;
            int c12 = asMap.hasKey("right") ? (int) g0.c(asMap.getDouble("right")) : 0;
            if (asMap.hasKey("bottom")) {
                i11 = (int) g0.c(asMap.getDouble("bottom"));
            }
            svgView.setHitSlopRect(new Rect(c10, c11, c12, i11));
        } else if (i10 != 2) {
            if (i10 != 3) {
                z2.a.G("ReactNative", "Invalid type for 'hitSlop' value " + dynamic.getType());
            }
            svgView.setHitSlopRect((Rect) null);
        } else {
            int c13 = (int) g0.c(dynamic.asDouble());
            svgView.setHitSlopRect(new Rect(c13, c13, c13, c13));
        }
    }

    @h7.a(name = "meetOrSlice")
    public void setMeetOrSlice(SvgView svgView, int i10) {
        svgView.setMeetOrSlice(i10);
    }

    @h7.a(name = "minX")
    public void setMinX(SvgView svgView, float f10) {
        svgView.setMinX(f10);
    }

    @h7.a(name = "minY")
    public void setMinY(SvgView svgView, float f10) {
        svgView.setMinY(f10);
    }

    public void setNativeBackgroundAndroid(SvgView svgView, ReadableMap readableMap) {
        super.setNativeBackground(svgView, readableMap);
    }

    public void setNativeForegroundAndroid(SvgView svgView, ReadableMap readableMap) {
        super.setNativeForeground(svgView, readableMap);
    }

    public void setNeedsOffscreenAlphaCompositing(SvgView svgView, boolean z10) {
        super.setNeedsOffscreenAlphaCompositing(svgView, z10);
    }

    public void setNextFocusDown(SvgView svgView, int i10) {
        super.nextFocusDown(svgView, i10);
    }

    public void setNextFocusForward(SvgView svgView, int i10) {
        super.nextFocusForward(svgView, i10);
    }

    public void setNextFocusLeft(SvgView svgView, int i10) {
        super.nextFocusLeft(svgView, i10);
    }

    public void setNextFocusRight(SvgView svgView, int i10) {
        super.nextFocusRight(svgView, i10);
    }

    public void setNextFocusUp(SvgView svgView, int i10) {
        super.nextFocusUp(svgView, i10);
    }

    @h7.a(name = "pointerEvents")
    public void setPointerEvents(SvgView svgView, String str) {
        try {
            Class<? super Object> superclass = svgView.getClass().getSuperclass();
            if (superclass != null) {
                Method declaredMethod = superclass.getDeclaredMethod("setPointerEvents", new Class[]{h0.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(svgView, new Object[]{h0.valueOf(str.toUpperCase(Locale.US).replace("-", "_"))});
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }

    public void setRemoveClippedSubviews(SvgView svgView, boolean z10) {
        super.setRemoveClippedSubviews(svgView, z10);
    }

    @h7.a(name = "vbHeight")
    public void setVbHeight(SvgView svgView, float f10) {
        svgView.setVbHeight(f10);
    }

    @h7.a(name = "vbWidth")
    public void setVbWidth(SvgView svgView, float f10) {
        svgView.setVbWidth(f10);
    }

    public void updateExtraData(ReactViewGroup reactViewGroup, Object obj) {
        super.updateExtraData(reactViewGroup, obj);
        reactViewGroup.invalidate();
    }
}
