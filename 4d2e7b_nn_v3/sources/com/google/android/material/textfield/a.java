package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

class a extends f {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f8566e = new C0098a();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View.OnFocusChangeListener f8567f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f8568g = new c();

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f8569h = new d();

    /* renamed from: i  reason: collision with root package name */
    private AnimatorSet f8570i;

    /* renamed from: j  reason: collision with root package name */
    private ValueAnimator f8571j;

    /* renamed from: com.google.android.material.textfield.a$a  reason: collision with other inner class name */
    class C0098a implements TextWatcher {
        C0098a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.f8618a.getSuffixText() == null) {
                a aVar = a.this;
                aVar.i(aVar.m());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        public void onFocusChange(View view, boolean z10) {
            a aVar = a.this;
            aVar.i(aVar.m());
        }
    }

    class c implements TextInputLayout.OnEditTextAttachedListener {
        c() {
        }

        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.this.m());
            editText.setOnFocusChangeListener(a.this.f8567f);
            a aVar = a.this;
            aVar.f8620c.setOnFocusChangeListener(aVar.f8567f);
            editText.removeTextChangedListener(a.this.f8566e);
            editText.addTextChangedListener(a.this.f8566e);
        }
    }

    class d implements TextInputLayout.OnEndIconChangedListener {

        /* renamed from: com.google.android.material.textfield.a$d$a  reason: collision with other inner class name */
        class C0099a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f8576a;

            C0099a(EditText editText) {
                this.f8576a = editText;
            }

            public void run() {
                this.f8576a.removeTextChangedListener(a.this.f8566e);
                a.this.i(true);
            }
        }

        d() {
        }

        public void onEndIconChanged(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i10 == 2) {
                editText.post(new C0099a(editText));
                if (editText.getOnFocusChangeListener() == a.this.f8567f) {
                    editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
                if (a.this.f8620c.getOnFocusChangeListener() == a.this.f8567f) {
                    a.this.f8620c.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Editable text = a.this.f8618a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f8618a.refreshEndIconDrawableState();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        public void onAnimationStart(Animator animator) {
            a.this.f8618a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f8618a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f8620c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f8620c.setScaleX(floatValue);
            a.this.f8620c.setScaleY(floatValue);
        }
    }

    a(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    /* access modifiers changed from: private */
    public void i(boolean z10) {
        boolean z11;
        if (this.f8618a.isEndIconVisible() == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && !this.f8570i.isRunning()) {
            this.f8571j.cancel();
            this.f8570i.start();
            if (z11) {
                this.f8570i.end();
            }
        } else if (!z10) {
            this.f8570i.cancel();
            this.f8571j.start();
            if (z11) {
                this.f8571j.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private void l() {
        ValueAnimator k10 = k();
        ValueAnimator j10 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8570i = animatorSet;
        animatorSet.playTogether(new Animator[]{k10, j10});
        this.f8570i.addListener(new f());
        ValueAnimator j11 = j(1.0f, 0.0f);
        this.f8571j = j11;
        j11.addListener(new g());
    }

    /* access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.f8618a.getEditText();
        if (editText == null || ((!editText.hasFocus() && !this.f8620c.hasFocus()) || editText.getText().length() <= 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        TextInputLayout textInputLayout = this.f8618a;
        int i10 = this.f8621d;
        if (i10 == 0) {
            i10 = R.drawable.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f8618a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f8618a.setEndIconCheckable(false);
        this.f8618a.setEndIconOnClickListener(new e());
        this.f8618a.addOnEditTextAttachedListener(this.f8568g);
        this.f8618a.addOnEndIconChangedListener(this.f8569h);
        l();
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z10) {
        if (this.f8618a.getSuffixText() != null) {
            i(z10);
        }
    }
}
