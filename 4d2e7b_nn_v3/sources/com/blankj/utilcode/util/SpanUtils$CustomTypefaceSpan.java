package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

@SuppressLint({"ParcelCreator"})
class SpanUtils$CustomTypefaceSpan extends TypefaceSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f18393a;

    private void a(Paint paint, Typeface typeface) {
        int i10;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i10 = 0;
        } else {
            i10 = typeface2.getStyle();
        }
        int i11 = i10 & (~typeface.getStyle());
        if ((i11 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i11 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.getShader();
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.f18393a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.f18393a);
    }
}
