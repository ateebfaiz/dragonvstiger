package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8622a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f8623b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f8624c;

    /* renamed from: d  reason: collision with root package name */
    private int f8625d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f8626e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Animator f8627f;

    /* renamed from: g  reason: collision with root package name */
    private final float f8628g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8629h;

    /* renamed from: i  reason: collision with root package name */
    private int f8630i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f8631j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8632k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public TextView f8633l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f8634m;

    /* renamed from: n  reason: collision with root package name */
    private int f8635n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f8636o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f8637p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8638q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f8639r;

    /* renamed from: s  reason: collision with root package name */
    private int f8640s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f8641t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f8642u;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f8644b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8645c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f8646d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f8643a = i10;
            this.f8644b = textView;
            this.f8645c = i11;
            this.f8646d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            int unused = h.this.f8629h = this.f8643a;
            Animator unused2 = h.this.f8627f = null;
            TextView textView = this.f8644b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8645c == 1 && h.this.f8633l != null) {
                    h.this.f8633l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f8646d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f8646d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8646d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = h.this.f8623b.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public h(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f8622a = context;
        this.f8623b = textInputLayout;
        this.f8628g = (float) context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private void E(int i10, int i11) {
        TextView m10;
        TextView m11;
        if (i10 != i11) {
            if (!(i11 == 0 || (m11 = m(i11)) == null)) {
                m11.setVisibility(0);
                m11.setAlpha(1.0f);
            }
            if (!(i10 == 0 || (m10 = m(i10)) == null)) {
                m10.setVisibility(4);
                if (i10 == 1) {
                    m10.setText((CharSequence) null);
                }
            }
            this.f8629h = i11;
        }
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        if (!ViewCompat.isLaidOut(this.f8623b) || !this.f8623b.isEnabled() || (this.f8630i == this.f8629h && textView != null && TextUtils.equals(textView.getText(), charSequence))) {
            return false;
        }
        return true;
    }

    private void S(int i10, int i11, boolean z10) {
        boolean z11 = z10;
        if (i10 != i11) {
            if (z11) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f8627f = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i12 = i10;
                int i13 = i11;
                i(arrayList2, this.f8638q, this.f8639r, 2, i12, i13);
                i(arrayList2, this.f8632k, this.f8633l, 1, i12, i13);
                AnimatorSetCompat.playTogether(animatorSet, arrayList);
                animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
                animatorSet.start();
            } else {
                E(i10, i11);
            }
            this.f8623b.updateEditTextBackground();
            this.f8623b.updateLabelState(z11);
            this.f8623b.updateTextInputBoxState();
        }
    }

    private boolean g() {
        if (this.f8624c == null || this.f8623b.getEditText() == null) {
            return false;
        }
        return true;
    }

    private void i(List list, boolean z10, TextView textView, int i10, int i11, int i12) {
        boolean z11;
        if (textView != null && z10) {
            if (i10 == i12 || i10 == i11) {
                if (i12 == i10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                list.add(j(textView, z11));
                if (i12 == i10) {
                    list.add(k(textView));
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z10) {
        float f10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{f10});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f8628g, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return ofFloat;
    }

    private TextView m(int i10) {
        if (i10 == 1) {
            return this.f8633l;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f8639r;
    }

    private int u(boolean z10, int i10, int i11) {
        if (z10) {
            return this.f8622a.getResources().getDimensionPixelSize(i10);
        }
        return i11;
    }

    private boolean y(int i10) {
        if (i10 != 1 || this.f8633l == null || TextUtils.isEmpty(this.f8631j)) {
            return false;
        }
        return true;
    }

    private boolean z(int i10) {
        if (i10 != 2 || this.f8639r == null || TextUtils.isEmpty(this.f8637p)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean A(int i10) {
        return i10 == 0 || i10 == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return this.f8632k;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f8638q;
    }

    /* access modifiers changed from: package-private */
    public void D(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f8624c != null) {
            if (!A(i10) || (frameLayout = this.f8626e) == null) {
                this.f8624c.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i11 = this.f8625d - 1;
            this.f8625d = i11;
            O(this.f8624c, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(CharSequence charSequence) {
        this.f8634m = charSequence;
        TextView textView = this.f8633l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(boolean z10) {
        if (this.f8632k != z10) {
            h();
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8622a);
                this.f8633l = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                this.f8633l.setTextAlignment(5);
                Typeface typeface = this.f8642u;
                if (typeface != null) {
                    this.f8633l.setTypeface(typeface);
                }
                H(this.f8635n);
                I(this.f8636o);
                F(this.f8634m);
                this.f8633l.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f8633l, 1);
                e(this.f8633l, 0);
            } else {
                w();
                D(this.f8633l, 0);
                this.f8633l = null;
                this.f8623b.updateEditTextBackground();
                this.f8623b.updateTextInputBoxState();
            }
            this.f8632k = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i10) {
        this.f8635n = i10;
        TextView textView = this.f8633l;
        if (textView != null) {
            this.f8623b.setTextAppearanceCompatWithErrorFallback(textView, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        this.f8636o = colorStateList;
        TextView textView = this.f8633l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int i10) {
        this.f8640s = i10;
        TextView textView = this.f8639r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (this.f8638q != z10) {
            h();
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8622a);
                this.f8639r = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                this.f8639r.setTextAlignment(5);
                Typeface typeface = this.f8642u;
                if (typeface != null) {
                    this.f8639r.setTypeface(typeface);
                }
                this.f8639r.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f8639r, 1);
                J(this.f8640s);
                L(this.f8641t);
                e(this.f8639r, 1);
                this.f8639r.setAccessibilityDelegate(new b());
            } else {
                x();
                D(this.f8639r, 1);
                this.f8639r = null;
                this.f8623b.updateEditTextBackground();
                this.f8623b.updateTextInputBoxState();
            }
            this.f8638q = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        this.f8641t = colorStateList;
        TextView textView = this.f8639r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.f8642u) {
            this.f8642u = typeface;
            M(this.f8633l, typeface);
            M(this.f8639r, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        h();
        this.f8631j = charSequence;
        this.f8633l.setText(charSequence);
        int i10 = this.f8629h;
        if (i10 != 1) {
            this.f8630i = 1;
        }
        S(i10, this.f8630i, P(this.f8633l, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void R(CharSequence charSequence) {
        h();
        this.f8637p = charSequence;
        this.f8639r.setText(charSequence);
        int i10 = this.f8629h;
        if (i10 != 2) {
            this.f8630i = 2;
        }
        S(i10, this.f8630i, P(this.f8639r, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void e(TextView textView, int i10) {
        if (this.f8624c == null && this.f8626e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f8622a);
            this.f8624c = linearLayout;
            linearLayout.setOrientation(0);
            this.f8623b.addView(this.f8624c, -1, -2);
            this.f8626e = new FrameLayout(this.f8622a);
            this.f8624c.addView(this.f8626e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f8623b.getEditText() != null) {
                f();
            }
        }
        if (A(i10)) {
            this.f8626e.setVisibility(0);
            this.f8626e.addView(textView);
        } else {
            this.f8624c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f8624c.setVisibility(0);
        this.f8625d++;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f8623b.getEditText();
            boolean isFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(this.f8622a);
            ViewCompat.setPaddingRelative(this.f8624c, u(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), u(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_top, this.f8622a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), u(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Animator animator = this.f8627f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f8630i);
    }

    /* access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f8634m;
    }

    /* access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f8631j;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        TextView textView = this.f8633l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList q() {
        TextView textView = this.f8633l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence r() {
        return this.f8637p;
    }

    /* access modifiers changed from: package-private */
    public View s() {
        return this.f8639r;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        TextView textView = this.f8639r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return z(this.f8629h);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f8631j = null;
        h();
        if (this.f8629h == 1) {
            if (!this.f8638q || TextUtils.isEmpty(this.f8637p)) {
                this.f8630i = 0;
            } else {
                this.f8630i = 2;
            }
        }
        S(this.f8629h, this.f8630i, P(this.f8633l, ""));
    }

    /* access modifiers changed from: package-private */
    public void x() {
        h();
        int i10 = this.f8629h;
        if (i10 == 2) {
            this.f8630i = 0;
        }
        S(i10, this.f8630i, P(this.f8639r, ""));
    }
}
