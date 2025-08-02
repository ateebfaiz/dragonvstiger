package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

class e implements EmojiCompat.GlyphChecker {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f15425b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f15426a;

    e() {
        TextPaint textPaint = new TextPaint();
        this.f15426a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder a() {
        ThreadLocal threadLocal = f15425b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    public boolean hasGlyph(CharSequence charSequence, int i10, int i11, int i12) {
        StringBuilder a10 = a();
        a10.setLength(0);
        while (i10 < i11) {
            a10.append(charSequence.charAt(i10));
            i10++;
        }
        return PaintCompat.hasGlyph(this.f15426a, a10.toString());
    }
}
