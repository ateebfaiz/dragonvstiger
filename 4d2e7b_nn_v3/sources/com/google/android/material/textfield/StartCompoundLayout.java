package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

@SuppressLint({"ViewConstructor"})
class StartCompoundLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f8549a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f8550b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f8551c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckableImageButton f8552d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f8553e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f8554f;

    /* renamed from: g  reason: collision with root package name */
    private View.OnLongClickListener f8555g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8556h;

    StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f8549a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.f8552d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f8550b = appCompatTextView;
        g(tintTypedArray);
        f(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void f(TintTypedArray tintTypedArray) {
        this.f8550b.setVisibility(8);
        this.f8550b.setId(R.id.textinput_prefix_text);
        this.f8550b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f8550b, 1);
        m(tintTypedArray.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        if (tintTypedArray.hasValue(R.styleable.TextInputLayout_prefixTextColor)) {
            n(tintTypedArray.getColorStateList(R.styleable.TextInputLayout_prefixTextColor));
        }
        l(tintTypedArray.getText(R.styleable.TextInputLayout_prefixText));
    }

    private void g(TintTypedArray tintTypedArray) {
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f8552d.getLayoutParams(), 0);
        }
        r((View.OnClickListener) null);
        s((View.OnLongClickListener) null);
        if (tintTypedArray.hasValue(R.styleable.TextInputLayout_startIconTint)) {
            this.f8553e = MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.TextInputLayout_startIconTint);
        }
        if (tintTypedArray.hasValue(R.styleable.TextInputLayout_startIconTintMode)) {
            this.f8554f = ViewUtils.parseTintMode(tintTypedArray.getInt(R.styleable.TextInputLayout_startIconTintMode, -1), (PorterDuff.Mode) null);
        }
        if (tintTypedArray.hasValue(R.styleable.TextInputLayout_startIconDrawable)) {
            q(tintTypedArray.getDrawable(R.styleable.TextInputLayout_startIconDrawable));
            if (tintTypedArray.hasValue(R.styleable.TextInputLayout_startIconContentDescription)) {
                p(tintTypedArray.getText(R.styleable.TextInputLayout_startIconContentDescription));
            }
            o(tintTypedArray.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        }
    }

    private void y() {
        int i10;
        int i11 = 8;
        if (this.f8551c == null || this.f8556h) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (this.f8552d.getVisibility() == 0 || i10 == 0) {
            i11 = 0;
        }
        setVisibility(i11);
        this.f8550b.setVisibility(i10);
        this.f8549a.updateDummyDrawables();
    }

    /* access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f8551c;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f8550b.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public TextView c() {
        return this.f8550b;
    }

    /* access modifiers changed from: package-private */
    public CharSequence d() {
        return this.f8552d.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public Drawable e() {
        return this.f8552d.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f8552d.isCheckable();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (this.f8552d.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10) {
        this.f8556h = z10;
        y();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        g.c(this.f8549a, this.f8552d, this.f8553e);
    }

    /* access modifiers changed from: package-private */
    public void l(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f8551c = charSequence2;
        this.f8550b.setText(charSequence);
        y();
    }

    /* access modifiers changed from: package-private */
    public void m(int i10) {
        TextViewCompat.setTextAppearance(this.f8550b, i10);
    }

    /* access modifiers changed from: package-private */
    public void n(ColorStateList colorStateList) {
        this.f8550b.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10) {
        this.f8552d.setCheckable(z10);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        x();
    }

    /* access modifiers changed from: package-private */
    public void p(CharSequence charSequence) {
        if (d() != charSequence) {
            this.f8552d.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(Drawable drawable) {
        this.f8552d.setImageDrawable(drawable);
        if (drawable != null) {
            g.a(this.f8549a, this.f8552d, this.f8553e, this.f8554f);
            v(true);
            k();
            return;
        }
        v(false);
        r((View.OnClickListener) null);
        s((View.OnLongClickListener) null);
        p((CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public void r(View.OnClickListener onClickListener) {
        g.e(this.f8552d, onClickListener, this.f8555g);
    }

    /* access modifiers changed from: package-private */
    public void s(View.OnLongClickListener onLongClickListener) {
        this.f8555g = onLongClickListener;
        g.f(this.f8552d, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void t(ColorStateList colorStateList) {
        if (this.f8553e != colorStateList) {
            this.f8553e = colorStateList;
            g.a(this.f8549a, this.f8552d, colorStateList, this.f8554f);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(PorterDuff.Mode mode) {
        if (this.f8554f != mode) {
            this.f8554f = mode;
            g.a(this.f8549a, this.f8552d, this.f8553e, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(boolean z10) {
        int i10;
        if (i() != z10) {
            CheckableImageButton checkableImageButton = this.f8552d;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            x();
            y();
        }
    }

    /* access modifiers changed from: package-private */
    public void w(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f8550b.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setLabelFor(this.f8550b);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f8550b);
            return;
        }
        accessibilityNodeInfoCompat.setTraversalAfter(this.f8552d);
    }

    /* access modifiers changed from: package-private */
    public void x() {
        int i10;
        EditText editText = this.f8549a.editText;
        if (editText != null) {
            if (i()) {
                i10 = 0;
            } else {
                i10 = ViewCompat.getPaddingStart(editText);
            }
            ViewCompat.setPaddingRelative(this.f8550b, i10, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
        }
    }
}
