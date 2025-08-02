package m5;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f22613a;

    public b(int i10) {
        this.f22613a = i10;
    }

    public final int a() {
        return this.f22613a;
    }

    public String toString() {
        b0 b0Var = b0.f709a;
        String format = String.format((Locale) null, "Status: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f22613a)}, 1));
        m.e(format, "format(locale, format, *args)");
        return format;
    }
}
