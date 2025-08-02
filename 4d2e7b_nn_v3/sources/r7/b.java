package r7;

import android.graphics.RectF;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f12943a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f12944b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12945c;

    public b(int i10, RectF rectF, int i11) {
        m.f(rectF, "rectangle");
        this.f12943a = i10;
        this.f12944b = rectF;
        this.f12945c = i11;
    }

    public final int a() {
        return this.f12945c;
    }

    public final int b() {
        return this.f12943a;
    }

    public final RectF c() {
        return this.f12944b;
    }
}
