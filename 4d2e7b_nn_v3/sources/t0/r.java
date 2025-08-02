package t0;

import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import n0.c;
import s0.h;
import u0.b;

public class r implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f24031a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24032b;

    /* renamed from: c  reason: collision with root package name */
    private final h f24033c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24034d;

    public r(String str, int i10, h hVar, boolean z10) {
        this.f24031a = str;
        this.f24032b = i10;
        this.f24033c = hVar;
        this.f24034d = z10;
    }

    public c a(k0 k0Var, j jVar, b bVar) {
        return new n0.r(k0Var, bVar, this);
    }

    public String b() {
        return this.f24031a;
    }

    public h c() {
        return this.f24033c;
    }

    public boolean d() {
        return this.f24034d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f24031a + ", index=" + this.f24032b + '}';
    }
}
