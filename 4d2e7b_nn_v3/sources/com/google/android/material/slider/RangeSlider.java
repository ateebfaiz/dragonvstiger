package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider<RangeSlider, OnChangeListener, OnSliderTouchListener> {
    private float minSeparation;
    private int separationUnit;

    public interface OnChangeListener extends BaseOnChangeListener<RangeSlider> {
        void onValueChange(@NonNull RangeSlider rangeSlider, float f10, boolean z10);
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<RangeSlider> {
        void onStartTrackingTouch(@NonNull RangeSlider rangeSlider);

        void onStopTrackingTouch(@NonNull RangeSlider rangeSlider);
    }

    static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new a();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public float f8490a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f8491b;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public RangeSliderState createFromParcel(Parcel parcel) {
                return new RangeSliderState(parcel);
            }

            /* renamed from: b */
            public RangeSliderState[] newArray(int i10) {
                return new RangeSliderState[i10];
            }
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f8490a);
            parcel.writeInt(this.f8491b);
        }

        RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.f8490a = parcel.readFloat();
            this.f8491b = parcel.readInt();
        }
    }

    public RangeSlider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static List<Float> convertToFloat(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < typedArray.length(); i10++) {
            arrayList.add(Float.valueOf(typedArray.getFloat(i10, -1.0f)));
        }
        return arrayList;
    }

    public /* bridge */ /* synthetic */ void addOnChangeListener(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.addOnChangeListener(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ void addOnSliderTouchListener(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.addOnSliderTouchListener(baseOnSliderTouchListener);
    }

    public /* bridge */ /* synthetic */ void clearOnChangeListeners() {
        super.clearOnChangeListeners();
    }

    public /* bridge */ /* synthetic */ void clearOnSliderTouchListeners() {
        super.clearOnSliderTouchListeners();
    }

    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    public float getMinSeparation() {
        return this.minSeparation;
    }

    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @NonNull
    public List<Float> getValues() {
        return super.getValues();
    }

    public /* bridge */ /* synthetic */ boolean hasLabelFormatter() {
        return super.hasLabelFormatter();
    }

    public /* bridge */ /* synthetic */ boolean isTickVisible() {
        return super.isTickVisible();
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i10, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i10, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i10, @NonNull KeyEvent keyEvent) {
        return super.onKeyUp(i10, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.minSeparation = rangeSliderState.f8490a;
        int c10 = rangeSliderState.f8491b;
        this.separationUnit = c10;
        setSeparationUnit(c10);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        float unused = rangeSliderState.f8490a = this.minSeparation;
        int unused2 = rangeSliderState.f8491b = this.separationUnit;
        return rangeSliderState;
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void removeOnChangeListener(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.removeOnChangeListener(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ void removeOnSliderTouchListener(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.removeOnSliderTouchListener(baseOnSliderTouchListener);
    }

    public void setCustomThumbDrawable(@DrawableRes int i10) {
        super.setCustomThumbDrawable(i10);
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        super.setCustomThumbDrawablesForValues(iArr);
    }

    public /* bridge */ /* synthetic */ void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i10) {
        super.setFocusedThumbIndex(i10);
    }

    public /* bridge */ /* synthetic */ void setHaloRadius(@Dimension @IntRange(from = 0) int i10) {
        super.setHaloRadius(i10);
    }

    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int i10) {
        super.setHaloRadiusResource(i10);
    }

    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setLabelBehavior(int i10) {
        super.setLabelBehavior(i10);
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        super.setLabelFormatter(labelFormatter);
    }

    public void setMinSeparation(@Dimension float f10) {
        this.minSeparation = f10;
        this.separationUnit = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f10) {
        this.minSeparation = f10;
        this.separationUnit = 1;
        setSeparationUnit(1);
    }

    public /* bridge */ /* synthetic */ void setStepSize(float f10) {
        super.setStepSize(f10);
    }

    public /* bridge */ /* synthetic */ void setThumbElevation(float f10) {
        super.setThumbElevation(f10);
    }

    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int i10) {
        super.setThumbElevationResource(i10);
    }

    public /* bridge */ /* synthetic */ void setThumbRadius(@Dimension @IntRange(from = 0) int i10) {
        super.setThumbRadius(i10);
    }

    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int i10) {
        super.setThumbRadiusResource(i10);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int i10) {
        super.setThumbStrokeColorResource(i10);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f10) {
        super.setThumbStrokeWidth(f10);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int i10) {
        super.setThumbStrokeWidthResource(i10);
    }

    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickVisible(boolean z10) {
        super.setTickVisible(z10);
    }

    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackHeight(@Dimension @IntRange(from = 0) int i10) {
        super.setTrackHeight(i10);
    }

    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setValueFrom(float f10) {
        super.setValueFrom(f10);
    }

    public /* bridge */ /* synthetic */ void setValueTo(float f10) {
        super.setValueTo(f10);
    }

    public void setValues(@NonNull Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        super.setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setValues(@NonNull List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.RangeSlider, i10, BaseSlider.DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(R.styleable.RangeSlider_values)) {
            setValues(convertToFloat(obtainStyledAttributes.getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(R.styleable.RangeSlider_values, 0))));
        }
        this.minSeparation = obtainStyledAttributes.getDimension(R.styleable.RangeSlider_minSeparation, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
