package w7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.m;

public final class j extends ReplacementSpan implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f13210a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13211b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13212c;

    public j(int i10, int i11, int i12) {
        this.f13210a = i10;
        this.f13211b = i11;
        this.f13212c = i12;
    }

    public final int a() {
        return this.f13212c;
    }

    public final int b() {
        return this.f13210a;
    }

    public final int c() {
        return this.f13211b;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        m.f(canvas, "canvas");
        m.f(paint, "paint");
    }

    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        m.f(paint, "paint");
        if (fontMetricsInt != null) {
            int i12 = -this.f13212c;
            fontMetricsInt.ascent = i12;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i12;
            fontMetricsInt.bottom = 0;
        }
        return this.f13211b;
    }
}
