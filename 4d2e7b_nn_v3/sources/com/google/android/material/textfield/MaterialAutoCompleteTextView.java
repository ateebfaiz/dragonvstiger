package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;
    @Nullable
    private final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    @NonNull
    public final ListPopupWindow modalListPopup;
    @LayoutRes
    private final int simpleItemLayout;
    @NonNull
    private final Rect tempRect;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            Object obj;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            if (i10 < 0) {
                obj = materialAutoCompleteTextView.modalListPopup.getSelectedItem();
            } else {
                obj = materialAutoCompleteTextView.getAdapter().getItem(i10);
            }
            MaterialAutoCompleteTextView.this.updateText(obj);
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedView();
                    i10 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemPosition();
                    j10 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemId();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.modalListPopup.getListView(), view, i10, j10);
            }
            MaterialAutoCompleteTextView.this.modalListPopup.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int measureContentWidth() {
        ListAdapter adapter = getAdapter();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i10 = 0;
        if (adapter == null || findTextInputLayoutAncestor == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        View view = null;
        int i11 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(max, view, findTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        Drawable background = this.modalListPopup.getBackground();
        if (background != null) {
            background.getPadding(this.tempRect);
            Rect rect = this.tempRect;
            i11 += rect.left + rect.right;
        }
        return i11 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void updateText(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Nullable
    public CharSequence getHint() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor == null || !findTextInputLayoutAncestor.isProvidingHint()) {
            return super.getHint();
        }
        return findTextInputLayoutAncestor.getHint();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t10) {
        super.setAdapter(t10);
        this.modalListPopup.setAdapter(getAdapter());
    }

    public void setSimpleItems(@ArrayRes int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 == null || !accessibilityManager2.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.modalListPopup.show();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.simpleItemLayout, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i10, 0), attributeSet, i10);
        this.tempRect = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialAutoCompleteTextView, i10, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialAutoCompleteTextView_android_inputType) && obtainStyledAttributes.getInt(R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.simpleItemLayout = obtainStyledAttributes.getResourceId(R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, R.layout.mtrl_auto_complete_simple_item);
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new a());
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(R.styleable.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
