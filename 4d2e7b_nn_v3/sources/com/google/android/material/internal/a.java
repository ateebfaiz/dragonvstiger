package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

final class a {

    /* renamed from: n  reason: collision with root package name */
    static final int f8343n = 1;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f8344a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f8345b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8346c;

    /* renamed from: d  reason: collision with root package name */
    private int f8347d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f8348e;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f8349f;

    /* renamed from: g  reason: collision with root package name */
    private int f8350g;

    /* renamed from: h  reason: collision with root package name */
    private float f8351h;

    /* renamed from: i  reason: collision with root package name */
    private float f8352i;

    /* renamed from: j  reason: collision with root package name */
    private int f8353j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8354k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8355l;

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f8356m;

    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    static class C0094a extends Exception {
    }

    private a(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f8344a = charSequence;
        this.f8345b = textPaint;
        this.f8346c = i10;
        this.f8348e = charSequence.length();
        this.f8349f = Layout.Alignment.ALIGN_NORMAL;
        this.f8350g = Integer.MAX_VALUE;
        this.f8351h = 0.0f;
        this.f8352i = 1.0f;
        this.f8353j = f8343n;
        this.f8354k = true;
        this.f8356m = null;
    }

    public static a b(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new a(charSequence, textPaint, i10);
    }

    public StaticLayout a() {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f8344a == null) {
            this.f8344a = "";
        }
        int max = Math.max(0, this.f8346c);
        CharSequence charSequence = this.f8344a;
        if (this.f8350g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f8345b, (float) max, this.f8356m);
        }
        int min = Math.min(charSequence.length(), this.f8348e);
        this.f8348e = min;
        if (this.f8355l && this.f8350g == 1) {
            this.f8349f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f8347d, min, this.f8345b, max);
        obtain.setAlignment(this.f8349f);
        obtain.setIncludePad(this.f8354k);
        if (this.f8355l) {
            textDirectionHeuristic = TextDirectionHeuristics.RTL;
        } else {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        }
        obtain.setTextDirection(textDirectionHeuristic);
        TextUtils.TruncateAt truncateAt = this.f8356m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f8350g);
        float f10 = this.f8351h;
        if (!(f10 == 0.0f && this.f8352i == 1.0f)) {
            obtain.setLineSpacing(f10, this.f8352i);
        }
        if (this.f8350g > 1) {
            obtain.setHyphenationFrequency(this.f8353j);
        }
        return obtain.build();
    }

    public a c(Layout.Alignment alignment) {
        this.f8349f = alignment;
        return this;
    }

    public a d(TextUtils.TruncateAt truncateAt) {
        this.f8356m = truncateAt;
        return this;
    }

    public a e(int i10) {
        this.f8353j = i10;
        return this;
    }

    public a f(boolean z10) {
        this.f8354k = z10;
        return this;
    }

    public a g(boolean z10) {
        this.f8355l = z10;
        return this;
    }

    public a h(float f10, float f11) {
        this.f8351h = f10;
        this.f8352i = f11;
        return this;
    }

    public a i(int i10) {
        this.f8350g = i10;
        return this;
    }
}
