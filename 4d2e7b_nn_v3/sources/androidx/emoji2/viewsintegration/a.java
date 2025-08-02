package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

final class a extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f15484a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f15485b;

    /* renamed from: c  reason: collision with root package name */
    private static Class f15486c;

    private a() {
        try {
            f15486c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, a.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f15485b == null) {
            synchronized (f15484a) {
                try {
                    if (f15485b == null) {
                        f15485b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15485b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class cls = f15486c;
        if (cls != null) {
            return SpannableBuilder.create(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
