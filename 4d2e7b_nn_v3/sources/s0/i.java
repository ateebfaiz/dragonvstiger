package s0;

import java.util.List;
import o0.a;
import o0.n;

public class i implements o {

    /* renamed from: a  reason: collision with root package name */
    private final b f23730a;

    /* renamed from: b  reason: collision with root package name */
    private final b f23731b;

    public i(b bVar, b bVar2) {
        this.f23730a = bVar;
        this.f23731b = bVar2;
    }

    public a a() {
        return new n(this.f23730a.a(), this.f23731b.a());
    }

    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean c() {
        if (!this.f23730a.c() || !this.f23731b.c()) {
            return false;
        }
        return true;
    }
}
