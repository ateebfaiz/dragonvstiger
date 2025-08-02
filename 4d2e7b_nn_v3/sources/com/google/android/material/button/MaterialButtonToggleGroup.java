package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private static final String LOG_TAG = "MaterialButtonToggleGroup";
    private Set<Integer> checkedIds;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    @IdRes
    private final int defaultCheckId;
    private final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<c> originalCornerData;
    private final d pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i10, boolean z10);
    }

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.getIndexWithinVisibleButtons(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* renamed from: e  reason: collision with root package name */
        private static final CornerSize f7982e = new AbsoluteCornerSize(0.0f);

        /* renamed from: a  reason: collision with root package name */
        CornerSize f7983a;

        /* renamed from: b  reason: collision with root package name */
        CornerSize f7984b;

        /* renamed from: c  reason: collision with root package name */
        CornerSize f7985c;

        /* renamed from: d  reason: collision with root package name */
        CornerSize f7986d;

        c(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f7983a = cornerSize;
            this.f7984b = cornerSize3;
            this.f7985c = cornerSize4;
            this.f7986d = cornerSize2;
        }

        public static c a(c cVar) {
            CornerSize cornerSize = f7982e;
            return new c(cornerSize, cVar.f7986d, cornerSize, cVar.f7985c);
        }

        public static c b(c cVar, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return c(cVar);
            }
            return d(cVar);
        }

        public static c c(c cVar) {
            CornerSize cornerSize = cVar.f7983a;
            CornerSize cornerSize2 = cVar.f7986d;
            CornerSize cornerSize3 = f7982e;
            return new c(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static c d(c cVar) {
            CornerSize cornerSize = f7982e;
            return new c(cornerSize, cornerSize, cVar.f7984b, cVar.f7985c);
        }

        public static c e(c cVar, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return d(cVar);
            }
            return c(cVar);
        }

        public static c f(c cVar) {
            CornerSize cornerSize = cVar.f7983a;
            CornerSize cornerSize2 = f7982e;
            return new c(cornerSize, cornerSize2, cVar.f7984b, cornerSize2);
        }
    }

    private class d implements MaterialButton.a {
        private d() {
        }

        public void a(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ d(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
                MaterialButton childButton = getChildButton(i10);
                int min = Math.min(childButton.getStrokeWidth(), getChildButton(i10 - 1).getStrokeWidth());
                LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
                if (getOrientation() == 0) {
                    MarginLayoutParamsCompat.setMarginEnd(buildLayoutParams, 0);
                    MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, -min);
                    buildLayoutParams.topMargin = 0;
                } else {
                    buildLayoutParams.bottomMargin = 0;
                    buildLayoutParams.topMargin = -min;
                    MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, 0);
                }
                childButton.setLayoutParams(buildLayoutParams);
            }
            resetChildMargins(firstVisibleChildIndex);
        }
    }

    @NonNull
    private LinearLayout.LayoutParams buildLayoutParams(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void checkInternal(@IdRes int i10, boolean z10) {
        if (i10 == -1) {
            String str = LOG_TAG;
            Log.e(str, "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.checkedIds);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.singleSelection && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else if (!z10 && hashSet.contains(Integer.valueOf(i10))) {
            if (!this.selectionRequired || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        } else {
            return;
        }
        updateCheckedIds(hashSet);
    }

    private void dispatchOnButtonChecked(@IdRes int i10, boolean z10) {
        Iterator<OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i10, z10);
        }
    }

    private MaterialButton getChildButton(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (isChildVisible(i10)) {
                return i10;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int getIndexWithinVisibleButtons(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && isChildVisible(i11)) {
                i10++;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private c getNewCornerData(int i10, int i11, int i12) {
        boolean z10;
        c cVar = this.originalCornerData.get(i10);
        if (i11 == i12) {
            return cVar;
        }
        if (getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 == i11) {
            if (z10) {
                return c.e(cVar, this);
            }
            return c.f(cVar);
        } else if (i10 != i12) {
            return null;
        } else {
            if (z10) {
                return c.b(cVar, this);
            }
            return c.a(cVar);
        }
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && isChildVisible(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private boolean isChildVisible(int i10) {
        if (getChildAt(i10).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void resetChildMargins(int i10) {
        if (getChildCount() != 0 && i10 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i10).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setCheckedStateForView(@IdRes int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder builder, @Nullable c cVar) {
        if (cVar == null) {
            builder.setAllCornerSizes(0.0f);
        } else {
            builder.setTopLeftCornerSize(cVar.f7983a).setBottomLeftCornerSize(cVar.f7986d).setTopRightCornerSize(cVar.f7984b).setBottomRightCornerSize(cVar.f7985c);
        }
    }

    private void updateCheckedIds(Set<Integer> set) {
        Set<Integer> set2 = this.checkedIds;
        this.checkedIds = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = getChildButton(i10).getId();
            setCheckedStateForView(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                dispatchOnButtonChecked(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(getChildButton(i10), Integer.valueOf(i10));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.add(onButtonCheckedListener);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        checkInternal(materialButton.getId(), materialButton.isChecked());
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new c(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    public void check(@IdRes int i10) {
        checkInternal(i10, true);
    }

    public void clearChecked() {
        updateCheckedIds(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.singleSelection || this.checkedIds.isEmpty()) {
            return -1;
        }
        return this.checkedIds.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = getChildButton(i10).getId();
            if (this.checkedIds.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i11;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    /* access modifiers changed from: package-private */
    public void onButtonCheckedStateChanged(@NonNull MaterialButton materialButton, boolean z10) {
        if (!this.skipCheckedStateTracker) {
            checkInternal(materialButton.getId(), z10);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.defaultCheckId;
        if (i10 != -1) {
            updateCheckedIds(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (isSingleSelection()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, false, i10));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i10, i11);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal((MaterialButton.a) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalCornerData.remove(indexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.remove(onButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z10) {
        this.selectionRequired = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.singleSelection != z10) {
            this.singleSelection = z10;
            clearChecked();
        }
    }

    public void uncheck(@IdRes int i10) {
        checkInternal(i10, false);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton childButton = getChildButton(i10);
            if (childButton.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                updateBuilderWithCornerData(builder, getNewCornerData(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(builder.build());
            }
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.originalCornerData = r7
            com.google.android.material.button.MaterialButtonToggleGroup$d r7 = new com.google.android.material.button.MaterialButtonToggleGroup$d
            r0 = 0
            r7.<init>(r6, r0)
            r6.pressedStateTracker = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.onButtonCheckedListeners = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.childOrderComparator = r7
            r7 = 0
            r6.skipCheckedStateTracker = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.checkedIds = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection((boolean) r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.defaultCheckId = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.selectionRequired = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
