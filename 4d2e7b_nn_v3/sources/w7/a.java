package w7;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.m;

public final class a extends MetricAffectingSpan implements e {

    /* renamed from: a  reason: collision with root package name */
    private final float f13191a;

    public a(float f10) {
        this.f13191a = f10;
    }

    private final void a(TextPaint textPaint) {
        if (!Float.isNaN(this.f13191a)) {
            textPaint.setLetterSpacing(this.f13191a);
        }
    }

    public final float b() {
        return this.f13191a;
    }

    public void updateDrawState(TextPaint textPaint) {
        m.f(textPaint, "paint");
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m.f(textPaint, "paint");
        a(textPaint);
    }
}
