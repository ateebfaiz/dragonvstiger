package t0;

import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import n0.c;
import s0.b;
import s0.o;

public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f24007a;

    /* renamed from: b  reason: collision with root package name */
    private final o f24008b;

    /* renamed from: c  reason: collision with root package name */
    private final o f24009c;

    /* renamed from: d  reason: collision with root package name */
    private final b f24010d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f24011e;

    public l(String str, o oVar, o oVar2, b bVar, boolean z10) {
        this.f24007a = str;
        this.f24008b = oVar;
        this.f24009c = oVar2;
        this.f24010d = bVar;
        this.f24011e = z10;
    }

    public c a(k0 k0Var, j jVar, u0.b bVar) {
        return new n0.o(k0Var, bVar, this);
    }

    public b b() {
        return this.f24010d;
    }

    public String c() {
        return this.f24007a;
    }

    public o d() {
        return this.f24008b;
    }

    public o e() {
        return this.f24009c;
    }

    public boolean f() {
        return this.f24011e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f24008b + ", size=" + this.f24009c + '}';
    }
}
