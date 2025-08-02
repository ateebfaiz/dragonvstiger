package q5;

import android.graphics.Bitmap;
import kotlin.jvm.internal.m;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final w f23543a;

    /* renamed from: b  reason: collision with root package name */
    private final Exception f23544b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23545c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f23546d;

    public x(w wVar, Exception exc, boolean z10, Bitmap bitmap) {
        m.f(wVar, "request");
        this.f23543a = wVar;
        this.f23544b = exc;
        this.f23545c = z10;
        this.f23546d = bitmap;
    }

    public final Bitmap a() {
        return this.f23546d;
    }

    public final Exception b() {
        return this.f23544b;
    }

    public final w c() {
        return this.f23543a;
    }

    public final boolean d() {
        return this.f23545c;
    }
}
