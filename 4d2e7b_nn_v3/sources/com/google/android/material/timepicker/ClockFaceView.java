package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private final int C;
    private final int N0;
    private final int O0;
    private String[] P0;
    private float Q0;
    private final ColorStateList R0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ClockHandView f8664d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f8665e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f8666f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray f8667g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityDelegateCompat f8668h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f8669i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f8670j;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final int f8671w;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.c(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f8664d.g()) - ClockFaceView.this.f8671w);
            return true;
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f8667g.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            float x10 = view.getX() + (((float) view.getWidth()) / 2.0f);
            long j10 = uptimeMillis;
            float f10 = x10;
            float height = (((float) view.getHeight()) / 2.0f) + view.getY();
            ClockFaceView.this.f8664d.onTouchEvent(MotionEvent.obtain(uptimeMillis, j10, 0, f10, height, 0));
            ClockFaceView.this.f8664d.onTouchEvent(MotionEvent.obtain(uptimeMillis, j10, 1, f10, height, 0));
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void j() {
        RectF d10 = this.f8664d.d();
        for (int i10 = 0; i10 < this.f8667g.size(); i10++) {
            TextView textView = (TextView) this.f8667g.get(i10);
            if (textView != null) {
                textView.getDrawingRect(this.f8665e);
                offsetDescendantRectToMyCoords(textView, this.f8665e);
                textView.setSelected(d10.contains((float) this.f8665e.centerX(), (float) this.f8665e.centerY()));
                textView.getPaint().setShader(k(d10, this.f8665e, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient k(RectF rectF, Rect rect, TextView textView) {
        this.f8666f.set(rect);
        this.f8666f.offset((float) textView.getPaddingLeft(), (float) textView.getPaddingTop());
        if (!RectF.intersects(rectF, this.f8666f)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f8666f.left, rectF.centerY() - this.f8666f.top, rectF.width() * 0.5f, this.f8669i, this.f8670j, Shader.TileMode.CLAMP);
    }

    private static float l(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    private void n(int i10) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f8667g.size();
        for (int i11 = 0; i11 < Math.max(this.P0.length, size); i11++) {
            TextView textView = (TextView) this.f8667g.get(i11);
            if (i11 >= this.P0.length) {
                removeView(textView);
                this.f8667g.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, this, false);
                    this.f8667g.put(i11, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.P0[i11]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i11));
                ViewCompat.setAccessibilityDelegate(textView, this.f8668h);
                textView.setTextColor(this.R0);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, new Object[]{this.P0[i11]}));
                }
            }
        }
    }

    public void c(int i10) {
        if (i10 != b()) {
            super.c(i10);
            this.f8664d.k(b());
        }
    }

    public void m(String[] strArr, int i10) {
        this.P0 = strArr;
        n(i10);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.P0.length, false, 1));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        j();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int l10 = (int) (((float) this.O0) / l(((float) this.C) / ((float) displayMetrics.heightPixels), ((float) this.N0) / ((float) displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(l10, 1073741824);
        setMeasuredDimension(l10, l10);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void onRotate(float f10, boolean z10) {
        if (Math.abs(this.Q0 - f10) > 0.001f) {
            this.Q0 = f10;
            j();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8665e = new Rect();
        this.f8666f = new RectF();
        this.f8667g = new SparseArray();
        this.f8670j = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.R0 = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f8664d = clockHandView;
        this.f8671w = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{16842913}, colorStateList.getDefaultColor());
        this.f8669i = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f8668h = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        m(strArr, 0);
        this.C = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.N0 = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.O0 = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
