package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

class f implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final ChipTextInputComboView f8727a;

    /* renamed from: b  reason: collision with root package name */
    private final ChipTextInputComboView f8728b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeModel f8729c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8730d = false;

    f(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f8727a = chipTextInputComboView;
        this.f8728b = chipTextInputComboView2;
        this.f8729c = timeModel;
    }

    private void b(int i10) {
        boolean z10;
        ChipTextInputComboView chipTextInputComboView = this.f8728b;
        boolean z11 = false;
        if (i10 == 12) {
            z10 = true;
        } else {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
        ChipTextInputComboView chipTextInputComboView2 = this.f8727a;
        if (i10 == 10) {
            z11 = true;
        }
        chipTextInputComboView2.setChecked(z11);
        this.f8729c.f8699f = i10;
    }

    private boolean c(int i10, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null || i10 < 7 || i10 > 16 || keyEvent.getAction() != 1 || editText.getSelectionStart() != 2 || text.length() != 2) {
            return false;
        }
        b(12);
        return true;
    }

    private boolean d(int i10, KeyEvent keyEvent, EditText editText) {
        if (i10 != 67 || keyEvent.getAction() != 0 || !TextUtils.isEmpty(editText.getText())) {
            return false;
        }
        b(10);
        return true;
    }

    public void a() {
        TextInputLayout e10 = this.f8727a.e();
        TextInputLayout e11 = this.f8728b.e();
        EditText editText = e10.getEditText();
        EditText editText2 = e11.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        boolean z10;
        if (i10 == 5) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            b(12);
        }
        return z10;
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        if (this.f8730d) {
            return false;
        }
        this.f8730d = true;
        EditText editText = (EditText) view;
        if (this.f8729c.f8699f == 12) {
            z10 = d(i10, keyEvent, editText);
        } else {
            z10 = c(i10, keyEvent, editText);
        }
        this.f8730d = false;
        return z10;
    }
}
