package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class c implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f8716a;

    public c(int i10) {
        this.f8716a = i10;
    }

    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        try {
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i12, i13, charSequence.subSequence(i10, i11).toString());
            if (Integer.parseInt(sb2.toString()) <= this.f8716a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
