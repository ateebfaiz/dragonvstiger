package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;

final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f15042a = new a();

    private a() {
    }

    @DoNotInline
    public static final void a(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    @DoNotInline
    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
