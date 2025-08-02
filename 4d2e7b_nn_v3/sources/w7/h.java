package w7;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.m;

public final class h extends CharacterStyle implements e {

    /* renamed from: a  reason: collision with root package name */
    private final float f13205a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13206b;

    /* renamed from: c  reason: collision with root package name */
    private final float f13207c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13208d;

    public h(float f10, float f11, float f12, int i10) {
        this.f13205a = f10;
        this.f13206b = f11;
        this.f13207c = f12;
        this.f13208d = i10;
    }

    public void updateDrawState(TextPaint textPaint) {
        m.f(textPaint, "textPaint");
        textPaint.setShadowLayer(this.f13207c, this.f13205a, this.f13206b, this.f13208d);
    }
}
