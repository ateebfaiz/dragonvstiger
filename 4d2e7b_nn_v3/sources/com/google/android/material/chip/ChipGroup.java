package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import java.util.List;
import java.util.Set;

public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    /* access modifiers changed from: private */
    public final CheckableGroup<Chip> checkableGroup;
    @Dimension
    private int chipSpacingHorizontal;
    @Dimension
    private int chipSpacingVertical;
    private final int defaultCheckedId;
    /* access modifiers changed from: private */
    @Nullable
    public OnCheckedStateChangeListener onCheckedStateChangeListener;
    @NonNull
    private final c passThroughListener;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Deprecated
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@NonNull ChipGroup chipGroup, @IdRes int i10);
    }

    public interface OnCheckedStateChangeListener {
        void onCheckedChanged(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list);
    }

    class a implements CheckableGroup.OnCheckedStateChangeListener {
        a() {
        }

        public void onCheckedStateChanged(Set set) {
            if (ChipGroup.this.onCheckedStateChangeListener != null) {
                OnCheckedStateChangeListener access$100 = ChipGroup.this.onCheckedStateChangeListener;
                ChipGroup chipGroup = ChipGroup.this;
                access$100.onCheckedChanged(chipGroup, chipGroup.checkableGroup.getCheckedIdsSortedByChildOrder(ChipGroup.this));
            }
        }
    }

    class b implements OnCheckedStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnCheckedChangeListener f8037a;

        b(OnCheckedChangeListener onCheckedChangeListener) {
            this.f8037a = onCheckedChangeListener;
        }

        public void onCheckedChanged(ChipGroup chipGroup, List list) {
            if (ChipGroup.this.checkableGroup.isSingleSelection()) {
                this.f8037a.onCheckedChanged(chipGroup, ChipGroup.this.getCheckedChipId());
            }
        }
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f8039a;

        private c() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                ChipGroup.this.checkableGroup.addCheckable((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8039a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.checkableGroup.removeCheckable((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8039a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        /* synthetic */ c(ChipGroup chipGroup, a aVar) {
            this();
        }
    }

    public ChipGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                i10++;
            }
        }
        return i10;
    }

    public void check(@IdRes int i10) {
        this.checkableGroup.check(i10);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!super.checkLayoutParams(layoutParams) || !(layoutParams instanceof LayoutParams)) {
            return false;
        }
        return true;
    }

    public void clearCheck() {
        this.checkableGroup.clearCheck();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.checkableGroup.getSingleCheckedId();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.checkableGroup.getCheckedIdsSortedByChildOrder(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    /* access modifiers changed from: package-private */
    public int getIndexOfChip(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                if (((Chip) getChildAt(i11)) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public boolean isSelectionRequired() {
        return this.checkableGroup.isSelectionRequired();
    }

    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.checkableGroup.isSingleSelection();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.defaultCheckedId;
        if (i10 != -1) {
            this.checkableGroup.check(i10);
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        int i11;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        if (isSingleLine()) {
            i10 = getChipCount();
        } else {
            i10 = -1;
        }
        int rowCount = getRowCount();
        if (isSingleSelection()) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(rowCount, i10, false, i11));
    }

    public void setChipSpacing(@Dimension int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(@Dimension int i10) {
        if (this.chipSpacingHorizontal != i10) {
            this.chipSpacingHorizontal = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(@DimenRes int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(@Dimension int i10) {
        if (this.chipSpacingVertical != i10) {
            this.chipSpacingVertical = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            setOnCheckedStateChangeListener((OnCheckedStateChangeListener) null);
        } else {
            setOnCheckedStateChangeListener(new b(onCheckedChangeListener));
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener onCheckedStateChangeListener2) {
        this.onCheckedStateChangeListener = onCheckedStateChangeListener2;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.passThroughListener.f8039a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z10) {
        this.checkableGroup.setSelectionRequired(z10);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        this.checkableGroup.setSingleSelection(z10);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    public void setSingleSelection(@BoolRes int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChipGroup(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            com.google.android.material.internal.CheckableGroup r9 = new com.google.android.material.internal.CheckableGroup
            r9.<init>()
            r8.checkableGroup = r9
            com.google.android.material.chip.ChipGroup$c r6 = new com.google.android.material.chip.ChipGroup$c
            r0 = 0
            r6.<init>(r8, r0)
            r8.passThroughListener = r6
            android.content.Context r0 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.ChipGroup
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.ChipGroup_chipSpacing
            int r11 = r10.getDimensionPixelOffset(r11, r7)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical
            int r11 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingVertical(r11)
            int r11 = com.google.android.material.R.styleable.ChipGroup_singleLine
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleLine((boolean) r11)
            int r11 = com.google.android.material.R.styleable.ChipGroup_singleSelection
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleSelection((boolean) r11)
            int r11 = com.google.android.material.R.styleable.ChipGroup_selectionRequired
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSelectionRequired(r11)
            int r11 = com.google.android.material.R.styleable.ChipGroup_checkedChip
            r0 = -1
            int r11 = r10.getResourceId(r11, r0)
            r8.defaultCheckedId = r11
            r10.recycle()
            com.google.android.material.chip.ChipGroup$a r10 = new com.google.android.material.chip.ChipGroup$a
            r10.<init>()
            r9.setOnCheckedStateChangeListener(r10)
            super.setOnHierarchyChangeListener(r6)
            r9 = 1
            androidx.core.view.ViewCompat.setImportantForAccessibility(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
