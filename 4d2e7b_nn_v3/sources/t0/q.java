package t0;

import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import java.util.Arrays;
import java.util.List;
import n0.c;
import n0.d;
import u0.b;

public class q implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f24028a;

    /* renamed from: b  reason: collision with root package name */
    private final List f24029b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24030c;

    public q(String str, List list, boolean z10) {
        this.f24028a = str;
        this.f24029b = list;
        this.f24030c = z10;
    }

    public c a(k0 k0Var, j jVar, b bVar) {
        return new d(k0Var, bVar, this, jVar);
    }

    public List b() {
        return this.f24029b;
    }

    public String c() {
        return this.f24028a;
    }

    public boolean d() {
        return this.f24030c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f24028a + "' Shapes: " + Arrays.toString(this.f24029b.toArray()) + '}';
    }
}
