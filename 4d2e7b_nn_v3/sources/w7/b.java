package w7;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.internal.m;

public final class b implements LineHeightSpan, e {

    /* renamed from: a  reason: collision with root package name */
    private final int f13192a;

    public b(float f10) {
        this.f13192a = (int) Math.ceil((double) f10);
    }

    public void chooseHeight(CharSequence charSequence, int i10, int i11, int i12, int i13, Paint.FontMetricsInt fontMetricsInt) {
        m.f(fontMetricsInt, "fm");
        int i14 = fontMetricsInt.descent;
        int i15 = this.f13192a;
        if (i14 > i15) {
            int min = (int) Math.min((double) i15, (double) i14);
            fontMetricsInt.descent = min;
            fontMetricsInt.bottom = min;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
            return;
        }
        int i16 = fontMetricsInt.ascent;
        if ((-i16) + i14 > i15) {
            fontMetricsInt.bottom = i14;
            int i17 = (-i15) + i14;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.top = i17;
            return;
        }
        int i18 = fontMetricsInt.bottom;
        if ((-i16) + i18 > i15) {
            fontMetricsInt.top = i16;
            fontMetricsInt.bottom = i16 + i15;
            return;
        }
        int i19 = fontMetricsInt.top;
        if ((-i19) + i18 > i15) {
            fontMetricsInt.top = i18 - i15;
            return;
        }
        double d10 = (double) (((float) (i15 - ((-i19) + i18))) / 2.0f);
        int ceil = (int) (((float) i19) - ((float) Math.ceil(d10)));
        int floor = (int) (((float) fontMetricsInt.bottom) + ((float) Math.floor(d10)));
        fontMetricsInt.top = ceil;
        fontMetricsInt.ascent = ceil;
        fontMetricsInt.descent = floor;
        fontMetricsInt.bottom = floor;
    }
}
