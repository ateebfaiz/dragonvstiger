package t0;

import android.graphics.Path;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import n0.c;
import n0.g;
import s0.a;
import s0.d;
import u0.b;

public class p implements c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f24022a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f24023b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24024c;

    /* renamed from: d  reason: collision with root package name */
    private final a f24025d;

    /* renamed from: e  reason: collision with root package name */
    private final d f24026e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24027f;

    public p(String str, boolean z10, Path.FillType fillType, a aVar, d dVar, boolean z11) {
        this.f24024c = str;
        this.f24022a = z10;
        this.f24023b = fillType;
        this.f24025d = aVar;
        this.f24026e = dVar;
        this.f24027f = z11;
    }

    public c a(k0 k0Var, j jVar, b bVar) {
        return new g(k0Var, bVar, this);
    }

    public a b() {
        return this.f24025d;
    }

    public Path.FillType c() {
        return this.f24023b;
    }

    public String d() {
        return this.f24024c;
    }

    public d e() {
        return this.f24026e;
    }

    public boolean f() {
        return this.f24027f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f24022a + '}';
    }
}
