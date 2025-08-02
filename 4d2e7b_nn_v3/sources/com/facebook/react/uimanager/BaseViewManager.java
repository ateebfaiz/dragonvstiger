package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.m;
import com.facebook.react.p;
import com.facebook.react.uimanager.events.o;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.v;
import com.facebook.react.uimanager.z;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import e6.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import z2.a;

public abstract class BaseViewManager<T extends View, C extends v> extends ViewManager<T, C> implements f, View.OnLayoutChangeListener {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = ((float) Math.sqrt(5.0d));
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String STATE_BUSY = "busy";
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_MIXED = "mixed";
    private static final z.a sMatrixDecompositionContext = new z.a();
    private static final double[] sTransformDecompositionArray = new double[16];

    public BaseViewManager() {
        super((ReactApplicationContext) null);
    }

    private void applyFilter(@NonNull T t10, @Nullable ReadableArray readableArray) {
        int i10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            t10.setRenderEffect((RenderEffect) null);
        }
        Boolean bool = (Boolean) t10.getTag(m.A);
        if (bool == null || !bool.booleanValue()) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        t10.setLayerType(i10, (Paint) null);
        if (readableArray != null) {
            if (m.s(readableArray)) {
                Paint paint = new Paint();
                paint.setColorFilter(m.t(readableArray));
                t10.setLayerType(2, paint);
            } else if (i11 >= 31) {
                t10.setRenderEffect(m.u(readableArray));
            }
        }
    }

    private void logUnsupportedPropertyWarning(String str) {
        a.I("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }

    private static float sanitizeFloatPropertyValue(float f10) {
        if (f10 >= -3.4028235E38f && f10 <= Float.MAX_VALUE) {
            return f10;
        }
        if (f10 < -3.4028235E38f || f10 == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f10 > Float.MAX_VALUE || f10 == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f10)) {
            return 0.0f;
        }
        throw new IllegalStateException("Invalid float property value: " + f10);
    }

    private static void setPointerEventsFlag(@NonNull View view, o.b bVar, boolean z10) {
        int i10;
        int i11;
        Integer num = (Integer) view.getTag(m.f20859p);
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        int ordinal = 1 << bVar.ordinal();
        int i12 = m.f20859p;
        if (z10) {
            i11 = ordinal | i10;
        } else {
            i11 = (~ordinal) & i10;
        }
        view.setTag(i12, Integer.valueOf(i11));
    }

    private void updateViewAccessibility(@NonNull T t10) {
        i0.o(t10, t10.isFocusable(), t10.getImportantForAccessibility());
    }

    private void updateViewContentDescription(@NonNull T t10) {
        Dynamic dynamic;
        String str = (String) t10.getTag(m.f20848e);
        ReadableMap readableMap = (ReadableMap) t10.getTag(m.f20851h);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t10.getTag(m.f20853j);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(nextKey);
                if (nextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t10.getContext().getString(p.G));
                } else if (nextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t10.getContext().getString(p.F));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text") && (dynamic = readableMap2.getDynamic("text")) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (arrayList.size() > 0) {
            t10.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        f.a b10 = f.a().b("topPointerCancel", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerCancel", "captured", "onPointerCancelCapture"))).b("topPointerDown", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerDown", "captured", "onPointerDownCapture")));
        Boolean bool = Boolean.TRUE;
        exportedCustomDirectEventTypeConstants.putAll(b10.b("topPointerEnter", f.d("phasedRegistrationNames", f.f("bubbled", "onPointerEnter", "captured", "onPointerEnterCapture", "skipBubbling", bool))).b("topPointerLeave", f.d("phasedRegistrationNames", f.f("bubbled", "onPointerLeave", "captured", "onPointerLeaveCapture", "skipBubbling", bool))).b("topPointerMove", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerMove", "captured", "onPointerMoveCapture"))).b("topPointerUp", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerUp", "captured", "onPointerUpCapture"))).b("topPointerOut", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerOut", "captured", "onPointerOutCapture"))).b("topPointerOver", f.d("phasedRegistrationNames", f.e("bubbled", "onPointerOver", "captured", "onPointerOverCapture"))).b("topClick", f.d("phasedRegistrationNames", f.e("bubbled", "onClick", "captured", "onClickCapture"))).a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(f.a().b("topAccessibilityAction", f.d("registrationName", "onAccessibilityAction")).a());
        return exportedCustomDirectEventTypeConstants;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@NonNull T t10) {
        int i10;
        super.onAfterUpdateTransaction(t10);
        updateViewAccessibility(t10);
        Boolean bool = (Boolean) t10.getTag(m.f20856m);
        if (bool != null && bool.booleanValue()) {
            t10.addOnLayoutChangeListener(this);
            setTransformProperty(t10, (ReadableArray) t10.getTag(m.f20868y), (ReadableArray) t10.getTag(m.f20869z));
            t10.setTag(m.f20856m, Boolean.FALSE);
        }
        Boolean bool2 = (Boolean) t10.getTag(m.A);
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            t10.setLayerType(i10, (Paint) null);
        }
        applyFilter(t10, (ReadableArray) t10.getTag(m.f20854k));
    }

    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i16 - i14;
        int i19 = i12 - i10;
        if (i13 - i11 != i17 - i15 || i19 != i18) {
            ReadableArray readableArray = (ReadableArray) view.getTag(m.f20869z);
            ReadableArray readableArray2 = (ReadableArray) view.getTag(m.f20868y);
            if (readableArray2 != null || readableArray != null) {
                setTransformProperty(view, readableArray2, readableArray);
            }
        }
    }

    /* access modifiers changed from: protected */
    public T prepareToRecycleView(@NonNull e1 e1Var, T t10) {
        t10.setTag((Object) null);
        t10.setTag(m.f20859p, (Object) null);
        t10.setTag(m.f20860q, (Object) null);
        t10.setTag(m.C, (Object) null);
        t10.setTag(m.f20857n, (Object) null);
        t10.setTag(m.f20848e, (Object) null);
        t10.setTag(m.f20847d, (Object) null);
        t10.setTag(m.f20850g, (Object) null);
        t10.setTag(m.f20851h, (Object) null);
        t10.setTag(m.f20844a, (Object) null);
        t10.setTag(m.f20853j, (Object) null);
        t10.setTag(m.f20852i, (Object) null);
        setTransformProperty(t10, (ReadableArray) null, (ReadableArray) null);
        t10.resetPivot();
        t10.setTop(0);
        t10.setBottom(0);
        t10.setLeft(0);
        t10.setRight(0);
        t10.setElevation(0.0f);
        t10.setAnimationMatrix((Matrix) null);
        t10.setTag(m.f20868y, (Object) null);
        t10.setTag(m.f20869z, (Object) null);
        t10.setTag(m.f20856m, (Object) null);
        t10.removeOnLayoutChangeListener(this);
        t10.setTag(m.A, (Object) null);
        t10.setTag(m.f20854k, (Object) null);
        applyFilter(t10, (ReadableArray) null);
        if (Build.VERSION.SDK_INT >= 28) {
            t10.setOutlineAmbientShadowColor(ViewCompat.MEASURED_STATE_MASK);
            t10.setOutlineSpotShadowColor(ViewCompat.MEASURED_STATE_MASK);
        }
        t10.setNextFocusDownId(-1);
        t10.setNextFocusForwardId(-1);
        t10.setNextFocusRightId(-1);
        t10.setNextFocusUpId(-1);
        t10.setFocusable(false);
        t10.setFocusableInTouchMode(false);
        t10.setElevation(0.0f);
        t10.setAlpha(1.0f);
        setPadding(t10, 0, 0, 0, 0);
        t10.setForeground((Drawable) null);
        return t10;
    }

    @h7.a(name = "accessibilityActions")
    public void setAccessibilityActions(T t10, ReadableArray readableArray) {
        if (readableArray != null) {
            t10.setTag(m.f20844a, readableArray);
        }
    }

    @h7.a(name = "accessibilityCollection")
    public void setAccessibilityCollection(@NonNull T t10, @Nullable ReadableMap readableMap) {
        t10.setTag(m.f20845b, readableMap);
    }

    @h7.a(name = "accessibilityCollectionItem")
    public void setAccessibilityCollectionItem(@NonNull T t10, @Nullable ReadableMap readableMap) {
        t10.setTag(m.f20846c, readableMap);
    }

    @h7.a(name = "accessibilityHint")
    public void setAccessibilityHint(@NonNull T t10, @Nullable String str) {
        t10.setTag(m.f20847d, str);
        updateViewContentDescription(t10);
    }

    @h7.a(name = "accessibilityLabel")
    public void setAccessibilityLabel(@NonNull T t10, @Nullable String str) {
        t10.setTag(m.f20848e, str);
        updateViewContentDescription(t10);
    }

    @h7.a(name = "accessibilityLabelledBy")
    public void setAccessibilityLabelledBy(@NonNull T t10, @Nullable Dynamic dynamic) {
        if (!dynamic.isNull()) {
            if (dynamic.getType() == ReadableType.String) {
                t10.setTag(m.f20857n, dynamic.asString());
            } else if (dynamic.getType() == ReadableType.Array) {
                t10.setTag(m.f20857n, dynamic.asArray().getString(0));
            }
        }
    }

    @h7.a(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(@NonNull T t10, @Nullable String str) {
        if (str == null || str.equals(DevicePublicKeyStringDef.NONE)) {
            ViewCompat.setAccessibilityLiveRegion(t10, 0);
        } else if (str.equals("polite")) {
            ViewCompat.setAccessibilityLiveRegion(t10, 1);
        } else if (str.equals("assertive")) {
            ViewCompat.setAccessibilityLiveRegion(t10, 2);
        }
    }

    @h7.a(name = "accessibilityRole")
    public void setAccessibilityRole(@NonNull T t10, @Nullable String str) {
        if (str == null) {
            t10.setTag(m.f20850g, (Object) null);
        } else {
            t10.setTag(m.f20850g, i0.e.c(str));
        }
    }

    @h7.a(name = "accessibilityValue")
    public void setAccessibilityValue(T t10, ReadableMap readableMap) {
        if (readableMap == null) {
            t10.setTag(m.f20853j, (Object) null);
            t10.setContentDescription((CharSequence) null);
            return;
        }
        t10.setTag(m.f20853j, readableMap);
        if (readableMap.hasKey("text")) {
            updateViewContentDescription(t10);
        }
    }

    @h7.a(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(@NonNull T t10, int i10) {
        t10.setBackgroundColor(i10);
    }

    public void setBorderBottomLeftRadius(T t10, float f10) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_BOTTOM_LEFT_RADIUS);
    }

    public void setBorderBottomRightRadius(T t10, float f10) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_BOTTOM_RIGHT_RADIUS);
    }

    public void setBorderRadius(T t10, float f10) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_RADIUS);
    }

    public void setBorderTopLeftRadius(T t10, float f10) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_TOP_LEFT_RADIUS);
    }

    public void setBorderTopRightRadius(T t10, float f10) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_TOP_RIGHT_RADIUS);
    }

    @h7.a(name = "onClick")
    public void setClick(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.CLICK, z10);
    }

    @h7.a(name = "onClickCapture")
    public void setClickCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.CLICK_CAPTURE, z10);
    }

    @h7.a(name = "elevation")
    public void setElevation(@NonNull T t10, float f10) {
        ViewCompat.setElevation(t10, g0.d(f10));
    }

    @h7.a(customType = "Filter", name = "experimental_filter")
    public void setFilter(@NonNull T t10, @Nullable ReadableArray readableArray) {
        t10.setTag(m.f20854k, readableArray);
    }

    @h7.a(name = "importantForAccessibility")
    public void setImportantForAccessibility(@NonNull T t10, @Nullable String str) {
        if (str == null || str.equals("auto")) {
            ViewCompat.setImportantForAccessibility(t10, 0);
        } else if (str.equals("yes")) {
            ViewCompat.setImportantForAccessibility(t10, 1);
        } else if (str.equals("no")) {
            ViewCompat.setImportantForAccessibility(t10, 2);
        } else if (str.equals("no-hide-descendants")) {
            ViewCompat.setImportantForAccessibility(t10, 4);
        }
    }

    @h7.a(name = "onMoveShouldSetResponder")
    public void setMoveShouldSetResponder(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onMoveShouldSetResponderCapture")
    public void setMoveShouldSetResponderCapture(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "nativeID")
    public void setNativeId(@NonNull T t10, @Nullable String str) {
        t10.setTag(m.C, str);
        n7.a.c(t10);
    }

    @h7.a(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@NonNull T t10, float f10) {
        t10.setAlpha(f10);
    }

    @h7.a(name = "onPointerEnter")
    public void setPointerEnter(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.ENTER, z10);
    }

    @h7.a(name = "onPointerEnterCapture")
    public void setPointerEnterCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.ENTER_CAPTURE, z10);
    }

    @h7.a(name = "onPointerLeave")
    public void setPointerLeave(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.LEAVE, z10);
    }

    @h7.a(name = "onPointerLeaveCapture")
    public void setPointerLeaveCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.LEAVE_CAPTURE, z10);
    }

    @h7.a(name = "onPointerMove")
    public void setPointerMove(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.MOVE, z10);
    }

    @h7.a(name = "onPointerMoveCapture")
    public void setPointerMoveCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.MOVE_CAPTURE, z10);
    }

    @h7.a(name = "onPointerOut")
    public void setPointerOut(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.OUT, z10);
    }

    @h7.a(name = "onPointerOutCapture")
    public void setPointerOutCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.OUT_CAPTURE, z10);
    }

    @h7.a(name = "onPointerOver")
    public void setPointerOver(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.OVER, z10);
    }

    @h7.a(name = "onPointerOverCapture")
    public void setPointerOverCapture(@NonNull T t10, boolean z10) {
        setPointerEventsFlag(t10, o.b.OVER_CAPTURE, z10);
    }

    @h7.a(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(@NonNull T t10, boolean z10) {
        t10.setTag(m.A, Boolean.valueOf(z10));
    }

    @h7.a(name = "onResponderEnd")
    public void setResponderEnd(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderGrant")
    public void setResponderGrant(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderMove")
    public void setResponderMove(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderReject")
    public void setResponderReject(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderRelease")
    public void setResponderRelease(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderStart")
    public void setResponderStart(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderTerminate")
    public void setResponderTerminate(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onResponderTerminationRequest")
    public void setResponderTerminationRequest(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "role")
    public void setRole(@NonNull T t10, @Nullable String str) {
        if (str == null) {
            t10.setTag(m.f20867x, (Object) null);
        } else {
            t10.setTag(m.f20867x, i0.f.b(str));
        }
    }

    @h7.a(name = "rotation")
    @Deprecated
    public void setRotation(@NonNull T t10, float f10) {
        t10.setRotation(f10);
    }

    @h7.a(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(@NonNull T t10, float f10) {
        t10.setScaleX(f10);
    }

    @h7.a(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(@NonNull T t10, float f10) {
        t10.setScaleY(f10);
    }

    @h7.a(customType = "Color", defaultInt = -16777216, name = "shadowColor")
    public void setShadowColor(@NonNull T t10, int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            t10.setOutlineAmbientShadowColor(i10);
            t10.setOutlineSpotShadowColor(i10);
        }
    }

    @h7.a(name = "onShouldBlockNativeResponder")
    public void setShouldBlockNativeResponder(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onStartShouldSetResponder")
    public void setStartShouldSetResponder(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onStartShouldSetResponderCapture")
    public void setStartShouldSetResponderCapture(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "testID")
    public void setTestId(@NonNull T t10, @Nullable String str) {
        t10.setTag(m.f20860q, str);
        t10.setTag(str);
    }

    @h7.a(name = "onTouchCancel")
    public void setTouchCancel(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onTouchEnd")
    public void setTouchEnd(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onTouchMove")
    public void setTouchMove(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "onTouchStart")
    public void setTouchStart(@NonNull T t10, boolean z10) {
    }

    @h7.a(name = "transform")
    public void setTransform(@NonNull T t10, @Nullable ReadableArray readableArray) {
        t10.setTag(m.f20868y, readableArray);
        t10.setTag(m.f20856m, Boolean.TRUE);
    }

    @h7.a(name = "transformOrigin")
    public void setTransformOrigin(@NonNull T t10, @Nullable ReadableArray readableArray) {
        t10.setTag(m.f20869z, readableArray);
        t10.setTag(m.f20856m, Boolean.TRUE);
    }

    /* access modifiers changed from: protected */
    public void setTransformProperty(@NonNull T t10, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        boolean z10;
        if (readableArray == null) {
            t10.setTranslationX(g0.d(0.0f));
            t10.setTranslationY(g0.d(0.0f));
            t10.setRotation(0.0f);
            t10.setRotationX(0.0f);
            t10.setRotationY(0.0f);
            t10.setScaleX(1.0f);
            t10.setScaleY(1.0f);
            t10.setCameraDistance(0.0f);
            return;
        }
        if (i7.a.c(t10) == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        z.a aVar = sMatrixDecompositionContext;
        aVar.a();
        double[] dArr = sTransformDecompositionArray;
        h1.d(readableArray, dArr, g0.b((float) t10.getWidth()), g0.b((float) t10.getHeight()), readableArray2, z10);
        z.k(dArr, aVar);
        t10.setTranslationX(g0.d(sanitizeFloatPropertyValue((float) aVar.f3977d[0])));
        t10.setTranslationY(g0.d(sanitizeFloatPropertyValue((float) aVar.f3977d[1])));
        t10.setRotation(sanitizeFloatPropertyValue((float) aVar.f3978e[2]));
        t10.setRotationX(sanitizeFloatPropertyValue((float) aVar.f3978e[0]));
        t10.setRotationY(sanitizeFloatPropertyValue((float) aVar.f3978e[1]));
        t10.setScaleX(sanitizeFloatPropertyValue((float) aVar.f3975b[0]));
        t10.setScaleY(sanitizeFloatPropertyValue((float) aVar.f3975b[1]));
        double[] dArr2 = aVar.f3974a;
        if (dArr2.length > 2) {
            float f10 = (float) dArr2[2];
            if (f10 == 0.0f) {
                f10 = 7.8125E-4f;
            }
            float f11 = -1.0f / f10;
            float f12 = g.c().density;
            t10.setCameraDistance(sanitizeFloatPropertyValue(f12 * f12 * f11 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    @h7.a(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(@NonNull T t10, float f10) {
        t10.setTranslationX(g0.d(f10));
    }

    @h7.a(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(@NonNull T t10, float f10) {
        t10.setTranslationY(g0.d(f10));
    }

    @h7.a(name = "accessibilityState")
    public void setViewState(@NonNull T t10, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey(STATE_EXPANDED)) {
                t10.setTag(m.f20852i, Boolean.valueOf(readableMap.getBoolean(STATE_EXPANDED)));
            }
            if (readableMap.hasKey("selected")) {
                boolean isSelected = t10.isSelected();
                boolean z10 = readableMap.getBoolean("selected");
                t10.setSelected(z10);
                if (t10.isAccessibilityFocused() && isSelected && !z10) {
                    t10.announceForAccessibility(t10.getContext().getString(p.H));
                }
            } else {
                t10.setSelected(false);
            }
            t10.setTag(m.f20851h, readableMap);
            if (readableMap.hasKey("disabled") && !readableMap.getBoolean("disabled")) {
                t10.setEnabled(true);
            }
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (nextKey.equals(STATE_BUSY) || nextKey.equals(STATE_EXPANDED) || (nextKey.equals(STATE_CHECKED) && readableMap.getType(STATE_CHECKED) == ReadableType.String)) {
                    updateViewContentDescription(t10);
                    return;
                } else if (t10.isAccessibilityFocused()) {
                    t10.sendAccessibilityEvent(1);
                }
            }
        }
    }

    @h7.a(name = "zIndex")
    public void setZIndex(@NonNull T t10, float f10) {
        ViewGroupManager.setViewZIndex(t10, Math.round(f10));
        ViewParent parent = t10.getParent();
        if (parent instanceof x0) {
            ((x0) parent).updateDrawingOrder();
        }
    }

    public BaseViewManager(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
