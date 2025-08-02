package com.facebook.react.views.textinput;

import android.text.SpannableStringBuilder;
import android.widget.EditText;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final SpannableStringBuilder f4351a;

    /* renamed from: b  reason: collision with root package name */
    private final float f4352b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4353c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4354d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4355e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4356f;

    /* renamed from: g  reason: collision with root package name */
    private final CharSequence f4357g;

    public q(EditText editText) {
        this.f4351a = new SpannableStringBuilder(editText.getText());
        this.f4352b = editText.getTextSize();
        this.f4355e = editText.getInputType();
        this.f4357g = editText.getHint();
        this.f4353c = editText.getMinLines();
        this.f4354d = editText.getMaxLines();
        this.f4356f = editText.getBreakStrategy();
    }

    public void a(EditText editText) {
        editText.setText(this.f4351a);
        editText.setTextSize(0, this.f4352b);
        editText.setMinLines(this.f4353c);
        editText.setMaxLines(this.f4354d);
        editText.setInputType(this.f4355e);
        editText.setHint(this.f4357g);
        editText.setBreakStrategy(this.f4356f);
    }
}
