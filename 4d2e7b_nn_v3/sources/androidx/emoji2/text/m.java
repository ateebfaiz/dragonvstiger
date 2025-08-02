package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

class m implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15472a = false;

    /* renamed from: b  reason: collision with root package name */
    private Spannable f15473b;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    static class c extends b {
        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            if (androidx.core.text.b.a(charSequence) || (charSequence instanceof PrecomputedTextCompat)) {
                return true;
            }
            return false;
        }
    }

    m(Spannable spannable) {
        this.f15473b = spannable;
    }

    private void a() {
        Spannable spannable = this.f15473b;
        if (!this.f15472a && c().a(spannable)) {
            this.f15473b = new SpannableString(spannable);
        }
        this.f15472a = true;
    }

    static b c() {
        if (Build.VERSION.SDK_INT < 28) {
            return new b();
        }
        return new c();
    }

    /* access modifiers changed from: package-private */
    public Spannable b() {
        return this.f15473b;
    }

    public char charAt(int i10) {
        return this.f15473b.charAt(i10);
    }

    public IntStream chars() {
        return a.a(this.f15473b);
    }

    public IntStream codePoints() {
        return a.b(this.f15473b);
    }

    public int getSpanEnd(Object obj) {
        return this.f15473b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f15473b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f15473b.getSpanStart(obj);
    }

    public Object[] getSpans(int i10, int i11, Class cls) {
        return this.f15473b.getSpans(i10, i11, cls);
    }

    public int length() {
        return this.f15473b.length();
    }

    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f15473b.nextSpanTransition(i10, i11, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.f15473b.removeSpan(obj);
    }

    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f15473b.setSpan(obj, i10, i11, i12);
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.f15473b.subSequence(i10, i11);
    }

    public String toString() {
        return this.f15473b.toString();
    }

    m(CharSequence charSequence) {
        this.f15473b = new SpannableString(charSequence);
    }
}
