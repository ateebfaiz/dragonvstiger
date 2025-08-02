package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Chip f8658a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f8659b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f8660c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f8661d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f8662e;

    private class b extends TextWatcherAdapter {
        private b() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f8658a.setText(ChipTextInputComboView.this.d("00"));
            } else {
                ChipTextInputComboView.this.f8658a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f8660c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f8660c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f8660c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f8659b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f8658a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        this.f8658a.setText(d(charSequence));
        if (!TextUtils.isEmpty(this.f8660c.getText())) {
            this.f8660c.removeTextChangedListener(this.f8661d);
            this.f8660c.setText((CharSequence) null);
            this.f8660c.addTextChangedListener(this.f8661d);
        }
    }

    public boolean isChecked() {
        return this.f8658a.isChecked();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    public void setChecked(boolean z10) {
        int i10;
        this.f8658a.setChecked(z10);
        EditText editText = this.f8660c;
        int i11 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        editText.setVisibility(i10);
        Chip chip = this.f8658a;
        if (z10) {
            i11 = 8;
        }
        chip.setVisibility(i11);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.f8660c);
            if (!TextUtils.isEmpty(this.f8660c.getText())) {
                EditText editText2 = this.f8660c;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8658a.setOnClickListener(onClickListener);
    }

    public void setTag(int i10, Object obj) {
        this.f8658a.setTag(i10, obj);
    }

    public void toggle() {
        this.f8658a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, this, false);
        this.f8658a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, this, false);
        this.f8659b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f8660c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f8661d = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f8662e = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
