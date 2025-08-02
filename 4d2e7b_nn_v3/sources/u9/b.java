package u9;

import java.util.Collections;
import java.util.Set;
import w9.a;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Set f13159a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13160b = new a();

    public b(Set set) {
        if (set != null) {
            this.f13159a = Collections.unmodifiableSet(set);
            return;
        }
        throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
    }

    public a b() {
        return this.f13160b;
    }
}
