package ec;

import cc.l;
import kotlinx.coroutines.y;

public final class c extends f {

    /* renamed from: g  reason: collision with root package name */
    public static final c f197g = new c();

    private c() {
        super(l.f208c, l.f209d, l.f210e, l.f206a);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public y limitedParallelism(int i10) {
        l.a(i10);
        if (i10 >= l.f208c) {
            return this;
        }
        return super.limitedParallelism(i10);
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
