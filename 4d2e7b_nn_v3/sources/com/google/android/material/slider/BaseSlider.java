package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private BaseSlider<S, L, T>.d accessibilityEventSender;
    /* access modifiers changed from: private */
    @NonNull
    public final e accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    @NonNull
    private final Paint activeTicksPaint;
    @NonNull
    private final Paint activeTrackPaint;
    @NonNull
    private final List<L> changeListeners;
    @Nullable
    private Drawable customThumbDrawable;
    @NonNull
    private List<Drawable> customThumbDrawablesForValues;
    @NonNull
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    @NonNull
    private ColorStateList haloColor;
    @NonNull
    private final Paint haloPaint;
    private int haloRadius;
    @NonNull
    private final Paint inactiveTicksPaint;
    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    @NonNull
    private final f labelMaker;
    private int labelPadding;
    /* access modifiers changed from: private */
    @NonNull
    public final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private boolean thumbIsPressed;
    @NonNull
    private final Paint thumbPaint;
    private int thumbRadius;
    @NonNull
    private ColorStateList tickColorActive;
    @NonNull
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;
    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;
    @NonNull
    private ColorStateList trackColorActive;
    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        float f8476a;

        /* renamed from: b  reason: collision with root package name */
        float f8477b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList f8478c;

        /* renamed from: d  reason: collision with root package name */
        float f8479d;

        /* renamed from: e  reason: collision with root package name */
        boolean f8480e;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, (a) null);
            }

            /* renamed from: b */
            public SliderState[] newArray(int i10) {
                return new SliderState[i10];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f8476a);
            parcel.writeFloat(this.f8477b);
            parcel.writeList(this.f8478c);
            parcel.writeFloat(this.f8479d);
            parcel.writeBooleanArray(new boolean[]{this.f8480e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f8476a = parcel.readFloat();
            this.f8477b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.f8478c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f8479d = parcel.readFloat();
            this.f8480e = parcel.createBooleanArray()[0];
        }
    }

    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AttributeSet f8481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8482b;

        a(AttributeSet attributeSet, int i10) {
            this.f8481a = attributeSet;
            this.f8482b = i10;
        }

        public TooltipDrawable a() {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), this.f8481a, R.styleable.Slider, this.f8482b, BaseSlider.DEF_STYLE_RES, new int[0]);
            TooltipDrawable access$000 = BaseSlider.P(BaseSlider.this.getContext(), obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            return access$000;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (TooltipDrawable revealFraction : BaseSlider.this.labels) {
                revealFraction.setRevealFraction(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (TooltipDrawable remove : BaseSlider.this.labels) {
                ViewUtils.getContentViewOverlay(BaseSlider.this).remove(remove);
            }
        }
    }

    private static class e extends ExploreByTouchHelper {

        /* renamed from: a  reason: collision with root package name */
        private final BaseSlider f8488a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f8489b = new Rect();

        e(BaseSlider baseSlider) {
            super(baseSlider);
            this.f8488a = baseSlider;
        }

        private String a(int i10) {
            if (i10 == this.f8488a.getValues().size() - 1) {
                return this.f8488a.getContext().getString(R.string.material_slider_range_end);
            }
            if (i10 == 0) {
                return this.f8488a.getContext().getString(R.string.material_slider_range_start);
            }
            return "";
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f10, float f11) {
            for (int i10 = 0; i10 < this.f8488a.getValues().size(); i10++) {
                this.f8488a.updateBoundsForVirturalViewId(i10, this.f8489b);
                if (this.f8489b.contains((int) f10, (int) f11)) {
                    return i10;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List list) {
            for (int i10 = 0; i10 < this.f8488a.getValues().size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (!this.f8488a.isEnabled()) {
                return false;
            }
            if (i11 == 4096 || i11 == 8192) {
                float access$800 = this.f8488a.e(20);
                if (i11 == 8192) {
                    access$800 = -access$800;
                }
                if (this.f8488a.isRtl()) {
                    access$800 = -access$800;
                }
                if (!this.f8488a.Z(i10, MathUtils.clamp(this.f8488a.getValues().get(i10).floatValue() + access$800, this.f8488a.getValueFrom(), this.f8488a.getValueTo()))) {
                    return false;
                }
                this.f8488a.b0();
                this.f8488a.postInvalidate();
                invalidateVirtualView(i10);
                return true;
            }
            if (i11 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.f8488a.Z(i10, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.f8488a.b0();
                    this.f8488a.postInvalidate();
                    invalidateVirtualView(i10);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.f8488a.getValues();
            float floatValue = values.get(i10).floatValue();
            float valueFrom = this.f8488a.getValueFrom();
            float valueTo = this.f8488a.getValueTo();
            if (this.f8488a.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.f8488a.getContentDescription() != null) {
                sb2.append(this.f8488a.getContentDescription());
                sb2.append(",");
            }
            if (values.size() > 1) {
                sb2.append(a(i10));
                sb2.append(this.f8488a.t(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb2.toString());
            this.f8488a.updateBoundsForVirturalViewId(i10, this.f8489b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f8489b);
        }
    }

    private interface f {
        TooltipDrawable a();
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    private Drawable A(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        a(newDrawable);
        return newDrawable;
    }

    private void B() {
        this.inactiveTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.activeTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
        this.activeTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
    }

    private boolean C() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private boolean D(float f10) {
        double doubleValue = new BigDecimal(Float.toString(f10)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(((double) Math.round(doubleValue)) - doubleValue) < THRESHOLD) {
            return true;
        }
        return false;
    }

    private void E(Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void F() {
        if (this.stepSize > 0.0f) {
            d0();
            int min = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
            float[] fArr = this.ticksCoordinates;
            if (fArr == null || fArr.length != min * 2) {
                this.ticksCoordinates = new float[(min * 2)];
            }
            float f10 = ((float) this.trackWidth) / ((float) (min - 1));
            for (int i10 = 0; i10 < min * 2; i10 += 2) {
                float[] fArr2 = this.ticksCoordinates;
                fArr2[i10] = ((float) this.trackSidePadding) + (((float) (i10 / 2)) * f10);
                fArr2[i10 + 1] = (float) f();
            }
        }
    }

    private void G(Canvas canvas, int i10, int i11) {
        if (W()) {
            int L = (int) (((float) this.trackSidePadding) + (L(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) i10)));
            if (Build.VERSION.SDK_INT < 28) {
                int i12 = this.haloRadius;
                canvas.clipRect((float) (L - i12), (float) (i11 - i12), (float) (L + i12), (float) (i12 + i11), Region.Op.UNION);
            }
            canvas.drawCircle((float) L, (float) i11, (float) this.haloRadius, this.haloPaint);
        }
    }

    private void H(Canvas canvas) {
        if (this.tickVisible && this.stepSize > 0.0f) {
            float[] u10 = u();
            int Q = Q(this.ticksCoordinates, u10[0]);
            int Q2 = Q(this.ticksCoordinates, u10[1]);
            int i10 = Q * 2;
            canvas.drawPoints(this.ticksCoordinates, 0, i10, this.inactiveTicksPaint);
            int i11 = Q2 * 2;
            canvas.drawPoints(this.ticksCoordinates, i10, i11 - i10, this.activeTicksPaint);
            float[] fArr = this.ticksCoordinates;
            canvas.drawPoints(fArr, i11, fArr.length - i11, this.inactiveTicksPaint);
        }
    }

    private void I() {
        this.trackSidePadding = this.minTrackSidePadding + Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        if (ViewCompat.isLaidOut(this)) {
            c0(getWidth());
        }
    }

    private boolean J(int i10) {
        int i11 = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(((long) i11) + ((long) i10), 0, (long) (this.values.size() - 1));
        this.focusedThumbIdx = clamp;
        if (clamp == i11) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        b0();
        postInvalidate();
        return true;
    }

    private boolean K(int i10) {
        if (isRtl()) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = -i10;
            }
        }
        return J(i10);
    }

    private float L(float f10) {
        float f11 = this.valueFrom;
        float f12 = (f10 - f11) / (this.valueTo - f11);
        if (isRtl()) {
            return 1.0f - f12;
        }
        return f12;
    }

    private Boolean M(int i10, KeyEvent keyEvent) {
        if (i10 != 61) {
            if (i10 != 66) {
                if (i10 != 81) {
                    if (i10 == 69) {
                        J(-1);
                        return Boolean.TRUE;
                    } else if (i10 != 70) {
                        switch (i10) {
                            case 21:
                                K(-1);
                                return Boolean.TRUE;
                            case 22:
                                K(1);
                                return Boolean.TRUE;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                J(1);
                return Boolean.TRUE;
            }
            this.activeThumbIdx = this.focusedThumbIdx;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(J(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(J(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void N() {
        for (T onStartTrackingTouch : this.touchListeners) {
            onStartTrackingTouch.onStartTrackingTouch(this);
        }
    }

    private void O() {
        for (T onStopTrackingTouch : this.touchListeners) {
            onStopTrackingTouch.onStopTrackingTouch(this);
        }
    }

    /* access modifiers changed from: private */
    public static TooltipDrawable P(Context context, TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, (AttributeSet) null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int Q(float[] fArr, float f10) {
        return Math.round(f10 * ((float) ((fArr.length / 2) - 1)));
    }

    private void R(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i10, DEF_STYLE_RES, new int[0]);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.Slider_trackColor);
        if (hasValue) {
            i11 = R.styleable.Slider_trackColor;
        } else {
            i11 = R.styleable.Slider_trackColorInactive;
        }
        if (hasValue) {
            i12 = R.styleable.Slider_trackColor;
        } else {
            i12 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i11);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i12);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        if (obtainStyledAttributes.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisible = obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true);
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.Slider_tickColor);
        if (hasValue2) {
            i13 = R.styleable.Slider_tickColor;
        } else {
            i13 = R.styleable.Slider_tickColorInactive;
        }
        if (hasValue2) {
            i14 = R.styleable.Slider_tickColor;
        } else {
            i14 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i13);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i14);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setLabelBehavior(obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void S(int i10) {
        BaseSlider<S, L, T>.d dVar = this.accessibilityEventSender;
        if (dVar == null) {
            this.accessibilityEventSender = new d(this, (a) null);
        } else {
            removeCallbacks(dVar);
        }
        this.accessibilityEventSender.a(i10);
        postDelayed(this.accessibilityEventSender, 200);
    }

    private void T(TooltipDrawable tooltipDrawable, float f10) {
        tooltipDrawable.setText(t(f10));
        int L = (this.trackSidePadding + ((int) (L(f10) * ((float) this.trackWidth)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int f11 = f() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(L, f11 - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + L, f11);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void U(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() != arrayList.size() || !this.values.equals(arrayList)) {
                this.values = arrayList;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                b0();
                h();
                l();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean V() {
        if (this.labelBehavior == 3) {
            return true;
        }
        return false;
    }

    private boolean W() {
        if (this.forceDrawCompatHalo || !(getBackground() instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    private boolean X(float f10) {
        return Z(this.activeThumbIdx, f10);
    }

    private double Y(float f10) {
        float f11 = this.stepSize;
        if (f11 <= 0.0f) {
            return (double) f10;
        }
        int i10 = (int) ((this.valueTo - this.valueFrom) / f11);
        return ((double) Math.round(f10 * ((float) i10))) / ((double) i10);
    }

    /* access modifiers changed from: private */
    public boolean Z(int i10, float f10) {
        this.focusedThumbIdx = i10;
        if (((double) Math.abs(f10 - this.values.get(i10).floatValue())) < THRESHOLD) {
            return false;
        }
        this.values.set(i10, Float.valueOf(w(i10, f10)));
        k(i10);
        return true;
    }

    private void a(Drawable drawable) {
        int i10 = this.thumbRadius * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i10, i10);
            return;
        }
        float max = ((float) i10) / ((float) Math.max(intrinsicWidth, intrinsicHeight));
        drawable.setBounds(0, 0, (int) (((float) intrinsicWidth) * max), (int) (((float) intrinsicHeight) * max));
    }

    private boolean a0() {
        return X(y());
    }

    private void b(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    /* access modifiers changed from: private */
    public void b0() {
        if (!W() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int L = (int) ((L(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding));
                int f10 = f();
                int i10 = this.haloRadius;
                DrawableCompat.setHotspotBounds(background, L - i10, f10 - i10, L + i10, f10 + i10);
            }
        }
    }

    private Float c(int i10) {
        float f10;
        if (this.isLongPress) {
            f10 = e(20);
        } else {
            f10 = d();
        }
        if (i10 == 21) {
            if (!isRtl()) {
                f10 = -f10;
            }
            return Float.valueOf(f10);
        } else if (i10 == 22) {
            if (isRtl()) {
                f10 = -f10;
            }
            return Float.valueOf(f10);
        } else if (i10 == 69) {
            return Float.valueOf(-f10);
        } else {
            if (i10 == 70 || i10 == 81) {
                return Float.valueOf(f10);
            }
            return null;
        }
    }

    private void c0(int i10) {
        this.trackWidth = Math.max(i10 - (this.trackSidePadding * 2), 0);
        F();
    }

    private float d() {
        float f10 = this.stepSize;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        return f10;
    }

    private void d0() {
        if (this.dirtyConfig) {
            g0();
            h0();
            f0();
            i0();
            e0();
            l0();
            this.dirtyConfig = false;
        }
    }

    /* access modifiers changed from: private */
    public float e(int i10) {
        float d10 = d();
        float f10 = (this.valueTo - this.valueFrom) / d10;
        float f11 = (float) i10;
        if (f10 <= f11) {
            return d10;
        }
        return ((float) Math.round(f10 / f11)) * d10;
    }

    private void e0() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f10 = this.stepSize;
            if (f10 > 0.0f && minSeparation > 0.0f) {
                if (this.separationUnit != 1) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.stepSize)}));
                } else if (minSeparation < f10 || !D(minSeparation)) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
                }
            }
        } else {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, new Object[]{Float.valueOf(minSeparation)}));
        }
    }

    private int f() {
        int i10 = this.trackTop;
        int i11 = 0;
        if (this.labelBehavior == 1 || V()) {
            i11 = this.labels.get(0).getIntrinsicHeight();
        }
        return i10 + i11;
    }

    private void f0() {
        if (this.stepSize > 0.0f && !j0(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
        }
    }

    private ValueAnimator g(boolean z10) {
        float f10;
        ValueAnimator valueAnimator;
        long j10;
        TimeInterpolator timeInterpolator;
        float f11 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (z10) {
            valueAnimator = this.labelsOutAnimator;
        } else {
            valueAnimator = this.labelsInAnimator;
        }
        float v10 = v(valueAnimator, f10);
        if (!z10) {
            f11 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{v10, f11});
        if (z10) {
            j10 = LABEL_ANIMATION_ENTER_DURATION;
        } else {
            j10 = LABEL_ANIMATION_EXIT_DURATION;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            timeInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        } else {
            timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        }
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private void g0() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
        }
    }

    private void h() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable next : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    i(next);
                }
            }
            subList.clear();
        }
        while (this.labels.size() < this.values.size()) {
            TooltipDrawable a10 = this.labelMaker.a();
            this.labels.add(a10);
            if (ViewCompat.isAttachedToWindow(this)) {
                b(a10);
            }
        }
        int i10 = 1;
        if (this.labels.size() == 1) {
            i10 = 0;
        }
        for (TooltipDrawable strokeWidth : this.labels) {
            strokeWidth.setStrokeWidth((float) i10);
        }
    }

    private void h0() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.valueOf(this.valueTo), Float.valueOf(this.valueFrom)}));
        }
    }

    private void i(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private void i0() {
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{next, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
            } else if (this.stepSize > 0.0f && !j0(next.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{next, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
            }
        }
    }

    private float j(float f10) {
        if (f10 == 0.0f) {
            return 0.0f;
        }
        float f11 = (f10 - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        float f12 = this.valueFrom;
        return (f11 * (f12 - this.valueTo)) + f12;
    }

    private boolean j0(float f10) {
        return D(f10 - this.valueFrom);
    }

    private void k(int i10) {
        for (L onValueChange : this.changeListeners) {
            onValueChange.onValueChange(this, this.values.get(i10).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            S(i10);
        }
    }

    private float k0(float f10) {
        return (L(f10) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
    }

    private void l() {
        for (L l10 : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l10.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void l0() {
        float f10 = this.stepSize;
        if (f10 != 0.0f) {
            if (((float) ((int) f10)) != f10) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"stepSize", Float.valueOf(f10)}));
            }
            float f11 = this.valueFrom;
            if (((float) ((int) f11)) != f11) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueFrom", Float.valueOf(f11)}));
            }
            float f12 = this.valueTo;
            if (((float) ((int) f12)) != f12) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueTo", Float.valueOf(f12)}));
            }
        }
    }

    private void m(Canvas canvas, int i10, int i11) {
        float[] u10 = u();
        int i12 = this.trackSidePadding;
        float f10 = (float) i10;
        float f11 = (float) i11;
        Canvas canvas2 = canvas;
        canvas2.drawLine(((float) i12) + (u10[0] * f10), f11, ((float) i12) + (u10[1] * f10), f11, this.activeTrackPaint);
    }

    private void n(Canvas canvas, int i10, int i11) {
        float[] u10 = u();
        int i12 = this.trackSidePadding;
        float f10 = (float) i10;
        float f11 = ((float) i12) + (u10[1] * f10);
        if (f11 < ((float) (i12 + i10))) {
            float f12 = (float) i11;
            canvas.drawLine(f11, f12, (float) (i12 + i10), f12, this.inactiveTrackPaint);
        }
        int i13 = this.trackSidePadding;
        float f13 = ((float) i13) + (u10[0] * f10);
        if (f13 > ((float) i13)) {
            float f14 = (float) i11;
            canvas.drawLine((float) i13, f14, f13, f14, this.inactiveTrackPaint);
        }
    }

    private void o(Canvas canvas, int i10, int i11, float f10, Drawable drawable) {
        canvas.save();
        canvas.translate(((float) (this.trackSidePadding + ((int) (L(f10) * ((float) i10))))) - (((float) drawable.getBounds().width()) / 2.0f), ((float) i11) - (((float) drawable.getBounds().height()) / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void p(Canvas canvas, int i10, int i11) {
        for (int i12 = 0; i12 < this.values.size(); i12++) {
            float floatValue = this.values.get(i12).floatValue();
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                o(canvas, i10, i11, floatValue, drawable);
            } else if (i12 < this.customThumbDrawablesForValues.size()) {
                o(canvas, i10, i11, floatValue, this.customThumbDrawablesForValues.get(i12));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(((float) this.trackSidePadding) + (L(floatValue) * ((float) i10)), (float) i11, (float) this.thumbRadius, this.thumbPaint);
                }
                o(canvas, i10, i11, floatValue, this.defaultThumbDrawable);
            }
        }
    }

    private void q() {
        if (this.labelBehavior != 2) {
            if (!this.labelsAreAnimatedIn) {
                this.labelsAreAnimatedIn = true;
                ValueAnimator g10 = g(true);
                this.labelsInAnimator = g10;
                this.labelsOutAnimator = null;
                g10.start();
            }
            Iterator<TooltipDrawable> it = this.labels.iterator();
            for (int i10 = 0; i10 < this.values.size() && it.hasNext(); i10++) {
                if (i10 != this.focusedThumbIdx) {
                    T(it.next(), this.values.get(i10).floatValue());
                }
            }
            if (it.hasNext()) {
                T(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
                return;
            }
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
        }
    }

    private void r() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator g10 = g(false);
            this.labelsOutAnimator = g10;
            this.labelsInAnimator = null;
            g10.addListener(new c());
            this.labelsOutAnimator.start();
        }
    }

    private void s(int i10) {
        if (i10 == 1) {
            J(Integer.MAX_VALUE);
        } else if (i10 == 2) {
            J(Integer.MIN_VALUE);
        } else if (i10 == 17) {
            K(Integer.MAX_VALUE);
        } else if (i10 == 66) {
            K(Integer.MIN_VALUE);
        }
    }

    /* access modifiers changed from: private */
    public String t(float f10) {
        String str;
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f10);
        }
        if (((float) ((int) f10)) == f10) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, new Object[]{Float.valueOf(f10)});
    }

    private float[] u() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float L = L(floatValue2);
        float L2 = L(floatValue);
        if (isRtl()) {
            return new float[]{L2, L};
        }
        return new float[]{L, L2};
    }

    private static float v(ValueAnimator valueAnimator, float f10) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f10;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float w(int i10, float f10) {
        float f11;
        float f12;
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            minSeparation = j(minSeparation);
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i11 = i10 + 1;
        if (i11 >= this.values.size()) {
            f11 = this.valueTo;
        } else {
            f11 = this.values.get(i11).floatValue() - minSeparation;
        }
        int i12 = i10 - 1;
        if (i12 < 0) {
            f12 = this.valueFrom;
        } else {
            f12 = this.values.get(i12).floatValue() + minSeparation;
        }
        return MathUtils.clamp(f10, f12, f11);
    }

    private int x(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float y() {
        double Y = Y(this.touchPosition);
        if (isRtl()) {
            Y = 1.0d - Y;
        }
        float f10 = this.valueTo;
        float f11 = this.valueFrom;
        return (float) ((Y * ((double) (f10 - f11))) + ((double) f11));
    }

    private float z() {
        float f10 = this.touchPosition;
        if (isRtl()) {
            f10 = 1.0f - f10;
        }
        float f11 = this.valueTo;
        float f12 = this.valueFrom;
        return (f10 * (f11 - f12)) + f12;
    }

    public void addOnChangeListener(BaseOnChangeListener baseOnChangeListener) {
        this.changeListeners.add(baseOnChangeListener);
    }

    public void addOnSliderTouchListener(BaseOnSliderTouchListener baseOnSliderTouchListener) {
        this.touchListeners.add(baseOnSliderTouchListener);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(x(this.trackColorInactive));
        this.activeTrackPaint.setColor(x(this.trackColorActive));
        this.inactiveTicksPaint.setColor(x(this.tickColorInactive));
        this.activeTicksPaint.setColor(x(this.tickColorActive));
        for (TooltipDrawable next : this.labels) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.defaultThumbDrawable.isStateful()) {
            this.defaultThumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(x(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z10) {
        this.forceDrawCompatHalo = z10;
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    /* access modifiers changed from: protected */
    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable b10 : this.labels) {
            b(b10);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.accessibilityEventSender;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.labelsAreAnimatedIn = false;
        for (TooltipDrawable i10 : this.labels) {
            i(i10);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            d0();
            F();
        }
        super.onDraw(canvas);
        int f10 = f();
        n(canvas, this.trackWidth, f10);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            m(canvas, this.trackWidth, f10);
        }
        H(canvas);
        if ((this.thumbIsPressed || isFocused() || V()) && isEnabled()) {
            G(canvas, this.trackWidth, f10);
            if (this.activeThumbIdx != -1 || V()) {
                q();
            } else {
                r();
            }
        } else {
            r();
        }
        p(canvas, this.trackWidth, f10);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!z10) {
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        s(i10);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean M = M(i10, keyEvent);
            if (M != null) {
                return M.booleanValue();
            }
            return super.onKeyDown(i10, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float c10 = c(i10);
        if (c10 != null) {
            if (X(this.values.get(this.activeThumbIdx).floatValue() + c10.floatValue())) {
                b0();
                postInvalidate();
            }
            return true;
        }
        if (i10 != 23) {
            if (i10 != 61) {
                if (i10 != 66) {
                    return super.onKeyDown(i10, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return J(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return J(-1);
                }
                return false;
            }
        }
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i10, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12 = this.widgetHeight;
        int i13 = 0;
        if (this.labelBehavior == 1 || V()) {
            i13 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12 + i13, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.f8476a;
        this.valueTo = sliderState.f8477b;
        U(sliderState.f8478c);
        this.stepSize = sliderState.f8479d;
        if (sliderState.f8480e) {
            requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f8476a = this.valueFrom;
        sliderState.f8477b = this.valueTo;
        sliderState.f8478c = new ArrayList(this.values);
        sliderState.f8479d = this.stepSize;
        sliderState.f8480e = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        c0(i10);
        b0();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x10 = motionEvent.getX();
        float f10 = (x10 - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        this.touchPosition = f10;
        float max = Math.max(0.0f, f10);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x10;
            if (!C()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    a0();
                    b0();
                    invalidate();
                    N();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= ((float) this.scaledTouchSlop) && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= ((float) this.scaledTouchSlop) && pickActiveThumb()) {
                N();
            }
            if (this.activeThumbIdx != -1) {
                a0();
                this.activeThumbIdx = -1;
                O();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (C() && Math.abs(x10 - this.touchDownX) < ((float) this.scaledTouchSlop)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                N();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                a0();
                b0();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean pickActiveThumb() {
        boolean z10;
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float z11 = z();
        float k02 = k0(z11);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - z11);
        for (int i10 = 1; i10 < this.values.size(); i10++) {
            float abs2 = Math.abs(this.values.get(i10).floatValue() - z11);
            float k03 = k0(this.values.get(i10).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            if (!isRtl() ? k03 - k02 >= 0.0f : k03 - k02 <= 0.0f) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i10;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(k03 - k02) < ((float) this.scaledTouchSlop)) {
                    this.activeThumbIdx = -1;
                    return false;
                } else if (z10) {
                    this.activeThumbIdx = i10;
                }
            }
            abs = abs2;
        }
        if (this.activeThumbIdx != -1) {
            return true;
        }
        return false;
    }

    public void removeOnChangeListener(BaseOnChangeListener baseOnChangeListener) {
        this.changeListeners.remove(baseOnChangeListener);
    }

    public void removeOnSliderTouchListener(BaseOnSliderTouchListener baseOnSliderTouchListener) {
        this.touchListeners.remove(baseOnSliderTouchListener);
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int i10) {
        this.activeThumbIdx = i10;
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(int i10) {
        setCustomThumbDrawable(getResources().getDrawable(i10));
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            drawableArr[i10] = getResources().getDrawable(iArr[i10]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setEnabled(boolean z10) {
        int i10;
        super.setEnabled(z10);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        setLayerType(i10, (Paint) null);
    }

    public void setFocusedThumbIndex(int i10) {
        if (i10 < 0 || i10 >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i10;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i10);
        postInvalidate();
    }

    public void setHaloRadius(int i10) {
        if (i10 != this.haloRadius) {
            this.haloRadius = i10;
            Drawable background = getBackground();
            if (W() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
            }
        }
    }

    public void setHaloRadiusResource(int i10) {
        setHaloRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.haloColor)) {
            this.haloColor = colorStateList;
            Drawable background = getBackground();
            if (W() || !(background instanceof RippleDrawable)) {
                this.haloPaint.setColor(x(colorStateList));
                this.haloPaint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i10) {
        if (this.labelBehavior != i10) {
            this.labelBehavior = i10;
            requestLayout();
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    /* access modifiers changed from: protected */
    public void setSeparationUnit(int i10) {
        this.separationUnit = i10;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(f10), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
        } else if (this.stepSize != f10) {
            this.stepSize = f10;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f10) {
        this.defaultThumbDrawable.setElevation(f10);
    }

    public void setThumbElevationResource(int i10) {
        setThumbElevation(getResources().getDimension(i10));
    }

    public void setThumbRadius(int i10) {
        if (i10 != this.thumbRadius) {
            this.thumbRadius = i10;
            I();
            this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, (float) this.thumbRadius).build());
            MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
            int i11 = this.thumbRadius;
            materialShapeDrawable.setBounds(0, 0, i11 * 2, i11 * 2);
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                a(drawable);
            }
            for (Drawable a10 : this.customThumbDrawablesForValues) {
                a(a10);
            }
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int i10) {
        setThumbRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.defaultThumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i10));
        }
    }

    public void setThumbStrokeWidth(float f10) {
        this.defaultThumbDrawable.setStrokeWidth(f10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i10));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.defaultThumbDrawable.getFillColor())) {
            this.defaultThumbDrawable.setFillColor(colorStateList);
            invalidate();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList;
            this.activeTicksPaint.setColor(x(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList;
            this.inactiveTicksPaint.setColor(x(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z10) {
        if (this.tickVisible != z10) {
            this.tickVisible = z10;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList;
            this.activeTrackPaint.setColor(x(colorStateList));
            invalidate();
        }
    }

    public void setTrackHeight(int i10) {
        if (this.trackHeight != i10) {
            this.trackHeight = i10;
            B();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            this.inactiveTrackPaint.setColor(x(colorStateList));
            invalidate();
        }
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f10) {
        this.valueFrom = f10;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f10) {
        this.valueTo = f10;
        this.dirtyConfig = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        U(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void updateBoundsForVirturalViewId(int i10, Rect rect) {
        int L = this.trackSidePadding + ((int) (L(getValues().get(i10).floatValue()) * ((float) this.trackWidth)));
        int f10 = f();
        int i11 = this.thumbRadius;
        rect.set(L - i11, f10 - i11, L + i11, f10 + i11);
    }

    private class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f8486a;

        private d() {
            this.f8486a = -1;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            this.f8486a = i10;
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.f8486a, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i10, DEF_STYLE_RES), attributeSet, i10);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.defaultThumbDrawable = materialShapeDrawable;
        this.customThumbDrawablesForValues = Collections.emptyList();
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        E(context2.getResources());
        this.labelMaker = new a(attributeSet, i10);
        R(context2, attributeSet, i10);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.accessibilityHelper = eVar;
        ViewCompat.setAccessibilityDelegate(this, eVar);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(Drawable drawable) {
        this.customThumbDrawable = A(drawable);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        U(new ArrayList(list));
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable A : drawableArr) {
            this.customThumbDrawablesForValues.add(A(A));
        }
        postInvalidate();
    }
}
